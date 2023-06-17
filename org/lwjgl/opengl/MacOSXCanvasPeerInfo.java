/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.AWTSurfaceLock;
import org.lwjgl.opengl.MacOSXPeerInfo;
import org.lwjgl.opengl.PixelFormat;

abstract class MacOSXCanvasPeerInfo
extends MacOSXPeerInfo {
    private final AWTSurfaceLock awt_surface = new AWTSurfaceLock();

    protected MacOSXCanvasPeerInfo(PixelFormat pixel_format, boolean support_pbuffer) throws LWJGLException {
        super(pixel_format, true, true, support_pbuffer, true);
    }

    protected void initHandle(Canvas component) throws LWJGLException {
        MacOSXCanvasPeerInfo.nInitHandle(this.awt_surface.lockAndGetHandle(component), this.getHandle());
    }

    private static native void nInitHandle(ByteBuffer var0, ByteBuffer var1) throws LWJGLException;

    protected void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }
}

