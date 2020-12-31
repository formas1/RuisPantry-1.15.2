package com.formas1.ruispantry.itemgroups;

import net.minecraft.item.ItemGroup;

public class RPGroups
{
	public static final RPMaterials MATERIALS = new RPMaterials(ItemGroup.GROUPS.length, "rpantry.materials");
	public static final RPToolsArmor TOOLS = new RPToolsArmor(ItemGroup.GROUPS.length, "rpantry.tools");
	public static final RPCorruption CORRUPTION = new RPCorruption(ItemGroup.GROUPS.length, "rpantry.corruption");
	public static final RPWasteland WASTELAND = new RPWasteland(ItemGroup.GROUPS.length, "rpantry.wasteland");
	public static final RPPantry PANTRY = new RPPantry(ItemGroup.GROUPS.length, "rpantry.pantry");

}
