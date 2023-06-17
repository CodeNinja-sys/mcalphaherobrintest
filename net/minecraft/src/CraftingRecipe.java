/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.ItemStack;

public class CraftingRecipe {
    private int width;
    private int height;
    private int[] ingredientMap;
    private ItemStack resultStack;
    public final int resultId;

    public CraftingRecipe(int i2, int j2, int[] ai2, ItemStack itemstack) {
        this.resultId = itemstack.itemID;
        this.width = i2;
        this.height = j2;
        this.ingredientMap = ai2;
        this.resultStack = itemstack;
    }

    public boolean matchRecipe(int[] ai2) {
        for (int i2 = 0; i2 <= 3 - this.width; ++i2) {
            for (int j2 = 0; j2 <= 3 - this.height; ++j2) {
                if (this.matches(ai2, i2, j2, true)) {
                    return true;
                }
                if (!this.matches(ai2, i2, j2, false)) continue;
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] ai2, int i2, int j2, boolean flag) {
        for (int k2 = 0; k2 < 3; ++k2) {
            for (int l2 = 0; l2 < 3; ++l2) {
                int i1 = k2 - i2;
                int j1 = l2 - j2;
                int k1 = -1;
                if (i1 >= 0 && j1 >= 0 && i1 < this.width && j1 < this.height) {
                    k1 = flag ? this.ingredientMap[this.width - i1 - 1 + j1 * this.width] : this.ingredientMap[i1 + j1 * this.width];
                }
                if (ai2[k2 + l2 * 3] == k1) continue;
                return false;
            }
        }
        return true;
    }

    public ItemStack createResult(int[] ai2) {
        return new ItemStack(this.resultStack.itemID, this.resultStack.stackSize);
    }

    public int getRecipeSize() {
        return this.width * this.height;
    }
}

