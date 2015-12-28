/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.init;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.dankparrot.atomcraft.reference.Names;
import net.dankparrot.atomcraft.reference.Reference;
import net.dankparrot.atomcraft.items.ItemAC;
import net.dankparrot.atomcraft.items.ItemIngot;
import net.dankparrot.atomcraft.items.ItemDust;
import net.dankparrot.atomcraft.items.ItemFoodAC;
import net.dankparrot.atomcraft.items.ItemGeigerCounter;


public class ModItems {

	public static final Item geigerCounter = new ItemGeigerCounter();
	public static final Item greenApple = new ItemFoodAC(Names.Items.GREEN_APPLE, 4, 0.3f, false);
	
	// Multi-ID items
	public static final Item ingot = new ItemIngot();
	public static final Item dust = new ItemDust();
	
	public static void init()
	{
		// All item IDs are listed below. //
		GameRegistry.registerItem(geigerCounter, "geiger_counter");
		GameRegistry.registerItem(greenApple, "green_apple");
		
		GameRegistry.registerItem(ingot, "ingot");
		GameRegistry.registerItem(dust, "dust");
		
		OreDictionary.registerOre("ingotUranium", new ItemStack(ingot, 1, 0));
		OreDictionary.registerOre("dustUranium", new ItemStack(dust, 1, 0));
	}
}