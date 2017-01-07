package xyz.dankparrot.atomcraft;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.dankparrot.atomcraft.init.ModItems;

public class ClientProxy extends SharedProxy
{

	public ClientProxy()
	{
		// TODO Auto-generated constructor stub
	}
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Atomcraft.MODID + ":" + id, "inventory"));
	}

	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}
	
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
	}
	
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
		
	}
}
