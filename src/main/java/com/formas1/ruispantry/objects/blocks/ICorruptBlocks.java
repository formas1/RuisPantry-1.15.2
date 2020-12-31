package com.formas1.ruispantry.objects.blocks;

import java.util.Random;

import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public interface ICorruptBlocks
{
	public static void corruptNeighbours(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
	{
		if(worldIn.rand.nextInt(100) > 60)
		{
			for(Direction face : Direction.values())
			{
				BlockState neighbourState = worldIn.getBlockState(pos.offset(face));
				BlockPos neighbourPos = pos.offset(face);
				if(neighbourState == Blocks.COBBLESTONE.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_cobblestone.getDefaultState());
				}
				else if(neighbourState == Blocks.STONE.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_stone.getDefaultState());
				}
				else if(neighbourState == Blocks.DIRT.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_dirt.getDefaultState());
				}
				else if(neighbourState == Blocks.GRASS_BLOCK.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_grass.getDefaultState());
				}
				/*else if(neighbourState.getBlock() instanceof LogBlock)
				{
					worldIn.setBlockState(neighbourPos, DeferredBlockInit.CORRUPTED_LOG.get().getDefaultState());
				}
				else if(neighbourState.getBlock() instanceof LeavesBlock)
				{
					worldIn.setBlockState(neighbourPos, DeferredBlockInit.CORRUPTED_LEAVES.get().getDefaultState());
				}
				else if(neighbourState.getBlock() instanceof SaplingBlock)
				{
					worldIn.setBlockState(neighbourPos, DeferredBlockInit.CORRUPTED_SAPLING.get().getDefaultState());
				}*/
				else if(neighbourState == BlockInit.formas_ore.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_formas_ore.getDefaultState());
				}
				else if(neighbourState == BlockInit.gam_ore.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_gam_ore.getDefaultState());
				}
				else if(neighbourState == BlockInit.milkshake_ore.getDefaultState())
				{
					worldIn.setBlockState(neighbourPos, BlockInit.corrupted_milkshake_ore.getDefaultState());
				}
			}
		}
	}
}
