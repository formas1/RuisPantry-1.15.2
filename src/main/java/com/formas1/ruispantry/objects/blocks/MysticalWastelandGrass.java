package com.formas1.ruispantry.objects.blocks;

import java.util.List;
import java.util.Random;

import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

public class MysticalWastelandGrass extends GrassBlock{

	public MysticalWastelandGrass(Properties properties) {
		super(properties);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state)
	{
		 BlockPos blockpos = pos.up();
	      BlockState blockstate = BlockInit.mystical_wasteland_grass.getDefaultState();

	      for(int i = 0; i < 128; ++i) {
	         BlockPos blockpos1 = blockpos;
	         int j = 0;

	         while(true) {
	            if (j >= i / 16) {
	               BlockState blockstate2 = worldIn.getBlockState(blockpos1);
	               if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(8) == 0) {
	                  ((IGrowable)blockstate.getBlock()).grow(worldIn, rand, blockpos1, blockstate2);
	               }

	               if (!blockstate2.isAir()) {
	                  break;
	               }

	               BlockState blockstate1;
	               if (rand.nextInt(8) == 0) {
	                  List<ConfiguredFeature<?, ?>> list = worldIn.getBiome(blockpos1).getFlowers();
	                  if (list.isEmpty()) {
	                     break;
	                  }

	                  ConfiguredFeature<?, ?> configuredfeature = ((DecoratedFeatureConfig)(list.get(0)).config).feature;
	                  blockstate1 = ((FlowersFeature)configuredfeature.feature).getFlowerToPlace(rand, blockpos1, configuredfeature.config);
	               } else {
	                  blockstate1 = blockstate;
	               }

	               if (blockstate1.isValidPosition(worldIn, blockpos1)) {
	                  worldIn.setBlockState(blockpos1, blockstate1, 3);
	               }
	               break;
	            }

	            blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
	            if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).isCollisionShapeOpaque(worldIn, blockpos1)) {
	               break;
	            }

	            ++j;
	         }
	      }

	}
	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable)
	{
		BlockState plant = plantable.getPlant(world, pos.offset(facing));
		if (plant.getBlock() == DeferredBlockInit.WASTELAND_PLUM_TREE_SAPLING.get() && this == BlockInit.mystical_wasteland_grass)
	           return true;
		return false;
	}
}