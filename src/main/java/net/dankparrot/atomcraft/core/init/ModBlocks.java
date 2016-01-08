/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.init;

import net.dankparrot.atomcraft.core.blocks.BlockAC;
import net.dankparrot.atomcraft.core.blocks.BlockCentrifuge;
import net.dankparrot.atomcraft.core.blocks.BlockConcrete;
import net.dankparrot.atomcraft.core.blocks.BlockOre;
import net.dankparrot.atomcraft.core.blocks.BlockSiren;
import net.dankparrot.atomcraft.core.blocks.IBlockAC;
import net.dankparrot.atomcraft.core.items.ItemBlockOre;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	
	// Note: Getting block types to play nicely will be hard
	// without Java 8's default methods in interfaces.
	
	public static final Block centrifuge = new BlockCentrifuge();
	public static final BlockAC concrete = new BlockConcrete();
	public static final BlockAC siren = new BlockSiren();
	
	// Multi-ID blocks
	public static final BlockAC ore = new BlockOre();
	
	private static void registerBlock(Block block)
	{
		// TODO make sure casting works as intended
		GameRegistry.registerBlock(block, ((IBlockAC) block).getName());
	}
	
	private static void registerBlock(Block block, Class<? extends ItemBlock> itemclass)
	{
		GameRegistry.registerBlock(block, itemclass, ((IBlockAC) block).getName());
	}
	
	public static void init()
	{
		registerBlock(concrete);
		registerBlock(centrifuge);
		registerBlock(siren);
		
		registerBlock(ore, ItemBlockOre.class);

		OreDictionary.registerOre("oreUranium", new ItemStack(ore, 1, 0));
	}
}
