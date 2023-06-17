/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class NextTickListEntry
implements Comparable {
    private static long nextTickEntryID = 0L;
    public int xCoord;
    public int yCoord;
    public int zCoord;
    public int blockID;
    public long scheduledTime;
    private long tickEntryID = nextTickEntryID++;

    public NextTickListEntry(int i2, int j2, int k2, int l2) {
        this.xCoord = i2;
        this.yCoord = j2;
        this.zCoord = k2;
        this.blockID = l2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NextTickListEntry) {
            NextTickListEntry nextticklistentry = (NextTickListEntry)obj;
            return this.xCoord == nextticklistentry.xCoord && this.yCoord == nextticklistentry.yCoord && this.zCoord == nextticklistentry.zCoord && this.blockID == nextticklistentry.blockID;
        }
        return false;
    }

    public int hashCode() {
        return (this.xCoord * 128 * 1024 + this.zCoord * 128 + this.yCoord) * 256 + this.blockID;
    }

    public NextTickListEntry setScheduledTime(long l2) {
        this.scheduledTime = l2;
        return this;
    }

    public int comparer(NextTickListEntry nextticklistentry) {
        if (this.scheduledTime < nextticklistentry.scheduledTime) {
            return -1;
        }
        if (this.scheduledTime > nextticklistentry.scheduledTime) {
            return 1;
        }
        if (this.tickEntryID < nextticklistentry.tickEntryID) {
            return -1;
        }
        return this.tickEntryID <= nextticklistentry.tickEntryID ? 0 : 1;
    }

    public int compareTo(Object obj) {
        return this.comparer((NextTickListEntry)obj);
    }
}

