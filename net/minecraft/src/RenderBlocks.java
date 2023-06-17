/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.BlockFluids;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderBlocks {
    private IBlockAccess blockAccess;
    private int overrideBlockTexture = -1;
    private boolean flipTexture = false;
    private boolean renderAllFaces = false;

    public RenderBlocks(IBlockAccess iblockaccess) {
        this.blockAccess = iblockaccess;
    }

    public RenderBlocks() {
    }

    public void renderBlockUsingTexture(Block block, int i2, int j2, int k2, int l2) {
        this.overrideBlockTexture = l2;
        this.renderBlockByRenderType(block, i2, j2, k2);
        this.overrideBlockTexture = -1;
    }

    public boolean renderBlockByRenderType(Block block, int i2, int j2, int k2) {
        int l2 = block.getRenderType();
        block.setBlockBoundsBasedOnState(this.blockAccess, i2, j2, k2);
        if (l2 == 0) {
            return this.renderStandardBlock(block, i2, j2, k2);
        }
        if (l2 == 4) {
            return this.renderBlockFluids(block, i2, j2, k2);
        }
        if (l2 == 13) {
            return this.renderBlockCactus(block, i2, j2, k2);
        }
        if (l2 == 1) {
            return this.renderBlockReed(block, i2, j2, k2);
        }
        if (l2 == 6) {
            return this.renderBlockCrops(block, i2, j2, k2);
        }
        if (l2 == 2) {
            return this.renderBlockTorch(block, i2, j2, k2);
        }
        if (l2 == 3) {
            return this.renderBlockFire(block, i2, j2, k2);
        }
        if (l2 == 5) {
            return this.renderBlockRedstoneWire(block, i2, j2, k2);
        }
        if (l2 == 8) {
            return this.renderBlockLadder(block, i2, j2, k2);
        }
        if (l2 == 7) {
            return this.renderBlockDoor(block, i2, j2, k2);
        }
        if (l2 == 9) {
            return this.renderBlockMinecartTrack(block, i2, j2, k2);
        }
        if (l2 == 10) {
            return this.renderBlockStairs(block, i2, j2, k2);
        }
        if (l2 == 11) {
            return this.renderBlockFence(block, i2, j2, k2);
        }
        if (l2 == 12) {
            return this.renderBlockLever(block, i2, j2, k2);
        }
        return false;
    }

    public boolean renderBlockTorch(Block block, int i2, int j2, int k2) {
        int l2 = this.blockAccess.getBlockMetadata(i2, j2, k2);
        Tessellator tessellator = Tessellator.instance;
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        if (Block.lightValue[block.blockID] > 0) {
            f2 = 1.0f;
        }
        tessellator.setColorOpaque_F(f2, f2, f2);
        double d2 = 0.4f;
        double d1 = 0.5 - d2;
        double d22 = 0.2f;
        if (l2 == 1) {
            this.renderTorchAtAngle(block, (double)i2 - d1, (double)j2 + d22, k2, -d2, 0.0);
        } else if (l2 == 2) {
            this.renderTorchAtAngle(block, (double)i2 + d1, (double)j2 + d22, k2, d2, 0.0);
        } else if (l2 == 3) {
            this.renderTorchAtAngle(block, i2, (double)j2 + d22, (double)k2 - d1, 0.0, -d2);
        } else if (l2 == 4) {
            this.renderTorchAtAngle(block, i2, (double)j2 + d22, (double)k2 + d1, 0.0, d2);
        } else {
            this.renderTorchAtAngle(block, i2, j2, k2, 0.0, 0.0);
        }
        return true;
    }

    public boolean renderBlockLever(Block block, int i2, int j2, int k2) {
        boolean flag1;
        int l2 = this.blockAccess.getBlockMetadata(i2, j2, k2);
        int i1 = l2 & 7;
        boolean flag = (l2 & 8) > 0;
        Tessellator tessellator = Tessellator.instance;
        boolean bl2 = flag1 = this.overrideBlockTexture >= 0;
        if (!flag1) {
            this.overrideBlockTexture = Block.cobblestone.blockIndexInTexture;
        }
        float f2 = 0.25f;
        float f1 = 0.1875f;
        float f22 = 0.1875f;
        if (i1 == 5) {
            block.setBlockBounds(0.5f - f1, 0.0f, 0.5f - f2, 0.5f + f1, f22, 0.5f + f2);
        } else if (i1 == 6) {
            block.setBlockBounds(0.5f - f2, 0.0f, 0.5f - f1, 0.5f + f2, f22, 0.5f + f1);
        } else if (i1 == 4) {
            block.setBlockBounds(0.5f - f1, 0.5f - f2, 1.0f - f22, 0.5f + f1, 0.5f + f2, 1.0f);
        } else if (i1 == 3) {
            block.setBlockBounds(0.5f - f1, 0.5f - f2, 0.0f, 0.5f + f1, 0.5f + f2, f22);
        } else if (i1 == 2) {
            block.setBlockBounds(1.0f - f22, 0.5f - f2, 0.5f - f1, 1.0f, 0.5f + f2, 0.5f + f1);
        } else if (i1 == 1) {
            block.setBlockBounds(0.0f, 0.5f - f2, 0.5f - f1, f22, 0.5f + f2, 0.5f + f1);
        }
        this.renderStandardBlock(block, i2, j2, k2);
        if (!flag1) {
            this.overrideBlockTexture = -1;
        }
        float f3 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        if (Block.lightValue[block.blockID] > 0) {
            f3 = 1.0f;
        }
        tessellator.setColorOpaque_F(f3, f3, f3);
        int j1 = block.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            j1 = this.overrideBlockTexture;
        }
        int k1 = (j1 & 0xF) << 4;
        int l1 = j1 & 0xF0;
        float f4 = (float)k1 / 256.0f;
        float f5 = ((float)k1 + 15.99f) / 256.0f;
        float f6 = (float)l1 / 256.0f;
        float f7 = ((float)l1 + 15.99f) / 256.0f;
        Vec3D[] avec3d = new Vec3D[8];
        float f8 = 0.0625f;
        float f9 = 0.0625f;
        float f10 = 0.625f;
        avec3d[0] = Vec3D.createVector(-f8, 0.0, -f9);
        avec3d[1] = Vec3D.createVector(f8, 0.0, -f9);
        avec3d[2] = Vec3D.createVector(f8, 0.0, f9);
        avec3d[3] = Vec3D.createVector(-f8, 0.0, f9);
        avec3d[4] = Vec3D.createVector(-f8, f10, -f9);
        avec3d[5] = Vec3D.createVector(f8, f10, -f9);
        avec3d[6] = Vec3D.createVector(f8, f10, f9);
        avec3d[7] = Vec3D.createVector(-f8, f10, f9);
        for (int i22 = 0; i22 < 8; ++i22) {
            if (flag) {
                avec3d[i22].zCoord -= 0.0625;
                avec3d[i22].rotateAroundX(0.6981317f);
            } else {
                avec3d[i22].zCoord += 0.0625;
                avec3d[i22].rotateAroundX(-0.6981317f);
            }
            if (i1 == 6) {
                avec3d[i22].rotateAroundY(1.570796f);
            }
            if (i1 < 5) {
                avec3d[i22].yCoord -= 0.375;
                avec3d[i22].rotateAroundX(1.570796f);
                if (i1 == 4) {
                    avec3d[i22].rotateAroundY(0.0f);
                }
                if (i1 == 3) {
                    avec3d[i22].rotateAroundY(3.141593f);
                }
                if (i1 == 2) {
                    avec3d[i22].rotateAroundY(1.570796f);
                }
                if (i1 == 1) {
                    avec3d[i22].rotateAroundY(-1.570796f);
                }
                avec3d[i22].xCoord += (double)i2 + 0.5;
                avec3d[i22].yCoord += (double)((float)j2 + 0.5f);
                avec3d[i22].zCoord += (double)k2 + 0.5;
                continue;
            }
            avec3d[i22].xCoord += (double)i2 + 0.5;
            avec3d[i22].yCoord += (double)((float)j2 + 0.125f);
            avec3d[i22].zCoord += (double)k2 + 0.5;
        }
        Vec3D vec3d = null;
        Vec3D vec3d1 = null;
        Vec3D vec3d2 = null;
        Vec3D vec3d3 = null;
        for (int j22 = 0; j22 < 6; ++j22) {
            if (j22 == 0) {
                f4 = (float)(k1 + 7) / 256.0f;
                f5 = ((float)(k1 + 9) - 0.01f) / 256.0f;
                f6 = (float)(l1 + 6) / 256.0f;
                f7 = ((float)(l1 + 8) - 0.01f) / 256.0f;
            } else if (j22 == 2) {
                f4 = (float)(k1 + 7) / 256.0f;
                f5 = ((float)(k1 + 9) - 0.01f) / 256.0f;
                f6 = (float)(l1 + 6) / 256.0f;
                f7 = ((float)(l1 + 16) - 0.01f) / 256.0f;
            }
            if (j22 == 0) {
                vec3d = avec3d[0];
                vec3d1 = avec3d[1];
                vec3d2 = avec3d[2];
                vec3d3 = avec3d[3];
            } else if (j22 == 1) {
                vec3d = avec3d[7];
                vec3d1 = avec3d[6];
                vec3d2 = avec3d[5];
                vec3d3 = avec3d[4];
            } else if (j22 == 2) {
                vec3d = avec3d[1];
                vec3d1 = avec3d[0];
                vec3d2 = avec3d[4];
                vec3d3 = avec3d[5];
            } else if (j22 == 3) {
                vec3d = avec3d[2];
                vec3d1 = avec3d[1];
                vec3d2 = avec3d[5];
                vec3d3 = avec3d[6];
            } else if (j22 == 4) {
                vec3d = avec3d[3];
                vec3d1 = avec3d[2];
                vec3d2 = avec3d[6];
                vec3d3 = avec3d[7];
            } else if (j22 == 5) {
                vec3d = avec3d[0];
                vec3d1 = avec3d[3];
                vec3d2 = avec3d[7];
                vec3d3 = avec3d[4];
            }
            tessellator.addVertexWithUV(vec3d.xCoord, vec3d.yCoord, vec3d.zCoord, f4, f7);
            tessellator.addVertexWithUV(vec3d1.xCoord, vec3d1.yCoord, vec3d1.zCoord, f5, f7);
            tessellator.addVertexWithUV(vec3d2.xCoord, vec3d2.yCoord, vec3d2.zCoord, f5, f6);
            tessellator.addVertexWithUV(vec3d3.xCoord, vec3d3.yCoord, vec3d3.zCoord, f4, f6);
        }
        return true;
    }

    public boolean renderBlockFire(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        int l2 = block.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            l2 = this.overrideBlockTexture;
        }
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        tessellator.setColorOpaque_F(f2, f2, f2);
        int i1 = (l2 & 0xF) << 4;
        int j1 = l2 & 0xF0;
        double d2 = (float)i1 / 256.0f;
        double d22 = ((float)i1 + 15.99f) / 256.0f;
        double d4 = (float)j1 / 256.0f;
        double d6 = ((float)j1 + 15.99f) / 256.0f;
        float f1 = 1.4f;
        if (this.blockAccess.isBlockOpaqueCube(i2, j2 - 1, k2) || Block.fire.canBlockCatchFire(this.blockAccess, i2, j2 - 1, k2)) {
            double d8 = (double)i2 + 0.5 + 0.2;
            double d9 = (double)i2 + 0.5 - 0.2;
            double d12 = (double)k2 + 0.5 + 0.2;
            double d14 = (double)k2 + 0.5 - 0.2;
            double d16 = (double)i2 + 0.5 - 0.3;
            double d18 = (double)i2 + 0.5 + 0.3;
            double d20 = (double)k2 + 0.5 - 0.3;
            double d222 = (double)k2 + 0.5 + 0.3;
            tessellator.addVertexWithUV(d16, (float)j2 + f1, k2 + 1, d22, d4);
            tessellator.addVertexWithUV(d8, j2 + 0, k2 + 1, d22, d6);
            tessellator.addVertexWithUV(d8, j2 + 0, k2 + 0, d2, d6);
            tessellator.addVertexWithUV(d16, (float)j2 + f1, k2 + 0, d2, d4);
            tessellator.addVertexWithUV(d18, (float)j2 + f1, k2 + 0, d22, d4);
            tessellator.addVertexWithUV(d9, j2 + 0, k2 + 0, d22, d6);
            tessellator.addVertexWithUV(d9, j2 + 0, k2 + 1, d2, d6);
            tessellator.addVertexWithUV(d18, (float)j2 + f1, k2 + 1, d2, d4);
            d2 = (float)i1 / 256.0f;
            d22 = ((float)i1 + 15.99f) / 256.0f;
            d4 = (float)(j1 + 16) / 256.0f;
            d6 = ((float)j1 + 15.99f + 16.0f) / 256.0f;
            tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1, d222, d22, d4);
            tessellator.addVertexWithUV(i2 + 1, j2 + 0, d14, d22, d6);
            tessellator.addVertexWithUV(i2 + 0, j2 + 0, d14, d2, d6);
            tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1, d222, d2, d4);
            tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1, d20, d22, d4);
            tessellator.addVertexWithUV(i2 + 0, j2 + 0, d12, d22, d6);
            tessellator.addVertexWithUV(i2 + 1, j2 + 0, d12, d2, d6);
            tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1, d20, d2, d4);
            d8 = (double)i2 + 0.5 - 0.5;
            d9 = (double)i2 + 0.5 + 0.5;
            d12 = (double)k2 + 0.5 - 0.5;
            d14 = (double)k2 + 0.5 + 0.5;
            d16 = (double)i2 + 0.5 - 0.4;
            d18 = (double)i2 + 0.5 + 0.4;
            d20 = (double)k2 + 0.5 - 0.4;
            d222 = (double)k2 + 0.5 + 0.4;
            tessellator.addVertexWithUV(d16, (float)j2 + f1, k2 + 0, d2, d4);
            tessellator.addVertexWithUV(d8, j2 + 0, k2 + 0, d2, d6);
            tessellator.addVertexWithUV(d8, j2 + 0, k2 + 1, d22, d6);
            tessellator.addVertexWithUV(d16, (float)j2 + f1, k2 + 1, d22, d4);
            tessellator.addVertexWithUV(d18, (float)j2 + f1, k2 + 1, d2, d4);
            tessellator.addVertexWithUV(d9, j2 + 0, k2 + 1, d2, d6);
            tessellator.addVertexWithUV(d9, j2 + 0, k2 + 0, d22, d6);
            tessellator.addVertexWithUV(d18, (float)j2 + f1, k2 + 0, d22, d4);
            d2 = (float)i1 / 256.0f;
            d22 = ((float)i1 + 15.99f) / 256.0f;
            d4 = (float)j1 / 256.0f;
            d6 = ((float)j1 + 15.99f) / 256.0f;
            tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1, d222, d2, d4);
            tessellator.addVertexWithUV(i2 + 0, j2 + 0, d14, d2, d6);
            tessellator.addVertexWithUV(i2 + 1, j2 + 0, d14, d22, d6);
            tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1, d222, d22, d4);
            tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1, d20, d2, d4);
            tessellator.addVertexWithUV(i2 + 1, j2 + 0, d12, d2, d6);
            tessellator.addVertexWithUV(i2 + 0, j2 + 0, d12, d22, d6);
            tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1, d20, d22, d4);
        } else {
            float f3 = 0.2f;
            float f4 = 0.0625f;
            if ((i2 + j2 + k2 & 1) == 1) {
                d2 = (float)i1 / 256.0f;
                d22 = ((float)i1 + 15.99f) / 256.0f;
                d4 = (float)(j1 + 16) / 256.0f;
                d6 = ((float)j1 + 15.99f + 16.0f) / 256.0f;
            }
            if ((i2 / 2 + j2 / 2 + k2 / 2 & 1) == 1) {
                double d10 = d22;
                d22 = d2;
                d2 = d10;
            }
            if (Block.fire.canBlockCatchFire(this.blockAccess, i2 - 1, j2, k2)) {
                tessellator.addVertexWithUV((float)i2 + f3, (float)j2 + f1 + f4, k2 + 1, d22, d4);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 1, d22, d6);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 0, d2, d6);
                tessellator.addVertexWithUV((float)i2 + f3, (float)j2 + f1 + f4, k2 + 0, d2, d4);
                tessellator.addVertexWithUV((float)i2 + f3, (float)j2 + f1 + f4, k2 + 0, d2, d4);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 0, d2, d6);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 1, d22, d6);
                tessellator.addVertexWithUV((float)i2 + f3, (float)j2 + f1 + f4, k2 + 1, d22, d4);
            }
            if (Block.fire.canBlockCatchFire(this.blockAccess, i2 + 1, j2, k2)) {
                tessellator.addVertexWithUV((float)(i2 + 1) - f3, (float)j2 + f1 + f4, k2 + 0, d2, d4);
                tessellator.addVertexWithUV(i2 + 1 - 0, (float)(j2 + 0) + f4, k2 + 0, d2, d6);
                tessellator.addVertexWithUV(i2 + 1 - 0, (float)(j2 + 0) + f4, k2 + 1, d22, d6);
                tessellator.addVertexWithUV((float)(i2 + 1) - f3, (float)j2 + f1 + f4, k2 + 1, d22, d4);
                tessellator.addVertexWithUV((float)(i2 + 1) - f3, (float)j2 + f1 + f4, k2 + 1, d22, d4);
                tessellator.addVertexWithUV(i2 + 1 - 0, (float)(j2 + 0) + f4, k2 + 1, d22, d6);
                tessellator.addVertexWithUV(i2 + 1 - 0, (float)(j2 + 0) + f4, k2 + 0, d2, d6);
                tessellator.addVertexWithUV((float)(i2 + 1) - f3, (float)j2 + f1 + f4, k2 + 0, d2, d4);
            }
            if (Block.fire.canBlockCatchFire(this.blockAccess, i2, j2, k2 - 1)) {
                tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1 + f4, (float)k2 + f3, d22, d4);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 0, d22, d6);
                tessellator.addVertexWithUV(i2 + 1, (float)(j2 + 0) + f4, k2 + 0, d2, d6);
                tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1 + f4, (float)k2 + f3, d2, d4);
                tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1 + f4, (float)k2 + f3, d2, d4);
                tessellator.addVertexWithUV(i2 + 1, (float)(j2 + 0) + f4, k2 + 0, d2, d6);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 0, d22, d6);
                tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1 + f4, (float)k2 + f3, d22, d4);
            }
            if (Block.fire.canBlockCatchFire(this.blockAccess, i2, j2, k2 + 1)) {
                tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1 + f4, (float)(k2 + 1) - f3, d2, d4);
                tessellator.addVertexWithUV(i2 + 1, (float)(j2 + 0) + f4, k2 + 1 - 0, d2, d6);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 1 - 0, d22, d6);
                tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1 + f4, (float)(k2 + 1) - f3, d22, d4);
                tessellator.addVertexWithUV(i2 + 0, (float)j2 + f1 + f4, (float)(k2 + 1) - f3, d22, d4);
                tessellator.addVertexWithUV(i2 + 0, (float)(j2 + 0) + f4, k2 + 1 - 0, d22, d6);
                tessellator.addVertexWithUV(i2 + 1, (float)(j2 + 0) + f4, k2 + 1 - 0, d2, d6);
                tessellator.addVertexWithUV(i2 + 1, (float)j2 + f1 + f4, (float)(k2 + 1) - f3, d2, d4);
            }
            if (Block.fire.canBlockCatchFire(this.blockAccess, i2, j2 + 1, k2)) {
                double d11 = (double)i2 + 0.5 + 0.5;
                double d13 = (double)i2 + 0.5 - 0.5;
                double d15 = (double)k2 + 0.5 + 0.5;
                double d17 = (double)k2 + 0.5 - 0.5;
                double d19 = (double)i2 + 0.5 - 0.5;
                double d21 = (double)i2 + 0.5 + 0.5;
                double d23 = (double)k2 + 0.5 - 0.5;
                double d24 = (double)k2 + 0.5 + 0.5;
                double d1 = (float)i1 / 256.0f;
                double d3 = ((float)i1 + 15.99f) / 256.0f;
                double d5 = (float)j1 / 256.0f;
                double d7 = ((float)j1 + 15.99f) / 256.0f;
                float f22 = -0.2f;
                if ((i2 + ++j2 + k2 & 1) == 0) {
                    tessellator.addVertexWithUV(d19, (float)j2 + f22, k2 + 0, d3, d5);
                    tessellator.addVertexWithUV(d11, j2 + 0, k2 + 0, d3, d7);
                    tessellator.addVertexWithUV(d11, j2 + 0, k2 + 1, d1, d7);
                    tessellator.addVertexWithUV(d19, (float)j2 + f22, k2 + 1, d1, d5);
                    d1 = (float)i1 / 256.0f;
                    d3 = ((float)i1 + 15.99f) / 256.0f;
                    d5 = (float)(j1 + 16) / 256.0f;
                    d7 = ((float)j1 + 15.99f + 16.0f) / 256.0f;
                    tessellator.addVertexWithUV(d21, (float)j2 + f22, k2 + 1, d3, d5);
                    tessellator.addVertexWithUV(d13, j2 + 0, k2 + 1, d3, d7);
                    tessellator.addVertexWithUV(d13, j2 + 0, k2 + 0, d1, d7);
                    tessellator.addVertexWithUV(d21, (float)j2 + f22, k2 + 0, d1, d5);
                } else {
                    tessellator.addVertexWithUV(i2 + 0, (float)j2 + f22, d24, d3, d5);
                    tessellator.addVertexWithUV(i2 + 0, j2 + 0, d17, d3, d7);
                    tessellator.addVertexWithUV(i2 + 1, j2 + 0, d17, d1, d7);
                    tessellator.addVertexWithUV(i2 + 1, (float)j2 + f22, d24, d1, d5);
                    d1 = (float)i1 / 256.0f;
                    d3 = ((float)i1 + 15.99f) / 256.0f;
                    d5 = (float)(j1 + 16) / 256.0f;
                    d7 = ((float)j1 + 15.99f + 16.0f) / 256.0f;
                    tessellator.addVertexWithUV(i2 + 1, (float)j2 + f22, d23, d3, d5);
                    tessellator.addVertexWithUV(i2 + 1, j2 + 0, d15, d3, d7);
                    tessellator.addVertexWithUV(i2 + 0, j2 + 0, d15, d1, d7);
                    tessellator.addVertexWithUV(i2 + 0, (float)j2 + f22, d23, d1, d5);
                }
            }
        }
        return true;
    }

    public boolean renderBlockRedstoneWire(Block block, int i2, int j2, int k2) {
        boolean flag3;
        Tessellator tessellator = Tessellator.instance;
        int l2 = block.getBlockTextureFromSideAndMetadata(1, this.blockAccess.getBlockMetadata(i2, j2, k2));
        if (this.overrideBlockTexture >= 0) {
            l2 = this.overrideBlockTexture;
        }
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        tessellator.setColorOpaque_F(f2, f2, f2);
        int i1 = (l2 & 0xF) << 4;
        int j1 = l2 & 0xF0;
        double d2 = (float)i1 / 256.0f;
        double d1 = ((float)i1 + 15.99f) / 256.0f;
        double d22 = (float)j1 / 256.0f;
        double d3 = ((float)j1 + 15.99f) / 256.0f;
        float f1 = 0.0f;
        float f22 = 0.03125f;
        boolean flag = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2 - 1, j2, k2) || !this.blockAccess.isBlockOpaqueCube(i2 - 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2 - 1, j2 - 1, k2);
        boolean flag1 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2 + 1, j2, k2) || !this.blockAccess.isBlockOpaqueCube(i2 + 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2 + 1, j2 - 1, k2);
        boolean flag2 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2, j2, k2 - 1) || !this.blockAccess.isBlockOpaqueCube(i2, j2, k2 - 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2, j2 - 1, k2 - 1);
        boolean bl2 = flag3 = BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2, j2, k2 + 1) || !this.blockAccess.isBlockOpaqueCube(i2, j2, k2 + 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2, j2 - 1, k2 + 1);
        if (!this.blockAccess.isBlockOpaqueCube(i2, j2 + 1, k2)) {
            if (this.blockAccess.isBlockOpaqueCube(i2 - 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2 - 1, j2 + 1, k2)) {
                flag = true;
            }
            if (this.blockAccess.isBlockOpaqueCube(i2 + 1, j2, k2) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2 + 1, j2 + 1, k2)) {
                flag1 = true;
            }
            if (this.blockAccess.isBlockOpaqueCube(i2, j2, k2 - 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2, j2 + 1, k2 - 1)) {
                flag2 = true;
            }
            if (this.blockAccess.isBlockOpaqueCube(i2, j2, k2 + 1) && BlockRedstoneWire.isPowerProviderOrWire(this.blockAccess, i2, j2 + 1, k2 + 1)) {
                flag3 = true;
            }
        }
        float f3 = 0.3125f;
        float f4 = i2 + 0;
        float f5 = i2 + 1;
        float f6 = k2 + 0;
        float f7 = k2 + 1;
        int byte0 = 0;
        if ((flag || flag1) && !flag2 && !flag3) {
            byte0 = 1;
        }
        if ((flag2 || flag3) && !flag1 && !flag) {
            byte0 = 2;
        }
        if (byte0 != 0) {
            d2 = (float)(i1 + 16) / 256.0f;
            d1 = ((float)(i1 + 16) + 15.99f) / 256.0f;
            d22 = (float)j1 / 256.0f;
            d3 = ((float)j1 + 15.99f) / 256.0f;
        }
        if (byte0 == 0) {
            if (flag1 || flag2 || flag3 || flag) {
                if (!flag) {
                    f4 += f3;
                }
                if (!flag) {
                    d2 += (double)(f3 / 16.0f);
                }
                if (!flag1) {
                    f5 -= f3;
                }
                if (!flag1) {
                    d1 -= (double)(f3 / 16.0f);
                }
                if (!flag2) {
                    f6 += f3;
                }
                if (!flag2) {
                    d22 += (double)(f3 / 16.0f);
                }
                if (!flag3) {
                    f7 -= f3;
                }
                if (!flag3) {
                    d3 -= (double)(f3 / 16.0f);
                }
            }
            tessellator.addVertexWithUV(f5 + f1, (float)j2 + f22, f7 + f1, d1, d3);
            tessellator.addVertexWithUV(f5 + f1, (float)j2 + f22, f6 - f1, d1, d22);
            tessellator.addVertexWithUV(f4 - f1, (float)j2 + f22, f6 - f1, d2, d22);
            tessellator.addVertexWithUV(f4 - f1, (float)j2 + f22, f7 + f1, d2, d3);
        }
        if (byte0 == 1) {
            tessellator.addVertexWithUV(f5 + f1, (float)j2 + f22, f7 + f1, d1, d3);
            tessellator.addVertexWithUV(f5 + f1, (float)j2 + f22, f6 - f1, d1, d22);
            tessellator.addVertexWithUV(f4 - f1, (float)j2 + f22, f6 - f1, d2, d22);
            tessellator.addVertexWithUV(f4 - f1, (float)j2 + f22, f7 + f1, d2, d3);
        }
        if (byte0 == 2) {
            tessellator.addVertexWithUV(f5 + f1, (float)j2 + f22, f7 + f1, d1, d3);
            tessellator.addVertexWithUV(f5 + f1, (float)j2 + f22, f6 - f1, d2, d3);
            tessellator.addVertexWithUV(f4 - f1, (float)j2 + f22, f6 - f1, d2, d22);
            tessellator.addVertexWithUV(f4 - f1, (float)j2 + f22, f7 + f1, d1, d22);
        }
        d2 = (float)(i1 + 16) / 256.0f;
        d1 = ((float)(i1 + 16) + 15.99f) / 256.0f;
        d22 = (float)j1 / 256.0f;
        d3 = ((float)j1 + 15.99f) / 256.0f;
        if (!this.blockAccess.isBlockOpaqueCube(i2, j2 + 1, k2)) {
            if (this.blockAccess.isBlockOpaqueCube(i2 - 1, j2, k2) && this.blockAccess.getBlockId(i2 - 1, j2 + 1, k2) == Block.redstoneWire.blockID) {
                tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 1) + f1, (float)(k2 + 1) + f1, d1, d22);
                tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 0) - f1, (float)(k2 + 1) + f1, d2, d22);
                tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 0) - f1, (float)(k2 + 0) - f1, d2, d3);
                tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 1) + f1, (float)(k2 + 0) - f1, d1, d3);
            }
            if (this.blockAccess.isBlockOpaqueCube(i2 + 1, j2, k2) && this.blockAccess.getBlockId(i2 + 1, j2 + 1, k2) == Block.redstoneWire.blockID) {
                tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 0) - f1, (float)(k2 + 1) + f1, d2, d3);
                tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 1) + f1, (float)(k2 + 1) + f1, d1, d3);
                tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 1) + f1, (float)(k2 + 0) - f1, d1, d22);
                tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 0) - f1, (float)(k2 + 0) - f1, d2, d22);
            }
            if (this.blockAccess.isBlockOpaqueCube(i2, j2, k2 - 1) && this.blockAccess.getBlockId(i2, j2 + 1, k2 - 1) == Block.redstoneWire.blockID) {
                tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 0) - f1, (float)k2 + f22, d2, d3);
                tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 1) + f1, (float)k2 + f22, d1, d3);
                tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 1) + f1, (float)k2 + f22, d1, d22);
                tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 0) - f1, (float)k2 + f22, d2, d22);
            }
            if (this.blockAccess.isBlockOpaqueCube(i2, j2, k2 + 1) && this.blockAccess.getBlockId(i2, j2 + 1, k2 + 1) == Block.redstoneWire.blockID) {
                tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 1) + f1, (float)(k2 + 1) - f22, d1, d22);
                tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 0) - f1, (float)(k2 + 1) - f22, d2, d22);
                tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 0) - f1, (float)(k2 + 1) - f22, d2, d3);
                tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 1) + f1, (float)(k2 + 1) - f22, d1, d3);
            }
        }
        return true;
    }

    public boolean renderBlockMinecartTrack(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        int l2 = this.blockAccess.getBlockMetadata(i2, j2, k2);
        int i1 = block.getBlockTextureFromSideAndMetadata(0, l2);
        if (this.overrideBlockTexture >= 0) {
            i1 = this.overrideBlockTexture;
        }
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        tessellator.setColorOpaque_F(f2, f2, f2);
        int j1 = (i1 & 0xF) << 4;
        int k1 = i1 & 0xF0;
        double d2 = (float)j1 / 256.0f;
        double d1 = ((float)j1 + 15.99f) / 256.0f;
        double d22 = (float)k1 / 256.0f;
        double d3 = ((float)k1 + 15.99f) / 256.0f;
        float f1 = 0.0625f;
        float f22 = i2 + 1;
        float f3 = i2 + 1;
        float f4 = i2 + 0;
        float f5 = i2 + 0;
        float f6 = k2 + 0;
        float f7 = k2 + 1;
        float f8 = k2 + 1;
        float f9 = k2 + 0;
        float f10 = (float)j2 + f1;
        float f11 = (float)j2 + f1;
        float f12 = (float)j2 + f1;
        float f13 = (float)j2 + f1;
        if (l2 == 1 || l2 == 2 || l2 == 3 || l2 == 7) {
            f22 = f5 = (float)(i2 + 1);
            f3 = f4 = (float)(i2 + 0);
            f6 = f7 = (float)(k2 + 1);
            f8 = f9 = (float)(k2 + 0);
        } else if (l2 == 8) {
            f22 = f3 = (float)(i2 + 0);
            f4 = f5 = (float)(i2 + 1);
            f6 = f9 = (float)(k2 + 1);
            f7 = f8 = (float)(k2 + 0);
        } else if (l2 == 9) {
            f22 = f5 = (float)(i2 + 0);
            f3 = f4 = (float)(i2 + 1);
            f6 = f7 = (float)(k2 + 0);
            f8 = f9 = (float)(k2 + 1);
        }
        if (l2 == 2 || l2 == 4) {
            f10 += 1.0f;
            f13 += 1.0f;
        } else if (l2 == 3 || l2 == 5) {
            f11 += 1.0f;
            f12 += 1.0f;
        }
        tessellator.addVertexWithUV(f22, f10, f6, d1, d22);
        tessellator.addVertexWithUV(f3, f11, f7, d1, d3);
        tessellator.addVertexWithUV(f4, f12, f8, d2, d3);
        tessellator.addVertexWithUV(f5, f13, f9, d2, d22);
        tessellator.addVertexWithUV(f5, f13, f9, d2, d22);
        tessellator.addVertexWithUV(f4, f12, f8, d2, d3);
        tessellator.addVertexWithUV(f3, f11, f7, d1, d3);
        tessellator.addVertexWithUV(f22, f10, f6, d1, d22);
        return true;
    }

    public boolean renderBlockLadder(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        int l2 = block.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            l2 = this.overrideBlockTexture;
        }
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        tessellator.setColorOpaque_F(f2, f2, f2);
        int i1 = (l2 & 0xF) << 4;
        int j1 = l2 & 0xF0;
        double d2 = (float)i1 / 256.0f;
        double d1 = ((float)i1 + 15.99f) / 256.0f;
        double d22 = (float)j1 / 256.0f;
        double d3 = ((float)j1 + 15.99f) / 256.0f;
        int k1 = this.blockAccess.getBlockMetadata(i2, j2, k2);
        float f1 = 0.0f;
        float f22 = 0.05f;
        if (k1 == 5) {
            tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 1) + f1, (float)(k2 + 1) + f1, d2, d22);
            tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 0) - f1, (float)(k2 + 1) + f1, d2, d3);
            tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 0) - f1, (float)(k2 + 0) - f1, d1, d3);
            tessellator.addVertexWithUV((float)i2 + f22, (float)(j2 + 1) + f1, (float)(k2 + 0) - f1, d1, d22);
        }
        if (k1 == 4) {
            tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 0) - f1, (float)(k2 + 1) + f1, d1, d3);
            tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 1) + f1, (float)(k2 + 1) + f1, d1, d22);
            tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 1) + f1, (float)(k2 + 0) - f1, d2, d22);
            tessellator.addVertexWithUV((float)(i2 + 1) - f22, (float)(j2 + 0) - f1, (float)(k2 + 0) - f1, d2, d3);
        }
        if (k1 == 3) {
            tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 0) - f1, (float)k2 + f22, d1, d3);
            tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 1) + f1, (float)k2 + f22, d1, d22);
            tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 1) + f1, (float)k2 + f22, d2, d22);
            tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 0) - f1, (float)k2 + f22, d2, d3);
        }
        if (k1 == 2) {
            tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 1) + f1, (float)(k2 + 1) - f22, d2, d22);
            tessellator.addVertexWithUV((float)(i2 + 1) + f1, (float)(j2 + 0) - f1, (float)(k2 + 1) - f22, d2, d3);
            tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 0) - f1, (float)(k2 + 1) - f22, d1, d3);
            tessellator.addVertexWithUV((float)(i2 + 0) - f1, (float)(j2 + 1) + f1, (float)(k2 + 1) - f22, d1, d22);
        }
        return true;
    }

    public boolean renderBlockReed(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        tessellator.setColorOpaque_F(f2, f2, f2);
        this.func_1239_a(block, this.blockAccess.getBlockMetadata(i2, j2, k2), i2, j2, k2);
        return true;
    }

    public boolean renderBlockCrops(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        float f2 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        tessellator.setColorOpaque_F(f2, f2, f2);
        this.func_1245_b(block, this.blockAccess.getBlockMetadata(i2, j2, k2), i2, (float)j2 - 0.0625f, k2);
        return true;
    }

    public void renderTorchAtAngle(Block block, double d2, double d1, double d22, double d3, double d4) {
        Tessellator tessellator = Tessellator.instance;
        int i2 = block.getBlockTextureFromSide(0);
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        float f2 = (float)j2 / 256.0f;
        float f1 = ((float)j2 + 15.99f) / 256.0f;
        float f22 = (float)k2 / 256.0f;
        float f3 = ((float)k2 + 15.99f) / 256.0f;
        double d5 = (double)f2 + 0.02734375;
        double d6 = (double)f22 + 0.0234375;
        double d7 = (double)f2 + 0.03515625;
        double d8 = (double)f22 + 0.03125;
        double d9 = (d2 += 0.5) - 0.5;
        double d10 = d2 + 0.5;
        double d11 = (d22 += 0.5) - 0.5;
        double d12 = d22 + 0.5;
        double d13 = 0.0625;
        double d14 = 0.625;
        tessellator.addVertexWithUV(d2 + d3 * (1.0 - d14) - d13, d1 + d14, d22 + d4 * (1.0 - d14) - d13, d5, d6);
        tessellator.addVertexWithUV(d2 + d3 * (1.0 - d14) - d13, d1 + d14, d22 + d4 * (1.0 - d14) + d13, d5, d8);
        tessellator.addVertexWithUV(d2 + d3 * (1.0 - d14) + d13, d1 + d14, d22 + d4 * (1.0 - d14) + d13, d7, d8);
        tessellator.addVertexWithUV(d2 + d3 * (1.0 - d14) + d13, d1 + d14, d22 + d4 * (1.0 - d14) - d13, d7, d6);
        tessellator.addVertexWithUV(d2 - d13, d1 + 1.0, d11, f2, f22);
        tessellator.addVertexWithUV(d2 - d13 + d3, d1 + 0.0, d11 + d4, f2, f3);
        tessellator.addVertexWithUV(d2 - d13 + d3, d1 + 0.0, d12 + d4, f1, f3);
        tessellator.addVertexWithUV(d2 - d13, d1 + 1.0, d12, f1, f22);
        tessellator.addVertexWithUV(d2 + d13, d1 + 1.0, d12, f2, f22);
        tessellator.addVertexWithUV(d2 + d3 + d13, d1 + 0.0, d12 + d4, f2, f3);
        tessellator.addVertexWithUV(d2 + d3 + d13, d1 + 0.0, d11 + d4, f1, f3);
        tessellator.addVertexWithUV(d2 + d13, d1 + 1.0, d11, f1, f22);
        tessellator.addVertexWithUV(d9, d1 + 1.0, d22 + d13, f2, f22);
        tessellator.addVertexWithUV(d9 + d3, d1 + 0.0, d22 + d13 + d4, f2, f3);
        tessellator.addVertexWithUV(d10 + d3, d1 + 0.0, d22 + d13 + d4, f1, f3);
        tessellator.addVertexWithUV(d10, d1 + 1.0, d22 + d13, f1, f22);
        tessellator.addVertexWithUV(d10, d1 + 1.0, d22 - d13, f2, f22);
        tessellator.addVertexWithUV(d10 + d3, d1 + 0.0, d22 - d13 + d4, f2, f3);
        tessellator.addVertexWithUV(d9 + d3, d1 + 0.0, d22 - d13 + d4, f1, f3);
        tessellator.addVertexWithUV(d9, d1 + 1.0, d22 - d13, f1, f22);
    }

    public void func_1239_a(Block block, int i2, double d2, double d1, double d22) {
        Tessellator tessellator = Tessellator.instance;
        int j2 = block.getBlockTextureFromSideAndMetadata(0, i2);
        if (this.overrideBlockTexture >= 0) {
            j2 = this.overrideBlockTexture;
        }
        int k2 = (j2 & 0xF) << 4;
        int l2 = j2 & 0xF0;
        double d3 = (float)k2 / 256.0f;
        double d4 = ((float)k2 + 15.99f) / 256.0f;
        double d5 = (float)l2 / 256.0f;
        double d6 = ((float)l2 + 15.99f) / 256.0f;
        double d7 = d2 + 0.5 - (double)0.45f;
        double d8 = d2 + 0.5 + (double)0.45f;
        double d9 = d22 + 0.5 - (double)0.45f;
        double d10 = d22 + 0.5 + (double)0.45f;
        tessellator.addVertexWithUV(d7, d1 + 1.0, d9, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d9, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d10, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d10, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d9, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d9, d4, d5);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d10, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d9, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d9, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d9, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d10, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d10, d4, d5);
    }

    public void func_1245_b(Block block, int i2, double d2, double d1, double d22) {
        Tessellator tessellator = Tessellator.instance;
        int j2 = block.getBlockTextureFromSideAndMetadata(0, i2);
        if (this.overrideBlockTexture >= 0) {
            j2 = this.overrideBlockTexture;
        }
        int k2 = (j2 & 0xF) << 4;
        int l2 = j2 & 0xF0;
        double d3 = (float)k2 / 256.0f;
        double d4 = ((float)k2 + 15.99f) / 256.0f;
        double d5 = (float)l2 / 256.0f;
        double d6 = ((float)l2 + 15.99f) / 256.0f;
        double d7 = d2 + 0.5 - 0.25;
        double d8 = d2 + 0.5 + 0.25;
        double d9 = d22 + 0.5 - 0.5;
        double d10 = d22 + 0.5 + 0.5;
        tessellator.addVertexWithUV(d7, d1 + 1.0, d9, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d9, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d10, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d10, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d9, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d10, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d9, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d9, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d9, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d10, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d10, d4, d5);
        d7 = d2 + 0.5 - 0.5;
        d8 = d2 + 0.5 + 0.5;
        d9 = d22 + 0.5 - 0.25;
        d10 = d22 + 0.5 + 0.25;
        tessellator.addVertexWithUV(d7, d1 + 1.0, d9, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d9, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d9, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d9, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d9, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d9, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d9, d4, d5);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d10, d3, d6);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d10, d4, d6);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d10, d4, d5);
        tessellator.addVertexWithUV(d7, d1 + 1.0, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d1 + 0.0, d10, d3, d6);
        tessellator.addVertexWithUV(d8, d1 + 0.0, d10, d4, d6);
        tessellator.addVertexWithUV(d8, d1 + 1.0, d10, d4, d5);
    }

    public boolean renderBlockFluids(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        boolean flag = block.shouldSideBeRendered(this.blockAccess, i2, j2 + 1, k2, 1);
        boolean flag1 = block.shouldSideBeRendered(this.blockAccess, i2, j2 - 1, k2, 0);
        boolean[] aflag = new boolean[]{block.shouldSideBeRendered(this.blockAccess, i2, j2, k2 - 1, 2), block.shouldSideBeRendered(this.blockAccess, i2, j2, k2 + 1, 3), block.shouldSideBeRendered(this.blockAccess, i2 - 1, j2, k2, 4), block.shouldSideBeRendered(this.blockAccess, i2 + 1, j2, k2, 5)};
        if (!(flag || flag1 || aflag[0] || aflag[1] || aflag[2] || aflag[3])) {
            return false;
        }
        boolean flag2 = false;
        float f2 = 0.5f;
        float f1 = 1.0f;
        float f22 = 0.8f;
        float f3 = 0.6f;
        double d2 = 0.0;
        double d1 = 1.0;
        Material material = block.blockMaterial;
        int l2 = this.blockAccess.getBlockMetadata(i2, j2, k2);
        float f4 = this.func_1224_a(i2, j2, k2, material);
        float f5 = this.func_1224_a(i2, j2, k2 + 1, material);
        float f6 = this.func_1224_a(i2 + 1, j2, k2 + 1, material);
        float f7 = this.func_1224_a(i2 + 1, j2, k2, material);
        if (this.renderAllFaces || flag) {
            flag2 = true;
            int i1 = block.getBlockTextureFromSideAndMetadata(1, l2);
            float f9 = (float)BlockFluids.func_293_a(this.blockAccess, i2, j2, k2, material);
            if (f9 > -999.0f) {
                i1 = block.getBlockTextureFromSideAndMetadata(2, l2);
            }
            int l1 = (i1 & 0xF) << 4;
            int j22 = i1 & 0xF0;
            double d22 = ((double)l1 + 8.0) / 256.0;
            double d3 = ((double)j22 + 8.0) / 256.0;
            if (f9 < -999.0f) {
                f9 = 0.0f;
            } else {
                d22 = (float)(l1 + 16) / 256.0f;
                d3 = (float)(j22 + 16) / 256.0f;
            }
            float f11 = MathHelper.sin(f9) * 8.0f / 256.0f;
            float f13 = MathHelper.cos(f9) * 8.0f / 256.0f;
            float f15 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
            tessellator.setColorOpaque_F(f1 * f15, f1 * f15, f1 * f15);
            tessellator.addVertexWithUV(i2 + 0, (float)j2 + f4, k2 + 0, d22 - (double)f13 - (double)f11, d3 - (double)f13 + (double)f11);
            tessellator.addVertexWithUV(i2 + 0, (float)j2 + f5, k2 + 1, d22 - (double)f13 + (double)f11, d3 + (double)f13 + (double)f11);
            tessellator.addVertexWithUV(i2 + 1, (float)j2 + f6, k2 + 1, d22 + (double)f13 + (double)f11, d3 + (double)f13 - (double)f11);
            tessellator.addVertexWithUV(i2 + 1, (float)j2 + f7, k2 + 0, d22 + (double)f13 - (double)f11, d3 - (double)f13 - (double)f11);
        }
        if (this.renderAllFaces || flag1) {
            float f8 = block.getBlockBrightness(this.blockAccess, i2, j2 - 1, k2);
            tessellator.setColorOpaque_F(f2 * f8, f2 * f8, f2 * f8);
            this.renderBottomFace(block, i2, j2, k2, block.getBlockTextureFromSide(0));
            flag2 = true;
        }
        for (int j1 = 0; j1 < 4; ++j1) {
            float f18;
            float f16;
            float f17;
            float f14;
            float f12;
            float f10;
            int k1 = i2;
            int i22 = j2;
            int k22 = k2;
            if (j1 == 0) {
                --k22;
            }
            if (j1 == 1) {
                ++k22;
            }
            if (j1 == 2) {
                --k1;
            }
            if (j1 == 3) {
                ++k1;
            }
            int l22 = block.getBlockTextureFromSideAndMetadata(j1 + 2, l2);
            int i3 = (l22 & 0xF) << 4;
            int j3 = l22 & 0xF0;
            if (!this.renderAllFaces && !aflag[j1]) continue;
            if (j1 == 0) {
                f10 = f4;
                f12 = f7;
                f14 = i2;
                f17 = i2 + 1;
                f16 = k2;
                f18 = k2;
            } else if (j1 == 1) {
                f10 = f6;
                f12 = f5;
                f14 = i2 + 1;
                f17 = i2;
                f16 = k2 + 1;
                f18 = k2 + 1;
            } else if (j1 == 2) {
                f10 = f5;
                f12 = f4;
                f14 = i2;
                f17 = i2;
                f16 = k2 + 1;
                f18 = k2;
            } else {
                f10 = f7;
                f12 = f6;
                f14 = i2 + 1;
                f17 = i2 + 1;
                f16 = k2;
                f18 = k2 + 1;
            }
            flag2 = true;
            double d4 = (float)(i3 + 0) / 256.0f;
            double d5 = ((double)(i3 + 16) - 0.01) / 256.0;
            double d6 = ((float)j3 + (1.0f - f10) * 16.0f) / 256.0f;
            double d7 = ((float)j3 + (1.0f - f12) * 16.0f) / 256.0f;
            double d8 = ((double)(j3 + 16) - 0.01) / 256.0;
            float f19 = block.getBlockBrightness(this.blockAccess, k1, i22, k22);
            f19 = j1 < 2 ? (f19 *= f22) : (f19 *= f3);
            tessellator.setColorOpaque_F(f1 * f19, f1 * f19, f1 * f19);
            tessellator.addVertexWithUV(f14, (float)j2 + f10, f16, d4, d6);
            tessellator.addVertexWithUV(f17, (float)j2 + f12, f18, d5, d7);
            tessellator.addVertexWithUV(f17, j2 + 0, f18, d5, d8);
            tessellator.addVertexWithUV(f14, j2 + 0, f16, d4, d8);
        }
        block.minY = d2;
        block.maxY = d1;
        return flag2;
    }

    private float func_1224_a(int i2, int j2, int k2, Material material) {
        int l2 = 0;
        float f2 = 0.0f;
        for (int i1 = 0; i1 < 4; ++i1) {
            int j1 = i2 - (i1 & 1);
            int k1 = j2;
            int l1 = k2 - (i1 >> 1 & 1);
            if (this.blockAccess.getBlockMaterial(j1, k1 + 1, l1) == material) {
                return 1.0f;
            }
            Material material1 = this.blockAccess.getBlockMaterial(j1, k1, l1);
            if (material1 == material) {
                int i22 = this.blockAccess.getBlockMetadata(j1, k1, l1);
                if (i22 >= 8 || i22 == 0) {
                    f2 += BlockFluids.func_288_b(i22) * 10.0f;
                    l2 += 10;
                }
                f2 += BlockFluids.func_288_b(i22);
                ++l2;
                continue;
            }
            if (material1.func_878_a()) continue;
            f2 += 1.0f;
            ++l2;
        }
        return 1.0f - f2 / (float)l2;
    }

    public void func_1243_a(Block block, World world, int i2, int j2, int k2) {
        float f2 = 0.5f;
        float f1 = 1.0f;
        float f22 = 0.8f;
        float f3 = 0.6f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        float f4 = block.getBlockBrightness(world, i2, j2, k2);
        float f5 = block.getBlockBrightness(world, i2, j2 - 1, k2);
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.setColorOpaque_F(f2 * f5, f2 * f5, f2 * f5);
        this.renderBottomFace(block, -0.5, -0.5, -0.5, block.getBlockTextureFromSide(0));
        f5 = block.getBlockBrightness(world, i2, j2 + 1, k2);
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.setColorOpaque_F(f1 * f5, f1 * f5, f1 * f5);
        this.renderTopFace(block, -0.5, -0.5, -0.5, block.getBlockTextureFromSide(1));
        f5 = block.getBlockBrightness(world, i2, j2, k2 - 1);
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.setColorOpaque_F(f22 * f5, f22 * f5, f22 * f5);
        this.renderEastFace(block, -0.5, -0.5, -0.5, block.getBlockTextureFromSide(2));
        f5 = block.getBlockBrightness(world, i2, j2, k2 + 1);
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.setColorOpaque_F(f22 * f5, f22 * f5, f22 * f5);
        this.renderWestFace(block, -0.5, -0.5, -0.5, block.getBlockTextureFromSide(3));
        f5 = block.getBlockBrightness(world, i2 - 1, j2, k2);
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.setColorOpaque_F(f3 * f5, f3 * f5, f3 * f5);
        this.renderNorthFace(block, -0.5, -0.5, -0.5, block.getBlockTextureFromSide(4));
        f5 = block.getBlockBrightness(world, i2 + 1, j2, k2);
        if (f5 < f4) {
            f5 = f4;
        }
        tessellator.setColorOpaque_F(f3 * f5, f3 * f5, f3 * f5);
        this.renderSouthFace(block, -0.5, -0.5, -0.5, block.getBlockTextureFromSide(5));
        tessellator.draw();
    }

    public boolean renderStandardBlock(Block block, int i2, int j2, int k2) {
        int l2 = block.colorMultiplier(this.blockAccess, i2, j2, k2);
        float f2 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f22 = (float)(l2 & 0xFF) / 255.0f;
        return this.renderStandardBlockWithColorMultiplier(block, i2, j2, k2, f2, f1, f22);
    }

    public boolean renderStandardBlockWithColorMultiplier(Block block, int i2, int j2, int k2, float f2, float f1, float f22) {
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5f;
        float f4 = 1.0f;
        float f5 = 0.8f;
        float f6 = 0.6f;
        float f7 = f4 * f2;
        float f8 = f4 * f1;
        float f9 = f4 * f22;
        if (block == Block.grass) {
            f22 = 1.0f;
            f1 = 1.0f;
            f2 = 1.0f;
        }
        float f10 = f3 * f2;
        float f11 = f5 * f2;
        float f12 = f6 * f2;
        float f13 = f3 * f1;
        float f14 = f5 * f1;
        float f15 = f6 * f1;
        float f16 = f3 * f22;
        float f17 = f5 * f22;
        float f18 = f6 * f22;
        float f19 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2 - 1, k2, 0)) {
            float f20 = block.getBlockBrightness(this.blockAccess, i2, j2 - 1, k2);
            tessellator.setColorOpaque_F(f10 * f20, f13 * f20, f16 * f20);
            this.renderBottomFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 0));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2 + 1, k2, 1)) {
            float f21 = block.getBlockBrightness(this.blockAccess, i2, j2 + 1, k2);
            if (block.maxY != 1.0 && !block.blockMaterial.getIsLiquid()) {
                f21 = f19;
            }
            tessellator.setColorOpaque_F(f7 * f21, f8 * f21, f9 * f21);
            this.renderTopFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 1));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2, k2 - 1, 2)) {
            float f222 = block.getBlockBrightness(this.blockAccess, i2, j2, k2 - 1);
            if (block.minZ > 0.0) {
                f222 = f19;
            }
            tessellator.setColorOpaque_F(f11 * f222, f14 * f222, f17 * f222);
            this.renderEastFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 2));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2, k2 + 1, 3)) {
            float f23 = block.getBlockBrightness(this.blockAccess, i2, j2, k2 + 1);
            if (block.maxZ < 1.0) {
                f23 = f19;
            }
            tessellator.setColorOpaque_F(f11 * f23, f14 * f23, f17 * f23);
            this.renderWestFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 3));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2 - 1, j2, k2, 4)) {
            float f24 = block.getBlockBrightness(this.blockAccess, i2 - 1, j2, k2);
            if (block.minX > 0.0) {
                f24 = f19;
            }
            tessellator.setColorOpaque_F(f12 * f24, f15 * f24, f18 * f24);
            this.renderNorthFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 4));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2 + 1, j2, k2, 5)) {
            float f25 = block.getBlockBrightness(this.blockAccess, i2 + 1, j2, k2);
            if (block.maxX < 1.0) {
                f25 = f19;
            }
            tessellator.setColorOpaque_F(f12 * f25, f15 * f25, f18 * f25);
            this.renderSouthFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 5));
            flag = true;
        }
        return flag;
    }

    public boolean renderBlockCactus(Block block, int i2, int j2, int k2) {
        int l2 = block.colorMultiplier(this.blockAccess, i2, j2, k2);
        float f2 = (float)(l2 >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(l2 >> 8 & 0xFF) / 255.0f;
        float f22 = (float)(l2 & 0xFF) / 255.0f;
        return this.func_1230_b(block, i2, j2, k2, f2, f1, f22);
    }

    public boolean func_1230_b(Block block, int i2, int j2, int k2, float f2, float f1, float f22) {
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5f;
        float f4 = 1.0f;
        float f5 = 0.8f;
        float f6 = 0.6f;
        float f7 = f3 * f2;
        float f8 = f4 * f2;
        float f9 = f5 * f2;
        float f10 = f6 * f2;
        float f11 = f3 * f1;
        float f12 = f4 * f1;
        float f13 = f5 * f1;
        float f14 = f6 * f1;
        float f15 = f3 * f22;
        float f16 = f4 * f22;
        float f17 = f5 * f22;
        float f18 = f6 * f22;
        float f19 = 0.0625f;
        float f20 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2 - 1, k2, 0)) {
            float f21 = block.getBlockBrightness(this.blockAccess, i2, j2 - 1, k2);
            tessellator.setColorOpaque_F(f7 * f21, f11 * f21, f15 * f21);
            this.renderBottomFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 0));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2 + 1, k2, 1)) {
            float f222 = block.getBlockBrightness(this.blockAccess, i2, j2 + 1, k2);
            if (block.maxY != 1.0 && !block.blockMaterial.getIsLiquid()) {
                f222 = f20;
            }
            tessellator.setColorOpaque_F(f8 * f222, f12 * f222, f16 * f222);
            this.renderTopFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 1));
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2, k2 - 1, 2)) {
            float f23 = block.getBlockBrightness(this.blockAccess, i2, j2, k2 - 1);
            if (block.minZ > 0.0) {
                f23 = f20;
            }
            tessellator.setColorOpaque_F(f9 * f23, f13 * f23, f17 * f23);
            tessellator.setTranslationF(0.0f, 0.0f, f19);
            this.renderEastFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 2));
            tessellator.setTranslationF(0.0f, 0.0f, -f19);
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2, j2, k2 + 1, 3)) {
            float f24 = block.getBlockBrightness(this.blockAccess, i2, j2, k2 + 1);
            if (block.maxZ < 1.0) {
                f24 = f20;
            }
            tessellator.setColorOpaque_F(f9 * f24, f13 * f24, f17 * f24);
            tessellator.setTranslationF(0.0f, 0.0f, -f19);
            this.renderWestFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 3));
            tessellator.setTranslationF(0.0f, 0.0f, f19);
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2 - 1, j2, k2, 4)) {
            float f25 = block.getBlockBrightness(this.blockAccess, i2 - 1, j2, k2);
            if (block.minX > 0.0) {
                f25 = f20;
            }
            tessellator.setColorOpaque_F(f10 * f25, f14 * f25, f18 * f25);
            tessellator.setTranslationF(f19, 0.0f, 0.0f);
            this.renderNorthFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 4));
            tessellator.setTranslationF(-f19, 0.0f, 0.0f);
            flag = true;
        }
        if (this.renderAllFaces || block.shouldSideBeRendered(this.blockAccess, i2 + 1, j2, k2, 5)) {
            float f26 = block.getBlockBrightness(this.blockAccess, i2 + 1, j2, k2);
            if (block.maxX < 1.0) {
                f26 = f20;
            }
            tessellator.setColorOpaque_F(f10 * f26, f14 * f26, f18 * f26);
            tessellator.setTranslationF(-f19, 0.0f, 0.0f);
            this.renderSouthFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 5));
            tessellator.setTranslationF(f19, 0.0f, 0.0f);
            flag = true;
        }
        return flag;
    }

    public boolean renderBlockFence(Block block, int i2, int j2, int k2) {
        float f7;
        boolean flag6;
        boolean flag = false;
        float f2 = 0.375f;
        float f1 = 0.625f;
        block.setBlockBounds(f2, 0.0f, f2, f1, 1.0f, f1);
        this.renderStandardBlock(block, i2, j2, k2);
        boolean flag1 = false;
        boolean flag2 = false;
        if (this.blockAccess.getBlockId(i2 - 1, j2, k2) == block.blockID || this.blockAccess.getBlockId(i2 + 1, j2, k2) == block.blockID) {
            flag1 = true;
        }
        if (this.blockAccess.getBlockId(i2, j2, k2 - 1) == block.blockID || this.blockAccess.getBlockId(i2, j2, k2 + 1) == block.blockID) {
            flag2 = true;
        }
        boolean flag3 = this.blockAccess.getBlockId(i2 - 1, j2, k2) == block.blockID;
        boolean flag4 = this.blockAccess.getBlockId(i2 + 1, j2, k2) == block.blockID;
        boolean flag5 = this.blockAccess.getBlockId(i2, j2, k2 - 1) == block.blockID;
        boolean bl2 = flag6 = this.blockAccess.getBlockId(i2, j2, k2 + 1) == block.blockID;
        if (!flag1 && !flag2) {
            flag1 = true;
        }
        f2 = 0.4375f;
        f1 = 0.5625f;
        float f22 = 0.75f;
        float f3 = 0.9375f;
        float f4 = flag3 ? 0.0f : f2;
        float f5 = flag4 ? 1.0f : f1;
        float f6 = flag5 ? 0.0f : f2;
        float f8 = f7 = flag6 ? 1.0f : f1;
        if (flag1) {
            block.setBlockBounds(f4, f22, f2, f5, f3, f1);
            this.renderStandardBlock(block, i2, j2, k2);
        }
        if (flag2) {
            block.setBlockBounds(f2, f22, f6, f1, f3, f7);
            this.renderStandardBlock(block, i2, j2, k2);
        }
        f22 = 0.375f;
        f3 = 0.5625f;
        if (flag1) {
            block.setBlockBounds(f4, f22, f2, f5, f3, f1);
            this.renderStandardBlock(block, i2, j2, k2);
        }
        if (flag2) {
            block.setBlockBounds(f2, f22, f6, f1, f3, f7);
            this.renderStandardBlock(block, i2, j2, k2);
        }
        block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return flag;
    }

    public boolean renderBlockStairs(Block block, int i2, int j2, int k2) {
        boolean flag = false;
        int l2 = this.blockAccess.getBlockMetadata(i2, j2, k2);
        if (l2 == 0) {
            block.setBlockBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
            this.renderStandardBlock(block, i2, j2, k2);
            block.setBlockBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            this.renderStandardBlock(block, i2, j2, k2);
        } else if (l2 == 1) {
            block.setBlockBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            this.renderStandardBlock(block, i2, j2, k2);
            block.setBlockBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
            this.renderStandardBlock(block, i2, j2, k2);
        } else if (l2 == 2) {
            block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
            this.renderStandardBlock(block, i2, j2, k2);
            block.setBlockBounds(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            this.renderStandardBlock(block, i2, j2, k2);
        } else if (l2 == 3) {
            block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            this.renderStandardBlock(block, i2, j2, k2);
            block.setBlockBounds(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
            this.renderStandardBlock(block, i2, j2, k2);
        }
        block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return flag;
    }

    public boolean renderBlockDoor(Block block, int i2, int j2, int k2) {
        Tessellator tessellator = Tessellator.instance;
        BlockDoor blockdoor = (BlockDoor)block;
        boolean flag = false;
        float f2 = 0.5f;
        float f1 = 1.0f;
        float f22 = 0.8f;
        float f3 = 0.6f;
        float f4 = block.getBlockBrightness(this.blockAccess, i2, j2, k2);
        float f5 = block.getBlockBrightness(this.blockAccess, i2, j2 - 1, k2);
        if (blockdoor.minY > 0.0) {
            f5 = f4;
        }
        if (Block.lightValue[block.blockID] > 0) {
            f5 = 1.0f;
        }
        tessellator.setColorOpaque_F(f2 * f5, f2 * f5, f2 * f5);
        this.renderBottomFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 0));
        flag = true;
        f5 = block.getBlockBrightness(this.blockAccess, i2, j2 + 1, k2);
        if (blockdoor.maxY < 1.0) {
            f5 = f4;
        }
        if (Block.lightValue[block.blockID] > 0) {
            f5 = 1.0f;
        }
        tessellator.setColorOpaque_F(f1 * f5, f1 * f5, f1 * f5);
        this.renderTopFace(block, i2, j2, k2, block.getBlockTexture(this.blockAccess, i2, j2, k2, 1));
        flag = true;
        f5 = block.getBlockBrightness(this.blockAccess, i2, j2, k2 - 1);
        if (blockdoor.minZ > 0.0) {
            f5 = f4;
        }
        if (Block.lightValue[block.blockID] > 0) {
            f5 = 1.0f;
        }
        tessellator.setColorOpaque_F(f22 * f5, f22 * f5, f22 * f5);
        int l2 = block.getBlockTexture(this.blockAccess, i2, j2, k2, 2);
        if (l2 < 0) {
            this.flipTexture = true;
            l2 = -l2;
        }
        this.renderEastFace(block, i2, j2, k2, l2);
        flag = true;
        this.flipTexture = false;
        f5 = block.getBlockBrightness(this.blockAccess, i2, j2, k2 + 1);
        if (blockdoor.maxZ < 1.0) {
            f5 = f4;
        }
        if (Block.lightValue[block.blockID] > 0) {
            f5 = 1.0f;
        }
        tessellator.setColorOpaque_F(f22 * f5, f22 * f5, f22 * f5);
        l2 = block.getBlockTexture(this.blockAccess, i2, j2, k2, 3);
        if (l2 < 0) {
            this.flipTexture = true;
            l2 = -l2;
        }
        this.renderWestFace(block, i2, j2, k2, l2);
        flag = true;
        this.flipTexture = false;
        f5 = block.getBlockBrightness(this.blockAccess, i2 - 1, j2, k2);
        if (blockdoor.minX > 0.0) {
            f5 = f4;
        }
        if (Block.lightValue[block.blockID] > 0) {
            f5 = 1.0f;
        }
        tessellator.setColorOpaque_F(f3 * f5, f3 * f5, f3 * f5);
        l2 = block.getBlockTexture(this.blockAccess, i2, j2, k2, 4);
        if (l2 < 0) {
            this.flipTexture = true;
            l2 = -l2;
        }
        this.renderNorthFace(block, i2, j2, k2, l2);
        flag = true;
        this.flipTexture = false;
        f5 = block.getBlockBrightness(this.blockAccess, i2 + 1, j2, k2);
        if (blockdoor.maxX < 1.0) {
            f5 = f4;
        }
        if (Block.lightValue[block.blockID] > 0) {
            f5 = 1.0f;
        }
        tessellator.setColorOpaque_F(f3 * f5, f3 * f5, f3 * f5);
        l2 = block.getBlockTexture(this.blockAccess, i2, j2, k2, 5);
        if (l2 < 0) {
            this.flipTexture = true;
            l2 = -l2;
        }
        this.renderSouthFace(block, i2, j2, k2, l2);
        flag = true;
        this.flipTexture = false;
        return flag;
    }

    public void renderBottomFace(Block block, double d2, double d1, double d22, int i2) {
        Tessellator tessellator = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        double d3 = ((double)j2 + block.minX * 16.0) / 256.0;
        double d4 = ((double)j2 + block.maxX * 16.0 - 0.01) / 256.0;
        double d5 = ((double)k2 + block.minZ * 16.0) / 256.0;
        double d6 = ((double)k2 + block.maxZ * 16.0 - 0.01) / 256.0;
        if (block.minX < 0.0 || block.maxX > 1.0) {
            d3 = ((float)j2 + 0.0f) / 256.0f;
            d4 = ((float)j2 + 15.99f) / 256.0f;
        }
        if (block.minZ < 0.0 || block.maxZ > 1.0) {
            d5 = ((float)k2 + 0.0f) / 256.0f;
            d6 = ((float)k2 + 15.99f) / 256.0f;
        }
        double d7 = d2 + block.minX;
        double d8 = d2 + block.maxX;
        double d9 = d1 + block.minY;
        double d10 = d22 + block.minZ;
        double d11 = d22 + block.maxZ;
        tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
        tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
        tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
        tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
    }

    public void renderTopFace(Block block, double d2, double d1, double d22, int i2) {
        Tessellator tessellator = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        double d3 = ((double)j2 + block.minX * 16.0) / 256.0;
        double d4 = ((double)j2 + block.maxX * 16.0 - 0.01) / 256.0;
        double d5 = ((double)k2 + block.minZ * 16.0) / 256.0;
        double d6 = ((double)k2 + block.maxZ * 16.0 - 0.01) / 256.0;
        if (block.minX < 0.0 || block.maxX > 1.0) {
            d3 = ((float)j2 + 0.0f) / 256.0f;
            d4 = ((float)j2 + 15.99f) / 256.0f;
        }
        if (block.minZ < 0.0 || block.maxZ > 1.0) {
            d5 = ((float)k2 + 0.0f) / 256.0f;
            d6 = ((float)k2 + 15.99f) / 256.0f;
        }
        double d7 = d2 + block.minX;
        double d8 = d2 + block.maxX;
        double d9 = d1 + block.maxY;
        double d10 = d22 + block.minZ;
        double d11 = d22 + block.maxZ;
        tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
        tessellator.addVertexWithUV(d8, d9, d10, d4, d5);
        tessellator.addVertexWithUV(d7, d9, d10, d3, d5);
        tessellator.addVertexWithUV(d7, d9, d11, d3, d6);
    }

    public void renderEastFace(Block block, double d2, double d1, double d22, int i2) {
        Tessellator tessellator = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        double d3 = ((double)j2 + block.minX * 16.0) / 256.0;
        double d4 = ((double)j2 + block.maxX * 16.0 - 0.01) / 256.0;
        double d5 = ((double)k2 + block.minY * 16.0) / 256.0;
        double d6 = ((double)k2 + block.maxY * 16.0 - 0.01) / 256.0;
        if (this.flipTexture) {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (block.minX < 0.0 || block.maxX > 1.0) {
            d3 = ((float)j2 + 0.0f) / 256.0f;
            d4 = ((float)j2 + 15.99f) / 256.0f;
        }
        if (block.minY < 0.0 || block.maxY > 1.0) {
            d5 = ((float)k2 + 0.0f) / 256.0f;
            d6 = ((float)k2 + 15.99f) / 256.0f;
        }
        double d8 = d2 + block.minX;
        double d9 = d2 + block.maxX;
        double d10 = d1 + block.minY;
        double d11 = d1 + block.maxY;
        double d12 = d22 + block.minZ;
        tessellator.addVertexWithUV(d8, d11, d12, d4, d5);
        tessellator.addVertexWithUV(d9, d11, d12, d3, d5);
        tessellator.addVertexWithUV(d9, d10, d12, d3, d6);
        tessellator.addVertexWithUV(d8, d10, d12, d4, d6);
    }

    public void renderWestFace(Block block, double d2, double d1, double d22, int i2) {
        Tessellator tessellator = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        double d3 = ((double)j2 + block.minX * 16.0) / 256.0;
        double d4 = ((double)j2 + block.maxX * 16.0 - 0.01) / 256.0;
        double d5 = ((double)k2 + block.minY * 16.0) / 256.0;
        double d6 = ((double)k2 + block.maxY * 16.0 - 0.01) / 256.0;
        if (this.flipTexture) {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (block.minX < 0.0 || block.maxX > 1.0) {
            d3 = ((float)j2 + 0.0f) / 256.0f;
            d4 = ((float)j2 + 15.99f) / 256.0f;
        }
        if (block.minY < 0.0 || block.maxY > 1.0) {
            d5 = ((float)k2 + 0.0f) / 256.0f;
            d6 = ((float)k2 + 15.99f) / 256.0f;
        }
        double d8 = d2 + block.minX;
        double d9 = d2 + block.maxX;
        double d10 = d1 + block.minY;
        double d11 = d1 + block.maxY;
        double d12 = d22 + block.maxZ;
        tessellator.addVertexWithUV(d8, d11, d12, d3, d5);
        tessellator.addVertexWithUV(d8, d10, d12, d3, d6);
        tessellator.addVertexWithUV(d9, d10, d12, d4, d6);
        tessellator.addVertexWithUV(d9, d11, d12, d4, d5);
    }

    public void renderNorthFace(Block block, double d2, double d1, double d22, int i2) {
        Tessellator tessellator = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        double d3 = ((double)j2 + block.minZ * 16.0) / 256.0;
        double d4 = ((double)j2 + block.maxZ * 16.0 - 0.01) / 256.0;
        double d5 = ((double)k2 + block.minY * 16.0) / 256.0;
        double d6 = ((double)k2 + block.maxY * 16.0 - 0.01) / 256.0;
        if (this.flipTexture) {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (block.minZ < 0.0 || block.maxZ > 1.0) {
            d3 = ((float)j2 + 0.0f) / 256.0f;
            d4 = ((float)j2 + 15.99f) / 256.0f;
        }
        if (block.minY < 0.0 || block.maxY > 1.0) {
            d5 = ((float)k2 + 0.0f) / 256.0f;
            d6 = ((float)k2 + 15.99f) / 256.0f;
        }
        double d8 = d2 + block.minX;
        double d9 = d1 + block.minY;
        double d10 = d1 + block.maxY;
        double d11 = d22 + block.minZ;
        double d12 = d22 + block.maxZ;
        tessellator.addVertexWithUV(d8, d10, d12, d4, d5);
        tessellator.addVertexWithUV(d8, d10, d11, d3, d5);
        tessellator.addVertexWithUV(d8, d9, d11, d3, d6);
        tessellator.addVertexWithUV(d8, d9, d12, d4, d6);
    }

    public void renderSouthFace(Block block, double d2, double d1, double d22, int i2) {
        Tessellator tessellator = Tessellator.instance;
        if (this.overrideBlockTexture >= 0) {
            i2 = this.overrideBlockTexture;
        }
        int j2 = (i2 & 0xF) << 4;
        int k2 = i2 & 0xF0;
        double d3 = ((double)j2 + block.minZ * 16.0) / 256.0;
        double d4 = ((double)j2 + block.maxZ * 16.0 - 0.01) / 256.0;
        double d5 = ((double)k2 + block.minY * 16.0) / 256.0;
        double d6 = ((double)k2 + block.maxY * 16.0 - 0.01) / 256.0;
        if (this.flipTexture) {
            double d7 = d3;
            d3 = d4;
            d4 = d7;
        }
        if (block.minZ < 0.0 || block.maxZ > 1.0) {
            d3 = ((float)j2 + 0.0f) / 256.0f;
            d4 = ((float)j2 + 15.99f) / 256.0f;
        }
        if (block.minY < 0.0 || block.maxY > 1.0) {
            d5 = ((float)k2 + 0.0f) / 256.0f;
            d6 = ((float)k2 + 15.99f) / 256.0f;
        }
        double d8 = d2 + block.maxX;
        double d9 = d1 + block.minY;
        double d10 = d1 + block.maxY;
        double d11 = d22 + block.minZ;
        double d12 = d22 + block.maxZ;
        tessellator.addVertexWithUV(d8, d9, d12, d3, d6);
        tessellator.addVertexWithUV(d8, d9, d11, d4, d6);
        tessellator.addVertexWithUV(d8, d10, d11, d4, d5);
        tessellator.addVertexWithUV(d8, d10, d12, d3, d5);
    }

    public void func_1238_a(Block block, float f2) {
        int i2 = block.getRenderType();
        Tessellator tessellator = Tessellator.instance;
        if (i2 == 0) {
            block.func_237_e();
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            float f1 = 0.5f;
            float f22 = 1.0f;
            float f3 = 0.8f;
            float f4 = 0.6f;
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_F(f22, f22, f22, f2);
            this.renderBottomFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
            tessellator.setColorRGBA_F(f1, f1, f1, f2);
            this.renderTopFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
            tessellator.setColorRGBA_F(f3, f3, f3, f2);
            this.renderEastFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
            this.renderWestFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
            tessellator.setColorRGBA_F(f4, f4, f4, f2);
            this.renderNorthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
            this.renderSouthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
            tessellator.draw();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        }
    }

    public void func_1227_a(Block block) {
        int byte0 = -1;
        Tessellator tessellator = Tessellator.instance;
        int i2 = block.getRenderType();
        if (i2 == 0) {
            block.func_237_e();
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this.renderTopFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            this.renderEastFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            this.renderWestFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            this.renderNorthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            this.renderSouthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
            tessellator.draw();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        } else if (i2 == 1) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this.func_1239_a(block, byte0, -0.5, -0.5, -0.5);
            tessellator.draw();
        } else if (i2 == 13) {
            block.func_237_e();
            GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
            float f2 = 0.0625f;
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this.renderBottomFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            this.renderTopFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            tessellator.setTranslationF(0.0f, 0.0f, f2);
            this.renderEastFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
            tessellator.setTranslationF(0.0f, 0.0f, -f2);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            tessellator.setTranslationF(0.0f, 0.0f, -f2);
            this.renderWestFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
            tessellator.setTranslationF(0.0f, 0.0f, f2);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            tessellator.setTranslationF(f2, 0.0f, 0.0f);
            this.renderNorthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
            tessellator.setTranslationF(-f2, 0.0f, 0.0f);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            tessellator.setTranslationF(-f2, 0.0f, 0.0f);
            this.renderSouthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
            tessellator.setTranslationF(f2, 0.0f, 0.0f);
            tessellator.draw();
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
        } else if (i2 == 6) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this.func_1245_b(block, byte0, -0.5, -0.5, -0.5);
            tessellator.draw();
        } else if (i2 == 2) {
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            this.renderTorchAtAngle(block, -0.5, -0.5, -0.5, 0.0, 0.0);
            tessellator.draw();
        } else if (i2 == 10) {
            for (int j2 = 0; j2 < 2; ++j2) {
                if (j2 == 0) {
                    block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                }
                if (j2 == 1) {
                    block.setBlockBounds(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
                }
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                this.renderTopFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, -1.0f);
                this.renderEastFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, 1.0f);
                this.renderWestFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                this.renderNorthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0f, 0.0f, 0.0f);
                this.renderSouthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
                tessellator.draw();
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            }
        } else if (i2 == 11) {
            for (int k2 = 0; k2 < 4; ++k2) {
                float f1 = 0.125f;
                if (k2 == 0) {
                    block.setBlockBounds(0.5f - f1, 0.0f, 0.0f, 0.5f + f1, 1.0f, f1 * 2.0f);
                }
                if (k2 == 1) {
                    block.setBlockBounds(0.5f - f1, 0.0f, 1.0f - f1 * 2.0f, 0.5f + f1, 1.0f, 1.0f);
                }
                f1 = 0.0625f;
                if (k2 == 2) {
                    block.setBlockBounds(0.5f - f1, 1.0f - f1 * 3.0f, -f1 * 2.0f, 0.5f + f1, 1.0f - f1, 1.0f + f1 * 2.0f);
                }
                if (k2 == 3) {
                    block.setBlockBounds(0.5f - f1, 0.5f - f1 * 3.0f, -f1 * 2.0f, 0.5f + f1, 0.5f - f1, 1.0f + f1 * 2.0f);
                }
                GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, -1.0f, 0.0f);
                this.renderBottomFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 1.0f, 0.0f);
                this.renderTopFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, -1.0f);
                this.renderEastFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0.0f, 0.0f, 1.0f);
                this.renderWestFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                this.renderNorthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(1.0f, 0.0f, 0.0f);
                this.renderSouthFace(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
                tessellator.draw();
                GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            }
            block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    public static boolean func_1219_a(int i2) {
        if (i2 == 0) {
            return true;
        }
        if (i2 == 13) {
            return true;
        }
        if (i2 == 10) {
            return true;
        }
        return i2 == 11;
    }
}

