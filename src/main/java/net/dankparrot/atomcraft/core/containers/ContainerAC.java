/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.containers;

import net.dankparrot.atomcraft.core.tileentity.TileEntityContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerAC extends Container {
	
	/// VARIABLES ///
	
	private int numContainerSlots;
	
	private TileEntityContainer tileEnt;
	
	/// CONSTRUCTORS ///
	
	/**
	 * <b>Note:</b> Use <i>BEFORE</i> adding any other slots to the container.
	 * @param playerInv
	 * @param te
	 */
	public ContainerAC(IInventory playerInv, TileEntityContainer te, int numSlots)
	{
		super();
		this.tileEnt = te;
		this.numContainerSlots = numSlots;
		this.addEntirePlayerInventory(playerInv);
	}
	
	// TODO better slot registration system
	
	/// METHODS ///
	
	/**
	 * Adds the entirety of the player's inventory the container.
	 * @param playerInv
	 */
	public void addEntirePlayerInventory(IInventory playerInv)
	{
		// Hotbar (0-8)
		this.addSlotGrid(playerInv, this.numContainerSlots, 8, 142, 9, 1);
		
		// Inventory (9-35)
		this.addSlotGrid(playerInv, this.numContainerSlots + 9, 8, 84, 9, 3);
	}
	
	/**
	 * Adds a grid of slots of a specified width and height
	 * at a given position to the container.
	 * @param inv the	IInventory to get the slot from
	 * @param index		the top-left slot id to start from
	 * @param xPos		leftmost x position of the grid
	 * @param yPos		topmost y position of the grid
	 * @param width		width of the grid in number of slots
	 * @param height	height of the grid in number of slots
	 */
	public void addSlotGrid(IInventory inv, int index, int xPos, int yPos, int width, int height)
	{
		for (int y = 0; y < height; y++)	// for each row
		{
			for (int x = 0; x < width; x++)	// and each column
			{
				this.addSlotToContainer(new Slot(inv, x + (y * width) + index, xPos + (x * 18), yPos + (y * 18)));
			}
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot)
	{
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack current = slot.getStack();
			previous = current.copy();
			
			// custom implementation stuff here
			
			if (current.stackSize == 0)
				slot.putStack(null);
			else
				slot.onSlotChanged();
			
			if (current.stackSize == previous.stackSize)
				return null;
			slot.onPickupFromSlot(playerIn, current);
		}
		return previous;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.tileEnt.isUseableByPlayer(playerIn);
	}
	
	//@Override
	//public boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean useEndIndex)
	// Re-write this function to support ItemSlots with varying size if needed.
	
}
