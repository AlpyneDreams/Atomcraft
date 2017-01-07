
package xyz.dankparrot.atomcraft.blocks;

import net.minecraft.block.SoundType;
import xyz.dankparrot.atomcraft.reference.Names;

public class BlockConcrete extends BlockAC {
	
	public BlockConcrete()
	{
		super(Names.Blocks.CONCRETE);
		this.setHardness(3.0F);
		this.setResistance(6000F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 1); // stone pick
	}
	
}
