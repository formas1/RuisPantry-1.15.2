package com.formas1.ruispantry.world.dimension.void_dim;

import net.minecraft.world.gen.GenerationSettings;

public class VoidGenSettings extends GenerationSettings
{
	public int getBiomeSize()
	{
		return 4;
	}
	
	public int getRiverSize()
	{
		return 4;
	}
	
	public int getBiomeId()
	{
		return -1;
	}
	
	@Override
	public int getBedrockFloorHeight()
	{
		return 0;
	}
}
