/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.src.TexturePackBase;
import org.lwjgl.opengl.GL11;

public class TexturePackDefault
extends TexturePackBase {
    private int texturePackName = -1;
    private BufferedImage field_6490_f;

    public TexturePackDefault() {
        this.texturePackFileName = "Default";
        this.firstDescriptionLine = "The default look of Minecraft";
        try {
            this.field_6490_f = ImageIO.read(TexturePackDefault.class.getResource("/pack.png"));
        }
        catch (IOException ioexception) {
            ioexception.printStackTrace();
        }
    }

    @Override
    public void func_6484_b(Minecraft minecraft) {
        if (this.field_6490_f != null) {
            minecraft.renderEngine.deleteTexture(this.texturePackName);
        }
    }

    @Override
    public void func_6483_c(Minecraft minecraft) {
        if (this.field_6490_f != null && this.texturePackName < 0) {
            this.texturePackName = minecraft.renderEngine.allocateAndSetupTexture(this.field_6490_f);
        }
        if (this.field_6490_f != null) {
            minecraft.renderEngine.bindTexture(this.texturePackName);
        } else {
            GL11.glBindTexture(3553, minecraft.renderEngine.getTexture("/gui/unknown_pack.png"));
        }
    }
}

