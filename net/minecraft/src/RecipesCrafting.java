/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.ItemStack;

public class RecipesCrafting {
    public void func_1051_a(CraftingManager craftingmanager) {
        craftingmanager.addRecipe(new ItemStack(Block.crate), new Object[]{"###", "# #", "###", Character.valueOf('#'), Block.planks});
        craftingmanager.addRecipe(new ItemStack(Block.stoneOvenIdle), new Object[]{"###", "# #", "###", Character.valueOf('#'), Block.cobblestone});
        craftingmanager.addRecipe(new ItemStack(Block.workbench), new Object[]{"##", "##", Character.valueOf('#'), Block.planks});
    }
}

