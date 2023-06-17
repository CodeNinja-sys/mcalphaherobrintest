/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemTool;
import net.minecraft.src.Material;

public class ItemPickaxe
extends ItemTool {
    private static Block[] blocksEffectiveAgainst = new Block[]{Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.blockIce, Block.bloodStone};
    private int field_328_aY;

    public ItemPickaxe(int i2, int j2) {
        super(i2, 2, j2, blocksEffectiveAgainst);
        this.field_328_aY = j2;
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        if (block == Block.obsidian) {
            return this.field_328_aY == 3;
        }
        if (block == Block.blockDiamond || block == Block.oreDiamond) {
            return this.field_328_aY >= 2;
        }
        if (block == Block.blockGold || block == Block.oreGold) {
            return this.field_328_aY >= 2;
        }
        if (block == Block.blockSteel || block == Block.oreIron) {
            return this.field_328_aY >= 1;
        }
        if (block == Block.oreRedstone || block == Block.oreRedstoneGlowing) {
            return this.field_328_aY >= 2;
        }
        if (block.blockMaterial == Material.rock) {
            return true;
        }
        return block.blockMaterial == Material.iron;
    }
}

