package com.formas1.ruispantry.enchantments;

import com.formas1.ruispantry.RuisPantry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class SmeltingEnchantment extends Enchantment
{
	public SmeltingEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots)
	{
		super(rarityIn, typeIn, slots);
	}
	
	@Override
	public int getMaxLevel() {
		return 1;
	}
	
	@Override
	public int getMinLevel() {
		return 1;
	}
	
	@Mod.EventBusSubscriber(modid = RuisPantry.MOD_ID, bus = Bus.FORGE)
	public static class SmeltingEquipped
	{
		@SubscribeEvent
		public static void doStuff(PlayerTickEvent event)
		{
			PlayerEntity player = event.player;
			if(hasEnchantment(player.getHeldItemMainhand()))
			{
				if(player.world.getRandom().nextInt(5) == 0)
				{
					player.world.addParticle(ParticleTypes.FLAME, player.getPosX(), player.getPosY(), player.getPosZ(), 0, 0, 0);
				}
			}
		}
		
		public static boolean hasEnchantment(ItemStack stack)
		{
			if (stack.hasTag())
			{
	            ListNBT nbttaglist = stack.getEnchantmentTagList();
	            for (int j = 0; j < nbttaglist.size(); ++j) {
	                 CompoundNBT nbttagcompound = nbttaglist.getCompound(j);
	                 String id = nbttagcompound.getString("id");
	                 if (id.equals("rpantry:smelting"))
	                 {
	                      return true;
	                 }
	            }
			}
			return false;
		}
	}
}
