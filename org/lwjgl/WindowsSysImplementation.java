/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.DefaultSysImplementation;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

final class WindowsSysImplementation
extends DefaultSysImplementation {
    private static final int JNI_VERSION = 22;
    static /* synthetic */ Class class$org$lwjgl$opengl$Display;

    WindowsSysImplementation() {
    }

    public int getRequiredJNIVersion() {
        return 22;
    }

    public long getTimerResolution() {
        return 1000L;
    }

    public long getTime() {
        return WindowsSysImplementation.nGetTime();
    }

    private static native long nGetTime();

    public final boolean has64Bit() {
        return true;
    }

    private static long getHwnd() {
        if (!Display.isCreated()) {
            return 0L;
        }
        try {
            Long hwnd_obj = (Long)AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    Method getImplementation_method = (class$org$lwjgl$opengl$Display == null ? (class$org$lwjgl$opengl$Display = WindowsSysImplementation.class$("org.lwjgl.opengl.Display")) : class$org$lwjgl$opengl$Display).getDeclaredMethod("getImplementation", null);
                    getImplementation_method.setAccessible(true);
                    Object display_impl = getImplementation_method.invoke(null, null);
                    Class<?> WindowsDisplay_class = Class.forName("org.lwjgl.opengl.WindowsDisplay");
                    Method getHwnd_method = WindowsDisplay_class.getDeclaredMethod("getHwnd", null);
                    getHwnd_method.setAccessible(true);
                    Long hwnd = (Long)getHwnd_method.invoke(display_impl, null);
                    return hwnd;
                }
            });
            return hwnd_obj;
        }
        catch (PrivilegedActionException e2) {
            throw new Error(e2);
        }
    }

    public void alert(String title, String message) {
        if (!Display.isCreated()) {
            WindowsSysImplementation.initCommonControls();
        }
        WindowsSysImplementation.nAlert(WindowsSysImplementation.getHwnd(), title, message);
    }

    private static native void nAlert(long var0, String var2, String var3);

    private static native void initCommonControls();

    public boolean openURL(String url) {
        try {
            LWJGLUtil.execPrivileged(new String[]{"rundll32", "url.dll,FileProtocolHandler", url});
            return true;
        }
        catch (Exception e2) {
            LWJGLUtil.log("Failed to open url (" + url + "): " + e2.getMessage());
            return false;
        }
    }

    public String getClipboard() {
        return WindowsSysImplementation.nGetClipboard();
    }

    private static native String nGetClipboard();

    static {
        Sys.initialize();
    }
}

