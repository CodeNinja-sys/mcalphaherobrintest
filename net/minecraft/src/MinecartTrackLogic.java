/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.BlockMinecartTrack;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.World;

class MinecartTrackLogic {
    private World worldObj;
    private int field_1165_c;
    private int field_1164_d;
    private int field_1163_e;
    private int field_1162_f;
    private List field_1161_g;
    final BlockMinecartTrack field_1160_a;

    public MinecartTrackLogic(BlockMinecartTrack blockminecarttrack, World world, int i2, int j2, int k2) {
        this.field_1160_a = blockminecarttrack;
        this.field_1161_g = new ArrayList();
        this.worldObj = world;
        this.field_1165_c = i2;
        this.field_1164_d = j2;
        this.field_1163_e = k2;
        this.field_1162_f = world.getBlockMetadata(i2, j2, k2);
        this.func_789_a();
    }

    private void func_789_a() {
        this.field_1161_g.clear();
        if (this.field_1162_f == 0) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (this.field_1162_f == 1) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
        } else if (this.field_1162_f == 2) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e));
        } else if (this.field_1162_f == 3) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
        } else if (this.field_1162_f == 4) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (this.field_1162_f == 5) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1));
        } else if (this.field_1162_f == 6) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (this.field_1162_f == 7) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1));
        } else if (this.field_1162_f == 8) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
        } else if (this.field_1162_f == 9) {
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e));
            this.field_1161_g.add(new ChunkPosition(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1));
        }
    }

    private void func_785_b() {
        for (int i2 = 0; i2 < this.field_1161_g.size(); ++i2) {
            MinecartTrackLogic minecarttracklogic = this.func_795_a((ChunkPosition)this.field_1161_g.get(i2));
            if (minecarttracklogic == null || !minecarttracklogic.func_793_b(this)) {
                this.field_1161_g.remove(i2--);
                continue;
            }
            this.field_1161_g.set(i2, new ChunkPosition(minecarttracklogic.field_1165_c, minecarttracklogic.field_1164_d, minecarttracklogic.field_1163_e));
        }
    }

    private boolean func_784_a(int i2, int j2, int k2) {
        if (this.worldObj.getBlockId(i2, j2, k2) == this.field_1160_a.blockID) {
            return true;
        }
        if (this.worldObj.getBlockId(i2, j2 + 1, k2) == this.field_1160_a.blockID) {
            return true;
        }
        return this.worldObj.getBlockId(i2, j2 - 1, k2) == this.field_1160_a.blockID;
    }

    private MinecartTrackLogic func_795_a(ChunkPosition chunkposition) {
        if (this.worldObj.getBlockId(chunkposition.x, chunkposition.y, chunkposition.z) == this.field_1160_a.blockID) {
            return new MinecartTrackLogic(this.field_1160_a, this.worldObj, chunkposition.x, chunkposition.y, chunkposition.z);
        }
        if (this.worldObj.getBlockId(chunkposition.x, chunkposition.y + 1, chunkposition.z) == this.field_1160_a.blockID) {
            return new MinecartTrackLogic(this.field_1160_a, this.worldObj, chunkposition.x, chunkposition.y + 1, chunkposition.z);
        }
        if (this.worldObj.getBlockId(chunkposition.x, chunkposition.y - 1, chunkposition.z) == this.field_1160_a.blockID) {
            return new MinecartTrackLogic(this.field_1160_a, this.worldObj, chunkposition.x, chunkposition.y - 1, chunkposition.z);
        }
        return null;
    }

    private boolean func_793_b(MinecartTrackLogic minecarttracklogic) {
        for (int i2 = 0; i2 < this.field_1161_g.size(); ++i2) {
            ChunkPosition chunkposition = (ChunkPosition)this.field_1161_g.get(i2);
            if (chunkposition.x != minecarttracklogic.field_1165_c || chunkposition.z != minecarttracklogic.field_1163_e) continue;
            return true;
        }
        return false;
    }

    private boolean func_794_b(int i2, int j2, int k2) {
        for (int l2 = 0; l2 < this.field_1161_g.size(); ++l2) {
            ChunkPosition chunkposition = (ChunkPosition)this.field_1161_g.get(l2);
            if (chunkposition.x != i2 || chunkposition.z != k2) continue;
            return true;
        }
        return false;
    }

    private int func_790_c() {
        int i2 = 0;
        if (this.func_784_a(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1)) {
            ++i2;
        }
        if (this.func_784_a(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1)) {
            ++i2;
        }
        if (this.func_784_a(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e)) {
            ++i2;
        }
        if (this.func_784_a(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e)) {
            ++i2;
        }
        return i2;
    }

    private boolean func_787_c(MinecartTrackLogic minecarttracklogic) {
        if (this.func_793_b(minecarttracklogic)) {
            return true;
        }
        if (this.field_1161_g.size() == 2) {
            return false;
        }
        if (this.field_1161_g.size() == 0) {
            return true;
        }
        ChunkPosition chunkposition = (ChunkPosition)this.field_1161_g.get(0);
        return minecarttracklogic.field_1164_d != this.field_1164_d || chunkposition.y != this.field_1164_d ? true : true;
    }

    private void func_788_d(MinecartTrackLogic minecarttracklogic) {
        this.field_1161_g.add(new ChunkPosition(minecarttracklogic.field_1165_c, minecarttracklogic.field_1164_d, minecarttracklogic.field_1163_e));
        boolean flag = this.func_794_b(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1);
        boolean flag1 = this.func_794_b(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1);
        boolean flag2 = this.func_794_b(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e);
        boolean flag3 = this.func_794_b(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e);
        int byte0 = -1;
        if (flag || flag1) {
            byte0 = 0;
        }
        if (flag2 || flag3) {
            byte0 = 1;
        }
        if (flag1 && flag3 && !flag && !flag2) {
            byte0 = 6;
        }
        if (flag1 && flag2 && !flag && !flag3) {
            byte0 = 7;
        }
        if (flag && flag2 && !flag1 && !flag3) {
            byte0 = 8;
        }
        if (flag && flag3 && !flag1 && !flag2) {
            byte0 = 9;
        }
        if (byte0 == 0) {
            if (this.worldObj.getBlockId(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1) == this.field_1160_a.blockID) {
                byte0 = 4;
            }
            if (this.worldObj.getBlockId(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1) == this.field_1160_a.blockID) {
                byte0 = 5;
            }
        }
        if (byte0 == 1) {
            if (this.worldObj.getBlockId(this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e) == this.field_1160_a.blockID) {
                byte0 = 2;
            }
            if (this.worldObj.getBlockId(this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e) == this.field_1160_a.blockID) {
                byte0 = 3;
            }
        }
        if (byte0 < 0) {
            byte0 = 0;
        }
        this.worldObj.setBlockMetadataWithNotify(this.field_1165_c, this.field_1164_d, this.field_1163_e, byte0);
    }

    private boolean func_786_c(int i2, int j2, int k2) {
        MinecartTrackLogic minecarttracklogic = this.func_795_a(new ChunkPosition(i2, j2, k2));
        if (minecarttracklogic == null) {
            return false;
        }
        minecarttracklogic.func_785_b();
        return minecarttracklogic.func_787_c(this);
    }

    public void func_792_a(boolean flag) {
        boolean flag1 = this.func_786_c(this.field_1165_c, this.field_1164_d, this.field_1163_e - 1);
        boolean flag2 = this.func_786_c(this.field_1165_c, this.field_1164_d, this.field_1163_e + 1);
        boolean flag3 = this.func_786_c(this.field_1165_c - 1, this.field_1164_d, this.field_1163_e);
        boolean flag4 = this.func_786_c(this.field_1165_c + 1, this.field_1164_d, this.field_1163_e);
        int i2 = -1;
        if ((flag1 || flag2) && !flag3 && !flag4) {
            i2 = 0;
        }
        if ((flag3 || flag4) && !flag1 && !flag2) {
            i2 = 1;
        }
        if (flag2 && flag4 && !flag1 && !flag3) {
            i2 = 6;
        }
        if (flag2 && flag3 && !flag1 && !flag4) {
            i2 = 7;
        }
        if (flag1 && flag3 && !flag2 && !flag4) {
            i2 = 8;
        }
        if (flag1 && flag4 && !flag2 && !flag3) {
            i2 = 9;
        }
        if (i2 == -1) {
            if (flag1 || flag2) {
                i2 = 0;
            }
            if (flag3 || flag4) {
                i2 = 1;
            }
            if (flag) {
                if (flag2 && flag4) {
                    i2 = 6;
                }
                if (flag3 && flag2) {
                    i2 = 7;
                }
                if (flag4 && flag1) {
                    i2 = 9;
                }
                if (flag1 && flag3) {
                    i2 = 8;
                }
            } else {
                if (flag1 && flag3) {
                    i2 = 8;
                }
                if (flag4 && flag1) {
                    i2 = 9;
                }
                if (flag3 && flag2) {
                    i2 = 7;
                }
                if (flag2 && flag4) {
                    i2 = 6;
                }
            }
        }
        if (i2 == 0) {
            if (this.worldObj.getBlockId(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e - 1) == this.field_1160_a.blockID) {
                i2 = 4;
            }
            if (this.worldObj.getBlockId(this.field_1165_c, this.field_1164_d + 1, this.field_1163_e + 1) == this.field_1160_a.blockID) {
                i2 = 5;
            }
        }
        if (i2 == 1) {
            if (this.worldObj.getBlockId(this.field_1165_c + 1, this.field_1164_d + 1, this.field_1163_e) == this.field_1160_a.blockID) {
                i2 = 2;
            }
            if (this.worldObj.getBlockId(this.field_1165_c - 1, this.field_1164_d + 1, this.field_1163_e) == this.field_1160_a.blockID) {
                i2 = 3;
            }
        }
        if (i2 < 0) {
            i2 = 0;
        }
        this.field_1162_f = i2;
        this.func_789_a();
        this.worldObj.setBlockMetadataWithNotify(this.field_1165_c, this.field_1164_d, this.field_1163_e, i2);
        for (int j2 = 0; j2 < this.field_1161_g.size(); ++j2) {
            MinecartTrackLogic minecarttracklogic = this.func_795_a((ChunkPosition)this.field_1161_g.get(j2));
            if (minecarttracklogic == null) continue;
            minecarttracklogic.func_785_b();
            if (!minecarttracklogic.func_787_c(this)) continue;
            minecarttracklogic.func_788_d(this);
        }
    }

    static int func_791_a(MinecartTrackLogic minecarttracklogic) {
        return minecarttracklogic.func_790_c();
    }
}

