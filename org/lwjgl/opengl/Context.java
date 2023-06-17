/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.ContextImplementation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.LinuxContextImplementation;
import org.lwjgl.opengl.MacOSXContextImplementation;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.PeerInfo;
import org.lwjgl.opengl.WindowsContextImplementation;

final class Context {
    private static final ContextImplementation implementation;
    private static final ThreadLocal current_context_local;
    private final ByteBuffer handle;
    private final PeerInfo peer_info;
    private final IntBuffer attribList;
    private final boolean forwardCompatible;
    private boolean destroyed;
    private boolean destroy_requested;
    private Thread thread;

    private static ContextImplementation createImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1: {
                return new LinuxContextImplementation();
            }
            case 3: {
                return new WindowsContextImplementation();
            }
            case 2: {
                return new MacOSXContextImplementation();
            }
        }
        throw new IllegalStateException("Unsupported platform");
    }

    PeerInfo getPeerInfo() {
        return this.peer_info;
    }

    static Context getCurrentContext() {
        return (Context)current_context_local.get();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Context(PeerInfo peer_info, ContextAttribs attribs, Context shared_context) throws LWJGLException {
        Context context_lock;
        Context context = context_lock = shared_context != null ? shared_context : this;
        synchronized (context) {
            if (shared_context != null && shared_context.destroyed) {
                throw new IllegalArgumentException("Shared context is destroyed");
            }
            GLContext.loadOpenGLLibrary();
            try {
                this.peer_info = peer_info;
                if (attribs != null) {
                    this.attribList = attribs.getAttribList();
                    this.forwardCompatible = attribs.isForwardCompatible();
                } else {
                    this.attribList = null;
                    this.forwardCompatible = false;
                }
                this.handle = implementation.create(peer_info, this.attribList, shared_context != null ? shared_context.handle : null);
            }
            catch (LWJGLException e2) {
                GLContext.unloadOpenGLLibrary();
                throw e2;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void releaseCurrentContext() throws LWJGLException {
        Context current_context = Context.getCurrentContext();
        if (current_context != null) {
            implementation.releaseCurrentContext();
            GLContext.useContext(null);
            current_context_local.set(null);
            Context context = current_context;
            synchronized (context) {
                current_context.thread = null;
                current_context.checkDestroy();
            }
        }
    }

    public synchronized void releaseDrawable() throws LWJGLException {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        implementation.releaseDrawable(this.getHandle());
    }

    public synchronized void update() {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        implementation.update(this.getHandle());
    }

    public static void swapBuffers() throws LWJGLException {
        implementation.swapBuffers();
    }

    private boolean canAccess() {
        return this.thread == null || Thread.currentThread() == this.thread;
    }

    private void checkAccess() {
        if (!this.canAccess()) {
            throw new IllegalStateException("From thread " + Thread.currentThread() + ": " + this.thread + " already has the context current");
        }
    }

    public synchronized void makeCurrent() throws LWJGLException {
        this.checkAccess();
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        this.thread = Thread.currentThread();
        current_context_local.set(this);
        implementation.makeCurrent(this.peer_info, this.handle);
        GLContext.useContext(this, this.forwardCompatible);
    }

    ByteBuffer getHandle() {
        return this.handle;
    }

    public synchronized boolean isCurrent() throws LWJGLException {
        if (this.destroyed) {
            throw new IllegalStateException("Context is destroyed");
        }
        return implementation.isCurrent(this.handle);
    }

    private void checkDestroy() {
        if (!this.destroyed && this.destroy_requested) {
            try {
                this.releaseDrawable();
                implementation.destroy(this.peer_info, this.handle);
                this.destroyed = true;
                this.thread = null;
                GLContext.unloadOpenGLLibrary();
            }
            catch (LWJGLException e2) {
                LWJGLUtil.log("Exception occurred while destroying context: " + e2);
            }
        }
    }

    public static void setSwapInterval(int value) {
        implementation.setSwapInterval(value);
    }

    public synchronized void forceDestroy() throws LWJGLException {
        this.checkAccess();
        this.destroy();
    }

    public synchronized void destroy() throws LWJGLException {
        if (this.destroyed) {
            return;
        }
        this.destroy_requested = true;
        boolean was_current = this.isCurrent();
        int error = 0;
        if (was_current) {
            if (GLContext.getCapabilities() != null && GLContext.getCapabilities().OpenGL11) {
                error = GL11.glGetError();
            }
            Context.releaseCurrentContext();
        }
        this.checkDestroy();
        if (was_current && error != 0) {
            throw new OpenGLException(error);
        }
    }

    static {
        current_context_local = new ThreadLocal();
        Sys.initialize();
        implementation = Context.createImplementation();
    }
}

