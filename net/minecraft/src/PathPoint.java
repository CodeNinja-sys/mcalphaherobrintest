/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MathHelper;

public class PathPoint {
    public final int xCoord;
    public final int yCoord;
    public final int zCoord;
    public final int hash;
    int index = -1;
    float totalPathDistance;
    float distanceToNext;
    float distanceToTarget;
    PathPoint previous;
    public boolean isFirst = false;

    public PathPoint(int i2, int j2, int k2) {
        this.xCoord = i2;
        this.yCoord = j2;
        this.zCoord = k2;
        this.hash = i2 | j2 << 10 | k2 << 20;
    }

    public float distanceTo(PathPoint pathpoint) {
        float f2 = pathpoint.xCoord - this.xCoord;
        float f1 = pathpoint.yCoord - this.yCoord;
        float f22 = pathpoint.zCoord - this.zCoord;
        return MathHelper.sqrt_float(f2 * f2 + f1 * f1 + f22 * f22);
    }

    public boolean equals(Object obj) {
        return ((PathPoint)obj).hash == this.hash;
    }

    public int hashCode() {
        return this.hash;
    }

    public boolean isAssigned() {
        return this.index >= 0;
    }

    public String toString() {
        return this.xCoord + ", " + this.yCoord + ", " + this.zCoord;
    }
}

