/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBBufferObject;
import org.lwjgl.opengl.ATIVertexArrayObject;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.EXTDirectStateAccess;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.References;
import org.lwjgl.opengl.StateTracker;

class GLChecks {
    private GLChecks() {
    }

    static References getReferences(ContextCapabilities caps) {
        return StateTracker.getReferencesStack(caps).getReferences();
    }

    static int getBufferObjectSize(ContextCapabilities caps, int buffer_enum) {
        IntBuffer scratch_buffer = caps.scratch_int_buffer;
        GL15.glGetBufferParameter(buffer_enum, 34660, scratch_buffer);
        return scratch_buffer.get(0);
    }

    static int getBufferObjectSizeARB(ContextCapabilities caps, int buffer_enum) {
        IntBuffer scratch_buffer = caps.scratch_int_buffer;
        ARBBufferObject.glGetBufferParameterARB(buffer_enum, 34660, scratch_buffer);
        return scratch_buffer.get(0);
    }

    static int getBufferObjectSizeATI(ContextCapabilities caps, int buffer) {
        IntBuffer scratch_buffer = caps.scratch_int_buffer;
        ATIVertexArrayObject.glGetObjectBufferATI(buffer, 34660, scratch_buffer);
        return scratch_buffer.get(0);
    }

    static int getNamedBufferObjectSize(ContextCapabilities caps, int buffer) {
        IntBuffer scratch_buffer = caps.scratch_int_buffer;
        EXTDirectStateAccess.glGetNamedBufferParameterEXT(buffer, 34660, scratch_buffer);
        return scratch_buffer.get(0);
    }

    private static boolean checkBufferObject(ContextCapabilities caps, int buffer_enum, boolean state) {
        IntBuffer scratch_buffer = caps.scratch_int_buffer;
        GL11.glGetInteger(buffer_enum, scratch_buffer);
        boolean is_enabled = scratch_buffer.get(0) != 0;
        return state == is_enabled;
    }

    static void ensureArrayVBOdisabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().arrayBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Array Buffer Object is enabled");
        }
    }

    static void ensureArrayVBOenabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().arrayBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Array Buffer Object is disabled");
        }
    }

    static void ensureElementVBOdisabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().elementArrayBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Element Array Buffer Object is enabled");
        }
    }

    static void ensureElementVBOenabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().elementArrayBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Element Array Buffer Object is disabled");
        }
    }

    static void ensureIndirectBOdisabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().indirectBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Draw Indirect Object is enabled");
        }
    }

    static void ensureIndirectBOenabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().indirectBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Draw Indirect Object is disabled");
        }
    }

    static void ensurePackPBOdisabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().pixelPackBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Pixel Pack Buffer Object is enabled");
        }
    }

    static void ensurePackPBOenabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().pixelPackBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Pixel Pack Buffer Object is disabled");
        }
    }

    static void ensureUnpackPBOdisabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().pixelUnpackBuffer != 0) {
            throw new OpenGLException("Cannot use Buffers when Pixel Unpack Buffer Object is enabled");
        }
    }

    static void ensureUnpackPBOenabled(ContextCapabilities caps) {
        if (StateTracker.getReferencesStack((ContextCapabilities)caps).getReferences().pixelUnpackBuffer == 0) {
            throw new OpenGLException("Cannot use offsets when Pixel Unpack Buffer Object is disabled");
        }
    }

    static int calculateImageStorage(Buffer buffer, int format, int type, int width, int height, int depth) {
        return GLChecks.calculateImageStorage(format, type, width, height, depth) >> BufferUtils.getElementSizeExponent(buffer);
    }

    static int calculateTexImage1DStorage(Buffer buffer, int format, int type, int width) {
        return GLChecks.calculateTexImage1DStorage(format, type, width) >> BufferUtils.getElementSizeExponent(buffer);
    }

    static int calculateTexImage2DStorage(Buffer buffer, int format, int type, int width, int height) {
        return GLChecks.calculateTexImage2DStorage(format, type, width, height) >> BufferUtils.getElementSizeExponent(buffer);
    }

    static int calculateTexImage3DStorage(Buffer buffer, int format, int type, int width, int height, int depth) {
        return GLChecks.calculateTexImage3DStorage(format, type, width, height, depth) >> BufferUtils.getElementSizeExponent(buffer);
    }

    private static int calculateImageStorage(int format, int type, int width, int height, int depth) {
        return GLChecks.calculateBytesPerPixel(format, type) * width * height * depth;
    }

    private static int calculateTexImage1DStorage(int format, int type, int width) {
        return GLChecks.calculateBytesPerPixel(format, type) * width;
    }

    private static int calculateTexImage2DStorage(int format, int type, int width, int height) {
        return GLChecks.calculateTexImage1DStorage(format, type, width) * height;
    }

    private static int calculateTexImage3DStorage(int format, int type, int width, int height, int depth) {
        return GLChecks.calculateTexImage2DStorage(format, type, width, height) * depth;
    }

    private static int calculateBytesPerPixel(int format, int type) {
        int epp;
        int bpe;
        switch (type) {
            case 5120: 
            case 5121: {
                bpe = 1;
                break;
            }
            case 5122: 
            case 5123: {
                bpe = 2;
                break;
            }
            case 5124: 
            case 5125: 
            case 5126: {
                bpe = 4;
                break;
            }
            default: {
                return 0;
            }
        }
        switch (format) {
            case 6406: 
            case 6409: {
                epp = 1;
                break;
            }
            case 6410: {
                epp = 2;
                break;
            }
            case 6407: 
            case 32992: {
                epp = 3;
                break;
            }
            case 6408: 
            case 32768: 
            case 32993: {
                epp = 4;
                break;
            }
            default: {
                return 0;
            }
        }
        return bpe * epp;
    }
}

