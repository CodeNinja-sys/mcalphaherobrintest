/*
 * Decompiled with CFR 0.150.
 */
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ft {
    private static final int[] a = new int[65536];

    public static int a(double d2, double d3) {
        int n2 = (int)((1.0 - d2) * 255.0);
        int n3 = (int)((1.0 - (d3 *= d2)) * 255.0);
        return a[n3 << 8 | n2];
    }

    static {
        try {
            BufferedImage bufferedImage = ImageIO.read(ft.class.getResource("/misc/foliagecolor.png"));
            bufferedImage.getRGB(0, 0, 256, 256, a, 0, 256);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

