/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.containers;

import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.dankparrot.atomcraft.core.tileentity.TileEntityContainer;
import net.dankparrot.atomcraft.core.containers.ContainerAC;
import net.minecraft.inventory.IInventory;

public class ContainerCentrifuge extends ContainerAC {

	public ContainerCentrifuge(IInventory playerInv, TileEntityCentrifuge te) {
		super(playerInv, te);
		
		this.addSlotGrid(playerInv, 8, 17, 2, 2, 36);
	}

}
