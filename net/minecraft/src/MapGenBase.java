/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;

public class MapGenBase {
    protected int field_1306_a = 8;
    protected Random field_1305_b = new Random();

    public void func_867_a(IChunkProvider ichunkprovider, World world, int i2, int j2, byte[] abyte0) {
        int k2 = this.field_1306_a;
        this.field_1305_b.setSeed(world.randomSeed);
        long l2 = this.field_1305_b.nextLong() / 2L * 2L + 1L;
        long l1 = this.field_1305_b.nextLong() / 2L * 2L + 1L;
        for (int i1 = i2 - k2; i1 <= i2 + k2; ++i1) {
            for (int j1 = j2 - k2; j1 <= j2 + k2; ++j1) {
                this.field_1305_b.setSeed((long)i1 * l2 + (long)j1 * l1 ^ world.randomSeed);
                this.func_868_a(world, i1, j1, i2, j2, abyte0);
            }
        }
    }

    protected void func_868_a(World world, int i2, int j2, int k2, int l2, byte[] abyte0) {
    }
}

