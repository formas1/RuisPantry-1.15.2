package com.formas1.ruispantry.world.gen;

import java.util.function.Predicate;

import com.formas1.ruispantry.init.BiomeInit;
import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.DeferredBlockInit;
import com.formas1.ruispantry.objects.blocks.StrawberryPlant;
import com.formas1.ruispantry.world.feature.FormasTree;
import com.formas1.ruispantry.world.feature.GamTree;
import com.formas1.ruispantry.world.feature.MilkshakeTree;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModGen
{
	public static void generate()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			//Overworld Configs
			ConfiguredPlacement generalOreConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 69));
			ConfiguredPlacement replaceStoneConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(200, 0, 0, 200));
			
			//FillerBlockTypes
			OreFeatureConfig.FillerBlockType.create("MYSTICAL_STONE", "mystical_stone", new BlockMatcher(BlockInit.mystical_wastestone));
			OreFeatureConfig.FillerBlockType.create("CANDY", "candy", new BlockMatcher(DeferredBlockInit.CANDY_STONE.get()));
			
			//Nether Ores
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, BlockInit.spinel_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
			
			//End Ores
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.create("ENDSTONE", "end_stone", new BlockMatcher(Blocks.END_STONE)), BlockInit.ender_asurite_ore.getDefaultState(), 8)).withPlacement(generalOreConfig));
			
			//Biome Ores
			if(biome == Biomes.PLAINS)
			{
			BlockClusterFeatureConfig strawberryConfig = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.strawberry_plant.getDefaultState().with(StrawberryPlant.AGE, 3)), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).func_227317_b_().build();
			
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(strawberryConfig).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			//biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(FormasTree.FORMAS_TREE_CONFIG).func_227227_a_(0.5F), Feature.FANCY_TREE.withConfiguration(GamTree.GAM_TREE_CONFIG).func_227227_a_(0.5F), Feature.FANCY_TREE.withConfiguration(MilkshakeTree.MILKSHAKE_TREE_CONFIG).func_227227_a_(0.5F)), Feature.FANCY_TREE.withConfiguration(FormasTree.FORMAS_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FANCY_TREE.withConfiguration(FormasTree.FORMAS_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FANCY_TREE.withConfiguration(GamTree.GAM_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FANCY_TREE.withConfiguration(MilkshakeTree.MILKSHAKE_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
			}
			if(biome == BiomeInit.WASTELAND_HILLS_BIOME.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.mystical_wastestone.getDefaultState(), 100)).withPlacement(replaceStoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.byName("mystical_stone"), BlockInit.wasteland_formas_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.byName("mystical_stone"), BlockInit.wasteland_gam_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.byName("mystical_stone"), BlockInit.wasteland_milkshake_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
			} else if(biome == BiomeInit.SUGAR_LAND_BIOME.get()) {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DeferredBlockInit.CANDY_STONE.get().getDefaultState(), 100)).withPlacement(replaceStoneConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.byName("candy"), DeferredBlockInit.ROCK_CANDY_BLOCK.get().getDefaultState(), 18)).withPlacement(generalOreConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.byName("candy"), DeferredBlockInit.CHOCOLATE_STONE.get().getDefaultState(), 22)).withPlacement(generalOreConfig));
			} else {
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.formas_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.gam_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.milkshake_ore.getDefaultState(), 10)).withPlacement(generalOreConfig));
			}
		}
	}
}
