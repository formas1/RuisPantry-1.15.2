package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.loot_modifiers.SmeltingEnchantmentModifier;

import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SerializerInit
{
	public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, RuisPantry.MOD_ID);
	
	public static final RegistryObject<GlobalLootModifierSerializer<SmeltingEnchantmentModifier>> SMELTING_ENCHANTMENT = LOOT_MODIFIER_SERIALIZERS.register("smelting_enchantment_loot", () -> new SmeltingEnchantmentModifier.Serializer());
}
