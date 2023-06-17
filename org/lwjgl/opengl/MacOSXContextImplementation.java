/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Context;
import org.lwjgl.opengl.ContextImplementation;
import org.lwjgl.opengl.PeerInfo;

final class MacOSXContextImplementation
implements ContextImplementation {
    MacOSXContextImplementation() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ByteBuffer create(PeerInfo peer_info, IntBuffer attribs, ByteBuffer shared_context_handle) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            ByteBuffer byteBuffer = MacOSXContextImplementation.nCreate(peer_handle, attribs, shared_context_handle);
            return byteBuffer;
        }
        finally {
            peer_info.unlock();
        }
    }

    private static native ByteBuffer nCreate(ByteBuffer var0, IntBuffer var1, ByteBuffer var2) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void swapBuffers() throws LWJGLException {
        Context current_context = Context.getCurrentContext();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        Context context = current_context;
        synchronized (context) {
            MacOSXContextImplementation.nSwapBuffers(current_context.getHandle());
        }
    }

    private static native void nSwapBuffers(ByteBuffer var0) throws LWJGLException;

    public void update(ByteBuffer context_handle) {
        MacOSXContextImplementation.nUpdate(context_handle);
    }

    private static native void nUpdate(ByteBuffer var0);

    public void releaseCurrentContext() throws LWJGLException {
        MacOSXContextImplementation.nReleaseCurrentContext();
    }

    private static native void nReleaseCurrentContext() throws LWJGLException;

    public void releaseDrawable(ByteBuffer context_handle) throws LWJGLException {
        MacOSXContextImplementation.clearDrawable(context_handle);
    }

    private static native void clearDrawable(ByteBuffer var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void resetView(PeerInfo peer_info, Context context) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            Context context2 = context;
            synchronized (context2) {
                MacOSXContextImplementation.clearDrawable(context.getHandle());
                MacOSXContextImplementation.setView(peer_handle, context.getHandle());
            }
        }
        finally {
            peer_info.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void makeCurrent(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        ByteBuffer peer_handle = peer_info.lockAndGetHandle();
        try {
            MacOSXContextImplementation.setView(peer_handle, handle);
            MacOSXContextImplementation.nMakeCurrent(handle);
        }
        finally {
            peer_info.unlock();
        }
    }

    private static native void setView(ByteBuffer var0, ByteBuffer var1) throws LWJGLException;

    private static native void nMakeCurrent(ByteBuffer var0) throws LWJGLException;

    public boolean isCurrent(ByteBuffer handle) throws LWJGLException {
        boolean result = MacOSXContextImplementation.nIsCurrent(handle);
        return result;
    }

    private static native boolean nIsCurrent(ByteBuffer var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSwapInterval(int value) {
        Context current_context;
        Context context = current_context = Context.getCurrentContext();
        synchronized (context) {
            MacOSXContextImplementation.nSetSwapInterval(current_context.getHandle(), value);
        }
    }

    private static native void nSetSwapInterval(ByteBuffer var0, int var1);

    public void destroy(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        MacOSXContextImplementation.nDestroy(handle);
    }

    private static native void nDestroy(ByteBuffer var0) throws LWJGLException;
}

