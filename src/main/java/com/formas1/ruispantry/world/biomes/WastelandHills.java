package com.formas1.ruispantry.world.biomes;

import com.formas1.ruispantry.init.ModEntityTypes;
import com.formas1.ruispantry.world.feature.CorruptedTree;
import com.formas1.ruispantry.world.feature.FormasTree;
import com.formas1.ruispantry.world.feature.WastelandPlumTree;

import net.minecraft.client.audio.MusicTicker;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;

public class WastelandHills extends Biome
{
	public WastelandHills(Builder biomeBuilder) {
		super(biomeBuilder);
		
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.MEGA_JUNGLE_TREE
				.withConfiguration(WastelandPlumTree.WASTELAND_PLUM_TREE_CONFIG)
				.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
				.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
		
		DefaultBiomeFeatures.addCarvers(this);
		DefaultBiomeFeatures.addMonsterRooms(this);
		DefaultBiomeFeatures.addOres(this);
		DefaultBiomeFeatures.addExtraEmeraldOre(this);
	}
		
	@Override
	public int getSkyColor()
	{
		return 8248042;
	}
	
	@Override
	public int getFoliageColor()
	{
		return 8248042;
	}
	
	@Override
	public int getGrassColor(double posX, double posZ)
	{
		return 8248042;
	}
}
