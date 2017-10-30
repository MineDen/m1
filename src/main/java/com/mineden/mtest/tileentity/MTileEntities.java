package com.mineden.mtest.tileentity;

import com.mineden.mtest.blocks.AutoBlockEnergy;
import com.mineden.mtest.gui.MGuiHandler;
import net.minecraft.creativetab.CreativeTabs;


public class MTileEntities {

    public static AutoBlockEnergy energy_cell_te;

    public static void init(){
        energy_cell_te = new AutoBlockEnergy("energy_cell", CreativeTabs.DECORATIONS, 2.8F, MGuiHandler.ENERGY_CELL_GUI);

    }

    public static void register(){
        energy_cell_te.register();
    }

}
