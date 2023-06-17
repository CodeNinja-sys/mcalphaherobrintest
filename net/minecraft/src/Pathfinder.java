/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.MCHashTable;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Path;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathPoint;

public class Pathfinder {
    private IBlockAccess worldMap;
    private Path path = new Path();
    private MCHashTable pointMap = new MCHashTable();
    private PathPoint[] pathOptions = new PathPoint[32];

    public Pathfinder(IBlockAccess iblockaccess) {
        this.worldMap = iblockaccess;
    }

    public PathEntity createEntityPathTo(Entity entity, Entity entity1, float f2) {
        return this.createEntityPathTo(entity, entity1.posX, entity1.boundingBox.minY, entity1.posZ, f2);
    }

    public PathEntity createEntityPathTo(Entity entity, int i2, int j2, int k2, float f2) {
        return this.createEntityPathTo(entity, (float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, f2);
    }

    private PathEntity createEntityPathTo(Entity entity, double d2, double d1, double d22, float f2) {
        this.path.clearPath();
        this.pointMap.clearMap();
        PathPoint pathpoint = this.openPoint(MathHelper.floor_double(entity.boundingBox.minX), MathHelper.floor_double(entity.boundingBox.minY), MathHelper.floor_double(entity.boundingBox.minZ));
        PathPoint pathpoint1 = this.openPoint(MathHelper.floor_double(d2 - (double)(entity.width / 2.0f)), MathHelper.floor_double(d1), MathHelper.floor_double(d22 - (double)(entity.width / 2.0f)));
        PathPoint pathpoint2 = new PathPoint(MathHelper.floor_float(entity.width + 1.0f), MathHelper.floor_float(entity.height + 1.0f), MathHelper.floor_float(entity.width + 1.0f));
        PathEntity pathentity = this.addToPath(entity, pathpoint, pathpoint1, pathpoint2, f2);
        return pathentity;
    }

    private PathEntity addToPath(Entity entity, PathPoint pathpoint, PathPoint pathpoint1, PathPoint pathpoint2, float f2) {
        pathpoint.totalPathDistance = 0.0f;
        pathpoint.distanceToTarget = pathpoint.distanceToNext = pathpoint.distanceTo(pathpoint1);
        this.path.clearPath();
        this.path.addPoint(pathpoint);
        PathPoint pathpoint3 = pathpoint;
        while (!this.path.isPathEmpty()) {
            PathPoint pathpoint4 = this.path.dequeue();
            if (pathpoint4.hash == pathpoint1.hash) {
                return this.createEntityPath(pathpoint, pathpoint1);
            }
            if (pathpoint4.distanceTo(pathpoint1) < pathpoint3.distanceTo(pathpoint1)) {
                pathpoint3 = pathpoint4;
            }
            pathpoint4.isFirst = true;
            int i2 = this.findPathOptions(entity, pathpoint4, pathpoint2, pathpoint1, f2);
            for (int j2 = 0; j2 < i2; ++j2) {
                PathPoint pathpoint5 = this.pathOptions[j2];
                float f1 = pathpoint4.totalPathDistance + pathpoint4.distanceTo(pathpoint5);
                if (pathpoint5.isAssigned() && !(f1 < pathpoint5.totalPathDistance)) continue;
                pathpoint5.previous = pathpoint4;
                pathpoint5.totalPathDistance = f1;
                pathpoint5.distanceToNext = pathpoint5.distanceTo(pathpoint1);
                if (pathpoint5.isAssigned()) {
                    this.path.changeDistance(pathpoint5, pathpoint5.totalPathDistance + pathpoint5.distanceToNext);
                    continue;
                }
                pathpoint5.distanceToTarget = pathpoint5.totalPathDistance + pathpoint5.distanceToNext;
                this.path.addPoint(pathpoint5);
            }
        }
        if (pathpoint3 == pathpoint) {
            return null;
        }
        return this.createEntityPath(pathpoint, pathpoint3);
    }

    private int findPathOptions(Entity entity, PathPoint pathpoint, PathPoint pathpoint1, PathPoint pathpoint2, float f2) {
        int i2 = 0;
        int j2 = 0;
        if (this.getVerticalOffset(entity, pathpoint.xCoord, pathpoint.yCoord + 1, pathpoint.zCoord, pathpoint1) > 0) {
            j2 = 1;
        }
        PathPoint pathpoint3 = this.getSafePoint(entity, pathpoint.xCoord, pathpoint.yCoord, pathpoint.zCoord + 1, pathpoint1, j2);
        PathPoint pathpoint4 = this.getSafePoint(entity, pathpoint.xCoord - 1, pathpoint.yCoord, pathpoint.zCoord, pathpoint1, j2);
        PathPoint pathpoint5 = this.getSafePoint(entity, pathpoint.xCoord + 1, pathpoint.yCoord, pathpoint.zCoord, pathpoint1, j2);
        PathPoint pathpoint6 = this.getSafePoint(entity, pathpoint.xCoord, pathpoint.yCoord, pathpoint.zCoord - 1, pathpoint1, j2);
        if (pathpoint3 != null && !pathpoint3.isFirst && pathpoint3.distanceTo(pathpoint2) < f2) {
            this.pathOptions[i2++] = pathpoint3;
        }
        if (pathpoint4 != null && !pathpoint4.isFirst && pathpoint4.distanceTo(pathpoint2) < f2) {
            this.pathOptions[i2++] = pathpoint4;
        }
        if (pathpoint5 != null && !pathpoint5.isFirst && pathpoint5.distanceTo(pathpoint2) < f2) {
            this.pathOptions[i2++] = pathpoint5;
        }
        if (pathpoint6 != null && !pathpoint6.isFirst && pathpoint6.distanceTo(pathpoint2) < f2) {
            this.pathOptions[i2++] = pathpoint6;
        }
        return i2;
    }

    private PathPoint getSafePoint(Entity entity, int i2, int j2, int k2, PathPoint pathpoint, int l2) {
        PathPoint pathpoint1 = null;
        if (this.getVerticalOffset(entity, i2, j2, k2, pathpoint) > 0) {
            pathpoint1 = this.openPoint(i2, j2, k2);
        }
        if (pathpoint1 == null && this.getVerticalOffset(entity, i2, j2 + l2, k2, pathpoint) > 0) {
            pathpoint1 = this.openPoint(i2, j2 + l2, k2);
            j2 += l2;
        }
        if (pathpoint1 != null) {
            int i1 = 0;
            int j1 = 0;
            while (j2 > 0 && (j1 = this.getVerticalOffset(entity, i2, j2 - 1, k2, pathpoint)) > 0) {
                if (j1 < 0) {
                    return null;
                }
                if (++i1 >= 4) {
                    return null;
                }
                --j2;
            }
            if (j2 > 0) {
                pathpoint1 = this.openPoint(i2, j2, k2);
            }
        }
        return pathpoint1;
    }

    private final PathPoint openPoint(int i2, int j2, int k2) {
        int l2 = i2 | j2 << 10 | k2 << 20;
        PathPoint pathpoint = (PathPoint)this.pointMap.lookup(l2);
        if (pathpoint == null) {
            pathpoint = new PathPoint(i2, j2, k2);
            this.pointMap.addKey(l2, pathpoint);
        }
        return pathpoint;
    }

    private int getVerticalOffset(Entity entity, int i2, int j2, int k2, PathPoint pathpoint) {
        for (int l2 = i2; l2 < i2 + pathpoint.xCoord; ++l2) {
            for (int i1 = j2; i1 < j2 + pathpoint.yCoord; ++i1) {
                for (int j1 = k2; j1 < k2 + pathpoint.zCoord; ++j1) {
                    Material material = this.worldMap.getBlockMaterial(i2, j2, k2);
                    if (material.func_880_c()) {
                        return 0;
                    }
                    if (material != Material.water && material != Material.lava) continue;
                    return -1;
                }
            }
        }
        return 1;
    }

    private PathEntity createEntityPath(PathPoint pathpoint, PathPoint pathpoint1) {
        int i2 = 1;
        PathPoint pathpoint2 = pathpoint1;
        while (pathpoint2.previous != null) {
            ++i2;
            pathpoint2 = pathpoint2.previous;
        }
        PathPoint[] apathpoint = new PathPoint[i2];
        PathPoint pathpoint3 = pathpoint1;
        apathpoint[--i2] = pathpoint3;
        while (pathpoint3.previous != null) {
            pathpoint3 = pathpoint3.previous;
            apathpoint[--i2] = pathpoint3;
        }
        return new PathEntity(apathpoint);
    }
}

