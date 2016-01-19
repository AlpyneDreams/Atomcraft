/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core;

import net.dankparrot.atomcraft.core.init.ModBlocks;
import net.dankparrot.atomcraft.core.init.ModItems;
import net.dankparrot.atomcraft.core.init.ModTileEntities;
import net.dankparrot.atomcraft.core.init.Recipes;
import net.dankparrot.atomcraft.core.network.ModGuiHandler;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.dankparrot.atomcraft.core.world.WorldGenAtomcraft;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e)
	{
		ModItems.init();
		ModBlocks.init();
		ModTileEntities.init();
	}

	public void init(FMLInitializationEvent e)
	{
		Recipes.init();
		GameRegistry.registerWorldGenerator(new WorldGenAtomcraft(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(Atomcraft.instance, new ModGuiHandler());
	}

	public void postInit(FMLPostInitializationEvent e)
	{

	}
}
