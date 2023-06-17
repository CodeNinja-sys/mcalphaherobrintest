/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.LinuxSysImplementation;
import org.lwjgl.MacOSXSysImplementation;
import org.lwjgl.SysImplementation;
import org.lwjgl.WindowsSysImplementation;
import org.lwjgl.input.Mouse;

public final class Sys {
    private static final String JNI_LIBRARY_NAME = "lwjgl";
    private static final String VERSION = "2.4.2";
    private static final SysImplementation implementation = Sys.createImplementation();
    private static final String POSTFIX64BIT = "64";
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$net$URL;

    private static void doLoadLibrary(final String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                String library_path = System.getProperty("org.lwjgl.librarypath");
                if (library_path != null) {
                    System.load(library_path + File.separator + System.mapLibraryName(lib_name));
                } else {
                    System.loadLibrary(lib_name);
                }
                return null;
            }
        });
    }

    private static void loadLibrary(String lib_name) {
        try {
            Sys.doLoadLibrary(lib_name);
        }
        catch (UnsatisfiedLinkError e2) {
            if (implementation.has64Bit()) {
                try {
                    Sys.doLoadLibrary(lib_name + POSTFIX64BIT);
                    return;
                }
                catch (UnsatisfiedLinkError e22) {
                    LWJGLUtil.log("Failed to load 64 bit library: " + e22.getMessage());
                }
            }
            throw e2;
        }
    }

    private static SysImplementation createImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1: {
                return new LinuxSysImplementation();
            }
            case 3: {
                return new WindowsSysImplementation();
            }
            case 2: {
                return new MacOSXSysImplementation();
            }
        }
        throw new IllegalStateException("Unsupported platform");
    }

    private Sys() {
    }

    public static String getVersion() {
        return VERSION;
    }

    public static void initialize() {
    }

    public static long getTimerResolution() {
        return implementation.getTimerResolution();
    }

    public static long getTime() {
        return implementation.getTime() & Long.MAX_VALUE;
    }

    public static void alert(String title, String message) {
        boolean grabbed = Mouse.isGrabbed();
        if (grabbed) {
            Mouse.setGrabbed(false);
        }
        if (title == null) {
            title = "";
        }
        if (message == null) {
            message = "";
        }
        implementation.alert(title, message);
        if (grabbed) {
            Mouse.setGrabbed(true);
        }
    }

    public static boolean openURL(String url) {
        try {
            final Class<?> serviceManagerClass = Class.forName("javax.jnlp.ServiceManager");
            Method lookupMethod = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    return serviceManagerClass.getMethod("lookup", class$java$lang$String == null ? (class$java$lang$String = Sys.class$("java.lang.String")) : class$java$lang$String);
                }
            });
            Object basicService = lookupMethod.invoke(serviceManagerClass, "javax.jnlp.BasicService");
            final Class<?> basicServiceClass = Class.forName("javax.jnlp.BasicService");
            Method showDocumentMethod = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    return basicServiceClass.getMethod("showDocument", class$java$net$URL == null ? (class$java$net$URL = Sys.class$("java.net.URL")) : class$java$net$URL);
                }
            });
            try {
                Boolean ret = (Boolean)showDocumentMethod.invoke(basicService, new URL(url));
                return ret;
            }
            catch (MalformedURLException e2) {
                e2.printStackTrace(System.err);
                return false;
            }
        }
        catch (Exception ue) {
            return implementation.openURL(url);
        }
    }

    public static String getClipboard() {
        return implementation.getClipboard();
    }

    static {
        Sys.loadLibrary(JNI_LIBRARY_NAME);
        int native_jni_version = implementation.getJNIVersion();
        int required_version = implementation.getRequiredJNIVersion();
        if (native_jni_version != required_version) {
            throw new LinkageError("Version mismatch: jar version is '" + required_version + "', native libary version is '" + native_jni_version + "'");
        }
        implementation.setDebug(LWJGLUtil.DEBUG);
    }
}

