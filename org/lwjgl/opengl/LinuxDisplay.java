/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.AWTCanvasImplementation;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayImplementation;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.LinuxDisplayPeerInfo;
import org.lwjgl.opengl.LinuxEvent;
import org.lwjgl.opengl.LinuxKeyboard;
import org.lwjgl.opengl.LinuxMouse;
import org.lwjgl.opengl.LinuxPbufferPeerInfo;
import org.lwjgl.opengl.LinuxPeerInfo;
import org.lwjgl.opengl.PeerInfo;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.XRandR;

final class LinuxDisplay
implements DisplayImplementation {
    public static final int CurrentTime = 0;
    public static final int GrabSuccess = 0;
    public static final int AutoRepeatModeOff = 0;
    public static final int AutoRepeatModeOn = 1;
    public static final int AutoRepeatModeDefault = 2;
    public static final int None = 0;
    private static final int KeyPressMask = 1;
    private static final int KeyReleaseMask = 2;
    private static final int ButtonPressMask = 4;
    private static final int ButtonReleaseMask = 8;
    private static final int NotifyAncestor = 0;
    private static final int NotifyNonlinear = 3;
    private static final int NotifyPointer = 5;
    private static final int NotifyPointerRoot = 6;
    private static final int NotifyDetailNone = 7;
    private static final int SetModeInsert = 0;
    private static final int SaveSetRoot = 1;
    private static final int SaveSetUnmap = 1;
    private static final int FULLSCREEN_LEGACY = 1;
    private static final int FULLSCREEN_NETWM = 2;
    private static final int WINDOWED = 3;
    private static int current_window_mode = 3;
    private static final int XRANDR = 10;
    private static final int XF86VIDMODE = 11;
    private static final int NONE = 12;
    private static long display;
    private static long current_window;
    private static long saved_error_handler;
    private static int display_connection_usage_count;
    private final LinuxEvent event_buffer = new LinuxEvent();
    private final LinuxEvent tmp_event_buffer = new LinuxEvent();
    private int current_displaymode_extension = 12;
    private long delete_atom;
    private PeerInfo peer_info;
    private ByteBuffer saved_gamma;
    private ByteBuffer current_gamma;
    private DisplayMode saved_mode;
    private DisplayMode current_mode;
    private XRandR.Screen[] savedXrandrConfig;
    private boolean keyboard_grabbed;
    private boolean pointer_grabbed;
    private boolean input_released;
    private boolean grab;
    private boolean focused;
    private boolean minimized;
    private boolean dirty;
    private boolean close_requested;
    private long current_cursor;
    private long blank_cursor;
    private Canvas parent;
    private long parent_window;
    private boolean xembedded;
    private boolean parent_focus;
    private LinuxKeyboard keyboard;
    private LinuxMouse mouse;

    LinuxDisplay() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static ByteBuffer getCurrentGammaRamp() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            block8: {
                ByteBuffer byteBuffer;
                LinuxDisplay.incDisplay();
                try {
                    if (!LinuxDisplay.isXF86VidModeSupported()) break block8;
                    byteBuffer = LinuxDisplay.nGetCurrentGammaRamp(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen());
                }
                catch (Throwable throwable) {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                LinuxDisplay.decDisplay();
                return byteBuffer;
            }
            ByteBuffer byteBuffer = null;
            LinuxDisplay.decDisplay();
            return byteBuffer;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native ByteBuffer nGetCurrentGammaRamp(long var0, int var2) throws LWJGLException;

    private static int getBestDisplayModeExtension() {
        int result;
        if (LinuxDisplay.isXrandrSupported()) {
            LWJGLUtil.log("Using Xrandr for display mode switching");
            result = 10;
        } else if (LinuxDisplay.isXF86VidModeSupported()) {
            LWJGLUtil.log("Using XF86VidMode for display mode switching");
            result = 11;
        } else {
            LWJGLUtil.log("No display mode extensions available");
            result = 12;
        }
        return result;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean isXrandrSupported() {
        if (Display.getPrivilegedBoolean("LWJGL_DISABLE_XRANDR")) {
            return false;
        }
        LinuxDisplay.lockAWT();
        try {
            boolean bl2;
            LinuxDisplay.incDisplay();
            try {
                bl2 = LinuxDisplay.nIsXrandrSupported(LinuxDisplay.getDisplay());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    LWJGLUtil.log("Got exception while querying Xrandr support: " + e2);
                    boolean bl3 = false;
                    return bl3;
                }
            }
            LinuxDisplay.decDisplay();
            return bl2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native boolean nIsXrandrSupported(long var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean isXF86VidModeSupported() {
        LinuxDisplay.lockAWT();
        try {
            boolean bl2;
            LinuxDisplay.incDisplay();
            try {
                bl2 = LinuxDisplay.nIsXF86VidModeSupported(LinuxDisplay.getDisplay());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    LWJGLUtil.log("Got exception while querying XF86VM support: " + e2);
                    boolean bl3 = false;
                    return bl3;
                }
            }
            LinuxDisplay.decDisplay();
            return bl2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native boolean nIsXF86VidModeSupported(long var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean isNetWMFullscreenSupported() throws LWJGLException {
        if (Display.getPrivilegedBoolean("LWJGL_DISABLE_NETWM")) {
            return false;
        }
        LinuxDisplay.lockAWT();
        try {
            boolean bl2;
            LinuxDisplay.incDisplay();
            try {
                bl2 = LinuxDisplay.nIsNetWMFullscreenSupported(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    LWJGLUtil.log("Got exception while querying NetWM support: " + e2);
                    boolean bl3 = false;
                    return bl3;
                }
            }
            LinuxDisplay.decDisplay();
            return bl2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native boolean nIsNetWMFullscreenSupported(long var0, int var2) throws LWJGLException;

    static void lockAWT() {
        try {
            LinuxDisplay.nLockAWT();
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Caught exception while locking AWT: " + e2);
        }
    }

    private static native void nLockAWT() throws LWJGLException;

    static void unlockAWT() {
        try {
            LinuxDisplay.nUnlockAWT();
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Caught exception while unlocking AWT: " + e2);
        }
    }

    private static native void nUnlockAWT() throws LWJGLException;

    static void incDisplay() throws LWJGLException {
        if (display_connection_usage_count == 0) {
            GLContext.loadOpenGLLibrary();
            saved_error_handler = LinuxDisplay.setErrorHandler();
            display = LinuxDisplay.openDisplay();
        }
        ++display_connection_usage_count;
    }

    private static native int callErrorHandler(long var0, long var2, long var4);

    private static native long setErrorHandler();

    private static native long resetErrorHandler(long var0);

    private static native void synchronize(long var0, boolean var2);

    private static int globalErrorHandler(long display, long event_ptr, long error_display, long serial, long error_code, long request_code, long minor_code) throws LWJGLException {
        if (display == LinuxDisplay.getDisplay()) {
            String error_msg = LinuxDisplay.getErrorText(display, error_code);
            throw new LWJGLException("X Error - disp: 0x" + Long.toHexString(error_display) + " serial: " + serial + " error: " + error_msg + " request_code: " + request_code + " minor_code: " + minor_code);
        }
        if (saved_error_handler != 0L) {
            return LinuxDisplay.callErrorHandler(saved_error_handler, display, event_ptr);
        }
        return 0;
    }

    private static native String getErrorText(long var0, long var2);

    static void decDisplay() {
    }

    static native long openDisplay() throws LWJGLException;

    static native void closeDisplay(long var0);

    private int getWindowMode(boolean fullscreen) throws LWJGLException {
        if (fullscreen) {
            if (this.current_displaymode_extension == 10 && LinuxDisplay.isNetWMFullscreenSupported()) {
                LWJGLUtil.log("Using NetWM for fullscreen window");
                return 2;
            }
            LWJGLUtil.log("Using legacy mode for fullscreen window");
            return 1;
        }
        return 3;
    }

    static long getDisplay() {
        if (display_connection_usage_count <= 0) {
            throw new InternalError("display_connection_usage_count = " + display_connection_usage_count);
        }
        return display;
    }

    static int getDefaultScreen() {
        return LinuxDisplay.nGetDefaultScreen(LinuxDisplay.getDisplay());
    }

    static native int nGetDefaultScreen(long var0);

    static long getWindow() {
        return current_window;
    }

    private void ungrabKeyboard() {
        if (this.keyboard_grabbed) {
            LinuxDisplay.nUngrabKeyboard(LinuxDisplay.getDisplay());
            this.keyboard_grabbed = false;
        }
    }

    static native int nUngrabKeyboard(long var0);

    private void grabKeyboard() {
        int res;
        if (!this.keyboard_grabbed && (res = LinuxDisplay.nGrabKeyboard(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow())) == 0) {
            this.keyboard_grabbed = true;
        }
    }

    static native int nGrabKeyboard(long var0, long var2);

    private void grabPointer() {
        int result;
        if (!this.pointer_grabbed && (result = LinuxDisplay.nGrabPointer(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), 0L)) == 0) {
            this.pointer_grabbed = true;
            if (this.isLegacyFullscreen()) {
                LinuxDisplay.nSetViewPort(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), LinuxDisplay.getDefaultScreen());
            }
        }
    }

    static native int nGrabPointer(long var0, long var2, long var4);

    private static native void nSetViewPort(long var0, long var2, int var4);

    private void ungrabPointer() {
        if (this.pointer_grabbed) {
            this.pointer_grabbed = false;
            LinuxDisplay.nUngrabPointer(LinuxDisplay.getDisplay());
        }
    }

    static native int nUngrabPointer(long var0);

    private boolean isFullscreen() {
        return current_window_mode == 1 || current_window_mode == 2;
    }

    private boolean shouldGrab() {
        return !this.input_released && this.grab && this.mouse != null;
    }

    private void updatePointerGrab() {
        if (this.isFullscreen() || this.shouldGrab()) {
            this.grabPointer();
        } else {
            this.ungrabPointer();
        }
        this.updateCursor();
    }

    private void updateCursor() {
        long cursor = this.shouldGrab() ? this.blank_cursor : this.current_cursor;
        LinuxDisplay.nDefineCursor(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), cursor);
    }

    private static native void nDefineCursor(long var0, long var2, long var4);

    private boolean isLegacyFullscreen() {
        return current_window_mode == 1;
    }

    private void updateKeyboardGrab() {
        if (this.isLegacyFullscreen()) {
            this.grabKeyboard();
        } else {
            this.ungrabKeyboard();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void createWindow(DisplayMode mode, Canvas parent, int x2, int y2) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            LinuxDisplay.incDisplay();
            try {
                ByteBuffer handle = this.peer_info.lockAndGetHandle();
                try {
                    current_window_mode = this.getWindowMode(Display.isFullscreen());
                    boolean undecorated = Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated") || current_window_mode != 3;
                    this.parent = parent;
                    this.parent_window = parent != null ? LinuxDisplay.getHandle(parent) : LinuxDisplay.getRootWindow(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen());
                    current_window = LinuxDisplay.nCreateWindow(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), handle, mode, current_window_mode, x2, y2, undecorated, this.parent_window);
                    LinuxDisplay.mapRaised(LinuxDisplay.getDisplay(), current_window);
                    this.xembedded = parent != null && this.isAncestorXEmbedded(this.parent_window);
                    this.blank_cursor = LinuxDisplay.createBlankCursor();
                    this.current_cursor = 0L;
                    this.focused = false;
                    this.input_released = false;
                    this.pointer_grabbed = false;
                    this.keyboard_grabbed = false;
                    this.close_requested = false;
                    this.grab = false;
                    this.minimized = false;
                    this.dirty = true;
                }
                finally {
                    this.peer_info.unlock();
                }
            }
            catch (LWJGLException e2) {
                LinuxDisplay.decDisplay();
                throw e2;
            }
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native long nCreateWindow(long var0, int var2, ByteBuffer var3, DisplayMode var4, int var5, int var6, int var7, boolean var8, long var9) throws LWJGLException;

    private static native long getRootWindow(long var0, int var2);

    private static native boolean hasProperty(long var0, long var2, long var4);

    private static native long getParentWindow(long var0, long var2) throws LWJGLException;

    private static native void mapRaised(long var0, long var2);

    private static native void reparentWindow(long var0, long var2, long var4, int var6, int var7);

    private boolean isAncestorXEmbedded(long window) throws LWJGLException {
        long xembed_atom = LinuxDisplay.internAtom("_XEMBED_INFO", true);
        if (xembed_atom != 0L) {
            long w2 = window;
            while (w2 != 0L) {
                if (LinuxDisplay.hasProperty(LinuxDisplay.getDisplay(), w2, xembed_atom)) {
                    return true;
                }
                w2 = LinuxDisplay.getParentWindow(LinuxDisplay.getDisplay(), w2);
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static long getHandle(Canvas parent) throws LWJGLException {
        AWTCanvasImplementation awt_impl = AWTGLCanvas.createImplementation();
        LinuxPeerInfo parent_peer_info = (LinuxPeerInfo)awt_impl.createPeerInfo(parent, null);
        ByteBuffer parent_peer_info_handle = parent_peer_info.lockAndGetHandle();
        try {
            long l2 = parent_peer_info.getDrawable();
            return l2;
        }
        finally {
            parent_peer_info.unlock();
        }
    }

    private void updateInputGrab() {
        this.updatePointerGrab();
        this.updateKeyboardGrab();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void destroyWindow() {
        LinuxDisplay.lockAWT();
        try {
            try {
                this.setNativeCursor(null);
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Failed to reset cursor: " + e2.getMessage());
            }
            LinuxDisplay.nDestroyCursor(LinuxDisplay.getDisplay(), this.blank_cursor);
            this.blank_cursor = 0L;
            this.ungrabKeyboard();
            LinuxDisplay.nDestroyWindow(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow());
            LinuxDisplay.decDisplay();
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    static native void nDestroyWindow(long var0, long var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void switchDisplayMode(DisplayMode mode) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            this.switchDisplayModeOnTmpDisplay(mode);
            this.current_mode = mode;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void switchDisplayModeOnTmpDisplay(DisplayMode mode) throws LWJGLException {
        LinuxDisplay.incDisplay();
        try {
            LinuxDisplay.nSwitchDisplayMode(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), this.current_displaymode_extension, mode);
        }
        finally {
            LinuxDisplay.decDisplay();
        }
    }

    private static native void nSwitchDisplayMode(long var0, int var2, int var3, DisplayMode var4) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static long internAtom(String atom_name, boolean only_if_exists) throws LWJGLException {
        LinuxDisplay.incDisplay();
        try {
            long l2 = LinuxDisplay.nInternAtom(LinuxDisplay.getDisplay(), atom_name, only_if_exists);
            return l2;
        }
        finally {
            LinuxDisplay.decDisplay();
        }
    }

    static native long nInternAtom(long var0, String var2, boolean var3);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetDisplayMode() {
        LinuxDisplay.lockAWT();
        try {
            if (this.current_displaymode_extension == 10 && this.savedXrandrConfig.length > 0) {
                XRandR.setConfiguration(this.savedXrandrConfig);
            } else {
                this.switchDisplayMode(this.saved_mode);
            }
            if (LinuxDisplay.isXF86VidModeSupported()) {
                this.doSetGamma(this.saved_gamma);
            }
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Caught exception while resetting mode: " + e2);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     * Enabled aggressive exception aggregation
     */
    public int getGammaRampLength() {
        if (!LinuxDisplay.isXF86VidModeSupported()) {
            return 0;
        }
        LinuxDisplay.lockAWT();
        try {
            int n2;
            LinuxDisplay.incDisplay();
            try {
                n2 = LinuxDisplay.nGetGammaRampLength(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen());
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Got exception while querying gamma length: " + e2);
                int n3 = 0;
                LinuxDisplay.decDisplay();
                LinuxDisplay.unlockAWT();
                return n3;
                {
                    catch (Throwable throwable) {
                        try {
                            LinuxDisplay.decDisplay();
                            throw throwable;
                        }
                        catch (LWJGLException e3) {
                            LWJGLUtil.log("Failed to get gamma ramp length: " + e3);
                            int n4 = 0;
                            return n4;
                        }
                    }
                }
            }
            LinuxDisplay.decDisplay();
            return n2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native int nGetGammaRampLength(long var0, int var2) throws LWJGLException;

    public void setGammaRamp(FloatBuffer gammaRamp) throws LWJGLException {
        if (!LinuxDisplay.isXF86VidModeSupported()) {
            throw new LWJGLException("No gamma ramp support (Missing XF86VM extension)");
        }
        this.doSetGamma(LinuxDisplay.convertToNativeRamp(gammaRamp));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doSetGamma(ByteBuffer native_gamma) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            this.setGammaRampOnTmpDisplay(native_gamma);
            this.current_gamma = native_gamma;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setGammaRampOnTmpDisplay(ByteBuffer native_gamma) throws LWJGLException {
        LinuxDisplay.incDisplay();
        try {
            LinuxDisplay.nSetGammaRamp(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), native_gamma);
        }
        finally {
            LinuxDisplay.decDisplay();
        }
    }

    private static native void nSetGammaRamp(long var0, int var2, ByteBuffer var3) throws LWJGLException;

    private static ByteBuffer convertToNativeRamp(FloatBuffer ramp) throws LWJGLException {
        return LinuxDisplay.nConvertToNativeRamp(ramp, ramp.position(), ramp.remaining());
    }

    private static native ByteBuffer nConvertToNativeRamp(FloatBuffer var0, int var1, int var2) throws LWJGLException;

    public String getAdapter() {
        return null;
    }

    public String getVersion() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DisplayMode init() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            this.delete_atom = LinuxDisplay.internAtom("WM_DELETE_WINDOW", false);
            this.current_displaymode_extension = LinuxDisplay.getBestDisplayModeExtension();
            if (this.current_displaymode_extension == 12) {
                throw new LWJGLException("No display mode extension is available");
            }
            DisplayMode[] modes = this.getAvailableDisplayModes();
            if (modes == null || modes.length == 0) {
                throw new LWJGLException("No modes available");
            }
            switch (this.current_displaymode_extension) {
                case 10: {
                    this.savedXrandrConfig = XRandR.getConfiguration();
                    this.saved_mode = LinuxDisplay.getCurrentXRandrMode();
                    break;
                }
                case 11: {
                    this.saved_mode = modes[0];
                    break;
                }
                default: {
                    throw new LWJGLException("Unknown display mode extension: " + this.current_displaymode_extension);
                }
            }
            this.current_mode = this.saved_mode;
            this.current_gamma = this.saved_gamma = LinuxDisplay.getCurrentGammaRamp();
            DisplayMode displayMode = this.saved_mode;
            return displayMode;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static DisplayMode getCurrentXRandrMode() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            DisplayMode displayMode;
            LinuxDisplay.incDisplay();
            try {
                displayMode = LinuxDisplay.nGetCurrentXRandrMode(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen());
            }
            catch (Throwable throwable) {
                LinuxDisplay.decDisplay();
                throw throwable;
            }
            LinuxDisplay.decDisplay();
            return displayMode;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native DisplayMode nGetCurrentXRandrMode(long var0, int var2) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTitle(String title) {
        LinuxDisplay.lockAWT();
        try {
            LinuxDisplay.nSetTitle(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), title);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void nSetTitle(long var0, long var2, String var4);

    public boolean isCloseRequested() {
        boolean result = this.close_requested;
        this.close_requested = false;
        return result;
    }

    public boolean isVisible() {
        return !this.minimized;
    }

    public boolean isActive() {
        return this.focused || this.isLegacyFullscreen();
    }

    public boolean isDirty() {
        boolean result = this.dirty;
        this.dirty = false;
        return result;
    }

    public PeerInfo createPeerInfo(PixelFormat pixel_format) throws LWJGLException {
        this.peer_info = new LinuxDisplayPeerInfo(pixel_format);
        return this.peer_info;
    }

    static native void setInputFocus(long var0, long var2, long var4);

    private void relayEventToParent(LinuxEvent event_buffer, int event_mask) {
        this.tmp_event_buffer.copyFrom(event_buffer);
        this.tmp_event_buffer.setWindow(this.parent_window);
        this.tmp_event_buffer.sendEvent(LinuxDisplay.getDisplay(), this.parent_window, true, event_mask);
    }

    private void relayEventToParent(LinuxEvent event_buffer) {
        if (this.parent == null) {
            return;
        }
        switch (event_buffer.getType()) {
            case 2: {
                this.relayEventToParent(event_buffer, 1);
                break;
            }
            case 3: {
                this.relayEventToParent(event_buffer, 1);
                break;
            }
            case 4: {
                this.relayEventToParent(event_buffer, 1);
                break;
            }
            case 5: {
                this.relayEventToParent(event_buffer, 1);
                break;
            }
        }
    }

    private void processEvents() {
        while (LinuxEvent.getPending(LinuxDisplay.getDisplay()) > 0) {
            this.event_buffer.nextEvent(LinuxDisplay.getDisplay());
            long event_window = this.event_buffer.getWindow();
            this.relayEventToParent(this.event_buffer);
            if (event_window != LinuxDisplay.getWindow() || this.event_buffer.filterEvent(event_window) || this.mouse != null && this.mouse.filterEvent(this.grab, this.shouldWarpPointer(), this.event_buffer) || this.keyboard != null && this.keyboard.filterEvent(this.event_buffer)) continue;
            switch (this.event_buffer.getType()) {
                case 9: {
                    this.setFocused(true, this.event_buffer.getFocusDetail());
                    break;
                }
                case 10: {
                    this.setFocused(false, this.event_buffer.getFocusDetail());
                    break;
                }
                case 33: {
                    if (this.event_buffer.getClientFormat() != 32 || (long)this.event_buffer.getClientData(0) != this.delete_atom) break;
                    this.close_requested = true;
                    break;
                }
                case 19: {
                    this.dirty = true;
                    this.minimized = false;
                    break;
                }
                case 18: {
                    this.dirty = true;
                    this.minimized = true;
                    break;
                }
                case 12: {
                    this.dirty = true;
                    break;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void update() {
        LinuxDisplay.lockAWT();
        try {
            this.processEvents();
            this.checkInput();
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reshape(int x2, int y2, int width, int height) {
        LinuxDisplay.lockAWT();
        try {
            LinuxDisplay.nReshape(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), x2, y2, width, height);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native void nReshape(long var0, long var2, int var4, int var5, int var6, int var7);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            DisplayMode[] arrdisplayMode;
            LinuxDisplay.incDisplay();
            try {
                DisplayMode[] modes;
                arrdisplayMode = modes = LinuxDisplay.nGetAvailableDisplayModes(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen(), this.current_displaymode_extension);
            }
            catch (Throwable throwable) {
                LinuxDisplay.decDisplay();
                throw throwable;
            }
            LinuxDisplay.decDisplay();
            return arrdisplayMode;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native DisplayMode[] nGetAvailableDisplayModes(long var0, int var2, int var3) throws LWJGLException;

    public boolean hasWheel() {
        return true;
    }

    public int getButtonCount() {
        return this.mouse.getButtonCount();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void createMouse() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            this.mouse = new LinuxMouse(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), LinuxDisplay.getWindow());
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    public void destroyMouse() {
        this.mouse = null;
        this.updateInputGrab();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pollMouse(IntBuffer coord_buffer, ByteBuffer buttons) {
        LinuxDisplay.lockAWT();
        try {
            this.mouse.poll(this.grab, coord_buffer, buttons);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void readMouse(ByteBuffer buffer) {
        LinuxDisplay.lockAWT();
        try {
            this.mouse.read(buffer);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setCursorPosition(int x2, int y2) {
        LinuxDisplay.lockAWT();
        try {
            this.mouse.setCursorPosition(x2, y2);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private void checkInput() {
        if (this.parent == null) {
            return;
        }
        if (this.parent_focus != this.parent.hasFocus()) {
            this.parent_focus = this.parent.hasFocus();
            if (this.parent_focus) {
                this.setInputFocusUnsafe(current_window);
            } else if (this.xembedded) {
                this.setInputFocusUnsafe(0L);
            }
        } else if (this.parent_focus && !this.focused) {
            this.setInputFocusUnsafe(current_window);
        }
    }

    private void setFocused(boolean got_focus, int focus_detail) {
        if (this.focused == got_focus || focus_detail == 7 || focus_detail == 5 || focus_detail == 6) {
            return;
        }
        this.focused = got_focus;
        if (this.focused) {
            this.acquireInput();
        } else {
            this.releaseInput();
        }
    }

    static native long nGetInputFocus(long var0);

    private void setInputFocusUnsafe(long window) {
        try {
            LinuxDisplay.setInputFocus(LinuxDisplay.getDisplay(), window, 0L);
            LinuxDisplay.sync(LinuxDisplay.getDisplay(), false);
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Got exception while trying to focus: " + e2);
        }
    }

    private static native void sync(long var0, boolean var2) throws LWJGLException;

    private void releaseInput() {
        if (this.isLegacyFullscreen() || this.input_released) {
            return;
        }
        this.input_released = true;
        this.updateInputGrab();
        if (current_window_mode == 2) {
            LinuxDisplay.nIconifyWindow(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow(), LinuxDisplay.getDefaultScreen());
            try {
                if (this.current_displaymode_extension == 10 && this.savedXrandrConfig.length > 0) {
                    XRandR.setConfiguration(this.savedXrandrConfig);
                } else {
                    this.switchDisplayModeOnTmpDisplay(this.saved_mode);
                }
                this.setGammaRampOnTmpDisplay(this.saved_gamma);
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Failed to restore saved mode: " + e2.getMessage());
            }
        }
    }

    private static native void nIconifyWindow(long var0, long var2, int var4);

    private void acquireInput() {
        if (this.isLegacyFullscreen() || !this.input_released) {
            return;
        }
        this.input_released = false;
        this.updateInputGrab();
        if (current_window_mode == 2) {
            try {
                this.switchDisplayModeOnTmpDisplay(this.current_mode);
                this.setGammaRampOnTmpDisplay(this.current_gamma);
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Failed to restore mode: " + e2.getMessage());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void grabMouse(boolean new_grab) {
        LinuxDisplay.lockAWT();
        try {
            if (new_grab != this.grab) {
                this.grab = new_grab;
                this.updateInputGrab();
                this.mouse.changeGrabbed(this.grab, this.shouldWarpPointer());
            }
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private boolean shouldWarpPointer() {
        return this.pointer_grabbed && this.shouldGrab();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getNativeCursorCapabilities() {
        LinuxDisplay.lockAWT();
        try {
            int n2;
            LinuxDisplay.incDisplay();
            try {
                n2 = LinuxDisplay.nGetNativeCursorCapabilities(LinuxDisplay.getDisplay());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    throw new RuntimeException(e2);
                }
            }
            LinuxDisplay.decDisplay();
            return n2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native int nGetNativeCursorCapabilities(long var0) throws LWJGLException;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setNativeCursor(Object handle) throws LWJGLException {
        this.current_cursor = LinuxDisplay.getCursorHandle(handle);
        LinuxDisplay.lockAWT();
        try {
            this.updateCursor();
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMinCursorSize() {
        LinuxDisplay.lockAWT();
        try {
            int n2;
            LinuxDisplay.incDisplay();
            try {
                n2 = LinuxDisplay.nGetMinCursorSize(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    LWJGLUtil.log("Exception occurred in getMinCursorSize: " + e2);
                    int n3 = 0;
                    return n3;
                }
            }
            LinuxDisplay.decDisplay();
            return n2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native int nGetMinCursorSize(long var0, long var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getMaxCursorSize() {
        LinuxDisplay.lockAWT();
        try {
            int n2;
            LinuxDisplay.incDisplay();
            try {
                n2 = LinuxDisplay.nGetMaxCursorSize(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    LWJGLUtil.log("Exception occurred in getMaxCursorSize: " + e2);
                    int n3 = 0;
                    return n3;
                }
            }
            LinuxDisplay.decDisplay();
            return n2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native int nGetMaxCursorSize(long var0, long var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void createKeyboard() throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            this.keyboard = new LinuxKeyboard(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow());
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void destroyKeyboard() {
        LinuxDisplay.lockAWT();
        try {
            this.keyboard.destroy(LinuxDisplay.getDisplay());
            this.keyboard = null;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pollKeyboard(ByteBuffer keyDownBuffer) {
        LinuxDisplay.lockAWT();
        try {
            this.keyboard.poll(keyDownBuffer);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void readKeyboard(ByteBuffer buffer) {
        LinuxDisplay.lockAWT();
        try {
            this.keyboard.read(buffer);
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native long nCreateCursor(long var0, int var2, int var3, int var4, int var5, int var6, IntBuffer var7, int var8, IntBuffer var9, int var10) throws LWJGLException;

    private static long createBlankCursor() {
        return LinuxDisplay.nCreateBlankCursor(LinuxDisplay.getDisplay(), LinuxDisplay.getWindow());
    }

    static native long nCreateBlankCursor(long var0, long var2);

    public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        LinuxDisplay.lockAWT();
        try {
            LinuxDisplay.incDisplay();
            try {
                long cursor = LinuxDisplay.nCreateCursor(LinuxDisplay.getDisplay(), width, height, xHotspot, yHotspot, numImages, images, images.position(), delays, delays != null ? delays.position() : -1);
                Long l2 = new Long(cursor);
                return l2;
            }
            catch (LWJGLException e2) {
                LinuxDisplay.decDisplay();
                throw e2;
            }
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static long getCursorHandle(Object cursor_handle) {
        return cursor_handle != null ? (Long)cursor_handle : 0L;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void destroyCursor(Object cursorHandle) {
        LinuxDisplay.lockAWT();
        try {
            LinuxDisplay.nDestroyCursor(LinuxDisplay.getDisplay(), LinuxDisplay.getCursorHandle(cursorHandle));
            LinuxDisplay.decDisplay();
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    static native void nDestroyCursor(long var0, long var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getPbufferCapabilities() {
        LinuxDisplay.lockAWT();
        try {
            int n2;
            LinuxDisplay.incDisplay();
            try {
                n2 = LinuxDisplay.nGetPbufferCapabilities(LinuxDisplay.getDisplay(), LinuxDisplay.getDefaultScreen());
            }
            catch (Throwable throwable) {
                try {
                    LinuxDisplay.decDisplay();
                    throw throwable;
                }
                catch (LWJGLException e2) {
                    LWJGLUtil.log("Exception occurred in getPbufferCapabilities: " + e2);
                    int n3 = 0;
                    return n3;
                }
            }
            LinuxDisplay.decDisplay();
            return n2;
        }
        finally {
            LinuxDisplay.unlockAWT();
        }
    }

    private static native int nGetPbufferCapabilities(long var0, int var2);

    public boolean isBufferLost(PeerInfo handle) {
        return false;
    }

    public PeerInfo createPbuffer(int width, int height, PixelFormat pixel_format, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
        return new LinuxPbufferPeerInfo(width, height, pixel_format);
    }

    public void setPbufferAttrib(PeerInfo handle, int attrib, int value) {
        throw new UnsupportedOperationException();
    }

    public void bindTexImageToPbuffer(PeerInfo handle, int buffer) {
        throw new UnsupportedOperationException();
    }

    public void releaseTexImageFromPbuffer(PeerInfo handle, int buffer) {
        throw new UnsupportedOperationException();
    }

    private static ByteBuffer convertIcon(ByteBuffer icon, int width, int height) {
        ByteBuffer icon_rgb = BufferUtils.createByteBuffer(icon.capacity());
        int depth = 4;
        for (int y2 = 0; y2 < height; ++y2) {
            for (int x2 = 0; x2 < width; ++x2) {
                byte r2 = icon.get(x2 * 4 + y2 * width * 4);
                byte g2 = icon.get(x2 * 4 + y2 * width * 4 + 1);
                byte b2 = icon.get(x2 * 4 + y2 * width * 4 + 2);
                icon_rgb.put(x2 * depth + y2 * width * depth, b2);
                icon_rgb.put(x2 * depth + y2 * width * depth + 1, g2);
                icon_rgb.put(x2 * depth + y2 * width * depth + 2, r2);
            }
        }
        return icon_rgb;
    }

    private static ByteBuffer convertIconMask(ByteBuffer icon, int width, int height) {
        ByteBuffer icon_mask = BufferUtils.createByteBuffer(icon.capacity() / 4 / 8);
        int depth = 4;
        for (int y2 = 0; y2 < height; ++y2) {
            for (int x2 = 0; x2 < width; ++x2) {
                byte a2 = icon.get(x2 * 4 + y2 * width * 4 + 3);
                int mask_index = x2 + y2 * width;
                int mask_byte_index = mask_index / 8;
                int mask_bit_index = mask_index % 8;
                int bit = (a2 & 0xFF) >= 127 ? 1 : 0;
                byte new_byte = (byte)((icon_mask.get(mask_byte_index) | bit << mask_bit_index) & 0xFF);
                icon_mask.put(mask_byte_index, new_byte);
            }
        }
        return icon_mask;
    }

    /*
     * Exception decompiling
     */
    public int setIcon(ByteBuffer[] icons) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    private static native void nSetWindowIcon(long var0, long var2, ByteBuffer var4, int var5, ByteBuffer var6, int var7, int var8, int var9);

    public int getWidth() {
        return Display.getDisplayMode().getWidth();
    }

    public int getHeight() {
        return Display.getDisplayMode().getHeight();
    }

    public boolean isInsideWindow() {
        return true;
    }

    static {
        display_connection_usage_count = 0;
    }
}

