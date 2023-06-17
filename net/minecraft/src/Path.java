/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.PathPoint;

public class Path {
    private PathPoint[] pathPoints = new PathPoint[1024];
    private int count = 0;

    public PathPoint addPoint(PathPoint pathpoint) {
        if (pathpoint.index >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this.count == this.pathPoints.length) {
            PathPoint[] apathpoint = new PathPoint[this.count << 1];
            System.arraycopy(this.pathPoints, 0, apathpoint, 0, this.count);
            this.pathPoints = apathpoint;
        }
        this.pathPoints[this.count] = pathpoint;
        pathpoint.index = this.count;
        this.sortBack(this.count++);
        return pathpoint;
    }

    public void clearPath() {
        this.count = 0;
    }

    public PathPoint dequeue() {
        PathPoint pathpoint = this.pathPoints[0];
        this.pathPoints[0] = this.pathPoints[--this.count];
        this.pathPoints[this.count] = null;
        if (this.count > 0) {
            this.sortForward(0);
        }
        pathpoint.index = -1;
        return pathpoint;
    }

    public void changeDistance(PathPoint pathpoint, float f2) {
        float f1 = pathpoint.distanceToTarget;
        pathpoint.distanceToTarget = f2;
        if (f2 < f1) {
            this.sortBack(pathpoint.index);
        } else {
            this.sortForward(pathpoint.index);
        }
    }

    private void sortBack(int i2) {
        PathPoint pathpoint = this.pathPoints[i2];
        float f2 = pathpoint.distanceToTarget;
        while (i2 > 0) {
            int j2 = i2 - 1 >> 1;
            PathPoint pathpoint1 = this.pathPoints[j2];
            if (f2 >= pathpoint1.distanceToTarget) break;
            this.pathPoints[i2] = pathpoint1;
            pathpoint1.index = i2;
            i2 = j2;
        }
        this.pathPoints[i2] = pathpoint;
        pathpoint.index = i2;
    }

    private void sortForward(int i2) {
        PathPoint pathpoint = this.pathPoints[i2];
        float f2 = pathpoint.distanceToTarget;
        while (true) {
            float f22;
            PathPoint pathpoint2;
            int j2 = 1 + (i2 << 1);
            int k2 = j2 + 1;
            if (j2 >= this.count) break;
            PathPoint pathpoint1 = this.pathPoints[j2];
            float f1 = pathpoint1.distanceToTarget;
            if (k2 >= this.count) {
                pathpoint2 = null;
                f22 = Float.POSITIVE_INFINITY;
            } else {
                pathpoint2 = this.pathPoints[k2];
                f22 = pathpoint2.distanceToTarget;
            }
            if (f1 < f22) {
                if (f1 >= f2) break;
                this.pathPoints[i2] = pathpoint1;
                pathpoint1.index = i2;
                i2 = j2;
                continue;
            }
            if (f22 >= f2) break;
            this.pathPoints[i2] = pathpoint2;
            pathpoint2.index = i2;
            i2 = k2;
        }
        this.pathPoints[i2] = pathpoint;
        pathpoint.index = i2;
    }

    public boolean isPathEmpty() {
        return this.count == 0;
    }
}

