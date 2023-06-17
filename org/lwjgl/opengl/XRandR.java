/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class XRandR {
    private static Screen[] current;
    private static Map screens;

    private static void populate() {
        if (screens == null) {
            screens = new HashMap();
            try {
                String line;
                Process p2 = Runtime.getRuntime().exec(new String[]{"xrandr", "-q"});
                ArrayList<Screen> currentList = new ArrayList<Screen>();
                ArrayList<Screen> possibles = new ArrayList<Screen>();
                String name = null;
                BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                while ((line = br2.readLine()) != null) {
                    String[] sa = (line = line.trim()).split("\\s+");
                    if (sa[1].equals("connected")) {
                        if (name != null) {
                            screens.put(name, possibles.toArray(new Screen[possibles.size()]));
                            possibles.clear();
                        }
                        name = sa[0];
                        currentList.add(new Screen(name, sa[2]));
                        continue;
                    }
                    if (!Pattern.matches("\\d*x\\d*", sa[0])) continue;
                    possibles.add(new Screen(name, sa[0]));
                }
                screens.put(name, possibles.toArray(new Screen[possibles.size()]));
                current = currentList.toArray(new Screen[currentList.size()]);
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static Screen[] getConfiguration() {
        AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                XRandR.populate();
                return null;
            }
        });
        return (Screen[])current.clone();
    }

    public static void setConfiguration(Screen[] screens) {
        int i2;
        if (screens.length == 0) {
            throw new IllegalArgumentException("Must specify at least one screen");
        }
        ArrayList<String> cmd = new ArrayList<String>();
        cmd.add("xrandr");
        for (i2 = 0; i2 < current.length; ++i2) {
            boolean found = false;
            for (int j2 = 0; j2 < screens.length; ++j2) {
                if (!screens[j2].name.equals(XRandR.current[i2].name)) continue;
                found = true;
                break;
            }
            if (found) continue;
            cmd.add("--output");
            cmd.add(XRandR.current[i2].name);
            cmd.add("--off");
        }
        for (i2 = 0; i2 < screens.length; ++i2) {
            screens[i2].getArgs(cmd);
        }
        try {
            String line;
            Process p2 = Runtime.getRuntime().exec(cmd.toArray(new String[cmd.size()]));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
            while ((line = br2.readLine()) != null) {
                System.out.println(line);
            }
            current = screens;
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String[] getScreenNames() {
        XRandR.populate();
        return screens.keySet().toArray(new String[screens.size()]);
    }

    public static Screen[] getResolutions(String name) {
        XRandR.populate();
        return (Screen[])((Screen[])screens.get(name)).clone();
    }

    public static class Screen
    implements Cloneable {
        public final String name;
        public final int width;
        public final int height;
        public int xPos = 0;
        public int yPos = 0;

        private Screen(String name, String conf) {
            this.name = name;
            String[] sa = conf.split("\\D");
            this.width = Integer.parseInt(sa[0]);
            this.height = Integer.parseInt(sa[1]);
            if (sa.length > 2) {
                this.xPos = Integer.parseInt(sa[2]);
                this.yPos = Integer.parseInt(sa[3]);
            }
        }

        private void getArgs(List argList) {
            argList.add("--output");
            argList.add(this.name);
            argList.add("--mode");
            argList.add(this.width + "x" + this.height);
            argList.add("--pos");
            argList.add(this.xPos + "x" + this.yPos);
        }

        public String toString() {
            return this.name + " " + this.width + "x" + this.height + " @ " + this.xPos + "x" + this.yPos;
        }
    }
}

