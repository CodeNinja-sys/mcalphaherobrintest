/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockTNT
extends Block {
    public BlockTNT(int i2, int j2) {
        super(i2, j2, Material.tnt);
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 0) {
            return this.blockIndexInTexture + 2;
        }
        if (i2 == 1) {
            return this.blockIndexInTexture + 1;
        }
        return this.blockIndexInTexture;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        if (l2 > 0 && Block.blocksList[l2].canProvidePower() && world.isBlockIndirectlyGettingPowered(i2, j2, k2)) {
            this.onBlockDestroyedByPlayer(world, i2, j2, k2, 0);
            world.setBlockWithNotify(i2, j2, k2, 0);
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int i2, int j2, int k2) {
        EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f);
        entitytntprimed.fuse = world.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
        world.entityJoinedWorld(entitytntprimed);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int i2, int j2, int k2, int l2) {
        if (world.multiplayerWorld) {
            return;
        }
        EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(world, (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f);
        world.entityJoinedWorld(entitytntprimed);
        world.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0f, 1.0f);
    }
}

