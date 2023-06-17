/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemBlock
extends Item {
    private int blockID;

    public ItemBlock(int i2) {
        super(i2);
        this.blockID = i2 + 256;
        this.setIconIndex(Block.blocksList[i2 + 256].getBlockTextureFromSide(2));
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        if (world.getBlockId(i2, j2, k2) == Block.snow.blockID) {
            l2 = 0;
        } else {
            if (l2 == 0) {
                --j2;
            }
            if (l2 == 1) {
                ++j2;
            }
            if (l2 == 2) {
                --k2;
            }
            if (l2 == 3) {
                ++k2;
            }
            if (l2 == 4) {
                --i2;
            }
            if (l2 == 5) {
                ++i2;
            }
        }
        if (itemstack.stackSize == 0) {
            return false;
        }
        if (world.canBlockBePlacedAt(this.blockID, i2, j2, k2, false)) {
            Block block = Block.blocksList[this.blockID];
            if (world.setBlockWithNotify(i2, j2, k2, this.blockID)) {
                Block.blocksList[this.blockID].onBlockPlaced(world, i2, j2, k2, l2);
                Block.blocksList[this.blockID].onBlockPlacedBy(world, i2, j2, k2, entityplayer);
                world.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, block.stepSound.func_1145_d(), (block.stepSound.func_1147_b() + 1.0f) / 2.0f, block.stepSound.func_1144_c() * 0.8f);
                --itemstack.stackSize;
            }
        }
        return true;
    }
}

