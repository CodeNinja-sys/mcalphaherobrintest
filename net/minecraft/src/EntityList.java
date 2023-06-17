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
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityHerobrine;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityMobs;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EntityZombieSimple;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityList {
    private static Map stringToClassMapping = new HashMap();
    private static Map classToStringMapping = new HashMap();
    private static Map IDtoClassMapping = new HashMap();
    private static Map classToIDMapping = new HashMap();

    static {
        EntityList.addMapping(EntityArrow.class, "Arrow", 10);
        EntityList.addMapping(EntitySnowball.class, "Snowball", 11);
        EntityList.addMapping(EntityItem.class, "Item", 1);
        EntityList.addMapping(EntityPainting.class, "Painting", 9);
        EntityList.addMapping(EntityLiving.class, "Mob", 48);
        EntityList.addMapping(EntityMobs.class, "Monster", 49);
        EntityList.addMapping(EntityCreeper.class, "Creeper", 50);
        EntityList.addMapping(EntitySkeleton.class, "Skeleton", 51);
        EntityList.addMapping(EntitySpider.class, "Spider", 52);
        EntityList.addMapping(EntityZombieSimple.class, "Giant", 53);
        EntityList.addMapping(EntityHerobrine.class, "Herobrine", 404);
        EntityList.addMapping(EntityZombie.class, "Zombie", 54);
        EntityList.addMapping(EntitySlime.class, "Slime", 55);
        EntityList.addMapping(EntityGhast.class, "Ghast", 56);
        EntityList.addMapping(EntityPigZombie.class, "PigZombie", 57);
        EntityList.addMapping(EntityPig.class, "Pig", 90);
        EntityList.addMapping(EntitySheep.class, "Sheep", 91);
        EntityList.addMapping(EntityCow.class, "Cow", 92);
        EntityList.addMapping(EntityChicken.class, "Chicken", 93);
        EntityList.addMapping(EntityTNTPrimed.class, "PrimedTnt", 20);
        EntityList.addMapping(EntityFallingSand.class, "FallingSand", 21);
        EntityList.addMapping(EntityMinecart.class, "Minecart", 40);
        EntityList.addMapping(EntityBoat.class, "Boat", 41);
    }

    private static void addMapping(Class class1, String s2, int i2) {
        stringToClassMapping.put(s2, class1);
        classToStringMapping.put(class1, s2);
        IDtoClassMapping.put(i2, class1);
        classToIDMapping.put(class1, i2);
    }

    public static Entity createEntityInWorld(String s2, World world) {
        Entity entity = null;
        try {
            Class class1 = (Class)stringToClassMapping.get(s2);
            if (class1 != null) {
                entity = (Entity)class1.getConstructor(World.class).newInstance(world);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return entity;
    }

    public static Entity createEntityFromNBT(NBTTagCompound nbttagcompound, World world) {
        Entity entity = null;
        try {
            Class class1 = (Class)stringToClassMapping.get(nbttagcompound.getString("id"));
            if (class1 != null) {
                entity = (Entity)class1.getConstructor(World.class).newInstance(world);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity != null) {
            entity.readFromNBT(nbttagcompound);
        } else {
            System.out.println("Skipping Entity with id " + nbttagcompound.getString("id"));
        }
        return entity;
    }

    public static Entity createEntity(int i2, World world) {
        Entity entity = null;
        try {
            Class class1 = (Class)IDtoClassMapping.get(i2);
            if (class1 != null) {
                entity = (Entity)class1.getConstructor(World.class).newInstance(world);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity == null) {
            System.out.println("Skipping Entity with id " + i2);
        }
        return entity;
    }

    public static int getEntityID(Entity entity) {
        return (Integer)classToIDMapping.get(entity.getClass());
    }

    public static String getEntityString(Entity entity) {
        return (String)classToStringMapping.get(entity.getClass());
    }
}

