/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.AWTCanvasImplementation;
import org.lwjgl.opengl.LinuxAWTGLCanvasPeerInfo;
import org.lwjgl.opengl.PeerInfo;
import org.lwjgl.opengl.PixelFormat;

final class LinuxCanvasImplementation
implements AWTCanvasImplementation {
    LinuxCanvasImplementation() {
    }

    static int getScreenFromDevice(final GraphicsDevice device) throws LWJGLException {
        try {
            Method getScreen_method = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    return device.getClass().getMethod("getScreen", null);
                }
            });
            Integer screen = (Integer)getScreen_method.invoke(device, null);
            return screen;
        }
        catch (Exception e2) {
            throw new LWJGLException(e2);
        }
    }

    private static int getVisualIDFromConfiguration(final GraphicsConfiguration configuration) throws LWJGLException {
        try {
            Method getVisual_method = (Method)AccessController.doPrivileged(new PrivilegedExceptionAction(){

                public Object run() throws Exception {
                    return configuration.getClass().getMethod("getVisual", null);
                }
            });
            Integer visual = (Integer)getVisual_method.invoke(configuration, null);
            return visual;
        }
        catch (Exception e2) {
            throw new LWJGLException(e2);
        }
    }

    public PeerInfo createPeerInfo(Canvas component, PixelFormat pixel_format) throws LWJGLException {
        return new LinuxAWTGLCanvasPeerInfo(component);
    }

    public GraphicsConfiguration findConfiguration(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
        try {
            int screen = LinuxCanvasImplementation.getScreenFromDevice(device);
            int visual_id_matching_format = LinuxCanvasImplementation.findVisualIDFromFormat(screen, pixel_format);
            GraphicsConfiguration[] configurations = device.getConfigurations();
            for (int i2 = 0; i2 < configurations.length; ++i2) {
                int visual_id = LinuxCanvasImplementation.getVisualIDFromConfiguration(configurations[i2]);
                if (visual_id != visual_id_matching_format) continue;
                return configurations[i2];
            }
        }
        catch (LWJGLException e2) {
            LWJGLUtil.log("Got exception while trying to determine configuration: " + e2);
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    private static int findVisualIDFromFormat(int screen, PixelFormat pixel_format) throws LWJGLException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[TRYBLOCK]], but top level block is 3[TRYBLOCK]
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:429)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:478)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:728)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:806)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:258)
         * org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:192)
         * org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         * org.benf.cfr.reader.entities.Method.analyse(Method.java:521)
         * org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1035)
         * org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:922)
         * org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:253)
         * org.benf.cfr.reader.Driver.doJar(Driver.java:135)
         * org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:65)
         * org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException(Decompilation failed);
    }

    private static native int nFindVisualIDFromFormat(long var0, int var2, PixelFormat var3) throws LWJGLException;
}

