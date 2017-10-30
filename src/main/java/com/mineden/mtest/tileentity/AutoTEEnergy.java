package com.mineden.mtest.tileentity;

import com.mineden.mtest.MEnergyStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;


public class AutoTEEnergy extends TileEntity implements ITickable{

    public MEnergyStorage storage;
    private int capacity = 10000;
    private int transferSpeed = 100;

    public AutoTEEnergy(int capacity, int transferSpeed){
        storage = new MEnergyStorage(capacity, transferSpeed);
        this.capacity = capacity;
        this.transferSpeed = transferSpeed;
    }

    @Override
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt){
        nbt.setInteger("Energy", this.storage.getEnergy());
        super.writeToNBT(nbt);
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt){
        int energy = nbt.getInteger("Energy");
        storage = new MEnergyStorage(this.capacity, this.transferSpeed);
        this.storage.setEnergy(energy);
        super.readFromNBT(nbt);
    }

    @Override
    public void update(){
        if(this.world != null && this.world.isRemote){
            this.storage.addEnergy(1);
            this.markDirty();
        }
    }

}