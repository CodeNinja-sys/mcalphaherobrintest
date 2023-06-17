/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.Component;
import java.nio.IntBuffer;
import net.minecraft.src.GLAllocation;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;

public class MouseHelper {
    private Component field_1117_c;
    private Cursor field_1116_d;
    public int field_1114_a;
    public int field_1113_b;
    private int field_1115_e = 10;

    public MouseHelper(Component component) {
        this.field_1117_c = component;
        IntBuffer intbuffer = GLAllocation.createDirectIntBuffer(1);
        intbuffer.put(0);
        intbuffer.flip();
        IntBuffer intbuffer1 = GLAllocation.createDirectIntBuffer(1024);
        try {
            this.field_1116_d = new Cursor(32, 32, 16, 16, 1, intbuffer1, intbuffer);
        }
        catch (LWJGLException lwjglexception) {
            lwjglexception.printStackTrace();
        }
    }

    public void func_774_a() {
        Mouse.setGrabbed(true);
        this.field_1114_a = 0;
        this.field_1113_b = 0;
    }

    public void func_773_b() {
        Mouse.setCursorPosition(this.field_1117_c.getWidth() / 2, this.field_1117_c.getHeight() / 2);
        Mouse.setGrabbed(false);
    }

    public void func_772_c() {
        this.field_1114_a = Mouse.getDX();
        this.field_1113_b = Mouse.getDY();
    }
}

