package com.mineden.mtest.gui;

import com.mineden.mtest.container.ContainerEnergyCell;
import com.mineden.mtest.tileentity.AutoTEEnergy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;


public class MGuiHandler implements IGuiHandler {

    public static final int ENERGY_CELL_GUI = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == ENERGY_CELL_GUI) return new ContainerEnergyCell(player.inventory, (AutoTEEnergy) te);
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if(ID == ENERGY_CELL_GUI) return new GuiEnergyCell(player.inventory, (AutoTEEnergy) te);
        return null;
    }
}
