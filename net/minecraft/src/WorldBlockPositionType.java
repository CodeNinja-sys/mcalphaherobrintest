/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.WorldClient;

class WorldBlockPositionType {
    int field_1202_a;
    int field_1201_b;
    int field_1207_c;
    int field_1206_d;
    int field_1205_e;
    int field_1204_f;
    final WorldClient field_1203_g;

    public WorldBlockPositionType(WorldClient worldclient, int i2, int j2, int k2, int l2, int i1) {
        this.field_1203_g = worldclient;
        this.field_1202_a = i2;
        this.field_1201_b = j2;
        this.field_1207_c = k2;
        this.field_1206_d = 80;
        this.field_1205_e = l2;
        this.field_1204_f = i1;
    }
}

