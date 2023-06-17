/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.apple.eio.FileManager
 */
package org.lwjgl;

import com.apple.eio.FileManager;
import java.awt.Toolkit;
import org.lwjgl.J2SESysImplementation;
import org.lwjgl.LWJGLUtil;

final class MacOSXSysImplementation
extends J2SESysImplementation {
    private static final int JNI_VERSION = 18;

    MacOSXSysImplementation() {
    }

    public int getRequiredJNIVersion() {
        return 18;
    }

    public boolean openURL(String url) {
        try {
            FileManager.openURL((String)url);
            return true;
        }
        catch (Exception e2) {
            LWJGLUtil.log("Exception occurred while trying to invoke browser: " + e2);
            return false;
        }
    }

    static {
        Toolkit.getDefaultToolkit();
    }
}

