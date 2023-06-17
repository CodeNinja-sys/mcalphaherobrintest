/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.src.TexturePackBase;
import net.minecraft.src.TexturePackCustom;
import net.minecraft.src.TexturePackDefault;

public class TexturePackList {
    private List availableTexturePacks = new ArrayList();
    private TexturePackBase defaultTexturePack = new TexturePackDefault();
    public TexturePackBase selectedTexturePack;
    private Map field_6538_d = new HashMap();
    private Minecraft mc;
    private File texturePackDir;
    private String field_6535_g;

    public TexturePackList(Minecraft minecraft, File file) {
        this.mc = minecraft;
        this.texturePackDir = new File(file, "texturepacks");
        if (!this.texturePackDir.exists()) {
            this.texturePackDir.mkdirs();
        }
        this.field_6535_g = minecraft.gameSettings.skin;
        this.func_6532_a();
        this.selectedTexturePack.func_6482_a();
    }

    public boolean setTexturePack(TexturePackBase texturepackbase) {
        if (texturepackbase == this.selectedTexturePack) {
            return false;
        }
        this.selectedTexturePack.closeTexturePackFile();
        this.field_6535_g = texturepackbase.texturePackFileName;
        this.selectedTexturePack = texturepackbase;
        this.mc.gameSettings.skin = this.field_6535_g;
        this.mc.gameSettings.saveOptions();
        this.selectedTexturePack.func_6482_a();
        return true;
    }

    public void func_6532_a() {
        ArrayList<TexturePackBase> arraylist = new ArrayList<TexturePackBase>();
        this.selectedTexturePack = null;
        arraylist.add(this.defaultTexturePack);
        if (this.texturePackDir.exists() && this.texturePackDir.isDirectory()) {
            File[] afile;
            for (File file : afile = this.texturePackDir.listFiles()) {
                if (!file.isFile() || !file.getName().toLowerCase().endsWith(".zip")) continue;
                String s2 = file.getName() + ":" + file.length() + ":" + file.lastModified();
                try {
                    if (!this.field_6538_d.containsKey(s2)) {
                        TexturePackCustom texturepackcustom = new TexturePackCustom(file);
                        texturepackcustom.field_6488_d = s2;
                        this.field_6538_d.put(s2, texturepackcustom);
                        texturepackcustom.func_6485_a(this.mc);
                    }
                    TexturePackBase texturepackbase1 = (TexturePackBase)this.field_6538_d.get(s2);
                    if (texturepackbase1.texturePackFileName.equals(this.field_6535_g)) {
                        this.selectedTexturePack = texturepackbase1;
                    }
                    arraylist.add(texturepackbase1);
                }
                catch (IOException ioexception) {
                    ioexception.printStackTrace();
                }
            }
        }
        if (this.selectedTexturePack == null) {
            this.selectedTexturePack = this.defaultTexturePack;
        }
        this.availableTexturePacks.removeAll(arraylist);
        for (TexturePackBase texturepackbase : this.availableTexturePacks) {
            texturepackbase.func_6484_b(this.mc);
            this.field_6538_d.remove(texturepackbase.field_6488_d);
        }
        this.availableTexturePacks = arraylist;
    }

    public List availableTexturePacks() {
        return new ArrayList(this.availableTexturePacks);
    }
}

