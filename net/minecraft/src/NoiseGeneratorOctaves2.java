/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.NoiseGenerator;
import net.minecraft.src.NoiseGenerator2;

public class NoiseGeneratorOctaves2
extends NoiseGenerator {
    private NoiseGenerator2[] field_4234_a;
    private int field_4233_b;

    public NoiseGeneratorOctaves2(Random random, int i2) {
        this.field_4233_b = i2;
        this.field_4234_a = new NoiseGenerator2[i2];
        for (int j2 = 0; j2 < i2; ++j2) {
            this.field_4234_a[j2] = new NoiseGenerator2(random);
        }
    }

    public double[] func_4112_a(double[] ad2, double d2, double d1, int i2, int j2, double d22, double d3, double d4) {
        return this.func_4111_a(ad2, d2, d1, i2, j2, d22, d3, d4, 0.5);
    }

    public double[] func_4111_a(double[] ad2, double d2, double d1, int i2, int j2, double d22, double d3, double d4, double d5) {
        d22 /= 1.5;
        d3 /= 1.5;
        if (ad2 == null || ad2.length < i2 * j2) {
            ad2 = new double[i2 * j2];
        } else {
            for (int k2 = 0; k2 < ad2.length; ++k2) {
                ad2[k2] = 0.0;
            }
        }
        double d6 = 1.0;
        double d7 = 1.0;
        for (int l2 = 0; l2 < this.field_4233_b; ++l2) {
            this.field_4234_a[l2].func_4157_a(ad2, d2, d1, i2, j2, d22 * d7, d3 * d7, 0.55 / d6);
            d7 *= d4;
            d6 *= d5;
        }
        return ad2;
    }
}

