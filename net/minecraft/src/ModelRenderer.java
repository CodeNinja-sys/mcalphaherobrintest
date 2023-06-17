/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.GLAllocation;
import net.minecraft.src.PositionTexureVertex;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TexturedQuad;
import org.lwjgl.opengl.GL11;

public class ModelRenderer {
    private PositionTexureVertex[] corners;
    private TexturedQuad[] faces;
    private int textureOffsetX;
    private int textureOffsetY;
    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    private boolean compiled = false;
    private int displayList = 0;
    public boolean mirror = false;
    public boolean field_1403_h = true;
    public boolean field_1402_i = false;

    public ModelRenderer(int i2, int j2) {
        this.textureOffsetX = i2;
        this.textureOffsetY = j2;
    }

    public void func_921_a(float f2, float f1, float f22, int i2, int j2, int k2) {
        this.addBox(f2, f1, f22, i2, j2, k2, 0.0f);
    }

    public void addBox(float f2, float f1, float f22, int i2, int j2, int k2, float f3) {
        this.corners = new PositionTexureVertex[8];
        this.faces = new TexturedQuad[6];
        float f4 = f2 + (float)i2;
        float f5 = f1 + (float)j2;
        float f6 = f22 + (float)k2;
        f2 -= f3;
        f1 -= f3;
        f22 -= f3;
        f4 += f3;
        f5 += f3;
        f6 += f3;
        if (this.mirror) {
            float f7 = f4;
            f4 = f2;
            f2 = f7;
        }
        PositionTexureVertex positiontexurevertex = new PositionTexureVertex(f2, f1, f22, 0.0f, 0.0f);
        PositionTexureVertex positiontexurevertex1 = new PositionTexureVertex(f4, f1, f22, 0.0f, 8.0f);
        PositionTexureVertex positiontexurevertex2 = new PositionTexureVertex(f4, f5, f22, 8.0f, 8.0f);
        PositionTexureVertex positiontexurevertex3 = new PositionTexureVertex(f2, f5, f22, 8.0f, 0.0f);
        PositionTexureVertex positiontexurevertex4 = new PositionTexureVertex(f2, f1, f6, 0.0f, 0.0f);
        PositionTexureVertex positiontexurevertex5 = new PositionTexureVertex(f4, f1, f6, 0.0f, 8.0f);
        PositionTexureVertex positiontexurevertex6 = new PositionTexureVertex(f4, f5, f6, 8.0f, 8.0f);
        PositionTexureVertex positiontexurevertex7 = new PositionTexureVertex(f2, f5, f6, 8.0f, 0.0f);
        this.corners[0] = positiontexurevertex;
        this.corners[1] = positiontexurevertex1;
        this.corners[2] = positiontexurevertex2;
        this.corners[3] = positiontexurevertex3;
        this.corners[4] = positiontexurevertex4;
        this.corners[5] = positiontexurevertex5;
        this.corners[6] = positiontexurevertex6;
        this.corners[7] = positiontexurevertex7;
        this.faces[0] = new TexturedQuad(new PositionTexureVertex[]{positiontexurevertex5, positiontexurevertex1, positiontexurevertex2, positiontexurevertex6}, this.textureOffsetX + k2 + i2, this.textureOffsetY + k2, this.textureOffsetX + k2 + i2 + k2, this.textureOffsetY + k2 + j2);
        this.faces[1] = new TexturedQuad(new PositionTexureVertex[]{positiontexurevertex, positiontexurevertex4, positiontexurevertex7, positiontexurevertex3}, this.textureOffsetX + 0, this.textureOffsetY + k2, this.textureOffsetX + k2, this.textureOffsetY + k2 + j2);
        this.faces[2] = new TexturedQuad(new PositionTexureVertex[]{positiontexurevertex5, positiontexurevertex4, positiontexurevertex, positiontexurevertex1}, this.textureOffsetX + k2, this.textureOffsetY + 0, this.textureOffsetX + k2 + i2, this.textureOffsetY + k2);
        this.faces[3] = new TexturedQuad(new PositionTexureVertex[]{positiontexurevertex2, positiontexurevertex3, positiontexurevertex7, positiontexurevertex6}, this.textureOffsetX + k2 + i2, this.textureOffsetY + 0, this.textureOffsetX + k2 + i2 + i2, this.textureOffsetY + k2);
        this.faces[4] = new TexturedQuad(new PositionTexureVertex[]{positiontexurevertex1, positiontexurevertex, positiontexurevertex3, positiontexurevertex2}, this.textureOffsetX + k2, this.textureOffsetY + k2, this.textureOffsetX + k2 + i2, this.textureOffsetY + k2 + j2);
        this.faces[5] = new TexturedQuad(new PositionTexureVertex[]{positiontexurevertex4, positiontexurevertex5, positiontexurevertex6, positiontexurevertex7}, this.textureOffsetX + k2 + i2 + k2, this.textureOffsetY + k2, this.textureOffsetX + k2 + i2 + k2 + i2, this.textureOffsetY + k2 + j2);
        if (this.mirror) {
            for (int l2 = 0; l2 < this.faces.length; ++l2) {
                this.faces[l2].func_809_a();
            }
        }
    }

    public void setPosition(float f2, float f1, float f22) {
        this.offsetX = f2;
        this.offsetY = f1;
        this.offsetZ = f22;
    }

    public void render(float f2) {
        if (this.field_1402_i) {
            return;
        }
        if (!this.field_1403_h) {
            return;
        }
        if (!this.compiled) {
            this.compileDisplayList(f2);
        }
        if (this.rotateAngleX != 0.0f || this.rotateAngleY != 0.0f || this.rotateAngleZ != 0.0f) {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.offsetX * f2, this.offsetY * f2, this.offsetZ * f2);
            if (this.rotateAngleZ != 0.0f) {
                GL11.glRotatef(this.rotateAngleZ * 57.29578f, 0.0f, 0.0f, 1.0f);
            }
            if (this.rotateAngleY != 0.0f) {
                GL11.glRotatef(this.rotateAngleY * 57.29578f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GL11.glRotatef(this.rotateAngleX * 57.29578f, 1.0f, 0.0f, 0.0f);
            }
            GL11.glCallList(this.displayList);
            GL11.glPopMatrix();
        } else if (this.offsetX != 0.0f || this.offsetY != 0.0f || this.offsetZ != 0.0f) {
            GL11.glTranslatef(this.offsetX * f2, this.offsetY * f2, this.offsetZ * f2);
            GL11.glCallList(this.displayList);
            GL11.glTranslatef(-this.offsetX * f2, -this.offsetY * f2, -this.offsetZ * f2);
        } else {
            GL11.glCallList(this.displayList);
        }
    }

    public void func_926_b(float f2) {
        if (this.field_1402_i) {
            return;
        }
        if (!this.field_1403_h) {
            return;
        }
        if (!this.compiled) {
            this.compileDisplayList(f2);
        }
        if (this.rotateAngleX != 0.0f || this.rotateAngleY != 0.0f || this.rotateAngleZ != 0.0f) {
            GL11.glTranslatef(this.offsetX * f2, this.offsetY * f2, this.offsetZ * f2);
            if (this.rotateAngleZ != 0.0f) {
                GL11.glRotatef(this.rotateAngleZ * 57.29578f, 0.0f, 0.0f, 1.0f);
            }
            if (this.rotateAngleY != 0.0f) {
                GL11.glRotatef(this.rotateAngleY * 57.29578f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GL11.glRotatef(this.rotateAngleX * 57.29578f, 1.0f, 0.0f, 0.0f);
            }
        } else if (this.offsetX != 0.0f || this.offsetY != 0.0f || this.offsetZ != 0.0f) {
            GL11.glTranslatef(this.offsetX * f2, this.offsetY * f2, this.offsetZ * f2);
        }
    }

    private void compileDisplayList(float f2) {
        this.displayList = GLAllocation.generateDisplayLists(1);
        GL11.glNewList(this.displayList, 4864);
        Tessellator tessellator = Tessellator.instance;
        for (int i2 = 0; i2 < this.faces.length; ++i2) {
            this.faces[i2].func_808_a(tessellator, f2);
        }
        GL11.glEndList();
        this.compiled = true;
    }
}

