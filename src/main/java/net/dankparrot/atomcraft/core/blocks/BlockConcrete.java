/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

import net.dankparrot.atomcraft.core.reference.Names;

public class BlockConcrete extends BlockAC {
	
	public BlockConcrete()
	{
		super(Names.Blocks.CONCRETE);
		this.setHardness(3.0F);
		this.setResistance(6000F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1); // stone pick
	}
	
}
