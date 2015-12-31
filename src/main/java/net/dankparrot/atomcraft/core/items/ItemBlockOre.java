/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.items;

import net.dankparrot.atomcraft.core.blocks.BlockAC;
import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlock {
	
	public ItemBlockOre(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	@Override	// Unlocalized name format: tile.block.subBlock
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "." + EnumOreType.getType(stack.getItemDamage());
	}
}
