/*
 * Decompiled with CFR 0.150.
 */
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class jm
extends d {
    private int e = -1;
    private BufferedImage f;

    public jm() {
        this.a = "Default";
        this.b = "The default look of Minecraft";
        try {
            this.f = ImageIO.read(jm.class.getResource("/pack.png"));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void b(Minecraft minecraft) {
        if (this.f != null) {
            minecraft.n.a(this.e);
        }
    }

    public void c(Minecraft minecraft) {
        if (this.f != null && this.e < 0) {
            this.e = minecraft.n.a(this.f);
        }
        if (this.f != null) {
            minecraft.n.b(this.e);
        } else {
            GL11.glBindTexture(3553, minecraft.n.a("/gui/unknown_pack.png"));
        }
    }
}

