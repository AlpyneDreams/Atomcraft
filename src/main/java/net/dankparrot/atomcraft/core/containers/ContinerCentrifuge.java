/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.containers;

import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.dankparrot.atomcraft.core.tileentity.TileEntityContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContinerCentrifuge extends ContainerAC {

	public ContinerCentrifuge(IInventory playerInv) {
		super(playerInv, new TileEntityCentrifuge(), 2);
		this.addSlotToContainer(new Slot(this.getTileEntity(), 0, 79, 17));
		this.addSlotToContainer(new Slot(this.getTileEntity(), 1, 79, 53));
	}
	
}
