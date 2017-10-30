package com.mineden.mtest.recipes;

import com.mineden.mtest.blocks.MBlocks;
import com.mineden.mtest.items.MItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

/**
 * com.mineden.mtest: Created in m1 on 21.10.2017-20:27.
 */
public class RegRecipes {

    public static void register(){
        MBlocks.machine_case.addShapedCraft("machine_case",
                "###",
                "#y#",
                "###",
                '#', new ItemStack(MItems.lead_ingot),
                'y', new ItemStack(Items.REDSTONE));
        MBlocks.lead_block.addShapedCraft("lead_block",
                "###",
                "###",
                "###",
                '#', new ItemStack(MItems.lead_ingot));
        MItems.lead_ingot.addShapelessCraft("lead_ingot", 9,
                (Ingredient[]) new Ingredient[]{Ingredient.fromStacks(new ItemStack(Item.getItemFromBlock(MBlocks.lead_block)))});
        MItems.lead_ingot.addSmelting(Item.getItemFromBlock(MBlocks.lead_ore));

    }

}
