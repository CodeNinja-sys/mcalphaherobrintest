/*
 * Decompiled with CFR 0.150.
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;

public class ff {
    private List b = new ArrayList();
    private d c = new jm();
    public d a;
    private Map d = new HashMap();
    private Minecraft e;
    private File f;
    private String g;

    public ff(Minecraft minecraft, File file) {
        this.e = minecraft;
        this.f = new File(file, "texturepacks");
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
        this.g = minecraft.y.j;
        this.a();
        this.a.a();
    }

    public boolean a(d d2) {
        if (d2 == this.a) {
            return false;
        }
        this.a.b();
        this.g = d2.a;
        this.a = d2;
        this.e.y.j = this.g;
        this.e.y.b();
        this.a.a();
        return true;
    }

    public void a() {
        ArrayList<d> arrayList = new ArrayList<d>();
        this.a = null;
        arrayList.add(this.c);
        if (this.f.exists() && this.f.isDirectory()) {
            Object object;
            for (File file : object = this.f.listFiles()) {
                if (!file.isFile() || !file.getName().toLowerCase().endsWith(".zip")) continue;
                String string = file.getName() + ":" + file.length() + ":" + file.lastModified();
                try {
                    d d2;
                    if (!this.d.containsKey(string)) {
                        d2 = new od(file);
                        d2.d = string;
                        this.d.put(string, d2);
                        d2.a(this.e);
                    }
                    d2 = (d)this.d.get(string);
                    if (d2.a.equals(this.g)) {
                        this.a = d2;
                    }
                    arrayList.add(d2);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
        }
        if (this.a == null) {
            this.a = this.c;
        }
        this.b.removeAll(arrayList);
        for (Object object : this.b) {
            ((d)object).b(this.e);
            this.d.remove(((d)object).d);
        }
        this.b = arrayList;
    }

    public List b() {
        return new ArrayList(this.b);
    }
}

