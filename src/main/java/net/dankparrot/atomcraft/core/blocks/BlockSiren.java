/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.blocks;

import net.dankparrot.atomcraft.core.reference.Names;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSiren extends BlockAC {
	
	public BlockSiren()
	{
		super(Names.Blocks.SIREN);
		this.setHardness(2.0F);
		this.setResistance(15F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 0);
		
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}
	
}
