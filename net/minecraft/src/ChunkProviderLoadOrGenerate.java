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

public class ChunkProviderLoadOrGenerate
implements IChunkProvider {
    private Chunk blankChunk;
    private IChunkProvider chunkProvider;
    private IChunkLoader chunkLoader;
    private Chunk[] chunks = new Chunk[1024];
    private World worldObj;
    int lastQueriedChunkXPos = -999999999;
    int lastQueriedChunkZPos = -999999999;
    private Chunk lastQueriedChunk;

    public ChunkProviderLoadOrGenerate(World world, IChunkLoader ichunkloader, IChunkProvider ichunkprovider) {
        this.blankChunk = new Chunk(world, new byte[32768], 0, 0);
        this.blankChunk.field_1524_q = true;
        this.blankChunk.neverSave = true;
        this.worldObj = world;
        this.chunkLoader = ichunkloader;
        this.chunkProvider = ichunkprovider;
    }

    @Override
    public boolean chunkExists(int i2, int j2) {
        if (i2 == this.lastQueriedChunkXPos && j2 == this.lastQueriedChunkZPos && this.lastQueriedChunk != null) {
            return true;
        }
        int k2 = i2 & 0x1F;
        int l2 = j2 & 0x1F;
        int i1 = k2 + l2 * 32;
        return this.chunks[i1] != null && (this.chunks[i1] == this.blankChunk || this.chunks[i1].isAtLocation(i2, j2));
    }

    @Override
    public Chunk provideChunk(int i2, int j2) {
        if (i2 == this.lastQueriedChunkXPos && j2 == this.lastQueriedChunkZPos && this.lastQueriedChunk != null) {
            return this.lastQueriedChunk;
        }
        int k2 = i2 & 0x1F;
        int l2 = j2 & 0x1F;
        int i1 = k2 + l2 * 32;
        if (!this.chunkExists(i2, j2)) {
            Chunk chunk;
            if (this.chunks[i1] != null) {
                this.chunks[i1].onChunkUnload();
                this.saveChunk(this.chunks[i1]);
                this.saveExtraChunkData(this.chunks[i1]);
            }
            if ((chunk = this.func_542_c(i2, j2)) == null) {
                chunk = this.chunkProvider == null ? this.blankChunk : this.chunkProvider.provideChunk(i2, j2);
            }
            this.chunks[i1] = chunk;
            chunk.func_4143_d();
            if (this.chunks[i1] != null) {
                this.chunks[i1].onChunkLoad();
            }
            if (!this.chunks[i1].isTerrainPopulated && this.chunkExists(i2 + 1, j2 + 1) && this.chunkExists(i2, j2 + 1) && this.chunkExists(i2 + 1, j2)) {
                this.populate(this, i2, j2);
            }
            if (this.chunkExists(i2 - 1, j2) && !this.provideChunk((int)(i2 - 1), (int)j2).isTerrainPopulated && this.chunkExists(i2 - 1, j2 + 1) && this.chunkExists(i2, j2 + 1) && this.chunkExists(i2 - 1, j2)) {
                this.populate(this, i2 - 1, j2);
            }
            if (this.chunkExists(i2, j2 - 1) && !this.provideChunk((int)i2, (int)(j2 - 1)).isTerrainPopulated && this.chunkExists(i2 + 1, j2 - 1) && this.chunkExists(i2, j2 - 1) && this.chunkExists(i2 + 1, j2)) {
                this.populate(this, i2, j2 - 1);
            }
            if (this.chunkExists(i2 - 1, j2 - 1) && !this.provideChunk((int)(i2 - 1), (int)(j2 - 1)).isTerrainPopulated && this.chunkExists(i2 - 1, j2 - 1) && this.chunkExists(i2, j2 - 1) && this.chunkExists(i2 - 1, j2)) {
                this.populate(this, i2 - 1, j2 - 1);
            }
        }
        this.lastQueriedChunkXPos = i2;
        this.lastQueriedChunkZPos = j2;
        this.lastQueriedChunk = this.chunks[i1];
        return this.chunks[i1];
    }

    private Chunk func_542_c(int i2, int j2) {
        if (this.chunkLoader == null) {
            return null;
        }
        try {
            Chunk chunk = this.chunkLoader.loadChunk(this.worldObj, i2, j2);
            if (chunk != null) {
                chunk.lastSaveTime = this.worldObj.worldTime;
            }
            return chunk;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void saveExtraChunkData(Chunk chunk) {
        if (this.chunkLoader == null) {
            return;
        }
        try {
            this.chunkLoader.saveExtraChunkData(this.worldObj, chunk);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void saveChunk(Chunk chunk) {
        if (this.chunkLoader == null) {
            return;
        }
        try {
            chunk.lastSaveTime = this.worldObj.worldTime;
            this.chunkLoader.saveChunk(this.worldObj, chunk);
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    @Override
    public void populate(IChunkProvider ichunkprovider, int i2, int j2) {
        Chunk chunk = this.provideChunk(i2, j2);
        if (!chunk.isTerrainPopulated) {
            chunk.isTerrainPopulated = true;
            if (this.chunkProvider != null) {
                this.chunkProvider.populate(ichunkprovider, i2, j2);
                chunk.setChunkModified();
            }
        }
    }

    @Override
    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
        int i2 = 0;
        int j2 = 0;
        if (iprogressupdate != null) {
            for (int k2 = 0; k2 < this.chunks.length; ++k2) {
                if (this.chunks[k2] == null || !this.chunks[k2].needsSaving(flag)) continue;
                ++j2;
            }
        }
        int l2 = 0;
        for (int i1 = 0; i1 < this.chunks.length; ++i1) {
            if (this.chunks[i1] == null) continue;
            if (flag && !this.chunks[i1].neverSave) {
                this.saveExtraChunkData(this.chunks[i1]);
            }
            if (!this.chunks[i1].needsSaving(flag)) continue;
            this.saveChunk(this.chunks[i1]);
            this.chunks[i1].isModified = false;
            if (++i2 == 2 && !flag) {
                return false;
            }
            if (iprogressupdate == null || ++l2 % 10 != 0) continue;
            iprogressupdate.setLoadingProgress(l2 * 100 / j2);
        }
        if (flag) {
            if (this.chunkLoader == null) {
                return true;
            }
            this.chunkLoader.saveExtraData();
        }
        return true;
    }

    @Override
    public boolean func_532_a() {
        if (this.chunkLoader != null) {
            this.chunkLoader.func_814_a();
        }
        return this.chunkProvider.func_532_a();
    }

    @Override
    public boolean func_536_b() {
        return true;
    }
}

