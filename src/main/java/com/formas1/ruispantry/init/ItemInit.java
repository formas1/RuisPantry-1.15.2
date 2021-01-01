package com.formas1.ruispantry.init;

import java.util.function.Supplier;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.armor.BatWingShoes;
import com.formas1.ruispantry.armor.BatWingShoesModel;
import com.formas1.ruispantry.itemgroups.RPGroups;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SimpleFoiledItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = RuisPantry.MOD_ID, bus = Bus.MOD)
@ObjectHolder(RuisPantry.MOD_ID)
public class ItemInit
{
	//Item Stuff
	public static final Item formas_stick = null;
	public static final Item formas_ingot = null;
	public static final Item formas_nugget = null;
	
	public static final Item spinel = null;
	public static final Item ender_asurite = null;
	
	public static final Item gam_stick = null;
	public static final Item gam_ingot = null;
	public static final Item gam_nugget = null;
	
	public static final Item milkshake_stick = null;
	public static final Item milkshake_ingot = null;
	public static final Item milkshake_nugget = null;
	
	//Tools
	public static final Item netherrack_sword = null;
	public static final Item netherrack_shovel = null;
	public static final Item netherrack_pickaxe = null;
	public static final Item netherrack_axe = null;
	public static final Item netherrack_hoe = null;
	
	public static final Item formas_sword = null;
	public static final Item formas_shovel = null;
	public static final Item formas_pickaxe = null;
	public static final Item formas_axe = null;
	public static final Item formas_hoe = null;
	
	public static final Item gam_sword = null;
	public static final Item gam_shovel = null;
	public static final Item gam_pickaxe = null;
	public static final Item gam_axe = null;
	public static final Item gam_hoe = null;
	
	public static final Item milkshake_sword = null;
	public static final Item milkshake_shovel = null;
	public static final Item milkshake_pickaxe = null;
	public static final Item milkshake_axe = null;
	public static final Item milkshake_hoe = null;
	
	//Armor
	public static final Item formas_helmet = null;
	public static final Item formas_chestplate = null;
	public static final Item formas_leggings = null;
	public static final Item formas_boots = null;
	
	public static final Item gam_helmet = null;
	public static final Item gam_chestplate = null;
	public static final Item gam_leggings = null;
	public static final Item gam_boots = null;
	
	public static final Item milkshake_helmet = null;
	public static final Item milkshake_chestplate = null;
	public static final Item milkshake_leggings = null;
	public static final Item milkshake_boots = null;
	
	//Food
	public static final Item strawberry = null;
	
	public static final Item plum = null;
	
	public static final Item corrupted_apple = null;
	
	public static final Item bat_wing = null;
	
	public static final Item bat_wing_shoes = null;
	
	public static final Item rock_candy = null;
	
	public static final Item chocolate = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("formas_stick"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("formas_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("formas_nugget"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("gam_stick"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("gam_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("gam_nugget"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("milkshake_stick"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("milkshake_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("milkshake_nugget"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("bat_wing"));
		
		event.getRegistry().register(new SimpleFoiledItem(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("spinel"));
		event.getRegistry().register(new SimpleFoiledItem(new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("ender_asurite"));
		
		//Tools
		//event.getRegistry().register(new PickaxeItem(RPantryItemTier.OBSIDIAN, 2, 5.0f, new Item.Properties().group(RuisPantryItemGroup.instance)).setRegistryName("obsidian_pickaxe"));
		
		event.getRegistry().register(new SwordItem(RPantryItemTier.FORMAS, 3, -2.4F,  new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_sword"));
		event.getRegistry().register(new PickaxeItem(RPantryItemTier.FORMAS, 1, -2.8F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_pickaxe"));
		event.getRegistry().register(new AxeItem(RPantryItemTier.FORMAS, 5.0F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_axe"));
		event.getRegistry().register(new ShovelItem(RPantryItemTier.FORMAS, 1.5F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_shovel"));
		event.getRegistry().register(new HoeItem(RPantryItemTier.FORMAS, 0.0f, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_hoe"));
		
		event.getRegistry().register(new SwordItem(RPantryItemTier.GAM, 3, -2.4F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_sword"));
		event.getRegistry().register(new PickaxeItem(RPantryItemTier.GAM, 1, -2.8F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_pickaxe"));
		event.getRegistry().register(new AxeItem(RPantryItemTier.GAM, 5.0F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_axe"));
		event.getRegistry().register(new ShovelItem(RPantryItemTier.GAM, 1.5F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_shovel"));
		event.getRegistry().register(new HoeItem(RPantryItemTier.GAM, 0.0f, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_hoe"));
		
		event.getRegistry().register(new SwordItem(RPantryItemTier.MILKSHAKE, 3, -2.4F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_sword"));
		event.getRegistry().register(new PickaxeItem(RPantryItemTier.MILKSHAKE, 1, -2.8F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_pickaxe"));
		event.getRegistry().register(new AxeItem(RPantryItemTier.MILKSHAKE, 5.0F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_axe"));
		event.getRegistry().register(new ShovelItem(RPantryItemTier.MILKSHAKE, 1.5F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_shovel"));
		event.getRegistry().register(new HoeItem(RPantryItemTier.MILKSHAKE, 0.0f, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_hoe"));
		
		event.getRegistry().register(new SwordItem(RPantryItemTier.NETHERRACK, 3, -2.4F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("netherrack_sword"));
		event.getRegistry().register(new PickaxeItem(RPantryItemTier.NETHERRACK, 1, -2.8F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("netherrack_pickaxe"));
		event.getRegistry().register(new AxeItem(RPantryItemTier.NETHERRACK, 5.0F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("netherrack_axe"));
		event.getRegistry().register(new ShovelItem(RPantryItemTier.NETHERRACK, 1.5F, -3.0F, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("netherrack_shovel"));
		event.getRegistry().register(new HoeItem(RPantryItemTier.NETHERRACK, 0.0f, new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("netherrack_hoe"));
		
		// Armor
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.FORMAS, EquipmentSlotType.HEAD,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_helmet"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.FORMAS, EquipmentSlotType.CHEST,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_chestplate"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.FORMAS, EquipmentSlotType.LEGS,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_leggings"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.FORMAS, EquipmentSlotType.FEET,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("formas_boots"));
				
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.GAM, EquipmentSlotType.HEAD,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_helmet"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.GAM, EquipmentSlotType.CHEST,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_chestplate"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.GAM, EquipmentSlotType.LEGS,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_leggings"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.GAM, EquipmentSlotType.FEET,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("gam_boots"));
				
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.MILKSHAKE, EquipmentSlotType.HEAD,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_helmet"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.MILKSHAKE, EquipmentSlotType.CHEST,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_chestplate"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.MILKSHAKE, EquipmentSlotType.LEGS,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_leggings"));
				event.getRegistry().register(new ArmorItem(RpantryArmorMaterial.MILKSHAKE, EquipmentSlotType.FEET,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("milkshake_boots"));
				
				event.getRegistry().register(new BatWingShoes(RpantryArmorMaterial.BAT_WING_SHOES, EquipmentSlotType.FEET,
						new Item.Properties().group(RPGroups.TOOLS)).setRegistryName("bat_wing_shoes"));
				
		//Food
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.MATERIALS).food(new Food.Builder().hunger(8).saturation(0.8f).setAlwaysEdible().effect(new EffectInstance(Effects.HASTE, 600, 0), 0.4f).build())).setRegistryName("strawberry"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.WASTELAND).food(new Food.Builder().hunger(6).saturation(0.8f).build())).setRegistryName("plum"));
		event.getRegistry().register(new SimpleFoiledItem(new Item.Properties().group(RPGroups.CORRUPTION).food(new Food.Builder().hunger(4).saturation(0.4f).setAlwaysEdible().effect(new EffectInstance(Effects.WITHER, 300, 0), 1.0f).build())).setRegistryName("corrupted_apple"));
		
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.PANTRY).food(new Food.Builder().hunger(6).saturation(0.6f).effect(new EffectInstance(Effects.SPEED, 300, 1), 1).build())).setRegistryName("rock_candy"));
		event.getRegistry().register(new Item(new Item.Properties().group(RPGroups.PANTRY).food(new Food.Builder().hunger(4).saturation(0.5f).effect(new EffectInstance(Effects.SPEED, 300, 1), 1).build())).setRegistryName("chocolate"));
		event.getRegistry().register(new SwordItem(RPantryItemTier.CANDY, 3, -2.4F, new Item.Properties().group(RPGroups.PANTRY).food(new Food.Builder().hunger(5).saturation(0.4f).effect(new EffectInstance(Effects.SPEED, 600, 0), 0.4f).build())).setRegistryName("candy_cane_sword"));
	}
	
	public enum RPantryItemTier implements IItemTier
	{
	/*	OBSIDIAN(4, 30, 15.0f, 6.0f, 15, () -> {
			return Ingredient.fromItems(Blocks.OBSIDIAN);
		}),
	*/
		FORMAS(4, 2000, 12.0f, 4.6f, 8, () -> {
			return Ingredient.fromItems(ItemInit.formas_ingot);
		}),
		
		GAM(4, 2000, 11.0f, 4.8f, 8, () -> {
			return Ingredient.fromItems(ItemInit.gam_ingot);
		}),
		
		MILKSHAKE(4, 2000, 11.0f, 4.4f, 9, () -> {
			return Ingredient.fromItems(ItemInit.milkshake_ingot);
		}),
		
		NETHERRACK(4, 10, 14.0f, 5.0f, 6, () -> {
			return Ingredient.fromItems(Blocks.NETHERRACK);
		}),
		
		CANDY(1, 120, 5.0f, 2.0f, 6, () -> {
			return Ingredient.fromItems(Items.SUGAR);
		});
		
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private RPantryItemTier (int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses()
		{
			return this.maxUses;
		}

		@Override
		public float getEfficiency()
		{
			return this.efficiency;
		}

		@Override
		public float getAttackDamage()
		{
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel()
		{
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability()
		{
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial()
		{
			return this.repairMaterial.getValue();
		}
		
	}
	
	public enum RpantryArmorMaterial implements IArmorMaterial {
		FORMAS(RuisPantry.MOD_ID + ":formas", 50, new int[] {5, 8, 9, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F, () -> {
			return Ingredient.fromItems(ItemInit.formas_ingot);
		}),
		
		GAM(RuisPantry.MOD_ID + ":gam", 48, new int[] {4, 9, 8, 5}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F, () -> {
			return Ingredient.fromItems(ItemInit.gam_ingot);
		}),
		
		MILKSHAKE(RuisPantry.MOD_ID + ":milkshake", 45, new int[] {4, 8, 7, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F, () -> {
			return Ingredient.fromItems(ItemInit.milkshake_ingot);
		}),
		
		BAT_WING_SHOES(RuisPantry.MOD_ID + ":bat_wing_shoes", 25, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, () -> {
		      return Ingredient.fromItems(ItemInit.bat_wing);
		});

		private static final int[] MAX_DAMAGE_ARRAY = new int[] { 16, 16, 16, 16 };
		private final String name;
		private final int maxDamageFactor;
		private final int[] damageReductionAmountArray;
		private final int enchantability;
		private final SoundEvent soundEvent;
		private final float toughness;
		private final LazyValue<Ingredient> repairMaterial;

		private RpantryArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn,
				int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn,
				Supplier<Ingredient> repairMaterialIn) {
			this.name = nameIn;
			this.maxDamageFactor = maxDamageFactorIn;
			this.damageReductionAmountArray = damageReductionAmountIn;
			this.enchantability = enchantabilityIn;
			this.soundEvent = soundEventIn;
			this.toughness = toughnessIn;
			this.repairMaterial = new LazyValue<>(repairMaterialIn);
		}

		@Override
		public int getDurability(EquipmentSlotType slotIn) {
			return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType slotIn) {
			return this.damageReductionAmountArray[slotIn.getIndex()];
		}

		@Override
		public int getEnchantability() {
			return this.enchantability;
		}

		@Override
		public SoundEvent getSoundEvent() {
			return this.soundEvent;
		}

		@Override
		public Ingredient getRepairMaterial() {
			return this.repairMaterial.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.toughness;
		}
	}
}
