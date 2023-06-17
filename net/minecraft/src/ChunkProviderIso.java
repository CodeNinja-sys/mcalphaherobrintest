/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.IOException;
import net.minecraft.src.Chunk;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.World;

public class ChunkProviderIso
implements IChunkProvider {
    private Chunk[] chunks = new Chunk[256];
    private World worldObj;
    private IChunkLoader chunkLoader;
    byte[] field_899_a = new byte[32768];

    public ChunkProviderIso(World world, IChunkLoader ichunkloader) {
        this.worldObj = world;
        this.chunkLoader = ichunkloader;
    }

    @Override
    public boolean chunkExists(int i2, int j2) {
        int k2 = i2 & 0xF | (j2 & 0xF) * 16;
        return this.chunks[k2] != null && this.chunks[k2].isAtLocation(i2, j2);
    }

    @Override
    public Chunk provideChunk(int i2, int j2) {
        int k2 = i2 & 0xF | (j2 & 0xF) * 16;
        try {
            if (!this.chunkExists(i2, j2)) {
                Chunk chunk = this.func_543_c(i2, j2);
                if (chunk == null) {
                    chunk = new Chunk(this.worldObj, this.field_899_a, i2, j2);
                    chunk.field_1524_q = true;
                    chunk.neverSave = true;
                }
                this.chunks[k2] = chunk;
            }
            return this.chunks[k2];
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private synchronized Chunk func_543_c(int i2, int j2) {
        try {
            return this.chunkLoader.loadChunk(this.worldObj, i2, j2);
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
            return null;
        }
    }

    @Override
    public void populate(IChunkProvider ichunkprovider, int i2, int j2) {
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
}

