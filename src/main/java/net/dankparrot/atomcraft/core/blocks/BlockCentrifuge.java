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

public class BlockCentrifuge extends BlockContainer implements IBlockAC {

	private String internalName;
	
	// TODO replace temporary BlockContainer code
	
	public BlockCentrifuge()
	{
		super(Material.rock);
		this.internalName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, Names.Blocks.CENTRIFUGE);
		this.setUnlocalizedName(Names.Blocks.CENTRIFUGE);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	/// METHODS ///
	
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
		//if (!world.isRemote) {
		//	player.openGui(Atomcraft.instance, ModGuiHandler.CENTRIFUGE, world, pos.getX(), pos.getY(), pos.getZ());
		//}
		//return true;
		return false;	// TODO placeholder because crashing
	}

	/// MUTATORS ///
	
	@Override
	public int getRenderType() {
		return 3; // dunno what the point of this is
	}
	
	public String getName()
	{
		return internalName;
	}
	
	public String getName(int meta)
	{
		return internalName;
	}

}
