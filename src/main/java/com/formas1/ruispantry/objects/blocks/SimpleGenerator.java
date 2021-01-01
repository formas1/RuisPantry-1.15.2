package com.formas1.ruispantry.objects.blocks;

import java.util.Random;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class SimpleGenerator extends Block
{
	public SimpleGenerator(Properties properties)
	{
		super(properties);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if(player.getHeldItem(handIn).getItem() == ItemInit.spinel)
		{
			for(int x = pos.getX() -8; x < pos.getX() + 16; x++) {
			    for(int y = 0; y < 256; y++) {
			        for(int z = pos.getZ() -8; z < pos.getZ() + 16; z++) {
			        	BlockPos newPos = new BlockPos(x, y, z);
			        	if(world.getBlockState(newPos).getBlock() instanceof GenericCorruptedBlock)
			        	{
			        		GenericCorruptedBlock block = (GenericCorruptedBlock) world.getBlockState(newPos).getBlock();
			        		Block curedBlock = block.blockType;
			        		try {
			        		world.setBlockState(newPos, curedBlock.getDefaultState());
			        		} catch(NullPointerException e) {
			        			if(world.getBlockState(newPos).getBlock() == BlockInit.corrupted_formas_ore) {
			        				world.setBlockState(newPos, BlockInit.formas_ore.getDefaultState());
			        			} else if(world.getBlockState(newPos).getBlock() == BlockInit.corrupted_gam_ore) {
			        				world.setBlockState(newPos, BlockInit.gam_ore.getDefaultState());
			        			} else if(world.getBlockState(newPos).getBlock() == BlockInit.corrupted_milkshake_ore) {
			        				world.setBlockState(newPos, BlockInit.milkshake_ore.getDefaultState());
			        			} else {
			        				world.destroyBlock(newPos, true);
			        			}
			        		}
			        		if(world.rand.nextFloat() <= 0.25F) {
			        			block.spawnDrops(block.getDefaultState(), world, pos.add(0, 1, 0));
			        		}
			        	}
			        }
			    }
			}
			return ActionResultType.CONSUME;
		}
		return ActionResultType.FAIL;
	}
}
