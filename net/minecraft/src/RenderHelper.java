/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.nio.FloatBuffer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.Vec3D;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    private static FloatBuffer field_1695_a = GLAllocation.createDirectFloatBuffer(16);

    public static void disableStandardItemLighting() {
        GL11.glDisable(2896);
        GL11.glDisable(16384);
        GL11.glDisable(16385);
        GL11.glDisable(2903);
    }

    public static void enableStandardItemLighting() {
        GL11.glEnable(2896);
        GL11.glEnable(16384);
        GL11.glEnable(16385);
        GL11.glEnable(2903);
        GL11.glColorMaterial(1032, 5634);
        float f2 = 0.4f;
        float f1 = 0.6f;
        float f22 = 0.0f;
        Vec3D vec3d = Vec3D.createVector(0.2f, 1.0, -0.7f).normalize();
        GL11.glLight(16384, 4611, RenderHelper.func_1157_a(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord, 0.0));
        GL11.glLight(16384, 4609, RenderHelper.func_1156_a(f1, f1, f1, 1.0f));
        GL11.glLight(16384, 4608, RenderHelper.func_1156_a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16384, 4610, RenderHelper.func_1156_a(f22, f22, f22, 1.0f));
        vec3d = Vec3D.createVector(-0.2f, 1.0, 0.7f).normalize();
        GL11.glLight(16385, 4611, RenderHelper.func_1157_a(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord, 0.0));
        GL11.glLight(16385, 4609, RenderHelper.func_1156_a(f1, f1, f1, 1.0f));
        GL11.glLight(16385, 4608, RenderHelper.func_1156_a(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLight(16385, 4610, RenderHelper.func_1156_a(f22, f22, f22, 1.0f));
        GL11.glShadeModel(7424);
        GL11.glLightModel(2899, RenderHelper.func_1156_a(f2, f2, f2, 1.0f));
    }

    private static FloatBuffer func_1157_a(double d2, double d1, double d22, double d3) {
        return RenderHelper.func_1156_a((float)d2, (float)d1, (float)d22, (float)d3);
    }

    private static FloatBuffer func_1156_a(float f2, float f1, float f22, float f3) {
        field_1695_a.clear();
        field_1695_a.put(f2).put(f1).put(f22).put(f3);
        field_1695_a.flip();
        return field_1695_a;
    }
}

