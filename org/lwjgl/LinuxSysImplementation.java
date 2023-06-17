/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl;

import java.awt.Toolkit;
import org.lwjgl.J2SESysImplementation;
import org.lwjgl.LWJGLUtil;

final class LinuxSysImplementation
extends J2SESysImplementation {
    private static final int JNI_VERSION = 18;

    LinuxSysImplementation() {
    }

    public int getRequiredJNIVersion() {
        return 18;
    }

    public boolean openURL(String url) {
        String[] browsers = new String[]{"xdg-open", "firefox", "mozilla", "opera", "konqueror", "nautilus", "galeon", "netscape"};
        for (int i2 = 0; i2 < browsers.length; ++i2) {
            String browser = browsers[i2];
            try {
                LWJGLUtil.execPrivileged(new String[]{browser, url});
                return true;
            }
            catch (Exception e2) {
                e2.printStackTrace(System.err);
                continue;
            }
        }
        return false;
    }

    public boolean has64Bit() {
        return true;
    }

    static {
        Toolkit.getDefaultToolkit();
    }
}

