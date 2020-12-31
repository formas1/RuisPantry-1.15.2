package com.formas1.ruispantry.armor;

import java.util.List;

import org.lwjgl.glfw.GLFW;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.capabilities.BatWingBootsFlyCapability;
import com.formas1.ruispantry.init.KeyBindInit;
import com.formas1.ruispantry.packets.BatWingShoesFlyPacket;
import com.formas1.ruispantry.packets.Networking;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class BatWingShoes extends ArmorItem
{
	private float canLevitate = 10.0F;
	private BatWingShoesModel armorModel;
	
	public BatWingShoes(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder)
	{
		super(materialIn, slot, builder);
		if(FMLEnvironment.dist == Dist.CLIENT)
		{
		this.armorModel = (BatWingShoesModel) new BatWingShoesModel();
		}
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        if(!world.isRemote)
        {           
            BatWingBootsFlyCapability cap = player.getCapability(BatWingBootsFlyCapability.LEVITATE_CAPABILITY).orElseGet(null);
            if(cap.isPressed1 && cap.canLevitate > 0.0F)
            {
                player.addPotionEffect(new EffectInstance(Effects.LEVITATION, 2, 1));
                cap.canLevitate = cap.canLevitate - 0.1f;
                cap.isPressed1 = false;
            }
            if(!cap.isPressed2 && !player.onGround)
            {
                player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 2, 1));
                cap.isPressed2 = true;
            }
            if(player.onGround)
            {
                cap.canLevitate = 10.0F;
            }
            RuisPantry.LOGGER.info(cap.canLevitate);
        } else {
            if(KeyBindInit.SPECIAL_ARMOR_1.isKeyDown() && canLevitate > 0.0F)
            {
            	armorModel.isFlying = true;
            	canLevitate = canLevitate - 0.1F;
                Networking.sendToServer(new BatWingShoesFlyPacket(1));
            }
            if(!KeyBindInit.SPECIAL_ARMOR_2.isKeyDown() && !player.onGround)
            {
                armorModel.isFlying = true;
                Networking.sendToServer(new BatWingShoesFlyPacket(2));
            }
            if(player.onGround)
            {
                armorModel.isFlying = false;
                canLevitate = 10.0F;
            }
            armorModel.time++;
        }
        RuisPantry.LOGGER.info(canLevitate);
    }
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
	    if(InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
	        tooltip.add(new StringTextComponent("\u00A73Hold \u00A75" + KeyBindInit.SPECIAL_ARMOR_1.getLocalizedName().toUpperCase() + "\u00A73 to activate limited-time Levitation"));
	        tooltip.add(new StringTextComponent("\u00A73Hold \u00A75" + KeyBindInit.SPECIAL_ARMOR_2.getLocalizedName().toUpperCase() + "\u00A73 to disable Slowfalling"));
	    }
	    else
	    {
	        tooltip.add(new StringTextComponent("\u00A73Hold " + "\u00A75" + "Shift" + "\u00A73" + " for Item Info")); //"\u00A7e" is a color code
	    }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public final BipedModel getArmorModel(LivingEntity entity, ItemStack itemStack, EquipmentSlotType armorSlot, BipedModel defaultArmor)
	{
		//if(armorModel == null) armorModel = (BatWingShoesModel) new BatWingShoesModel();
		return armorModel.applyEntityStats(defaultArmor).applySlot(armorSlot);
	}
	
	public final String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
	{
		//if(armorModel == null) armorModel = (BatWingShoesModel) new BatWingShoesModel();
        return armorModel.getTexture();
    }
}
