package com.mineden.mtest;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;


public class WorldOreGen implements IWorldGenerator{

    private final WorldGenMinable blockToGen;
    private final int dimensionId;
    private final int chances;
    private final int minHeight;
    private final int maxHeight;

    public WorldOreGen(Block block, int dimensionId, int chances, int veinSize, int minHeight, int maxHeight){
        this.blockToGen = new WorldGenMinable(block.getDefaultState(), veinSize);
        this.dimensionId = dimensionId;
        this.chances = chances;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public void genOverworld(World world, Random r, int cX, int cZ){
        int hdf = this.maxHeight - this.minHeight + 1;
        for(int i = 0; i < this.chances; i++){
            int x = cX * 16 + r.nextInt(16);
            int y = this.minHeight + r.nextInt(hdf);
            int z = cZ * 16 + r.nextInt(16);
            this.blockToGen.generate(world, r, new BlockPos(x, y, z));
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
            case 0:
                if(this.dimensionId == 0){
                    this.genOverworld(world, random, chunkX, chunkZ);
                }
        }
    }

    public void register(){
        GameRegistry.registerWorldGenerator(this, 0);
    }

}
