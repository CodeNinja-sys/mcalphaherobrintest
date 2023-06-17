/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPickupFX;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.GuiChest;
import net.minecraft.src.GuiCrafting;
import net.minecraft.src.GuiEditSign;
import net.minecraft.src.GuiFurnace;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MovementInput;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Session;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class EntityPlayerSP
extends EntityPlayer {
    public MovementInput field_787_a;
    private Minecraft mc;
    public int field_9373_b = 20;
    private boolean field_9374_bx = false;
    public float field_4134_c;
    public float field_4133_d;

    public EntityPlayerSP(Minecraft minecraft, World world, Session session, int i2) {
        super(world);
        this.mc = minecraft;
        this.dimension = i2;
        if (session != null && session.inventory != null && session.inventory.length() > 0) {
            this.skinUrl = "http://www.minecraft.net/skin/" + session.inventory + ".png";
            System.out.println("Loading texture " + this.skinUrl);
        }
        this.field_771_i = session.inventory;
    }

    @Override
    public void func_418_b_() {
        super.func_418_b_();
        this.field_9342_ah = this.field_787_a.field_1174_a;
        this.field_9340_ai = this.field_787_a.field_1173_b;
        this.isJumping = this.field_787_a.field_1176_d;
    }

    @Override
    public void onLivingUpdate() {
        this.field_4133_d = this.field_4134_c;
        if (this.field_9374_bx) {
            if (this.field_4134_c == 0.0f) {
                this.mc.sndManager.func_337_a("portal.trigger", 1.0f, this.rand.nextFloat() * 0.4f + 0.8f);
            }
            this.field_4134_c += 0.0125f;
            if (this.field_4134_c >= 1.0f) {
                this.field_4134_c = 1.0f;
                this.field_9373_b = 10;
                this.mc.sndManager.func_337_a("portal.travel", 1.0f, this.rand.nextFloat() * 0.4f + 0.8f);
                this.mc.func_6237_k();
            }
            this.field_9374_bx = false;
        } else {
            if (this.field_4134_c > 0.0f) {
                this.field_4134_c -= 0.05f;
            }
            if (this.field_4134_c < 0.0f) {
                this.field_4134_c = 0.0f;
            }
        }
        if (this.field_9373_b > 0) {
            --this.field_9373_b;
        }
        this.field_787_a.func_797_a(this);
        if (this.field_787_a.field_1175_e && this.field_9287_aY < 0.2f) {
            this.field_9287_aY = 0.2f;
        }
        super.onLivingUpdate();
    }

    public void func_458_k() {
        this.field_787_a.func_798_a();
    }

    public void func_460_a(int i2, boolean flag) {
        this.field_787_a.func_796_a(i2, flag);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("Score", this.score);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.score = nbttagcompound.getInteger("Score");
    }

    @Override
    public void displayGUIChest(IInventory iinventory) {
        this.mc.displayGuiScreen(new GuiChest(this.inventory, iinventory));
    }

    @Override
    public void displayGUIEditSign(TileEntitySign tileentitysign) {
        this.mc.displayGuiScreen(new GuiEditSign(tileentitysign));
    }

    @Override
    public void displayWorkbenchGUI() {
        this.mc.displayGuiScreen(new GuiCrafting(this.inventory));
    }

    @Override
    public void displayGUIFurnace(TileEntityFurnace tileentityfurnace) {
        this.mc.displayGuiScreen(new GuiFurnace(this.inventory, tileentityfurnace));
    }

    @Override
    public void func_443_a_(Entity entity, int i2) {
        this.mc.field_6321_h.func_1192_a(new EntityPickupFX(this.mc.theWorld, entity, this, -0.5f));
    }

    public int getPlayerArmorValue() {
        return this.inventory.getTotalArmorValue();
    }

    @Override
    public void func_6415_a_(Entity entity) {
        if (entity.interact(this)) {
            return;
        }
        ItemStack itemstack = this.getCurrentEquippedItem();
        if (itemstack != null && entity instanceof EntityLiving) {
            itemstack.useItemOnEntity((EntityLiving)entity);
            if (itemstack.stackSize <= 0) {
                itemstack.func_1097_a(this);
                this.destroyCurrentEquippedItem();
            }
        }
    }

    public void sendChatMessage(String s2) {
    }

    public void func_6420_o() {
    }

    @Override
    public boolean func_381_o() {
        return this.field_787_a.field_1175_e;
    }

    @Override
    public void func_4039_q() {
        if (this.field_9373_b > 0) {
            this.field_9373_b = 10;
            return;
        }
        this.field_9374_bx = true;
    }

    public void setHealth(int i2) {
        int j2 = this.health - i2;
        if (j2 <= 0) {
            this.health = i2;
        } else {
            this.field_9346_af = j2;
            this.field_9335_K = this.health;
            this.field_9306_bj = this.field_9366_o;
            this.damageEntity(j2);
            this.field_9332_M = 10;
            this.hurtTime = 10;
        }
    }

    @Override
    public void func_9367_r() {
        this.mc.respawn();
    }
}

