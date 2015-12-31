/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core;

import net.dankparrot.atomcraft.core.init.ModBlocks;
import net.dankparrot.atomcraft.core.init.ModItems;
import net.dankparrot.atomcraft.core.init.Recipes;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e)
	{
		ModItems.init();
		ModBlocks.init();
	}

	public void init(FMLInitializationEvent e)
	{
		Recipes.init();
	}

	public void postInit(FMLPostInitializationEvent e)
	{

	}
}
