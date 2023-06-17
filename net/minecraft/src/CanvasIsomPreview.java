/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.src.EnumOS1;
import net.minecraft.src.IsoImageBuffer;
import net.minecraft.src.OsMap;
import net.minecraft.src.TerrainTextureManager;
import net.minecraft.src.ThreadRunIsoClient;
import net.minecraft.src.World;
import net.minecraft.src.WorldIso;

public class CanvasIsomPreview
extends Canvas
implements KeyListener,
MouseListener,
MouseMotionListener,
Runnable {
    private int field_1793_a = 0;
    private int field_1792_b = 2;
    private boolean field_1791_c = true;
    private World worldObj;
    private File dataFolder;
    private boolean field_1788_f = true;
    private List field_1787_g = Collections.synchronizedList(new LinkedList());
    private IsoImageBuffer[][] field_1786_h = new IsoImageBuffer[64][64];
    private int field_1785_i;
    private int field_1784_j;
    private int field_1783_k;
    private int field_1782_l;

    public File getDataFolder() {
        if (this.dataFolder == null) {
            this.dataFolder = this.func_1264_a("minecraft");
        }
        return this.dataFolder;
    }

    public File func_1264_a(String s2) {
        File file;
        String s1 = System.getProperty("user.home", ".");
        switch (OsMap.field_1193_a[CanvasIsomPreview.func_1269_e().ordinal()]) {
            case 1: 
            case 2: {
                file = new File(s1, '.' + s2 + '/');
                break;
            }
            case 3: {
                String s22 = System.getenv("APPDATA");
                if (s22 != null) {
                    file = new File(s22, "." + s2 + '/');
                    break;
                }
                file = new File(s1, '.' + s2 + '/');
                break;
            }
            case 4: {
                file = new File(s1, "Library/Application Support/" + s2);
                break;
            }
            default: {
                file = new File(s1, s2 + '/');
            }
        }
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + file);
        }
        return file;
    }

    private static EnumOS1 func_1269_e() {
        String s2 = System.getProperty("os.name").toLowerCase();
        if (s2.contains("win")) {
            return EnumOS1.windows;
        }
        if (s2.contains("mac")) {
            return EnumOS1.macos;
        }
        if (s2.contains("solaris")) {
            return EnumOS1.solaris;
        }
        if (s2.contains("sunos")) {
            return EnumOS1.solaris;
        }
        if (s2.contains("linux")) {
            return EnumOS1.linux;
        }
        if (s2.contains("unix")) {
            return EnumOS1.linux;
        }
        return EnumOS1.unknown;
    }

    public CanvasIsomPreview() {
        this.dataFolder = this.getDataFolder();
        for (int i2 = 0; i2 < 64; ++i2) {
            for (int j2 = 0; j2 < 64; ++j2) {
                this.field_1786_h[i2][j2] = new IsoImageBuffer(null, i2, j2);
            }
        }
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
        this.setBackground(Color.red);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void func_1270_b(String s2) {
        this.field_1784_j = 0;
        this.field_1785_i = 0;
        this.worldObj = new WorldIso(this, new File(this.dataFolder, "saves"), s2);
        this.worldObj.skylightSubtracted = 0;
        List list = this.field_1787_g;
        synchronized (list) {
            this.field_1787_g.clear();
            for (int i2 = 0; i2 < 64; ++i2) {
                for (int j2 = 0; j2 < 64; ++j2) {
                    this.field_1786_h[i2][j2].func_888_a(this.worldObj, i2, j2);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void func_1266_a(int i2) {
        List list = this.field_1787_g;
        synchronized (list) {
            this.worldObj.skylightSubtracted = i2;
            this.field_1787_g.clear();
            for (int j2 = 0; j2 < 64; ++j2) {
                for (int k2 = 0; k2 < 64; ++k2) {
                    this.field_1786_h[j2][k2].func_888_a(this.worldObj, j2, k2);
                }
            }
        }
    }

    public void func_1272_b() {
        new ThreadRunIsoClient(this).start();
        for (int i2 = 0; i2 < 8; ++i2) {
            new Thread(this).start();
        }
    }

    public void func_1273_c() {
        this.field_1788_f = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private IsoImageBuffer func_1267_a(int i2, int j2) {
        int k2 = i2 & 0x3F;
        int l2 = j2 & 0x3F;
        IsoImageBuffer isoimagebuffer = this.field_1786_h[k2][l2];
        if (isoimagebuffer.field_1354_c == i2 && isoimagebuffer.field_1353_d == j2) {
            return isoimagebuffer;
        }
        List list = this.field_1787_g;
        synchronized (list) {
            this.field_1787_g.remove(isoimagebuffer);
        }
        isoimagebuffer.func_889_a(i2, j2);
        return isoimagebuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        TerrainTextureManager terraintexturemanager = new TerrainTextureManager();
        while (this.field_1788_f) {
            IsoImageBuffer isoimagebuffer = null;
            List list = this.field_1787_g;
            synchronized (list) {
                if (this.field_1787_g.size() > 0) {
                    isoimagebuffer = (IsoImageBuffer)this.field_1787_g.remove(0);
                }
            }
            if (isoimagebuffer != null) {
                if (this.field_1793_a - isoimagebuffer.field_1350_g < 2) {
                    terraintexturemanager.func_799_a(isoimagebuffer);
                    this.repaint();
                } else {
                    isoimagebuffer.field_1349_h = false;
                }
            }
            try {
                Thread.sleep(2L);
            }
            catch (InterruptedException interruptedexception) {
                interruptedexception.printStackTrace();
            }
        }
    }

    @Override
    public void update(Graphics g2) {
    }

    @Override
    public void paint(Graphics g2) {
    }

    public void func_1265_d() {
        BufferStrategy bufferstrategy = this.getBufferStrategy();
        if (bufferstrategy == null) {
            this.createBufferStrategy(2);
            return;
        }
        this.func_1268_a((Graphics2D)bufferstrategy.getDrawGraphics());
        bufferstrategy.show();
    }

    public void func_1268_a(Graphics2D graphics2d) {
        ++this.field_1793_a;
        AffineTransform affinetransform = graphics2d.getTransform();
        graphics2d.setClip(0, 0, this.getWidth(), this.getHeight());
        graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        graphics2d.translate(this.getWidth() / 2, this.getHeight() / 2);
        graphics2d.scale(this.field_1792_b, this.field_1792_b);
        graphics2d.translate(this.field_1785_i, this.field_1784_j);
        if (this.worldObj != null) {
            graphics2d.translate(-(this.worldObj.spawnX + this.worldObj.spawnZ), -(-this.worldObj.spawnX + this.worldObj.spawnZ) + 64);
        }
        Rectangle rectangle = graphics2d.getClipBounds();
        graphics2d.setColor(new Color(-15724512));
        graphics2d.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        int byte0 = 16;
        int byte1 = 3;
        int i2 = rectangle.x / byte0 / 2 - 2 - byte1;
        int j2 = (rectangle.x + rectangle.width) / byte0 / 2 + 1 + byte1;
        int k2 = rectangle.y / byte0 - 1 - byte1 * 2;
        int l2 = (rectangle.y + rectangle.height + 16 + 128) / byte0 + 1 + byte1 * 2;
        for (int i1 = k2; i1 <= l2; ++i1) {
            for (int k1 = i2; k1 <= j2; ++k1) {
                int l1 = k1 - (i1 >> 1);
                int i22 = k1 + (i1 + 1 >> 1);
                IsoImageBuffer isoimagebuffer = this.func_1267_a(l1, i22);
                isoimagebuffer.field_1350_g = this.field_1793_a;
                if (!isoimagebuffer.field_1352_e) {
                    if (isoimagebuffer.field_1349_h) continue;
                    isoimagebuffer.field_1349_h = true;
                    this.field_1787_g.add(isoimagebuffer);
                    continue;
                }
                isoimagebuffer.field_1349_h = false;
                if (isoimagebuffer.field_1351_f) continue;
                int j22 = k1 * byte0 * 2 + (i1 & 1) * byte0;
                int k22 = i1 * byte0 - 128 - 16;
                graphics2d.drawImage((Image)isoimagebuffer.field_1348_a, j22, k22, null);
            }
        }
        if (this.field_1791_c) {
            graphics2d.setTransform(affinetransform);
            int j1 = this.getHeight() - 32 - 4;
            graphics2d.setColor(new Color(Integer.MIN_VALUE, true));
            graphics2d.fillRect(4, this.getHeight() - 32 - 4, this.getWidth() - 8, 32);
            graphics2d.setColor(Color.WHITE);
            String s2 = "F1 - F5: load levels   |   0-9: Set time of day   |   Space: return to spawn   |   Double click: zoom   |   Escape: hide this text";
            graphics2d.drawString(s2, this.getWidth() / 2 - graphics2d.getFontMetrics().stringWidth(s2) / 2, j1 + 20);
        }
        graphics2d.dispose();
    }

    @Override
    public void mouseDragged(MouseEvent mouseevent) {
        int i2 = mouseevent.getX() / this.field_1792_b;
        int j2 = mouseevent.getY() / this.field_1792_b;
        this.field_1785_i += i2 - this.field_1783_k;
        this.field_1784_j += j2 - this.field_1782_l;
        this.field_1783_k = i2;
        this.field_1782_l = j2;
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseevent) {
    }

    @Override
    public void mouseClicked(MouseEvent mouseevent) {
        if (mouseevent.getClickCount() == 2) {
            this.field_1792_b = 3 - this.field_1792_b;
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseevent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseevent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseevent) {
        int i2 = mouseevent.getX() / this.field_1792_b;
        int j2 = mouseevent.getY() / this.field_1792_b;
        this.field_1783_k = i2;
        this.field_1782_l = j2;
    }

    @Override
    public void mouseReleased(MouseEvent mouseevent) {
    }

    @Override
    public void keyPressed(KeyEvent keyevent) {
        if (keyevent.getKeyCode() == 48) {
            this.func_1266_a(11);
        }
        if (keyevent.getKeyCode() == 49) {
            this.func_1266_a(10);
        }
        if (keyevent.getKeyCode() == 50) {
            this.func_1266_a(9);
        }
        if (keyevent.getKeyCode() == 51) {
            this.func_1266_a(7);
        }
        if (keyevent.getKeyCode() == 52) {
            this.func_1266_a(6);
        }
        if (keyevent.getKeyCode() == 53) {
            this.func_1266_a(5);
        }
        if (keyevent.getKeyCode() == 54) {
            this.func_1266_a(3);
        }
        if (keyevent.getKeyCode() == 55) {
            this.func_1266_a(2);
        }
        if (keyevent.getKeyCode() == 56) {
            this.func_1266_a(1);
        }
        if (keyevent.getKeyCode() == 57) {
            this.func_1266_a(0);
        }
        if (keyevent.getKeyCode() == 112) {
            this.func_1270_b("World1");
        }
        if (keyevent.getKeyCode() == 113) {
            this.func_1270_b("World2");
        }
        if (keyevent.getKeyCode() == 114) {
            this.func_1270_b("World3");
        }
        if (keyevent.getKeyCode() == 115) {
            this.func_1270_b("World4");
        }
        if (keyevent.getKeyCode() == 116) {
            this.func_1270_b("World5");
        }
        if (keyevent.getKeyCode() == 32) {
            this.field_1784_j = 0;
            this.field_1785_i = 0;
        }
        if (keyevent.getKeyCode() == 27) {
            this.field_1791_c = !this.field_1791_c;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyevent) {
    }

    @Override
    public void keyTyped(KeyEvent keyevent) {
    }

    static boolean func_1271_a(CanvasIsomPreview canvasisompreview) {
        return canvasisompreview.field_1788_f;
    }
}

