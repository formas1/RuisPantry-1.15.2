package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.world.dimension.PantryDimension;
import com.formas1.ruispantry.world.dimension.PantryModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit
{
	public static final DeferredRegister<ModDimension> DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, RuisPantry.MOD_ID);
	
	public static final RegistryObject<ModDimension> PANTRY = DIMENSIONS.register("pantry_dim", () -> new PantryModDimension());
}
