/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.Render;
import org.lwjgl.opengl.GL11;

public class RenderEntity
extends Render {
    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        GL11.glPushMatrix();
        RenderEntity.renderOffsetAABB(entity.boundingBox, d2 - entity.lastTickPosX, d1 - entity.lastTickPosY, d22 - entity.lastTickPosZ);
        GL11.glPopMatrix();
    }
}

