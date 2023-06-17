/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.WindowsPeerInfo;

final class WindowsDisplayPeerInfo
extends WindowsPeerInfo {
    private final PixelFormat pixel_format;

    WindowsDisplayPeerInfo(PixelFormat pixel_format) throws LWJGLException {
        this.pixel_format = pixel_format;
        GLContext.loadOpenGLLibrary();
    }

    PixelFormat getPixelFormat() {
        return this.pixel_format;
    }

    void initDC(long hwnd, long hdc) throws LWJGLException {
        WindowsDisplayPeerInfo.nInitDC(this.getHandle(), hwnd, hdc);
    }

    private static native void nInitDC(ByteBuffer var0, long var1, long var3);

    protected void doLockAndInitHandle() throws LWJGLException {
    }

    protected void doUnlock() throws LWJGLException {
    }

    public void destroy() {
        super.destroy();
        GLContext.unloadOpenGLLibrary();
    }
}

