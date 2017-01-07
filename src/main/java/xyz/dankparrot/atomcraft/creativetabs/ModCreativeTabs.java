
package xyz.dankparrot.atomcraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xyz.dankparrot.atomcraft.Atomcraft;
import xyz.dankparrot.atomcraft.init.ModItems;

public class ModCreativeTabs {
	/**
	 * Atomcraft creative tab, icon is a geiger counter.
	 */
	public static final CreativeTabs AC_TAB = new CreativeTabs(Atomcraft.MODID)
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.geigerCounter;
		}
	};
}
