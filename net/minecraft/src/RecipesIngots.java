/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesIngots {
    private Object[][] field_1198_a = new Object[][]{{Block.blockGold, Item.ingotGold}, {Block.blockSteel, Item.ingotIron}, {Block.blockDiamond, Item.diamond}};

    public void func_810_a(CraftingManager craftingmanager) {
        for (int i2 = 0; i2 < this.field_1198_a.length; ++i2) {
            Block block = (Block)this.field_1198_a[i2][0];
            Item item = (Item)this.field_1198_a[i2][1];
            craftingmanager.addRecipe(new ItemStack(block), new Object[]{"###", "###", "###", Character.valueOf('#'), item});
            craftingmanager.addRecipe(new ItemStack(item, 9), new Object[]{"#", Character.valueOf('#'), block});
        }
    }
}

