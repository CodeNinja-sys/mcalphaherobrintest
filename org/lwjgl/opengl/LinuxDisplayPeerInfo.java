/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.LinuxDisplay;
import org.lwjgl.opengl.LinuxPeerInfo;
import org.lwjgl.opengl.PixelFormat;

final class LinuxDisplayPeerInfo
extends LinuxPeerInfo {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    LinuxDisplayPeerInfo(PixelFormat pixel_format) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            GLContext.loadOpenGLLibrary();
            try {
                LinuxDisplay.incDisplay();
                try {
                    LinuxDisplayPeerInfo.initDefaultPeerInfo(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), this.getHandle(), pixel_format);
                }
                catch (LWJGLException e2) {
                    LinuxDisplay.decDisplay();
                    throw e2;
                }
            }
            catch (LWJGLException e3) {
                GLContext.unloadOpenGLLibrary();
                throw e3;
            }
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void initDefaultPeerInfo(long var0, int var2, ByteBuffer var3, PixelFormat var4) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void doLockAndInitHandle() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            LinuxDisplayPeerInfo.initDrawable(LinuxDisplay.getWindow(), this.getHandle());
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void initDrawable(long var0, ByteBuffer var2);

    protected void doUnlock() throws LWJGLException {
    }

    public void destroy() {
        super.destroy();
        LinuxDisplay.lockAWT();
        LinuxDisplay.decDisplay();
        GLContext.unloadOpenGLLibrary();
        LinuxDisplay.unlockAWT();
    }
}

