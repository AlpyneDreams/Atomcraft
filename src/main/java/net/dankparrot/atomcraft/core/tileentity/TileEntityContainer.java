/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.tileentity;

import com.google.common.base.CaseFormat;

import jdk.nashorn.internal.ir.WhileNode;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class TileEntityContainer extends TileEntity implements IInventory {
	
	/// VARIABLES ///
	
	private ItemStack[] inventory;
	
	private String unlocalizedName;	// Format: container.tileEntity
	private String customName;		// Set in anvils
	
	/// CONSTRUCTORS ///
	
	public TileEntityContainer(String unlocalizedName, int inventorySize)
	{
		super();
		this.inventory = new ItemStack[inventorySize];
		this.unlocalizedName = unlocalizedName;
	}
	
	/// METHODS ///
	
	@Override
	public ItemStack getStackInSlot(int index) {
		if(index < 0 || index >= this.getSizeInventory())
			return null;
		return this.inventory[index];
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
			else
			{
				stack = this.getStackInSlot(index).splitStack(count);
				
				if (this.getStackInSlot(index).stackSize <= 0)
					this.setInventorySlotContents(index, null);
				else
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				
				this.markDirty();
				return stack;
			}
		}
		else
			return null;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO specific item only slots
		return true;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < this.getSizeInventory(); i++)
			this.setInventorySlotContents(i, null);
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}
	
	/// NBT HANDLERS ///
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
			
		NBTTagList list = new NBTTagList();
		// For each ItemStack add item data to nbt
		for (int i = 0; i < this.getSizeInventory(); i++)
		{
			if (this.getStackInSlot(i) != null)
			{
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("Items", list);
			
		// Handle custom names
		if (this.hasCustomName())
			nbt.setString("CustomName", this.getCustomName());
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", 10);
		// For each item data add an ItemStack to inventory
		for (int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}
		
		// Handle custom names
		if (nbt.hasKey("CustomName", 8))
			this.setCustomName(nbt.getString("CustomName"));
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public int getSizeInventory() {
		return this.inventory.length;
	}
	
	@Override
	public IChatComponent getDisplayName() {
		return this.hasCustomName() ? new ChatComponentText(this.getCustomName()) : new ChatComponentTranslation(this.getName());
	}
	
	@Override
	public String getName() {
		return this.hasCustomName() ? this.getCustomName() : this.unlocalizedName;
	}
	
	// Unlocalized Name
	
	/**
	 * Returns the TileEntity's unlocalized name.
	 * @return
	 */
	public String getUnlocalizedName()
	{
		return "container." + this.unlocalizedName;
	}
	
	/**
	 * Sets the TileEntity's unlocalized name.
	 * @param name
	 */
	public void setUnlocalizedName(String name)
	{
		this.unlocalizedName = name;
	}
	
	// Custom Name
	
	/**
	 * Returns the TileEntity's custom name.
	 * (Set by anvils in NBT data)
	 * @return
	 */
	public String getCustomName()
	{
		return this.customName;
	}
	
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	@Override
	public boolean hasCustomName() {
		return this.getCustomName() != null && this.getCustomName().length() > 0;
	}
	
	/// FIELD METHODS ///
	
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
	
}
