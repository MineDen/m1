package com.mineden.mtest.items;

import com.mineden.mtest.ToolMaterials;
import net.minecraft.creativetab.CreativeTabs;


public class MItems {

    public static AutoItem lead_ingot;
    private static AutoItem energy_controller;
    private static AutoItem energy_display;
    public static AutoShovel lead_shovel;
    public static AutoPickaxe lead_pickaxe;
    public static AutoAxe lead_axe;
    public static AutoSword lead_sword;
    public static AutoHoe lead_hoe;

    public static void init(){
        lead_ingot = new AutoItem("lead_ingot", CreativeTabs.MATERIALS, 64);
        energy_controller = new AutoItem("energy_controller", CreativeTabs.REDSTONE, 16);
        energy_display = new AutoItem("energy_display", CreativeTabs.REDSTONE, 16);
        lead_shovel = new AutoShovel(ToolMaterials.LEAD);
        lead_pickaxe = new AutoPickaxe(ToolMaterials.LEAD);
        lead_axe = new AutoAxe(ToolMaterials.LEAD, 8.0F, -3.0F);
        lead_sword = new AutoSword(ToolMaterials.LEAD);
        lead_hoe = new AutoHoe(ToolMaterials.LEAD);
    }

    public static void register(){
        lead_ingot.register();
        energy_controller.register();
        energy_display.register();
        lead_shovel.register("lead_shovel");
        lead_pickaxe.register("lead_pickaxe");
        lead_axe.register("lead_axe");
        lead_sword.register("lead_sword");
        lead_hoe.register("lead_hoe");
    }

}
