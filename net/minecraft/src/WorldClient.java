/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import net.minecraft.src.ChunkProviderClient;
import net.minecraft.src.Entity;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IWorldAccess;
import net.minecraft.src.MCHashTable;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet255KickDisconnect;
import net.minecraft.src.Packet59ComplexEntity;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.WorldBlockPositionType;
import net.minecraft.src.WorldProvider;

public class WorldClient
extends World {
    private LinkedList field_1057_z = new LinkedList();
    private NetClientHandler sendQueue;
    private ChunkProviderClient scheduledTickTreeSet;
    private boolean scheduledTickSet = false;
    private MCHashTable field_1055_D = new MCHashTable();
    private Set field_1054_E = new HashSet();
    private Set field_1053_F = new HashSet();

    public WorldClient(NetClientHandler netclienthandler, long l2, int i2) {
        super("MpServer", WorldProvider.func_4101_a(i2), l2);
        this.sendQueue = netclienthandler;
        this.spawnX = 8;
        this.spawnY = 64;
        this.spawnZ = 8;
    }

    @Override
    public void tick() {
        ++this.worldTime;
        int i2 = this.calculateSkylightSubtracted(1.0f);
        if (i2 != this.skylightSubtracted) {
            this.skylightSubtracted = i2;
            for (int j2 = 0; j2 < this.worldAccesses.size(); ++j2) {
                ((IWorldAccess)this.worldAccesses.get(j2)).func_936_e();
            }
        }
        for (int k2 = 0; k2 < 10 && !this.field_1053_F.isEmpty(); ++k2) {
            Entity entity = (Entity)this.field_1053_F.iterator().next();
            if (this.loadedEntityList.contains(entity)) continue;
            this.entityJoinedWorld(entity);
        }
        this.sendQueue.processReadPackets();
        for (int l2 = 0; l2 < this.field_1057_z.size(); ++l2) {
            WorldBlockPositionType worldblockpositiontype = (WorldBlockPositionType)this.field_1057_z.get(l2);
            if (--worldblockpositiontype.field_1206_d != 0) continue;
            super.setBlockAndMetadata(worldblockpositiontype.field_1202_a, worldblockpositiontype.field_1201_b, worldblockpositiontype.field_1207_c, worldblockpositiontype.field_1205_e, worldblockpositiontype.field_1204_f);
            super.func_665_h(worldblockpositiontype.field_1202_a, worldblockpositiontype.field_1201_b, worldblockpositiontype.field_1207_c);
            this.field_1057_z.remove(l2--);
        }
    }

    public void func_711_c(int i2, int j2, int k2, int l2, int i1, int j1) {
        for (int k1 = 0; k1 < this.field_1057_z.size(); ++k1) {
            WorldBlockPositionType worldblockpositiontype = (WorldBlockPositionType)this.field_1057_z.get(k1);
            if (worldblockpositiontype.field_1202_a < i2 || worldblockpositiontype.field_1201_b < j2 || worldblockpositiontype.field_1207_c < k2 || worldblockpositiontype.field_1202_a > l2 || worldblockpositiontype.field_1201_b > i1 || worldblockpositiontype.field_1207_c > j1) continue;
            this.field_1057_z.remove(k1--);
        }
    }

    @Override
    protected IChunkProvider func_4081_a(File file) {
        this.scheduledTickTreeSet = new ChunkProviderClient(this);
        return this.scheduledTickTreeSet;
    }

    @Override
    public void func_4076_b() {
        this.spawnX = 8;
        this.spawnY = 64;
        this.spawnZ = 8;
    }

    @Override
    protected void func_4080_j() {
    }

    @Override
    public void scheduleBlockUpdate(int i2, int j2, int k2, int l2) {
    }

    @Override
    public boolean TickUpdates(boolean flag) {
        return false;
    }

    public void func_713_a(int i2, int j2, boolean flag) {
        if (flag) {
            this.scheduledTickTreeSet.func_538_d(i2, j2);
        } else {
            this.scheduledTickTreeSet.func_539_c(i2, j2);
        }
        if (!flag) {
            this.func_701_b(i2 * 16, 0, j2 * 16, i2 * 16 + 15, 128, j2 * 16 + 15);
        }
    }

    @Override
    public boolean entityJoinedWorld(Entity entity) {
        boolean flag = super.entityJoinedWorld(entity);
        this.field_1054_E.add(entity);
        if (!flag) {
            this.field_1053_F.add(entity);
        }
        return flag;
    }

    @Override
    public void setEntityDead(Entity entity) {
        super.setEntityDead(entity);
        this.field_1054_E.remove(entity);
    }

    @Override
    protected void obtainEntitySkin(Entity entity) {
        super.obtainEntitySkin(entity);
        if (this.field_1053_F.contains(entity)) {
            this.field_1053_F.remove(entity);
        }
    }

    @Override
    protected void releaseEntitySkin(Entity entity) {
        super.releaseEntitySkin(entity);
        if (this.field_1054_E.contains(entity)) {
            this.field_1053_F.add(entity);
        }
    }

    public void func_712_a(int i2, Entity entity) {
        Entity entity1 = this.func_709_b(i2);
        if (entity1 != null) {
            this.setEntityDead(entity1);
        }
        this.field_1054_E.add(entity);
        entity.field_620_ab = i2;
        if (!this.entityJoinedWorld(entity)) {
            this.field_1053_F.add(entity);
        }
        this.field_1055_D.addKey(i2, entity);
    }

    public Entity func_709_b(int i2) {
        return (Entity)this.field_1055_D.lookup(i2);
    }

    public Entity func_710_c(int i2) {
        Entity entity = (Entity)this.field_1055_D.removeObject(i2);
        if (entity != null) {
            this.field_1054_E.remove(entity);
            this.setEntityDead(entity);
        }
        return entity;
    }

    @Override
    public boolean setBlockMetadata(int i2, int j2, int k2, int l2) {
        int i1 = this.getBlockId(i2, j2, k2);
        int j1 = this.getBlockMetadata(i2, j2, k2);
        if (super.setBlockMetadata(i2, j2, k2, l2)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, i2, j2, k2, i1, j1));
            return true;
        }
        return false;
    }

    @Override
    public boolean setBlockAndMetadata(int i2, int j2, int k2, int l2, int i1) {
        int j1 = this.getBlockId(i2, j2, k2);
        int k1 = this.getBlockMetadata(i2, j2, k2);
        if (super.setBlockAndMetadata(i2, j2, k2, l2, i1)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, i2, j2, k2, j1, k1));
            return true;
        }
        return false;
    }

    @Override
    public boolean setBlock(int i2, int j2, int k2, int l2) {
        int i1 = this.getBlockId(i2, j2, k2);
        int j1 = this.getBlockMetadata(i2, j2, k2);
        if (super.setBlock(i2, j2, k2, l2)) {
            this.field_1057_z.add(new WorldBlockPositionType(this, i2, j2, k2, i1, j1));
            return true;
        }
        return false;
    }

    public boolean func_714_c(int i2, int j2, int k2, int l2, int i1) {
        this.func_711_c(i2, j2, k2, i2, j2, k2);
        if (super.setBlockAndMetadata(i2, j2, k2, l2, i1)) {
            this.notifyBlockChange(i2, j2, k2, l2);
            return true;
        }
        return false;
    }

    @Override
    public void func_698_b(int i2, int j2, int k2, TileEntity tileentity) {
        if (this.scheduledTickSet) {
            return;
        }
        this.sendQueue.addToSendQueue(new Packet59ComplexEntity(i2, j2, k2, tileentity));
    }

    @Override
    public void sendQuittingDisconnectingPacket() {
        this.sendQueue.addToSendQueue(new Packet255KickDisconnect("Quitting"));
    }
}

