/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.reference;

import net.minecraft.world.Explosion;

public enum EnumExplosives {
	;
	
	private int meta;
	private String name;
	private Explosion explosion;
	
	private EnumExplosives(int meta, String name, Explosion explosion)
	{
		this.meta = meta;
		this.name = name;
		this.explosion = explosion;
	}
}
