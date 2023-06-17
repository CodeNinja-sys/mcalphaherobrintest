/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderPlayer
extends RenderLiving {
    private ModelBiped field_209_f;
    private ModelBiped field_208_g;
    private ModelBiped field_207_h;
    private static final String[] armorFilenamePrefix = new String[]{"cloth", "chain", "iron", "diamond", "gold"};

    public RenderPlayer() {
        super(new ModelBiped(0.0f), 0.5f);
        this.field_209_f = (ModelBiped)this.unusedRenderBlocks;
        this.field_208_g = new ModelBiped(1.0f);
        this.field_207_h = new ModelBiped(0.5f);
    }

    protected boolean func_187_a(EntityPlayer entityplayer, int i2) {
        Item item;
        ItemStack itemstack = entityplayer.inventory.armorItemInSlot(3 - i2);
        if (itemstack != null && (item = itemstack.getItem()) instanceof ItemArmor) {
            ItemArmor itemarmor = (ItemArmor)item;
            this.loadTexture("/armor/" + armorFilenamePrefix[itemarmor.renderIndex] + "_" + (i2 != 2 ? 1 : 2) + ".png");
            ModelBiped modelbiped = i2 != 2 ? this.field_208_g : this.field_207_h;
            modelbiped.bipedHead.field_1403_h = i2 == 0;
            modelbiped.field_1285_b.field_1403_h = i2 == 0;
            modelbiped.field_1284_c.field_1403_h = i2 == 1 || i2 == 2;
            modelbiped.bipedRightArm.field_1403_h = i2 == 1;
            modelbiped.bipedLeftArm.field_1403_h = i2 == 1;
            modelbiped.bipedRightLeg.field_1403_h = i2 == 2 || i2 == 3;
            modelbiped.bipedLeftLeg.field_1403_h = i2 == 2 || i2 == 3;
            this.func_4013_a(modelbiped);
            return true;
        }
        return false;
    }

    public void func_188_a(EntityPlayer entityplayer, double d2, double d1, double d22, float f2, float f1) {
        float f5;
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        this.field_209_f.field_1278_i = itemstack != null;
        this.field_207_h.field_1278_i = this.field_209_f.field_1278_i;
        this.field_208_g.field_1278_i = this.field_209_f.field_1278_i;
        this.field_207_h.field_1277_j = this.field_209_f.field_1277_j = entityplayer.func_381_o();
        this.field_208_g.field_1277_j = this.field_209_f.field_1277_j;
        double d3 = d1 - (double)entityplayer.yOffset;
        if (entityplayer.field_12240_bw) {
            d3 -= 0.125;
        }
        super.func_171_a(entityplayer, d2, d3, d22, f2, f1);
        this.field_209_f.field_1277_j = false;
        this.field_207_h.field_1277_j = false;
        this.field_208_g.field_1277_j = false;
        this.field_209_f.field_1278_i = false;
        this.field_207_h.field_1278_i = false;
        this.field_208_g.field_1278_i = false;
        float f22 = 1.6f;
        float f3 = 0.01666667f * f22;
        float f4 = entityplayer.getDistanceToEntity(this.renderManager.field_1226_h);
        float f6 = f5 = entityplayer.func_381_o() ? 32.0f : 64.0f;
        if (f4 < f5) {
            f3 = (float)((double)f3 * (Math.sqrt(f4) / 2.0));
            FontRenderer fontrenderer = this.getFontRendererFromRenderManager();
            GL11.glPushMatrix();
            GL11.glTranslatef((float)d2 + 0.0f, (float)d1 + 2.3f, (float)d22);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glRotatef(-this.renderManager.field_1225_i, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(this.renderManager.field_1224_j, 1.0f, 0.0f, 0.0f);
            GL11.glScalef(-f3, -f3, f3);
            String s2 = entityplayer.field_771_i;
            GL11.glDisable(2896);
            if (!entityplayer.func_381_o()) {
                GL11.glDepthMask(false);
                GL11.glDisable(2929);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                Tessellator tessellator = Tessellator.instance;
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                int i2 = fontrenderer.getStringWidth(s2) / 2;
                tessellator.setColorRGBA_F(0.0f, 0.0f, 0.0f, 0.25f);
                tessellator.addVertex(-i2 - 1, -1.0, 0.0);
                tessellator.addVertex(-i2 - 1, 8.0, 0.0);
                tessellator.addVertex(i2 + 1, 8.0, 0.0);
                tessellator.addVertex(i2 + 1, -1.0, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
                fontrenderer.drawString(s2, -fontrenderer.getStringWidth(s2) / 2, 0, 0x20FFFFFF);
                GL11.glEnable(2929);
                GL11.glDepthMask(true);
                fontrenderer.drawString(s2, -fontrenderer.getStringWidth(s2) / 2, 0, -1);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            } else {
                GL11.glTranslatef(0.0f, 0.25f / f3, 0.0f);
                GL11.glDepthMask(false);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                Tessellator tessellator1 = Tessellator.instance;
                GL11.glDisable(3553);
                tessellator1.startDrawingQuads();
                int j2 = fontrenderer.getStringWidth(s2) / 2;
                tessellator1.setColorRGBA_F(0.0f, 0.0f, 0.0f, 0.25f);
                tessellator1.addVertex(-j2 - 1, -1.0, 0.0);
                tessellator1.addVertex(-j2 - 1, 8.0, 0.0);
                tessellator1.addVertex(j2 + 1, 8.0, 0.0);
                tessellator1.addVertex(j2 + 1, -1.0, 0.0);
                tessellator1.draw();
                GL11.glEnable(3553);
                GL11.glDepthMask(true);
                fontrenderer.drawString(s2, -fontrenderer.getStringWidth(s2) / 2, 0, 0x20FFFFFF);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            }
        }
    }

    protected void func_4015_a(EntityPlayer entityplayer, float f2) {
        ItemStack itemstack1;
        ItemStack itemstack = entityplayer.inventory.armorItemInSlot(3);
        if (itemstack != null && itemstack.getItem().shiftedIndex < 256) {
            GL11.glPushMatrix();
            this.field_209_f.bipedHead.func_926_b(0.0625f);
            if (RenderBlocks.func_1219_a(Block.blocksList[itemstack.itemID].getRenderType())) {
                float f1 = 0.625f;
                GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f1, -f1, f1);
            }
            this.renderManager.field_4236_f.renderItem(itemstack);
            GL11.glPopMatrix();
        }
        if ((itemstack1 = entityplayer.inventory.getCurrentItem()) != null) {
            GL11.glPushMatrix();
            this.field_209_f.bipedRightArm.func_926_b(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (entityplayer.fishEntity != null) {
                itemstack1 = new ItemStack(Item.stick.shiftedIndex);
            }
            if (itemstack1.itemID < 256 && RenderBlocks.func_1219_a(Block.blocksList[itemstack1.itemID].getRenderType())) {
                float f22 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(f22 *= 0.75f, -f22, f22);
            } else if (Item.itemsList[itemstack1.itemID].isFull3D()) {
                float f3 = 0.625f;
                if (Item.itemsList[itemstack1.itemID].shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(f3, -f3, f3);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            } else {
                float f4 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(f4, f4, f4);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            this.renderManager.field_4236_f.renderItem(itemstack1);
            GL11.glPopMatrix();
        }
    }

    protected void func_186_b(EntityPlayer entityplayer, float f2) {
        float f1 = 0.9375f;
        GL11.glScalef(f1, f1, f1);
    }

    public void drawFirstPersonHand() {
        this.field_209_f.field_1244_k = 0.0f;
        this.field_209_f.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        this.field_209_f.bipedRightArm.render(0.0625f);
    }

    @Override
    protected void func_6330_a(EntityLiving entityliving, float f2) {
        this.func_186_b((EntityPlayer)entityliving, f2);
    }

    @Override
    protected boolean func_166_a(EntityLiving entityliving, int i2) {
        return this.func_187_a((EntityPlayer)entityliving, i2);
    }

    @Override
    protected void func_6331_b(EntityLiving entityliving, float f2) {
        this.func_4015_a((EntityPlayer)entityliving, f2);
    }

    @Override
    public void func_171_a(EntityLiving entityliving, double d2, double d1, double d22, float f2, float f1) {
        this.func_188_a((EntityPlayer)entityliving, d2, d1, d22, f2, f1);
    }

    @Override
    public void doRender(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        this.func_188_a((EntityPlayer)entity, d2, d1, d22, f2, f1);
    }
}

