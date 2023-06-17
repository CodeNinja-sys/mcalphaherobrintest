/*
 * Decompiled with CFR 0.150.
 */
public class qc
extends ji {
    public String[] a = new String[]{"", "", "", ""};
    public int b = -1;

    public void b(iq iq2) {
        super.b(iq2);
        iq2.a("Text1", this.a[0]);
        iq2.a("Text2", this.a[1]);
        iq2.a("Text3", this.a[2]);
        iq2.a("Text4", this.a[3]);
    }

    public void a(iq iq2) {
        super.a(iq2);
        for (int i2 = 0; i2 < 4; ++i2) {
            this.a[i2] = iq2.i("Text" + (i2 + 1));
            if (this.a[i2].length() <= 15) continue;
            this.a[i2] = this.a[i2].substring(0, 15);
        }
    }
}

