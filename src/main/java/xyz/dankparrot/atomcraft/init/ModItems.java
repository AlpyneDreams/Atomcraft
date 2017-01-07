package xyz.dankparrot.atomcraft.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import xyz.dankparrot.atomcraft.Atomcraft;
import xyz.dankparrot.atomcraft.items.*;

public class ModItems
{
	
	public static void registerItem(ItemAC item, int... meta)
	{
		GameRegistry.register(item);
		
		for (int i : meta) {
			Atomcraft.proxy.registerItemRenderer(item, i, item.getName(i));
		}
	}
	
	public static void registerItem(ItemAC item)
	{
		registerItem(item, 0);
	}
	
	public static ItemAC geigerCounter = new ItemGeigerCounter();
	public static ItemAC ingot = new ItemIngot();
	public static ItemAC dust = new ItemDust();
	public static ItemAC uranium = new ItemUranium();
	
	public static void init()
	{
		registerItem(geigerCounter);
		registerItem(ingot, 0, 1);
		registerItem(dust, 0, 1);
		registerItem(uranium, 0, 1, 2, 3, 4, 15);
		
		OreDictionary.registerOre("ingotUranium", new ItemStack(ingot, 0));
		OreDictionary.registerOre("dustUranium", new ItemStack(dust, 0));

	}

}
