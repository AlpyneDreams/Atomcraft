/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.containers;

import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.dankparrot.atomcraft.core.tileentity.TileEntityContainer;
import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.containers.ContainerAC;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerCentrifuge extends ContainerAC {

	public ContainerCentrifuge(IInventory playerInv, TileEntityCentrifuge te) {
		super(playerInv, te, 2);
		
		this.addSlotToContainer(new Slot(te, 36, 79, 17));
		this.addSlotToContainer(new Slot(te, 37, 79, 53));
	}

}
