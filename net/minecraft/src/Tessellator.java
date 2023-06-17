/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import net.minecraft.src.GLAllocation;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Tessellator {
    private static boolean convertQuadsToTriangles = true;
    private static boolean tryVBO = false;
    private ByteBuffer byteBuffer;
    private IntBuffer intBuffer;
    private FloatBuffer floatBuffer;
    private int[] rawBuffer;
    private int vertexCount = 0;
    private double textureU;
    private double textureV;
    private int color;
    private boolean hasColor = false;
    private boolean hasTexture = false;
    private boolean hasNormals = false;
    private int rawBufferIndex = 0;
    private int addedVertices = 0;
    private boolean isColorDisabled = false;
    private int drawMode;
    private double xOffset;
    private double yOffset;
    private double zOffset;
    private int normal;
    public static final Tessellator instance = new Tessellator(0x200000);
    private boolean isDrawing = false;
    private boolean useVBO = false;
    private IntBuffer vertexBuffers;
    private int vboIndex = 0;
    private int vboCount = 10;
    private int bufferSize;

    private Tessellator(int i2) {
        this.bufferSize = i2;
        this.byteBuffer = GLAllocation.createDirectByteBuffer(i2 * 4);
        this.intBuffer = this.byteBuffer.asIntBuffer();
        this.floatBuffer = this.byteBuffer.asFloatBuffer();
        this.rawBuffer = new int[i2];
        boolean bl2 = this.useVBO = tryVBO && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
        if (this.useVBO) {
            this.vertexBuffers = GLAllocation.createDirectIntBuffer(this.vboCount);
            ARBVertexBufferObject.glGenBuffersARB(this.vertexBuffers);
        }
    }

    public void draw() {
        if (!this.isDrawing) {
            throw new IllegalStateException("Not tesselating!");
        }
        this.isDrawing = false;
        if (this.vertexCount > 0) {
            this.intBuffer.clear();
            this.intBuffer.put(this.rawBuffer, 0, this.rawBufferIndex);
            this.byteBuffer.position(0);
            this.byteBuffer.limit(this.rawBufferIndex * 4);
            if (this.useVBO) {
                this.vboIndex = (this.vboIndex + 1) % this.vboCount;
                ARBVertexBufferObject.glBindBufferARB(34962, this.vertexBuffers.get(this.vboIndex));
                ARBVertexBufferObject.glBufferDataARB(34962, this.byteBuffer, 35040);
            }
            if (this.hasTexture) {
                if (this.useVBO) {
                    GL11.glTexCoordPointer(2, 5126, 32, 12L);
                } else {
                    this.floatBuffer.position(3);
                    GL11.glTexCoordPointer(2, 32, this.floatBuffer);
                }
                GL11.glEnableClientState(32888);
            }
            if (this.hasColor) {
                if (this.useVBO) {
                    GL11.glColorPointer(4, 5121, 32, 20L);
                } else {
                    this.byteBuffer.position(20);
                    GL11.glColorPointer(4, true, 32, this.byteBuffer);
                }
                GL11.glEnableClientState(32886);
            }
            if (this.hasNormals) {
                if (this.useVBO) {
                    GL11.glNormalPointer(5120, 32, 24L);
                } else {
                    this.byteBuffer.position(24);
                    GL11.glNormalPointer(32, this.byteBuffer);
                }
                GL11.glEnableClientState(32885);
            }
            if (this.useVBO) {
                GL11.glVertexPointer(3, 5126, 32, 0L);
            } else {
                this.floatBuffer.position(0);
                GL11.glVertexPointer(3, 32, this.floatBuffer);
            }
            GL11.glEnableClientState(32884);
            if (this.drawMode == 7 && convertQuadsToTriangles) {
                GL11.glDrawArrays(4, 0, this.vertexCount);
            } else {
                GL11.glDrawArrays(this.drawMode, 0, this.vertexCount);
            }
            GL11.glDisableClientState(32884);
            if (this.hasTexture) {
                GL11.glDisableClientState(32888);
            }
            if (this.hasColor) {
                GL11.glDisableClientState(32886);
            }
            if (this.hasNormals) {
                GL11.glDisableClientState(32885);
            }
        }
        this.reset();
    }

    private void reset() {
        this.vertexCount = 0;
        this.byteBuffer.clear();
        this.rawBufferIndex = 0;
        this.addedVertices = 0;
    }

    public void startDrawingQuads() {
        this.startDrawing(7);
    }

    public void startDrawing(int i2) {
        if (this.isDrawing) {
            throw new IllegalStateException("Already tesselating!");
        }
        this.isDrawing = true;
        this.reset();
        this.drawMode = i2;
        this.hasNormals = false;
        this.hasColor = false;
        this.hasTexture = false;
        this.isColorDisabled = false;
    }

    public void setTextureUV(double d2, double d1) {
        this.hasTexture = true;
        this.textureU = d2;
        this.textureV = d1;
    }

    public void setColorOpaque_F(float f2, float f1, float f22) {
        this.setColorOpaque((int)(f2 * 255.0f), (int)(f1 * 255.0f), (int)(f22 * 255.0f));
    }

    public void setColorRGBA_F(float f2, float f1, float f22, float f3) {
        this.setColorRGBA((int)(f2 * 255.0f), (int)(f1 * 255.0f), (int)(f22 * 255.0f), (int)(f3 * 255.0f));
    }

    public void setColorOpaque(int i2, int j2, int k2) {
        this.setColorRGBA(i2, j2, k2, 255);
    }

    public void setColorRGBA(int i2, int j2, int k2, int l2) {
        if (this.isColorDisabled) {
            return;
        }
        if (i2 > 255) {
            i2 = 255;
        }
        if (j2 > 255) {
            j2 = 255;
        }
        if (k2 > 255) {
            k2 = 255;
        }
        if (l2 > 255) {
            l2 = 255;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (j2 < 0) {
            j2 = 0;
        }
        if (k2 < 0) {
            k2 = 0;
        }
        if (l2 < 0) {
            l2 = 0;
        }
        this.hasColor = true;
        this.color = l2 << 24 | k2 << 16 | j2 << 8 | i2;
    }

    public void addVertexWithUV(double d2, double d1, double d22, double d3, double d4) {
        this.setTextureUV(d3, d4);
        this.addVertex(d2, d1, d22);
    }

    public void addVertex(double d2, double d1, double d22) {
        ++this.addedVertices;
        if (this.drawMode == 7 && convertQuadsToTriangles && this.addedVertices % 4 == 0) {
            for (int i2 = 0; i2 < 2; ++i2) {
                int j2 = 8 * (3 - i2);
                if (this.hasTexture) {
                    this.rawBuffer[this.rawBufferIndex + 3] = this.rawBuffer[this.rawBufferIndex - j2 + 3];
                    this.rawBuffer[this.rawBufferIndex + 4] = this.rawBuffer[this.rawBufferIndex - j2 + 4];
                }
                if (this.hasColor) {
                    this.rawBuffer[this.rawBufferIndex + 5] = this.rawBuffer[this.rawBufferIndex - j2 + 5];
                }
                this.rawBuffer[this.rawBufferIndex + 0] = this.rawBuffer[this.rawBufferIndex - j2 + 0];
                this.rawBuffer[this.rawBufferIndex + 1] = this.rawBuffer[this.rawBufferIndex - j2 + 1];
                this.rawBuffer[this.rawBufferIndex + 2] = this.rawBuffer[this.rawBufferIndex - j2 + 2];
                ++this.vertexCount;
                this.rawBufferIndex += 8;
            }
        }
        if (this.hasTexture) {
            this.rawBuffer[this.rawBufferIndex + 3] = Float.floatToRawIntBits((float)this.textureU);
            this.rawBuffer[this.rawBufferIndex + 4] = Float.floatToRawIntBits((float)this.textureV);
        }
        if (this.hasColor) {
            this.rawBuffer[this.rawBufferIndex + 5] = this.color;
        }
        if (this.hasNormals) {
            this.rawBuffer[this.rawBufferIndex + 6] = this.normal;
        }
        this.rawBuffer[this.rawBufferIndex + 0] = Float.floatToRawIntBits((float)(d2 + this.xOffset));
        this.rawBuffer[this.rawBufferIndex + 1] = Float.floatToRawIntBits((float)(d1 + this.yOffset));
        this.rawBuffer[this.rawBufferIndex + 2] = Float.floatToRawIntBits((float)(d22 + this.zOffset));
        this.rawBufferIndex += 8;
        ++this.vertexCount;
        if (this.vertexCount % 4 == 0 && this.rawBufferIndex >= this.bufferSize - 32) {
            this.draw();
            this.isDrawing = true;
        }
    }

    public void setColorOpaque_I(int i2) {
        int j2 = i2 >> 16 & 0xFF;
        int k2 = i2 >> 8 & 0xFF;
        int l2 = i2 & 0xFF;
        this.setColorOpaque(j2, k2, l2);
    }

    public void setColorRGBA_I(int i2, int j2) {
        int k2 = i2 >> 16 & 0xFF;
        int l2 = i2 >> 8 & 0xFF;
        int i1 = i2 & 0xFF;
        this.setColorRGBA(k2, l2, i1, j2);
    }

    public void disableColor() {
        this.isColorDisabled = true;
    }

    public void setNormal(float f2, float f1, float f22) {
        if (!this.isDrawing) {
            System.out.println("But..");
        }
        this.hasNormals = true;
        byte byte0 = (byte)(f2 * 128.0f);
        byte byte1 = (byte)(f1 * 127.0f);
        byte byte2 = (byte)(f22 * 127.0f);
        this.normal = byte0 | byte1 << 8 | byte2 << 16;
    }

    public void setTranslationD(double d2, double d1, double d22) {
        this.xOffset = d2;
        this.yOffset = d1;
        this.zOffset = d22;
    }

    public void setTranslationF(float f2, float f1, float f22) {
        this.xOffset += (double)f2;
        this.yOffset += (double)f1;
        this.zOffset += (double)f22;
    }
}

