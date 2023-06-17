/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Entity;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NibbleArray;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class Chunk {
    public static boolean field_1540_a;
    public byte[] blocks;
    public boolean isChunkLoaded;
    public World worldObj;
    public NibbleArray data;
    public NibbleArray skylightMap;
    public NibbleArray blocklightMap;
    public byte[] heightMap;
    public int field_1532_i;
    public final int xPosition;
    public final int zPosition;
    public Map chunkTileEntityMap = new HashMap();
    public List[] entities = new List[9];
    public boolean isTerrainPopulated = false;
    public boolean isModified = false;
    public boolean neverSave;
    public boolean field_1524_q = false;
    public boolean hasEntities = false;
    public long lastSaveTime = 0L;

    public Chunk(World world, int i2, int j2) {
        this.worldObj = world;
        this.xPosition = i2;
        this.zPosition = j2;
        this.heightMap = new byte[256];
        for (int k2 = 0; k2 < this.entities.length; ++k2) {
            this.entities[k2] = new ArrayList();
        }
    }

    public Chunk(World world, byte[] abyte0, int i2, int j2) {
        this(world, i2, j2);
        this.blocks = abyte0;
        this.data = new NibbleArray(abyte0.length);
        this.skylightMap = new NibbleArray(abyte0.length);
        this.blocklightMap = new NibbleArray(abyte0.length);
    }

    public boolean isAtLocation(int i2, int j2) {
        return i2 == this.xPosition && j2 == this.zPosition;
    }

    public int getHeightValue(int i2, int j2) {
        return this.heightMap[j2 << 4 | i2] & 0xFF;
    }

    public void func_1014_a() {
    }

    public void generateHeightMap() {
        int i2 = 127;
        for (int j2 = 0; j2 < 16; ++j2) {
            for (int k2 = 0; k2 < 16; ++k2) {
                int l2;
                int i1 = j2 << 11 | k2 << 7;
                for (l2 = 127; l2 > 0 && Block.lightOpacity[this.blocks[i1 + l2 - 1]] == 0; --l2) {
                }
                this.heightMap[k2 << 4 | j2] = (byte)l2;
                if (l2 >= i2) continue;
                i2 = l2;
            }
        }
        this.field_1532_i = i2;
        this.isModified = true;
    }

    public void func_1024_c() {
        int i2 = 127;
        for (int j2 = 0; j2 < 16; ++j2) {
            for (int l2 = 0; l2 < 16; ++l2) {
                this.heightMap[l2 << 4 | j2] = -128;
                this.func_1003_g(j2, 127, l2);
                if ((this.heightMap[l2 << 4 | j2] & 0xFF) >= i2) continue;
                i2 = this.heightMap[l2 << 4 | j2] & 0xFF;
            }
        }
        this.field_1532_i = i2;
        for (int k2 = 0; k2 < 16; ++k2) {
            for (int i1 = 0; i1 < 16; ++i1) {
                this.func_996_c(k2, i1);
            }
        }
        this.isModified = true;
    }

    public void func_4143_d() {
        int byte0 = 32;
        for (int i2 = 0; i2 < 16; ++i2) {
            for (int j2 = 0; j2 < 16; ++j2) {
                int k2 = i2 << 11 | j2 << 7;
                for (int l2 = 0; l2 < 128; ++l2) {
                    int j1 = Block.lightValue[this.blocks[k2 + l2]];
                    if (j1 <= 0) continue;
                    this.blocklightMap.setNibble(i2, l2, j2, j1);
                }
                int i1 = 15;
                int k1 = byte0 - 2;
                while (k1 < 128 && i1 > 0) {
                    byte byte1 = this.blocks[k2 + ++k1];
                    int l1 = Block.lightOpacity[byte1];
                    int i22 = Block.lightValue[byte1];
                    if (l1 == 0) {
                        l1 = 1;
                    }
                    if (i22 > (i1 -= l1)) {
                        i1 = i22;
                    }
                    if (i1 < 0) {
                        i1 = 0;
                    }
                    this.blocklightMap.setNibble(i2, k1, j2, i1);
                }
            }
        }
        this.worldObj.func_616_a(EnumSkyBlock.Block, this.xPosition * 16, byte0 - 1, this.zPosition * 16, this.xPosition * 16 + 16, byte0 + 1, this.zPosition * 16 + 16);
        this.isModified = true;
    }

    private void func_996_c(int i2, int j2) {
        int k2 = this.getHeightValue(i2, j2);
        int l2 = this.xPosition * 16 + i2;
        int i1 = this.zPosition * 16 + j2;
        this.func_1020_f(l2 - 1, i1, k2);
        this.func_1020_f(l2 + 1, i1, k2);
        this.func_1020_f(l2, i1 - 1, k2);
        this.func_1020_f(l2, i1 + 1, k2);
    }

    private void func_1020_f(int i2, int j2, int k2) {
        int l2 = this.worldObj.getHeightValue(i2, j2);
        if (l2 > k2) {
            this.worldObj.func_616_a(EnumSkyBlock.Sky, i2, k2, j2, i2, l2, j2);
        } else if (l2 < k2) {
            this.worldObj.func_616_a(EnumSkyBlock.Sky, i2, l2, j2, i2, k2, j2);
        }
        this.isModified = true;
    }

    private void func_1003_g(int i2, int j2, int k2) {
        int l2;
        int i1 = l2 = this.heightMap[k2 << 4 | i2] & 0xFF;
        if (j2 > l2) {
            i1 = j2;
        }
        int j1 = i2 << 11 | k2 << 7;
        while (i1 > 0 && Block.lightOpacity[this.blocks[j1 + i1 - 1]] == 0) {
            --i1;
        }
        if (i1 == l2) {
            return;
        }
        this.worldObj.func_680_f(i2, k2, i1, l2);
        this.heightMap[k2 << 4 | i2] = (byte)i1;
        if (i1 < this.field_1532_i) {
            this.field_1532_i = i1;
        } else {
            int k1 = 127;
            for (int i22 = 0; i22 < 16; ++i22) {
                for (int k22 = 0; k22 < 16; ++k22) {
                    if ((this.heightMap[k22 << 4 | i22] & 0xFF) >= k1) continue;
                    k1 = this.heightMap[k22 << 4 | i22] & 0xFF;
                }
            }
            this.field_1532_i = k1;
        }
        int l1 = this.xPosition * 16 + i2;
        int j22 = this.zPosition * 16 + k2;
        if (i1 < l2) {
            for (int l22 = i1; l22 < l2; ++l22) {
                this.skylightMap.setNibble(i2, l22, k2, 15);
            }
        } else {
            this.worldObj.func_616_a(EnumSkyBlock.Sky, l1, l2, j22, l1, i1, j22);
            for (int i3 = l2; i3 < i1; ++i3) {
                this.skylightMap.setNibble(i2, i3, k2, 0);
            }
        }
        int j3 = 15;
        int k3 = i1;
        while (i1 > 0 && j3 > 0) {
            int l3;
            if ((l3 = Block.lightOpacity[this.getBlockID(i2, --i1, k2)]) == 0) {
                l3 = 1;
            }
            if ((j3 -= l3) < 0) {
                j3 = 0;
            }
            this.skylightMap.setNibble(i2, i1, k2, j3);
        }
        while (i1 > 0 && Block.lightOpacity[this.getBlockID(i2, i1 - 1, k2)] == 0) {
            --i1;
        }
        if (i1 != k3) {
            this.worldObj.func_616_a(EnumSkyBlock.Sky, l1 - 1, i1, j22 - 1, l1 + 1, k3, j22 + 1);
        }
        this.isModified = true;
    }

    public int getBlockID(int i2, int j2, int k2) {
        return this.blocks[i2 << 11 | k2 << 7 | j2];
    }

    public boolean setBlockIDWithMetadata(int i2, int j2, int k2, int l2, int i1) {
        byte byte0 = (byte)l2;
        int j1 = this.heightMap[k2 << 4 | i2] & 0xFF;
        int k1 = this.blocks[i2 << 11 | k2 << 7 | j2] & 0xFF;
        if (k1 == l2 && this.data.getNibble(i2, j2, k2) == i1) {
            return false;
        }
        int l1 = this.xPosition * 16 + i2;
        int i22 = this.zPosition * 16 + k2;
        this.blocks[i2 << 11 | k2 << 7 | j2] = byte0;
        if (k1 != 0 && !this.worldObj.multiplayerWorld) {
            Block.blocksList[k1].onBlockRemoval(this.worldObj, l1, j2, i22);
        }
        this.data.setNibble(i2, j2, k2, i1);
        if (!this.worldObj.worldProvider.field_6478_e) {
            if (Block.lightOpacity[byte0] != 0) {
                if (j2 >= j1) {
                    this.func_1003_g(i2, j2 + 1, k2);
                }
            } else if (j2 == j1 - 1) {
                this.func_1003_g(i2, j2, k2);
            }
            this.worldObj.func_616_a(EnumSkyBlock.Sky, l1, j2, i22, l1, j2, i22);
        }
        this.worldObj.func_616_a(EnumSkyBlock.Block, l1, j2, i22, l1, j2, i22);
        this.func_996_c(i2, k2);
        if (l2 != 0) {
            Block.blocksList[l2].onBlockAdded(this.worldObj, l1, j2, i22);
        }
        this.data.setNibble(i2, j2, k2, i1);
        this.isModified = true;
        return true;
    }

    public boolean setBlockID(int i2, int j2, int k2, int l2) {
        byte byte0 = (byte)l2;
        int i1 = this.heightMap[k2 << 4 | i2] & 0xFF;
        int j1 = this.blocks[i2 << 11 | k2 << 7 | j2] & 0xFF;
        if (j1 == l2) {
            return false;
        }
        int k1 = this.xPosition * 16 + i2;
        int l1 = this.zPosition * 16 + k2;
        this.blocks[i2 << 11 | k2 << 7 | j2] = byte0;
        if (j1 != 0) {
            Block.blocksList[j1].onBlockRemoval(this.worldObj, k1, j2, l1);
        }
        this.data.setNibble(i2, j2, k2, 0);
        if (Block.lightOpacity[byte0] != 0) {
            if (j2 >= i1) {
                this.func_1003_g(i2, j2 + 1, k2);
            }
        } else if (j2 == i1 - 1) {
            this.func_1003_g(i2, j2, k2);
        }
        this.worldObj.func_616_a(EnumSkyBlock.Sky, k1, j2, l1, k1, j2, l1);
        this.worldObj.func_616_a(EnumSkyBlock.Block, k1, j2, l1, k1, j2, l1);
        this.func_996_c(i2, k2);
        if (l2 != 0 && !this.worldObj.multiplayerWorld) {
            Block.blocksList[l2].onBlockAdded(this.worldObj, k1, j2, l1);
        }
        this.isModified = true;
        return true;
    }

    public int getBlockMetadata(int i2, int j2, int k2) {
        return this.data.getNibble(i2, j2, k2);
    }

    public void setBlockMetadata(int i2, int j2, int k2, int l2) {
        this.isModified = true;
        this.data.setNibble(i2, j2, k2, l2);
    }

    public int getSavedLightValue(EnumSkyBlock enumskyblock, int i2, int j2, int k2) {
        if (enumskyblock == EnumSkyBlock.Sky) {
            return this.skylightMap.getNibble(i2, j2, k2);
        }
        if (enumskyblock == EnumSkyBlock.Block) {
            return this.blocklightMap.getNibble(i2, j2, k2);
        }
        return 0;
    }

    public void setLightValue(EnumSkyBlock enumskyblock, int i2, int j2, int k2, int l2) {
        this.isModified = true;
        if (enumskyblock == EnumSkyBlock.Sky) {
            this.skylightMap.setNibble(i2, j2, k2, l2);
        } else if (enumskyblock == EnumSkyBlock.Block) {
            this.blocklightMap.setNibble(i2, j2, k2, l2);
        } else {
            return;
        }
    }

    public int getBlockLightValue(int i2, int j2, int k2, int l2) {
        int j1;
        int i1 = this.skylightMap.getNibble(i2, j2, k2);
        if (i1 > 0) {
            field_1540_a = true;
        }
        if ((j1 = this.blocklightMap.getNibble(i2, j2, k2)) > (i1 -= l2)) {
            i1 = j1;
        }
        return i1;
    }

    public void addEntity(Entity entity) {
        int k2;
        if (this.field_1524_q) {
            return;
        }
        this.hasEntities = true;
        int i2 = MathHelper.floor_double(entity.posX / 16.0);
        int j2 = MathHelper.floor_double(entity.posZ / 16.0);
        if (i2 != this.xPosition || j2 != this.zPosition) {
            System.out.println("Wrong location! " + entity);
            Thread.dumpStack();
        }
        if ((k2 = MathHelper.floor_double(entity.posY / 16.0)) < 0) {
            k2 = 0;
        }
        if (k2 >= this.entities.length) {
            k2 = this.entities.length - 1;
        }
        entity.field_621_aZ = true;
        entity.field_657_ba = this.xPosition;
        entity.field_656_bb = k2;
        entity.field_654_bc = this.zPosition;
        this.entities[k2].add(entity);
    }

    public void func_1015_b(Entity entity) {
        this.func_1016_a(entity, entity.field_656_bb);
    }

    public void func_1016_a(Entity entity, int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= this.entities.length) {
            i2 = this.entities.length - 1;
        }
        this.entities[i2].remove(entity);
    }

    public boolean canBlockSeeTheSky(int i2, int j2, int k2) {
        return j2 >= (this.heightMap[k2 << 4 | i2] & 0xFF);
    }

    public TileEntity getChunkBlockTileEntity(int i2, int j2, int k2) {
        ChunkPosition chunkposition = new ChunkPosition(i2, j2, k2);
        TileEntity tileentity = (TileEntity)this.chunkTileEntityMap.get(chunkposition);
        if (tileentity == null) {
            int l2 = this.getBlockID(i2, j2, k2);
            if (!Block.isBlockContainer[l2]) {
                return null;
            }
            BlockContainer blockcontainer = (BlockContainer)Block.blocksList[l2];
            blockcontainer.onBlockAdded(this.worldObj, this.xPosition * 16 + i2, j2, this.zPosition * 16 + k2);
            tileentity = (TileEntity)this.chunkTileEntityMap.get(chunkposition);
        }
        return tileentity;
    }

    public void func_1001_a(TileEntity tileentity) {
        int i2 = tileentity.xCoord - this.xPosition * 16;
        int j2 = tileentity.yCoord;
        int k2 = tileentity.zCoord - this.zPosition * 16;
        this.setChunkBlockTileEntity(i2, j2, k2, tileentity);
    }

    public void setChunkBlockTileEntity(int i2, int j2, int k2, TileEntity tileentity) {
        ChunkPosition chunkposition = new ChunkPosition(i2, j2, k2);
        tileentity.worldObj = this.worldObj;
        tileentity.xCoord = this.xPosition * 16 + i2;
        tileentity.yCoord = j2;
        tileentity.zCoord = this.zPosition * 16 + k2;
        if (this.getBlockID(i2, j2, k2) == 0 || !(Block.blocksList[this.getBlockID(i2, j2, k2)] instanceof BlockContainer)) {
            System.out.println("Attempted to place a tile entity where there was no entity tile!");
            return;
        }
        if (this.isChunkLoaded) {
            if (this.chunkTileEntityMap.get(chunkposition) != null) {
                this.worldObj.loadedTileEntityList.remove(this.chunkTileEntityMap.get(chunkposition));
            }
            this.worldObj.loadedTileEntityList.add(tileentity);
        }
        this.chunkTileEntityMap.put(chunkposition, tileentity);
    }

    public void removeChunkBlockTileEntity(int i2, int j2, int k2) {
        ChunkPosition chunkposition = new ChunkPosition(i2, j2, k2);
        if (this.isChunkLoaded) {
            this.worldObj.loadedTileEntityList.remove(this.chunkTileEntityMap.remove(chunkposition));
        }
    }

    public void onChunkLoad() {
        this.isChunkLoaded = true;
        this.worldObj.loadedTileEntityList.addAll(this.chunkTileEntityMap.values());
        for (int i2 = 0; i2 < this.entities.length; ++i2) {
            this.worldObj.func_636_a(this.entities[i2]);
        }
    }

    public void onChunkUnload() {
        this.isChunkLoaded = false;
        this.worldObj.loadedTileEntityList.removeAll(this.chunkTileEntityMap.values());
        for (int i2 = 0; i2 < this.entities.length; ++i2) {
            this.worldObj.func_632_b(this.entities[i2]);
        }
    }

    public void setChunkModified() {
        this.isModified = true;
    }

    public void getEntitiesWithinAABBForEntity(Entity entity, AxisAlignedBB axisalignedbb, List list) {
        int i2 = MathHelper.floor_double((axisalignedbb.minY - 2.0) / 16.0);
        int j2 = MathHelper.floor_double((axisalignedbb.maxY + 2.0) / 16.0);
        if (i2 < 0) {
            i2 = 0;
        }
        if (j2 >= this.entities.length) {
            j2 = this.entities.length - 1;
        }
        for (int k2 = i2; k2 <= j2; ++k2) {
            List list1 = this.entities[k2];
            for (int l2 = 0; l2 < list1.size(); ++l2) {
                Entity entity1 = (Entity)list1.get(l2);
                if (entity1 == entity || !entity1.boundingBox.intersectsWith(axisalignedbb)) continue;
                list.add(entity1);
            }
        }
    }

    public void getEntitiesOfTypeWithinAAAB(Class class1, AxisAlignedBB axisalignedbb, List list) {
        int i2 = MathHelper.floor_double((axisalignedbb.minY - 2.0) / 16.0);
        int j2 = MathHelper.floor_double((axisalignedbb.maxY + 2.0) / 16.0);
        if (i2 < 0) {
            i2 = 0;
        }
        if (j2 >= this.entities.length) {
            j2 = this.entities.length - 1;
        }
        for (int k2 = i2; k2 <= j2; ++k2) {
            List list1 = this.entities[k2];
            for (int l2 = 0; l2 < list1.size(); ++l2) {
                Entity entity = (Entity)list1.get(l2);
                if (!class1.isAssignableFrom(entity.getClass()) || !entity.boundingBox.intersectsWith(axisalignedbb)) continue;
                list.add(entity);
            }
        }
    }

    public boolean needsSaving(boolean flag) {
        if (this.neverSave) {
            return false;
        }
        if (this.hasEntities && this.worldObj.worldTime != this.lastSaveTime) {
            return true;
        }
        return this.isModified;
    }

    public int func_1004_a(byte[] abyte0, int i2, int j2, int k2, int l2, int i1, int j1, int k1) {
        for (int l1 = i2; l1 < l2; ++l1) {
            for (int l22 = k2; l22 < j1; ++l22) {
                int l3 = l1 << 11 | l22 << 7 | j2;
                int l4 = i1 - j2;
                System.arraycopy(abyte0, k1, this.blocks, l3, l4);
                k1 += l4;
            }
        }
        this.generateHeightMap();
        for (int i22 = i2; i22 < l2; ++i22) {
            for (int i3 = k2; i3 < j1; ++i3) {
                int i4 = (i22 << 11 | i3 << 7 | j2) >> 1;
                int i5 = (i1 - j2) / 2;
                System.arraycopy(abyte0, k1, this.data.data, i4, i5);
                k1 += i5;
            }
        }
        for (int j22 = i2; j22 < l2; ++j22) {
            for (int j3 = k2; j3 < j1; ++j3) {
                int j4 = (j22 << 11 | j3 << 7 | j2) >> 1;
                int j5 = (i1 - j2) / 2;
                System.arraycopy(abyte0, k1, this.blocklightMap.data, j4, j5);
                k1 += j5;
            }
        }
        for (int k22 = i2; k22 < l2; ++k22) {
            for (int k3 = k2; k3 < j1; ++k3) {
                int k4 = (k22 << 11 | k3 << 7 | j2) >> 1;
                int k5 = (i1 - j2) / 2;
                System.arraycopy(abyte0, k1, this.skylightMap.data, k4, k5);
                k1 += k5;
            }
        }
        return k1;
    }

    public Random func_997_a(long l2) {
        return new Random(this.worldObj.randomSeed + (long)(this.xPosition * this.xPosition * 4987142) + (long)(this.xPosition * 5947611) + (long)(this.zPosition * this.zPosition) * 4392871L + (long)(this.zPosition * 389711) ^ l2);
    }
}

