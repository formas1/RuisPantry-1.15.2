package com.formas1.ruispantry.world.feature;

import java.util.Random;

import com.formas1.ruispantry.init.DeferredBlockInit;

import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class FormasTree extends Tree {

	public static final TreeFeatureConfig FORMAS_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider
			(DeferredBlockInit.FORMAS_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(DeferredBlockInit.FORMAS_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0))).ignoreVines()
			.setSapling((IPlantable) DeferredBlockInit.FORMAS_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.FANCY_TREE.withConfiguration(FORMAS_TREE_CONFIG);
	}
}