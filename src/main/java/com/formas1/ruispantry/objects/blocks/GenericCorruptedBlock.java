package com.formas1.ruispantry.objects.blocks;

import java.util.Random;

import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public class GenericCorruptedBlock extends Block implements ICorruptBlocks
{
	public GenericCorruptedBlock(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public boolean ticksRandomly(BlockState state)
	{
		return true;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
	{
		ICorruptBlocks.corruptNeighbours(state, worldIn, pos, rand);
	}
}