/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.items;

import java.util.List;
import java.util.Random;

import com.google.common.base.CaseFormat;

import net.dankparrot.atomcraft.core.reference.Names;
import net.dankparrot.atomcraft.core.reference.EnumOreType;
import net.dankparrot.atomcraft.core.reference.EnumUraniumType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUranium extends ItemAC {
	
	public ItemUranium()
	{
		super(Names.Items.URANIUM, 64);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		
		NBTTagCompound tagCompound = stack.getTagCompound();
		
		tagCompound.setFloat("EnrichmentPercent", EnumUraniumType.NATURAL.getEnrichmentPercent());
	}
	
	public void setEnrichmentPercent(ItemStack stack, float value)
	{
		stack.getTagCompound().setFloat("EnrichmentPercent", value);
		stack.setItemDamage(EnumUraniumType.fromPercentEnriched(value).getMeta());
	}
	
	public float getEnrichmentPercent(ItemStack stack)
	{
		return stack.getTagCompound().getFloat("EnrichmentPercent");
	}
	
	@Override
	public String getName(int meta)
	{
		return EnumUraniumType.fromMeta(meta).getName() + "_" + this.getName();
		// Format: highly_enriched_uranium
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName() + "." + EnumUraniumType.fromMeta(stack.getItemDamage()).getUnlocalizedName();
		// Format: item.uranium.highlyEnriched
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean isAdvanced)
	{
		if (stack.hasTagCompound() && stack.getItemDamage() != 15)
		{
			float percent = stack.getTagCompound().getFloat("EnrichmentPercent");
			String percentStr = String.format("%.1f%% ", percent);
			String tooltipStr = this.getTooltip("enriched");
			
			tooltip.add(EnumChatFormatting.GRAY + percentStr + tooltipStr);
		}
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
	    subItems.add(new ItemStack(itemIn, 1, 0));
	    subItems.add(new ItemStack(itemIn, 1, 1));
	    subItems.add(new ItemStack(itemIn, 1, 2));
	    subItems.add(new ItemStack(itemIn, 1, 3));
	    subItems.add(new ItemStack(itemIn, 1, 4));
	    // Depleted Uranium
	    subItems.add(new ItemStack(itemIn, 1, 15));
	}
}
