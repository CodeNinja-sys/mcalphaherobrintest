/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.World;

public class ChunkProviderClient
implements IChunkProvider {
    private Chunk blankChunk;
    private Map chunkMapping = new HashMap();
    private List unusedChunkList = new ArrayList();
    private World worldObj;

    public ChunkProviderClient(World world) {
        this.blankChunk = new Chunk(world, new byte[32768], 0, 0);
        this.blankChunk.field_1524_q = true;
        this.blankChunk.neverSave = true;
        this.worldObj = world;
    }

    @Override
    public boolean chunkExists(int i2, int j2) {
        ChunkCoordinates chunkcoordinates = new ChunkCoordinates(i2, j2);
        return this.chunkMapping.containsKey(chunkcoordinates);
    }

    public void func_539_c(int i2, int j2) {
        Chunk chunk = this.provideChunk(i2, j2);
        if (!chunk.field_1524_q) {
            chunk.onChunkUnload();
        }
        this.chunkMapping.remove(new ChunkCoordinates(i2, j2));
        this.unusedChunkList.remove(chunk);
    }

    public Chunk func_538_d(int i2, int j2) {
        ChunkCoordinates chunkcoordinates = new ChunkCoordinates(i2, j2);
        byte[] abyte0 = new byte[32768];
        Chunk chunk = new Chunk(this.worldObj, abyte0, i2, j2);
        Arrays.fill(chunk.skylightMap.data, (byte)-1);
        this.chunkMapping.put(chunkcoordinates, chunk);
        chunk.isChunkLoaded = true;
        return chunk;
    }

    @Override
    public Chunk provideChunk(int i2, int j2) {
        ChunkCoordinates chunkcoordinates = new ChunkCoordinates(i2, j2);
        Chunk chunk = (Chunk)this.chunkMapping.get(chunkcoordinates);
        if (chunk == null) {
            return this.blankChunk;
        }
        return chunk;
    }

    @Override
    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        return true;
    }

    @Override
    public boolean func_532_a() {
        return false;
    }

    @Override
    public boolean func_536_b() {
        return false;
    }

    @Override
    public void populate(IChunkProvider ichunkprovider, int i2, int j2) {
    }
}

