package com.formas1.ruispantry.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.enchantments.HegemoneBlessEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.IExtensibleEnum;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentInit
{
	public static EnchantmentType HOE = EnchantmentType.create("hoe", item -> item instanceof HoeItem);
	
	public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, RuisPantry.MOD_ID);
	
	public static final RegistryObject<Enchantment> HEGEMONE_BLESS = ENCHANTMENTS.register("hegemone_bless", () -> new HegemoneBlessEnchantment(Rarity.RARE, HOE, new EquipmentSlotType[] { EquipmentSlotType.MAINHAND }));
	
	public static void registerTypes()
	{
		final EnchantmentType[] vanilla = ItemGroup.TOOLS.getRelevantEnchantmentTypes();
		final List<EnchantmentType> modded = new ArrayList<EnchantmentType>(Arrays.asList(vanilla));
		modded.add(HOE);
		ItemGroup.TOOLS.setRelevantEnchantmentTypes(modded.toArray(new EnchantmentType[0]));
	}
}
