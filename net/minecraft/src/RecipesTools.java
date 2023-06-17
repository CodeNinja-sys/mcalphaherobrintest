/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesTools {
    private String[][] field_1665_a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] field_1664_b = new Object[][]{{Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold}, {Item.pickaxeWood, Item.pickaxeStone, Item.pickaxeSteel, Item.pickaxeDiamond, Item.pickaxeGold}, {Item.shovelWood, Item.shovelStone, Item.shovelSteel, Item.shovelDiamond, Item.shovelGold}, {Item.axeWood, Item.axeStone, Item.axeSteel, Item.axeDiamond, Item.axeGold}, {Item.hoeWood, Item.hoeStone, Item.hoeSteel, Item.hoeDiamond, Item.hoeGold}};

    public void func_1122_a(CraftingManager craftingmanager) {
        for (int i2 = 0; i2 < this.field_1664_b[0].length; ++i2) {
            Object obj = this.field_1664_b[0][i2];
            for (int j2 = 0; j2 < this.field_1664_b.length - 1; ++j2) {
                Item item = (Item)this.field_1664_b[j2 + 1][i2];
                craftingmanager.addRecipe(new ItemStack(item), new Object[]{this.field_1665_a[j2], Character.valueOf('#'), Item.stick, Character.valueOf('X'), obj});
            }
        }
    }
}

