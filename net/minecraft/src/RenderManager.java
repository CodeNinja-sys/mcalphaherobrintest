/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.EntityFish;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityHerobrine;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EntityZombieSimple;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GameSettings;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.ModelChicken;
import net.minecraft.src.ModelCow;
import net.minecraft.src.ModelPig;
import net.minecraft.src.ModelSheep1;
import net.minecraft.src.ModelSheep2;
import net.minecraft.src.ModelSkeleton;
import net.minecraft.src.ModelSlime;
import net.minecraft.src.ModelZombie;
import net.minecraft.src.Render;
import net.minecraft.src.RenderArrow;
import net.minecraft.src.RenderBiped;
import net.minecraft.src.RenderBoat;
import net.minecraft.src.RenderChicken;
import net.minecraft.src.RenderCow;
import net.minecraft.src.RenderCreeper;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderEntity;
import net.minecraft.src.RenderFallingSand;
import net.minecraft.src.RenderFireball;
import net.minecraft.src.RenderFish;
import net.minecraft.src.RenderGhast;
import net.minecraft.src.RenderHerobrine;
import net.minecraft.src.RenderItem;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.RenderMinecart;
import net.minecraft.src.RenderPainting;
import net.minecraft.src.RenderPig;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.RenderSheep;
import net.minecraft.src.RenderSlime;
import net.minecraft.src.RenderSnowball;
import net.minecraft.src.RenderSpider;
import net.minecraft.src.RenderTNTPrimed;
import net.minecraft.src.RenderZombieSimple;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderManager {
    private Map entityRenderMap = new HashMap();
    public static RenderManager instance = new RenderManager();
    private FontRenderer field_1218_p;
    public static double field_1232_b;
    public static double field_1231_c;
    public static double field_1230_d;
    public RenderEngine renderEngine;
    public ItemRenderer field_4236_f;
    public World worldObj;
    public EntityPlayer field_1226_h;
    public float field_1225_i;
    public float field_1224_j;
    public GameSettings options;
    public double field_1222_l;
    public double field_1221_m;
    public double field_1220_n;

    private RenderManager() {
        this.entityRenderMap.put(EntitySpider.class, new RenderSpider());
        this.entityRenderMap.put(EntityPig.class, new RenderPig(new ModelPig(), new ModelPig(0.5f), 0.7f));
        this.entityRenderMap.put(EntitySheep.class, new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7f));
        this.entityRenderMap.put(EntityCow.class, new RenderCow(new ModelCow(), 0.7f));
        this.entityRenderMap.put(EntityChicken.class, new RenderChicken(new ModelChicken(), 0.3f));
        this.entityRenderMap.put(EntityCreeper.class, new RenderCreeper());
        this.entityRenderMap.put(EntitySkeleton.class, new RenderBiped(new ModelSkeleton(), 0.5f));
        this.entityRenderMap.put(EntityZombie.class, new RenderBiped(new ModelZombie(), 0.5f));
        this.entityRenderMap.put(EntitySlime.class, new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25f));
        this.entityRenderMap.put(EntityPlayer.class, new RenderPlayer());
        this.entityRenderMap.put(EntityHerobrine.class, new RenderHerobrine(new ModelBiped(), 0.5f));
        this.entityRenderMap.put(EntityZombieSimple.class, new RenderZombieSimple(new ModelZombie(), 0.5f, 6.0f));
        this.entityRenderMap.put(EntityGhast.class, new RenderGhast());
        this.entityRenderMap.put(EntityLiving.class, new RenderLiving(new ModelBiped(), 0.5f));
        this.entityRenderMap.put(Entity.class, new RenderEntity());
        this.entityRenderMap.put(EntityPainting.class, new RenderPainting());
        this.entityRenderMap.put(EntityArrow.class, new RenderArrow());
        this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball());
        this.entityRenderMap.put(EntityFireball.class, new RenderFireball());
        this.entityRenderMap.put(EntityItem.class, new RenderItem());
        this.entityRenderMap.put(EntityTNTPrimed.class, new RenderTNTPrimed());
        this.entityRenderMap.put(EntityFallingSand.class, new RenderFallingSand());
        this.entityRenderMap.put(EntityMinecart.class, new RenderMinecart());
        this.entityRenderMap.put(EntityBoat.class, new RenderBoat());
        this.entityRenderMap.put(EntityFish.class, new RenderFish());
        for (Render render : this.entityRenderMap.values()) {
            render.setRenderManager(this);
        }
    }

    public Render func_4117_a(Class class1) {
        Render render = (Render)this.entityRenderMap.get(class1);
        if (render == null && class1 != Entity.class) {
            render = this.func_4117_a(class1.getSuperclass());
            this.entityRenderMap.put(class1, render);
        }
        return render;
    }

    public Render func_855_a(Entity entity) {
        return this.func_4117_a(entity.getClass());
    }

    public void func_857_a(World world, RenderEngine renderengine, FontRenderer fontrenderer, EntityPlayer entityplayer, GameSettings gamesettings, float f2) {
        this.worldObj = world;
        this.renderEngine = renderengine;
        this.options = gamesettings;
        this.field_1226_h = entityplayer;
        this.field_1218_p = fontrenderer;
        this.field_1225_i = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f2;
        this.field_1224_j = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f2;
        this.field_1222_l = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * (double)f2;
        this.field_1221_m = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * (double)f2;
        this.field_1220_n = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * (double)f2;
    }

    public void func_854_a(Entity entity, float f2) {
        double d2 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f2;
        double d1 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f2;
        double d22 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f2;
        float f1 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f2;
        float f22 = entity.getEntityBrightness(f2);
        GL11.glColor3f(f22, f22, f22);
        this.func_853_a(entity, d2 - field_1232_b, d1 - field_1231_c, d22 - field_1230_d, f1, f2);
    }

    public void func_853_a(Entity entity, double d2, double d1, double d22, float f2, float f1) {
        Render render = this.func_855_a(entity);
        if (render != null) {
            render.doRender(entity, d2, d1, d22, f2, f1);
            render.doRenderShadowAndFire(entity, d2, d1, d22, f2, f1);
        }
    }

    public void func_852_a(World world) {
        this.worldObj = world;
    }

    public double func_851_a(double d2, double d1, double d22) {
        double d3 = d2 - this.field_1222_l;
        double d4 = d1 - this.field_1221_m;
        double d5 = d22 - this.field_1220_n;
        return d3 * d3 + d4 * d4 + d5 * d5;
    }

    public FontRenderer getFontRenderer() {
        return this.field_1218_p;
    }
}

