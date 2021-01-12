package com.formas1.ruispantry.objects.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SimpleFuelItem extends Item
{
	int burnTime;
	public SimpleFuelItem(Properties properties, int burnTime)
	{
		super(properties);
		this.burnTime = burnTime;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return this.burnTime;
	}

}
