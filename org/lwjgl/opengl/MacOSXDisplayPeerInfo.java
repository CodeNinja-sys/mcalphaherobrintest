/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.MacOSXCanvasPeerInfo;
import org.lwjgl.opengl.MacOSXDisplay;
import org.lwjgl.opengl.PixelFormat;

final class MacOSXDisplayPeerInfo
extends MacOSXCanvasPeerInfo {
    private boolean locked = false;

    MacOSXDisplayPeerInfo(PixelFormat pixel_format, boolean support_pbuffer) throws LWJGLException {
        super(pixel_format, support_pbuffer);
    }

    protected void doLockAndInitHandle() throws LWJGLException {
        if (this.locked) {
            throw new RuntimeException("Already locked");
        }
        Canvas canvas = ((MacOSXDisplay)Display.getImplementation()).getCanvas();
        if (canvas != null) {
            this.initHandle(canvas);
            this.locked = true;
        }
    }

    protected void doUnlock() throws LWJGLException {
        if (this.locked) {
            super.doUnlock();
            this.locked = false;
        }
    }
}

