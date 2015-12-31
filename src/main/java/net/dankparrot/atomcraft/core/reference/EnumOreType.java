/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.reference;

import net.minecraft.util.IStringSerializable;

public enum EnumOreType implements IStringSerializable {
	URANIUM(0, "uranium", 7F);
	
	// Lookup table for metadata.
    private static final EnumOreType[] META_LOOKUP = new EnumOreType[values().length];
	
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
	 * Returns an EnumOreType based on the ore's metadata.
	 * @param meta The block ore item's metadata.
	 * @return The ore type.
	 */
	public static EnumOreType getType(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
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
