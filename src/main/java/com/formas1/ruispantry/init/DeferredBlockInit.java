package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.objects.blocks.ModSaplingBlock;
import com.formas1.ruispantry.objects.blocks.PantryPortalBlock;
import com.formas1.ruispantry.objects.blocks.SimpleGenerator;
import com.formas1.ruispantry.world.feature.CorruptedTree;
import com.formas1.ruispantry.world.feature.FormasTree;
import com.formas1.ruispantry.world.feature.GamTree;
import com.formas1.ruispantry.world.feature.MilkshakeTree;
import com.formas1.ruispantry.world.feature.WastelandPlumTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ToolItem;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DeferredBlockInit
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			RuisPantry.MOD_ID);
	
	//Formas Tree
	public static final RegistryObject<Block> FORMAS_PLANKS = BLOCKS.register("formas_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> FORMAS_LOG = BLOCKS.register("formas_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> FORMAS_LEAVES = BLOCKS.register("formas_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> FORMAS_SAPLING = BLOCKS.register("formas_sapling",
			() -> new ModSaplingBlock(() -> new FormasTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

	
	//Gam Tree
	public static final RegistryObject<Block> GAM_PLANKS = BLOCKS.register("gam_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> GAM_LOG = BLOCKS.register("gam_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> GAM_LEAVES = BLOCKS.register("gam_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> GAM_SAPLING = BLOCKS.register("gam_sapling",
			() -> new ModSaplingBlock(() -> new GamTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	
	
	//Milkshake Tree
	public static final RegistryObject<Block> MILKSHAKE_PLANKS = BLOCKS.register("milkshake_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> MILKSHAKE_LOG = BLOCKS.register("milkshake_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> MILKSHAKE_LEAVES = BLOCKS.register("milkshake_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> MILKSHAKE_SAPLING = BLOCKS.register("milkshake_sapling",
			() -> new ModSaplingBlock(() -> new MilkshakeTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	
	
	//Corrupted Oak Tree
	public static final RegistryObject<Block> CORRUPTED_PLANKS = BLOCKS.register("corrupted_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> CORRUPTED_LOG = BLOCKS.register("corrupted_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> CORRUPTED_LEAVES = BLOCKS.register("corrupted_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> CORRUPTED_SAPLING = BLOCKS.register("corrupted_sapling",
			() -> new ModSaplingBlock(() -> new CorruptedTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	
	
	//Wasteland Plum Tree
	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_PLANKS = BLOCKS.register("wasteland_plum_tree_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_LOG = BLOCKS.register("wasteland_plum_tree_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_LEAVES = BLOCKS.register("wasteland_plum_tree_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_SAPLING = BLOCKS.register("wasteland_plum_tree_sapling",
			() -> new ModSaplingBlock(() -> new WastelandPlumTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	
	
	//Stairs
	public static final RegistryObject<Block> FORMAS_STAIRS = BLOCKS.register("formas_stairs",
			() -> new StairsBlock(() -> DeferredBlockInit.FORMAS_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
					
	public static final RegistryObject<Block> GAM_STAIRS = BLOCKS.register("gam_stairs",
			() -> new StairsBlock(() -> DeferredBlockInit.GAM_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	
	public static final RegistryObject<Block> MILKSHAKE_STAIRS = BLOCKS.register("milkshake_stairs",
			() -> new StairsBlock(() -> DeferredBlockInit.MILKSHAKE_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	
	public static final RegistryObject<Block> CORRUPTED_STAIRS = BLOCKS.register("corrupted_stairs",
			() -> new StairsBlock(() -> DeferredBlockInit.CORRUPTED_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	
	public static final RegistryObject<Block> CORRUPTED_COBBLESTONE_STAIRS = BLOCKS.register("corrupted_cobblestone_stairs",
			() -> new StairsBlock(() -> BlockInit.corrupted_cobblestone.getDefaultState(),
					Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	
	public static final RegistryObject<Block> CORRUPTED_STONE_STAIRS = BLOCKS.register("corrupted_stone_stairs",
			() -> new StairsBlock(() -> BlockInit.corrupted_stone.getDefaultState(),
					Block.Properties.from(Blocks.STONE_STAIRS)));
	
	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_STAIRS = BLOCKS.register("wasteland_plum_tree_stairs",
			() -> new StairsBlock(() -> DeferredBlockInit.WASTELAND_PLUM_TREE_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));
	
	public static final RegistryObject<Block> MYSTICAL_WASTESTONE_STAIRS = BLOCKS.register("mystical_wastestone_stairs",
			() -> new StairsBlock(() -> BlockInit.mystical_wastestone.getDefaultState(),
					Block.Properties.from(Blocks.STONE_STAIRS)));
	
	public static final RegistryObject<Block> MYSTICAL_WASTECOBBLE_STAIRS = BLOCKS.register("mystical_wastecobble_stairs",
			() -> new StairsBlock(() -> BlockInit.mystical_wastecobble.getDefaultState(),
					Block.Properties.from(Blocks.COBBLESTONE_STAIRS)));
	
	
	//Slabs
	
	public static final RegistryObject<Block> FORMAS_SLAB = BLOCKS.register("formas_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
					
	public static final RegistryObject<Block> GAM_SLAB = BLOCKS.register("gam_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	
	public static final RegistryObject<Block> MILKSHAKE_SLAB = BLOCKS.register("milkshake_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	
	public static final RegistryObject<Block> CORRUPTED_SLAB = BLOCKS.register("corrupted_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	
	public static final RegistryObject<Block> CORRUPTED_COBBLESTONE_SLAB = BLOCKS.register("corrupted_cobblestone_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.COBBLESTONE_SLAB)));
	
	public static final RegistryObject<Block> CORRUPTED_STONE_SLAB = BLOCKS.register("corrupted_stone_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.STONE_SLAB)));
	
	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_SLAB = BLOCKS.register("wasteland_plum_tree_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	
	public static final RegistryObject<Block> MYSTICAL_WASTESTONE_SLAB = BLOCKS.register("mystical_wastestone_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.STONE_SLAB)));
	
	public static final RegistryObject<Block> MYSTICAL_WASTECOBBLE_SLAB = BLOCKS.register("mystical_wastecobble_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.COBBLESTONE_SLAB)));
	
	//Walls
	
	public static final RegistryObject<Block> CORRUPTED_COBBLESTONE_WALL = BLOCKS.register("corrupted_cobblestone_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.COBBLESTONE_WALL)));
	
	public static final RegistryObject<Block> MYSTICAL_WASTECOBBLE_WALL = BLOCKS.register("mystical_wastecobble_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.COBBLESTONE_WALL)));
	
	
	//Fences
	
	public static final RegistryObject<Block> FORMAS_FENCE = BLOCKS.register("formas_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	public static final RegistryObject<Block> GAM_FENCE = BLOCKS.register("gam_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	public static final RegistryObject<Block> MILKSHAKE_FENCE = BLOCKS.register("milkshake_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	public static final RegistryObject<Block> CORRUPTED_FENCE = BLOCKS.register("corrupted_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	public static final RegistryObject<Block> WASTELAND_PLUM_TREE_FENCE = BLOCKS.register("wasteland_plum_tree_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	
	
	
	
	
	public static final RegistryObject<Block> PANTRY_PORTAL = BLOCKS.register("pantry_portal",
			() -> new PantryPortalBlock(Block.Properties.create(Material.PORTAL).doesNotBlockMovement().hardnessAndResistance(-1.0F, 3600000.0F).noDrops().notSolid()));
	
	public static final RegistryObject<Block> CANDY_STONE = BLOCKS.register("candy_stone",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> ROCK_CANDY_BLOCK = BLOCKS.register("rock_candy_block",
			() -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F).harvestLevel(2).lightValue(8).sound(SoundType.CORAL)));
	
	public static final RegistryObject<Block> CHOCOLATE_STONE = BLOCKS.register("chocolate_stone",
			() -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).hardnessAndResistance(1.5F, 6.0F).harvestLevel(1).sound(SoundType.CORAL)));

	public static final RegistryObject<Block> COOKIE_BLOCK = BLOCKS.register("cookie_block",
			() -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5F).sound(SoundType.CORAL)));
	
	public static final RegistryObject<Block> CARAMEL_BLOCK = BLOCKS.register("caramel_block",
			() -> new Block(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.5F).speedFactor(0.4F).slipperiness(0.8F).sound(SoundType.field_226947_m_)));
	
	
	//public static final RegistryObject<Block> SIMPLE_GENERATOR = BLOCKS.register("simple_generator",
		//	() -> new SimpleGenerator(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 8.0F).sound(SoundType.ANVIL).harvestTool(ToolType.PICKAXE).harvestLevel(3).notSolid()));
	
	public static void setItemGroups()
	{
		RuisPantry.CORRUPTION = new Block[] {CORRUPTED_STONE_SLAB.get(), CORRUPTED_STONE_STAIRS.get(), CORRUPTED_COBBLESTONE_SLAB.get(), CORRUPTED_COBBLESTONE_STAIRS.get(), CORRUPTED_COBBLESTONE_WALL.get(), CORRUPTED_PLANKS.get(), CORRUPTED_LOG.get(), CORRUPTED_LEAVES.get(), CORRUPTED_SAPLING.get(), CORRUPTED_SLAB.get(), CORRUPTED_STAIRS.get()};
		RuisPantry.WASTELAND = new Block[] {MYSTICAL_WASTESTONE_SLAB.get(), MYSTICAL_WASTESTONE_STAIRS.get(), MYSTICAL_WASTECOBBLE_SLAB.get(), MYSTICAL_WASTECOBBLE_STAIRS.get(), MYSTICAL_WASTECOBBLE_WALL.get(), WASTELAND_PLUM_TREE_PLANKS.get(), WASTELAND_PLUM_TREE_LOG.get(), WASTELAND_PLUM_TREE_LEAVES.get(), WASTELAND_PLUM_TREE_SAPLING.get(), WASTELAND_PLUM_TREE_SLAB.get(), WASTELAND_PLUM_TREE_STAIRS.get()};
		RuisPantry.PANTRY = new Block[] {PANTRY_PORTAL.get(), CANDY_STONE.get(), ROCK_CANDY_BLOCK.get(), CHOCOLATE_STONE.get(), COOKIE_BLOCK.get(), CARAMEL_BLOCK.get()};
	}
}
