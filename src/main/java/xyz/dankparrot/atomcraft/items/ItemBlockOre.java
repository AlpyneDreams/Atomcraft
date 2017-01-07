
package xyz.dankparrot.atomcraft.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import xyz.dankparrot.atomcraft.reference.EnumOreType;

public class ItemBlockOre extends ItemBlock {
	
	public ItemBlockOre(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setRegistryName(block.getRegistryName());
	}
	
    @Override
	public int getMetadata(int damage)
    {
        return damage;
    }
	
	@Override	// Unlocalized name format: tile.block.subBlock
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName(stack) + "." + EnumOreType.fromMeta(stack.getItemDamage()).getName();
	}
}
