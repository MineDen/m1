package com.mineden.mtest.blocks;

import com.mineden.mtest.WorldOreGen;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class MBlocks {

    public static AutoBlock lead_ore;
    public static WorldOreGen lead_ore_generator;
    public static AutoBlock lead_block;
    public static AutoBlock machine_case;

    public static void init(){
        lead_ore = new AutoBlock(MapColor.IRON, "lead_ore", CreativeTabs.BUILDING_BLOCKS, 4.5F);
        lead_ore_generator = new WorldOreGen(lead_ore, 0, 22, 10, 0, 72);
        lead_block = new AutoBlock(MapColor.IRON, "lead_block", CreativeTabs.BUILDING_BLOCKS, 3.5F);
        machine_case = new AutoBlock(MapColor.GRAY, "machine_case", CreativeTabs.DECORATIONS, 2.8F);
    }

    public static void register(){
        lead_ore.register();
        lead_block.register();
        machine_case.register();
    }

}
