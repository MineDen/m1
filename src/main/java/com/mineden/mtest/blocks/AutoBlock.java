package com.mineden.mtest.blocks;

import com.mineden.mtest.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class AutoBlock extends Block{

    public AutoBlock(MapColor blockMapColorIn, String unlocName, CreativeTabs creativeTab, float hardness) {
        super(Material.ROCK, blockMapColorIn);
        this.setUnlocalizedName(unlocName);
        this.setRegistryName(this.getUnlocalizedName().substring(5));
        this.setCreativeTab(creativeTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", 0);
    }

    public void register(){
        ForgeRegistries.BLOCKS.register(this);
        Item iBlock = new ItemBlock(this);
        iBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(iBlock);
        ModelResourceLocation MRL = new ModelResourceLocation(ModInfo.MOD_ID + ":" + iBlock.getUnlocalizedName().substring(5), "invertory");
        ModelLoader.setCustomModelResourceLocation(iBlock, 0, MRL);
    }

    public void addShapedCraft(String craftName, Object... input){
        ResourceLocation name = new ResourceLocation(ModInfo.MOD_ID + ":" + craftName);
        ItemStack recipeIS = new ItemStack(Item.getItemFromBlock(this), 1);
        GameRegistry.addShapedRecipe(name, null, recipeIS, input);
    }

    public void addShapelessCraft(String craftName, Ingredient... ingredients){
        ResourceLocation name = new ResourceLocation(ModInfo.MOD_ID + ":" + craftName);
        ItemStack recipeIS = new ItemStack(Item.getItemFromBlock(this), 1);
        GameRegistry.addShapelessRecipe(name, null, recipeIS, ingredients);
    }

    public void addSmelting(Item input){
        ItemStack outputIS = new ItemStack(Item.getItemFromBlock(this), 1);
        ItemStack inputIS = new ItemStack(input, 1);
        GameRegistry.addSmelting(inputIS, outputIS, 0.8F);
    }

}
