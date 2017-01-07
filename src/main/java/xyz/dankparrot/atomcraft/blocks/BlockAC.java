
package xyz.dankparrot.atomcraft.blocks;

import com.google.common.base.CaseFormat;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import xyz.dankparrot.atomcraft.creativetabs.ModCreativeTabs;

public class BlockAC extends Block {
	
	private String name;
	
	/**************************************************
		Constructors
	*************************************************/
	
	public BlockAC(String name, Material material)
	{
		super(material);
		this.name = name;
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	public BlockAC(String unlocalizedName)
	{
		this(unlocalizedName, Material.ROCK);
	}
	
	/**************************************************
		Methods
	 *************************************************/
	
	public String getName()
	{
		return name;
	}
	
	public String getName(int meta)
	{
		return name;
	}
	
	@Override	// Sets the block's metadata to drop
	public int damageDropped(IBlockState state)
	{
		return this.getMetaFromState(state);
	}
	
	@Override	// Sets the item returned from creative mode pick-block.
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
}
