/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.client;

import net.dankparrot.atomcraft.core.init.ModItems;
import net.dankparrot.atomcraft.core.items.ItemAC;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

public class ModItemModels {
	
	private static void registerItem(ItemAC item)
	{
		registerItem(item, 0);
	}
	
	private static void registerItem(ItemAC item, int meta)
	{
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		itemMesher.register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + item.getName(meta), "inventory"));
	}
	
	public static void preInit()
	{
		//ModelBakery.addVarientName
	}
	
	public static void init()
	{
		registerItem(ModItems.geigerCounter);
		registerItem(ModItems.ingot, 0);
		registerItem(ModItems.dust, 0);
	}
	
}
