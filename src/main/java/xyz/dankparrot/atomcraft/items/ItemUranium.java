package xyz.dankparrot.atomcraft.items;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xyz.dankparrot.atomcraft.reference.EnumUraniumType;
import xyz.dankparrot.atomcraft.reference.Names;

public class ItemUranium extends ItemAC {
	
	public ItemUranium()
	{
		super(Names.Items.URANIUM, 64);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		
	}
	
	public void setEnrichmentPercent(ItemStack stack, float value)
	{
		NBTTagCompound cmpd = stack.getTagCompound();
		if (cmpd == null) {
			cmpd = new NBTTagCompound();
		}
		
		cmpd.setFloat("EnrichmentPercent", value);
		stack.setTagCompound(cmpd);
		
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
		return this.getUnlocalizedName() + "." + EnumUraniumType.fromMeta(stack.getItemDamage()).getName();
		// Format: item.uranium.highly_enriched
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, java.util.List<String> tooltip, boolean advanced)
	{
		if (stack.hasTagCompound() && stack.getItemDamage() != 15) {
			float percent = getEnrichmentPercent(stack);
			String percentStr = String.format("%.1f%% enriched", percent);
			
			tooltip.add(percentStr);
		}
		
	}
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return stack.getItemDamage() == EnumUraniumType.WEAPONS_GRADE.getMeta();
    }
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
	{
	    subItems.add(new ItemStack(itemIn, 1, 0));
	    subItems.add(new ItemStack(itemIn, 1, 1));
	    subItems.add(new ItemStack(itemIn, 1, 2));
	    subItems.add(new ItemStack(itemIn, 1, 3));
	    subItems.add(new ItemStack(itemIn, 1, 4));
	    // Depleted Uranium
	    subItems.add(new ItemStack(itemIn, 1, 15));
	    
	    for (ItemStack stack : subItems) {
	    	setEnrichmentPercent(stack, EnumUraniumType.fromMeta(stack.getMetadata()).getEnrichmentPercent());
	    }
	}
}
