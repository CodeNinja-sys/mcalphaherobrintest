/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GL11;

class BaseReferences {
    int elementArrayBuffer;
    int arrayBuffer;
    Buffer[] glVertexAttribPointer_buffer;
    Buffer[] glTexCoordPointer_buffer;
    int glClientActiveTexture;
    int pixelPackBuffer;
    int pixelUnpackBuffer;
    int indirectBuffer;

    BaseReferences(ContextCapabilities caps) {
        int max_texture_units;
        int max_vertex_attribs;
        IntBuffer temp = caps.scratch_int_buffer;
        if (caps.OpenGL20 || caps.GL_ARB_vertex_shader) {
            GL11.glGetInteger(34921, temp);
            max_vertex_attribs = temp.get(0);
        } else {
            max_vertex_attribs = 0;
        }
        this.glVertexAttribPointer_buffer = new Buffer[max_vertex_attribs];
        if (caps.OpenGL20) {
            GL11.glGetInteger(34930, temp);
            max_texture_units = temp.get(0);
        } else if (caps.OpenGL13 || caps.GL_ARB_multitexture) {
            GL11.glGetInteger(34018, temp);
            max_texture_units = temp.get(0);
        } else {
            max_texture_units = 1;
        }
        this.glTexCoordPointer_buffer = new Buffer[max_texture_units];
    }

    void clear() {
        this.elementArrayBuffer = 0;
        this.arrayBuffer = 0;
        this.glClientActiveTexture = 0;
        Arrays.fill(this.glVertexAttribPointer_buffer, null);
        Arrays.fill(this.glTexCoordPointer_buffer, null);
        this.pixelPackBuffer = 0;
        this.pixelUnpackBuffer = 0;
        this.indirectBuffer = 0;
    }

    void copy(BaseReferences references, int mask) {
        if ((mask & 2) != 0) {
            this.elementArrayBuffer = references.elementArrayBuffer;
            this.arrayBuffer = references.arrayBuffer;
            this.glClientActiveTexture = references.glClientActiveTexture;
            System.arraycopy(references.glVertexAttribPointer_buffer, 0, this.glVertexAttribPointer_buffer, 0, this.glVertexAttribPointer_buffer.length);
            System.arraycopy(references.glTexCoordPointer_buffer, 0, this.glTexCoordPointer_buffer, 0, this.glTexCoordPointer_buffer.length);
            this.indirectBuffer = references.indirectBuffer;
        }
        if ((mask & 1) != 0) {
            this.pixelPackBuffer = references.pixelPackBuffer;
            this.pixelUnpackBuffer = references.pixelUnpackBuffer;
        }
    }
}

