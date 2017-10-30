package com.mineden.mtest.items;

import com.mineden.mtest.ModInfo;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class AutoPickaxe extends ItemPickaxe{

    protected AutoPickaxe(ToolMaterial material) {
        super(material);
    }

    public void register(String unlocName){
        this.setUnlocalizedName(unlocName);
        this.setRegistryName(this.getUnlocalizedName().substring(5));
        ForgeRegistries.ITEMS.register(this);
        ModelResourceLocation MRL = new ModelResourceLocation(ModInfo.MOD_ID + ":" + this.getUnlocalizedName().substring(5), "invertory");
        ModelLoader.setCustomModelResourceLocation(this, 0, MRL);
    }

    public void addShapedCraft(String craftName, int count, Object... input){
        ResourceLocation name = new ResourceLocation(ModInfo.MOD_ID + ":" + craftName);
        ItemStack recipeIS = new ItemStack(this, count);
        GameRegistry.addShapedRecipe(name, null, recipeIS, input);
    }

    public void addShapelessCraft(String craftName, int count, Ingredient... ingredients){
        ResourceLocation name = new ResourceLocation(ModInfo.MOD_ID + ":" + craftName);
        ItemStack recipeIS = new ItemStack(this, count);
        GameRegistry.addShapelessRecipe(name, null, recipeIS, ingredients);
    }

    public void addSmelting(Item input){
        ItemStack outputIS = new ItemStack(this, 1);
        ItemStack inputIS = new ItemStack(input, 1);
        GameRegistry.addSmelting(inputIS, outputIS, 0.8F);
    }

}
