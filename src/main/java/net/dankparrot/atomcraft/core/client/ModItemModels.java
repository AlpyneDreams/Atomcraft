/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.client;

import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.init.ModItems;
import net.dankparrot.atomcraft.core.items.ItemAC;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

public class ModItemModels {
	
	private static void addVariants(ItemAC item, int... meta)
	{
		String[] names = new String[meta.length];
		
		for(int i = 0; i < names.length; i++)
			names[i] = Reference.MODID + ":" + item.getName(meta[i]);
		
		ModelBakery.addVariantName(item, names);
	}
	
	private static void registerItem(ItemAC item)
	{
		registerItem(item, 0);
	}
	
	private static void registerItem(ItemAC item, int... meta)
	{
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		for (int i = 0; i < meta.length; i++)
		{
			itemMesher.register(item, meta[i], new ModelResourceLocation(Reference.MODID + ":" + item.getName(meta[i]), "inventory"));
		}
	}
	
	public static void preInit()
	{
		addVariants(ModItems.ingot, 0);
		addVariants(ModItems.dust, 0);
		addVariants(ModItems.uranium, 0, 1, 2, 3, 4, 15);
	}
	
	public static void init()
	{
		registerItem(ModItems.geigerCounter);
		registerItem(ModItems.ingot, 0);
		registerItem(ModItems.dust, 0);
		registerItem(ModItems.uranium, 0, 1, 2, 3, 4, 15);
	}
	
}
