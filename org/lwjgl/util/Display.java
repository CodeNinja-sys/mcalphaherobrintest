/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Display;

public final class Display {
    private static final boolean DEBUG = false;
    static final /* synthetic */ boolean $assertionsDisabled;

    public static DisplayMode[] getAvailableDisplayModes(int minWidth, int minHeight, int maxWidth, int maxHeight, int minBPP, int maxBPP, int minFreq, int maxFreq) throws LWJGLException {
        DisplayMode[] modes = org.lwjgl.opengl.Display.getAvailableDisplayModes();
        if (LWJGLUtil.DEBUG) {
            System.out.println("Available screen modes:");
            for (int i2 = 0; i2 < modes.length; ++i2) {
                System.out.println(modes[i2]);
            }
        }
        ArrayList<DisplayMode> matches = new ArrayList<DisplayMode>(modes.length);
        for (int i3 = 0; i3 < modes.length; ++i3) {
            if (!$assertionsDisabled && modes[i3] == null) {
                throw new AssertionError((Object)("" + i3 + " " + modes.length));
            }
            if (minWidth != -1 && modes[i3].getWidth() < minWidth || maxWidth != -1 && modes[i3].getWidth() > maxWidth || minHeight != -1 && modes[i3].getHeight() < minHeight || maxHeight != -1 && modes[i3].getHeight() > maxHeight || minBPP != -1 && modes[i3].getBitsPerPixel() < minBPP || maxBPP != -1 && modes[i3].getBitsPerPixel() > maxBPP || modes[i3].getFrequency() != 0 && (minFreq != -1 && modes[i3].getFrequency() < minFreq || maxFreq != -1 && modes[i3].getFrequency() > maxFreq)) continue;
            matches.add(modes[i3]);
        }
        DisplayMode[] ret = new DisplayMode[matches.size()];
        matches.toArray(ret);
        if (LWJGLUtil.DEBUG) {
            // empty if block
        }
        return ret;
    }

    public static DisplayMode setDisplayMode(DisplayMode[] dm2, String[] param) throws Exception {
        int i2;
        class Sorter
        implements Comparator {
            final 1FieldAccessor[] field;
            private final /* synthetic */ String[] val$param;

            Sorter(String[] arrstring) {
                this.val$param = arrstring;
                class FieldAccessor {
                    final String fieldName;
                    final int order;
                    final int preferred;
                    final boolean usePreferred;

                    FieldAccessor(String fieldName, int order, int preferred, boolean usePreferred) {
                        this.fieldName = fieldName;
                        this.order = order;
                        this.preferred = preferred;
                        this.usePreferred = usePreferred;
                    }

                    int getInt(DisplayMode mode) {
                        if ("width".equals(this.fieldName)) {
                            return mode.getWidth();
                        }
                        if ("height".equals(this.fieldName)) {
                            return mode.getHeight();
                        }
                        if ("freq".equals(this.fieldName)) {
                            return mode.getFrequency();
                        }
                        if ("bpp".equals(this.fieldName)) {
                            return mode.getBitsPerPixel();
                        }
                        throw new IllegalArgumentException("Unknown field " + this.fieldName);
                    }
                }
                this.field = new FieldAccessor[this.val$param.length];
                for (int i2 = 0; i2 < this.field.length; ++i2) {
                    int idx = this.val$param[i2].indexOf(61);
                    this.field[i2] = idx > 0 ? new FieldAccessor(this.val$param[i2].substring(0, idx), 0, Integer.parseInt(this.val$param[i2].substring(idx + 1, this.val$param[i2].length())), true) : (this.val$param[i2].charAt(0) == '-' ? new FieldAccessor(this.val$param[i2].substring(1), -1, 0, false) : new FieldAccessor(this.val$param[i2], 1, 0, false));
                }
            }

            public int compare(Object o1, Object o2) {
                DisplayMode dm1 = (DisplayMode)o1;
                DisplayMode dm2 = (DisplayMode)o2;
                for (int i2 = 0; i2 < this.field.length; ++i2) {
                    int f1 = this.field[i2].getInt(dm1);
                    int f2 = this.field[i2].getInt(dm2);
                    if (this.field[i2].usePreferred && f1 != f2) {
                        int absf2;
                        if (f1 == this.field[i2].preferred) {
                            return -1;
                        }
                        if (f2 == this.field[i2].preferred) {
                            return 1;
                        }
                        int absf1 = Math.abs(f1 - this.field[i2].preferred);
                        if (absf1 < (absf2 = Math.abs(f2 - this.field[i2].preferred))) {
                            return -1;
                        }
                        if (absf1 <= absf2) continue;
                        return 1;
                    }
                    if (f1 < f2) {
                        return this.field[i2].order;
                    }
                    if (f1 == f2) continue;
                    return -this.field[i2].order;
                }
                return 0;
            }
        }
        Arrays.sort(dm2, new Sorter(param));
        if (LWJGLUtil.DEBUG) {
            System.out.println("Sorted display modes:");
            for (i2 = 0; i2 < dm2.length; ++i2) {
                System.out.println(dm2[i2]);
            }
        }
        for (i2 = 0; i2 < dm2.length; ++i2) {
            try {
                if (LWJGLUtil.DEBUG) {
                    System.out.println("Attempting to set displaymode: " + dm2[i2]);
                }
                org.lwjgl.opengl.Display.setDisplayMode(dm2[i2]);
                return dm2[i2];
            }
            catch (Exception e2) {
                if (!LWJGLUtil.DEBUG) continue;
                System.out.println("Failed to set display mode to " + dm2[i2]);
                e2.printStackTrace();
                continue;
            }
        }
        throw new Exception("Failed to set display mode.");
    }

    static {
        $assertionsDisabled = !Display.class.desiredAssertionStatus();
    }
}

