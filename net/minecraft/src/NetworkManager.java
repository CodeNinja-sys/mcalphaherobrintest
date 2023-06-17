/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.src.NetHandler;
import net.minecraft.src.NetworkMasterThread;
import net.minecraft.src.NetworkReaderThread;
import net.minecraft.src.NetworkWriterThread;
import net.minecraft.src.Packet;

public class NetworkManager {
    public static final Object threadSyncObject = new Object();
    public static int numReadThreads;
    public static int numWriteThreads;
    private Object sendQueueLock = new Object();
    private Socket field_12258_e;
    private final SocketAddress networkSocket;
    private DataInputStream socketInputStream;
    private DataOutputStream socketOutputStream;
    private boolean isRunning = true;
    private List readPackets = Collections.synchronizedList(new ArrayList());
    private List dataPackets = Collections.synchronizedList(new ArrayList());
    private List chunkDataPackets = Collections.synchronizedList(new ArrayList());
    private NetHandler netHandler;
    private boolean isServerTerminating = false;
    private Thread writeThread;
    private Thread readThread;
    private boolean isTerminating = false;
    private String terminationReason = "";
    private int timeSinceLastRead = 0;
    private int sendQueueByteLength = 0;
    private int chunkDataSendCounter = 0;

    public NetworkManager(Socket socket, String s2, NetHandler nethandler) throws IOException {
        this.field_12258_e = socket;
        this.networkSocket = socket.getRemoteSocketAddress();
        this.netHandler = nethandler;
        socket.setTrafficClass(24);
        this.socketInputStream = new DataInputStream(socket.getInputStream());
        this.socketOutputStream = new DataOutputStream(socket.getOutputStream());
        this.readThread = new NetworkReaderThread(this, s2 + " read thread");
        this.writeThread = new NetworkWriterThread(this, s2 + " write thread");
        this.readThread.start();
        this.writeThread.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addToSendQueue(Packet packet) {
        if (this.isServerTerminating) {
            return;
        }
        Object object = this.sendQueueLock;
        synchronized (object) {
            this.sendQueueByteLength += packet.getPacketSize() + 1;
            if (packet.isChunkDataPacket) {
                this.chunkDataPackets.add(packet);
            } else {
                this.dataPackets.add(packet);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendPacket() {
        block12: {
            try {
                Object object;
                boolean flag = true;
                if (!this.dataPackets.isEmpty()) {
                    Packet packet;
                    flag = false;
                    object = this.sendQueueLock;
                    synchronized (object) {
                        packet = (Packet)this.dataPackets.remove(0);
                        this.sendQueueByteLength -= packet.getPacketSize() + 1;
                    }
                    Packet.writePacket(packet, this.socketOutputStream);
                }
                if ((flag || this.chunkDataSendCounter-- <= 0) && !this.chunkDataPackets.isEmpty()) {
                    Packet packet1;
                    flag = false;
                    object = this.sendQueueLock;
                    synchronized (object) {
                        packet1 = (Packet)this.chunkDataPackets.remove(0);
                        this.sendQueueByteLength -= packet1.getPacketSize() + 1;
                    }
                    Packet.writePacket(packet1, this.socketOutputStream);
                    this.chunkDataSendCounter = 50;
                }
                if (flag) {
                    Thread.sleep(10L);
                }
            }
            catch (InterruptedException flag) {
            }
            catch (Exception exception) {
                if (this.isTerminating) break block12;
                this.onNetworkError(exception);
            }
        }
    }

    private void readPacket() {
        block4: {
            try {
                Packet packet = Packet.readPacket(this.socketInputStream);
                if (packet != null) {
                    this.readPackets.add(packet);
                } else {
                    this.networkShutdown("End of stream");
                }
            }
            catch (Exception exception) {
                if (this.isTerminating) break block4;
                this.onNetworkError(exception);
            }
        }
    }

    private void onNetworkError(Exception exception) {
        exception.printStackTrace();
        this.networkShutdown("Internal exception: " + exception.toString());
    }

    public void networkShutdown(String s2) {
        if (!this.isRunning) {
            return;
        }
        this.isTerminating = true;
        this.terminationReason = s2;
        new NetworkMasterThread(this).start();
        this.isRunning = false;
        try {
            this.socketInputStream.close();
            this.socketInputStream = null;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            this.socketOutputStream.close();
            this.socketOutputStream = null;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            this.field_12258_e.close();
            this.field_12258_e = null;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public void processReadPackets() {
        if (this.sendQueueByteLength > 0x100000) {
            this.networkShutdown("Send buffer overflow");
        }
        if (this.readPackets.isEmpty()) {
            if (this.timeSinceLastRead++ == 1200) {
                this.networkShutdown("Timed out");
            }
        } else {
            this.timeSinceLastRead = 0;
        }
        int i2 = 100;
        while (!this.readPackets.isEmpty() && i2-- >= 0) {
            Packet packet = (Packet)this.readPackets.remove(0);
            packet.processPacket(this.netHandler);
        }
        if (this.isTerminating && this.readPackets.isEmpty()) {
            this.netHandler.handleErrorMessage(this.terminationReason);
        }
    }

    static boolean isRunning(NetworkManager networkmanager) {
        return networkmanager.isRunning;
    }

    static boolean isServerTerminating(NetworkManager networkmanager) {
        return networkmanager.isServerTerminating;
    }

    static void readNetworkPacket(NetworkManager networkmanager) {
        networkmanager.readPacket();
    }

    static void sendNetworkPacket(NetworkManager networkmanager) {
        networkmanager.sendPacket();
    }

    static Thread getReadThread(NetworkManager networkmanager) {
        return networkmanager.readThread;
    }

    static Thread getWriteThread(NetworkManager networkmanager) {
        return networkmanager.writeThread;
    }
}

