/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;

public class BlockBreakable
extends Block {
    private boolean field_6363_a;

    protected BlockBreakable(int i2, int j2, Material material, boolean flag) {
        super(i2, j2, material);
        this.field_6363_a = flag;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        int i1 = iblockaccess.getBlockId(i2, j2, k2);
        if (!this.field_6363_a && i1 == this.blockID) {
            return false;
        }
        return super.shouldSideBeRendered(iblockaccess, i2, j2, k2, l2);
    }
}

