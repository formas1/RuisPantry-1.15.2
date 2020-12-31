package com.formas1.ruispantry.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindInit 
{
	public static final KeyBinding SPECIAL_ARMOR_1 = new KeyBinding("key.special_armor_1", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_I, "key.categories.rpantry");
	public static final KeyBinding SPECIAL_ARMOR_2 = new KeyBinding("key.special_armor_2", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_O, "key.categories.rpantry");
}
