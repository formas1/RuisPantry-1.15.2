package com.formas1.ruispantry.world.dimension.void_dim;

import java.util.Random;
import java.util.Set;

import com.formas1.ruispantry.init.BiomeInit;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;

public class VoidBiomeProvider extends BiomeProvider
{
	private Random rand;
	public VoidBiomeProvider()
	{
		super(biomeList);
		rand = new Random();
	}
	
	private static final Set<Biome> biomeList = ImmutableSet.of(Biomes.THE_VOID);

	@Override
	public Biome getNoiseBiome(int x, int y, int z)
	{
		return Biomes.THE_VOID;
	}
}
