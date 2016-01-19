/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.explosion;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface IExplosion {
	
	public void explode(World worldIn, BlockPos pos);
	
}
