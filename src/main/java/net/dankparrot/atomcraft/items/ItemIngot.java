/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.items;

import java.util.List;

import net.dankparrot.atomcraft.reference.Names;
import net.dankparrot.atomcraft.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemIngot extends ItemAC {
	
	public IIcon[] icons = new IIcon[Names.Ores.TYPES.length];
	
	public ItemIngot()
	{
		super(Names.Items.INGOT, 64);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IIconRegister reg)
	{
		for (int i = 0; i < this.icons.length; i++)
		{
			// Format: "atomcraft:uraniumDust"
			this.icons[i] = reg.registerIcon(Reference.MODID + ":" + Names.Ores.TYPES[i] + "Ingot");
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if (meta >= Names.Ores.TYPES.length)
			meta = 0;
		
		return this.icons[meta];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < Names.Ores.TYPES.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int meta = stack.getItemDamage();
		if (meta >= Names.Ores.TYPES.length)
			meta = 0;
		return this.getUnlocalizedName() + "." + Names.Ores.TYPES[meta];
	}

}
