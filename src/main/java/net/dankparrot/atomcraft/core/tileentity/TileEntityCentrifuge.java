/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class TileEntityCentrifuge extends TileEntity implements IInventory {
	
	private boolean hasItems = false;
	private ItemStack[] inventory;
	
	public TileEntityCentrifuge() {
		this.inventory = new ItemStack[this.getSizeInventory()]; 
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		NBTTagList l = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); i++)
		{
			if (this.getStackInSlot(i) != null)
			{
				NBTTagCompound s = new NBTTagCompound();
				s.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(s);
				l.appendTag(s);
			}
		}
		compound.setTag("Items", l);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList l = compound.getTagList("Items", 10);
		for (int i = 0; i < l.tagCount(); i++)
		{
			NBTTagCompound s = l.getCompoundTagAt(i);
			int slot = s.getByte("Slot");
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(s));
		}
	}

	@Override
	public String getName() {
		return "container.centrifuge";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		return new ChatComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		return 2;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index < 0 || index >= this.getSizeInventory())
			return null;
		return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (this.getStackInSlot(index) != null)
		{
			ItemStack stack;
			
			if (this.getStackInSlot(index).stackSize <= count)
			{
				stack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return stack;
			}
			else {
				stack = this.getStackInSlot(index).splitStack(count);
				
				if (this.getStackInSlot(index).stackSize <= 0)
				{
					this.setInventorySlotContents(index, null);
				}
				else {
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}
				
				this.markDirty();
				return stack;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index < 0 || index >= this.getSizeInventory())
	    	return;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();
	        
		if (stack != null && stack.stackSize == 0)
			stack = null;

		this.inventory[index] = stack;
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.getSizeInventory(); i++)
			this.setInventorySlotContents(i, null);
	}

}
