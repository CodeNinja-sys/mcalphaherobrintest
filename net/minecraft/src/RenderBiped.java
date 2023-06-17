/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderBiped
extends RenderLiving {
    protected ModelBiped field_4013_a;

    public RenderBiped(ModelBiped modelbiped, float f2) {
        super(modelbiped, f2);
        this.field_4013_a = modelbiped;
    }

    @Override
    protected void func_6331_b(EntityLiving entityliving, float f2) {
        ItemStack itemstack = entityliving.getHeldItem();
        if (itemstack != null) {
            GL11.glPushMatrix();
            this.field_4013_a.bipedRightArm.func_926_b(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (itemstack.itemID < 256 && RenderBlocks.func_1219_a(Block.blocksList[itemstack.itemID].getRenderType())) {
                float f1 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f1 *= 0.75f, -f1, f1);
            } else if (Item.itemsList[itemstack.itemID].isFull3D()) {
                float f22 = 0.625f;
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(f22, -f22, f22);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                float f3 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f3, f3, f3);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            this.renderManager.field_4236_f.renderItem(itemstack);
            GL11.glPopMatrix();
        }
    }
}

