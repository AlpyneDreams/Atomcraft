/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.client;

import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.blocks.BlockAC;
import net.dankparrot.atomcraft.core.init.ModBlocks;
import net.dankparrot.atomcraft.core.init.ModItems;
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

	private static void registerBlock(BlockAC block)
	{
		registerBlock(block, 0);
	}
	
	private static void registerBlock(BlockAC block, int meta)
	{
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		itemMesher.register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MODID + ":" + block.getName(meta), "inventory"));
	}
	
	public static void preInit()
	{
		// TODO automate ModelBakery init stuff
		ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.ore), "atomcraft:uranium_ore");
	}
	
	public static void init()
	{
		registerBlock(ModBlocks.concrete);
		registerBlock(ModBlocks.ore, 0);
	}
	
}
