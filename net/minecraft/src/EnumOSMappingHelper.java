/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EnumOS2;

public class EnumOSMappingHelper {
    public static final int[] field_1585_a = new int[EnumOS2.values().length];

    static {
        try {
            EnumOSMappingHelper.field_1585_a[EnumOS2.linux.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumOSMappingHelper.field_1585_a[EnumOS2.solaris.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumOSMappingHelper.field_1585_a[EnumOS2.windows.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            EnumOSMappingHelper.field_1585_a[EnumOS2.macos.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

