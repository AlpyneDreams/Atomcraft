/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft;

import net.dankparrot.atomcraft.client.ModItemMeshers;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}

	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		ModItemMeshers.init();
	}

	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}
}
