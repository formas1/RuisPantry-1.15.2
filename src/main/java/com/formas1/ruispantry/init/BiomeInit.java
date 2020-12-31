package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.world.biomes.CorruptedBiome;
import com.formas1.ruispantry.world.biomes.SugarLand;
import com.formas1.ruispantry.world.biomes.WastelandHills;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit
{
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			RuisPantry.MOD_ID);
	
	public static final RegistryObject<Biome> CORRUPTED_BIOME = BIOMES.register("corruption_biome", () -> new CorruptedBiome(new Biome.Builder().temperature(1.3F).waterColor(10092544).waterFogColor(10092544).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockInit.corrupted_grass.getDefaultState(), BlockInit.corrupted_dirt.getDefaultState(), Blocks.GRAVEL.getDefaultState())).category(Category.EXTREME_HILLS).downfall(0.5F).depth(0.12f).scale(0.3F).precipitation(RainType.RAIN).parent(null)));
	
	public static final RegistryObject<Biome> WASTELAND_HILLS_BIOME = BIOMES.register("wasteland_hills_biome", () -> new WastelandHills(new Biome.Builder().temperature(0.8F).waterColor(8248042).waterFogColor(8248042).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockInit.mystical_wasteland_grass.getDefaultState(), Blocks.DIRT.getDefaultState(), BlockInit.mystical_wastestone.getDefaultState())).category(Category.EXTREME_HILLS).downfall(1.0F).depth(0.10f).scale(0.5F).precipitation(RainType.RAIN).parent(null)));
	
	public static final RegistryObject<Biome> SUGAR_LAND_BIOME = BIOMES.register("sugar_land_biome", () -> new SugarLand(new Biome.Builder().temperature(0.0F).waterColor(16739238).waterFogColor(16739238).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(DeferredBlockInit.CARAMEL_BLOCK.get().getDefaultState(), DeferredBlockInit.COOKIE_BLOCK.get().getDefaultState(), Blocks.HONEY_BLOCK.getDefaultState())).category(Category.PLAINS).downfall(1.5F).depth(0.10f).scale(0.2F).precipitation(RainType.SNOW).parent(null)));
	
	
	public static void registerBiomes()
	{
		registerBiome(CORRUPTED_BIOME.get(), 2, Type.MOUNTAIN, Type.DRY, Type.MAGICAL, Type.OVERWORLD);
		registerBiome(WASTELAND_HILLS_BIOME.get(), 2, Type.MOUNTAIN, Type.MAGICAL, Type.OVERWORLD, Type.WASTELAND);
	}
		
	private static void registerBiome(Biome biome, int weight, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, weight));
	}
}
