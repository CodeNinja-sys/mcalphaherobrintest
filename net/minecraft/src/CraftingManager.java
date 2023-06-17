/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.CraftingRecipe;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.RecipeSorter;
import net.minecraft.src.RecipesArmor;
import net.minecraft.src.RecipesCrafting;
import net.minecraft.src.RecipesFood;
import net.minecraft.src.RecipesIngots;
import net.minecraft.src.RecipesTools;
import net.minecraft.src.RecipesWeapons;

public class CraftingManager {
    private static final CraftingManager instance = new CraftingManager();
    private List recipes = new ArrayList();

    public static final CraftingManager getInstance() {
        return instance;
    }

    private CraftingManager() {
        new RecipesTools().func_1122_a(this);
        new RecipesWeapons().func_766_a(this);
        new RecipesIngots().func_810_a(this);
        new RecipesFood().func_976_a(this);
        new RecipesCrafting().func_1051_a(this);
        new RecipesArmor().func_1148_a(this);
        this.addRecipe(new ItemStack(Item.paper, 3), new Object[]{"###", Character.valueOf('#'), Item.reed});
        this.addRecipe(new ItemStack(Item.book, 1), new Object[]{"#", "#", "#", Character.valueOf('#'), Item.paper});
        this.addRecipe(new ItemStack(Block.fence, 2), new Object[]{"###", "###", Character.valueOf('#'), Item.stick});
        this.addRecipe(new ItemStack(Block.jukebox, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.diamond});
        this.addRecipe(new ItemStack(Block.bookShelf, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.book});
        this.addRecipe(new ItemStack(Block.blockSnow, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.snowball});
        this.addRecipe(new ItemStack(Block.blockClay, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.clay});
        this.addRecipe(new ItemStack(Block.brick, 1), new Object[]{"##", "##", Character.valueOf('#'), Item.brick});
        this.addRecipe(new ItemStack(Block.lightStone, 1), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.lightStoneDust});
        this.addRecipe(new ItemStack(Block.cloth, 1), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.silk});
        this.addRecipe(new ItemStack(Block.tnt, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Item.gunpowder, Character.valueOf('#'), Block.sand});
        this.addRecipe(new ItemStack(Block.stairSingle, 3), new Object[]{"###", Character.valueOf('#'), Block.cobblestone});
        this.addRecipe(new ItemStack(Block.ladder, 1), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Item.stick});
        this.addRecipe(new ItemStack(Item.doorWood, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Block.planks});
        this.addRecipe(new ItemStack(Item.doorSteel, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Item.ingotIron});
        this.addRecipe(new ItemStack(Item.sign, 1), new Object[]{"###", "###", " X ", Character.valueOf('#'), Block.planks, Character.valueOf('X'), Item.stick});
        this.addRecipe(new ItemStack(Block.planks, 4), new Object[]{"#", Character.valueOf('#'), Block.wood});
        this.addRecipe(new ItemStack(Item.stick, 4), new Object[]{"#", "#", Character.valueOf('#'), Block.planks});
        this.addRecipe(new ItemStack(Block.torchWood, 4), new Object[]{"X", "#", Character.valueOf('X'), Item.coal, Character.valueOf('#'), Item.stick});
        this.addRecipe(new ItemStack(Item.bowlEmpty, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Block.planks});
        this.addRecipe(new ItemStack(Block.minecartTrack, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Item.ingotIron, Character.valueOf('#'), Item.stick});
        this.addRecipe(new ItemStack(Item.minecartEmpty, 1), new Object[]{"# #", "###", Character.valueOf('#'), Item.ingotIron});
        this.addRecipe(new ItemStack(Block.pumpkinLantern, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.pumpkin, Character.valueOf('B'), Block.torchWood});
        this.addRecipe(new ItemStack(Item.minecartCrate, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.crate, Character.valueOf('B'), Item.minecartEmpty});
        this.addRecipe(new ItemStack(Item.minecartPowered, 1), new Object[]{"A", "B", Character.valueOf('A'), Block.stoneOvenIdle, Character.valueOf('B'), Item.minecartEmpty});
        this.addRecipe(new ItemStack(Item.boat, 1), new Object[]{"# #", "###", Character.valueOf('#'), Block.planks});
        this.addRecipe(new ItemStack(Item.bucketEmpty, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Item.ingotIron});
        this.addRecipe(new ItemStack(Item.flintAndSteel, 1), new Object[]{"A ", " B", Character.valueOf('A'), Item.ingotIron, Character.valueOf('B'), Item.flint});
        this.addRecipe(new ItemStack(Item.bread, 1), new Object[]{"###", Character.valueOf('#'), Item.wheat});
        this.addRecipe(new ItemStack(Block.stairCompactPlanks, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.planks});
        this.addRecipe(new ItemStack(Item.fishingRod, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Item.silk});
        this.addRecipe(new ItemStack(Block.stairCompactCobblestone, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Block.cobblestone});
        this.addRecipe(new ItemStack(Item.painting, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Block.cloth});
        this.addRecipe(new ItemStack(Item.appleGold, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Block.blockGold, Character.valueOf('X'), Item.appleRed});
        this.addRecipe(new ItemStack(Block.lever, 1), new Object[]{"X", "#", Character.valueOf('#'), Block.cobblestone, Character.valueOf('X'), Item.stick});
        this.addRecipe(new ItemStack(Block.torchRedstoneActive, 1), new Object[]{"X", "#", Character.valueOf('#'), Item.stick, Character.valueOf('X'), Item.redstone});
        this.addRecipe(new ItemStack(Item.pocketSundial, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.ingotGold, Character.valueOf('X'), Item.redstone});
        this.addRecipe(new ItemStack(Item.compass, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Item.ingotIron, Character.valueOf('X'), Item.redstone});
        this.addRecipe(new ItemStack(Block.button, 1), new Object[]{"#", "#", Character.valueOf('#'), Block.stone});
        this.addRecipe(new ItemStack(Block.pressurePlateStone, 1), new Object[]{"###", Character.valueOf('#'), Block.stone});
        this.addRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[]{"###", Character.valueOf('#'), Block.planks});
        Collections.sort(this.recipes, new RecipeSorter(this));
        System.out.println(this.recipes.size() + " recipes");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    void addRecipe(ItemStack itemstack, Object[] aobj) {
        block7: {
            s = "";
            i = 0;
            j = 0;
            k = 0;
            if (!(aobj[i] instanceof String[])) ** GOTO lbl17
            as = (String[])aobj[i++];
            for (l = 0; l < as.length; ++k, ++l) {
                s2 = as[l];
                j = s2.length();
                s = s + s2;
            }
            break block7;
lbl-1000:
            // 1 sources

            {
                s1 = (String)aobj[i++];
                ++k;
                j = s1.length();
                s = s + s1;
lbl17:
                // 2 sources

                ** while (aobj[i] instanceof String)
            }
        }
        hashmap = new HashMap<Character, Integer>();
        while (i < aobj.length) {
            character = (Character)aobj[i];
            i1 = 0;
            if (aobj[i + 1] instanceof Item) {
                i1 = ((Item)aobj[i + 1]).shiftedIndex;
            } else if (aobj[i + 1] instanceof Block) {
                i1 = ((Block)aobj[i + 1]).blockID;
            }
            hashmap.put(character, i1);
            i += 2;
        }
        ai = new int[j * k];
        for (j1 = 0; j1 < j * k; ++j1) {
            c = s.charAt(j1);
            ai[j1] = hashmap.containsKey(Character.valueOf(c)) != false ? (Integer)hashmap.get(Character.valueOf(c)) : -1;
        }
        this.recipes.add(new CraftingRecipe(j, k, ai, itemstack));
    }

    public ItemStack craft(int[] ai2) {
        for (int i2 = 0; i2 < this.recipes.size(); ++i2) {
            CraftingRecipe craftingrecipe = (CraftingRecipe)this.recipes.get(i2);
            if (!craftingrecipe.matchRecipe(ai2)) continue;
            return craftingrecipe.createResult(ai2);
        }
        return null;
    }
}

