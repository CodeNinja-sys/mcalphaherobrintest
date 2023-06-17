/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Context;
import org.lwjgl.opengl.ContextImplementation;
import org.lwjgl.opengl.LinuxDisplay;
import org.lwjgl.opengl.PeerInfo;

final class LinuxContextImplementation
implements ContextImplementation {
    LinuxContextImplementation() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ByteBuffer create(PeerInfo peer_info, IntBuffer attribs, ByteBuffer shared_context_handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer byteBuffer;
            ByteBuffer peer_handle = peer_info.lockAndGetHandle();
            try {
                byteBuffer = LinuxContextImplementation.nCreate(peer_handle, attribs, shared_context_handle);
            }
            catch (Throwable throwable) {
                peer_info.unlock();
                throw throwable;
            }
            peer_info.unlock();
            return byteBuffer;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native ByteBuffer nCreate(ByteBuffer var0, IntBuffer var1, ByteBuffer var2) throws LWJGLException;

    public void releaseDrawable(ByteBuffer context_handle) throws LWJGLException {
    }

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
            PeerInfo current_peer_info = current_context.getPeerInfo();
            LinuxDisplay.lockAWT();
            try {
                ByteBuffer peer_handle = current_peer_info.lockAndGetHandle();
                try {
                    LinuxContextImplementation.nSwapBuffers(peer_handle);
                }
                finally {
                    current_peer_info.unlock();
                }
            }
            finally {
                LinuxDisplay.unlockAWT();
            }
        }
    }

    private static native void nSwapBuffers(ByteBuffer var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseCurrentContext() throws LWJGLException {
        Context current_context = Context.getCurrentContext();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        Context context = current_context;
        synchronized (context) {
            PeerInfo current_peer_info = current_context.getPeerInfo();
            LinuxDisplay.lockAWT();
            try {
                ByteBuffer peer_handle = current_peer_info.lockAndGetHandle();
                try {
                    LinuxContextImplementation.nReleaseCurrentContext(peer_handle);
                }
                finally {
                    current_peer_info.unlock();
                }
            }
            finally {
                LinuxDisplay.unlockAWT();
            }
        }
    }

    private static native void nReleaseCurrentContext(ByteBuffer var0) throws LWJGLException;

    public void update(ByteBuffer context_handle) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void makeCurrent(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer peer_handle = peer_info.lockAndGetHandle();
            try {
                LinuxContextImplementation.nMakeCurrent(peer_handle, handle);
            }
            finally {
                peer_info.unlock();
            }
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void nMakeCurrent(ByteBuffer var0, ByteBuffer var1) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isCurrent(ByteBuffer handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            boolean result;
            boolean bl2 = result = LinuxContextImplementation.nIsCurrent(handle);
            return bl2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native boolean nIsCurrent(ByteBuffer var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSwapInterval(int value) {
        Context current_context = Context.getCurrentContext();
        if (current_context == null) {
            throw new IllegalStateException("No context is current");
        }
        Context context = current_context;
        synchronized (context) {
            LinuxDisplay.lockAWT();
            LinuxContextImplementation.nSetSwapInterval(current_context.getHandle(), value);
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void nSetSwapInterval(ByteBuffer var0, int var1);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void destroy(PeerInfo peer_info, ByteBuffer handle) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            ByteBuffer peer_handle = peer_info.lockAndGetHandle();
            try {
                LinuxContextImplementation.nDestroy(peer_handle, handle);
            }
            finally {
                peer_info.unlock();
            }
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void nDestroy(ByteBuffer var0, ByteBuffer var1) throws LWJGLException;
}

