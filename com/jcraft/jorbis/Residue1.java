/*
 * Decompiled with CFR 0.150.
 */
package com.jcraft.jorbis;

import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Residue0;

class Residue1
extends Residue0 {
    Residue1() {
    }

    int inverse(Block block, Object object, float[][] arrf, int[] arrn, int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (arrn[i2] == 0) continue;
            arrf[n3++] = arrf[i2];
        }
        if (n3 != 0) {
            return Residue1._01inverse(block, object, arrf, n3, 1);
        }
        return 0;
    }
}

