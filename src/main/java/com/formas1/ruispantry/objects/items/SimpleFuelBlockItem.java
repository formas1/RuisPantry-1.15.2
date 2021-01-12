package com.formas1.ruispantry.objects.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class SimpleFuelBlockItem extends BlockItem
{
	int burnTime;
	public SimpleFuelBlockItem(Block blockIn, Properties builder, int burnTime)
	{
		super(blockIn, builder);
		this.burnTime = burnTime;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack)
	{
		return this.burnTime;
	}
}
