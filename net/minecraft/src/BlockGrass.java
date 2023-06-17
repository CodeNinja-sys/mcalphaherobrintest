/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockGrass
extends Block {
    protected BlockGrass(int i2) {
        super(i2, Material.ground);
        this.blockIndexInTexture = 3;
        this.setTickOnLoad(true);
    }

    @Override
    public int getBlockTexture(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        if (l2 == 1) {
            return 0;
        }
        if (l2 == 0) {
            return 2;
        }
        Material material = iblockaccess.getBlockMaterial(i2, j2 + 1, k2);
        return material != Material.snow && material != Material.builtSnow ? 3 : 68;
    }

    @Override
    public int colorMultiplier(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        iblockaccess.func_4075_a().func_4069_a(i2, k2, 1, 1);
        double d2 = iblockaccess.func_4075_a().temperature[0];
        double d1 = iblockaccess.func_4075_a().humidity[0];
        return ColorizerGrass.func_4147_a(d2, d1);
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        int j1;
        int i1;
        int l2;
        if (world.getBlockLightValue(i2, j2 + 1, k2) < 4 && world.getBlockMaterial(i2, j2 + 1, k2).getCanBlockGrass()) {
            if (random.nextInt(4) != 0) {
                return;
            }
            world.setBlockWithNotify(i2, j2, k2, Block.dirt.blockID);
        } else if (world.getBlockLightValue(i2, j2 + 1, k2) >= 9 && world.getBlockId(l2 = i2 + random.nextInt(3) - 1, i1 = j2 + random.nextInt(5) - 3, j1 = k2 + random.nextInt(3) - 1) == Block.dirt.blockID && world.getBlockLightValue(l2, i1 + 1, j1) >= 4 && !world.getBlockMaterial(l2, i1 + 1, j1).getCanBlockGrass()) {
            world.setBlockWithNotify(l2, i1, j1, Block.grass.blockID);
        }
    }

    @Override
    public int idDropped(int i2, Random random) {
        return Block.dirt.idDropped(0, random);
    }
}

