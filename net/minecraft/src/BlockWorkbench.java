/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockWorkbench
extends Block {
    protected BlockWorkbench(int i2) {
        super(i2, Material.wood);
        this.blockIndexInTexture = 59;
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 1) {
            return this.blockIndexInTexture - 16;
        }
        if (i2 == 0) {
            return Block.planks.getBlockTextureFromSide(0);
        }
        if (i2 == 2 || i2 == 4) {
            return this.blockIndexInTexture + 1;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public boolean blockActivated(World world, int i2, int j2, int k2, EntityPlayer entityplayer) {
        entityplayer.displayWorkbenchGUI();
        return true;
    }
}

