/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet0KeepAlive;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet11PlayerPosition;
import net.minecraft.src.Packet12PlayerLook;
import net.minecraft.src.Packet13PlayerLookMove;
import net.minecraft.src.Packet14BlockDig;
import net.minecraft.src.Packet15Place;
import net.minecraft.src.Packet16BlockItemSwitch;
import net.minecraft.src.Packet17AddToInventory;
import net.minecraft.src.Packet18ArmAnimation;
import net.minecraft.src.Packet1Login;
import net.minecraft.src.Packet20NamedEntitySpawn;
import net.minecraft.src.Packet21PickupSpawn;
import net.minecraft.src.Packet22Collect;
import net.minecraft.src.Packet23VehicleSpawn;
import net.minecraft.src.Packet24MobSpawn;
import net.minecraft.src.Packet255KickDisconnect;
import net.minecraft.src.Packet28;
import net.minecraft.src.Packet29DestroyEntity;
import net.minecraft.src.Packet2Handshake;
import net.minecraft.src.Packet30Entity;
import net.minecraft.src.Packet31RelEntityMove;
import net.minecraft.src.Packet32EntityLook;
import net.minecraft.src.Packet33RelEntityMoveLook;
import net.minecraft.src.Packet34EntityTeleport;
import net.minecraft.src.Packet38;
import net.minecraft.src.Packet39;
import net.minecraft.src.Packet3Chat;
import net.minecraft.src.Packet4UpdateTime;
import net.minecraft.src.Packet50PreChunk;
import net.minecraft.src.Packet51MapChunk;
import net.minecraft.src.Packet52MultiBlockChange;
import net.minecraft.src.Packet53BlockChange;
import net.minecraft.src.Packet59ComplexEntity;
import net.minecraft.src.Packet5PlayerInventory;
import net.minecraft.src.Packet60;
import net.minecraft.src.Packet6SpawnPosition;
import net.minecraft.src.Packet7;
import net.minecraft.src.Packet8;
import net.minecraft.src.Packet9;

public abstract class Packet {
    private static Map packetIdToClassMap = new HashMap();
    private static Map packetClassToIdMap = new HashMap();
    public boolean isChunkDataPacket = false;

    static {
        Packet.addIdClassMapping(0, Packet0KeepAlive.class);
        Packet.addIdClassMapping(1, Packet1Login.class);
        Packet.addIdClassMapping(2, Packet2Handshake.class);
        Packet.addIdClassMapping(3, Packet3Chat.class);
        Packet.addIdClassMapping(4, Packet4UpdateTime.class);
        Packet.addIdClassMapping(5, Packet5PlayerInventory.class);
        Packet.addIdClassMapping(6, Packet6SpawnPosition.class);
        Packet.addIdClassMapping(7, Packet7.class);
        Packet.addIdClassMapping(8, Packet8.class);
        Packet.addIdClassMapping(9, Packet9.class);
        Packet.addIdClassMapping(10, Packet10Flying.class);
        Packet.addIdClassMapping(11, Packet11PlayerPosition.class);
        Packet.addIdClassMapping(12, Packet12PlayerLook.class);
        Packet.addIdClassMapping(13, Packet13PlayerLookMove.class);
        Packet.addIdClassMapping(14, Packet14BlockDig.class);
        Packet.addIdClassMapping(15, Packet15Place.class);
        Packet.addIdClassMapping(16, Packet16BlockItemSwitch.class);
        Packet.addIdClassMapping(17, Packet17AddToInventory.class);
        Packet.addIdClassMapping(18, Packet18ArmAnimation.class);
        Packet.addIdClassMapping(20, Packet20NamedEntitySpawn.class);
        Packet.addIdClassMapping(21, Packet21PickupSpawn.class);
        Packet.addIdClassMapping(22, Packet22Collect.class);
        Packet.addIdClassMapping(23, Packet23VehicleSpawn.class);
        Packet.addIdClassMapping(24, Packet24MobSpawn.class);
        Packet.addIdClassMapping(28, Packet28.class);
        Packet.addIdClassMapping(29, Packet29DestroyEntity.class);
        Packet.addIdClassMapping(30, Packet30Entity.class);
        Packet.addIdClassMapping(31, Packet31RelEntityMove.class);
        Packet.addIdClassMapping(32, Packet32EntityLook.class);
        Packet.addIdClassMapping(33, Packet33RelEntityMoveLook.class);
        Packet.addIdClassMapping(34, Packet34EntityTeleport.class);
        Packet.addIdClassMapping(38, Packet38.class);
        Packet.addIdClassMapping(39, Packet39.class);
        Packet.addIdClassMapping(50, Packet50PreChunk.class);
        Packet.addIdClassMapping(51, Packet51MapChunk.class);
        Packet.addIdClassMapping(52, Packet52MultiBlockChange.class);
        Packet.addIdClassMapping(53, Packet53BlockChange.class);
        Packet.addIdClassMapping(59, Packet59ComplexEntity.class);
        Packet.addIdClassMapping(60, Packet60.class);
        Packet.addIdClassMapping(255, Packet255KickDisconnect.class);
    }

    static void addIdClassMapping(int i2, Class class1) {
        if (packetIdToClassMap.containsKey(i2)) {
            throw new IllegalArgumentException("Duplicate packet id:" + i2);
        }
        if (packetClassToIdMap.containsKey(class1)) {
            throw new IllegalArgumentException("Duplicate packet class:" + class1);
        }
        packetIdToClassMap.put(i2, class1);
        packetClassToIdMap.put(class1, i2);
    }

    public static Packet getNewPacket(int i2) {
        Class class1;
        block3: {
            try {
                class1 = (Class)packetIdToClassMap.get(i2);
                if (class1 != null) break block3;
                return null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("Skipping packet with id " + i2);
                return null;
            }
        }
        return (Packet)class1.newInstance();
    }

    public final int getPacketId() {
        return (Integer)packetClassToIdMap.get(this.getClass());
    }

    public static Packet readPacket(DataInputStream datainputstream) throws IOException {
        int i2 = datainputstream.read();
        if (i2 == -1) {
            return null;
        }
        Packet packet = Packet.getNewPacket(i2);
        if (packet == null) {
            throw new IOException("Bad packet id " + i2);
        }
        packet.readPacketData(datainputstream);
        return packet;
    }

    public static void writePacket(Packet packet, DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.write(packet.getPacketId());
        packet.writePacketData(dataoutputstream);
    }

    public abstract void readPacketData(DataInputStream var1) throws IOException;

    public abstract void writePacketData(DataOutputStream var1) throws IOException;

    public abstract void processPacket(NetHandler var1);

    public abstract int getPacketSize();

    static Class _mthclass$(String s2) {
        try {
            return Class.forName(s2);
        }
        catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    }
}

