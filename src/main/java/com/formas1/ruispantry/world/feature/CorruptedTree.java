package com.formas1.ruispantry.world.feature;

import java.util.Random;

import com.formas1.ruispantry.init.DeferredBlockInit;
import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.trees.BigTree;
import net.minecraft.block.trees.JungleTree;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class CorruptedTree extends BigTree {

	public static final HugeTreeFeatureConfig CORRUPTED_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(DeferredBlockInit.CORRUPTED_LOG.get().getDefaultState()), new SimpleBlockStateProvider(DeferredBlockInit.CORRUPTED_LEAVES.get().getDefaultState()))).baseHeight(4).heightInterval(8).setSapling((IPlantable)DeferredBlockInit.CORRUPTED_SAPLING.get()).build();
	public static final TreeFeatureConfig CORRUPTED_SAPLING_TREE = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(DeferredBlockInit.CORRUPTED_LOG.get().getDefaultState()), new SimpleBlockStateProvider(DeferredBlockInit.CORRUPTED_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(4).foliageHeight(3).trunkTopOffset(3).ignoreVines().setSapling((IPlantable)DeferredBlockInit.CORRUPTED_SAPLING.get()).build();
	@Override
	protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random randomIn)
	{
		return Feature.MEGA_JUNGLE_TREE.withConfiguration(CORRUPTED_TREE_CONFIG);
	}

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b)
	{
		return (new TreeFeature(TreeFeatureConfig::deserializeJungle)).withConfiguration(CORRUPTED_SAPLING_TREE);
	}
}