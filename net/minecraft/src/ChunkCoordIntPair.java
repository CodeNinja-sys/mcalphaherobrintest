/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class ChunkCoordIntPair {
    public int chunkXPos;
    public int chunkZPos;

    public ChunkCoordIntPair(int i2, int j2) {
        this.chunkXPos = i2;
        this.chunkZPos = j2;
    }

    public int hashCode() {
        return this.chunkXPos << 8 | this.chunkZPos;
    }

    public boolean equals(Object obj) {
        ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)obj;
        return chunkcoordintpair.chunkXPos == this.chunkXPos && chunkcoordintpair.chunkZPos == this.chunkZPos;
    }
}

