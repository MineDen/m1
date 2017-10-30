package com.mineden.mtest.gui;

import com.mineden.mtest.ModInfo;
import com.mineden.mtest.container.ContainerEnergyCell;
import com.mineden.mtest.tileentity.AutoTEEnergy;
import net.minecraft.block.BlockChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.energy.CapabilityEnergy;


public class GuiEnergyCell extends GuiContainer {

    private final AutoTEEnergy te;
    private final ResourceLocation texture;
    int opx = 10000 / 69;

    public GuiEnergyCell(IInventory playerInv, AutoTEEnergy te) {
        super(new ContainerEnergyCell(playerInv, te));

        this.xSize = 176;
        this.ySize = 185;
        this.te = te;
        this.texture = new ResourceLocation(ModInfo.MOD_ID, "textures/gui/container/energy_cell.png");
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(texture);
        int centerX = width / 2 - this.xSize / 2;
        int centerY = height / 2 - this.ySize / 2;
        drawTexturedModalRect(centerX, centerY, 0, 0, this.xSize, this.ySize);
        int energyY = Math.round(te.storage.getEnergy() / opx);
        drawTexturedModalRect(centerX + 7, centerY + 7 + (69 - energyY), 34, 255 - energyY, 16, energyY);
        drawHoveringText("Stored: " + te.storage.getEnergy() + "RF/10000RF", mouseX, mouseY);
        String contName = I18n.format("container.energy_cell");
        int cnW = fontRenderer.getStringWidth(contName);
        int cnX = width / 2 - cnW / 2;
        int cnY = centerY + 6;
        fontRenderer.drawString(contName, cnX, cnY, 4210752);
    }

}
