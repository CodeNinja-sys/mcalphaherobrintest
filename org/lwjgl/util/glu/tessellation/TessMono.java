/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.GLUface;
import org.lwjgl.util.glu.tessellation.GLUhalfEdge;
import org.lwjgl.util.glu.tessellation.GLUmesh;
import org.lwjgl.util.glu.tessellation.Geom;
import org.lwjgl.util.glu.tessellation.Mesh;

class TessMono {
    static final /* synthetic */ boolean $assertionsDisabled;

    TessMono() {
    }

    static boolean __gl_meshTessellateMonoRegion(GLUface face) {
        GLUhalfEdge tempHalfEdge;
        GLUhalfEdge up = face.anEdge;
        if (!($assertionsDisabled || up.Lnext != up && up.Lnext.Lnext != up)) {
            throw new AssertionError();
        }
        while (Geom.VertLeq(up.Sym.Org, up.Org)) {
            up = up.Onext.Sym;
        }
        while (Geom.VertLeq(up.Org, up.Sym.Org)) {
            up = up.Lnext;
        }
        GLUhalfEdge lo2 = up.Onext.Sym;
        while (up.Lnext != lo2) {
            if (Geom.VertLeq(up.Sym.Org, lo2.Org)) {
                while (lo2.Lnext != up && (Geom.EdgeGoesLeft(lo2.Lnext) || Geom.EdgeSign(lo2.Org, lo2.Sym.Org, lo2.Lnext.Sym.Org) <= 0.0)) {
                    tempHalfEdge = Mesh.__gl_meshConnect(lo2.Lnext, lo2);
                    if (tempHalfEdge == null) {
                        return false;
                    }
                    lo2 = tempHalfEdge.Sym;
                }
                lo2 = lo2.Onext.Sym;
                continue;
            }
            while (lo2.Lnext != up && (Geom.EdgeGoesRight(up.Onext.Sym) || Geom.EdgeSign(up.Sym.Org, up.Org, up.Onext.Sym.Org) >= 0.0)) {
                tempHalfEdge = Mesh.__gl_meshConnect(up, up.Onext.Sym);
                if (tempHalfEdge == null) {
                    return false;
                }
                up = tempHalfEdge.Sym;
            }
            up = up.Lnext;
        }
        if (!$assertionsDisabled && lo2.Lnext == up) {
            throw new AssertionError();
        }
        while (lo2.Lnext.Lnext != up) {
            tempHalfEdge = Mesh.__gl_meshConnect(lo2.Lnext, lo2);
            if (tempHalfEdge == null) {
                return false;
            }
            lo2 = tempHalfEdge.Sym;
        }
        return true;
    }

    public static boolean __gl_meshTessellateInterior(GLUmesh mesh) {
        GLUface f2 = mesh.fHead.next;
        while (f2 != mesh.fHead) {
            GLUface next = f2.next;
            if (f2.inside && !TessMono.__gl_meshTessellateMonoRegion(f2)) {
                return false;
            }
            f2 = next;
        }
        return true;
    }

    public static void __gl_meshDiscardExterior(GLUmesh mesh) {
        GLUface f2 = mesh.fHead.next;
        while (f2 != mesh.fHead) {
            GLUface next = f2.next;
            if (!f2.inside) {
                Mesh.__gl_meshZapFace(f2);
            }
            f2 = next;
        }
    }

    public static boolean __gl_meshSetWindingNumber(GLUmesh mesh, int value, boolean keepOnlyBoundary) {
        GLUhalfEdge e2 = mesh.eHead.next;
        while (e2 != mesh.eHead) {
            GLUhalfEdge eNext = e2.next;
            if (e2.Sym.Lface.inside != e2.Lface.inside) {
                e2.winding = e2.Lface.inside ? value : -value;
            } else if (!keepOnlyBoundary) {
                e2.winding = 0;
            } else if (!Mesh.__gl_meshDelete(e2)) {
                return false;
            }
            e2 = eNext;
        }
        return true;
    }

    static {
        $assertionsDisabled = !TessMono.class.desiredAssertionStatus();
    }
}

