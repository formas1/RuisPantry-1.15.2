	package com.formas1.ruispantry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.formas1.ruispantry.capabilities.BatWingBootsFlyCapability;
import com.formas1.ruispantry.client.entity.render.UndeadVindicatorRender;
import com.formas1.ruispantry.init.BiomeInit;
import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.BrewingInit;
import com.formas1.ruispantry.init.DeferredBlockInit;
import com.formas1.ruispantry.init.DimensionInit;
import com.formas1.ruispantry.init.EnchantmentInit;
import com.formas1.ruispantry.init.FeatureInit;
import com.formas1.ruispantry.init.ItemInit;
import com.formas1.ruispantry.init.KeyBindInit;
import com.formas1.ruispantry.init.ModEntityTypes;
import com.formas1.ruispantry.init.SoundInit;
import com.formas1.ruispantry.itemgroups.RPGroups;
import com.formas1.ruispantry.objects.blocks.StrawberryPlant;
import com.formas1.ruispantry.packets.Networking;
import com.formas1.ruispantry.world.gen.ModGen;
import com.formas1.ruispantry.world.gen.StructureGen;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;


@SuppressWarnings("deprecation")
@Mod("rpantry")
@Mod.EventBusSubscriber(modid = RuisPantry.MOD_ID, bus = Bus.MOD)
public class RuisPantry
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "rpantry";
    public static RuisPantry instance;
    public static final ResourceLocation PANTRY_DIM_TYPE = new ResourceLocation(MOD_ID, "pantry");
	public static Block[] CORRUPTION;
	public static Block[] WASTELAND;
	public static Block[] PANTRY;

    public RuisPantry()
    {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	
    	//SoundInit.SOUNDS.register(modEventBus);
    	BrewingInit.POTIONS.register(modEventBus);
    	EnchantmentInit.ENCHANTMENTS.register(modEventBus);
    	EnchantmentInit.registerTypes();
    	DeferredBlockInit.BLOCKS.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		BiomeInit.BIOMES.register(modEventBus);
		DimensionInit.DIMENSIONS.register(modEventBus);
		FeatureInit.FEATURES.register(modEventBus);
        instance = this;

        MinecraftForge.EVENT_BUS.register(new BatWingBootsFlyCapability());
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		DeferredBlockInit.setItemGroups();
		DeferredBlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final ItemGroup GROUP;
			boolean corruption = Arrays.stream(CORRUPTION).anyMatch(block::equals);
			boolean wasteland = Arrays.stream(WASTELAND).anyMatch(block::equals);
			boolean pantry = Arrays.stream(PANTRY).anyMatch(block::equals);
			if(corruption) {
				GROUP = RPGroups.CORRUPTION;
			} else if(wasteland) {
				GROUP = RPGroups.WASTELAND;
			} else if(pantry) {
				GROUP = RPGroups.PANTRY;
			} else {
				GROUP = RPGroups.MATERIALS;
			}
			final Item.Properties properties = new Item.Properties().group(GROUP);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		LOGGER.debug("Registered BlockItems!");
	}
    
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event)
    {
    	BiomeInit.registerBiomes();
    }
    
    @SubscribeEvent
    public static void onRegisterPotions(final RegistryEvent.Register<Potion> event)
    {
    	BrewingInit.register();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	ModEntityTypes.registerPlacementTypes();
    	registerEntityWorldSpawn(ModEntityTypes.UNDEAD_VINDICATOR.get(), 5, 1, 3, BiomeInit.WASTELAND_HILLS_BIOME.get());
    	DeferredWorkQueue.runLater(StructureGen::generateStructures);
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
    	RenderTypeLookup.setRenderLayer(BlockInit.strawberry_plant, RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.FORMAS_SAPLING.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.GAM_SAPLING.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.MILKSHAKE_SAPLING.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.CORRUPTED_SAPLING.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.WASTELAND_PLUM_TREE_SAPLING.get(), RenderType.getCutout());
    	
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.FORMAS_LEAVES.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.GAM_LEAVES.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.MILKSHAKE_LEAVES.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.CORRUPTED_LEAVES.get(), RenderType.getCutout());
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.WASTELAND_PLUM_TREE_LEAVES.get(), RenderType.getCutout());
    	
    	RenderTypeLookup.setRenderLayer(BlockInit.big_strawberry, RenderType.getCutout());
    	
    	RenderTypeLookup.setRenderLayer(DeferredBlockInit.PANTRY_PORTAL.get(), RenderType.getCutout());
    	//RenderTypeLookup.setRenderLayer(DeferredBlockInit.SIMPLE_GENERATOR.get(), RenderType.getCutout());
    	
    	RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UNDEAD_VINDICATOR.get(), UndeadVindicatorRender::new);
    	
    	ClientRegistry.registerKeyBinding(KeyBindInit.SPECIAL_ARMOR_1);
		ClientRegistry.registerKeyBinding(KeyBindInit.SPECIAL_ARMOR_2);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    	
    }
    
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event)
    {
    	ModGen.generate();
    	//StructureGen.generateStructures();
    	BatWingBootsFlyCapability.register();
    	Networking.registerMessages();
    }
    
    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event)
    {
    	
    }
    
    private static void registerEntityWorldSpawn(EntityType<?> entity, int weight, int minGroupIn, int maxGroupIn, Biome... biomes)
    {
    	for(Biome biome : biomes) {
    		if(biome != null)
    		{
    			biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, weight, minGroupIn, maxGroupIn));
    		}
    	}
    }
    
    
}
