/****************************************
				Atomcraft
	© 2015 Dank Parrot aka Gamer12594
****************************************/

package net.dankparrot.atomcraft;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dankparrot.atomcraft.init.ModBlocks;
import net.dankparrot.atomcraft.init.ModItems;
import net.dankparrot.atomcraft.init.Recipes;
import net.dankparrot.atomcraft.reference.Reference;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Atomcraft
{
	public static final Logger log = LogManager.getLogger(Reference.NAME);
	
	@Mod.Instance(value = Reference.MODID)
	public static Atomcraft instance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		log.info("Loading Atomcraft version " + Reference.VERSION + " by DankParrot.");
		
		// Load blocks and items
		ModItems.init();
		ModBlocks.init();
		Recipes.init();
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	
}