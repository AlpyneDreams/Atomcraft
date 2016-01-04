/****************************************
		© 2016 Dank Parrot
****************************************/

package net.dankparrot.atomcraft.core.client.gui;

import net.dankparrot.atomcraft.core.containers.ContainerAC;
import net.dankparrot.atomcraft.core.containers.ContainerCentrifuge;
import net.dankparrot.atomcraft.core.reference.Reference;
import net.dankparrot.atomcraft.core.tileentity.TileEntityCentrifuge;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiCentrifuge extends GuiContainer {
	
	private IInventory playerInv;
	private TileEntityCentrifuge tileEnt;
	
	public GuiCentrifuge(IInventory playerInv, TileEntityCentrifuge te)
	{
		super(new ContainerCentrifuge(playerInv, te));
		
		this.playerInv = playerInv;
		this.tileEnt = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/gui/container/centrifuge.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	    String s = this.tileEnt.getDisplayName().getUnformattedText();
	    this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
	    this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
	}

}
