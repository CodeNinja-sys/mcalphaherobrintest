/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.Vec3D;

public class MovingObjectPosition {
    public int typeOfHit;
    public int blockX;
    public int blockY;
    public int blockZ;
    public int sideHit;
    public Vec3D hitVec;
    public Entity entityHit;

    public MovingObjectPosition(int i2, int j2, int k2, int l2, Vec3D vec3d) {
        this.typeOfHit = 0;
        this.blockX = i2;
        this.blockY = j2;
        this.blockZ = k2;
        this.sideHit = l2;
        this.hitVec = Vec3D.createVector(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord);
    }

    public MovingObjectPosition(Entity entity) {
        this.typeOfHit = 1;
        this.entityHit = entity;
        this.hitVec = Vec3D.createVector(entity.posX, entity.posY, entity.posZ);
    }
}

