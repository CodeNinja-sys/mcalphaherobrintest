/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.ClippingHelper;
import net.minecraft.src.ClippingHelperImplementation;
import net.minecraft.src.ICamera;

public class Frustrum
implements ICamera {
    private ClippingHelper field_593_a = ClippingHelperImplementation.func_1155_a();
    private double field_592_b;
    private double field_595_c;
    private double field_594_d;

    @Override
    public void func_343_a(double d2, double d1, double d22) {
        this.field_592_b = d2;
        this.field_595_c = d1;
        this.field_594_d = d22;
    }

    public boolean func_344_a(double d2, double d1, double d22, double d3, double d4, double d5) {
        return this.field_593_a.func_1152_a(d2 - this.field_592_b, d1 - this.field_595_c, d22 - this.field_594_d, d3 - this.field_592_b, d4 - this.field_595_c, d5 - this.field_594_d);
    }

    @Override
    public boolean func_342_a(AxisAlignedBB axisalignedbb) {
        return this.func_344_a(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.maxY, axisalignedbb.maxZ);
    }
}

