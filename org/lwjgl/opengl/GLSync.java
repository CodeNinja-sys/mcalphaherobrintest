/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.PointerWrapper;

public final class GLSync
implements PointerWrapper {
    private final long sync;

    GLSync(long sync) {
        this.sync = sync;
    }

    public long getPointer() {
        return this.sync;
    }
}

