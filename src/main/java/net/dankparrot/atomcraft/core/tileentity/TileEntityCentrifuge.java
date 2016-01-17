/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.tileentity;

import net.dankparrot.atomcraft.core.items.ItemUranium;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class TileEntityCentrifuge extends TileEntityContainer implements IInventory {
	
	public TileEntityCentrifuge() {
		super("centrifuge", 2);
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if (index == 0 && stack.getItem().equals(ItemUranium.class))
			return true;
		else return false;
	}

}
