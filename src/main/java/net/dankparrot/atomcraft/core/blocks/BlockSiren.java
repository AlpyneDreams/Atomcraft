/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

import java.util.List;

import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.Names;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockSiren extends BlockAC {
	
	public static final PropertyEnum STATE = PropertyEnum.create("state", EnumSiren.class);
	
	public BlockSiren()
	{
		super(Names.Blocks.SIREN);
		this.setHardness(2.0F);
		this.setResistance(15F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		// The default state is state=off
		this.setDefaultState(this.blockState.getBaseState().withProperty(STATE, EnumSiren.OFF));
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {STATE});
	}
	
	@Override	// Converts a meta integer to a block state.
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(STATE, EnumSiren.fromMeta(meta));
	}

	@Override	// Converts a block state int a meta integer.
	public int getMetaFromState(IBlockState state) {
		EnumSiren type = (EnumSiren)state.getValue(STATE);
		return type.getMeta();
	}
	
	@Override	// Registers the varients in the creative menu.
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	public enum EnumSiren implements IStringSerializable
	{
		OFF(0, "off"), ON(1, "on");
		
		private int meta;
		private String name;
		
		private EnumSiren(int meta, String name)
		{
			this.meta = meta;
			this.name = name;
		}
		
		public static EnumSiren fromMeta(int meta)
		{
			for (EnumSiren i : EnumSiren.values())
			{
				if (i.getMeta() == meta)
					return i;
			}
			return null; // TODO can we return this.fromMeta(0) [also applies to EnumOreType]?
		}
		
		public int getMeta()
		{
			return meta;
		}
		
		@Override
		public String getName() {
			return name;
		}
		
		public String toString()
		{
			return getName();
		}
		
	}
}
