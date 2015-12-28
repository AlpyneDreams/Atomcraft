/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.dankparrot.atomcraft.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.reference.Names;
import net.dankparrot.atomcraft.reference.Reference;


public class BlockOre extends BlockAC {
	
	public IIcon[] icons = new IIcon[Names.Ores.TYPES.length];
	
	public BlockOre()
	{
		super(Names.Blocks.ORE, Material.rock);
		this.setHardness(3F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg)
	{
		for (int i = 0; i < this.icons.length; i++)
		{
			// Format: "atomcraft:uraniumOre"
			this.icons[i] = reg.registerIcon(Reference.MODID + ":" + Names.Ores.TYPES[i] + "Ore");
		}
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (meta >= Names.Ores.TYPES.length)
			return icons[0];
		return icons[meta];
	}
	
	public float getBlockHardness(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (meta >= Names.Ores.TYPES.length)
			meta = 0;
		
		return 3.0F;
	}
	
	@Override
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativetabs, List list)
	{
		// For each ore type, add a new subblock
		for (int i = 0; i < Names.Ores.TYPES.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
}
