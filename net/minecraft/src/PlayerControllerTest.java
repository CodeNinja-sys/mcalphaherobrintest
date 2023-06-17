/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PlayerController;
import net.minecraft.src.Session;
import net.minecraft.src.World;

public class PlayerControllerTest
extends PlayerController {
    public PlayerControllerTest(Minecraft minecraft) {
        super(minecraft);
        this.field_1064_b = true;
    }

    @Override
    public void func_6473_b(EntityPlayer entityplayer) {
        for (int i2 = 0; i2 < 9; ++i2) {
            if (entityplayer.inventory.mainInventory[i2] == null) {
                this.mc.thePlayer.inventory.mainInventory[i2] = new ItemStack(((Block)Session.registeredBlocksList.get((int)i2)).blockID);
                continue;
            }
            this.mc.thePlayer.inventory.mainInventory[i2].stackSize = 1;
        }
    }

    @Override
    public boolean func_6469_d() {
        return false;
    }

    @Override
    public void func_717_a(World world) {
        super.func_717_a(world);
    }

    @Override
    public void func_6474_c() {
    }
}

