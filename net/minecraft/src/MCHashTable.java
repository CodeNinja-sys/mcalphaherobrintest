/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.HashEntry;

public class MCHashTable {
    private transient HashEntry[] slots = new HashEntry[16];
    private transient int count;
    private int threshold = 12;
    private final float growFactor = 0.75f;
    private volatile transient int versionStamp;

    private static int computeHash(int i2) {
        i2 ^= i2 >>> 20 ^ i2 >>> 12;
        return i2 ^ i2 >>> 7 ^ i2 >>> 4;
    }

    private static int getSlotIndex(int i2, int j2) {
        return i2 & j2 - 1;
    }

    public Object lookup(int i2) {
        int j2 = MCHashTable.computeHash(i2);
        HashEntry hashentry = this.slots[MCHashTable.getSlotIndex(j2, this.slots.length)];
        while (hashentry != null) {
            if (hashentry.hashEntry == i2) {
                return hashentry.valueEntry;
            }
            hashentry = hashentry.nextEntry;
        }
        return null;
    }

    public void addKey(int i2, Object obj) {
        int j2 = MCHashTable.computeHash(i2);
        int k2 = MCHashTable.getSlotIndex(j2, this.slots.length);
        HashEntry hashentry = this.slots[k2];
        while (hashentry != null) {
            if (hashentry.hashEntry == i2) {
                hashentry.valueEntry = obj;
            }
            hashentry = hashentry.nextEntry;
        }
        ++this.versionStamp;
        this.insert(j2, i2, obj, k2);
    }

    private void grow(int i2) {
        HashEntry[] ahashentry = this.slots;
        int j2 = ahashentry.length;
        if (j2 == 0x40000000) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        HashEntry[] ahashentry1 = new HashEntry[i2];
        this.copyTo(ahashentry1);
        this.slots = ahashentry1;
        this.threshold = (int)((float)i2 * 0.75f);
    }

    private void copyTo(HashEntry[] ahashentry) {
        HashEntry[] ahashentry1 = this.slots;
        int i2 = ahashentry.length;
        for (int j2 = 0; j2 < ahashentry1.length; ++j2) {
            HashEntry hashentry1;
            HashEntry hashentry = ahashentry1[j2];
            if (hashentry == null) continue;
            ahashentry1[j2] = null;
            do {
                hashentry1 = hashentry.nextEntry;
                int k2 = MCHashTable.getSlotIndex(hashentry.slotHash, i2);
                hashentry.nextEntry = ahashentry[k2];
                ahashentry[k2] = hashentry;
            } while ((hashentry = hashentry1) != null);
        }
    }

    public Object removeObject(int i2) {
        HashEntry hashentry = this.removeEntry(i2);
        return hashentry != null ? hashentry.valueEntry : null;
    }

    final HashEntry removeEntry(int i2) {
        HashEntry hashentry;
        int j2 = MCHashTable.computeHash(i2);
        int k2 = MCHashTable.getSlotIndex(j2, this.slots.length);
        HashEntry hashentry1 = hashentry = this.slots[k2];
        while (hashentry1 != null) {
            HashEntry hashentry2 = hashentry1.nextEntry;
            if (hashentry1.hashEntry == i2) {
                ++this.versionStamp;
                --this.count;
                if (hashentry == hashentry1) {
                    this.slots[k2] = hashentry2;
                } else {
                    hashentry.nextEntry = hashentry2;
                }
                return hashentry1;
            }
            hashentry = hashentry1;
            hashentry1 = hashentry2;
        }
        return hashentry1;
    }

    public void clearMap() {
        ++this.versionStamp;
        HashEntry[] ahashentry = this.slots;
        for (int i2 = 0; i2 < ahashentry.length; ++i2) {
            ahashentry[i2] = null;
        }
        this.count = 0;
    }

    private void insert(int i2, int j2, Object obj, int k2) {
        HashEntry hashentry = this.slots[k2];
        this.slots[k2] = new HashEntry(i2, j2, obj, hashentry);
        if (this.count++ >= this.threshold) {
            this.grow(2 * this.slots.length);
        }
    }

    static int getHash(int i2) {
        return MCHashTable.computeHash(i2);
    }
}

