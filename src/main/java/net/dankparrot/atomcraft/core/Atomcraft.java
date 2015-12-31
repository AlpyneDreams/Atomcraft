/****************************************
				Atomcraft
	© 2015 Dank Parrot aka Gamer12594
****************************************/

package net.dankparrot.atomcraft.core;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Atomcraft
{	
	@Mod.Instance(value = Reference.MODID)
	public static Atomcraft instance;
	
	@SidedProxy(clientSide="net.dankparrot.atomcraft.core.ClientProxy", serverSide="net.dankparrot.atomcraft.core.ServerProxy")
	public static CommonProxy proxy;
	
	public static Logger ACLog = LogManager.getLogger(Reference.NAME);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.proxy.preInit(event);
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
		this.proxy.init(event);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		this.proxy.postInit(event);
	}
	
	
}