/*
 * Decompiled with CFR 0.150.
 */
class pf
extends Thread {
    final /* synthetic */ jq a;

    pf(jq jq2, String string) {
        this.a = jq2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Object object = jq.a;
        synchronized (object) {
            ++jq.b;
        }
        try {
            while (jq.a(this.a) && !jq.b(this.a)) {
                jq.c(this.a);
            }
        }
        finally {
            object = jq.a;
            synchronized (object) {
                --jq.b;
            }
        }
    }
}

