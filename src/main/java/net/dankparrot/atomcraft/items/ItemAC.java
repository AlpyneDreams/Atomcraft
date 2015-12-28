/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.items;

import net.minecraft.item.Item;
import net.dankparrot.atomcraft.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.reference.Reference;

public class ItemAC extends Item {
	
	public ItemAC(String unlocalizedName, int maxStackSize)
	{
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MODID + ":" + unlocalizedName);
		this.setMaxStackSize(maxStackSize);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	public ItemAC(String unlocalizedName)
	{
		this(unlocalizedName, 1);
	}
	
}
