package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit
{
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			RuisPantry.MOD_ID);
	
	public static final RegistryObject<SoundEvent> WASTELAND_AMBIENT = SOUNDS.register("biome.wasteland.ambient", 
			() -> new SoundEvent(new ResourceLocation(RuisPantry.MOD_ID, "biome.wasteland.ambient")));
}
