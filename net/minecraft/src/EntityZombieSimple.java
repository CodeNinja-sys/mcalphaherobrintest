/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityMobs;
import net.minecraft.src.World;

public class EntityZombieSimple
extends EntityMobs {
    public EntityZombieSimple(World world) {
        super(world);
        this.texture = "/mob/zombie.png";
        this.field_9333_am = 0.5f;
        this.field_762_e = 50;
        this.health *= 10;
        this.yOffset *= 6.0f;
        this.setSize(this.width * 6.0f, this.height * 6.0f);
    }

    @Override
    protected float func_439_a(int i2, int j2, int k2) {
        return this.worldObj.getLightBrightness(i2, j2, k2) - 0.5f;
    }
}

