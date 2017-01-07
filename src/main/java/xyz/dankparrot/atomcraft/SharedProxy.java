package xyz.dankparrot.atomcraft;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.dankparrot.atomcraft.init.ModBlocks;
import xyz.dankparrot.atomcraft.init.ModItems;
import xyz.dankparrot.atomcraft.init.Recipes;

public class SharedProxy
{

	public SharedProxy()
	{
		
	}
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
	}
	
	public void preInit(FMLPreInitializationEvent e)
	{
		ModItems.init();
		ModBlocks.init();
		Recipes.init();
	}
	
	public void init(FMLInitializationEvent e)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		
		
	}

}
