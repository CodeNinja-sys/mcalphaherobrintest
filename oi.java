/*
 * Decompiled with CFR 0.150.
 */
import java.awt.Component;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public class oi {
    private Component c;
    private Cursor d;
    public int a;
    public int b;
    private int e = 10;

    public oi(Component component) {
        this.c = component;
        IntBuffer intBuffer = ds.c(1);
        intBuffer.put(0);
        intBuffer.flip();
        IntBuffer intBuffer2 = ds.c(1024);
        try {
            this.d = new Cursor(32, 32, 16, 16, 1, intBuffer2, intBuffer);
        }
        catch (LWJGLException lWJGLException) {
            lWJGLException.printStackTrace();
        }
    }

    public void a() {
        Mouse.setGrabbed(true);
        this.a = 0;
        this.b = 0;
    }

    public void b() {
        Mouse.setCursorPosition(this.c.getWidth() / 2, this.c.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void c() {
        this.a = Mouse.getDX();
        this.b = Mouse.getDY();
    }
}

