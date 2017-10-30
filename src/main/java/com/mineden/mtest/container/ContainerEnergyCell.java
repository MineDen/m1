package com.mineden.mtest.container;

import com.mineden.mtest.tileentity.AutoTEEnergy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class ContainerEnergyCell extends Container{

    private AutoTEEnergy te;

    public ContainerEnergyCell(IInventory playerInv, AutoTEEnergy te){
        int xPos = 8;
        int yPos = 104;

        // Player Inventory, Slot 9-35, Slot IDs 9-35
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
            }
        }

        // Player Inventory, Slot 0-8, Slot IDs 36-44
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !playerIn.isSpectator();
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack itemStack = null;
        Slot slot = this.inventorySlots.get(fromSlot);

        if(slot != null && slot.getHasStack()){
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            int cSlots = 0;

            if(fromSlot < cSlots && !this.mergeItemStack(itemStack1,
                    cSlots, inventorySlots.size(), true))
                return ItemStack.EMPTY;
            else if(!this.mergeItemStack(itemStack1, 0, cSlots, false))
                return ItemStack.EMPTY;
            if(itemStack1.getCount() == 0)
                slot.putStack(ItemStack.EMPTY);
            else slot.onSlotChanged();
            if(itemStack1.getCount() == itemStack.getCount())
                return ItemStack.EMPTY;
            slot.onTake(playerIn, itemStack1);
        }
        return itemStack;
    }

}
