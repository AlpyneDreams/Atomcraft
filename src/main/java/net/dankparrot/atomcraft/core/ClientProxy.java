/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core;

import net.dankparrot.atomcraft.core.client.ModBlockModels;
import net.dankparrot.atomcraft.core.client.ModItemModels;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
		ModBlockModels.preInit();
	}

	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		ModItemModels.init();
		ModBlockModels.init();
	}

	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
}
