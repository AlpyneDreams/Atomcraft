
package xyz.dankparrot.atomcraft.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import xyz.dankparrot.atomcraft.Atomcraft;
import xyz.dankparrot.atomcraft.blocks.BlockAC;
import xyz.dankparrot.atomcraft.blocks.BlockConcrete;
import xyz.dankparrot.atomcraft.blocks.BlockOre;
import xyz.dankparrot.atomcraft.items.ItemBlockOre;

public class ModBlocks
{
	
	private static void registerBlock(BlockAC block, ItemBlock item, int... meta)
	{
		GameRegistry.register(block);
		GameRegistry.register(item);
		
		for (int i : meta) {
			Atomcraft.proxy.registerItemRenderer(item, i, block.getName(i));
		}
	}
	
	private static void registerBlock(BlockAC block, int... meta)
	{
		ItemBlock item = new ItemBlock(block);
		if (meta.length > 1)
			item.setHasSubtypes(true);
		item.setRegistryName(block.getRegistryName());
		
		registerBlock(block, item, meta);
	}
	
	private static void registerBlock(BlockAC block)
	{
		registerBlock(block, 0);
	}
	
	public static final BlockAC concrete = new BlockConcrete();
	public static final BlockAC ore = new BlockOre();
	
	public static void init()
	{
		registerBlock(concrete);
		registerBlock(ore, new ItemBlockOre(ore), 0, 1);
	}
}
