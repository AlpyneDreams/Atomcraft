package xyz.dankparrot.atomcraft;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.dankparrot.atomcraft.init.ModItems;

@Mod(modid = Atomcraft.MODID, version = Atomcraft.VERSION)
public class Atomcraft
{
	public static final String MODID = "atomcraft";
	public static final String VERSION = "INDEV";

	@SidedProxy(serverSide = "xyz.dankparrot.atomcraft.CommonProxy", clientSide = "xyz.dankparrot.atomcraft.ClientProxy")
	public static SharedProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
    	proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}
