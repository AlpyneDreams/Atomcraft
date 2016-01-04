/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

import net.dankparrot.atomcraft.core.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.google.common.base.CaseFormat;

public class BlockAC extends Block {
	
	private String internalName;
	
	public BlockAC(String unlocalizedName, Material material)
	{
		super(material);
		this.internalName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, unlocalizedName);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	public BlockAC(String unlocalizedName)
	{
		this(unlocalizedName, Material.rock);
	}
	
	/**
	 * Returns the block's mod-unique internal name
	 * that follows the format: "block_name".
	 * The internal name is automatically generated
	 * based on the unlocalized name.
	 * 
	 * @return The block's mod-unique internal name.
	 */
	public String getName()
	{
		return internalName;
	}
	
	/**
	 * Returns the block's mod-unique internal name
	 * that follows the format: "block_name".
	 * The internal name is automatically generated
	 * based on the unlocalized name.
	 * 
	 * @param meta The damage value of the block.
	 * @return The block's mod-unique internal name.
	 */
	public String getName(int meta)
	{
		return internalName;
	}
	
	@Override	// Sets the block's metadata to drop
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override	// Sets the item returned from creative mode pick-block.
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
}
