/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class RecipesArmor {
    private String[][] field_1681_a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] field_1680_b = new Object[][]{{Item.leather, Block.fire, Item.ingotIron, Item.diamond, Item.ingotGold}, {Item.helmetLeather, Item.helmetChain, Item.helmetSteel, Item.helmetDiamond, Item.helmetGold}, {Item.plateLeather, Item.plateChain, Item.plateSteel, Item.plateDiamond, Item.plateGold}, {Item.legsLeather, Item.legsChain, Item.legsSteel, Item.legsDiamond, Item.legsGold}, {Item.bootsLeather, Item.bootsChain, Item.bootsSteel, Item.bootsDiamond, Item.bootsGold}};

    public void func_1148_a(CraftingManager craftingmanager) {
        for (int i2 = 0; i2 < this.field_1680_b[0].length; ++i2) {
            Object obj = this.field_1680_b[0][i2];
            for (int j2 = 0; j2 < this.field_1680_b.length - 1; ++j2) {
                Item item = (Item)this.field_1680_b[j2 + 1][i2];
                craftingmanager.addRecipe(new ItemStack(item), new Object[]{this.field_1681_a[j2], Character.valueOf('X'), obj});
            }
        }
    }
}

