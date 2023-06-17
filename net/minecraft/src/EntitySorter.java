/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.Entity;
import net.minecraft.src.WorldRenderer;

public class EntitySorter
implements Comparator {
    private Entity field_1594_a;

    public EntitySorter(Entity entity) {
        this.field_1594_a = entity;
    }

    public int func_1063_a(WorldRenderer worldrenderer, WorldRenderer worldrenderer1) {
        return worldrenderer.func_1202_a(this.field_1594_a) >= worldrenderer1.func_1202_a(this.field_1594_a) ? 1 : -1;
    }

    public int compare(Object obj, Object obj1) {
        return this.func_1063_a((WorldRenderer)obj, (WorldRenderer)obj1);
    }
}

