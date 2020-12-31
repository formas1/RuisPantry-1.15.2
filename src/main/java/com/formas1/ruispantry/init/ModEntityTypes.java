package com.formas1.ruispantry.init;

import com.formas1.ruispantry.RuisPantry;
import com.formas1.ruispantry.entities.UndeadVindicator;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			RuisPantry.MOD_ID);

	public static final RegistryObject<EntityType<UndeadVindicator>> UNDEAD_VINDICATOR = ENTITY_TYPES.register(
			"undead_vindicator",
			() -> EntityType.Builder.<UndeadVindicator>create(UndeadVindicator::new, EntityClassification.MONSTER)
					.size(0.6F, 1.95F).build(new ResourceLocation(RuisPantry.MOD_ID, "undead_vindicator").toString()));
	
	@SuppressWarnings("unchecked")
	public static void registerPlacementType(EntityType type, EntitySpawnPlacementRegistry.PlacementType spawnType)
	{
		EntitySpawnPlacementRegistry.register(type, spawnType, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
	}
	
	public static void registerPlacementTypes()
	{
		registerPlacementType(ModEntityTypes.UNDEAD_VINDICATOR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND);
	}
}
