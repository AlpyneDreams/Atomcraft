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
	
	public static void init()
	{
		// All item IDs are listed below. //
		GameRegistry.registerItem(geigerCounter, "geiger_counter");
		
		//GameRegistry.registerItem(ingot, "ingot");
		//GameRegistry.registerItem(dust, "dust");
		
		//OreDictionary.registerOre("ingotUranium", new ItemStack(ingot, 1, 0));
		//OreDictionary.registerOre("dustUranium", new ItemStack(dust, 1, 0));
	}
}