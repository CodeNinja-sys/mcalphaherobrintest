/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesWeapons {
    private String[][] field_1100_a = new String[][]{{"X", "X", "#"}};
    private Object[][] field_1099_b = new Object[][]{{Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold}, {Item.swordWood, Item.swordStone, Item.swordSteel, Item.swordDiamond, Item.swordGold}};

    public void func_766_a(CraftingManager craftingmanager) {
        for (int i2 = 0; i2 < this.field_1099_b[0].length; ++i2) {
            Object obj = this.field_1099_b[0][i2];
            for (int j2 = 0; j2 < this.field_1099_b.length - 1; ++j2) {
                Item item = (Item)this.field_1099_b[j2 + 1][i2];
                craftingmanager.addRecipe(new ItemStack(item), new Object[]{this.field_1100_a[j2], Character.valueOf('#'), Item.stick, Character.valueOf('X'), obj});
            }
        }
        craftingmanager.addRecipe(new ItemStack(Item.bow, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Item.silk, Character.valueOf('#'), Item.stick});
        craftingmanager.addRecipe(new ItemStack(Item.arrow, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Item.feather, Character.valueOf('X'), Item.flint, Character.valueOf('#'), Item.stick});
    }
}

