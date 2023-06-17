/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;

public class ChunkCache
implements IBlockAccess {
    private int field_1060_a;
    private int field_1059_b;
    private Chunk[][] field_1062_c;
    private World worldObj;

    public ChunkCache(World world, int i2, int j2, int k2, int l2, int i1, int j1) {
        this.worldObj = world;
        this.field_1060_a = i2 >> 4;
        this.field_1059_b = k2 >> 4;
        int k1 = l2 >> 4;
        int l1 = j1 >> 4;
        this.field_1062_c = new Chunk[k1 - this.field_1060_a + 1][l1 - this.field_1059_b + 1];
        for (int i22 = this.field_1060_a; i22 <= k1; ++i22) {
            for (int j22 = this.field_1059_b; j22 <= l1; ++j22) {
                this.field_1062_c[i22 - this.field_1060_a][j22 - this.field_1059_b] = world.getChunkFromChunkCoords(i22, j22);
            }
        }
    }

    @Override
    public int getBlockId(int i2, int j2, int k2) {
        if (j2 < 0) {
            return 0;
        }
        if (j2 >= 128) {
            return 0;
        }
        int l2 = (i2 >> 4) - this.field_1060_a;
        int i1 = (k2 >> 4) - this.field_1059_b;
        return this.field_1062_c[l2][i1].getBlockID(i2 & 0xF, j2, k2 & 0xF);
    }

    @Override
    public TileEntity getBlockTileEntity(int i2, int j2, int k2) {
        int l2 = (i2 >> 4) - this.field_1060_a;
        int i1 = (k2 >> 4) - this.field_1059_b;
        return this.field_1062_c[l2][i1].getChunkBlockTileEntity(i2 & 0xF, j2, k2 & 0xF);
    }

    @Override
    public float getLightBrightness(int i2, int j2, int k2) {
        return this.worldObj.worldProvider.lightBrightnessTable[this.func_4086_d(i2, j2, k2)];
    }

    public int func_4086_d(int i2, int j2, int k2) {
        return this.func_716_a(i2, j2, k2, true);
    }

    public int func_716_a(int i2, int j2, int k2, boolean flag) {
        int l2;
        if (i2 < -32000000 || k2 < -32000000 || i2 >= 32000000 || k2 > 32000000) {
            return 15;
        }
        if (flag && ((l2 = this.getBlockId(i2, j2, k2)) == Block.stairSingle.blockID || l2 == Block.tilledField.blockID)) {
            int k1 = this.func_716_a(i2, j2 + 1, k2, false);
            int i22 = this.func_716_a(i2 + 1, j2, k2, false);
            int j22 = this.func_716_a(i2 - 1, j2, k2, false);
            int k22 = this.func_716_a(i2, j2, k2 + 1, false);
            int l22 = this.func_716_a(i2, j2, k2 - 1, false);
            if (i22 > k1) {
                k1 = i22;
            }
            if (j22 > k1) {
                k1 = j22;
            }
            if (k22 > k1) {
                k1 = k22;
            }
            if (l22 > k1) {
                k1 = l22;
            }
            return k1;
        }
        if (j2 < 0) {
            return 0;
        }
        if (j2 >= 128) {
            int i1 = 15 - this.worldObj.skylightSubtracted;
            if (i1 < 0) {
                i1 = 0;
            }
            return i1;
        }
        int j1 = (i2 >> 4) - this.field_1060_a;
        int l1 = (k2 >> 4) - this.field_1059_b;
        return this.field_1062_c[j1][l1].getBlockLightValue(i2 & 0xF, j2, k2 & 0xF, this.worldObj.skylightSubtracted);
    }

    @Override
    public int getBlockMetadata(int i2, int j2, int k2) {
        if (j2 < 0) {
            return 0;
        }
        if (j2 >= 128) {
            return 0;
        }
        int l2 = (i2 >> 4) - this.field_1060_a;
        int i1 = (k2 >> 4) - this.field_1059_b;
        return this.field_1062_c[l2][i1].getBlockMetadata(i2 & 0xF, j2, k2 & 0xF);
    }

    @Override
    public Material getBlockMaterial(int i2, int j2, int k2) {
        int l2 = this.getBlockId(i2, j2, k2);
        if (l2 == 0) {
            return Material.air;
        }
        return Block.blocksList[l2].blockMaterial;
    }

    @Override
    public boolean isBlockOpaqueCube(int i2, int j2, int k2) {
        Block block = Block.blocksList[this.getBlockId(i2, j2, k2)];
        if (block == null) {
            return false;
        }
        return block.isOpaqueCube();
    }

    @Override
    public WorldChunkManager func_4075_a() {
        return this.worldObj.func_4075_a();
    }
}

