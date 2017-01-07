
package xyz.dankparrot.atomcraft.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init()
	{
		// Surround TNT with Gunpowder -> Instant TNT
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.explosives, 1, 0), 
		//		"GGG", "GTG", "GGG", 'G', Items.GUNPOWDER, 'T', Blocks.TNT);
		
		// Uranium Ore -> Uranium Ingot
		//GameRegistry.addSmelting(new ItemStack(ModBlocks.ore, 1, 0), new ItemStack(ModItems.ingot, 1, 0), 1F);
		// Uranium Dust -> Uranium Ingot
		GameRegistry.addSmelting(new ItemStack(ModItems.dust, 1), new ItemStack(ModItems.ingot, 1), 0.5F);
		
	}
}
