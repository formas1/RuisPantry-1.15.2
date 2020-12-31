package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.itemgroups.RPGroups;
import com.formas1.ruispantry.itemgroups.RPMaterials;
import com.formas1.ruispantry.objects.blocks.BigStrawberry;
import com.formas1.ruispantry.objects.blocks.CorruptedGrass;
import com.formas1.ruispantry.objects.blocks.MysticalWastelandGrass;
import com.formas1.ruispantry.objects.blocks.GenericCorruptedBlock;
import com.formas1.ruispantry.objects.blocks.Spinel;
import com.formas1.ruispantry.objects.blocks.SpinelBlock;
import com.formas1.ruispantry.objects.blocks.StrawberryPlant;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(RuisPantry.MOD_ID)
@Mod.EventBusSubscriber(modid = RuisPantry.MOD_ID, bus = Bus.MOD)
public class BlockInit
{
	public static final Block formas_block = null;
	public static final Block gam_block = null;
	public static final Block milkshake_block = null;
	
	
	//OVERWORLD_MOD_ORES
	public static final Block formas_ore = null;
	public static final Block corrupted_formas_ore = null;
	public static final Block wasteland_formas_ore = null;
	
	public static final Block gam_ore = null;
	public static final Block corrupted_gam_ore = null;
	public static final Block wasteland_gam_ore = null;
	
	public static final Block milkshake_ore = null;
	public static final Block corrupted_milkshake_ore = null;
	public static final Block wasteland_milkshake_ore = null;
	
	
	
	public static final Block strawberry_plant = null;
	public static final Block big_strawberry = null;
	
	public static final Block spinel_ore = null;
	public static final Block spinel_block = null;
	public static final Block ender_asurite_ore = null;
	
	public static final Block corrupted_cobblestone = null;
	public static final Block corrupted_stone = null;
	public static final Block corrupted_dirt = null;
	public static final Block corrupted_grass = null;
	
	public static final Block mystical_wasteland_grass = null;
	public static final Block mystical_wastestone = null;
	public static final Block mystical_wastecobble = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{
	event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5f, 15.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("formas_block"));
	event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5f, 15.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("gam_block"));
	event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5f, 15.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("milkshake_block"));
	
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("formas_ore"));
	event.getRegistry().register(new GenericCorruptedBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("corrupted_formas_ore"));
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("wasteland_formas_ore"));
	
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("gam_ore"));
	event.getRegistry().register(new GenericCorruptedBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("corrupted_gam_ore"));
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("wasteland_gam_ore"));
	
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("milkshake_ore"));
	event.getRegistry().register(new GenericCorruptedBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("corrupted_milkshake_ore"));
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 15.0f).lightValue(10).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(3)).setRegistryName("wasteland_milkshake_ore"));
	
	event.getRegistry().register(new StrawberryPlant(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f, 0.0f).sound(SoundType.PLANT)).setRegistryName("strawberry_plant"));
	event.getRegistry().register(new BigStrawberry(Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.0f, 2.0f).notSolid().sound(SoundType.SLIME)).setRegistryName("big_strawberry"));
	
	event.getRegistry().register(new Spinel(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(4)).setRegistryName("spinel_ore"));
	event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.5f, 15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(4)).setRegistryName("ender_asurite_ore"));
	event.getRegistry().register(new SpinelBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 15.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(4)).setRegistryName("spinel_block"));
	
	event.getRegistry().register(new CorruptedGrass(Block.Properties.from(Blocks.GRASS_BLOCK)).setRegistryName("corrupted_grass"));
	event.getRegistry().register(new CorruptedGrass(Block.Properties.from(Blocks.DIRT)).setRegistryName("corrupted_dirt"));
	event.getRegistry().register(new GenericCorruptedBlock(Block.Properties.from(Blocks.STONE)).setRegistryName("corrupted_stone"));
	event.getRegistry().register(new GenericCorruptedBlock(Block.Properties.from(Blocks.COBBLESTONE)).setRegistryName("corrupted_cobblestone"));
	
	event.getRegistry().register(new MysticalWastelandGrass(Block.Properties.from(Blocks.GRASS_BLOCK)).setRegistryName("mystical_wasteland_grass"));
	event.getRegistry().register(new Block(Block.Properties.from(Blocks.STONE)).setRegistryName("mystical_wastestone"));
	event.getRegistry().register(new Block(Block.Properties.from(Blocks.COBBLESTONE)).setRegistryName("mystical_wastecobble"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{
	event.getRegistry().register(new BlockItem(formas_block, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("formas_block"));	
	event.getRegistry().register(new BlockItem(gam_block, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("gam_block"));
	event.getRegistry().register(new BlockItem(milkshake_block, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("milkshake_block"));
	
	event.getRegistry().register(new BlockItem(formas_ore, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("formas_ore"));
	event.getRegistry().register(new BlockItem(corrupted_formas_ore, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_formas_ore"));
	event.getRegistry().register(new BlockItem(wasteland_formas_ore, new Item.Properties().group(RPGroups.WASTELAND)).setRegistryName("wasteland_formas_ore"));
	
	event.getRegistry().register(new BlockItem(gam_ore, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("gam_ore"));
	event.getRegistry().register(new BlockItem(corrupted_gam_ore, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_gam_ore"));
	event.getRegistry().register(new BlockItem(wasteland_gam_ore, new Item.Properties().group(RPGroups.WASTELAND)).setRegistryName("wasteland_gam_ore"));
	
	event.getRegistry().register(new BlockItem(milkshake_ore, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("milkshake_ore"));
	event.getRegistry().register(new BlockItem(corrupted_milkshake_ore, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_milkshake_ore"));
	event.getRegistry().register(new BlockItem(wasteland_milkshake_ore, new Item.Properties().group(RPGroups.WASTELAND)).setRegistryName("wasteland_milkshake_ore"));
	
	event.getRegistry().register(new BlockItem(strawberry_plant, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("strawberry_plant"));
	//event.getRegistry().register(new BlockItem(big_strawberry, new Item.Properties().group(RuisPantryItemGroup.instance)).setRegistryName("big_strawberry"));
	
	event.getRegistry().register(new BlockItem(spinel_ore, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("spinel_ore"));
	event.getRegistry().register(new BlockItem(ender_asurite_ore, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("ender_asurite_ore"));
	event.getRegistry().register(new BlockItem(spinel_block, new Item.Properties().group(RPGroups.MATERIALS)).setRegistryName("spinel_block"));
	
	event.getRegistry().register(new BlockItem(corrupted_cobblestone, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_cobblestone"));
	event.getRegistry().register(new BlockItem(corrupted_stone, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_stone"));
	event.getRegistry().register(new BlockItem(corrupted_dirt, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_dirt"));
	event.getRegistry().register(new BlockItem(corrupted_grass, new Item.Properties().group(RPGroups.CORRUPTION)).setRegistryName("corrupted_grass"));
	
	event.getRegistry().register(new BlockItem(mystical_wasteland_grass, new Item.Properties().group(RPGroups.WASTELAND)).setRegistryName("mystical_wasteland_grass"));
	event.getRegistry().register(new BlockItem(mystical_wastestone, new Item.Properties().group(RPGroups.WASTELAND)).setRegistryName("mystical_wastestone"));
	event.getRegistry().register(new BlockItem(mystical_wastecobble, new Item.Properties().group(RPGroups.WASTELAND)).setRegistryName("mystical_wastecobble"));
	}
}
