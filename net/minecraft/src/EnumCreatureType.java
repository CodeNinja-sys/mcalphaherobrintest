/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityAnimals;
import net.minecraft.src.IMobs;

public enum EnumCreatureType {
    monster(IMobs.class, 100),
    creature(EntityAnimals.class, 20);

    public final Class field_4278_c;
    public final int maxNumberOfEntityType;

    private EnumCreatureType(Class class1, int j2) {
        this.field_4278_c = class1;
        this.maxNumberOfEntityType = j2;
    }
}

