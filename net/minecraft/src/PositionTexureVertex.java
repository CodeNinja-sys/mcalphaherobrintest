/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Vec3D;

public class PositionTexureVertex {
    public Vec3D vector3D;
    public float texturePositionX;
    public float texturePositionY;

    public PositionTexureVertex(float f2, float f1, float f22, float f3, float f4) {
        this(Vec3D.createVectorHelper(f2, f1, f22), f3, f4);
    }

    public PositionTexureVertex setTexturePosition(float f2, float f1) {
        return new PositionTexureVertex(this, f2, f1);
    }

    public PositionTexureVertex(PositionTexureVertex positiontexurevertex, float f2, float f1) {
        this.vector3D = positiontexurevertex.vector3D;
        this.texturePositionX = f2;
        this.texturePositionY = f1;
    }

    public PositionTexureVertex(Vec3D vec3d, float f2, float f1) {
        this.vector3D = vec3d;
        this.texturePositionX = f2;
        this.texturePositionY = f1;
    }
}

