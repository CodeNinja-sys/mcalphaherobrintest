/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import net.minecraft.src.World;

public class IsoImageBuffer {
    public BufferedImage field_1348_a;
    public World worldObj;
    public int field_1354_c;
    public int field_1353_d;
    public boolean field_1352_e = false;
    public boolean field_1351_f = false;
    public int field_1350_g = 0;
    public boolean field_1349_h = false;

    public IsoImageBuffer(World world, int i2, int j2) {
        this.worldObj = world;
        this.func_889_a(i2, j2);
    }

    public void func_889_a(int i2, int j2) {
        this.field_1352_e = false;
        this.field_1354_c = i2;
        this.field_1353_d = j2;
        this.field_1350_g = 0;
        this.field_1349_h = false;
    }

    public void func_888_a(World world, int i2, int j2) {
        this.worldObj = world;
        this.func_889_a(i2, j2);
    }
}

