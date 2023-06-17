/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import net.minecraft.src.Chunk;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityList;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.NibbleArray;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class ChunkLoader
implements IChunkLoader {
    private File saveDir;
    private boolean createIfNecessary;

    public ChunkLoader(File file, boolean flag) {
        this.saveDir = file;
        this.createIfNecessary = flag;
    }

    private File chunkFileForXZ(int i2, int j2) {
        String s2 = "c." + Integer.toString(i2, 36) + "." + Integer.toString(j2, 36) + ".dat";
        String s1 = Integer.toString(i2 & 0x3F, 36);
        String s22 = Integer.toString(j2 & 0x3F, 36);
        File file = new File(this.saveDir, s1);
        if (!file.exists()) {
            if (this.createIfNecessary) {
                file.mkdir();
            } else {
                return null;
            }
        }
        if (!(file = new File(file, s22)).exists()) {
            if (this.createIfNecessary) {
                file.mkdir();
            } else {
                return null;
            }
        }
        if (!(file = new File(file, s2)).exists() && !this.createIfNecessary) {
            return null;
        }
        return file;
    }

    @Override
    public Chunk loadChunk(World world, int i2, int j2) {
        File file = this.chunkFileForXZ(i2, j2);
        if (file != null && file.exists()) {
            NBTTagCompound nbttagcompound;
            block7: {
                block6: {
                    FileInputStream fileinputstream = new FileInputStream(file);
                    nbttagcompound = CompressedStreamTools.func_1138_a(fileinputstream);
                    if (nbttagcompound.hasKey("Level")) break block6;
                    System.out.println("Chunk file at " + i2 + "," + j2 + " is missing level data, skipping");
                    return null;
                }
                if (nbttagcompound.getCompoundTag("Level").hasKey("Blocks")) break block7;
                System.out.println("Chunk file at " + i2 + "," + j2 + " is missing block data, skipping");
                return null;
            }
            try {
                Chunk chunk = ChunkLoader.loadChunkIntoWorldFromCompound(world, nbttagcompound.getCompoundTag("Level"));
                if (!chunk.isAtLocation(i2, j2)) {
                    System.out.println("Chunk file at " + i2 + "," + j2 + " is in the wrong location; relocating. (Expected " + i2 + ", " + j2 + ", got " + chunk.xPosition + ", " + chunk.zPosition + ")");
                    nbttagcompound.setInteger("xPos", i2);
                    nbttagcompound.setInteger("zPos", j2);
                    chunk = ChunkLoader.loadChunkIntoWorldFromCompound(world, nbttagcompound.getCompoundTag("Level"));
                }
                return chunk;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void saveChunk(World world, Chunk chunk) {
        world.func_663_l();
        File file = this.chunkFileForXZ(chunk.xPosition, chunk.zPosition);
        if (file.exists()) {
            world.sizeOnDisk -= file.length();
        }
        try {
            File file1 = new File(this.saveDir, "tmp_chunk.dat");
            FileOutputStream fileoutputstream = new FileOutputStream(file1);
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound.setTag("Level", nbttagcompound1);
            this.storeChunkInCompound(chunk, world, nbttagcompound1);
            CompressedStreamTools.writeGzippedCompoundToOutputStream(nbttagcompound, fileoutputstream);
            fileoutputstream.close();
            if (file.exists()) {
                file.delete();
            }
            file1.renameTo(file);
            world.sizeOnDisk += file.length();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void storeChunkInCompound(Chunk chunk, World world, NBTTagCompound nbttagcompound) {
        world.func_663_l();
        nbttagcompound.setInteger("xPos", chunk.xPosition);
        nbttagcompound.setInteger("zPos", chunk.zPosition);
        nbttagcompound.setLong("LastUpdate", world.worldTime);
        nbttagcompound.setByteArray("Blocks", chunk.blocks);
        nbttagcompound.setByteArray("Data", chunk.data.data);
        nbttagcompound.setByteArray("SkyLight", chunk.skylightMap.data);
        nbttagcompound.setByteArray("BlockLight", chunk.blocklightMap.data);
        nbttagcompound.setByteArray("HeightMap", chunk.heightMap);
        nbttagcompound.setBoolean("TerrainPopulated", chunk.isTerrainPopulated);
        chunk.hasEntities = false;
        NBTTagList nbttaglist = new NBTTagList();
        for (int i2 = 0; i2 < chunk.entities.length; ++i2) {
            for (Entity entity : chunk.entities[i2]) {
                chunk.hasEntities = true;
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                if (!entity.func_358_c(nbttagcompound1)) continue;
                nbttaglist.setTag(nbttagcompound1);
            }
        }
        nbttagcompound.setTag("Entities", nbttaglist);
        NBTTagList nbttaglist1 = new NBTTagList();
        for (TileEntity tileentity : chunk.chunkTileEntityMap.values()) {
            NBTTagCompound nbttagcompound2 = new NBTTagCompound();
            tileentity.writeToNBT(nbttagcompound2);
            nbttaglist1.setTag(nbttagcompound2);
        }
        nbttagcompound.setTag("TileEntities", nbttaglist1);
    }

    public static Chunk loadChunkIntoWorldFromCompound(World world, NBTTagCompound nbttagcompound) {
        NBTTagList nbttaglist1;
        NBTTagList nbttaglist;
        int i2 = nbttagcompound.getInteger("xPos");
        int j2 = nbttagcompound.getInteger("zPos");
        Chunk chunk = new Chunk(world, i2, j2);
        chunk.blocks = nbttagcompound.getByteArray("Blocks");
        chunk.data = new NibbleArray(nbttagcompound.getByteArray("Data"));
        chunk.skylightMap = new NibbleArray(nbttagcompound.getByteArray("SkyLight"));
        chunk.blocklightMap = new NibbleArray(nbttagcompound.getByteArray("BlockLight"));
        chunk.heightMap = nbttagcompound.getByteArray("HeightMap");
        chunk.isTerrainPopulated = nbttagcompound.getBoolean("TerrainPopulated");
        if (!chunk.data.isValid()) {
            chunk.data = new NibbleArray(chunk.blocks.length);
        }
        if (chunk.heightMap == null || !chunk.skylightMap.isValid()) {
            chunk.heightMap = new byte[256];
            chunk.skylightMap = new NibbleArray(chunk.blocks.length);
            chunk.func_1024_c();
        }
        if (!chunk.blocklightMap.isValid()) {
            chunk.blocklightMap = new NibbleArray(chunk.blocks.length);
            chunk.func_1014_a();
        }
        if ((nbttaglist = nbttagcompound.getTagList("Entities")) != null) {
            for (int k2 = 0; k2 < nbttaglist.tagCount(); ++k2) {
                NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(k2);
                Entity entity = EntityList.createEntityFromNBT(nbttagcompound1, world);
                chunk.hasEntities = true;
                if (entity == null) continue;
                chunk.addEntity(entity);
            }
        }
        if ((nbttaglist1 = nbttagcompound.getTagList("TileEntities")) != null) {
            for (int l2 = 0; l2 < nbttaglist1.tagCount(); ++l2) {
                NBTTagCompound nbttagcompound2 = (NBTTagCompound)nbttaglist1.tagAt(l2);
                TileEntity tileentity = TileEntity.createAndLoadEntity(nbttagcompound2);
                if (tileentity == null) continue;
                chunk.func_1001_a(tileentity);
            }
        }
        return chunk;
    }

    @Override
    public void func_814_a() {
    }

    @Override
    public void saveExtraData() {
    }

    @Override
    public void saveExtraChunkData(World world, Chunk chunk) {
    }
}

