package com.formas1.ruispantry.objects.blocks;

import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.IPlantable;

public class CorruptedGrass extends GenericCorruptedBlock{

	public Block blockType;
	public CorruptedGrass(Properties properties, Block blockType)
	{
		super(properties, blockType);
		this.blockType = blockType;
	}

	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable)
	{
		BlockState plant = plantable.getPlant(world, pos.offset(facing));
		if (plant.getBlock() == DeferredBlockInit.CORRUPTED_SAPLING.get() && this == BlockInit.corrupted_grass)
	           return true;
		return false;
	}
}