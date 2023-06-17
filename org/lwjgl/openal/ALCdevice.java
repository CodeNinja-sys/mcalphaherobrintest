/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.openal;

import java.util.HashMap;
import java.util.Iterator;
import org.lwjgl.openal.ALCcontext;

public final class ALCdevice {
    final long device;
    private boolean valid = false;
    private HashMap contexts = new HashMap();

    ALCdevice(long device) {
        this.device = device;
        this.valid = true;
    }

    public boolean equals(Object device) {
        if (device instanceof ALCdevice) {
            return ((ALCdevice)device).device == this.device;
        }
        return super.equals(device);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void addContext(ALCcontext context) {
        HashMap hashMap = this.contexts;
        synchronized (hashMap) {
            this.contexts.put(new Long(context.context), context);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void removeContext(ALCcontext context) {
        HashMap hashMap = this.contexts;
        synchronized (hashMap) {
            this.contexts.remove(new Long(context.context));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setInvalid() {
        this.valid = false;
        HashMap hashMap = this.contexts;
        synchronized (hashMap) {
            Iterator i2 = this.contexts.values().iterator();
            while (i2.hasNext()) {
                ALCcontext context = (ALCcontext)i2.next();
                context.setInvalid();
            }
        }
        this.contexts.clear();
    }

    public boolean isValid() {
        return this.valid;
    }
}

