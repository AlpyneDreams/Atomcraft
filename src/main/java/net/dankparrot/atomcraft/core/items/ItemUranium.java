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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.LanguageRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUranium extends ItemAC {
	
	private static final float NATURAL_URANIUM = 0.7f;
	
	public ItemUranium()
	{
		super(Names.Items.URANIUM, 64);
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getName(int meta)
	{
		
		return EnumUraniumType.fromMeta(0).getName() + "_" + this.getName();
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		
		NBTTagCompound tagCompound = stack.getTagCompound();
		
		tagCompound.setFloat("EnrichmentPercent", EnumUraniumType.NATURAL.getEnrichmentPercent());
	}
	
	// TODO When EnrichmentPercent changes, the ItemStack's metadata should change
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName() + "." + EnumUraniumType.fromMeta(stack.getItemDamage()).getUnlocalizedName();
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List tooltip, boolean isAdvanced)
	{
		if (stack.hasTagCompound())
		{
			// messy stuff here:
			float percent = stack.getTagCompound().getFloat("EnrichmentPercent");
			String percentStr = String.format("%.1f", percent);
			String format = StatCollector.translateToLocal("tooltip." + Names.Items.URANIUM + ".enrichment");
			
			tooltip.add(EnumChatFormatting.GRAY + String.format(format, percentStr));
		}
	}
}
