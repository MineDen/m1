package com.mineden.mtest;

/**
 * com.mineden.mtest: Created in m1 on 28.10.2017-18:41.
 */
public class MEnergyStorage {

    private int energy = 0;
    private int capacity;
    private int transferSpeed;

    public MEnergyStorage(int capacity, int transferSpeed){
        this.capacity = capacity;
        this.transferSpeed = transferSpeed;
    }

    public int getEnergy(){
        return this.energy;
    }

    public void setEnergy(int energy){
        if(energy >= 0 && energy <= this.capacity)
            this.energy = energy;
        else if(energy < 0)
            this.energy = 0;
        else this.energy = this.capacity;
    }

    public int addEnergy(int energy){
        int e = Math.min(this.transferSpeed, energy);
        if(this.energy + e <= this.capacity)
            this.energy = this.energy + e;
        else if(this.energy + e > this.capacity)
            this.energy = this.capacity;
        return this.energy;
    }

    public int removeEnergy(int energy){
        int e = Math.min(this.transferSpeed, energy);
        if(this.energy - e >= 0)
            this.energy = this.energy - e;
        else if(this.energy - e < 0)
            this.energy = 0;
        return this.energy;
    }

}
