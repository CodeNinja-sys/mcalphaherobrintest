/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.MCHashTable;

class HashEntry {
    final int hashEntry;
    Object valueEntry;
    HashEntry nextEntry;
    final int slotHash;

    HashEntry(int i2, int j2, Object obj, HashEntry hashentry) {
        this.valueEntry = obj;
        this.nextEntry = hashentry;
        this.hashEntry = j2;
        this.slotHash = i2;
    }

    public final int getHash() {
        return this.hashEntry;
    }

    public final Object getValue() {
        return this.valueEntry;
    }

    public final boolean equals(Object obj) {
        Object obj2;
        Object obj1;
        Integer integer1;
        if (!(obj instanceof HashEntry)) {
            return false;
        }
        HashEntry hashentry = (HashEntry)obj;
        Integer integer = this.getHash();
        return (integer == (integer1 = Integer.valueOf(hashentry.getHash())) || integer != null && integer.equals(integer1)) && ((obj1 = this.getValue()) == (obj2 = hashentry.getValue()) || obj1 != null && obj1.equals(obj2));
    }

    public final int hashCode() {
        return MCHashTable.getHash(this.hashEntry);
    }

    public final String toString() {
        return this.getHash() + "=" + this.getValue();
    }
}

