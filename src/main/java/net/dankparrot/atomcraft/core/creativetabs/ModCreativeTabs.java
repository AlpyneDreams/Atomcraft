/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.creativetabs;

import net.dankparrot.atomcraft.core.init.ModItems;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs {
	public static final CreativeTabs AC_TAB = new CreativeTabs(Reference.MODID)
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.geigerCounter;
		}
	};
}
