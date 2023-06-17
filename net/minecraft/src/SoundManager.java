/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import java.util.Random;
import net.minecraft.src.CodecMus;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.GameSettings;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SoundPool;
import net.minecraft.src.SoundPoolEntry;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager {
    private static SoundSystem sndSystem;
    private SoundPool soundPoolSounds = new SoundPool();
    private SoundPool soundPoolStreaming = new SoundPool();
    private SoundPool soundPoolMusic = new SoundPool();
    private int field_587_e = 0;
    private GameSettings options;
    private static boolean loaded;
    private Random rand = new Random();
    private int field_583_i = this.rand.nextInt(12000);

    static {
        loaded = false;
    }

    public void func_340_a(GameSettings gamesettings) {
        this.soundPoolStreaming.field_1657_b = false;
        this.options = gamesettings;
        if (!(loaded || gamesettings != null && gamesettings.soundVolume == 0.0f && gamesettings.musicVolume == 0.0f)) {
            this.tryToSetLibraryAndCodecs();
        }
    }

    private void tryToSetLibraryAndCodecs() {
        try {
            float f2 = this.options.soundVolume;
            float f1 = this.options.musicVolume;
            this.options.soundVolume = 0.0f;
            this.options.musicVolume = 0.0f;
            this.options.saveOptions();
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", CodecMus.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            sndSystem = new SoundSystem();
            this.options.soundVolume = f2;
            this.options.musicVolume = f1;
            this.options.saveOptions();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        loaded = true;
    }

    public void onSoundOptionsChanged() {
        if (!(loaded || this.options.soundVolume == 0.0f && this.options.musicVolume == 0.0f)) {
            this.tryToSetLibraryAndCodecs();
        }
        if (this.options.musicVolume == 0.0f) {
            sndSystem.stop("BgMusic");
        } else {
            sndSystem.setVolume("BgMusic", this.options.musicVolume);
        }
    }

    public void closeMinecraft() {
        if (loaded) {
            sndSystem.cleanup();
        }
    }

    public void func_6372_a(String s2, File file) {
        this.soundPoolSounds.addSound(s2, file);
    }

    public void addStreaming(String s2, File file) {
        this.soundPoolStreaming.addSound(s2, file);
    }

    public void addMusic(String s2, File file) {
        this.soundPoolMusic.addSound(s2, file);
    }

    public void func_4033_c() {
        if (!loaded || this.options.musicVolume == 0.0f) {
            return;
        }
        if (!sndSystem.playing("BgMusic") && !sndSystem.playing("streaming")) {
            if (this.field_583_i > 0) {
                --this.field_583_i;
                return;
            }
            SoundPoolEntry soundpoolentry = this.soundPoolMusic.getRandomSound();
            if (soundpoolentry != null) {
                this.field_583_i = this.rand.nextInt(12000) + 12000;
                sndSystem.backgroundMusic("BgMusic", soundpoolentry.soundUrl, soundpoolentry.soundName, false);
                sndSystem.setVolume("BgMusic", this.options.musicVolume);
                sndSystem.play("BgMusic");
            }
        }
    }

    public void func_338_a(EntityLiving entityliving, float f2) {
        if (!loaded || this.options.soundVolume == 0.0f) {
            return;
        }
        if (entityliving == null) {
            return;
        }
        float f1 = entityliving.prevRotationYaw + (entityliving.rotationYaw - entityliving.prevRotationYaw) * f2;
        double d2 = entityliving.prevPosX + (entityliving.posX - entityliving.prevPosX) * (double)f2;
        double d1 = entityliving.prevPosY + (entityliving.posY - entityliving.prevPosY) * (double)f2;
        double d22 = entityliving.prevPosZ + (entityliving.posZ - entityliving.prevPosZ) * (double)f2;
        float f22 = MathHelper.cos(-f1 * 0.01745329f - 3.141593f);
        float f3 = MathHelper.sin(-f1 * 0.01745329f - 3.141593f);
        float f4 = -f3;
        float f5 = 0.0f;
        float f6 = -f22;
        float f7 = 0.0f;
        float f8 = 1.0f;
        float f9 = 0.0f;
        sndSystem.setListenerPosition((float)d2, (float)d1, (float)d22);
        sndSystem.setListenerOrientation(f4, f5, f6, f7, f8, f9);
    }

    public void func_331_a(String s2, float f2, float f1, float f22, float f3, float f4) {
        if (!loaded || this.options.soundVolume == 0.0f) {
            return;
        }
        String s1 = "streaming";
        if (sndSystem.playing("streaming")) {
            sndSystem.stop("streaming");
        }
        if (s2 == null) {
            return;
        }
        SoundPoolEntry soundpoolentry = this.soundPoolStreaming.getRandomSoundFromSoundPool(s2);
        if (soundpoolentry != null && f3 > 0.0f) {
            if (sndSystem.playing("BgMusic")) {
                sndSystem.stop("BgMusic");
            }
            float f5 = 16.0f;
            sndSystem.newStreamingSource(true, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, f2, f1, f22, 2, f5 * 4.0f);
            sndSystem.setVolume(s1, 0.5f * this.options.soundVolume);
            sndSystem.play(s1);
        }
    }

    public void func_336_b(String s2, float f2, float f1, float f22, float f3, float f4) {
        if (!loaded || this.options.soundVolume == 0.0f) {
            return;
        }
        SoundPoolEntry soundpoolentry = this.soundPoolSounds.getRandomSoundFromSoundPool(s2);
        if (soundpoolentry != null && f3 > 0.0f) {
            this.field_587_e = (this.field_587_e + 1) % 256;
            String s1 = "sound_" + this.field_587_e;
            float f5 = 16.0f;
            if (f3 > 1.0f) {
                f5 *= f3;
            }
            sndSystem.newSource(f3 > 1.0f, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, f2, f1, f22, 2, f5);
            sndSystem.setPitch(s1, f4);
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            sndSystem.setVolume(s1, f3 * this.options.soundVolume);
            sndSystem.play(s1);
        }
    }

    public void func_337_a(String s2, float f2, float f1) {
        if (!loaded || this.options.soundVolume == 0.0f) {
            return;
        }
        SoundPoolEntry soundpoolentry = this.soundPoolSounds.getRandomSoundFromSoundPool(s2);
        if (soundpoolentry != null) {
            this.field_587_e = (this.field_587_e + 1) % 256;
            String s1 = "sound_" + this.field_587_e;
            sndSystem.newSource(false, s1, soundpoolentry.soundUrl, soundpoolentry.soundName, false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            sndSystem.setPitch(s1, f1);
            sndSystem.setVolume(s1, (f2 *= 0.25f) * this.options.soundVolume);
            sndSystem.play(s1);
        }
    }
}

