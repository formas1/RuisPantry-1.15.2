package com.formas1.ruispantry.world.dimension.void_dim;

import java.util.function.BiFunction;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.ModDimension;

public class VoidModDimension extends ModDimension
{

	@Override
	public BiFunction<World, DimensionType, ? extends Dimension> getFactory()
	{
		return VoidDimension::new;
	}

}
