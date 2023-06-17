/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.PositionTexureVertex;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3D;

public class TexturedQuad {
    public PositionTexureVertex[] field_1195_a;
    public int field_1194_b = 0;
    private boolean field_1196_c = false;

    public TexturedQuad(PositionTexureVertex[] apositiontexurevertex) {
        this.field_1195_a = apositiontexurevertex;
        this.field_1194_b = apositiontexurevertex.length;
    }

    public TexturedQuad(PositionTexureVertex[] apositiontexurevertex, int i2, int j2, int k2, int l2) {
        this(apositiontexurevertex);
        float f2 = 0.0015625f;
        float f1 = 0.003125f;
        apositiontexurevertex[0] = apositiontexurevertex[0].setTexturePosition((float)k2 / 64.0f - f2, (float)j2 / 32.0f + f1);
        apositiontexurevertex[1] = apositiontexurevertex[1].setTexturePosition((float)i2 / 64.0f + f2, (float)j2 / 32.0f + f1);
        apositiontexurevertex[2] = apositiontexurevertex[2].setTexturePosition((float)i2 / 64.0f + f2, (float)l2 / 32.0f - f1);
        apositiontexurevertex[3] = apositiontexurevertex[3].setTexturePosition((float)k2 / 64.0f - f2, (float)l2 / 32.0f - f1);
    }

    public void func_809_a() {
        PositionTexureVertex[] apositiontexurevertex = new PositionTexureVertex[this.field_1195_a.length];
        for (int i2 = 0; i2 < this.field_1195_a.length; ++i2) {
            apositiontexurevertex[i2] = this.field_1195_a[this.field_1195_a.length - i2 - 1];
        }
        this.field_1195_a = apositiontexurevertex;
    }

    public void func_808_a(Tessellator tessellator, float f2) {
        Vec3D vec3d = this.field_1195_a[1].vector3D.subtract(this.field_1195_a[0].vector3D);
        Vec3D vec3d1 = this.field_1195_a[1].vector3D.subtract(this.field_1195_a[2].vector3D);
        Vec3D vec3d2 = vec3d1.crossProduct(vec3d).normalize();
        tessellator.startDrawingQuads();
        if (this.field_1196_c) {
            tessellator.setNormal(-((float)vec3d2.xCoord), -((float)vec3d2.yCoord), -((float)vec3d2.zCoord));
        } else {
            tessellator.setNormal((float)vec3d2.xCoord, (float)vec3d2.yCoord, (float)vec3d2.zCoord);
        }
        for (int i2 = 0; i2 < 4; ++i2) {
            PositionTexureVertex positiontexurevertex = this.field_1195_a[i2];
            tessellator.addVertexWithUV((float)positiontexurevertex.vector3D.xCoord * f2, (float)positiontexurevertex.vector3D.yCoord * f2, (float)positiontexurevertex.vector3D.zCoord * f2, positiontexurevertex.texturePositionX, positiontexurevertex.texturePositionY);
        }
        tessellator.draw();
    }
}

