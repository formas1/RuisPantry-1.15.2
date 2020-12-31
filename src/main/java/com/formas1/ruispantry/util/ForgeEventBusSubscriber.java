package com.formas1.ruispantry.util;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = RuisPantry.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber
{
	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event)
	{
		if(DimensionType.byName(RuisPantry.PANTRY_DIM_TYPE) == null)
		{
			DimensionManager.registerDimension(RuisPantry.PANTRY_DIM_TYPE, DimensionInit.PANTRY.get(), null, true);
		}
		RuisPantry.LOGGER.info("Rui's Pantry Dimensions Registered!");
	}
}
