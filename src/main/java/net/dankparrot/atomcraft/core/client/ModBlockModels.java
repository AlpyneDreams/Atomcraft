/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.client;

import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.blocks.BlockAC;
import net.dankparrot.atomcraft.core.blocks.IBlockAC;
import net.dankparrot.atomcraft.core.init.ModBlocks;
import net.dankparrot.atomcraft.core.init.ModItems;
import net.dankparrot.atomcraft.core.items.ItemAC;
import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLLog;

public class ModBlockModels {
	
	// casts are in both functions - TODO make sure casting works as intended
	
	private static void addVariants(Block block, int... meta)
	{
		String[] names = new String[meta.length];
		
		for (int i = 0; i < names.length; i++)
			names[i] = Reference.MODID + ":" + ((IBlockAC) block).getName(meta[i]);
		ModelBakery.addVariantName(Item.getItemFromBlock(block), names);
	}
	
	private static void registerBlock(Block block)
	{
		registerBlock(block, 0);
	}
	
	private static void registerBlock(Block block, int meta)
	{
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		itemMesher.register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MODID + ":" + ((IBlockAC) block).getName(meta), "inventory"));
	}
	
	public static void preInit()
	{
		addVariants(ModBlocks.ore, 0);
	}
	
	public static void init()
	{
		registerBlock(ModBlocks.concrete);
		registerBlock(ModBlocks.centrifuge);
		registerBlock(ModBlocks.siren);
		
		registerBlock(ModBlocks.ore, 0);
	}
	
}
