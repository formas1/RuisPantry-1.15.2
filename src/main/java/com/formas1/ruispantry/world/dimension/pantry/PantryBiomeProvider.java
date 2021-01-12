package com.formas1.ruispantry.world.dimension.pantry;

import java.util.Random;
import java.util.Set;

import com.formas1.ruispantry.init.BiomeInit;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class PantryBiomeProvider extends BiomeProvider
{
	private Random rand;
	public PantryBiomeProvider()
	{
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.SUGAR_LAND_BIOME.get());

	@Override
	public Biome getNoiseBiome(int x, int y, int z)
	{
		return BiomeInit.SUGAR_LAND_BIOME.get();
	}
}
