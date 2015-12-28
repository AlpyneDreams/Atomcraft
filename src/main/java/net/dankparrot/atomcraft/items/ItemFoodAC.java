/****************************************
		© 2015 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.dankparrot.atomcraft.creativetabs.ModCreativeTabs;
import net.dankparrot.atomcraft.reference.Reference;

public class ItemFoodAC extends ItemFood {
	
	public ItemFoodAC(String unlocalizedName, int healAmount, float saturationMod, boolean wolvesFavorite)
	{
		super(healAmount, saturationMod, wolvesFavorite);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(Reference.MODID + ":" + unlocalizedName);
		this.setCreativeTab(ModCreativeTabs.AC_TAB);
	}

}
