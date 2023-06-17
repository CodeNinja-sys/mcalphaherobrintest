/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.MobSpawnerBase;

public class MobSpawnerHell
extends MobSpawnerBase {
    public MobSpawnerHell() {
        this.biomeMonsters = new Class[]{EntityGhast.class, EntityPigZombie.class};
        this.biomeCreatures = new Class[0];
    }
}

