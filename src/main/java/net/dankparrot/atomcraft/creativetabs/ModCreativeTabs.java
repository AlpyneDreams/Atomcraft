/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.creativetabs;

import net.dankparrot.atomcraft.init.ModItems;
import net.dankparrot.atomcraft.items.ItemGeigerCounter;
import net.dankparrot.atomcraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs {
	public static final CreativeTabs AC_TAB = new CreativeTabs(Reference.MODID)
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.dust;
		}
	};
}
