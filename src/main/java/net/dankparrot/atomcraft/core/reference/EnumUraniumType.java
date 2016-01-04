/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.reference;

import com.google.common.base.CaseFormat;

import net.minecraft.util.IStringSerializable;

/**
 * Enumeration for Different Types of Uranium:<br>
 * 	0 - Natural (0.7%)<br>
 * 	1 - Slightly Enriched (> 0.9%)<br>
 *  2 - Low-Enriched (> 2%)<br>
 *  3 - Highly-Enriched (> 20%) (a.k.a. Weapons-Usable)<br>
 *  4 - Weapons-Grade (> 85%)<br>
 *  <br>
 *  15 - Depleted (0.3%)
 */
// Really messy enrichment code, WIP
public enum EnumUraniumType implements IStringSerializable {
	NATURAL(0, 0.7f, "natural"),
	SLIGHTLY_ENRICHED(1, 0.9f, "slightlyEnriched"),
	LOW_ENRICHED(2, 2f, "lowEnriched"),
	HIGHLY_ENRICHED(3, 20f, "highlyEnriched"),
	WEAPONS_GRADE(4, 85f, "weaponsGrade"),
	DEPLETED(15, 0f, "depleted");
	
	private int meta;
	private float percent;
	private String unlocalizedName;
	private String internalName;
	
	private EnumUraniumType(int meta, float percent, String name)
	{
		this.meta = meta;
		this.percent = percent;
		this.unlocalizedName = name;
		this.internalName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
	}
	
	@Override
	public String getName()
	{
		return this.internalName;
	}
	
	public String getUnlocalizedName()
	{
		return this.unlocalizedName;
	}
	
	@Override
	public String toString()
	{
		return this.getName();
	}
	
	/**
	 * Returns an EnumUraniumType based on the sample's metadata.
	 * @param meta The uranium sample's metadata.
	 * @return The uranium type. Returns null if not found.
	 */
	public static EnumUraniumType fromMeta(int meta)
    {
		for (EnumUraniumType u : EnumUraniumType.values())
		{
			if(u.meta == meta)
				return u;
		}
		return null;
    }
	
	/**
	 * Returns an EnumUraniumType based on enrichment percent.
	 * @param percent The enrichment percent of the uranium.
	 * @return The uranium type. Returns null if invalid type.
	 */
	public static EnumUraniumType fromPercentEnriched(float percent)
	{
		// TODO need a better way to convert % enriched -> uranium type
		if (percent == 0f)
			return DEPLETED;
		if (percent == 0.7f)
			return NATURAL;
		
		if (percent >= 85f)
			return WEAPONS_GRADE;
		if (percent < 85f && percent >= 20f)
			return HIGHLY_ENRICHED;
		if (percent < 20f && percent >= 2f)
			return LOW_ENRICHED;
		if (percent < 2f && percent >= 0.9f)
			return SLIGHTLY_ENRICHED;
		
		return null;
	}
	
	/**
	 * @return The minimum (or only) enrichment percent for the type of uranium.
	 */
	public float getEnrichmentPercent()
	{
		return this.percent;
	}
	
	/**
	 * @return The uranium type's block/item metadata.
	 */
	public int getMeta()
	{
		return this.meta;
	}
}
