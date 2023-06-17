/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper {
    private static DateFormat field_4287_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
    private static ByteBuffer field_4286_b;
    private static byte[] field_4289_c;
    private static int[] field_4288_d;

    public static String func_4148_a(File file, int i2, int j2) {
        try {
            File file2;
            File file1 = new File(file, "screenshots");
            file1.mkdir();
            if (field_4286_b == null || field_4286_b.capacity() < i2 * j2 * 3) {
                field_4286_b = BufferUtils.createByteBuffer(i2 * j2 * 3);
                field_4289_c = new byte[i2 * j2 * 3];
                field_4288_d = new int[i2 * j2];
            }
            GL11.glPixelStorei(3333, 1);
            GL11.glPixelStorei(3317, 1);
            field_4286_b.clear();
            GL11.glReadPixels(0, 0, i2, j2, 6407, 5121, field_4286_b);
            field_4286_b.clear();
            String s2 = "" + field_4287_a.format(new Date());
            int k2 = 1;
            while ((file2 = new File(file1, s2 + (k2 != 1 ? "_" + k2 : "") + ".png")).exists()) {
                ++k2;
            }
            field_4286_b.get(field_4289_c);
            for (int l2 = 0; l2 < i2; ++l2) {
                for (int i1 = 0; i1 < j2; ++i1) {
                    int j22;
                    int j1 = l2 + (j2 - i1 - 1) * i2;
                    int k1 = field_4289_c[j1 * 3 + 0] & 0xFF;
                    int l1 = field_4289_c[j1 * 3 + 1] & 0xFF;
                    int i22 = field_4289_c[j1 * 3 + 2] & 0xFF;
                    ScreenShotHelper.field_4288_d[l2 + i1 * i2] = j22 = 0xFF000000 | k1 << 16 | l1 << 8 | i22;
                }
            }
            BufferedImage bufferedimage = new BufferedImage(i2, j2, 1);
            bufferedimage.setRGB(0, 0, i2, j2, field_4288_d, 0, i2);
            ImageIO.write((RenderedImage)bufferedimage, "png", file2);
            return "Saved screenshot as " + file2.getName();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "Failed to save: " + exception;
        }
    }
}

