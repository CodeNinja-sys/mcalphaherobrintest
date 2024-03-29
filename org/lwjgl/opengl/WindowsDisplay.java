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
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.AWTCanvasImplementation;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayImplementation;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PeerInfo;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.WindowsDisplayPeerInfo;
import org.lwjgl.opengl.WindowsFileVersion;
import org.lwjgl.opengl.WindowsKeyboard;
import org.lwjgl.opengl.WindowsMouse;
import org.lwjgl.opengl.WindowsPbufferPeerInfo;
import org.lwjgl.opengl.WindowsPeerInfo;
import org.lwjgl.opengl.WindowsRegistry;

final class WindowsDisplay
implements DisplayImplementation {
    private static final int GAMMA_LENGTH = 256;
    private static final int WM_CANCELMODE = 31;
    private static final int WM_MOUSEMOVE = 512;
    private static final int WM_LBUTTONDOWN = 513;
    private static final int WM_LBUTTONUP = 514;
    private static final int WM_LBUTTONDBLCLK = 515;
    private static final int WM_RBUTTONDOWN = 516;
    private static final int WM_RBUTTONUP = 517;
    private static final int WM_RBUTTONDBLCLK = 518;
    private static final int WM_MBUTTONDOWN = 519;
    private static final int WM_MBUTTONUP = 520;
    private static final int WM_MBUTTONDBLCLK = 521;
    private static final int WM_MOUSEWHEEL = 522;
    private static final int WM_CAPTURECHANGED = 533;
    private static final int WM_MOUSELEAVE = 675;
    private static final int WM_KEYDOWN = 256;
    private static final int WM_KEYUP = 257;
    private static final int WM_SYSKEYUP = 261;
    private static final int WM_SYSKEYDOWN = 260;
    private static final int WM_SYSCHAR = 262;
    private static final int WM_CHAR = 258;
    private static final int WM_SETICON = 128;
    private static final int WM_QUIT = 18;
    private static final int WM_SYSCOMMAND = 274;
    private static final int WM_PAINT = 15;
    private static final int WM_KILLFOCUS = 8;
    private static final int WM_SETFOCUS = 7;
    private static final int SC_SIZE = 61440;
    private static final int SC_MOVE = 61456;
    private static final int SC_MINIMIZE = 61472;
    private static final int SC_MAXIMIZE = 61488;
    private static final int SC_NEXTWINDOW = 61504;
    private static final int SC_PREVWINDOW = 61520;
    private static final int SC_CLOSE = 61536;
    private static final int SC_VSCROLL = 61552;
    private static final int SC_HSCROLL = 61568;
    private static final int SC_MOUSEMENU = 61584;
    private static final int SC_KEYMENU = 61696;
    private static final int SC_ARRANGE = 61712;
    private static final int SC_RESTORE = 61728;
    private static final int SC_TASKLIST = 61744;
    private static final int SC_SCREENSAVE = 61760;
    private static final int SC_HOTKEY = 61776;
    private static final int SC_DEFAULT = 61792;
    private static final int SC_MONITORPOWER = 61808;
    private static final int SC_CONTEXTHELP = 61824;
    private static final int SC_SEPARATOR = 61455;
    static final int SM_CXCURSOR = 13;
    static final int SM_CYCURSOR = 14;
    static final int SM_CMOUSEBUTTONS = 43;
    static final int SM_MOUSEWHEELPRESENT = 75;
    private static final int SIZE_RESTORED = 0;
    private static final int SIZE_MINIMIZED = 1;
    private static final int SIZE_MAXIMIZED = 2;
    private static final int WM_SIZE = 5;
    private static final int WM_ACTIVATE = 6;
    private static final int WA_INACTIVE = 0;
    private static final int WA_ACTIVE = 1;
    private static final int WA_CLICKACTIVE = 2;
    private static final int SW_SHOWMINNOACTIVE = 7;
    private static final int SW_SHOWDEFAULT = 10;
    private static final int SW_RESTORE = 9;
    private static final int ICON_SMALL = 0;
    private static final int ICON_BIG = 1;
    private static final IntBuffer rect_buffer = BufferUtils.createIntBuffer(4);
    private static final Rect rect = new Rect();
    private static final Rect rect2 = new Rect();
    private static WindowsDisplay current_display;
    private static boolean cursor_clipped;
    private WindowsDisplayPeerInfo peer_info;
    private Object current_cursor;
    private Canvas parent;
    private static boolean hasParent;
    private WindowsKeyboard keyboard;
    private WindowsMouse mouse;
    private boolean close_requested;
    private boolean is_dirty;
    private ByteBuffer current_gamma;
    private ByteBuffer saved_gamma;
    private DisplayMode current_mode;
    private boolean mode_set;
    private boolean isMinimized;
    private boolean isFocused;
    private boolean did_maximize;
    private boolean inAppActivate;
    private long hwnd;
    private long hdc;
    private long small_icon;
    private long large_icon;
    private int captureMouse = -1;
    private boolean trackingMouse = false;
    private boolean mouseInside = false;

    WindowsDisplay() {
        current_display = this;
    }

    public void createWindow(DisplayMode mode, Canvas parent, int x2, int y2) throws LWJGLException {
        this.close_requested = false;
        this.is_dirty = false;
        this.isMinimized = false;
        this.isFocused = false;
        this.did_maximize = false;
        this.parent = parent;
        hasParent = parent != null;
        long parent_hwnd = parent != null ? WindowsDisplay.getHwnd(parent) : 0L;
        this.hwnd = WindowsDisplay.nCreateWindow(x2, y2, mode.getWidth(), mode.getHeight(), Display.isFullscreen() || WindowsDisplay.isUndecorated(), parent != null, parent_hwnd);
        if (this.hwnd == 0L) {
            throw new LWJGLException("Failed to create window");
        }
        this.hdc = WindowsDisplay.getDC(this.hwnd);
        if (this.hdc == 0L) {
            WindowsDisplay.nDestroyWindow(this.hwnd);
            throw new LWJGLException("Failed to get dc");
        }
        try {
            int format = WindowsPeerInfo.choosePixelFormat(this.getHdc(), 0, 0, this.peer_info.getPixelFormat(), null, true, true, false, true);
            WindowsPeerInfo.setPixelFormat(this.getHdc(), format);
            this.peer_info.initDC(this.getHwnd(), this.getHdc());
            WindowsDisplay.showWindow(this.getHwnd(), 10);
            if (parent == null) {
                WindowsDisplay.setForegroundWindow(this.getHwnd());
                WindowsDisplay.setFocus(this.getHwnd());
            }
        }
        catch (LWJGLException e2) {
            WindowsDisplay.nReleaseDC(this.hwnd, this.hdc);
            WindowsDisplay.nDestroyWindow(this.hwnd);
            throw e2;
        }
    }

    private static native long nCreateWindow(int var0, int var1, int var2, int var3, boolean var4, boolean var5, long var6) throws LWJGLException;

    private static boolean isUndecorated() {
        return Display.getPrivilegedBoolean("org.lwjgl.opengl.Window.undecorated");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static long getHwnd(Canvas parent) throws LWJGLException {
        AWTCanvasImplementation awt_impl = AWTGLCanvas.createImplementation();
        WindowsPeerInfo parent_peer_info = (WindowsPeerInfo)awt_impl.createPeerInfo(parent, null);
        ByteBuffer parent_peer_info_handle = parent_peer_info.lockAndGetHandle();
        try {
            long l2 = parent_peer_info.getHwnd();
            return l2;
        }
        finally {
            parent_peer_info.unlock();
        }
    }

    public void destroyWindow() {
        WindowsDisplay.nReleaseDC(this.hwnd, this.hdc);
        WindowsDisplay.nDestroyWindow(this.hwnd);
        this.freeLargeIcon();
        this.freeSmallIcon();
        WindowsDisplay.resetCursorClipping();
    }

    private static native void nReleaseDC(long var0, long var2);

    private static native void nDestroyWindow(long var0);

    static void resetCursorClipping() {
        if (cursor_clipped) {
            try {
                WindowsDisplay.clipCursor(null);
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Failed to reset cursor clipping: " + e2);
            }
            cursor_clipped = false;
        }
    }

    private static void getGlobalClientRect(long hwnd, Rect rect) {
        rect_buffer.put(0, 0).put(1, 0);
        WindowsDisplay.clientToScreen(hwnd, rect_buffer);
        int offset_x = rect_buffer.get(0);
        int offset_y = rect_buffer.get(1);
        WindowsDisplay.getClientRect(hwnd, rect_buffer);
        rect.copyFromBuffer(rect_buffer);
        rect.offset(offset_x, offset_y);
    }

    static void setupCursorClipping(long hwnd) throws LWJGLException {
        cursor_clipped = true;
        WindowsDisplay.getGlobalClientRect(hwnd, rect);
        rect.copyToBuffer(rect_buffer);
        WindowsDisplay.clipCursor(rect_buffer);
    }

    private static native void clipCursor(IntBuffer var0) throws LWJGLException;

    public void switchDisplayMode(DisplayMode mode) throws LWJGLException {
        WindowsDisplay.nSwitchDisplayMode(mode);
        this.current_mode = mode;
        this.mode_set = true;
    }

    private static native void nSwitchDisplayMode(DisplayMode var0) throws LWJGLException;

    private void appActivate(boolean active) {
        if (this.inAppActivate) {
            return;
        }
        this.inAppActivate = true;
        this.isFocused = active;
        if (active) {
            if (Display.isFullscreen()) {
                this.restoreDisplayMode();
            }
            if (this.parent == null) {
                WindowsDisplay.showWindow(this.getHwnd(), 9);
                WindowsDisplay.setForegroundWindow(this.getHwnd());
                WindowsDisplay.setFocus(this.getHwnd());
            }
            this.did_maximize = true;
            if (Display.isFullscreen()) {
                this.updateClipping();
            }
        } else if (Display.isFullscreen()) {
            WindowsDisplay.showWindow(this.getHwnd(), 7);
            this.resetDisplayMode();
        } else {
            this.updateClipping();
        }
        this.updateCursor();
        this.inAppActivate = false;
    }

    private static native void showWindow(long var0, int var2);

    private static native void setForegroundWindow(long var0);

    private static native void setFocus(long var0);

    private void restoreDisplayMode() {
        try {
            this.doSetGammaRamp(this.current_gamma);
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Failed to restore gamma: " + e2.getMessage());
        }
        if (!this.mode_set) {
            this.mode_set = true;
            try {
                WindowsDisplay.nSwitchDisplayMode(this.current_mode);
            }
            catch (LWJGLException e3) {
                LWJGLUtil.log("Failed to restore display mode: " + e3.getMessage());
            }
        }
    }

    public void resetDisplayMode() {
        try {
            this.doSetGammaRamp(this.saved_gamma);
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Failed to reset gamma ramp: " + e2.getMessage());
        }
        this.current_gamma = this.saved_gamma;
        if (this.mode_set) {
            this.mode_set = false;
            WindowsDisplay.nResetDisplayMode();
        }
        WindowsDisplay.resetCursorClipping();
    }

    private static native void nResetDisplayMode();

    public int getGammaRampLength() {
        return 256;
    }

    public void setGammaRamp(FloatBuffer gammaRamp) throws LWJGLException {
        this.doSetGammaRamp(WindowsDisplay.convertToNativeRamp(gammaRamp));
    }

    private static native ByteBuffer convertToNativeRamp(FloatBuffer var0) throws LWJGLException;

    private static native ByteBuffer getCurrentGammaRamp() throws LWJGLException;

    private void doSetGammaRamp(ByteBuffer native_gamma) throws LWJGLException {
        WindowsDisplay.nSetGammaRamp(native_gamma);
        this.current_gamma = native_gamma;
    }

    private static native void nSetGammaRamp(ByteBuffer var0) throws LWJGLException;

    public String getAdapter() {
        try {
            String maxObjNo = WindowsRegistry.queryRegistrationKey(3, "HARDWARE\\DeviceMap\\Video", "MaxObjectNumber");
            int maxObjectNumber = maxObjNo.charAt(0);
            String vga_driver_value = "";
            for (int i2 = 0; i2 < maxObjectNumber; ++i2) {
                String adapter_string = WindowsRegistry.queryRegistrationKey(3, "HARDWARE\\DeviceMap\\Video", "\\Device\\Video" + i2);
                String root_key = "\\registry\\machine\\";
                if (!adapter_string.toLowerCase().startsWith(root_key)) continue;
                String driver_value = WindowsRegistry.queryRegistrationKey(3, adapter_string.substring(root_key.length()), "InstalledDisplayDrivers");
                if (driver_value.toUpperCase().startsWith("VGA")) {
                    vga_driver_value = driver_value;
                    continue;
                }
                if (driver_value.toUpperCase().startsWith("RDP") || driver_value.toUpperCase().startsWith("NMNDD")) continue;
                return driver_value;
            }
            if (!vga_driver_value.equals("")) {
                return vga_driver_value;
            }
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Exception occurred while querying registry: " + e2);
        }
        return null;
    }

    public String getVersion() {
        WindowsFileVersion version;
        String[] drivers;
        String driver = this.getAdapter();
        if (driver != null && (drivers = driver.split(",")).length > 0 && (version = this.nGetVersion(drivers[0] + ".dll")) != null) {
            return version.toString();
        }
        return null;
    }

    private native WindowsFileVersion nGetVersion(String var1);

    public DisplayMode init() throws LWJGLException {
        this.current_gamma = this.saved_gamma = WindowsDisplay.getCurrentGammaRamp();
        this.current_mode = WindowsDisplay.getCurrentDisplayMode();
        return this.current_mode;
    }

    private static native DisplayMode getCurrentDisplayMode() throws LWJGLException;

    public void setTitle(String title) {
        WindowsDisplay.nSetTitle(this.hwnd, title);
    }

    private static native void nSetTitle(long var0, String var2);

    public boolean isCloseRequested() {
        boolean saved = this.close_requested;
        this.close_requested = false;
        return saved;
    }

    public boolean isVisible() {
        return !this.isMinimized;
    }

    public boolean isActive() {
        return this.isFocused;
    }

    public boolean isDirty() {
        boolean saved = this.is_dirty;
        this.is_dirty = false;
        return saved;
    }

    public PeerInfo createPeerInfo(PixelFormat pixel_format) throws LWJGLException {
        this.peer_info = new WindowsDisplayPeerInfo(pixel_format);
        return this.peer_info;
    }

    public void update() {
        WindowsDisplay.nUpdate();
        if (this.parent != null && this.parent.isFocusOwner()) {
            WindowsDisplay.setFocus(this.getHwnd());
        }
        if (this.did_maximize) {
            this.did_maximize = false;
            try {
                if (Display.getDrawable().getContext() != null && Display.getDrawable().getContext().isCurrent()) {
                    Display.getDrawable().getContext().makeCurrent();
                }
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Exception occurred while trying to make context current: " + e2);
            }
        }
    }

    private static native void nUpdate();

    public void reshape(int x2, int y2, int width, int height) {
        WindowsDisplay.nReshape(this.getHwnd(), x2, y2, width, height, Display.isFullscreen() || WindowsDisplay.isUndecorated(), this.parent != null);
    }

    private static native void nReshape(long var0, int var2, int var3, int var4, int var5, boolean var6, boolean var7);

    public native DisplayMode[] getAvailableDisplayModes() throws LWJGLException;

    public boolean hasWheel() {
        return this.mouse.hasWheel();
    }

    public int getButtonCount() {
        return this.mouse.getButtonCount();
    }

    public void createMouse() throws LWJGLException {
        this.mouse = new WindowsMouse(this.getHwnd());
    }

    public void destroyMouse() {
        if (this.mouse != null) {
            this.mouse.destroy();
        }
        this.mouse = null;
    }

    public void pollMouse(IntBuffer coord_buffer, ByteBuffer buttons) {
        this.mouse.poll(coord_buffer, buttons);
    }

    public void readMouse(ByteBuffer buffer) {
        this.mouse.read(buffer);
    }

    public void grabMouse(boolean grab) {
        this.mouse.grab(grab, this.shouldGrab());
        this.updateCursor();
    }

    public int getNativeCursorCapabilities() {
        return 1;
    }

    public void setCursorPosition(int x2, int y2) {
        WindowsDisplay.getGlobalClientRect(this.getHwnd(), rect);
        int transformed_x = WindowsDisplay.rect.left + x2;
        int transformed_y = WindowsDisplay.rect.bottom - 1 - y2;
        WindowsDisplay.nSetCursorPosition(transformed_x, transformed_y);
        this.setMousePosition(x2, y2);
    }

    private static native void nSetCursorPosition(int var0, int var1);

    public void setNativeCursor(Object handle) throws LWJGLException {
        this.current_cursor = handle;
        this.updateCursor();
    }

    private void updateCursor() {
        try {
            if (this.mouse != null && this.shouldGrab()) {
                WindowsDisplay.nSetNativeCursor(this.getHwnd(), this.mouse.getBlankCursor());
            } else {
                WindowsDisplay.nSetNativeCursor(this.getHwnd(), this.current_cursor);
            }
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Failed to update cursor: " + e2);
        }
    }

    static native void nSetNativeCursor(long var0, Object var2) throws LWJGLException;

    public int getMinCursorSize() {
        return WindowsDisplay.getSystemMetrics(13);
    }

    public int getMaxCursorSize() {
        return WindowsDisplay.getSystemMetrics(13);
    }

    static native int getSystemMetrics(int var0);

    private static native long getDllInstance();

    private long getHwnd() {
        return this.hwnd;
    }

    private long getHdc() {
        return this.hdc;
    }

    private static native long getDC(long var0);

    private static native long getDesktopWindow();

    private static native long getForegroundWindow();

    static void centerCursor(long hwnd) {
        if (WindowsDisplay.getForegroundWindow() != hwnd && !hasParent) {
            return;
        }
        WindowsDisplay.getGlobalClientRect(hwnd, rect);
        int local_offset_x = WindowsDisplay.rect.left;
        int local_offset_y = WindowsDisplay.rect.top;
        int center_x = (WindowsDisplay.rect.left + WindowsDisplay.rect.right) / 2;
        int center_y = (WindowsDisplay.rect.top + WindowsDisplay.rect.bottom) / 2;
        WindowsDisplay.nSetCursorPosition(center_x, center_y);
        int local_x = center_x - local_offset_x;
        int local_y = center_y - local_offset_y;
        if (current_display != null) {
            current_display.setMousePosition(local_x, WindowsDisplay.transformY(hwnd, local_y));
        }
    }

    private void setMousePosition(int x2, int y2) {
        if (this.mouse != null) {
            this.mouse.setPosition(x2, y2);
        }
    }

    public void createKeyboard() throws LWJGLException {
        this.keyboard = new WindowsKeyboard(this.getHwnd());
    }

    public void destroyKeyboard() {
        this.keyboard.destroy();
        this.keyboard = null;
    }

    public void pollKeyboard(ByteBuffer keyDownBuffer) {
        this.keyboard.poll(keyDownBuffer);
    }

    public void readKeyboard(ByteBuffer buffer) {
        this.keyboard.read(buffer);
    }

    public static native ByteBuffer nCreateCursor(int var0, int var1, int var2, int var3, int var4, IntBuffer var5, int var6, IntBuffer var7, int var8) throws LWJGLException;

    public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        return WindowsDisplay.doCreateCursor(width, height, xHotspot, yHotspot, numImages, images, delays);
    }

    static Object doCreateCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
        return WindowsDisplay.nCreateCursor(width, height, xHotspot, yHotspot, numImages, images, images.position(), delays, delays != null ? delays.position() : -1);
    }

    public void destroyCursor(Object cursorHandle) {
        WindowsDisplay.doDestroyCursor(cursorHandle);
    }

    static native void doDestroyCursor(Object var0);

    public int getPbufferCapabilities() {
        try {
            return this.nGetPbufferCapabilities(new PixelFormat(0, 0, 0, 0, 0, 0, 0, 0, false));
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Exception occurred while determining pbuffer capabilities: " + e2);
            return 0;
        }
    }

    private native int nGetPbufferCapabilities(PixelFormat var1) throws LWJGLException;

    public boolean isBufferLost(PeerInfo handle) {
        return ((WindowsPbufferPeerInfo)handle).isBufferLost();
    }

    public PeerInfo createPbuffer(int width, int height, PixelFormat pixel_format, IntBuffer pixelFormatCaps, IntBuffer pBufferAttribs) throws LWJGLException {
        return new WindowsPbufferPeerInfo(width, height, pixel_format, pixelFormatCaps, pBufferAttribs);
    }

    public void setPbufferAttrib(PeerInfo handle, int attrib, int value) {
        ((WindowsPbufferPeerInfo)handle).setPbufferAttrib(attrib, value);
    }

    public void bindTexImageToPbuffer(PeerInfo handle, int buffer) {
        ((WindowsPbufferPeerInfo)handle).bindTexImageToPbuffer(buffer);
    }

    public void releaseTexImageFromPbuffer(PeerInfo handle, int buffer) {
        ((WindowsPbufferPeerInfo)handle).releaseTexImageFromPbuffer(buffer);
    }

    private void freeSmallIcon() {
        if (this.small_icon != 0L) {
            WindowsDisplay.destroyIcon(this.small_icon);
            this.small_icon = 0L;
        }
    }

    private void freeLargeIcon() {
        if (this.large_icon != 0L) {
            WindowsDisplay.destroyIcon(this.large_icon);
            this.large_icon = 0L;
        }
    }

    public int setIcon(ByteBuffer[] icons) {
        boolean done_small = false;
        boolean done_large = false;
        int used = 0;
        int small_icon_size = 16;
        int large_icon_size = 32;
        for (int i2 = 0; i2 < icons.length; ++i2) {
            int size = icons[i2].limit() / 4;
            if ((int)Math.sqrt(size) == small_icon_size && !done_small) {
                this.freeSmallIcon();
                this.small_icon = WindowsDisplay.createIcon(small_icon_size, small_icon_size, icons[i2].asIntBuffer());
                WindowsDisplay.sendMessage(this.hwnd, 128L, 0L, this.small_icon);
                ++used;
                done_small = true;
            }
            if ((int)Math.sqrt(size) != large_icon_size || done_large) continue;
            this.freeLargeIcon();
            this.large_icon = WindowsDisplay.createIcon(large_icon_size, large_icon_size, icons[i2].asIntBuffer());
            WindowsDisplay.sendMessage(this.hwnd, 128L, 1L, this.large_icon);
            ++used;
            done_large = true;
        }
        return used;
    }

    private static native long createIcon(int var0, int var1, IntBuffer var2);

    private static native void destroyIcon(long var0);

    private static native long sendMessage(long var0, long var2, long var4, long var6);

    private void handleMouseButton(int button, int state, long millis) {
        if (this.mouse != null) {
            this.mouse.handleMouseButton((byte)button, (byte)state, millis);
            if (this.captureMouse == -1 && button != -1 && state == 1) {
                this.captureMouse = button;
                WindowsDisplay.nSetCapture(this.hwnd);
            }
            if (this.captureMouse != -1 && button == this.captureMouse && state == 0) {
                this.captureMouse = -1;
                WindowsDisplay.nReleaseCapture();
            }
        }
        if (this.parent != null && !this.isFocused) {
            WindowsDisplay.setFocus(this.getHwnd());
        }
    }

    private boolean shouldGrab() {
        return !this.isMinimized && this.isFocused && Mouse.isGrabbed();
    }

    private void handleMouseMoved(int x2, int y2, long millis) {
        if (this.mouse != null) {
            this.mouse.handleMouseMoved(x2, y2, millis, this.shouldGrab());
        }
    }

    private static native long nSetCapture(long var0);

    private static native boolean nReleaseCapture();

    private void handleMouseScrolled(int amount, long millis) {
        if (this.mouse != null) {
            this.mouse.handleMouseScrolled(amount, millis);
        }
    }

    private static native void getClientRect(long var0, IntBuffer var2);

    private void handleChar(long wParam, long lParam, long millis) {
        boolean repeat;
        byte state = (byte)(1L - (lParam >>> 31 & 1L));
        byte previous_state = (byte)(lParam >>> 30 & 1L);
        boolean bl2 = repeat = state == previous_state;
        if (this.keyboard != null) {
            this.keyboard.handleChar((int)(wParam & 0xFFL), millis, repeat);
        }
    }

    private void handleKeyButton(long wParam, long lParam, long millis) {
        byte state = (byte)(1L - (lParam >>> 31 & 1L));
        byte previous_state = (byte)(lParam >>> 30 & 1L);
        boolean repeat = state == previous_state;
        byte extended = (byte)(lParam >>> 24 & 1L);
        int scan_code = (int)(lParam >>> 16 & 0xFFL);
        if (this.keyboard != null) {
            this.keyboard.handleKey((int)wParam, scan_code, extended != 0, state, millis, repeat);
            if (this.captureMouse != -1 && this.keyboard.isKeyDown(1)) {
                WindowsDisplay.nReleaseCapture();
                this.captureMouse = -1;
            }
        }
    }

    private static int transformY(long hwnd, int y2) {
        WindowsDisplay.getClientRect(hwnd, rect_buffer);
        rect.copyFromBuffer(rect_buffer);
        return WindowsDisplay.rect.bottom - WindowsDisplay.rect.top - 1 - y2;
    }

    private static native void clientToScreen(long var0, IntBuffer var2);

    private static int handleMessage(long hwnd, int msg, long wParam, long lParam, long millis) {
        if (current_display != null) {
            return current_display.doHandleMessage(hwnd, msg, wParam, lParam, millis);
        }
        return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
    }

    private static native int defWindowProc(long var0, int var2, long var3, long var5);

    private void checkCursorState() {
        this.updateClipping();
    }

    private void updateClipping() {
        if ((Display.isFullscreen() || this.mouse != null && this.mouse.isGrabbed()) && !this.isMinimized && this.isFocused && (WindowsDisplay.getForegroundWindow() == this.getHwnd() || hasParent)) {
            try {
                WindowsDisplay.setupCursorClipping(this.getHwnd());
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("setupCursorClipping failed: " + e2.getMessage());
            }
        } else {
            WindowsDisplay.resetCursorClipping();
        }
    }

    private void setMinimized(boolean m2) {
        this.isMinimized = m2;
        this.checkCursorState();
    }

    private int doHandleMessage(long hwnd, int msg, long wParam, long lParam, long millis) {
        switch (msg) {
            case 6: {
                switch ((int)wParam) {
                    case 1: 
                    case 2: {
                        this.appActivate(true);
                        break;
                    }
                    case 0: {
                        this.appActivate(false);
                    }
                }
                return 0;
            }
            case 5: {
                switch ((int)wParam) {
                    case 0: 
                    case 2: {
                        this.setMinimized(false);
                        break;
                    }
                    case 1: {
                        this.setMinimized(true);
                    }
                }
                return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
            }
            case 8: {
                this.appActivate(false);
                return 0;
            }
            case 7: {
                this.appActivate(true);
                return 0;
            }
            case 512: {
                short xPos = (short)(lParam & 0xFFFFL);
                int yPos = WindowsDisplay.transformY(this.getHwnd(), (short)(lParam >> 16 & 0xFFFFL));
                this.handleMouseMoved(xPos, yPos, millis);
                this.checkCursorState();
                this.mouseInside = true;
                if (!this.trackingMouse) {
                    this.trackingMouse = this.nTrackMouseEvent(hwnd);
                }
                return 0;
            }
            case 522: {
                short dwheel = (short)(wParam >> 16 & 0xFFFFL);
                this.handleMouseScrolled(dwheel, millis);
                return 0;
            }
            case 513: {
                this.handleMouseButton(0, 1, millis);
                return 0;
            }
            case 514: {
                this.handleMouseButton(0, 0, millis);
                return 0;
            }
            case 516: {
                this.handleMouseButton(1, 1, millis);
                return 0;
            }
            case 517: {
                this.handleMouseButton(1, 0, millis);
                return 0;
            }
            case 519: {
                this.handleMouseButton(2, 1, millis);
                return 0;
            }
            case 520: {
                this.handleMouseButton(2, 0, millis);
                return 0;
            }
            case 258: 
            case 262: {
                this.handleChar(wParam, lParam, millis);
                return 0;
            }
            case 257: 
            case 261: {
                if (wParam == 44L && this.keyboard != null && !this.keyboard.isKeyDown(183)) {
                    long fake_lparam = lParam & Integer.MAX_VALUE;
                    this.handleKeyButton(wParam, fake_lparam &= 0xFFFFFFFFBFFFFFFFL, millis);
                }
            }
            case 256: 
            case 260: {
                this.handleKeyButton(wParam, lParam, millis);
                return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
            }
            case 18: {
                this.close_requested = true;
                return 0;
            }
            case 274: {
                switch ((int)(wParam & 0xFFF0L)) {
                    case 61584: 
                    case 61696: 
                    case 61760: 
                    case 61808: {
                        return 0;
                    }
                    case 61536: {
                        this.close_requested = true;
                        return 0;
                    }
                }
                return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
            }
            case 15: {
                this.is_dirty = true;
                return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
            }
            case 675: {
                this.mouseInside = false;
                this.trackingMouse = false;
                return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
            }
            case 31: {
                WindowsDisplay.nReleaseCapture();
            }
            case 533: {
                if (this.captureMouse != -1) {
                    this.handleMouseButton(this.captureMouse, 0, millis);
                    this.captureMouse = -1;
                }
                return 0;
            }
        }
        return WindowsDisplay.defWindowProc(hwnd, msg, wParam, lParam);
    }

    public int getWidth() {
        return Display.getDisplayMode().getWidth();
    }

    public int getHeight() {
        return Display.getDisplayMode().getHeight();
    }

    private int firstMouseButtonDown() {
        for (int i2 = 0; i2 < Mouse.getButtonCount(); ++i2) {
            if (!Mouse.isButtonDown(i2)) continue;
            return i2;
        }
        return -1;
    }

    private native boolean nTrackMouseEvent(long var1);

    public boolean isInsideWindow() {
        return this.mouseInside;
    }

    static {
        hasParent = false;
    }

    private static final class Rect {
        public int top;
        public int bottom;
        public int left;
        public int right;

        private Rect() {
        }

        public void copyToBuffer(IntBuffer buffer) {
            buffer.put(0, this.top).put(1, this.bottom).put(2, this.left).put(3, this.right);
        }

        public void copyFromBuffer(IntBuffer buffer) {
            this.top = buffer.get(0);
            this.bottom = buffer.get(1);
            this.left = buffer.get(2);
            this.right = buffer.get(3);
        }

        public void offset(int offset_x, int offset_y) {
            this.left += offset_x;
            this.right += offset_x;
            this.top += offset_y;
            this.bottom += offset_y;
        }

        public static void intersect(Rect r1, Rect r2, Rect dst) {
            dst.top = Math.max(r1.top, r2.top);
            dst.bottom = Math.min(r1.bottom, r2.bottom);
            dst.left = Math.max(r1.left, r2.left);
            dst.right = Math.min(r1.right, r2.right);
        }

        public String toString() {
            return "Rect: top = " + this.top + " bottom = " + this.bottom + " left = " + this.left + " right = " + this.right;
        }
    }
}

