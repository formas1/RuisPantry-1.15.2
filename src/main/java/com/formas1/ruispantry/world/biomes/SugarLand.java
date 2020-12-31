package com.formas1.ruispantry.world.biomes;

import com.formas1.ruispantry.init.DeferredBlockInit;
import com.formas1.ruispantry.init.ModEntityTypes;
import com.formas1.ruispantry.world.feature.CorruptedTree;
import com.formas1.ruispantry.world.feature.FormasTree;
import com.formas1.ruispantry.world.feature.WastelandPlumTree;

import net.minecraft.block.Blocks;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

public class SugarLand extends Biome
{
	public static final BlockClusterFeatureConfig GLOWSTONE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GLOWSTONE.getDefaultState()), new SimpleBlockPlacer())).tries(64).func_227317_b_().build();
	public SugarLand(Builder biomeBuilder) {
		super(biomeBuilder);
		
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GLOWSTONE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(4))));
		DefaultBiomeFeatures.addCarvers(this);
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
