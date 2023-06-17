/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class BlockFluids
extends Block {
    protected BlockFluids(int i2, Material material) {
        super(i2, (material != Material.lava ? 12 : 14) * 16 + 13, material);
        float f2 = 0.0f;
        float f1 = 0.0f;
        this.setBlockBounds(0.0f + f1, 0.0f + f2, 0.0f + f1, 1.0f + f1, 1.0f + f2, 1.0f + f1);
        this.setTickOnLoad(true);
    }

    public static float func_288_b(int i2) {
        if (i2 >= 8) {
            i2 = 0;
        }
        float f2 = (float)(i2 + 1) / 9.0f;
        return f2;
    }

    @Override
    public int getBlockTextureFromSide(int i2) {
        if (i2 == 0 || i2 == 1) {
            return this.blockIndexInTexture;
        }
        return this.blockIndexInTexture + 1;
    }

    protected int func_290_h(World world, int i2, int j2, int k2) {
        if (world.getBlockMaterial(i2, j2, k2) != this.blockMaterial) {
            return -1;
        }
        return world.getBlockMetadata(i2, j2, k2);
    }

    protected int func_289_b(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        if (iblockaccess.getBlockMaterial(i2, j2, k2) != this.blockMaterial) {
            return -1;
        }
        int l2 = iblockaccess.getBlockMetadata(i2, j2, k2);
        if (l2 >= 8) {
            l2 = 0;
        }
        return l2;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canCollideCheck(int i2, boolean flag) {
        return flag && i2 == 0;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i2, int j2, int k2, int l2) {
        Material material = iblockaccess.getBlockMaterial(i2, j2, k2);
        if (material == this.blockMaterial) {
            return false;
        }
        if (material == Material.ice) {
            return false;
        }
        if (l2 == 1) {
            return true;
        }
        return super.shouldSideBeRendered(iblockaccess, i2, j2, k2, l2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i2, int j2, int k2) {
        return null;
    }

    @Override
    public int getRenderType() {
        return 4;
    }

    @Override
    public int idDropped(int i2, Random random) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    private Vec3D func_291_e(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        Vec3D vec3d = Vec3D.createVector(0.0, 0.0, 0.0);
        int l2 = this.func_289_b(iblockaccess, i2, j2, k2);
        for (int i1 = 0; i1 < 4; ++i1) {
            int i22;
            int j1 = i2;
            int k1 = j2;
            int l1 = k2;
            if (i1 == 0) {
                --j1;
            }
            if (i1 == 1) {
                --l1;
            }
            if (i1 == 2) {
                ++j1;
            }
            if (i1 == 3) {
                ++l1;
            }
            if ((i22 = this.func_289_b(iblockaccess, j1, k1, l1)) < 0) {
                if (iblockaccess.getBlockMaterial(j1, k1, l1).func_880_c() || (i22 = this.func_289_b(iblockaccess, j1, k1 - 1, l1)) < 0) continue;
                int j22 = i22 - (l2 - 8);
                vec3d = vec3d.addVector((j1 - i2) * j22, (k1 - j2) * j22, (l1 - k2) * j22);
                continue;
            }
            if (i22 < 0) continue;
            int k22 = i22 - l2;
            vec3d = vec3d.addVector((j1 - i2) * k22, (k1 - j2) * k22, (l1 - k2) * k22);
        }
        if (iblockaccess.getBlockMetadata(i2, j2, k2) >= 8) {
            boolean flag = false;
            if (flag || this.shouldSideBeRendered(iblockaccess, i2, j2, k2 - 1, 2)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2, j2, k2 + 1, 3)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2 - 1, j2, k2, 4)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2 + 1, j2, k2, 5)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2, j2 + 1, k2 - 1, 2)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2, j2 + 1, k2 + 1, 3)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2 - 1, j2 + 1, k2, 4)) {
                flag = true;
            }
            if (flag || this.shouldSideBeRendered(iblockaccess, i2 + 1, j2 + 1, k2, 5)) {
                flag = true;
            }
            if (flag) {
                vec3d = vec3d.normalize().addVector(0.0, -6.0, 0.0);
            }
        }
        vec3d = vec3d.normalize();
        return vec3d;
    }

    @Override
    public void velocityToAddToEntity(World world, int i2, int j2, int k2, Entity entity, Vec3D vec3d) {
        Vec3D vec3d1 = this.func_291_e(world, i2, j2, k2);
        vec3d.xCoord += vec3d1.xCoord;
        vec3d.yCoord += vec3d1.yCoord;
        vec3d.zCoord += vec3d1.zCoord;
    }

    @Override
    public int tickRate() {
        if (this.blockMaterial == Material.water) {
            return 5;
        }
        return this.blockMaterial != Material.lava ? 0 : 30;
    }

    @Override
    public float getBlockBrightness(IBlockAccess iblockaccess, int i2, int j2, int k2) {
        float f1;
        float f2 = iblockaccess.getLightBrightness(i2, j2, k2);
        return f2 <= (f1 = iblockaccess.getLightBrightness(i2, j2 + 1, k2)) ? f1 : f2;
    }

    @Override
    public void updateTick(World world, int i2, int j2, int k2, Random random) {
        super.updateTick(world, i2, j2, k2, random);
    }

    @Override
    public int func_234_g() {
        return this.blockMaterial != Material.water ? 0 : 1;
    }

    @Override
    public void randomDisplayTick(World world, int i2, int j2, int k2, Random random) {
        int l2;
        if (this.blockMaterial == Material.water && random.nextInt(64) == 0 && (l2 = world.getBlockMetadata(i2, j2, k2)) > 0 && l2 < 8) {
            world.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, "liquid.water", random.nextFloat() * 0.25f + 0.75f, random.nextFloat() * 1.0f + 0.5f);
        }
        if (this.blockMaterial == Material.lava && world.getBlockMaterial(i2, j2 + 1, k2) == Material.air && !world.isBlockOpaqueCube(i2, j2 + 1, k2) && random.nextInt(100) == 0) {
            double d2 = (float)i2 + random.nextFloat();
            double d1 = (double)j2 + this.maxY;
            double d22 = (float)k2 + random.nextFloat();
            world.spawnParticle("lava", d2, d1, d22, 0.0, 0.0, 0.0);
        }
    }

    public static double func_293_a(IBlockAccess iblockaccess, int i2, int j2, int k2, Material material) {
        Vec3D vec3d = null;
        if (material == Material.water) {
            vec3d = ((BlockFluids)Block.waterStill).func_291_e(iblockaccess, i2, j2, k2);
        }
        if (material == Material.lava) {
            vec3d = ((BlockFluids)Block.lavaStill).func_291_e(iblockaccess, i2, j2, k2);
        }
        if (vec3d.xCoord == 0.0 && vec3d.zCoord == 0.0) {
            return -1000.0;
        }
        return Math.atan2(vec3d.zCoord, vec3d.xCoord) - 1.5707963267948966;
    }

    @Override
    public void onBlockAdded(World world, int i2, int j2, int k2) {
        this.checkForHarden(world, i2, j2, k2);
    }

    @Override
    public void onNeighborBlockChange(World world, int i2, int j2, int k2, int l2) {
        this.checkForHarden(world, i2, j2, k2);
    }

    private void checkForHarden(World world, int i2, int j2, int k2) {
        if (world.getBlockId(i2, j2, k2) != this.blockID) {
            return;
        }
        if (this.blockMaterial == Material.lava) {
            boolean flag = false;
            if (flag || world.getBlockMaterial(i2, j2, k2 - 1) == Material.water) {
                flag = true;
            }
            if (flag || world.getBlockMaterial(i2, j2, k2 + 1) == Material.water) {
                flag = true;
            }
            if (flag || world.getBlockMaterial(i2 - 1, j2, k2) == Material.water) {
                flag = true;
            }
            if (flag || world.getBlockMaterial(i2 + 1, j2, k2) == Material.water) {
                flag = true;
            }
            if (flag || world.getBlockMaterial(i2, j2 + 1, k2) == Material.water) {
                flag = true;
            }
            if (flag) {
                int l2 = world.getBlockMetadata(i2, j2, k2);
                if (l2 == 0) {
                    world.setBlockWithNotify(i2, j2, k2, Block.obsidian.blockID);
                } else if (l2 <= 4) {
                    world.setBlockWithNotify(i2, j2, k2, Block.cobblestone.blockID);
                }
                this.func_292_i(world, i2, j2, k2);
            }
        }
    }

    protected void func_292_i(World world, int i2, int j2, int k2) {
        world.playSoundEffect((float)i2 + 0.5f, (float)j2 + 0.5f, (float)k2 + 0.5f, "random.fizz", 0.5f, 2.6f + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8f);
        for (int l2 = 0; l2 < 8; ++l2) {
            world.spawnParticle("largesmoke", (double)i2 + Math.random(), (double)j2 + 1.2, (double)k2 + Math.random(), 0.0, 0.0, 0.0);
        }
    }
}

