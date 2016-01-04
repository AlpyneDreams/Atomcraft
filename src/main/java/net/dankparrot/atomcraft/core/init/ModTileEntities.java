/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.init;

import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	
	private static void registerTileEntity(TileEntity ent)
	{
		// TODO registering automation for tileEnts
	}
	
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityCentrifuge.class, "centrifuge");
	}
	
}
