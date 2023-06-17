/*
 * Decompiled with CFR 0.150.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class en {
    private static final en a = new en();
    private List b = new ArrayList();

    public static final en a() {
        return a;
    }

    private en() {
        new eg().a(this);
        new pa().a(this);
        new mv().a(this);
        new iw().a(this);
        new gf().a(this);
        new o().a(this);
        this.a(new fp(dx.aI, 3), "###", Character.valueOf('#'), dx.aH);
        this.a(new fp(dx.aJ, 1), "#", "#", "#", Character.valueOf('#'), dx.aI);
        this.a(new fp(nq.aZ, 2), "###", "###", Character.valueOf('#'), dx.B);
        this.a(new fp(nq.aY, 1), "###", "#X#", "###", Character.valueOf('#'), nq.x, Character.valueOf('X'), dx.l);
        this.a(new fp(nq.an, 1), "###", "XXX", "###", Character.valueOf('#'), nq.x, Character.valueOf('X'), dx.aJ);
        this.a(new fp(nq.aU, 1), "##", "##", Character.valueOf('#'), dx.aB);
        this.a(new fp(nq.aW, 1), "##", "##", Character.valueOf('#'), dx.aG);
        this.a(new fp(nq.al, 1), "##", "##", Character.valueOf('#'), dx.aF);
        this.a(new fp(nq.bd, 1), "###", "###", "###", Character.valueOf('#'), dx.aR);
        this.a(new fp(nq.ab, 1), "###", "###", "###", Character.valueOf('#'), dx.I);
        this.a(new fp(nq.am, 1), "X#X", "#X#", "X#X", Character.valueOf('X'), dx.K, Character.valueOf('#'), nq.E);
        this.a(new fp(nq.ak, 3), "###", Character.valueOf('#'), nq.w);
        this.a(new fp(nq.aF, 1), "# #", "###", "# #", Character.valueOf('#'), dx.B);
        this.a(new fp(dx.at, 1), "##", "##", "##", Character.valueOf('#'), nq.x);
        this.a(new fp(dx.az, 1), "##", "##", "##", Character.valueOf('#'), dx.m);
        this.a(new fp(dx.as, 1), "###", "###", " X ", Character.valueOf('#'), nq.x, Character.valueOf('X'), dx.B);
        this.a(new fp(nq.x, 4), "#", Character.valueOf('#'), nq.J);
        this.a(new fp(dx.B, 4), "#", "#", Character.valueOf('#'), nq.x);
        this.a(new fp(nq.aq, 4), "X", "#", Character.valueOf('X'), dx.k, Character.valueOf('#'), dx.B);
        this.a(new fp(dx.C, 4), "# #", " # ", Character.valueOf('#'), nq.x);
        this.a(new fp(nq.aG, 16), "X X", "X#X", "X X", Character.valueOf('X'), dx.m, Character.valueOf('#'), dx.B);
        this.a(new fp(dx.ax, 1), "# #", "###", Character.valueOf('#'), dx.m);
        this.a(new fp(nq.bf, 1), "A", "B", Character.valueOf('A'), nq.ba, Character.valueOf('B'), nq.aq);
        this.a(new fp(dx.aL, 1), "A", "B", Character.valueOf('A'), nq.au, Character.valueOf('B'), dx.ax);
        this.a(new fp(dx.aM, 1), "A", "B", Character.valueOf('A'), nq.aB, Character.valueOf('B'), dx.ax);
        this.a(new fp(dx.aC, 1), "# #", "###", Character.valueOf('#'), nq.x);
        this.a(new fp(dx.au, 1), "# #", " # ", Character.valueOf('#'), dx.m);
        this.a(new fp(dx.g, 1), "A ", " B", Character.valueOf('A'), dx.m, Character.valueOf('B'), dx.an);
        this.a(new fp(dx.S, 1), "###", Character.valueOf('#'), dx.R);
        this.a(new fp(nq.at, 4), "#  ", "## ", "###", Character.valueOf('#'), nq.x);
        this.a(new fp(dx.aP, 1), "  #", " #X", "# X", Character.valueOf('#'), dx.B, Character.valueOf('X'), dx.I);
        this.a(new fp(nq.aH, 4), "#  ", "## ", "###", Character.valueOf('#'), nq.w);
        this.a(new fp(dx.aq, 1), "###", "#X#", "###", Character.valueOf('#'), dx.B, Character.valueOf('X'), nq.ab);
        this.a(new fp(dx.ar, 1), "###", "#X#", "###", Character.valueOf('#'), nq.ah, Character.valueOf('X'), dx.h);
        this.a(new fp(nq.aJ, 1), "X", "#", Character.valueOf('#'), nq.w, Character.valueOf('X'), dx.B);
        this.a(new fp(nq.aQ, 1), "X", "#", Character.valueOf('#'), dx.B, Character.valueOf('X'), dx.aA);
        this.a(new fp(dx.aQ, 1), " # ", "#X#", " # ", Character.valueOf('#'), dx.n, Character.valueOf('X'), dx.aA);
        this.a(new fp(dx.aO, 1), " # ", "#X#", " # ", Character.valueOf('#'), dx.m, Character.valueOf('X'), dx.aA);
        this.a(new fp(nq.aR, 1), "#", "#", Character.valueOf('#'), nq.t);
        this.a(new fp(nq.aK, 1), "###", Character.valueOf('#'), nq.t);
        this.a(new fp(nq.aM, 1), "###", Character.valueOf('#'), nq.x);
        Collections.sort(this.b, new gr(this));
        System.out.println(this.b.size() + " recipes");
    }

    void a(fp fp2, Object ... arrobject) {
        Object object;
        String string = "";
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (arrobject[n2] instanceof String[]) {
            object = (String[])arrobject[n2++];
            for (int i2 = 0; i2 < ((String[])object).length; ++i2) {
                Object object2 = object[i2];
                ++n4;
                n3 = ((String)object2).length();
                string = string + (String)object2;
            }
        } else {
            while (arrobject[n2] instanceof String) {
                object = (String)arrobject[n2++];
                ++n4;
                n3 = ((String)object).length();
                string = string + (String)object;
            }
        }
        object = new HashMap();
        while (n2 < arrobject.length) {
            Character c2 = (Character)arrobject[n2];
            int n5 = 0;
            if (arrobject[n2 + 1] instanceof dx) {
                n5 = ((dx)arrobject[n2 + 1]).aW;
            } else if (arrobject[n2 + 1] instanceof nq) {
                n5 = ((nq)arrobject[n2 + 1]).bh;
            }
            object.put(c2, n5);
            n2 += 2;
        }
        int[] arrn = new int[n3 * n4];
        for (int i3 = 0; i3 < n3 * n4; ++i3) {
            char c3 = string.charAt(i3);
            arrn[i3] = object.containsKey(Character.valueOf(c3)) ? (Integer)object.get(Character.valueOf(c3)) : -1;
        }
        this.b.add(new cd(n3, n4, arrn, fp2));
    }

    public fp a(int[] arrn) {
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            cd cd2 = (cd)this.b.get(i2);
            if (!cd2.a(arrn)) continue;
            return cd2.b(arrn);
        }
        return null;
    }
}

