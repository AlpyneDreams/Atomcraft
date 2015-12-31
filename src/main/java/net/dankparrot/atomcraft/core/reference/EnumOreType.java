/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.reference;

import net.minecraft.util.IStringSerializable;

public enum EnumOreType implements IStringSerializable {
	URANIUM(0, "uranium", 7F);
	
	private int meta;
	private String name;
	private float lightLevel;
	
	private EnumOreType(int meta, String name, float lightLevel)
	{
		this.meta = meta;
		this.name = name;
		this.lightLevel = lightLevel;
	}
	
	private EnumOreType(int meta, String name)
	{
		this(meta, name, 0F);
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	/**
	 * Note: This function is a <u>placeholder</u>, it is
	 * not yet implemented.
	 * <p>
	 * Returns an EnumOreType based on the ore's metadata.
	 * @param meta The block ore item's metadata.
	 * @return The ore type.
	 */
	public static EnumOreType getType(int meta)
    {
		// TODO implement this function
		return URANIUM;
    }
	
	/**
	 * @return The ore type's metadata.
	 */
	public int getMeta()
	{
		return this.meta;
	}
	
	/**
	 * @return The ore block's light level.
	 */
	public float getBlockLightLevel()
	{
		return this.lightLevel;
	}
}
