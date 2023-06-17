/*
 * Decompiled with CFR 0.150.
 */
import java.io.File;
import java.util.Random;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class qg {
    private static SoundSystem a;
    private es b = new es();
    private es c = new es();
    private es d = new es();
    private int e = 0;
    private gq f;
    private static boolean g;
    private Random h = new Random();
    private int i = this.h.nextInt(12000);

    public void a(gq gq2) {
        this.c.b = false;
        this.f = gq2;
        if (!(g || gq2 != null && gq2.b == 0.0f && gq2.a == 0.0f)) {
            this.d();
        }
    }

    private void d() {
        try {
            float f2 = this.f.b;
            float f3 = this.f.a;
            this.f.b = 0.0f;
            this.f.a = 0.0f;
            this.f.b();
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
            SoundSystemConfig.setCodec("mus", fj.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            a = new SoundSystem();
            this.f.b = f2;
            this.f.a = f3;
            this.f.b();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            System.err.println("error linking with the LibraryJavaSound plug-in");
        }
        g = true;
    }

    public void a() {
        if (!(g || this.f.b == 0.0f && this.f.a == 0.0f)) {
            this.d();
        }
        if (this.f.a == 0.0f) {
            a.stop("BgMusic");
        } else {
            a.setVolume("BgMusic", this.f.a);
        }
    }

    public void b() {
        if (g) {
            a.cleanup();
        }
    }

    public void a(String string, File file) {
        this.b.a(string, file);
    }

    public void b(String string, File file) {
        this.c.a(string, file);
    }

    public void c(String string, File file) {
        this.d.a(string, file);
    }

    public void c() {
        if (!g || this.f.a == 0.0f) {
            return;
        }
        if (!a.playing("BgMusic") && !a.playing("streaming")) {
            if (this.i > 0) {
                --this.i;
                return;
            }
            al al2 = this.d.a();
            if (al2 != null) {
                this.i = this.h.nextInt(12000) + 12000;
                a.backgroundMusic("BgMusic", al2.b, al2.a, false);
                a.setVolume("BgMusic", this.f.a);
                a.play("BgMusic");
            }
        }
    }

    public void a(hf hf2, float f2) {
        if (!g || this.f.b == 0.0f) {
            return;
        }
        if (hf2 == null) {
            return;
        }
        float f3 = hf2.aE + (hf2.aC - hf2.aE) * f2;
        double d2 = hf2.at + (hf2.aw - hf2.at) * (double)f2;
        double d3 = hf2.au + (hf2.ax - hf2.au) * (double)f2;
        double d4 = hf2.av + (hf2.ay - hf2.av) * (double)f2;
        float f4 = fi.b((float)(-f3 * ((float)Math.PI / 180) - (float)Math.PI));
        float f5 = fi.a((float)(-f3 * ((float)Math.PI / 180) - (float)Math.PI));
        float f6 = -f5;
        float f7 = 0.0f;
        float f8 = -f4;
        float f9 = 0.0f;
        float f10 = 1.0f;
        float f11 = 0.0f;
        a.setListenerPosition((float)d2, (float)d3, (float)d4);
        a.setListenerOrientation(f6, f7, f8, f9, f10, f11);
    }

    public void a(String string, float f2, float f3, float f4, float f5, float f6) {
        if (!g || this.f.b == 0.0f) {
            return;
        }
        String string2 = "streaming";
        if (a.playing("streaming")) {
            a.stop("streaming");
        }
        if (string == null) {
            return;
        }
        al al2 = this.c.a(string);
        if (al2 != null && f5 > 0.0f) {
            if (a.playing("BgMusic")) {
                a.stop("BgMusic");
            }
            float f7 = 16.0f;
            a.newStreamingSource(true, string2, al2.b, al2.a, false, f2, f3, f4, 2, f7 * 4.0f);
            a.setVolume(string2, 0.5f * this.f.b);
            a.play(string2);
        }
    }

    public void b(String string, float f2, float f3, float f4, float f5, float f6) {
        if (!g || this.f.b == 0.0f) {
            return;
        }
        al al2 = this.b.a(string);
        if (al2 != null && f5 > 0.0f) {
            this.e = (this.e + 1) % 256;
            String string2 = "sound_" + this.e;
            float f7 = 16.0f;
            if (f5 > 1.0f) {
                f7 *= f5;
            }
            a.newSource(f5 > 1.0f, string2, al2.b, al2.a, false, f2, f3, f4, 2, f7);
            a.setPitch(string2, f6);
            if (f5 > 1.0f) {
                f5 = 1.0f;
            }
            a.setVolume(string2, f5 * this.f.b);
            a.play(string2);
        }
    }

    public void a(String string, float f2, float f3) {
        if (!g || this.f.b == 0.0f) {
            return;
        }
        al al2 = this.b.a(string);
        if (al2 != null) {
            this.e = (this.e + 1) % 256;
            String string2 = "sound_" + this.e;
            a.newSource(false, string2, al2.b, al2.a, false, 0.0f, 0.0f, 0.0f, 0, 0.0f);
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            a.setPitch(string2, f3);
            a.setVolume(string2, (f2 *= 0.25f) * this.f.b);
            a.play(string2);
        }
    }

    static {
        g = false;
    }
}

