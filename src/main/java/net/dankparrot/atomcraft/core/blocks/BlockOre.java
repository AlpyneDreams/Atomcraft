/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

import java.util.List;

import net.dankparrot.atomcraft.core.Atomcraft;
import net.dankparrot.atomcraft.core.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockOre extends BlockAC {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumOreType.class);
	
	public BlockOre()
	{
		super(Names.Blocks.ORE, Material.rock);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypePiston);
		// The default state is TYPE=URANIUM.
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumOreType.URANIUM));
		//this.setLightLevel(7F); - do this for uranium
		
	}
	
	@Override	// Adds the block's attributes.
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {TYPE});
	}
	
	@Override
	public String getName(int meta)
	{
		return EnumOreType.getType(meta).getName() + "_" + super.getName();
	}

	@Override	// Converts a meta integer to a block state.
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, EnumOreType.getType(meta));
	}

	@Override	// Converts a block state int a meta integer.
	public int getMetaFromState(IBlockState state) {
		EnumOreType type = (EnumOreType) state.getValue(TYPE);
		return type.getMeta();
	}
	
	@Override	// Registers the varients in the creative menu.
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
		//list.add(new ItemStack(item, 1, 1));
	}
	
	@Override
	public int getLightValue(IBlockAccess world, BlockPos pos)
	{
		return (int)(15.0F * EnumOreType.getType(this.getMetaFromState(world.getBlockState(pos))).getBlockLightLevel());
	}
}
