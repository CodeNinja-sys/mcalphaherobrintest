/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class GLAllocation {
    private static List displayLists = new ArrayList();
    private static List textureNames = new ArrayList();

    public static synchronized int generateDisplayLists(int i2) {
        int j2 = GL11.glGenLists(i2);
        displayLists.add(j2);
        displayLists.add(i2);
        return j2;
    }

    public static synchronized void generateTextureNames(IntBuffer intbuffer) {
        GL11.glGenTextures(intbuffer);
        for (int i2 = intbuffer.position(); i2 < intbuffer.limit(); ++i2) {
            textureNames.add(intbuffer.get(i2));
        }
    }

    public static synchronized void deleteTexturesAndDisplayLists() {
        for (int i2 = 0; i2 < displayLists.size(); i2 += 2) {
            GL11.glDeleteLists((Integer)displayLists.get(i2), (Integer)displayLists.get(i2 + 1));
        }
        IntBuffer intbuffer = GLAllocation.createDirectIntBuffer(textureNames.size());
        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        for (int j2 = 0; j2 < textureNames.size(); ++j2) {
            intbuffer.put((Integer)textureNames.get(j2));
        }
        intbuffer.flip();
        GL11.glDeleteTextures(intbuffer);
        displayLists.clear();
        textureNames.clear();
    }

    public static synchronized ByteBuffer createDirectByteBuffer(int i2) {
        ByteBuffer bytebuffer = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        return bytebuffer;
    }

    public static IntBuffer createDirectIntBuffer(int i2) {
        return GLAllocation.createDirectByteBuffer(i2 << 2).asIntBuffer();
    }

    public static FloatBuffer createDirectFloatBuffer(int i2) {
        return GLAllocation.createDirectByteBuffer(i2 << 2).asFloatBuffer();
    }
}

