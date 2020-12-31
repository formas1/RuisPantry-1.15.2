package com.formas1.ruispantry.enchantments;

import com.formas1.ruispantry.RuisPantry;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class HegemoneBlessEnchantment extends Enchantment
{
	public HegemoneBlessEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots)
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
	public static class HegemoneBlessEquipped
	{
		@SuppressWarnings("resource")
		@SubscribeEvent
		public static void doStuff(RightClickBlock event)
		{
			PlayerEntity player = event.getPlayer();
			if(hasEnchantment(player.getHeldItemMainhand()))
			{
				World world = player.world;
				BlockPos blockpos = new BlockPos(Minecraft.getInstance().objectMouseOver.getHitVec());
				BlockState blockstate = world.getBlockState(blockpos);
				if (blockstate.getBlock() instanceof IGrowable)
				{
			       	IGrowable igrowable = (IGrowable)blockstate.getBlock();
			         if (igrowable.canGrow(world, blockpos, blockstate, world.isRemote))
			         {
			        	 if (world instanceof ServerWorld)
			        	 {
			        		if (igrowable.canUseBonemeal(world, world.rand, blockpos, blockstate))
			               	{
			            	   		igrowable.grow((ServerWorld)world, world.rand, blockpos, blockstate);
			            	   		player.getHeldItemMainhand().damageItem(1, player, (p_220043_1_) -> {
			                            p_220043_1_.sendBreakAnimation(player.getActiveHand());
			                        });
			               	}
			        	 }
			        	 BoneMealItem.spawnBonemealParticles(world, blockpos, 0);
			         }
				}
			}
		}
		
		public static boolean hasEnchantment(ItemStack stack){
			if (stack.hasTag()){
	            ListNBT nbttaglist = stack.getEnchantmentTagList();

	            for (int j = 0; j < nbttaglist.size(); ++j) {
	                 CompoundNBT nbttagcompound = nbttaglist.getCompound(j);
	                 String id = nbttagcompound.getString("id");
	                 if (id.equals("rpantry:hegemone_bless")){
	                      return true;
	                 }
	            }
		}
			return false;
	}
}
}
