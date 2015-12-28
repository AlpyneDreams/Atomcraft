/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.init;

import net.dankparrot.atomcraft.items.ItemDust;
import net.dankparrot.atomcraft.items.ItemGeigerCounter;
import net.dankparrot.atomcraft.items.ItemIngot;
import net.dankparrot.atomcraft.reference.Names;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;


public class ModItems {

	public static final Item geigerCounter = new ItemGeigerCounter();
	
	// Multi-ID items
	//public static final Item ingot = new ItemIngot();
	//public static final Item dust = new ItemDust();
	
	private static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
	}
	
	public static void init()
	{
		registerItem(geigerCounter);
		
		//GameRegistry.registerItem(ingot, "ingot");
		//GameRegistry.registerItem(dust, "dust");
		
		//OreDictionary.registerOre("ingotUranium", new ItemStack(ingot, 1, 0));
		//OreDictionary.registerOre("dustUranium", new ItemStack(dust, 1, 0));
	}
}