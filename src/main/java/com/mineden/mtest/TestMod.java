package com.mineden.mtest;

import com.mineden.mtest.blocks.MBlocks;
import com.mineden.mtest.gui.MGuiHandler;
import com.mineden.mtest.items.MItems;
import com.mineden.mtest.proxy.CommonProxy;
import com.mineden.mtest.recipes.RegRecipes;
import com.mineden.mtest.tileentity.MTileEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;


@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class TestMod {

    @SidedProxy(clientSide = ModInfo.CPROXY, serverSide = ModInfo.SPROXY)
    public static CommonProxy proxy;

    @Mod.Instance
    public static TestMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        MTileEntities.init();
        MTileEntities.register();
        MBlocks.init();
        MBlocks.register();
        MItems.init();
        MItems.register();
        RegRecipes.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new MGuiHandler());
        MBlocks.lead_ore_generator.register();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }

}
