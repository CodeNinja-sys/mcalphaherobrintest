/*
 * Decompiled with CFR 0.150.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class mu
implements ai {
    private File a;
    private boolean b;

    public mu(File file, boolean bl2) {
        this.a = file;
        this.b = bl2;
    }

    private File a(int n2, int n3) {
        String string = "c." + Integer.toString(n2, 36) + "." + Integer.toString(n3, 36) + ".dat";
        String string2 = Integer.toString(n2 & 0x3F, 36);
        String string3 = Integer.toString(n3 & 0x3F, 36);
        File file = new File(this.a, string2);
        if (!file.exists()) {
            if (this.b) {
                file.mkdir();
            } else {
                return null;
            }
        }
        if (!(file = new File(file, string3)).exists()) {
            if (this.b) {
                file.mkdir();
            } else {
                return null;
            }
        }
        if (!(file = new File(file, string)).exists() && !this.b) {
            return null;
        }
        return file;
    }

    public ha a(cy cy2, int n2, int n3) {
        File file = this.a(n2, n3);
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                iq iq2 = ab.a(fileInputStream);
                if (!iq2.b("Level")) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is missing level data, skipping");
                    return null;
                }
                if (!iq2.k("Level").b("Blocks")) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is missing block data, skipping");
                    return null;
                }
                ha ha2 = mu.a(cy2, iq2.k("Level"));
                if (!ha2.a(n2, n3)) {
                    System.out.println("Chunk file at " + n2 + "," + n3 + " is in the wrong location; relocating. (Expected " + n2 + ", " + n3 + ", got " + ha2.j + ", " + ha2.k + ")");
                    iq2.a("xPos", n2);
                    iq2.a("zPos", n3);
                    ha2 = mu.a(cy2, iq2.k("Level"));
                }
                return ha2;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void a(cy cy2, ha ha2) {
        cy2.n();
        File file = this.a(ha2.j, ha2.k);
        if (file.exists()) {
            cy2.v -= file.length();
        }
        try {
            File file2 = new File(this.a, "tmp_chunk.dat");
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            iq iq2 = new iq();
            iq iq3 = new iq();
            iq2.a("Level", (fd)iq3);
            this.a(ha2, cy2, iq3);
            ab.a(iq2, fileOutputStream);
            fileOutputStream.close();
            if (file.exists()) {
                file.delete();
            }
            file2.renameTo(file);
            cy2.v += file.length();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void a(ha ha2, cy cy2, iq iq2) {
        iq iq3;
        cy2.n();
        iq2.a("xPos", ha2.j);
        iq2.a("zPos", ha2.k);
        iq2.a("LastUpdate", cy2.e);
        iq2.a("Blocks", ha2.b);
        iq2.a("Data", ha2.e.a);
        iq2.a("SkyLight", ha2.f.a);
        iq2.a("BlockLight", ha2.g.a);
        iq2.a("HeightMap", ha2.h);
        iq2.a("TerrainPopulated", ha2.n);
        ha2.r = false;
        ly ly2 = new ly();
        for (int i2 = 0; i2 < ha2.m.length; ++i2) {
            for (Object object : ha2.m[i2]) {
                ha2.r = true;
                iq3 = new iq();
                if (!((lw)object).c(iq3)) continue;
                ly2.a(iq3);
            }
        }
        iq2.a("Entities", ly2);
        ly ly3 = new ly();
        for (Object object : ha2.l.values()) {
            iq3 = new iq();
            ((ji)object).b(iq3);
            ly3.a(iq3);
        }
        iq2.a("TileEntities", ly3);
    }

    public static ha a(cy cy2, iq iq2) {
        ly ly2;
        Object object;
        ly ly3;
        int n2 = iq2.e("xPos");
        int n3 = iq2.e("zPos");
        ha ha2 = new ha(cy2, n2, n3);
        ha2.b = iq2.j("Blocks");
        ha2.e = new oo(iq2.j("Data"));
        ha2.f = new oo(iq2.j("SkyLight"));
        ha2.g = new oo(iq2.j("BlockLight"));
        ha2.h = iq2.j("HeightMap");
        ha2.n = iq2.m("TerrainPopulated");
        if (!ha2.e.a()) {
            ha2.e = new oo(ha2.b.length);
        }
        if (ha2.h == null || !ha2.f.a()) {
            ha2.h = new byte[256];
            ha2.f = new oo(ha2.b.length);
            ha2.c();
        }
        if (!ha2.g.a()) {
            ha2.g = new oo(ha2.b.length);
            ha2.a();
        }
        if ((ly3 = iq2.l("Entities")) != null) {
            for (int i2 = 0; i2 < ly3.c(); ++i2) {
                iq iq3 = (iq)ly3.a(i2);
                object = fq.a(iq3, cy2);
                ha2.r = true;
                if (object == null) continue;
                ha2.a((lw)object);
            }
        }
        if ((ly2 = iq2.l("TileEntities")) != null) {
            for (int i3 = 0; i3 < ly2.c(); ++i3) {
                object = (iq)ly2.a(i3);
                ji ji2 = ji.c((iq)object);
                if (ji2 == null) continue;
                ha2.a(ji2);
            }
        }
        return ha2;
    }

    public void a() {
    }

    public void b() {
    }

    public void b(cy cy2, ha ha2) {
    }
}

