/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.CraftingRecipe;

class RecipeSorter
implements Comparator {
    final CraftingManager field_1557_a;

    RecipeSorter(CraftingManager craftingmanager) {
        this.field_1557_a = craftingmanager;
    }

    public int func_1040_a(CraftingRecipe craftingrecipe, CraftingRecipe craftingrecipe1) {
        if (craftingrecipe1.getRecipeSize() < craftingrecipe.getRecipeSize()) {
            return -1;
        }
        return craftingrecipe1.getRecipeSize() <= craftingrecipe.getRecipeSize() ? 0 : 1;
    }

    public int compare(Object obj, Object obj1) {
        return this.func_1040_a((CraftingRecipe)obj, (CraftingRecipe)obj1);
    }
}

