/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.PathPoint;
import net.minecraft.src.Vec3D;

public class PathEntity {
    private final PathPoint[] points;
    public final int pathLength;
    private int pathIndex;

    public PathEntity(PathPoint[] apathpoint) {
        this.points = apathpoint;
        this.pathLength = apathpoint.length;
    }

    public void incrementPathIndex() {
        ++this.pathIndex;
    }

    public boolean isFinished() {
        return this.pathIndex >= this.points.length;
    }

    public Vec3D getPosition(Entity entity) {
        double d2 = (double)this.points[this.pathIndex].xCoord + (double)((int)(entity.width + 1.0f)) * 0.5;
        double d1 = this.points[this.pathIndex].yCoord;
        double d22 = (double)this.points[this.pathIndex].zCoord + (double)((int)(entity.width + 1.0f)) * 0.5;
        return Vec3D.createVector(d2, d1, d22);
    }
}

