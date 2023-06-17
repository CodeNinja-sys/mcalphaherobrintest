/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.ReferencesStack;
import org.lwjgl.opengl.StateStack;

final class StateTracker {
    private ReferencesStack references_stack;
    private final StateStack attrib_stack = new StateStack(0);
    private boolean insideBeginEnd;

    StateTracker() {
    }

    void init() {
        this.references_stack = new ReferencesStack();
    }

    static void setBeginEnd(ContextCapabilities caps, boolean inside) {
        caps.tracker.insideBeginEnd = inside;
    }

    boolean isBeginEnd() {
        return this.insideBeginEnd;
    }

    static void popAttrib(ContextCapabilities caps) {
        caps.tracker.doPopAttrib();
    }

    private void doPopAttrib() {
        this.references_stack.popState(this.attrib_stack.popState());
    }

    static void pushAttrib(ContextCapabilities caps, int mask) {
        caps.tracker.doPushAttrib(mask);
    }

    private void doPushAttrib(int mask) {
        this.attrib_stack.pushState(mask);
        this.references_stack.pushState();
    }

    static ReferencesStack getReferencesStack(ContextCapabilities caps) {
        return caps.tracker.references_stack;
    }

    static void bindBuffer(ContextCapabilities caps, int target, int buffer) {
        ReferencesStack references_stack = StateTracker.getReferencesStack(caps);
        switch (target) {
            case 34963: {
                references_stack.getReferences().elementArrayBuffer = buffer;
                break;
            }
            case 34962: {
                references_stack.getReferences().arrayBuffer = buffer;
                break;
            }
            case 35051: {
                references_stack.getReferences().pixelPackBuffer = buffer;
                break;
            }
            case 35052: {
                references_stack.getReferences().pixelUnpackBuffer = buffer;
                break;
            }
            case 36671: {
                references_stack.getReferences().indirectBuffer = buffer;
            }
        }
    }
}

