package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BrewingInit
{
	public static final DeferredRegister<Potion> POTIONS = new DeferredRegister<>(ForgeRegistries.POTION_TYPES, RuisPantry.MOD_ID);
	
	public static final RegistryObject<Potion> LEVITATION = POTIONS.register("levitation", () -> new Potion(new EffectInstance(Effects.LEVITATION, 3600)));
	public static final RegistryObject<Potion> LONG_LEVITATION = POTIONS.register("long_levitation", () -> new Potion("levitation", new EffectInstance(Effects.LEVITATION, 9600)));
	
	public static void register()
	{
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.SLOW_FALLING)), Ingredient.fromItems(ItemInit.bat_wing), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), LEVITATION.get()));
		BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), LEVITATION.get())), Ingredient.fromItems(Items.REDSTONE), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), LONG_LEVITATION.get()));
	}
}
