/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Packet;
import net.minecraft.src.Packet10Flying;
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

public class NetHandler {
    public void handleMapChunk(Packet51MapChunk packet51mapchunk) {
    }

    public void func_4114_b(Packet packet) {
    }

    public void handleErrorMessage(String s2) {
    }

    public void handleKickDisconnect(Packet255KickDisconnect packet255kickdisconnect) {
        this.func_4114_b(packet255kickdisconnect);
    }

    public void handleLogin(Packet1Login packet1login) {
        this.func_4114_b(packet1login);
    }

    public void handleFlying(Packet10Flying packet10flying) {
        this.func_4114_b(packet10flying);
    }

    public void handleMultiBlockChange(Packet52MultiBlockChange packet52multiblockchange) {
        this.func_4114_b(packet52multiblockchange);
    }

    public void handleBlockDig(Packet14BlockDig packet14blockdig) {
        this.func_4114_b(packet14blockdig);
    }

    public void handleBlockChange(Packet53BlockChange packet53blockchange) {
        this.func_4114_b(packet53blockchange);
    }

    public void handlePreChunk(Packet50PreChunk packet50prechunk) {
        this.func_4114_b(packet50prechunk);
    }

    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn packet20namedentityspawn) {
        this.func_4114_b(packet20namedentityspawn);
    }

    public void handleEntity(Packet30Entity packet30entity) {
        this.func_4114_b(packet30entity);
    }

    public void handleEntityTeleport(Packet34EntityTeleport packet34entityteleport) {
        this.func_4114_b(packet34entityteleport);
    }

    public void handlePlace(Packet15Place packet15place) {
        this.func_4114_b(packet15place);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16blockitemswitch) {
        this.func_4114_b(packet16blockitemswitch);
    }

    public void handleDestroyEntity(Packet29DestroyEntity packet29destroyentity) {
        this.func_4114_b(packet29destroyentity);
    }

    public void handlePickupSpawn(Packet21PickupSpawn packet21pickupspawn) {
        this.func_4114_b(packet21pickupspawn);
    }

    public void handleCollect(Packet22Collect packet22collect) {
        this.func_4114_b(packet22collect);
    }

    public void handleChat(Packet3Chat packet3chat) {
        this.func_4114_b(packet3chat);
    }

    public void handleAddToInventory(Packet17AddToInventory packet17addtoinventory) {
        this.func_4114_b(packet17addtoinventory);
    }

    public void handleVehicleSpawn(Packet23VehicleSpawn packet23vehiclespawn) {
        this.func_4114_b(packet23vehiclespawn);
    }

    public void handleArmAnimation(Packet18ArmAnimation packet18armanimation) {
        this.func_4114_b(packet18armanimation);
    }

    public void handleHandshake(Packet2Handshake packet2handshake) {
        this.func_4114_b(packet2handshake);
    }

    public void handleMobSpawn(Packet24MobSpawn packet24mobspawn) {
        this.func_4114_b(packet24mobspawn);
    }

    public void handleUpdateTime(Packet4UpdateTime packet4updatetime) {
        this.func_4114_b(packet4updatetime);
    }

    public void handlePlayerInventory(Packet5PlayerInventory packet5playerinventory) {
        this.func_4114_b(packet5playerinventory);
    }

    public void handleComplexEntity(Packet59ComplexEntity packet59complexentity) {
        this.func_4114_b(packet59complexentity);
    }

    public void handleSpawnPosition(Packet6SpawnPosition packet6spawnposition) {
        this.func_4114_b(packet6spawnposition);
    }

    public void func_6498_a(Packet28 packet28) {
        this.func_4114_b(packet28);
    }

    public void func_6497_a(Packet39 packet39) {
        this.func_4114_b(packet39);
    }

    public void func_6499_a(Packet7 packet7) {
        this.func_4114_b(packet7);
    }

    public void func_9447_a(Packet38 packet38) {
        this.func_4114_b(packet38);
    }

    public void handleHealth(Packet8 packet8) {
        this.func_4114_b(packet8);
    }

    public void func_9448_a(Packet9 packet9) {
        this.func_4114_b(packet9);
    }

    public void func_12245_a(Packet60 packet60) {
        this.func_4114_b(packet60);
    }
}

