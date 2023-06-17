/*
 * Decompiled with CFR 0.150.
 */
class ph
extends Thread {
    final /* synthetic */ jq a;

    ph(jq jq2, String string) {
        this.a = jq2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void run() {
        Object object = jq.a;
        synchronized (object) {
            ++jq.c;
        }
        try {
            while (jq.a(this.a)) {
                jq.d(this.a);
            }
        }
        finally {
            object = jq.a;
            synchronized (object) {
                --jq.c;
            }
        }
    }
}

