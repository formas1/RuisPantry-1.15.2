package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.world.dimension.pantry.PantryDimension;
import com.formas1.ruispantry.world.dimension.pantry.PantryModDimension;
import com.formas1.ruispantry.world.dimension.void_dim.VoidModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit
{
	public static final DeferredRegister<ModDimension> DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, RuisPantry.MOD_ID);
	
	public static final RegistryObject<ModDimension> PANTRY = DIMENSIONS.register("pantry", () -> new PantryModDimension());
	
	public static final RegistryObject<ModDimension> VOID = DIMENSIONS.register("void", () -> new VoidModDimension());
}
