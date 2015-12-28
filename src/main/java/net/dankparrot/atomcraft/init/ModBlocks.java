/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.init;

import net.dankparrot.atomcraft.blocks.BlockConcrete;
import net.dankparrot.atomcraft.blocks.BlockOre;
import net.dankparrot.atomcraft.items.ItemBlockOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	
	public static final Block concrete = new BlockConcrete();
	
	// Multi-ID blocks
	//public static final Block ore = new BlockOre();
	
	public static void init()
	{
		// All block IDs are listed below. //
		GameRegistry.registerBlock(concrete, "concrete");
		
		//GameRegistry.registerBlock(ore, ItemBlockOre.class, "ore");

		//OreDictionary.registerOre("oreUranium", new ItemStack(ore, 1, 0));
	}
}
