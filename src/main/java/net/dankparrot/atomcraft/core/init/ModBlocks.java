/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.init;

import net.dankparrot.atomcraft.core.blocks.BlockAC;
import net.dankparrot.atomcraft.core.blocks.BlockCentrifuge;
import net.dankparrot.atomcraft.core.blocks.BlockConcrete;
import net.dankparrot.atomcraft.core.blocks.BlockOre;
import net.dankparrot.atomcraft.core.items.ItemBlockOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	
	public static final BlockCentrifuge centrifuge = new BlockCentrifuge();
	public static final BlockAC concrete = new BlockConcrete();
	
	// Multi-ID blocks
	public static final BlockAC ore = new BlockOre();
	
	private static void registerBlock(BlockAC block)
	{
		GameRegistry.registerBlock(block, block.getName());
	}
	
	private static void registerBlock(BlockAC block, Class<? extends ItemBlock> itemclass)
	{
		GameRegistry.registerBlock(block, itemclass, block.getName());
	}
	
	public static void init()
	{
		GameRegistry.registerBlock(centrifuge, centrifuge.getName());
		registerBlock(concrete);
		
		registerBlock(ore, ItemBlockOre.class);

		OreDictionary.registerOre("oreUranium", new ItemStack(ore, 1, 0));
	}
}
