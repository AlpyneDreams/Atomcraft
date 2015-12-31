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
		this(unlocalizedName, 64);
	}
	
	/**
	 * Returns the item's mod-unique internal name
	 * that follows the format: "item_name".
	 * The internal name is automatically generated
	 * based on the unlocalized name.
	 * 
	 * @return The item's mod-unique internal name.
	 */
	public String getName()
	{
		return internalName;
	}
	
	/**
	 * Returns the item's mod-unique internal name
	 * that follows the format: "item_name".
	 * The internal name is automatically generated
	 * based on the unlocalized name.
	 * 
	 * @param meta The damage value of the item.
	 * @return The item's mod-unique internal name.
	 */
	public String getName(int meta)
	{
		return internalName;
	}
}
