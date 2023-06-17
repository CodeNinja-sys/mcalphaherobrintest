/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import net.minecraft.src.KeyBinding;
import org.lwjgl.input.Keyboard;

public class GameSettings {
    private static final String[] RENDER_DISTANCES = new String[]{"FAR", "NORMAL", "SHORT", "TINY"};
    private static final String[] DIFFICULTY_LEVELS = new String[]{"Peaceful", "Easy", "Normal", "Hard"};
    public float musicVolume = 1.0f;
    public float soundVolume = 1.0f;
    public float mouseSensitivity = 0.5f;
    public boolean invertMouse = false;
    public int renderDistance = 0;
    public boolean viewBobbing = true;
    public boolean anaglyph = false;
    public boolean limitFramerate = false;
    public boolean fancyGraphics = true;
    public String skin = "Default";
    public KeyBinding keyBindForward = new KeyBinding("Forward", 17);
    public KeyBinding keyBindLeft = new KeyBinding("Left", 30);
    public KeyBinding keyBindBack = new KeyBinding("Back", 31);
    public KeyBinding keyBindRight = new KeyBinding("Right", 32);
    public KeyBinding keyBindJump = new KeyBinding("Jump", 57);
    public KeyBinding keyBindInventory = new KeyBinding("Inventory", 23);
    public KeyBinding keyBindDrop = new KeyBinding("Drop", 16);
    public KeyBinding keyBindChat = new KeyBinding("Chat", 20);
    public KeyBinding keyBindToggleFog = new KeyBinding("Toggle fog", 33);
    public KeyBinding keyBindSneak = new KeyBinding("Sneak", 42);
    public KeyBinding[] keyBindings = new KeyBinding[]{this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindToggleFog};
    protected Minecraft mc;
    private File optionsFile;
    public int numberOfOptions = 10;
    public int difficulty = 2;
    public boolean thirdPersonView = false;
    public String field_12259_z = "";

    public GameSettings(Minecraft minecraft, File file) {
        this.mc = minecraft;
        this.optionsFile = new File(file, "options.txt");
        this.loadOptions();
    }

    public GameSettings() {
    }

    public String getKeyBinding(int i2) {
        return this.keyBindings[i2].keyDescription + ": " + Keyboard.getKeyName(this.keyBindings[i2].keyCode);
    }

    public void setKeyBinding(int i2, int j2) {
        this.keyBindings[i2].keyCode = j2;
        this.saveOptions();
    }

    public void setOptionFloatValue(int i2, float f2) {
        if (i2 == 0) {
            this.musicVolume = f2;
            this.mc.sndManager.onSoundOptionsChanged();
        }
        if (i2 == 1) {
            this.soundVolume = f2;
            this.mc.sndManager.onSoundOptionsChanged();
        }
        if (i2 == 3) {
            this.mouseSensitivity = f2;
        }
    }

    public void setOptionValue(int i2, int j2) {
        if (i2 == 2) {
            boolean bl2 = this.invertMouse = !this.invertMouse;
        }
        if (i2 == 5) {
            boolean bl3 = this.viewBobbing = !this.viewBobbing;
        }
        if (i2 == 6) {
            this.anaglyph = !this.anaglyph;
            this.mc.renderEngine.refreshTextures();
        }
        if (i2 == 7) {
            boolean bl4 = this.limitFramerate = !this.limitFramerate;
        }
        if (i2 == 9) {
            this.fancyGraphics = !this.fancyGraphics;
            this.mc.field_6323_f.func_958_a();
        }
        this.saveOptions();
    }

    public int getOptionControlType(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 1;
        }
        return i2 != 3 ? 0 : 1;
    }

    public float getOptionFloatValue(int i2) {
        if (i2 == 0) {
            return this.musicVolume;
        }
        if (i2 == 1) {
            return this.soundVolume;
        }
        if (i2 == 3) {
            return this.mouseSensitivity;
        }
        return 0.0f;
    }

    public String getOptionDisplayString(int i2) {
        if (i2 == 0) {
            return "Music: " + (this.musicVolume <= 0.0f ? "OFF" : (int)(this.musicVolume * 100.0f) + "%");
        }
        if (i2 == 1) {
            return "Sound: " + (this.soundVolume <= 0.0f ? "OFF" : (int)(this.soundVolume * 100.0f) + "%");
        }
        if (i2 == 2) {
            return "Invert mouse: " + (this.invertMouse ? "ON" : "OFF");
        }
        if (i2 == 3) {
            if (this.mouseSensitivity == 0.0f) {
                return "Sensitivity: *yawn*";
            }
            if (this.mouseSensitivity == 1.0f) {
                return "Sensitivity: HYPERSPEED!!!";
            }
            return "Sensitivity: " + (int)(this.mouseSensitivity * 200.0f) + "%";
        }
        if (i2 == 4) {
            return "Render distance: " + RENDER_DISTANCES[this.renderDistance];
        }
        if (i2 == 5) {
            return "View bobbing: " + (this.viewBobbing ? "ON" : "OFF");
        }
        if (i2 == 6) {
            return "3d anaglyph: " + (this.anaglyph ? "ON" : "OFF");
        }
        if (i2 == 7) {
            return "Limit framerate: " + (this.limitFramerate ? "ON" : "OFF");
        }
        if (i2 == 8) {
            return "Difficulty: " + DIFFICULTY_LEVELS[this.difficulty];
        }
        if (i2 == 9) {
            return "Graphics: " + (this.fancyGraphics ? "FANCY" : "FAST");
        }
        return "";
    }

    public void loadOptions() {
        try {
            if (!this.optionsFile.exists()) {
                return;
            }
            BufferedReader bufferedreader = new BufferedReader(new FileReader(this.optionsFile));
            String s2 = "";
            while ((s2 = bufferedreader.readLine()) != null) {
                String[] as2 = s2.split(":");
                if (as2[0].equals("music")) {
                    this.musicVolume = this.parseFloat(as2[1]);
                }
                if (as2[0].equals("sound")) {
                    this.soundVolume = this.parseFloat(as2[1]);
                }
                if (as2[0].equals("mouseSensitivity")) {
                    this.mouseSensitivity = this.parseFloat(as2[1]);
                }
                if (as2[0].equals("invertYMouse")) {
                    this.invertMouse = as2[1].equals("true");
                }
                if (as2[0].equals("viewDistance")) {
                    this.renderDistance = Integer.parseInt(as2[1]);
                }
                if (as2[0].equals("bobView")) {
                    this.viewBobbing = as2[1].equals("true");
                }
                if (as2[0].equals("anaglyph3d")) {
                    this.anaglyph = as2[1].equals("true");
                }
                if (as2[0].equals("limitFramerate")) {
                    this.limitFramerate = as2[1].equals("true");
                }
                if (as2[0].equals("difficulty")) {
                    this.difficulty = Integer.parseInt(as2[1]);
                }
                if (as2[0].equals("fancyGraphics")) {
                    this.fancyGraphics = as2[1].equals("true");
                }
                if (as2[0].equals("skin")) {
                    this.skin = as2[1];
                }
                if (as2[0].equals("lastServer")) {
                    this.field_12259_z = as2[1];
                }
                for (int i2 = 0; i2 < this.keyBindings.length; ++i2) {
                    if (!as2[0].equals("key_" + this.keyBindings[i2].keyDescription)) continue;
                    this.keyBindings[i2].keyCode = Integer.parseInt(as2[1]);
                }
            }
            bufferedreader.close();
        }
        catch (Exception exception) {
            System.out.println("Failed to load options");
            exception.printStackTrace();
        }
    }

    private float parseFloat(String s2) {
        if (s2.equals("true")) {
            return 1.0f;
        }
        if (s2.equals("false")) {
            return 0.0f;
        }
        return Float.parseFloat(s2);
    }

    public void saveOptions() {
        try {
            PrintWriter printwriter = new PrintWriter(new FileWriter(this.optionsFile));
            printwriter.println("music:" + this.musicVolume);
            printwriter.println("sound:" + this.soundVolume);
            printwriter.println("invertYMouse:" + this.invertMouse);
            printwriter.println("mouseSensitivity:" + this.mouseSensitivity);
            printwriter.println("viewDistance:" + this.renderDistance);
            printwriter.println("bobView:" + this.viewBobbing);
            printwriter.println("anaglyph3d:" + this.anaglyph);
            printwriter.println("limitFramerate:" + this.limitFramerate);
            printwriter.println("difficulty:" + this.difficulty);
            printwriter.println("fancyGraphics:" + this.fancyGraphics);
            printwriter.println("skin:" + this.skin);
            printwriter.println("lastServer:" + this.field_12259_z);
            for (int i2 = 0; i2 < this.keyBindings.length; ++i2) {
                printwriter.println("key_" + this.keyBindings[i2].keyDescription + ":" + this.keyBindings[i2].keyCode);
            }
            printwriter.close();
        }
        catch (Exception exception) {
            System.out.println("Failed to save options");
            exception.printStackTrace();
        }
    }
}

