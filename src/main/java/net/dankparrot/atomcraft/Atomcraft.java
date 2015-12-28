/****************************************
				Atomcraft
	© 2015 Dank Parrot aka Gamer12594
****************************************/

package net.dankparrot.atomcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dankparrot.atomcraft.init.ModBlocks;
import net.dankparrot.atomcraft.init.ModItems;
import net.dankparrot.atomcraft.init.Recipes;
import net.dankparrot.atomcraft.reference.Reference;
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
	
	@SidedProxy(clientSide="net.dankparrot.atomcraft.ClientProxy", serverSide="net.dankparrot.atomcraft.ServerProxy")
	public static CommonProxy proxy;
	
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