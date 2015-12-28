/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.items;

import net.dankparrot.atomcraft.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlockWithMetadata {
	
	public ItemBlockOre(Block block) {
		super(block, block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int meta = stack.getItemDamage();
		if (meta >= Names.Ores.TYPES.length)
			meta = 0;
		return this.getUnlocalizedName() + "." + Names.Ores.TYPES[meta];
	}
	
}
