/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityRainFX;
import net.minecraft.src.World;

public class EntitySplashFX
extends EntityRainFX {
    public EntitySplashFX(World world, double d2, double d1, double d22, double d3, double d4, double d5) {
        super(world, d2, d1, d22);
        this.field_664_h = 0.04f;
        ++this.field_670_b;
        if (d4 == 0.0 && (d3 != 0.0 || d5 != 0.0)) {
            this.motionX = d3;
            this.motionY = d4 + 0.1;
            this.motionZ = d5;
        }
    }
}

