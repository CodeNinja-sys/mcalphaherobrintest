/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import net.minecraft.src.ColorizerFoliage;

public class ColorizerGrass {
    private static final int[] field_6540_a = new int[65536];

    static {
        try {
            BufferedImage bufferedimage = ImageIO.read(ColorizerFoliage.class.getResource("/misc/grasscolor.png"));
            bufferedimage.getRGB(0, 0, 256, 256, field_6540_a, 0, 256);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static int func_4147_a(double d2, double d1) {
        int i2 = (int)((1.0 - d2) * 255.0);
        int j2 = (int)((1.0 - (d1 *= d2)) * 255.0);
        return field_6540_a[j2 << 8 | i2];
    }

    static Class _mthclass$(String s2) {
        try {
            return Class.forName(s2);
        }
        catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}

