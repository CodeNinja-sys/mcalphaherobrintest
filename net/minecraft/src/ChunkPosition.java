/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class ChunkPosition {
    public final int x;
    public final int y;
    public final int z;

    public ChunkPosition(int i2, int j2, int k2) {
        this.x = i2;
        this.y = j2;
        this.z = k2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChunkPosition) {
            ChunkPosition chunkposition = (ChunkPosition)obj;
            return chunkposition.x == this.x && chunkposition.y == this.y && chunkposition.z == this.z;
        }
        return false;
    }

    public int hashCode() {
        return this.x * 8976890 + this.y * 981131 + this.z;
    }
}

