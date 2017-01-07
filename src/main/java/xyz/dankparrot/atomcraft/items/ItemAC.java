package xyz.dankparrot.atomcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xyz.dankparrot.atomcraft.Atomcraft;
import xyz.dankparrot.atomcraft.creativetabs.ModCreativeTabs;

public abstract class ItemAC extends Item
{

	private String name;
	
	public ItemAC(String name, int maxStackSize)
	{
		this.name = name;
		
		setMaxStackSize(maxStackSize);
		setCreativeTab(ModCreativeTabs.AC_TAB);
		
		setRegistryName(name);
		setUnlocalizedName(name);
	}
	
	public ItemAC(String name)
	{
		this(name, 64);
	}
	
	@Override
	public ItemAC setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
	
	public String getName() { return name; }
	public String getName(int meta) { return name; }
}
