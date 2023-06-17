/*
 * Decompiled with CFR 0.150.
 */
import java.io.File;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;

public class Start {
    public static void main(String[] args) {
        try {
            Field f2 = Minecraft.class.getDeclaredField("minecraftDir");
            Field.setAccessible(new Field[]{f2}, true);
            f2.set(null, new File("jars"));
        }
        catch (Exception e2) {
            e2.printStackTrace();
            return;
        }
        Minecraft.main(args);
        Thread[] threads = new Thread[256];
        int count = Thread.enumerate(threads);
        Minecraft mc2 = null;
        for (int i2 = 0; i2 < count; ++i2) {
            if (!threads[i2].getName().equals("Minecraft main thread")) continue;
            try {
                Field f3 = Thread.class.getDeclaredField("target");
                Field.setAccessible(new Field[]{f3}, true);
                mc2 = (Minecraft)f3.get(threads[i2]);
            }
            catch (Exception e3) {
                e3.printStackTrace();
                System.exit(0);
            }
            break;
        }
    }
}

