/*
 * Decompiled with CFR 0.150.
 */
public class ct
extends bp {
    private String a;
    private String h;

    public ct(String string, String string2) {
        this.a = string;
        this.h = string2;
    }

    public void g() {
    }

    protected void a(char c2, int n2) {
    }

    public void a() {
        this.e.clear();
        this.e.add(new gh(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Back to title screen"));
    }

    protected void a(gh gh2) {
        if (gh2.f == 0) {
            this.b.a(new dj());
        }
    }

    public void a(int n2, int n3, float f2) {
        this.i();
        this.a(this.g, this.a, this.c / 2, this.d / 2 - 50, 0xFFFFFF);
        this.a(this.g, this.h, this.c / 2, this.d / 2 - 10, 0xFFFFFF);
        super.a(n2, n3, f2);
    }
}

