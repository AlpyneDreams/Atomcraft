/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

import com.google.common.base.CaseFormat;

import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.core.network.ModGuiHandler;
import net.dankparrot.atomcraft.core.reference.Names;
import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockCentrifuge extends BlockContainer {

	private String internalName;
	
	// TODO Replace temporary implementation of BlockContainer with
	
	public BlockCentrifuge()
	{
		super(Material.rock);
		this.internalName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, Names.Blocks.CENTRIFUGE);
		this.setUnlocalizedName(Names.Blocks.CENTRIFUGE);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
		TileEntityCentrifuge te = (TileEntityCentrifuge) world.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(world, pos, te);
		super.breakBlock(world, pos, blockstate);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCentrifuge();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			((TileEntityCentrifuge) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			player.openGui(Atomcraft.instance, ModGuiHandler.CENTRIFUGE, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	@Override
	public int getRenderType() {
		return 3;
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
