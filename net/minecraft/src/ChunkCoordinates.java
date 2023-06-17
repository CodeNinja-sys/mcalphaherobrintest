/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

final class ChunkCoordinates {
    public final int field_1518_a;
    public final int field_1517_b;

    public ChunkCoordinates(int i2, int j2) {
        this.field_1518_a = i2;
        this.field_1517_b = j2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ChunkCoordinates) {
            ChunkCoordinates chunkcoordinates = (ChunkCoordinates)obj;
            return this.field_1518_a == chunkcoordinates.field_1518_a && this.field_1517_b == chunkcoordinates.field_1517_b;
        }
        return false;
    }

    public int hashCode() {
        return this.field_1518_a << 16 ^ this.field_1517_b;
    }
}

