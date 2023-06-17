/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.WeakHashMap;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.Util;

public final class GLContext {
    private static final ThreadLocal current_capabilities = new ThreadLocal();
    private static CapabilitiesCacheEntry fast_path_cache = new CapabilitiesCacheEntry();
    private static final ThreadLocal thread_cache_entries = new ThreadLocal();
    private static final Map capability_cache = new WeakHashMap();
    private static int gl_ref_count;
    private static boolean did_auto_load;

    public static ContextCapabilities getCapabilities() {
        CapabilitiesCacheEntry recent_cache_entry = fast_path_cache;
        if (recent_cache_entry.owner == Thread.currentThread()) {
            return recent_cache_entry.capabilities;
        }
        return GLContext.getThreadLocalCapabilities();
    }

    private static ContextCapabilities getThreadLocalCapabilities() {
        return (ContextCapabilities)current_capabilities.get();
    }

    static void setCapabilities(ContextCapabilities capabilities) {
        current_capabilities.set(capabilities);
        CapabilitiesCacheEntry thread_cache_entry = (CapabilitiesCacheEntry)thread_cache_entries.get();
        if (thread_cache_entry == null) {
            thread_cache_entry = new CapabilitiesCacheEntry();
            thread_cache_entries.set(thread_cache_entry);
        }
        thread_cache_entry.owner = Thread.currentThread();
        thread_cache_entry.capabilities = capabilities;
        fast_path_cache = thread_cache_entry;
    }

    static long getPlatformSpecificFunctionAddress(String function_prefix, String[] os_prefixes, String[] os_function_prefixes, String function) {
        String os_name = (String)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return System.getProperty("os.name");
            }
        });
        for (int i2 = 0; i2 < os_prefixes.length; ++i2) {
            if (!os_name.startsWith(os_prefixes[i2])) continue;
            String platform_function_name = function.replaceFirst(function_prefix, os_function_prefixes[i2]);
            long address = GLContext.getFunctionAddress(platform_function_name);
            return address;
        }
        return 0L;
    }

    static native long getFunctionAddress(String var0);

    static int getSupportedExtensions(Set supported_extensions) {
        int profileMask;
        block21: {
            int minorVersion;
            int majorVersion;
            block20: {
                String version = GL11.glGetString(7938);
                if (version == null) {
                    throw new IllegalStateException("glGetString(GL_VERSION) returned null - possibly caused by missing current context.");
                }
                StringTokenizer version_tokenizer = new StringTokenizer(version, ". ");
                String major_string = version_tokenizer.nextToken();
                String minor_string = version_tokenizer.nextToken();
                majorVersion = 0;
                minorVersion = 0;
                try {
                    majorVersion = Integer.parseInt(major_string);
                    minorVersion = Integer.parseInt(minor_string);
                }
                catch (NumberFormatException e2) {
                    LWJGLUtil.log("The major and/or minor OpenGL version is malformed: " + e2.getMessage());
                }
                if (4 <= majorVersion) {
                    supported_extensions.add("OpenGL40");
                }
                if (3 < majorVersion || 3 == majorVersion && 3 <= minorVersion) {
                    supported_extensions.add("OpenGL33");
                }
                if (3 < majorVersion || 3 == majorVersion && 2 <= minorVersion) {
                    supported_extensions.add("OpenGL32");
                }
                if (3 < majorVersion || 3 == majorVersion && 1 <= minorVersion) {
                    supported_extensions.add("OpenGL31");
                }
                if (3 <= majorVersion) {
                    supported_extensions.add("OpenGL30");
                }
                if (2 < majorVersion || 2 == majorVersion && 1 <= minorVersion) {
                    supported_extensions.add("OpenGL21");
                }
                if (2 <= majorVersion) {
                    supported_extensions.add("OpenGL20");
                }
                if (1 < majorVersion || 5 <= minorVersion) {
                    supported_extensions.add("OpenGL15");
                }
                if (1 < majorVersion || 4 <= minorVersion) {
                    supported_extensions.add("OpenGL14");
                }
                if (1 < majorVersion || 3 <= minorVersion) {
                    supported_extensions.add("OpenGL13");
                }
                if (1 < majorVersion || 2 <= minorVersion) {
                    supported_extensions.add("OpenGL12");
                }
                if (1 < majorVersion || 1 <= minorVersion) {
                    supported_extensions.add("OpenGL11");
                }
                profileMask = 0;
                if (majorVersion >= 3) break block20;
                String extensions_string = GL11.glGetString(7939);
                if (extensions_string == null) {
                    throw new IllegalStateException("glGetString(GL_EXTENSIONS) returned null - is there a context current?");
                }
                StringTokenizer tokenizer = new StringTokenizer(extensions_string);
                while (tokenizer.hasMoreTokens()) {
                    supported_extensions.add(tokenizer.nextToken());
                }
                break block21;
            }
            IntBuffer buffer = BufferUtils.createIntBuffer(16);
            GL11.glGetInteger(33309, buffer);
            int extensionCount = buffer.get(0);
            for (int i2 = 0; i2 < extensionCount; ++i2) {
                supported_extensions.add(GL30.glGetStringi(7939, i2));
            }
            if (3 >= majorVersion && 2 > minorVersion) break block21;
            Util.checkGLError();
            GL11.glGetInteger(37158, buffer);
            try {
                Util.checkGLError();
                profileMask = buffer.get(0);
            }
            catch (OpenGLException e3) {
                LWJGLUtil.log("Failed to retrieve CONTEXT_PROFILE_MASK");
            }
        }
        return profileMask;
    }

    static void initNativeStubs(final Class extension_class, Set supported_extensions, String ext_name) {
        GLContext.resetNativeStubs(extension_class);
        if (supported_extensions.contains(ext_name)) {
            try {
                AccessController.doPrivileged(new PrivilegedExceptionAction(){

                    public Object run() throws Exception {
                        Method init_stubs_method = extension_class.getDeclaredMethod("initNativeStubs", null);
                        init_stubs_method.invoke(null, null);
                        return null;
                    }
                });
            }
            catch (Exception e2) {
                LWJGLUtil.log("Failed to initialize extension " + extension_class + " - exception: " + e2);
                supported_extensions.remove(ext_name);
            }
        }
    }

    public static synchronized void useContext(Object context) throws LWJGLException {
        GLContext.useContext(context, false);
    }

    public static synchronized void useContext(Object context, boolean forwardCompatible) throws LWJGLException {
        if (context == null) {
            ContextCapabilities.unloadAllStubs();
            GLContext.setCapabilities(null);
            if (did_auto_load) {
                GLContext.unloadOpenGLLibrary();
            }
            return;
        }
        if (gl_ref_count == 0) {
            GLContext.loadOpenGLLibrary();
            did_auto_load = true;
        }
        try {
            ContextCapabilities capabilities = (ContextCapabilities)capability_cache.get(context);
            if (capabilities == null) {
                new ContextCapabilities(forwardCompatible);
                capability_cache.put(context, GLContext.getCapabilities());
            } else {
                GLContext.setCapabilities(capabilities);
            }
        }
        catch (LWJGLException e2) {
            if (did_auto_load) {
                GLContext.unloadOpenGLLibrary();
            }
            throw e2;
        }
    }

    public static synchronized void loadOpenGLLibrary() throws LWJGLException {
        if (gl_ref_count == 0) {
            GLContext.nLoadOpenGLLibrary();
        }
        ++gl_ref_count;
    }

    private static native void nLoadOpenGLLibrary() throws LWJGLException;

    public static synchronized void unloadOpenGLLibrary() {
        if (--gl_ref_count == 0 && LWJGLUtil.getPlatform() != 1) {
            GLContext.nUnloadOpenGLLibrary();
        }
    }

    private static native void nUnloadOpenGLLibrary();

    static native void resetNativeStubs(Class var0);

    static {
        Sys.initialize();
    }

    private static final class CapabilitiesCacheEntry {
        Thread owner;
        ContextCapabilities capabilities;

        private CapabilitiesCacheEntry() {
        }
    }
}

