/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.client;

import net.dankparrot.atomcraft.init.ModItems;
import net.dankparrot.atomcraft.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItemMeshers {
	
	private static void registerItem(Item item)
	{
		ItemModelMesher itemMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		itemMesher.register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		// having trouble? try adding a meta arg and using item.getUnlocalizedName(new ItemStack(item, 1, meta))
	}
	
	public static void init()
	{
		registerItem(ModItems.geigerCounter);
	}
	
}
