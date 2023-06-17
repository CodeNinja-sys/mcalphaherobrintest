/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;

public class AxisAlignedBB {
    private static List boundingBoxes = new ArrayList();
    private static int numBoundingBoxesInUse = 0;
    public double minX;
    public double minY;
    public double minZ;
    public double maxX;
    public double maxY;
    public double maxZ;

    public static AxisAlignedBB getBoundingBox(double d2, double d1, double d22, double d3, double d4, double d5) {
        return new AxisAlignedBB(d2, d1, d22, d3, d4, d5);
    }

    public static void clearBoundingBoxPool() {
        numBoundingBoxesInUse = 0;
    }

    public static AxisAlignedBB getBoundingBoxFromPool(double d2, double d1, double d22, double d3, double d4, double d5) {
        if (numBoundingBoxesInUse >= boundingBoxes.size()) {
            boundingBoxes.add(AxisAlignedBB.getBoundingBox(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        }
        return ((AxisAlignedBB)boundingBoxes.get(numBoundingBoxesInUse++)).setBounds(d2, d1, d22, d3, d4, d5);
    }

    private AxisAlignedBB(double d2, double d1, double d22, double d3, double d4, double d5) {
        this.minX = d2;
        this.minY = d1;
        this.minZ = d22;
        this.maxX = d3;
        this.maxY = d4;
        this.maxZ = d5;
    }

    public AxisAlignedBB setBounds(double d2, double d1, double d22, double d3, double d4, double d5) {
        this.minX = d2;
        this.minY = d1;
        this.minZ = d22;
        this.maxX = d3;
        this.maxY = d4;
        this.maxZ = d5;
        return this;
    }

    public AxisAlignedBB addCoord(double d2, double d1, double d22) {
        double d3 = this.minX;
        double d4 = this.minY;
        double d5 = this.minZ;
        double d6 = this.maxX;
        double d7 = this.maxY;
        double d8 = this.maxZ;
        if (d2 < 0.0) {
            d3 += d2;
        }
        if (d2 > 0.0) {
            d6 += d2;
        }
        if (d1 < 0.0) {
            d4 += d1;
        }
        if (d1 > 0.0) {
            d7 += d1;
        }
        if (d22 < 0.0) {
            d5 += d22;
        }
        if (d22 > 0.0) {
            d8 += d22;
        }
        return AxisAlignedBB.getBoundingBoxFromPool(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB expands(double d2, double d1, double d22) {
        double d3 = this.minX - d2;
        double d4 = this.minY - d1;
        double d5 = this.minZ - d22;
        double d6 = this.maxX + d2;
        double d7 = this.maxY + d1;
        double d8 = this.maxZ + d22;
        return AxisAlignedBB.getBoundingBoxFromPool(d3, d4, d5, d6, d7, d8);
    }

    public AxisAlignedBB getOffsetBoundingBox(double d2, double d1, double d22) {
        return AxisAlignedBB.getBoundingBoxFromPool(this.minX + d2, this.minY + d1, this.minZ + d22, this.maxX + d2, this.maxY + d1, this.maxZ + d22);
    }

    public double func_1163_a(AxisAlignedBB axisalignedbb, double d2) {
        double d22;
        double d1;
        if (axisalignedbb.maxY <= this.minY || axisalignedbb.minY >= this.maxY) {
            return d2;
        }
        if (axisalignedbb.maxZ <= this.minZ || axisalignedbb.minZ >= this.maxZ) {
            return d2;
        }
        if (d2 > 0.0 && axisalignedbb.maxX <= this.minX && (d1 = this.minX - axisalignedbb.maxX) < d2) {
            d2 = d1;
        }
        if (d2 < 0.0 && axisalignedbb.minX >= this.maxX && (d22 = this.maxX - axisalignedbb.minX) > d2) {
            d2 = d22;
        }
        return d2;
    }

    public double func_1172_b(AxisAlignedBB axisalignedbb, double d2) {
        double d22;
        double d1;
        if (axisalignedbb.maxX <= this.minX || axisalignedbb.minX >= this.maxX) {
            return d2;
        }
        if (axisalignedbb.maxZ <= this.minZ || axisalignedbb.minZ >= this.maxZ) {
            return d2;
        }
        if (d2 > 0.0 && axisalignedbb.maxY <= this.minY && (d1 = this.minY - axisalignedbb.maxY) < d2) {
            d2 = d1;
        }
        if (d2 < 0.0 && axisalignedbb.minY >= this.maxY && (d22 = this.maxY - axisalignedbb.minY) > d2) {
            d2 = d22;
        }
        return d2;
    }

    public double func_1162_c(AxisAlignedBB axisalignedbb, double d2) {
        double d22;
        double d1;
        if (axisalignedbb.maxX <= this.minX || axisalignedbb.minX >= this.maxX) {
            return d2;
        }
        if (axisalignedbb.maxY <= this.minY || axisalignedbb.minY >= this.maxY) {
            return d2;
        }
        if (d2 > 0.0 && axisalignedbb.maxZ <= this.minZ && (d1 = this.minZ - axisalignedbb.maxZ) < d2) {
            d2 = d1;
        }
        if (d2 < 0.0 && axisalignedbb.minZ >= this.maxZ && (d22 = this.maxZ - axisalignedbb.minZ) > d2) {
            d2 = d22;
        }
        return d2;
    }

    public boolean intersectsWith(AxisAlignedBB axisalignedbb) {
        if (axisalignedbb.maxX <= this.minX || axisalignedbb.minX >= this.maxX) {
            return false;
        }
        if (axisalignedbb.maxY <= this.minY || axisalignedbb.minY >= this.maxY) {
            return false;
        }
        return axisalignedbb.maxZ > this.minZ && axisalignedbb.minZ < this.maxZ;
    }

    public AxisAlignedBB offset(double d2, double d1, double d22) {
        this.minX += d2;
        this.minY += d1;
        this.minZ += d22;
        this.maxX += d2;
        this.maxY += d1;
        this.maxZ += d22;
        return this;
    }

    public boolean isVecInside(Vec3D vec3d) {
        if (vec3d.xCoord <= this.minX || vec3d.xCoord >= this.maxX) {
            return false;
        }
        if (vec3d.yCoord <= this.minY || vec3d.yCoord >= this.maxY) {
            return false;
        }
        return vec3d.zCoord > this.minZ && vec3d.zCoord < this.maxZ;
    }

    public double getAverageEdgeLength() {
        double d2 = this.maxX - this.minX;
        double d1 = this.maxY - this.minY;
        double d22 = this.maxZ - this.minZ;
        return (d2 + d1 + d22) / 3.0;
    }

    public AxisAlignedBB copy() {
        return AxisAlignedBB.getBoundingBoxFromPool(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }

    public MovingObjectPosition func_1169_a(Vec3D vec3d, Vec3D vec3d1) {
        Vec3D vec3d2 = vec3d.getIntermediateWithXValue(vec3d1, this.minX);
        Vec3D vec3d3 = vec3d.getIntermediateWithXValue(vec3d1, this.maxX);
        Vec3D vec3d4 = vec3d.getIntermediateWithYValue(vec3d1, this.minY);
        Vec3D vec3d5 = vec3d.getIntermediateWithYValue(vec3d1, this.maxY);
        Vec3D vec3d6 = vec3d.getIntermediateWithZValue(vec3d1, this.minZ);
        Vec3D vec3d7 = vec3d.getIntermediateWithZValue(vec3d1, this.maxZ);
        if (!this.isVecInYZ(vec3d2)) {
            vec3d2 = null;
        }
        if (!this.isVecInYZ(vec3d3)) {
            vec3d3 = null;
        }
        if (!this.isVecInXZ(vec3d4)) {
            vec3d4 = null;
        }
        if (!this.isVecInXZ(vec3d5)) {
            vec3d5 = null;
        }
        if (!this.isVecInXY(vec3d6)) {
            vec3d6 = null;
        }
        if (!this.isVecInXY(vec3d7)) {
            vec3d7 = null;
        }
        Vec3D vec3d8 = null;
        if (vec3d2 != null && (vec3d8 == null || vec3d.squareDistanceTo(vec3d2) < vec3d.squareDistanceTo(vec3d8))) {
            vec3d8 = vec3d2;
        }
        if (vec3d3 != null && (vec3d8 == null || vec3d.squareDistanceTo(vec3d3) < vec3d.squareDistanceTo(vec3d8))) {
            vec3d8 = vec3d3;
        }
        if (vec3d4 != null && (vec3d8 == null || vec3d.squareDistanceTo(vec3d4) < vec3d.squareDistanceTo(vec3d8))) {
            vec3d8 = vec3d4;
        }
        if (vec3d5 != null && (vec3d8 == null || vec3d.squareDistanceTo(vec3d5) < vec3d.squareDistanceTo(vec3d8))) {
            vec3d8 = vec3d5;
        }
        if (vec3d6 != null && (vec3d8 == null || vec3d.squareDistanceTo(vec3d6) < vec3d.squareDistanceTo(vec3d8))) {
            vec3d8 = vec3d6;
        }
        if (vec3d7 != null && (vec3d8 == null || vec3d.squareDistanceTo(vec3d7) < vec3d.squareDistanceTo(vec3d8))) {
            vec3d8 = vec3d7;
        }
        if (vec3d8 == null) {
            return null;
        }
        int byte0 = -1;
        if (vec3d8 == vec3d2) {
            byte0 = 4;
        }
        if (vec3d8 == vec3d3) {
            byte0 = 5;
        }
        if (vec3d8 == vec3d4) {
            byte0 = 0;
        }
        if (vec3d8 == vec3d5) {
            byte0 = 1;
        }
        if (vec3d8 == vec3d6) {
            byte0 = 2;
        }
        if (vec3d8 == vec3d7) {
            byte0 = 3;
        }
        return new MovingObjectPosition(0, 0, 0, byte0, vec3d8);
    }

    private boolean isVecInYZ(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.yCoord >= this.minY && vec3d.yCoord <= this.maxY && vec3d.zCoord >= this.minZ && vec3d.zCoord <= this.maxZ;
    }

    private boolean isVecInXZ(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.xCoord >= this.minX && vec3d.xCoord <= this.maxX && vec3d.zCoord >= this.minZ && vec3d.zCoord <= this.maxZ;
    }

    private boolean isVecInXY(Vec3D vec3d) {
        if (vec3d == null) {
            return false;
        }
        return vec3d.xCoord >= this.minX && vec3d.xCoord <= this.maxX && vec3d.yCoord >= this.minY && vec3d.yCoord <= this.maxY;
    }

    public void setBB(AxisAlignedBB axisalignedbb) {
        this.minX = axisalignedbb.minX;
        this.minY = axisalignedbb.minY;
        this.minZ = axisalignedbb.minZ;
        this.maxX = axisalignedbb.maxX;
        this.maxY = axisalignedbb.maxY;
        this.maxZ = axisalignedbb.maxZ;
    }
}

