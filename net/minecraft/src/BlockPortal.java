/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPortal
extends BlockBreakable {
    public BlockPortal(int i2, int j2) {
        super(i2, j2, Material.field_4260_x, false);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        if (iblockaccess.getBlockId(i2 - 1, j2, k2) == this.blockID || iblockaccess.getBlockId(i2 + 1, j2, k2) == this.blockID) {
            float f2 = 0.5f;
            float f22 = 0.125f;
            this.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f22, 0.5f + f2, 1.0f, 0.5f + f22);
        } else {
            float f1 = 0.125f;
            float f3 = 0.5f;
            this.setBlockBounds(0.5f - f1, 0.0f, 0.5f - f3, 0.5f + f1, 1.0f, 0.5f + f3);
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean tryToCreatePortal(World world, int i2, int j2, int k2) {
        int l2 = 0;
        int i1 = 0;
        if (world.getBlockId(i2 - 1, j2, k2) == Block.obsidian.blockID || world.getBlockId(i2 + 1, j2, k2) == Block.obsidian.blockID) {
            l2 = 1;
        }
        if (world.getBlockId(i2, j2, k2 - 1) == Block.obsidian.blockID || world.getBlockId(i2, j2, k2 + 1) == Block.obsidian.blockID) {
            i1 = 1;
        }
        System.out.println(l2 + ", " + i1);
        if (l2 == i1) {
            return false;
        }
        if (world.getBlockId(i2 - l2, j2, k2 - i1) == 0) {
            i2 -= l2;
            k2 -= i1;
        }
        for (int j1 = -1; j1 <= 2; ++j1) {
            for (int l1 = -1; l1 <= 3; ++l1) {
                boolean flag;
                boolean bl2 = flag = j1 == -1 || j1 == 2 || l1 == -1 || l1 == 3;
                if (!(j1 != -1 && j1 != 2 || l1 != -1 && l1 != 3)) continue;
                int j22 = world.getBlockId(i2 + l2 * j1, j2 + l1, k2 + i1 * j1);
                if (!(flag ? j22 != Block.obsidian.blockID : j22 != 0 && j22 != Block.fire.blockID)) continue;
                return false;
            }
        }
        world.field_1043_h = true;
        for (int k1 = 0; k1 < 2; ++k1) {
            for (int i22 = 0; i22 < 3; ++i22) {
                world.setBlockWithNotify(i2 + l2 * k1, j2 + i22, k2 + i1 * k1, Block.portal.blockID);
            }
        }
        world.field_1043_h = false;
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        boolean flag1;
        int l1;
        int i1 = 0;
        int j1 = 1;
        if (world.getBlockId(i2 - 1, j2, k2) == this.blockID || world.getBlockId(i2 + 1, j2, k2) == this.blockID) {
            i1 = 1;
            j1 = 0;
        }
        int k1 = j2;
        while (world.getBlockId(i2, k1 - 1, k2) == this.blockID) {
            --k1;
        }
        if (world.getBlockId(i2, k1 - 1, k2) != Block.obsidian.blockID) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
        for (l1 = 1; l1 < 4 && world.getBlockId(i2, k1 + l1, k2) == this.blockID; ++l1) {
        }
        if (l1 != 3 || world.getBlockId(i2, k1 + l1, k2) != Block.obsidian.blockID) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
        boolean flag = world.getBlockId(i2 - 1, j2, k2) == this.blockID || world.getBlockId(i2 + 1, j2, k2) == this.blockID;
        boolean bl2 = flag1 = world.getBlockId(i2, j2, k2 - 1) == this.blockID || world.getBlockId(i2, j2, k2 + 1) == this.blockID;
        if (flag && flag1) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
        if (!(world.getBlockId(i2 + i1, j2, k2 + j1) == Block.obsidian.blockID && world.getBlockId(i2 - i1, j2, k2 - j1) == this.blockID || world.getBlockId(i2 - i1, j2, k2 - j1) == Block.obsidian.blockID && world.getBlockId(i2 + i1, j2, k2 + j1) == this.blockID)) {
            world.setBlockWithNotify(i2, j2, k2, 0);
            return;
        }
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        return true;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public int func_234_g() {
        return 1;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int i2, int j2, int k2, Entity entity) {
        if (world.multiplayerWorld) {
            return;
        }
        entity.func_4039_q();
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        if (random.nextInt(100) == 0) {
            world.playSoundEffect((double)i2 + 0.5, (double)j2 + 0.5, (double)k2 + 0.5, "portal.portal", 1.0f, random.nextFloat() * 0.4f + 0.8f);
        }
        for (int l2 = 0; l2 < 4; ++l2) {
            double d2 = (float)i2 + random.nextFloat();
            double d1 = (float)j2 + random.nextFloat();
            double d22 = (float)k2 + random.nextFloat();
            double d3 = 0.0;
            double d4 = 0.0;
            double d5 = 0.0;
            int i1 = random.nextInt(2) * 2 - 1;
            d3 = ((double)random.nextFloat() - 0.5) * 0.5;
            d4 = ((double)random.nextFloat() - 0.5) * 0.5;
            d5 = ((double)random.nextFloat() - 0.5) * 0.5;
            if (world.getBlockId(i2 - 1, j2, k2) == this.blockID || world.getBlockId(i2 + 1, j2, k2) == this.blockID) {
                d22 = (double)k2 + 0.5 + 0.25 * (double)i1;
                d5 = random.nextFloat() * 2.0f * (float)i1;
            } else {
                d2 = (double)i2 + 0.5 + 0.25 * (double)i1;
                d3 = random.nextFloat() * 2.0f * (float)i1;
            }
            world.spawnParticle("portal", d2, d1, d22, d3, d4, d5);
        }
    }
}

