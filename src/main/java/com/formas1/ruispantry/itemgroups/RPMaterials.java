package com.formas1.ruispantry.itemgroups;

import com.formas1.ruispantry.init.BlockInit;
import com.formas1.ruispantry.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RPMaterials extends ItemGroup
{
	public RPMaterials(int index, String label)
	{
		super(index, label);
	}
	
	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(ItemInit.strawberry);
	}
}
