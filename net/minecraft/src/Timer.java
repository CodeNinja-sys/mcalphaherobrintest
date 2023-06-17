/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class Timer {
    public float ticksPerSecond;
    private double lastHRTime;
    public int elapsedTicks;
    public float renderPartialTicks;
    public float timerSpeed = 1.0f;
    public float elapsedPartialTicks = 0.0f;
    private long lastSyncSysClock;
    private long lastSyncHRClock;
    private double timeSyncAdjustment = 1.0;

    public Timer(float f2) {
        this.ticksPerSecond = f2;
        this.lastSyncSysClock = System.currentTimeMillis();
        this.lastSyncHRClock = System.nanoTime() / 1000000L;
    }

    public void updateTimer() {
        long l2 = System.currentTimeMillis();
        long l1 = l2 - this.lastSyncSysClock;
        long l22 = System.nanoTime() / 1000000L;
        if (l1 > 1000L) {
            long l3 = l22 - this.lastSyncHRClock;
            double d1 = (double)l1 / (double)l3;
            this.timeSyncAdjustment += (d1 - this.timeSyncAdjustment) * (double)0.2f;
            this.lastSyncSysClock = l2;
            this.lastSyncHRClock = l22;
        }
        if (l1 < 0L) {
            this.lastSyncSysClock = l2;
            this.lastSyncHRClock = l22;
        }
        double d2 = (double)l22 / 1000.0;
        double d22 = (d2 - this.lastHRTime) * this.timeSyncAdjustment;
        this.lastHRTime = d2;
        if (d22 < 0.0) {
            d22 = 0.0;
        }
        if (d22 > 1.0) {
            d22 = 1.0;
        }
        this.elapsedPartialTicks = (float)((double)this.elapsedPartialTicks + d22 * (double)this.timerSpeed * (double)this.ticksPerSecond);
        this.elapsedTicks = (int)this.elapsedPartialTicks;
        this.elapsedPartialTicks -= (float)this.elapsedTicks;
        if (this.elapsedTicks > 10) {
            this.elapsedTicks = 10;
        }
        this.renderPartialTicks = this.elapsedPartialTicks;
    }
}

