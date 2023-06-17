/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class ItemHoe
extends Item {
    public ItemHoe(int i2, int j2) {
        super(i2);
        this.maxStackSize = 1;
        this.maxDamage = 32 << j2;
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i2, int j2, int k2, int l2) {
        int i1 = world.getBlockId(i2, j2, k2);
        Material material = world.getBlockMaterial(i2, j2 + 1, k2);
        if (!material.func_878_a() && i1 == Block.grass.blockID || i1 == Block.dirt.blockID) {
            Block block = Block.tilledField;
            world.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, block.stepSound.func_1145_d(), (block.stepSound.func_1147_b() + 1.0f) / 2.0f, block.stepSound.func_1144_c() * 0.8f);
            if (world.multiplayerWorld) {
                return true;
            }
            world.setBlockWithNotify(i2, j2, k2, block.blockID);
            itemstack.damageItem(1);
            if (world.rand.nextInt(8) == 0 && i1 == Block.grass.blockID) {
                int j1 = 1;
                for (int k1 = 0; k1 < j1; ++k1) {
                    float f2 = 0.7f;
                    float f1 = world.rand.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                    float f22 = 1.2f;
                    float f3 = world.rand.nextFloat() * f2 + (1.0f - f2) * 0.5f;
                    EntityItem entityitem = new EntityItem(world, (float)i2 + f1, (float)j2 + f22, (float)k2 + f3, new ItemStack(Item.seeds));
                    entityitem.field_805_c = 10;
                    world.entityJoinedWorld(entityitem);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull3D() {
        return true;
    }
}

