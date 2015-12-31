/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.items;

import com.google.common.base.CaseFormat;

import net.dankparrot.atomcraft.core.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.core.reference.Names;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraft.item.Item;

public class ItemAC extends Item {
	
	private String internalName;
	
	public ItemAC(String unlocalizedName, int maxStackSize)
	{
		super();
		this.internalName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, unlocalizedName);
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(maxStackSize);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	public ItemAC(String unlocalizedName)
	{
		this(unlocalizedName, 1);
	}
	
	/**
	 * Every item has a mod-unique internal name
	 * that follows the format: "item_name".
	 * This name is used for texture names,
	 * model names, and item ids. The internal name
	 * is automatically generated based on the 
	 * block's unlocalized name.
	 * @return The block's mod-unique internal name.
	 */
	public String getName()
	{
		return internalName;
	}
	
	public String getName(int meta)
	{
		return internalName;
	}
}
