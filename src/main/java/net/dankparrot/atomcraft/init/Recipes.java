/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class Recipes {
	
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(ModItems.ingot, 1, 0), 0.0F);
	}
}
