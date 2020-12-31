package com.formas1.ruispantry.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class UndeadVindicator extends VindicatorEntity {

	public UndeadVindicator(EntityType<? extends VindicatorEntity> type, World worldIn) {
		super(type, worldIn);
	}
}
