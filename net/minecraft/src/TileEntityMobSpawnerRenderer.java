/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityList;
import net.minecraft.src.RenderManager;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntityMobSpawnerRenderer
extends TileEntitySpecialRenderer {
    private Map field_1412_b = new HashMap();

    public void func_931_a(TileEntityMobSpawner tileentitymobspawner, double d2, double d1, double d22, float f2) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d2 + 0.5f, (float)d1, (float)d22 + 0.5f);
        Entity entity = (Entity)this.field_1412_b.get(tileentitymobspawner.entityID);
        if (entity == null) {
            entity = EntityList.createEntityInWorld(tileentitymobspawner.entityID, null);
            this.field_1412_b.put(tileentitymobspawner.entityID, entity);
        }
        if (entity != null) {
            entity.setWorld(tileentitymobspawner.worldObj);
            float f1 = 0.4375f;
            GL11.glTranslatef(0.0f, 0.4f, 0.0f);
            GL11.glRotatef((float)(tileentitymobspawner.field_830_d + (tileentitymobspawner.field_831_c - tileentitymobspawner.field_830_d) * (double)f2) * 10.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-30.0f, 1.0f, 0.0f, 0.0f);
            GL11.glTranslatef(0.0f, -0.4f, 0.0f);
            GL11.glScalef(f1, f1, f1);
            entity.setLocationAndAngles(d2, d1, d22, 0.0f, 0.0f);
            RenderManager.instance.func_853_a(entity, 0.0, 0.0, 0.0, 0.0f, f2);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d2, double d1, double d22, float f2) {
        this.func_931_a((TileEntityMobSpawner)tileentity, d2, d1, d22, f2);
    }
}

