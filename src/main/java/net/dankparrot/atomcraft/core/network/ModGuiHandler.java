/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.network;

import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.client.gui.GuiCentrifuge;
import net.dankparrot.atomcraft.core.containers.ContainerCentrifuge;
import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
	
	public static final int CENTRIFUGE = 0;
	
	// TODO Implement a better way of registering GUIs.
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == this.CENTRIFUGE)
			return new ContainerCentrifuge(player.inventory, (TileEntityCentrifuge) world.getTileEntity(new BlockPos(x, y, x)));
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == this.CENTRIFUGE)
			return new GuiCentrifuge(player.inventory, (TileEntityCentrifuge)world.getTileEntity(new BlockPos(x, y, z)));
		
		return null;
	}
	
}
