/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.TileEntity;

public interface IWorldAccess {
    public void func_934_a(int var1, int var2, int var3);

    public void func_937_b(int var1, int var2, int var3, int var4, int var5, int var6);

    public void playSound(String var1, double var2, double var4, double var6, float var8, float var9);

    public void spawnParticle(String var1, double var2, double var4, double var6, double var8, double var10, double var12);

    public void obtainEntitySkin(Entity var1);

    public void releaseEntitySkin(Entity var1);

    public void func_936_e();

    public void playRecord(String var1, int var2, int var3, int var4);

    public void func_935_a(int var1, int var2, int var3, TileEntity var4);
}

