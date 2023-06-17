/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class FontRenderer {
    private int[] charWidth = new int[256];
    public int field_1308_a = 0;
    private int field_1310_c;
    private IntBuffer buffer = GLAllocation.createDirectIntBuffer(1024);

    public FontRenderer(GameSettings gamesettings, String s2, RenderEngine renderengine) {
        BufferedImage bufferedimage;
        try {
            bufferedimage = ImageIO.read(RenderEngine.class.getResourceAsStream(s2));
        }
        catch (IOException ioexception) {
            throw new RuntimeException(ioexception);
        }
        int i2 = bufferedimage.getWidth();
        int j2 = bufferedimage.getHeight();
        int[] ai2 = new int[i2 * j2];
        bufferedimage.getRGB(0, 0, i2, j2, ai2, 0, i2);
        for (int k2 = 0; k2 < 256; ++k2) {
            int j22;
            int l2 = k2 % 16;
            int k1 = k2 / 16;
            for (j22 = 7; j22 >= 0; --j22) {
                int i3 = l2 * 8 + j22;
                boolean flag = true;
                for (int l3 = 0; l3 < 8 && flag; ++l3) {
                    int i4 = (k1 * 8 + l3) * i2;
                    int k4 = ai2[i3 + i4] & 0xFF;
                    if (k4 <= 0) continue;
                    flag = false;
                }
                if (!flag) break;
            }
            if (k2 == 32) {
                j22 = 2;
            }
            this.charWidth[k2] = j22 + 2;
        }
        this.field_1308_a = renderengine.allocateAndSetupTexture(bufferedimage);
        this.field_1310_c = GLAllocation.generateDisplayLists(288);
        Tessellator tessellator = Tessellator.instance;
        for (int i1 = 0; i1 < 256; ++i1) {
            GL11.glNewList(this.field_1310_c + i1, 4864);
            tessellator.startDrawingQuads();
            int l1 = i1 % 16 * 8;
            int k2 = i1 / 16 * 8;
            float f2 = 7.99f;
            float f1 = 0.0f;
            float f22 = 0.0f;
            tessellator.addVertexWithUV(0.0, 0.0f + f2, 0.0, (float)l1 / 128.0f + f1, ((float)k2 + f2) / 128.0f + f22);
            tessellator.addVertexWithUV(0.0f + f2, 0.0f + f2, 0.0, ((float)l1 + f2) / 128.0f + f1, ((float)k2 + f2) / 128.0f + f22);
            tessellator.addVertexWithUV(0.0f + f2, 0.0, 0.0, ((float)l1 + f2) / 128.0f + f1, (float)k2 / 128.0f + f22);
            tessellator.addVertexWithUV(0.0, 0.0, 0.0, (float)l1 / 128.0f + f1, (float)k2 / 128.0f + f22);
            tessellator.draw();
            GL11.glTranslatef(this.charWidth[i1], 0.0f, 0.0f);
            GL11.glEndList();
        }
        for (int j1 = 0; j1 < 32; ++j1) {
            boolean flag1;
            int i22 = (j1 >> 3 & 1) * 85;
            int l2 = (j1 >> 2 & 1) * 170 + i22;
            int j3 = (j1 >> 1 & 1) * 170 + i22;
            int k3 = (j1 >> 0 & 1) * 170 + i22;
            if (j1 == 6) {
                l2 += 85;
            }
            boolean bl2 = flag1 = j1 >= 16;
            if (gamesettings.anaglyph) {
                int j4 = (l2 * 30 + j3 * 59 + k3 * 11) / 100;
                int l4 = (l2 * 30 + j3 * 70) / 100;
                int i5 = (l2 * 30 + k3 * 70) / 100;
                l2 = j4;
                j3 = l4;
                k3 = i5;
            }
            if (flag1) {
                l2 /= 4;
                j3 /= 4;
                k3 /= 4;
            }
            GL11.glNewList(this.field_1310_c + 256 + j1, 4864);
            GL11.glColor3f((float)l2 / 255.0f, (float)j3 / 255.0f, (float)k3 / 255.0f);
            GL11.glEndList();
        }
    }

    public void drawStringWithShadow(String s2, int i2, int j2, int k2) {
        this.renderString(s2, i2 + 1, j2 + 1, k2, true);
        this.drawString(s2, i2, j2, k2);
    }

    public void drawString(String s2, int i2, int j2, int k2) {
        this.renderString(s2, i2, j2, k2, false);
    }

    /*
     * Exception decompiling
     */
    public void renderString(String s, int i, int j, int k, boolean flag) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * org.benf.cfr.reader.util.ConfusedCFRException: CONTINUE without a while class org.benf.cfr.reader.bytecode.analysis.parse.statement.AssignmentSimple
         * org.benf.cfr.reader.bytecode.analysis.parse.statement.GotoStatement.getTargetStartBlock(GotoStatement.java:87)
         * org.benf.cfr.reader.bytecode.analysis.parse.statement.IfStatement.getStructuredStatement(IfStatement.java:103)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.getStructuredStatementPlaceHolder(Op03SimpleStatement.java:542)
         * org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:719)
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

    public int getStringWidth(String s2) {
        if (s2 == null) {
            return 0;
        }
        int i2 = 0;
        for (int j2 = 0; j2 < s2.length(); ++j2) {
            if (s2.charAt(j2) == '\u00a7') {
                ++j2;
                continue;
            }
            int k2 = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(s2.charAt(j2));
            if (k2 < 0) continue;
            i2 += this.charWidth[k2 + 32];
        }
        return i2;
    }
}

