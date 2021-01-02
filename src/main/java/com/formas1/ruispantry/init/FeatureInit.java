package com.formas1.ruispantry.init;

import java.util.Locale;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.world.feature.structures.CandyCanePieces;
import com.formas1.ruispantry.world.feature.structures.CandyCaneStructure;
import com.formas1.ruispantry.world.feature.structures.GraveyardPieces;
import com.formas1.ruispantry.world.feature.structures.GraveyardStructure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = RuisPantry.MOD_ID)
public class FeatureInit
{

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, RuisPantry.MOD_ID);
	
	
	public static final RegistryObject<GraveyardStructure> GRAVEYARD = FEATURES.register("graveyard",
			() -> new GraveyardStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<CandyCaneStructure> CANDY_CANE = FEATURES.register("candy_cane",
			() -> new CandyCaneStructure(NoFeatureConfig::deserialize));

	
	public static IStructurePieceType GRAVEYARD_PIECE = GraveyardPieces.Piece::new;
	
	public static IStructurePieceType CANDY_CANE_PIECE = CandyCanePieces.Piece::new;
	
	@SubscribeEvent
	public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event)
	{
		Registry.register(Registry.STRUCTURE_PIECE, "GRAVEYARD".toLowerCase(Locale.ROOT), GRAVEYARD_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "CANDY_CANE".toLowerCase(Locale.ROOT), CANDY_CANE_PIECE);
	}
}
