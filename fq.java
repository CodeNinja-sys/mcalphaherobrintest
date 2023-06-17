/*
 * Decompiled with CFR 0.150.
 */
import java.util.HashMap;
import java.util.Map;

public class fq {
    private static Map a = new HashMap();
    private static Map b = new HashMap();
    private static Map c = new HashMap();
    private static Map d = new HashMap();

    private static void a(Class class_, String string, int n2) {
        a.put(string, class_);
        b.put(class_, string);
        c.put(n2, class_);
        d.put(class_, n2);
    }

    public static lw a(String string, cy cy2) {
        lw lw2 = null;
        try {
            Class class_ = (Class)a.get(string);
            if (class_ != null) {
                lw2 = (lw)class_.getConstructor(cy.class).newInstance(cy2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return lw2;
    }

    public static lw a(iq iq2, cy cy2) {
        lw lw2 = null;
        try {
            Class class_ = (Class)a.get(iq2.i("id"));
            if (class_ != null) {
                lw2 = (lw)class_.getConstructor(cy.class).newInstance(cy2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (lw2 != null) {
            lw2.e(iq2);
        } else {
            System.out.println("Skipping Entity with id " + iq2.i("id"));
        }
        return lw2;
    }

    public static lw a(int n2, cy cy2) {
        lw lw2 = null;
        try {
            Class class_ = (Class)c.get(n2);
            if (class_ != null) {
                lw2 = (lw)class_.getConstructor(cy.class).newInstance(cy2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (lw2 == null) {
            System.out.println("Skipping Entity with id " + n2);
        }
        return lw2;
    }

    public static int a(lw lw2) {
        return (Integer)d.get(lw2.getClass());
    }

    public static String b(lw lw2) {
        return (String)b.get(lw2.getClass());
    }

    static {
        fq.a(lv.class, "Arrow", 10);
        fq.a(at.class, "Snowball", 11);
        fq.a(eo.class, "Item", 1);
        fq.a(kp.class, "Painting", 9);
        fq.a(hf.class, "Mob", 48);
        fq.a(ef.class, "Monster", 49);
        fq.a(dq.class, "Creeper", 50);
        fq.a(dh.class, "Skeleton", 51);
        fq.a(be.class, "Spider", 52);
        fq.a(ip.class, "Giant", 53);
        fq.a(nt.class, "Zombie", 54);
        fq.a(ns.class, "Slime", 55);
        fq.a(am.class, "Ghast", 56);
        fq.a(pt.class, "PigZombie", 57);
        fq.a(op.class, "Pig", 90);
        fq.a(bx.class, "Sheep", 91);
        fq.a(as.class, "Cow", 92);
        fq.a(ou.class, "Chicken", 93);
        fq.a(kr.class, "PrimedTnt", 20);
        fq.a(gb.class, "FallingSand", 21);
        fq.a(qd.class, "Minecart", 40);
        fq.a(dp.class, "Boat", 41);
    }
}

