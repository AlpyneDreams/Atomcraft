/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(ModItems.ingot, 1, 0), 1F);
	}
}
