package com.formas1.ruispantry.world.biomes;

import com.formas1.ruispantry.world.feature.CorruptedTree;
import com.formas1.ruispantry.world.feature.FormasTree;
import com.formas1.ruispantry.world.feature.WastelandPlumTree;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class CorruptedBiome extends Biome{

	public CorruptedBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_PIGMAN, 5, 2, 4));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITHER_SKELETON, 4, 1, 2));
		this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.EVOKER, 1, 1, 1));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.MEGA_JUNGLE_TREE
				.withConfiguration(CorruptedTree.CORRUPTED_TREE_CONFIG)
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
				.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		
		//this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.63784827f)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
				Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
				.withPlacement(Placement.CHANCE_PASSTHROUGH
				.configure(new ChanceConfig(47))));
		
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraGoldOre(this);
	}
	
	@Override
	public int getSkyColor()
	{
		return 16711680;
	}
	
	@Override
	public int getFoliageColor()
	{
		return 6884864;
	}
	
	@Override
	public int getGrassColor(double posX, double posZ)
	{
		return 6884864;
	}
}
