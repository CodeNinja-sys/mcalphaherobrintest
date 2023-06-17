/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.SoundPoolEntry;

public class SoundPool {
    private Random rand = new Random();
    private Map nameToSoundPoolEntriesMapping = new HashMap();
    private List allSoundPoolEntries = new ArrayList();
    public int numberOfSoundPoolEntries = 0;
    public boolean field_1657_b = true;

    public SoundPoolEntry addSound(String s2, File file) {
        try {
            String s1 = s2;
            s2 = s2.substring(0, s2.indexOf("."));
            if (this.field_1657_b) {
                while (Character.isDigit(s2.charAt(s2.length() - 1))) {
                    s2 = s2.substring(0, s2.length() - 1);
                }
            }
            if (!this.nameToSoundPoolEntriesMapping.containsKey(s2 = s2.replaceAll("/", "."))) {
                this.nameToSoundPoolEntriesMapping.put(s2, new ArrayList());
            }
            SoundPoolEntry soundpoolentry = new SoundPoolEntry(s1, file.toURI().toURL());
            ((List)this.nameToSoundPoolEntriesMapping.get(s2)).add(soundpoolentry);
            this.allSoundPoolEntries.add(soundpoolentry);
            ++this.numberOfSoundPoolEntries;
            return soundpoolentry;
        }
        catch (MalformedURLException malformedurlexception) {
            malformedurlexception.printStackTrace();
            throw new RuntimeException(malformedurlexception);
        }
    }

    public SoundPoolEntry getRandomSoundFromSoundPool(String s2) {
        List list = (List)this.nameToSoundPoolEntriesMapping.get(s2);
        if (list == null) {
            return null;
        }
        return (SoundPoolEntry)list.get(this.rand.nextInt(list.size()));
    }

    public SoundPoolEntry getRandomSound() {
        if (this.allSoundPoolEntries.size() == 0) {
            return null;
        }
        return (SoundPoolEntry)this.allSoundPoolEntries.get(this.rand.nextInt(this.allSoundPoolEntries.size()));
    }
}

