/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Item;

public class ItemArmor
extends Item {
    private static final int[] damageReduceAmmountArray = new int[]{3, 8, 6, 3};
    private static final int[] maxDamageArray = new int[]{11, 16, 15, 13};
    public final int armorLevel;
    public final int armorType;
    public final int damageReduceAmmount;
    public final int renderIndex;

    public ItemArmor(int i2, int j2, int k2, int l2) {
        super(i2);
        this.armorLevel = j2;
        this.armorType = l2;
        this.renderIndex = k2;
        this.damageReduceAmmount = damageReduceAmmountArray[l2];
        this.maxDamage = maxDamageArray[l2] * 3 << j2;
        this.maxStackSize = 1;
    }
}

