/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.PeerInfo;
import org.lwjgl.opengl.PixelFormat;

abstract class MacOSXPeerInfo
extends PeerInfo {
    MacOSXPeerInfo(PixelFormat pixel_format, boolean use_display_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered) throws LWJGLException {
        super(MacOSXPeerInfo.createHandle());
        if (pixel_format.isFloatingPoint() && !LWJGLUtil.isMacOSXEqualsOrBetterThan(10, 4)) {
            throw new LWJGLException("Floating point pixel format requested, but is not supported");
        }
        this.choosePixelFormat(pixel_format, use_display_bpp, support_window, support_pbuffer, double_buffered);
    }

    private static native ByteBuffer createHandle();

    private void choosePixelFormat(PixelFormat pixel_format, boolean use_display_bpp, boolean support_window, boolean support_pbuffer, boolean double_buffered) throws LWJGLException {
        MacOSXPeerInfo.nChoosePixelFormat(this.getHandle(), pixel_format, use_display_bpp, support_window, support_pbuffer, double_buffered);
    }

    private static native void nChoosePixelFormat(ByteBuffer var0, PixelFormat var1, boolean var2, boolean var3, boolean var4, boolean var5) throws LWJGLException;

    public void destroy() {
        MacOSXPeerInfo.nDestroy(this.getHandle());
    }

    private static native void nDestroy(ByteBuffer var0);
}

