/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengl.AWTCanvasImplementation;
import org.lwjgl.opengl.Context;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.LinuxCanvasImplementation;
import org.lwjgl.opengl.MacOSXCanvasImplementation;
import org.lwjgl.opengl.PeerInfo;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.opengl.WindowsCanvasImplementation;

public class AWTGLCanvas
extends Canvas
implements Drawable,
ComponentListener,
HierarchyListener {
    private static final long serialVersionUID = 1L;
    private static final AWTCanvasImplementation implementation;
    private boolean update_context;
    private Object SYNC_LOCK = new Object();
    private final PixelFormat pixel_format;
    private final Drawable drawable;
    private final ContextAttribs attribs;
    private PeerInfo peer_info;
    private Context context;
    private int reentry_count;
    private boolean first_run;

    static AWTCanvasImplementation createImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1: {
                return new LinuxCanvasImplementation();
            }
            case 3: {
                return new WindowsCanvasImplementation();
            }
            case 2: {
                return new MacOSXCanvasImplementation();
            }
        }
        throw new IllegalStateException("Unsupported platform");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setUpdate() {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            this.update_context = true;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public AWTGLCanvas() throws LWJGLException {
        this(new PixelFormat());
    }

    public AWTGLCanvas(PixelFormat pixel_format) throws LWJGLException {
        this(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(), pixel_format);
    }

    public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
        this(device, pixel_format, null);
    }

    public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable) throws LWJGLException {
        this(device, pixel_format, drawable, null);
    }

    public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable, ContextAttribs attribs) throws LWJGLException {
        super(implementation.findConfiguration(device, pixel_format));
        if (pixel_format == null) {
            throw new NullPointerException("Pixel format must be non-null");
        }
        this.addHierarchyListener(this);
        this.addComponentListener(this);
        this.drawable = drawable;
        this.pixel_format = pixel_format;
        this.attribs = attribs;
    }

    public void addNotify() {
        super.addNotify();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void removeNotify() {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            this.destroyContext();
            super.removeNotify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setSwapInterval(int swap_interval) {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            Context.setSwapInterval(swap_interval);
        }
    }

    public void setVSyncEnabled(boolean enabled) {
        this.setSwapInterval(enabled ? 1 : 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void swapBuffers() throws LWJGLException {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            Context.swapBuffers();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void releaseContext() throws LWJGLException {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            if (this.context.isCurrent()) {
                Context.releaseCurrentContext();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void makeCurrent() throws LWJGLException {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            if (this.context == null) {
                throw new IllegalStateException("Canvas not yet displayable");
            }
            this.context.makeCurrent();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void destroyContext() {
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            try {
                if (this.context != null) {
                    this.context.forceDestroy();
                    this.context = null;
                    this.reentry_count = 0;
                    this.peer_info.destroy();
                    this.peer_info = null;
                }
            }
            catch (LWJGLException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    protected void initGL() {
    }

    protected void paintGL() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void paint(Graphics g2) {
        LWJGLException exception = null;
        Object object = this.SYNC_LOCK;
        synchronized (object) {
            if (!this.isDisplayable()) {
                return;
            }
            try {
                if (this.peer_info == null) {
                    this.peer_info = implementation.createPeerInfo(this, this.pixel_format);
                }
                this.peer_info.lockAndGetHandle();
                try {
                    if (this.context == null) {
                        this.context = new Context(this.peer_info, this.attribs, this.drawable != null ? this.drawable.getContext() : null);
                        this.first_run = true;
                    }
                    if (this.reentry_count == 0) {
                        this.context.makeCurrent();
                    }
                    ++this.reentry_count;
                    try {
                        if (this.update_context) {
                            this.context.update();
                            this.update_context = false;
                        }
                        if (this.first_run) {
                            this.first_run = false;
                            this.initGL();
                        }
                        this.paintGL();
                    }
                    finally {
                        --this.reentry_count;
                        if (this.reentry_count == 0) {
                            Context.releaseCurrentContext();
                        }
                    }
                }
                finally {
                    this.peer_info.unlock();
                }
            }
            catch (LWJGLException e2) {
                exception = e2;
            }
        }
        if (exception != null) {
            this.exceptionOccurred(exception);
        }
    }

    protected void exceptionOccurred(LWJGLException exception) {
        LWJGLUtil.log("Unhandled exception occurred, skipping paint(): " + exception);
    }

    public void update(Graphics g2) {
        this.paint(g2);
    }

    public void componentShown(ComponentEvent e2) {
    }

    public void componentHidden(ComponentEvent e2) {
    }

    public void componentResized(ComponentEvent e2) {
        this.setUpdate();
    }

    public void componentMoved(ComponentEvent e2) {
        this.setUpdate();
    }

    public void setLocation(int x2, int y2) {
        super.setLocation(x2, y2);
        this.setUpdate();
    }

    public void setLocation(Point p2) {
        super.setLocation(p2);
        this.setUpdate();
    }

    public void setSize(Dimension d2) {
        super.setSize(d2);
        this.setUpdate();
    }

    public void setSize(int width, int height) {
        super.setSize(width, height);
        this.setUpdate();
    }

    public void setBounds(int x2, int y2, int width, int height) {
        super.setBounds(x2, y2, width, height);
        this.setUpdate();
    }

    public void hierarchyChanged(HierarchyEvent e2) {
        this.setUpdate();
    }

    static {
        Sys.initialize();
        implementation = AWTGLCanvas.createImplementation();
    }
}

