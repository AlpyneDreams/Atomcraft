/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.blocks;

import net.dankparrot.atomcraft.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAC extends Block {
	
	public BlockAC(String unlocalizedName, Material material)
	{
		super(material);
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(Reference.MODID + ":" + unlocalizedName);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}
	
	public BlockAC(String unlocalizedName)
	{
		this(unlocalizedName, Material.rock);
	}
}
