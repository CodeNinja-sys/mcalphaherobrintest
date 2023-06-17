/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.WorldRenderer;

public class RenderSorter
implements Comparator {
    private EntityPlayer field_4274_a;

    public RenderSorter(EntityPlayer entityplayer) {
        this.field_4274_a = entityplayer;
    }

    public int func_993_a(WorldRenderer worldrenderer, WorldRenderer worldrenderer1) {
        double d1;
        boolean flag = worldrenderer.field_1749_o;
        boolean flag1 = worldrenderer1.field_1749_o;
        if (flag && !flag1) {
            return 1;
        }
        if (flag1 && !flag) {
            return -1;
        }
        double d2 = worldrenderer.func_1202_a(this.field_4274_a);
        if (d2 < (d1 = (double)worldrenderer1.func_1202_a(this.field_4274_a))) {
            return 1;
        }
        if (d2 > d1) {
            return -1;
        }
        return worldrenderer.field_1735_w >= worldrenderer1.field_1735_w ? -1 : 1;
    }

    public int compare(Object obj, Object obj1) {
        return this.func_993_a((WorldRenderer)obj, (WorldRenderer)obj1);
    }
}

