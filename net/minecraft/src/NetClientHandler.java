/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Chunk;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.EntityFish;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityOtherPlayerMP;
import net.minecraft.src.EntityPickupFX;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.Explosion;
import net.minecraft.src.GuiConnectFailed;
import net.minecraft.src.GuiDownloadTerrain;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NetHandler;
import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet;
import net.minecraft.src.Packet10Flying;
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
import net.minecraft.src.Packet8;
import net.minecraft.src.Packet9;
import net.minecraft.src.PlayerControllerMP;
import net.minecraft.src.TileEntity;
import net.minecraft.src.WorldClient;

public class NetClientHandler
extends NetHandler {
    private boolean disconnected = false;
    private NetworkManager netManager;
    public String field_1209_a;
    private Minecraft mc;
    private WorldClient worldClient;
    private boolean field_1210_g = false;
    Random rand = new Random();

    public NetClientHandler(Minecraft minecraft, String s2, int i2) throws UnknownHostException, IOException {
        this.mc = minecraft;
        Socket socket = new Socket(InetAddress.getByName(s2), i2);
        this.netManager = new NetworkManager(socket, "Client", this);
    }

    public void processReadPackets() {
        if (this.disconnected) {
            return;
        }
        this.netManager.processReadPackets();
    }

    @Override
    public void handleLogin(Packet1Login packet1login) {
        this.mc.field_6327_b = new PlayerControllerMP(this.mc, this);
        this.worldClient = new WorldClient(this, packet1login.field_4074_d, packet1login.field_4073_e);
        this.worldClient.multiplayerWorld = true;
        this.mc.func_6261_a(this.worldClient);
        this.mc.displayGuiScreen(new GuiDownloadTerrain(this));
        this.mc.thePlayer.field_620_ab = packet1login.protocolVersion;
        System.out.println("clientEntityId: " + packet1login.protocolVersion);
    }

    @Override
    public void handlePickupSpawn(Packet21PickupSpawn packet21pickupspawn) {
        double d2 = (double)packet21pickupspawn.xPosition / 32.0;
        double d1 = (double)packet21pickupspawn.yPosition / 32.0;
        double d22 = (double)packet21pickupspawn.zPosition / 32.0;
        EntityItem entityitem = new EntityItem(this.worldClient, d2, d1, d22, new ItemStack(packet21pickupspawn.itemId, packet21pickupspawn.count));
        entityitem.motionX = (double)packet21pickupspawn.rotation / 128.0;
        entityitem.motionY = (double)packet21pickupspawn.pitch / 128.0;
        entityitem.motionZ = (double)packet21pickupspawn.roll / 128.0;
        entityitem.field_9303_br = packet21pickupspawn.xPosition;
        entityitem.field_9302_bs = packet21pickupspawn.yPosition;
        entityitem.field_9301_bt = packet21pickupspawn.zPosition;
        this.worldClient.func_712_a(packet21pickupspawn.entityId, entityitem);
    }

    @Override
    public void handleVehicleSpawn(Packet23VehicleSpawn packet23vehiclespawn) {
        double d2 = (double)packet23vehiclespawn.xPosition / 32.0;
        double d1 = (double)packet23vehiclespawn.yPosition / 32.0;
        double d22 = (double)packet23vehiclespawn.zPosition / 32.0;
        Entity obj = null;
        if (packet23vehiclespawn.type == 10) {
            obj = new EntityMinecart(this.worldClient, d2, d1, d22, 0);
        }
        if (packet23vehiclespawn.type == 11) {
            obj = new EntityMinecart(this.worldClient, d2, d1, d22, 1);
        }
        if (packet23vehiclespawn.type == 12) {
            obj = new EntityMinecart(this.worldClient, d2, d1, d22, 2);
        }
        if (packet23vehiclespawn.type == 90) {
            obj = new EntityFish(this.worldClient, d2, d1, d22);
        }
        if (packet23vehiclespawn.type == 60) {
            obj = new EntityArrow(this.worldClient, d2, d1, d22);
        }
        if (packet23vehiclespawn.type == 61) {
            obj = new EntitySnowball(this.worldClient, d2, d1, d22);
        }
        if (packet23vehiclespawn.type == 1) {
            obj = new EntityBoat(this.worldClient, d2, d1, d22);
        }
        if (packet23vehiclespawn.type == 50) {
            obj = new EntityTNTPrimed(this.worldClient, d2, d1, d22);
        }
        if (obj != null) {
            obj.field_9303_br = packet23vehiclespawn.xPosition;
            obj.field_9302_bs = packet23vehiclespawn.yPosition;
            obj.field_9301_bt = packet23vehiclespawn.zPosition;
            obj.rotationYaw = 0.0f;
            obj.rotationPitch = 0.0f;
            obj.field_620_ab = packet23vehiclespawn.entityId;
            this.worldClient.func_712_a(packet23vehiclespawn.entityId, obj);
        }
    }

    @Override
    public void func_6498_a(Packet28 packet28) {
        Entity entity = this.func_12246_a(packet28.field_6367_a);
        if (entity == null) {
            return;
        }
        entity.setVelocity((double)packet28.field_6366_b / 8000.0, (double)packet28.field_6369_c / 8000.0, (double)packet28.field_6368_d / 8000.0);
    }

    @Override
    public void handleNamedEntitySpawn(Packet20NamedEntitySpawn packet20namedentityspawn) {
        double d2 = (double)packet20namedentityspawn.xPosition / 32.0;
        double d1 = (double)packet20namedentityspawn.yPosition / 32.0;
        double d22 = (double)packet20namedentityspawn.zPosition / 32.0;
        float f2 = (float)(packet20namedentityspawn.rotation * 360) / 256.0f;
        float f1 = (float)(packet20namedentityspawn.pitch * 360) / 256.0f;
        EntityOtherPlayerMP entityotherplayermp = new EntityOtherPlayerMP(this.mc.theWorld, packet20namedentityspawn.name);
        entityotherplayermp.field_9303_br = packet20namedentityspawn.xPosition;
        entityotherplayermp.field_9302_bs = packet20namedentityspawn.yPosition;
        entityotherplayermp.field_9301_bt = packet20namedentityspawn.zPosition;
        int i2 = packet20namedentityspawn.currentItem;
        entityotherplayermp.inventory.mainInventory[entityotherplayermp.inventory.currentItem] = i2 == 0 ? null : new ItemStack(i2);
        entityotherplayermp.setPositionAndRotation(d2, d1, d22, f2, f1);
        this.worldClient.func_712_a(packet20namedentityspawn.entityId, entityotherplayermp);
    }

    @Override
    public void handleEntityTeleport(Packet34EntityTeleport packet34entityteleport) {
        Entity entity = this.func_12246_a(packet34entityteleport.entityId);
        if (entity == null) {
            return;
        }
        entity.field_9303_br = packet34entityteleport.xPosition;
        entity.field_9302_bs = packet34entityteleport.yPosition;
        entity.field_9301_bt = packet34entityteleport.zPosition;
        double d2 = (double)entity.field_9303_br / 32.0;
        double d1 = (double)entity.field_9302_bs / 32.0 + 0.015625;
        double d22 = (double)entity.field_9301_bt / 32.0;
        float f2 = (float)(packet34entityteleport.yaw * 360) / 256.0f;
        float f1 = (float)(packet34entityteleport.pitch * 360) / 256.0f;
        entity.setPositionAndRotation2(d2, d1, d22, f2, f1, 3);
    }

    @Override
    public void handleEntity(Packet30Entity packet30entity) {
        Entity entity = this.func_12246_a(packet30entity.entityId);
        if (entity == null) {
            return;
        }
        entity.field_9303_br += packet30entity.xPosition;
        entity.field_9302_bs += packet30entity.yPosition;
        entity.field_9301_bt += packet30entity.zPosition;
        double d2 = (double)entity.field_9303_br / 32.0;
        double d1 = (double)entity.field_9302_bs / 32.0 + 0.015625;
        double d22 = (double)entity.field_9301_bt / 32.0;
        float f2 = packet30entity.rotating ? (float)(packet30entity.yaw * 360) / 256.0f : entity.rotationYaw;
        float f1 = packet30entity.rotating ? (float)(packet30entity.pitch * 360) / 256.0f : entity.rotationPitch;
        entity.setPositionAndRotation2(d2, d1, d22, f2, f1, 3);
    }

    @Override
    public void handleDestroyEntity(Packet29DestroyEntity packet29destroyentity) {
        this.worldClient.func_710_c(packet29destroyentity.entityId);
    }

    @Override
    public void handleFlying(Packet10Flying packet10flying) {
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        double d2 = entityplayersp.posX;
        double d1 = entityplayersp.posY;
        double d22 = entityplayersp.posZ;
        float f2 = entityplayersp.rotationYaw;
        float f1 = entityplayersp.rotationPitch;
        if (packet10flying.moving) {
            d2 = packet10flying.xPosition;
            d1 = packet10flying.yPosition;
            d22 = packet10flying.zPosition;
        }
        if (packet10flying.rotating) {
            f2 = packet10flying.yaw;
            f1 = packet10flying.pitch;
        }
        entityplayersp.field_9287_aY = 0.0f;
        entityplayersp.motionZ = 0.0;
        entityplayersp.motionY = 0.0;
        entityplayersp.motionX = 0.0;
        entityplayersp.setPositionAndRotation(d2, d1, d22, f2, f1);
        packet10flying.xPosition = entityplayersp.posX;
        packet10flying.yPosition = entityplayersp.boundingBox.minY;
        packet10flying.zPosition = entityplayersp.posZ;
        packet10flying.stance = entityplayersp.posY;
        this.netManager.addToSendQueue(packet10flying);
        if (!this.field_1210_g) {
            this.mc.thePlayer.prevPosX = this.mc.thePlayer.posX;
            this.mc.thePlayer.prevPosY = this.mc.thePlayer.posY;
            this.mc.thePlayer.prevPosZ = this.mc.thePlayer.posZ;
            this.field_1210_g = true;
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public void handlePreChunk(Packet50PreChunk packet50prechunk) {
        this.worldClient.func_713_a(packet50prechunk.xPosition, packet50prechunk.yPosition, packet50prechunk.mode);
    }

    @Override
    public void handleMultiBlockChange(Packet52MultiBlockChange packet52multiblockchange) {
        Chunk chunk = this.worldClient.getChunkFromChunkCoords(packet52multiblockchange.xPosition, packet52multiblockchange.zPosition);
        int i2 = packet52multiblockchange.xPosition * 16;
        int j2 = packet52multiblockchange.zPosition * 16;
        for (int k2 = 0; k2 < packet52multiblockchange.size; ++k2) {
            short word0 = packet52multiblockchange.coordinateArray[k2];
            int l2 = packet52multiblockchange.typeArray[k2] & 0xFF;
            byte byte0 = packet52multiblockchange.metadataArray[k2];
            int i1 = word0 >> 12 & 0xF;
            int j1 = word0 >> 8 & 0xF;
            int k1 = word0 & 0xFF;
            chunk.setBlockIDWithMetadata(i1, k1, j1, l2, byte0);
            this.worldClient.func_711_c(i1 + i2, k1, j1 + j2, i1 + i2, k1, j1 + j2);
            this.worldClient.func_701_b(i1 + i2, k1, j1 + j2, i1 + i2, k1, j1 + j2);
        }
    }

    @Override
    public void handleMapChunk(Packet51MapChunk packet51mapchunk) {
        this.worldClient.func_711_c(packet51mapchunk.xPosition, packet51mapchunk.yPosition, packet51mapchunk.zPosition, packet51mapchunk.xPosition + packet51mapchunk.xSize - 1, packet51mapchunk.yPosition + packet51mapchunk.ySize - 1, packet51mapchunk.zPosition + packet51mapchunk.zSize - 1);
        this.worldClient.func_693_a(packet51mapchunk.xPosition, packet51mapchunk.yPosition, packet51mapchunk.zPosition, packet51mapchunk.xSize, packet51mapchunk.ySize, packet51mapchunk.zSize, packet51mapchunk.chunk);
    }

    @Override
    public void handleBlockChange(Packet53BlockChange packet53blockchange) {
        this.worldClient.func_714_c(packet53blockchange.xPosition, packet53blockchange.yPosition, packet53blockchange.zPosition, packet53blockchange.type, packet53blockchange.metadata);
    }

    @Override
    public void handleKickDisconnect(Packet255KickDisconnect packet255kickdisconnect) {
        this.netManager.networkShutdown("Got kicked");
        this.disconnected = true;
        this.mc.func_6261_a(null);
        this.mc.displayGuiScreen(new GuiConnectFailed("Disconnected by server", packet255kickdisconnect.reason));
    }

    @Override
    public void handleErrorMessage(String s2) {
        if (this.disconnected) {
            return;
        }
        this.disconnected = true;
        this.mc.func_6261_a(null);
        this.mc.displayGuiScreen(new GuiConnectFailed("Connection lost", s2));
    }

    public void addToSendQueue(Packet packet) {
        if (this.disconnected) {
            return;
        }
        this.netManager.addToSendQueue(packet);
    }

    @Override
    public void handleCollect(Packet22Collect packet22collect) {
        Entity entity = this.func_12246_a(packet22collect.collectedEntityId);
        EntityLiving obj = (EntityLiving)this.func_12246_a(packet22collect.collectorEntityId);
        if (obj == null) {
            obj = this.mc.thePlayer;
        }
        if (entity != null) {
            this.worldClient.playSoundAtEntity(entity, "random.pop", 0.2f, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7f + 1.0f) * 2.0f);
            this.mc.field_6321_h.func_1192_a(new EntityPickupFX(this.mc.theWorld, entity, obj, -0.5f));
            this.worldClient.func_710_c(packet22collect.collectedEntityId);
        }
    }

    @Override
    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16blockitemswitch) {
        Entity entity = this.func_12246_a(packet16blockitemswitch.unused);
        if (entity == null) {
            return;
        }
        EntityPlayer entityplayer = (EntityPlayer)entity;
        int i2 = packet16blockitemswitch.id;
        entityplayer.inventory.mainInventory[entityplayer.inventory.currentItem] = i2 == 0 ? null : new ItemStack(i2);
    }

    @Override
    public void handleChat(Packet3Chat packet3chat) {
        this.mc.ingameGUI.addChatMessage(packet3chat.message);
    }

    @Override
    public void handleArmAnimation(Packet18ArmAnimation packet18armanimation) {
        Entity entity = this.func_12246_a(packet18armanimation.entityId);
        if (entity == null) {
            return;
        }
        if (packet18armanimation.animate == 1) {
            EntityPlayer entityplayer = (EntityPlayer)entity;
            entityplayer.func_457_w();
        } else if (packet18armanimation.animate == 100) {
            entity.field_9300_bu = true;
        } else if (packet18armanimation.animate == 101) {
            entity.field_9300_bu = false;
        } else if (packet18armanimation.animate == 102) {
            entity.field_9299_bv = true;
        } else if (packet18armanimation.animate == 103) {
            entity.field_9299_bv = false;
        } else if (packet18armanimation.animate == 104) {
            entity.field_12240_bw = true;
        } else if (packet18armanimation.animate == 105) {
            entity.field_12240_bw = false;
        } else if (packet18armanimation.animate == 2) {
            entity.func_9280_g();
        }
    }

    @Override
    public void handleAddToInventory(Packet17AddToInventory packet17addtoinventory) {
        this.mc.thePlayer.inventory.addItemStackToInventory(new ItemStack(packet17addtoinventory.id, packet17addtoinventory.count, packet17addtoinventory.durability));
    }

    @Override
    public void handleHandshake(Packet2Handshake packet2handshake) {
        if (packet2handshake.username.equals("-")) {
            this.addToSendQueue(new Packet1Login(this.mc.field_6320_i.inventory, "Password", 6));
        } else {
            try {
                URL url = new URL("http://www.minecraft.net/game/joinserver.jsp?user=" + this.mc.field_6320_i.inventory + "&sessionId=" + this.mc.field_6320_i.field_6543_c + "&serverId=" + packet2handshake.username);
                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(url.openStream()));
                String s2 = bufferedreader.readLine();
                bufferedreader.close();
                if (s2.equalsIgnoreCase("ok")) {
                    this.addToSendQueue(new Packet1Login(this.mc.field_6320_i.inventory, "Password", 6));
                } else {
                    this.netManager.networkShutdown("Failed to login: " + s2);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                this.netManager.networkShutdown("Internal client error: " + exception.toString());
            }
        }
    }

    public void disconnect() {
        this.disconnected = true;
        this.netManager.networkShutdown("Closed");
    }

    @Override
    public void handleMobSpawn(Packet24MobSpawn packet24mobspawn) {
        double d2 = (double)packet24mobspawn.xPosition / 32.0;
        double d1 = (double)packet24mobspawn.yPosition / 32.0;
        double d22 = (double)packet24mobspawn.zPosition / 32.0;
        float f2 = (float)(packet24mobspawn.yaw * 360) / 256.0f;
        float f1 = (float)(packet24mobspawn.pitch * 360) / 256.0f;
        EntityLiving entityliving = (EntityLiving)EntityList.createEntity(packet24mobspawn.type, this.mc.theWorld);
        entityliving.field_9303_br = packet24mobspawn.xPosition;
        entityliving.field_9302_bs = packet24mobspawn.yPosition;
        entityliving.field_9301_bt = packet24mobspawn.zPosition;
        entityliving.field_620_ab = packet24mobspawn.entityId;
        entityliving.setPositionAndRotation(d2, d1, d22, f2, f1);
        entityliving.field_9343_G = true;
        this.worldClient.func_712_a(packet24mobspawn.entityId, entityliving);
    }

    @Override
    public void handleUpdateTime(Packet4UpdateTime packet4updatetime) {
        this.mc.theWorld.setWorldTime(packet4updatetime.time);
    }

    @Override
    public void handlePlayerInventory(Packet5PlayerInventory packet5playerinventory) {
        EntityPlayerSP entityplayersp = this.mc.thePlayer;
        if (packet5playerinventory.type == -1) {
            entityplayersp.inventory.mainInventory = packet5playerinventory.stacks;
        }
        if (packet5playerinventory.type == -2) {
            entityplayersp.inventory.craftingInventory = packet5playerinventory.stacks;
        }
        if (packet5playerinventory.type == -3) {
            entityplayersp.inventory.armorInventory = packet5playerinventory.stacks;
        }
    }

    @Override
    public void handleComplexEntity(Packet59ComplexEntity packet59complexentity) {
        if (packet59complexentity.entityNBT.getInteger("x") != packet59complexentity.xPosition) {
            return;
        }
        if (packet59complexentity.entityNBT.getInteger("y") != packet59complexentity.yPosition) {
            return;
        }
        if (packet59complexentity.entityNBT.getInteger("z") != packet59complexentity.zPosition) {
            return;
        }
        TileEntity tileentity = this.worldClient.getBlockTileEntity(packet59complexentity.xPosition, packet59complexentity.yPosition, packet59complexentity.zPosition);
        if (tileentity != null) {
            try {
                tileentity.readFromNBT(packet59complexentity.entityNBT);
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.worldClient.func_701_b(packet59complexentity.xPosition, packet59complexentity.yPosition, packet59complexentity.zPosition, packet59complexentity.xPosition, packet59complexentity.yPosition, packet59complexentity.zPosition);
        }
    }

    @Override
    public void handleSpawnPosition(Packet6SpawnPosition packet6spawnposition) {
        this.worldClient.spawnX = packet6spawnposition.xPosition;
        this.worldClient.spawnY = packet6spawnposition.yPosition;
        this.worldClient.spawnZ = packet6spawnposition.zPosition;
    }

    @Override
    public void func_6497_a(Packet39 packet39) {
        Entity obj = this.func_12246_a(packet39.field_6365_a);
        Entity entity = this.func_12246_a(packet39.field_6364_b);
        if (packet39.field_6365_a == this.mc.thePlayer.field_620_ab) {
            obj = this.mc.thePlayer;
        }
        if (obj == null) {
            return;
        }
        obj.mountEntity(entity);
    }

    @Override
    public void func_9447_a(Packet38 packet38) {
        Entity entity = this.func_12246_a(packet38.field_9274_a);
        if (entity != null) {
            entity.func_9282_a(packet38.field_9273_b);
        }
    }

    private Entity func_12246_a(int i2) {
        if (i2 == this.mc.thePlayer.field_620_ab) {
            return this.mc.thePlayer;
        }
        return this.worldClient.func_709_b(i2);
    }

    @Override
    public void handleHealth(Packet8 packet8) {
        this.mc.thePlayer.setHealth(packet8.healthMP);
    }

    @Override
    public void func_9448_a(Packet9 packet9) {
        this.mc.respawn();
    }

    @Override
    public void func_12245_a(Packet60 packet60) {
        Explosion explosion = new Explosion(this.mc.theWorld, null, packet60.field_12236_a, packet60.field_12235_b, packet60.field_12239_c, packet60.field_12238_d);
        explosion.field_12251_g = packet60.field_12237_e;
        explosion.func_12247_b();
    }
}

