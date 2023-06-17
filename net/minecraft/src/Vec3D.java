/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.MathHelper;

public class Vec3D {
    private static List vectorList = new ArrayList();
    private static int nextVector = 0;
    public double xCoord;
    public double yCoord;
    public double zCoord;

    public static Vec3D createVectorHelper(double d2, double d1, double d22) {
        return new Vec3D(d2, d1, d22);
    }

    public static void initialize() {
        nextVector = 0;
    }

    public static Vec3D createVector(double d2, double d1, double d22) {
        if (nextVector >= vectorList.size()) {
            vectorList.add(Vec3D.createVectorHelper(0.0, 0.0, 0.0));
        }
        return ((Vec3D)vectorList.get(nextVector++)).setComponents(d2, d1, d22);
    }

    private Vec3D(double d2, double d1, double d22) {
        if (d2 == -0.0) {
            d2 = 0.0;
        }
        if (d1 == -0.0) {
            d1 = 0.0;
        }
        if (d22 == -0.0) {
            d22 = 0.0;
        }
        this.xCoord = d2;
        this.yCoord = d1;
        this.zCoord = d22;
    }

    private Vec3D setComponents(double d2, double d1, double d22) {
        this.xCoord = d2;
        this.yCoord = d1;
        this.zCoord = d22;
        return this;
    }

    public Vec3D subtract(Vec3D vec3d) {
        return Vec3D.createVector(vec3d.xCoord - this.xCoord, vec3d.yCoord - this.yCoord, vec3d.zCoord - this.zCoord);
    }

    public Vec3D normalize() {
        double d2 = MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
        if (d2 < 1.0E-4) {
            return Vec3D.createVector(0.0, 0.0, 0.0);
        }
        return Vec3D.createVector(this.xCoord / d2, this.yCoord / d2, this.zCoord / d2);
    }

    public Vec3D crossProduct(Vec3D vec3d) {
        return Vec3D.createVector(this.yCoord * vec3d.zCoord - this.zCoord * vec3d.yCoord, this.zCoord * vec3d.xCoord - this.xCoord * vec3d.zCoord, this.xCoord * vec3d.yCoord - this.yCoord * vec3d.xCoord);
    }

    public Vec3D addVector(double d2, double d1, double d22) {
        return Vec3D.createVector(this.xCoord + d2, this.yCoord + d1, this.zCoord + d22);
    }

    public double distanceTo(Vec3D vec3d) {
        double d2 = vec3d.xCoord - this.xCoord;
        double d1 = vec3d.yCoord - this.yCoord;
        double d22 = vec3d.zCoord - this.zCoord;
        return MathHelper.sqrt_double(d2 * d2 + d1 * d1 + d22 * d22);
    }

    public double squareDistanceTo(Vec3D vec3d) {
        double d2 = vec3d.xCoord - this.xCoord;
        double d1 = vec3d.yCoord - this.yCoord;
        double d22 = vec3d.zCoord - this.zCoord;
        return d2 * d2 + d1 * d1 + d22 * d22;
    }

    public double squareDistanceTo(double d2, double d1, double d22) {
        double d3 = d2 - this.xCoord;
        double d4 = d1 - this.yCoord;
        double d5 = d22 - this.zCoord;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public double lengthVector() {
        return MathHelper.sqrt_double(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
    }

    public Vec3D getIntermediateWithXValue(Vec3D vec3d, double d2) {
        double d1 = vec3d.xCoord - this.xCoord;
        double d22 = vec3d.yCoord - this.yCoord;
        double d3 = vec3d.zCoord - this.zCoord;
        if (d1 * d1 < (double)1.0E-7f) {
            return null;
        }
        double d4 = (d2 - this.xCoord) / d1;
        if (d4 < 0.0 || d4 > 1.0) {
            return null;
        }
        return Vec3D.createVector(this.xCoord + d1 * d4, this.yCoord + d22 * d4, this.zCoord + d3 * d4);
    }

    public Vec3D getIntermediateWithYValue(Vec3D vec3d, double d2) {
        double d1 = vec3d.xCoord - this.xCoord;
        double d22 = vec3d.yCoord - this.yCoord;
        double d3 = vec3d.zCoord - this.zCoord;
        if (d22 * d22 < (double)1.0E-7f) {
            return null;
        }
        double d4 = (d2 - this.yCoord) / d22;
        if (d4 < 0.0 || d4 > 1.0) {
            return null;
        }
        return Vec3D.createVector(this.xCoord + d1 * d4, this.yCoord + d22 * d4, this.zCoord + d3 * d4);
    }

    public Vec3D getIntermediateWithZValue(Vec3D vec3d, double d2) {
        double d1 = vec3d.xCoord - this.xCoord;
        double d22 = vec3d.yCoord - this.yCoord;
        double d3 = vec3d.zCoord - this.zCoord;
        if (d3 * d3 < (double)1.0E-7f) {
            return null;
        }
        double d4 = (d2 - this.zCoord) / d3;
        if (d4 < 0.0 || d4 > 1.0) {
            return null;
        }
        return Vec3D.createVector(this.xCoord + d1 * d4, this.yCoord + d22 * d4, this.zCoord + d3 * d4);
    }

    public String toString() {
        return "(" + this.xCoord + ", " + this.yCoord + ", " + this.zCoord + ")";
    }

    public void rotateAroundX(float f2) {
        float f1 = MathHelper.cos(f2);
        float f22 = MathHelper.sin(f2);
        double d2 = this.xCoord;
        double d1 = this.yCoord * (double)f1 + this.zCoord * (double)f22;
        double d22 = this.zCoord * (double)f1 - this.yCoord * (double)f22;
        this.xCoord = d2;
        this.yCoord = d1;
        this.zCoord = d22;
    }

    public void rotateAroundY(float f2) {
        float f1 = MathHelper.cos(f2);
        float f22 = MathHelper.sin(f2);
        double d2 = this.xCoord * (double)f1 + this.zCoord * (double)f22;
        double d1 = this.yCoord;
        double d22 = this.zCoord * (double)f1 - this.xCoord * (double)f22;
        this.xCoord = d2;
        this.yCoord = d1;
        this.zCoord = d22;
    }
}

