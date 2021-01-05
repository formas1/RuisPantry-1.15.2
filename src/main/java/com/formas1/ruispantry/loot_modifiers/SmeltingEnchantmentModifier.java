package com.formas1.ruispantry.loot_modifiers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

public class SmeltingEnchantmentModifier extends LootModifier {
        public SmeltingEnchantmentModifier(ILootCondition[] conditionsIn) {
            super(conditionsIn);
        }

        @Nonnull
        @Override
        public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
            ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
            generatedLoot.forEach((stack) -> ret.add(smelt(stack, context)));
            return ret;
        }

        private static ItemStack smelt(ItemStack stack, LootContext context) {
            return context.getWorld().getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(stack), context.getWorld())
                    .map(FurnaceRecipe::getRecipeOutput)
                    .filter(itemStack -> !itemStack.isEmpty())
                    .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                    .orElse(stack);
        }

        public static class Serializer extends GlobalLootModifierSerializer<SmeltingEnchantmentModifier> {
            @Override
            public SmeltingEnchantmentModifier read(ResourceLocation name, JsonObject json, ILootCondition[] conditionsIn) {
                return new SmeltingEnchantmentModifier(conditionsIn);
            }
        }
    }