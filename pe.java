/*
 * Decompiled with CFR 0.150.
 */
class pe
extends Thread {
    final /* synthetic */ jq a;

    pe(jq jq2) {
        this.a = jq2;
    }

    public void run() {
        try {
            Thread.sleep(5000L);
            if (jq.e(this.a).isAlive()) {
                try {
                    jq.e(this.a).stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (jq.f(this.a).isAlive()) {
                try {
                    jq.f(this.a).stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

