package com.formas1.ruispantry.world.feature;

import java.util.Random;

import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class MilkshakeTree extends Tree {

	public static final TreeFeatureConfig MILKSHAKE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider
			(DeferredBlockInit.MILKSHAKE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(DeferredBlockInit.MILKSHAKE_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0))).ignoreVines()
			.setSapling((IPlantable)DeferredBlockInit.MILKSHAKE_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.FANCY_TREE.withConfiguration(MILKSHAKE_TREE_CONFIG);
	}
}