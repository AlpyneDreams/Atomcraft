/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.items;

import java.util.List;

import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.Names;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDust extends ItemAC {
	
	public ItemDust()
	{
		super(Names.Items.DUST, 64);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getName(int meta)
	{
		return EnumOreType.getType(meta).getName() + "_" + this.getName();
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + EnumOreType.getType(stack.getItemDamage()).getName();
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
	    subItems.add(new ItemStack(itemIn, 1, 0));
	}


}
