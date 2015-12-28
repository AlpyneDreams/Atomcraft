/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.items;

import net.dankparrot.atomcraft.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.reference.Names;
import net.dankparrot.atomcraft.reference.Reference;
import net.minecraft.item.Item;

public class ItemAC extends Item {
	
	public ItemAC(String unlocalizedName, int maxStackSize)
	{
		super();
		this.setUnlocalizedName(unlocalizedName);	// Unlocalized Name Format: itemName
		this.setMaxStackSize(maxStackSize);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	public ItemAC(String unlocalizedName)
	{
		this(unlocalizedName, 1);
	}
	
}
