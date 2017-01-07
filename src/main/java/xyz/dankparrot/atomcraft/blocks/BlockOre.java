
package xyz.dankparrot.atomcraft.blocks;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import xyz.dankparrot.atomcraft.reference.EnumOreType;
import xyz.dankparrot.atomcraft.reference.EnumUraniumType;
import xyz.dankparrot.atomcraft.reference.Names;



public class BlockOre extends BlockAC {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumOreType.class);
	
	public BlockOre()
	{
		super(Names.Blocks.ORE, Material.ROCK);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		this.setSoundType(SoundType.STONE);
		// The default state is TYPE=URANIUM.
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumOreType.URANIUM));
	}
	 
	@Override	// Adds the block's attributes.
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public String getName(int meta)
	{
		return EnumOreType.fromMeta(meta).getName() + "_" + this.getName();
	}

	@Override	// Converts a meta integer to a block state.
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, EnumOreType.fromMeta(meta));
	}

	@Override	// Converts a block state int a meta integer.
	public int getMetaFromState(IBlockState state) {
		EnumOreType type = (EnumOreType) state.getValue(TYPE);
		return type.getMeta();
	}
	
	@Override	// Registers the varients in the creative menu.
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
	}
	
	@Override	// Uranium ore should emitt a faint light
	public int getLightValue(IBlockState state)
	{
		// TODO maybe implement this more like redstone ore, i.e. ticks and particles?
		return (int)(15.0F * EnumOreType.fromMeta(this.getMetaFromState(state)).getBlockLightLevel());
	}
}
