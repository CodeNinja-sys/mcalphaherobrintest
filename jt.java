/*
 * Decompiled with CFR 0.150.
 */
import net.minecraft.client.Minecraft;

public class jt
extends iv {
    public jt(Minecraft minecraft) {
        super(minecraft);
        this.b = true;
    }

    public void b(eb eb2) {
        for (int i2 = 0; i2 < 9; ++i2) {
            if (eb2.e.a[i2] == null) {
                this.a.g.e.a[i2] = new fp(((nq)ea.a.get((int)i2)).bh);
                continue;
            }
            this.a.g.e.a[i2].a = 1;
        }
    }

    public boolean d() {
        return false;
    }

    public void a(cy cy2) {
        super.a(cy2);
    }

    public void c() {
    }
}

