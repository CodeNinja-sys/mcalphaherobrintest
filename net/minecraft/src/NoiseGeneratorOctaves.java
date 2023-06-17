/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.NoiseGenerator;
import net.minecraft.src.NoiseGeneratorPerlin;

public class NoiseGeneratorOctaves
extends NoiseGenerator {
    private NoiseGeneratorPerlin[] generatorCollection;
    private int field_1191_b;

    public NoiseGeneratorOctaves(Random random, int i2) {
        this.field_1191_b = i2;
        this.generatorCollection = new NoiseGeneratorPerlin[i2];
        for (int j2 = 0; j2 < i2; ++j2) {
            this.generatorCollection[j2] = new NoiseGeneratorPerlin(random);
        }
    }

    public double func_806_a(double d2, double d1) {
        double d22 = 0.0;
        double d3 = 1.0;
        for (int i2 = 0; i2 < this.field_1191_b; ++i2) {
            d22 += this.generatorCollection[i2].func_801_a(d2 * d3, d1 * d3) / d3;
            d3 /= 2.0;
        }
        return d22;
    }

    public double[] func_807_a(double[] ad2, double d2, double d1, double d22, int i2, int j2, int k2, double d3, double d4, double d5) {
        if (ad2 == null) {
            ad2 = new double[i2 * j2 * k2];
        } else {
            for (int l2 = 0; l2 < ad2.length; ++l2) {
                ad2[l2] = 0.0;
            }
        }
        double d6 = 1.0;
        for (int i1 = 0; i1 < this.field_1191_b; ++i1) {
            this.generatorCollection[i1].func_805_a(ad2, d2, d1, d22, i2, j2, k2, d3 * d6, d4 * d6, d5 * d6, d6);
            d6 /= 2.0;
        }
        return ad2;
    }

    public double[] func_4109_a(double[] ad2, int i2, int j2, int k2, int l2, double d2, double d1, double d22) {
        return this.func_807_a(ad2, i2, 10.0, j2, k2, 1, l2, d2, 1.0, d1);
    }
}

