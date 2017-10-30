package com.mineden.mtest.blocks;

import com.mineden.mtest.ModInfo;
import com.mineden.mtest.TestMod;
import com.mineden.mtest.tileentity.AutoTEEnergy;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class AutoBlockEnergy extends Block implements ITileEntityProvider {

    private int guiId;

    public AutoBlockEnergy(String unlocName, CreativeTabs creativeTab, float hardness, int guiId) {
        super(Material.ROCK);
        this.setUnlocalizedName(unlocName);
        this.setRegistryName(this.getUnlocalizedName().substring(5));
        this.setCreativeTab(creativeTab);
        this.setHardness(hardness);
        this.setHarvestLevel("pickaxe", 0);
        this.guiId = guiId;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AutoTEEnergy(10000, 100);
    }

    public void register() {
        ForgeRegistries.BLOCKS.register(this);
        Item iBlock = new ItemBlock(this);
        iBlock.setRegistryName(this.getRegistryName());
        ForgeRegistries.ITEMS.register(iBlock);
        GameRegistry.registerTileEntity(AutoTEEnergy.class, this.getUnlocalizedName().substring(5));
        ModelResourceLocation MRL = new ModelResourceLocation(ModInfo.MOD_ID + ":" + iBlock.getUnlocalizedName().substring(5), "invertory");
        ModelLoader.setCustomModelResourceLocation(iBlock, 0, MRL);
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
                                    EnumHand hand, EnumFacing side,
                                    float hitX, float hitY, float hitZ){
        if(!world.isRemote && pos != null) {
            player.sendMessage(new TextComponentString("AutoBlockEnergy activated"));
            player.openGui(TestMod.instance, this.guiId, world, pos.getX(), pos.getY(), pos.getZ());
        }
        else{
            if(pos != null) {
                player.openGui(TestMod.instance, this.guiId, world, pos.getX(), pos.getY(), pos.getZ());
            }
        }
        return true;
    }

}
