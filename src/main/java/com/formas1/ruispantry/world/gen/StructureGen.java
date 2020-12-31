package com.formas1.ruispantry.world.gen;

import com.formas1.ruispantry.init.BiomeInit;
import com.formas1.ruispantry.init.FeatureInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class StructureGen
{
	public static void generateStructures()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			if(biome == Biomes.GIANT_TREE_TAIGA || biome == Biomes.DESERT || biome == Biomes.BIRCH_FOREST)
			{
				biome.addStructure(FeatureInit.GRAVEYARD.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			} else if(biome == BiomeInit.SUGAR_LAND_BIOME.get())
			{
				biome.addStructure(FeatureInit.CANDY_CANE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.GRAVEYARD.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.CANDY_CANE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}
}
