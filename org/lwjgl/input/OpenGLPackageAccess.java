/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.input;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.opengl.InputImplementation;

final class OpenGLPackageAccess {
    static final Object global_lock;
    static /* synthetic */ Class class$org$lwjgl$opengl$Display;

    OpenGLPackageAccess() {
    }

    static InputImplementation createImplementation() {
        try {
            return (InputImplementation)AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    Method getImplementation_method = (class$org$lwjgl$opengl$Display == null ? (class$org$lwjgl$opengl$Display = OpenGLPackageAccess.class$("org.lwjgl.opengl.Display")) : class$org$lwjgl$opengl$Display).getDeclaredMethod("getImplementation", null);
                    getImplementation_method.setAccessible(true);
                    return getImplementation_method.invoke(null, null);
                }
            });
        }
        catch (PrivilegedActionException e2) {
            throw new Error(e2);
        }
    }

    static {
        try {
            global_lock = AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    Field lock_field = Class.forName("org.lwjgl.opengl.GlobalLock").getDeclaredField("lock");
                    lock_field.setAccessible(true);
                    return lock_field.get(null);
                }
            });
        }
        catch (PrivilegedActionException e2) {
            throw new Error(e2);
        }
    }
}

