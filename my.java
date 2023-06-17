/*
 * Decompiled with CFR 0.150.
 */
class my
extends Thread {
    final /* synthetic */ ah a;

    my(ah ah2) {
        this.a = ah2;
    }

    public void run() {
        while (ah.a(this.a)) {
            this.a.d();
            try {
                Thread.sleep(1L);
            }
            catch (Exception exception) {}
        }
    }
}

