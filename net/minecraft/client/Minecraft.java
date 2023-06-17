/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import net.minecraft.client.MinecraftApplet;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EnumOS2;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GameWindowListener;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiConflictWarning;
import net.minecraft.src.GuiConnecting;
import net.minecraft.src.GuiGameOver;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiUnused;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.LoadingScreenRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.MinecraftImpl;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.MouseHelper;
import net.minecraft.src.MovementInputFromOptions;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.OpenGlCapsChecker;
import net.minecraft.src.PlayerController;
import net.minecraft.src.PlayerControllerTest;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderManager;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.ScreenShotHelper;
import net.minecraft.src.Session;
import net.minecraft.src.SoundManager;
import net.minecraft.src.Teleporter;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TextureCompassFX;
import net.minecraft.src.TextureFlamesFX;
import net.minecraft.src.TextureLavaFX;
import net.minecraft.src.TextureLavaFlowFX;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.TexturePortalFX;
import net.minecraft.src.TextureWatchFX;
import net.minecraft.src.TextureWaterFX;
import net.minecraft.src.TexureWaterFlowFX;
import net.minecraft.src.ThreadDownloadResources;
import net.minecraft.src.ThreadSleepForever;
import net.minecraft.src.Timer;
import net.minecraft.src.UnexpectedThrowable;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldProviderHell;
import net.minecraft.src.WorldRenderer;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft
implements Runnable {
    public PlayerController field_6327_b;
    private boolean mainFrame = false;
    public int displayWidth;
    public int displayHeight;
    private OpenGlCapsChecker glCapabilities;
    private Timer timer = new Timer(20.0f);
    public World theWorld;
    public RenderGlobal field_6323_f;
    public EntityPlayerSP thePlayer;
    public EffectRenderer field_6321_h;
    public Session field_6320_i = null;
    public String field_6319_j;
    public Canvas mcCanvas;
    public boolean field_6317_l = true;
    public volatile boolean field_6316_m = false;
    public RenderEngine renderEngine;
    public FontRenderer fontRenderer;
    public GuiScreen currentScreen = null;
    public LoadingScreenRenderer loadingScreen = new LoadingScreenRenderer(this);
    public EntityRenderer field_9243_r = new EntityRenderer(this);
    private ThreadDownloadResources downloadResourcesThread;
    private int ticksRan = 0;
    private int field_6282_S = 0;
    private int field_9236_T;
    private int field_9235_U;
    public String field_6310_s = null;
    public int field_6309_t = 0;
    public GuiIngame ingameGUI;
    public boolean field_6307_v = false;
    public ModelBiped field_9242_w = new ModelBiped(0.0f);
    public MovingObjectPosition objectMouseOver = null;
    public GameSettings gameSettings;
    protected MinecraftApplet mcApplet;
    public SoundManager sndManager = new SoundManager();
    public MouseHelper mouseHelper;
    public TexturePackList texturePackList;
    public File field_6297_D;
    public static long[] field_9240_E = new long[512];
    public static long[] field_9239_F = new long[512];
    public static int field_9238_G = 0;
    private String field_9234_V;
    private int field_9233_W;
    private TextureWaterFX field_9232_X = new TextureWaterFX();
    private TextureLavaFX field_9231_Y = new TextureLavaFX();
    private static File minecraftDir = null;
    public volatile boolean running = true;
    public String field_6292_I = "";
    boolean field_6291_J = false;
    long field_6290_K = -1L;
    public boolean field_6289_L = false;
    private int field_6302_aa = 0;
    public boolean field_6288_M = false;
    long field_6287_N = System.currentTimeMillis();
    private int field_6300_ab = 0;

    public Minecraft(Component component, Canvas canvas, MinecraftApplet minecraftapplet, int i2, int j2, boolean flag) {
        this.field_9236_T = i2;
        this.field_9235_U = j2;
        this.mainFrame = flag;
        this.mcApplet = minecraftapplet;
        new ThreadSleepForever(this, "Timer hack thread");
        this.mcCanvas = canvas;
        this.displayWidth = i2;
        this.displayHeight = j2;
        this.mainFrame = flag;
    }

    public abstract void func_4007_a(UnexpectedThrowable var1);

    public void func_6258_a(String s2, int i2) {
        this.field_9234_V = s2;
        this.field_9233_W = i2;
    }

    public void startGame() throws LWJGLException {
        if (this.mcCanvas != null) {
            Graphics g2 = this.mcCanvas.getGraphics();
            if (g2 != null) {
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, this.displayWidth, this.displayHeight);
                g2.dispose();
            }
            Display.setParent(this.mcCanvas);
        } else if (this.mainFrame) {
            Display.setFullscreen(true);
            this.displayWidth = Display.getDisplayMode().getWidth();
            this.displayHeight = Display.getDisplayMode().getHeight();
            if (this.displayWidth <= 0) {
                this.displayWidth = 1;
            }
            if (this.displayHeight <= 0) {
                this.displayHeight = 1;
            }
        } else {
            Display.setDisplayMode(new DisplayMode(this.displayWidth, this.displayHeight));
        }
        Display.setTitle("Minecraft Minecraft Alpha v1.2.6");
        try {
            Display.create();
        }
        catch (LWJGLException lwjglexception) {
            lwjglexception.printStackTrace();
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            Display.create();
        }
        RenderManager.instance.field_4236_f = new ItemRenderer(this);
        this.field_6297_D = Minecraft.getMinecraftDir();
        this.gameSettings = new GameSettings(this, this.field_6297_D);
        this.texturePackList = new TexturePackList(this, this.field_6297_D);
        this.renderEngine = new RenderEngine(this.texturePackList, this.gameSettings);
        this.fontRenderer = new FontRenderer(this.gameSettings, "/font/default.png", this.renderEngine);
        this.loadScreen();
        Keyboard.create();
        Mouse.create();
        this.mouseHelper = new MouseHelper(this.mcCanvas);
        try {
            Controllers.create();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.checkGLError("Pre startup");
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glClearDepth(1.0);
        GL11.glEnable(2929);
        GL11.glDepthFunc(515);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1f);
        GL11.glCullFace(1029);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        this.checkGLError("Startup");
        this.glCapabilities = new OpenGlCapsChecker();
        this.sndManager.func_340_a(this.gameSettings);
        this.renderEngine.registerTextureFX(this.field_9231_Y);
        this.renderEngine.registerTextureFX(this.field_9232_X);
        this.renderEngine.registerTextureFX(new TexturePortalFX());
        this.renderEngine.registerTextureFX(new TextureCompassFX(this));
        this.renderEngine.registerTextureFX(new TextureWatchFX(this));
        this.renderEngine.registerTextureFX(new TexureWaterFlowFX());
        this.renderEngine.registerTextureFX(new TextureLavaFlowFX());
        this.renderEngine.registerTextureFX(new TextureFlamesFX(0));
        this.renderEngine.registerTextureFX(new TextureFlamesFX(1));
        this.field_6323_f = new RenderGlobal(this, this.renderEngine);
        GL11.glViewport(0, 0, this.displayWidth, this.displayHeight);
        this.field_6321_h = new EffectRenderer(this.theWorld, this.renderEngine);
        try {
            this.downloadResourcesThread = new ThreadDownloadResources(this.field_6297_D, this);
            this.downloadResourcesThread.start();
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.checkGLError("Post startup");
        this.ingameGUI = new GuiIngame(this);
        if (this.field_9234_V != null) {
            this.displayGuiScreen(new GuiConnecting(this, this.field_9234_V, this.field_9233_W));
        } else {
            this.displayGuiScreen(new GuiMainMenu());
        }
    }

    private void loadScreen() throws LWJGLException {
        ScaledResolution scaledresolution = new ScaledResolution(this.displayWidth, this.displayHeight);
        int i2 = scaledresolution.getScaledWidth();
        int j2 = scaledresolution.getScaledHeight();
        GL11.glClear(16640);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, i2, j2, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
        GL11.glViewport(0, 0, this.displayWidth, this.displayHeight);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        Tessellator tessellator = Tessellator.instance;
        GL11.glDisable(2896);
        GL11.glEnable(3553);
        GL11.glDisable(2912);
        GL11.glBindTexture(3553, this.renderEngine.getTexture("/title/mojang.png"));
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0xFFFFFF);
        tessellator.addVertexWithUV(0.0, this.displayHeight, 0.0, 0.0, 0.0);
        tessellator.addVertexWithUV(this.displayWidth, this.displayHeight, 0.0, 0.0, 0.0);
        tessellator.addVertexWithUV(this.displayWidth, 0.0, 0.0, 0.0, 0.0);
        tessellator.addVertexWithUV(0.0, 0.0, 0.0, 0.0, 0.0);
        tessellator.draw();
        int c2 = 256;
        int c1 = 256;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        tessellator.setColorOpaque_I(0xFFFFFF);
        this.func_6274_a((this.displayWidth / 2 - c2) / 2, (this.displayHeight / 2 - c1) / 2, 0, 0, c2, c1);
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        GL11.glEnable(3008);
        GL11.glAlphaFunc(516, 0.1f);
        Display.swapBuffers();
    }

    public void func_6274_a(int i2, int j2, int k2, int l2, int i1, int j1) {
        float f2 = 0.00390625f;
        float f1 = 0.00390625f;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(i2 + 0, j2 + j1, 0.0, (float)(k2 + 0) * f2, (float)(l2 + j1) * f1);
        tessellator.addVertexWithUV(i2 + i1, j2 + j1, 0.0, (float)(k2 + i1) * f2, (float)(l2 + j1) * f1);
        tessellator.addVertexWithUV(i2 + i1, j2 + 0, 0.0, (float)(k2 + i1) * f2, (float)(l2 + 0) * f1);
        tessellator.addVertexWithUV(i2 + 0, j2 + 0, 0.0, (float)(k2 + 0) * f2, (float)(l2 + 0) * f1);
        tessellator.draw();
    }

    public static File getMinecraftDir() {
        if (minecraftDir == null) {
            minecraftDir = Minecraft.getAppDir("minecraft");
        }
        return minecraftDir;
    }

    public static File getAppDir(String s2) {
        File file;
        String s1 = System.getProperty("user.home", ".");
        switch (Minecraft.getOs()) {
            case linux: 
            case solaris: {
                file = new File(s1, '.' + s2 + '/');
                break;
            }
            case windows: {
                String s22 = System.getenv("APPDATA");
                if (s22 != null) {
                    file = new File(s22, "." + s2 + '/');
                    break;
                }
                file = new File(s1, '.' + s2 + '/');
                break;
            }
            case macos: {
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

    private static EnumOS2 getOs() {
        String s2 = System.getProperty("os.name").toLowerCase();
        if (s2.contains("win")) {
            return EnumOS2.windows;
        }
        if (s2.contains("mac")) {
            return EnumOS2.macos;
        }
        if (s2.contains("solaris")) {
            return EnumOS2.solaris;
        }
        if (s2.contains("sunos")) {
            return EnumOS2.solaris;
        }
        if (s2.contains("linux")) {
            return EnumOS2.linux;
        }
        if (s2.contains("unix")) {
            return EnumOS2.linux;
        }
        return EnumOS2.unknown;
    }

    public void displayGuiScreen(GuiScreen guiscreen) {
        if (this.currentScreen instanceof GuiUnused) {
            return;
        }
        if (this.currentScreen != null) {
            this.currentScreen.onGuiClosed();
        }
        if (guiscreen == null && this.theWorld == null) {
            guiscreen = new GuiMainMenu();
        } else if (guiscreen == null && this.thePlayer.health <= 0) {
            guiscreen = new GuiGameOver();
        }
        this.currentScreen = guiscreen;
        if (guiscreen != null) {
            this.func_6273_f();
            ScaledResolution scaledresolution = new ScaledResolution(this.displayWidth, this.displayHeight);
            int i2 = scaledresolution.getScaledWidth();
            int j2 = scaledresolution.getScaledHeight();
            guiscreen.setWorldAndResolution(this, i2, j2);
            this.field_6307_v = false;
        } else {
            this.func_6259_e();
        }
    }

    private void checkGLError(String s2) {
        int i2 = GL11.glGetError();
        if (i2 != 0) {
            String s1 = GLU.gluErrorString(i2);
            System.out.println("########## GL ERROR ##########");
            System.out.println("@ " + s2);
            System.out.println(i2 + ": " + s1);
            System.exit(0);
        }
    }

    public void func_6266_c() {
        if (this.mcApplet != null) {
            this.mcApplet.func_6231_c();
        }
        try {
            if (this.downloadResourcesThread != null) {
                this.downloadResourcesThread.closeMinecraft();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            System.out.println("Stopping!");
            this.func_6261_a(null);
            try {
                GLAllocation.deleteTexturesAndDisplayLists();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.sndManager.closeMinecraft();
            Mouse.destroy();
            Keyboard.destroy();
        }
        finally {
            Display.destroy();
        }
        System.gc();
    }

    @Override
    public void run() {
        this.running = true;
        try {
            this.startGame();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.func_4007_a(new UnexpectedThrowable("Failed to start game", exception));
            return;
        }
        try {
            long l2 = System.currentTimeMillis();
            int i2 = 0;
            while (this.running && (this.mcApplet == null || this.mcApplet.isActive())) {
                AxisAlignedBB.clearBoundingBoxPool();
                Vec3D.initialize();
                if (this.mcCanvas == null && Display.isCloseRequested()) {
                    this.shutdown();
                }
                if (this.field_6316_m && this.theWorld != null) {
                    float f2 = this.timer.renderPartialTicks;
                    this.timer.updateTimer();
                    this.timer.renderPartialTicks = f2;
                } else {
                    this.timer.updateTimer();
                }
                long l1 = System.nanoTime();
                for (int j2 = 0; j2 < this.timer.elapsedTicks; ++j2) {
                    ++this.ticksRan;
                    try {
                        this.runTick();
                        continue;
                    }
                    catch (MinecraftException minecraftexception) {
                        this.theWorld = null;
                        this.func_6261_a(null);
                        this.displayGuiScreen(new GuiConflictWarning());
                    }
                }
                long l22 = System.nanoTime() - l1;
                this.checkGLError("Pre render");
                this.sndManager.func_338_a(this.thePlayer, this.timer.renderPartialTicks);
                GL11.glEnable(3553);
                if (this.theWorld != null && !this.theWorld.multiplayerWorld) {
                    while (this.theWorld.func_6465_g()) {
                    }
                }
                if (this.theWorld != null && this.theWorld.multiplayerWorld) {
                    this.theWorld.func_6465_g();
                }
                if (this.gameSettings.limitFramerate) {
                    Thread.sleep(5L);
                }
                if (!Keyboard.isKeyDown(65)) {
                    Display.update();
                }
                if (!this.field_6307_v) {
                    if (this.field_6327_b != null) {
                        this.field_6327_b.func_6467_a(this.timer.renderPartialTicks);
                    }
                    this.field_9243_r.func_4136_b(this.timer.renderPartialTicks);
                }
                if (!Display.isActive()) {
                    if (this.mainFrame) {
                        this.toggleFullscreen();
                    }
                    Thread.sleep(10L);
                }
                if (Keyboard.isKeyDown(61)) {
                    this.func_6238_a(l22);
                } else {
                    this.field_6290_K = System.nanoTime();
                }
                Thread.yield();
                if (Keyboard.isKeyDown(65)) {
                    Display.update();
                }
                this.func_6248_s();
                if (!(this.mcCanvas == null || this.mainFrame || this.mcCanvas.getWidth() == this.displayWidth && this.mcCanvas.getHeight() == this.displayHeight)) {
                    this.displayWidth = this.mcCanvas.getWidth();
                    this.displayHeight = this.mcCanvas.getHeight();
                    if (this.displayWidth <= 0) {
                        this.displayWidth = 1;
                    }
                    if (this.displayHeight <= 0) {
                        this.displayHeight = 1;
                    }
                    this.resize(this.displayWidth, this.displayHeight);
                }
                this.checkGLError("Post render");
                ++i2;
                this.field_6316_m = !this.isMultiplayerWorld() && this.currentScreen != null && this.currentScreen.doesGuiPauseGame();
                while (System.currentTimeMillis() >= l2 + 1000L) {
                    this.field_6292_I = i2 + " fps, " + WorldRenderer.field_1762_b + " chunk updates";
                    WorldRenderer.field_1762_b = 0;
                    l2 += 1000L;
                    i2 = 0;
                }
            }
        }
        catch (MinecraftError l2) {
        }
        catch (Throwable throwable) {
            this.theWorld = null;
            throwable.printStackTrace();
            this.func_4007_a(new UnexpectedThrowable("Unexpected error", throwable));
        }
    }

    private void func_6248_s() {
        if (Keyboard.isKeyDown(60)) {
            if (!this.field_6291_J) {
                if (Keyboard.isKeyDown(59)) {
                    this.ingameGUI.addChatMessage(ScreenShotHelper.func_4148_a(minecraftDir, this.displayWidth, this.displayHeight));
                }
                this.field_6291_J = true;
            }
        } else {
            this.field_6291_J = false;
        }
    }

    private void func_6238_a(long l2) {
        long l1 = 16666666L;
        if (this.field_6290_K == -1L) {
            this.field_6290_K = System.nanoTime();
        }
        long l22 = System.nanoTime();
        Minecraft.field_9239_F[Minecraft.field_9238_G & Minecraft.field_9240_E.length - 1] = l2;
        Minecraft.field_9240_E[Minecraft.field_9238_G++ & Minecraft.field_9240_E.length - 1] = l22 - this.field_6290_K;
        this.field_6290_K = l22;
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, this.displayWidth, this.displayHeight, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
        GL11.glLineWidth(1.0f);
        GL11.glDisable(3553);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(7);
        int i2 = (int)(l1 / 200000L);
        tessellator.setColorOpaque_I(0x20000000);
        tessellator.addVertex(0.0, this.displayHeight - i2, 0.0);
        tessellator.addVertex(0.0, this.displayHeight, 0.0);
        tessellator.addVertex(field_9240_E.length, this.displayHeight, 0.0);
        tessellator.addVertex(field_9240_E.length, this.displayHeight - i2, 0.0);
        tessellator.setColorOpaque_I(0x20200000);
        tessellator.addVertex(0.0, this.displayHeight - i2 * 2, 0.0);
        tessellator.addVertex(0.0, this.displayHeight - i2, 0.0);
        tessellator.addVertex(field_9240_E.length, this.displayHeight - i2, 0.0);
        tessellator.addVertex(field_9240_E.length, this.displayHeight - i2 * 2, 0.0);
        tessellator.draw();
        long l3 = 0L;
        for (int j2 = 0; j2 < field_9240_E.length; ++j2) {
            l3 += field_9240_E[j2];
        }
        int k2 = (int)(l3 / 200000L / (long)field_9240_E.length);
        tessellator.startDrawing(7);
        tessellator.setColorOpaque_I(0x20400000);
        tessellator.addVertex(0.0, this.displayHeight - k2, 0.0);
        tessellator.addVertex(0.0, this.displayHeight, 0.0);
        tessellator.addVertex(field_9240_E.length, this.displayHeight, 0.0);
        tessellator.addVertex(field_9240_E.length, this.displayHeight - k2, 0.0);
        tessellator.draw();
        tessellator.startDrawing(1);
        for (int i1 = 0; i1 < field_9240_E.length; ++i1) {
            int j1 = (i1 - field_9238_G & field_9240_E.length - 1) * 255 / field_9240_E.length;
            int k1 = j1 * j1 / 255;
            k1 = k1 * k1 / 255;
            int i22 = k1 * k1 / 255;
            i22 = i22 * i22 / 255;
            if (field_9240_E[i1] > l1) {
                tessellator.setColorOpaque_I(-16777216 + k1 * 65536);
            } else {
                tessellator.setColorOpaque_I(-16777216 + k1 * 256);
            }
            long l4 = field_9240_E[i1] / 200000L;
            long l5 = field_9239_F[i1] / 200000L;
            tessellator.addVertex((float)i1 + 0.5f, (float)((long)this.displayHeight - l4) + 0.5f, 0.0);
            tessellator.addVertex((float)i1 + 0.5f, (float)this.displayHeight + 0.5f, 0.0);
            tessellator.setColorOpaque_I(-16777216 + k1 * 65536 + k1 * 256 + k1 * 1);
            tessellator.addVertex((float)i1 + 0.5f, (float)((long)this.displayHeight - l4) + 0.5f, 0.0);
            tessellator.addVertex((float)i1 + 0.5f, (float)((long)this.displayHeight - (l4 - l5)) + 0.5f, 0.0);
        }
        tessellator.draw();
        GL11.glEnable(3553);
    }

    public void shutdown() {
        this.running = false;
    }

    public void func_6259_e() {
        if (!Display.isActive()) {
            return;
        }
        if (this.field_6289_L) {
            return;
        }
        this.field_6289_L = true;
        this.mouseHelper.func_774_a();
        this.displayGuiScreen(null);
        this.field_6302_aa = this.ticksRan + 10000;
    }

    public void func_6273_f() {
        if (!this.field_6289_L) {
            return;
        }
        if (this.thePlayer != null) {
            this.thePlayer.func_458_k();
        }
        this.field_6289_L = false;
        this.mouseHelper.func_773_b();
    }

    public void func_6252_g() {
        if (this.currentScreen != null) {
            return;
        }
        this.displayGuiScreen(new GuiIngameMenu());
    }

    private void func_6254_a(int i2, boolean flag) {
        if (this.field_6327_b.field_1064_b) {
            return;
        }
        if (i2 == 0 && this.field_6282_S > 0) {
            return;
        }
        if (flag && this.objectMouseOver != null && this.objectMouseOver.typeOfHit == 0 && i2 == 0) {
            int j2 = this.objectMouseOver.blockX;
            int k2 = this.objectMouseOver.blockY;
            int l2 = this.objectMouseOver.blockZ;
            this.field_6327_b.sendBlockRemoving(j2, k2, l2, this.objectMouseOver.sideHit);
            this.field_6321_h.func_1191_a(j2, k2, l2, this.objectMouseOver.sideHit);
        } else {
            this.field_6327_b.func_6468_a();
        }
    }

    private void clickMouse(int i2) {
        ItemStack itemstack;
        if (i2 == 0 && this.field_6282_S > 0) {
            return;
        }
        if (i2 == 0) {
            this.thePlayer.func_457_w();
        }
        boolean flag = true;
        if (this.objectMouseOver == null) {
            if (i2 == 0 && !(this.field_6327_b instanceof PlayerControllerTest)) {
                this.field_6282_S = 10;
            }
        } else if (this.objectMouseOver.typeOfHit == 1) {
            if (i2 == 0) {
                this.field_6327_b.func_6472_b(this.thePlayer, this.objectMouseOver.entityHit);
            }
            if (i2 == 1) {
                this.field_6327_b.func_6475_a(this.thePlayer, this.objectMouseOver.entityHit);
            }
        } else if (this.objectMouseOver.typeOfHit == 0) {
            int j2 = this.objectMouseOver.blockX;
            int k2 = this.objectMouseOver.blockY;
            int l2 = this.objectMouseOver.blockZ;
            int i1 = this.objectMouseOver.sideHit;
            Block block = Block.blocksList[this.theWorld.getBlockId(j2, k2, l2)];
            if (i2 == 0) {
                this.theWorld.onBlockHit(j2, k2, l2, this.objectMouseOver.sideHit);
                if (block != Block.bedrock || this.thePlayer.field_9371_f >= 100) {
                    this.field_6327_b.clickBlock(j2, k2, l2, this.objectMouseOver.sideHit);
                }
            } else {
                int j1;
                ItemStack itemstack1 = this.thePlayer.inventory.getCurrentItem();
                int n2 = j1 = itemstack1 == null ? 0 : itemstack1.stackSize;
                if (this.field_6327_b.sendPlaceBlock(this.thePlayer, this.theWorld, itemstack1, j2, k2, l2, i1)) {
                    flag = false;
                    this.thePlayer.func_457_w();
                }
                if (itemstack1 == null) {
                    return;
                }
                if (itemstack1.stackSize == 0) {
                    this.thePlayer.inventory.mainInventory[this.thePlayer.inventory.currentItem] = null;
                } else if (itemstack1.stackSize != j1) {
                    this.field_9243_r.field_1395_a.func_9449_b();
                }
            }
        }
        if (flag && i2 == 1 && (itemstack = this.thePlayer.inventory.getCurrentItem()) != null && this.field_6327_b.sendUseItem(this.thePlayer, this.theWorld, itemstack)) {
            this.field_9243_r.field_1395_a.func_9450_c();
        }
    }

    public void toggleFullscreen() {
        try {
            this.mainFrame = !this.mainFrame;
            System.out.println("Toggle fullscreen!");
            if (this.mainFrame) {
                Display.setDisplayMode(Display.getDesktopDisplayMode());
                this.displayWidth = Display.getDisplayMode().getWidth();
                this.displayHeight = Display.getDisplayMode().getHeight();
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
            } else {
                if (this.mcCanvas != null) {
                    this.displayWidth = this.mcCanvas.getWidth();
                    this.displayHeight = this.mcCanvas.getHeight();
                } else {
                    this.displayWidth = this.field_9236_T;
                    this.displayHeight = this.field_9235_U;
                }
                if (this.displayWidth <= 0) {
                    this.displayWidth = 1;
                }
                if (this.displayHeight <= 0) {
                    this.displayHeight = 1;
                }
                Display.setDisplayMode(new DisplayMode(this.field_9236_T, this.field_9235_U));
            }
            this.func_6273_f();
            Display.setFullscreen(this.mainFrame);
            Display.update();
            Thread.sleep(1000L);
            if (this.mainFrame) {
                this.func_6259_e();
            }
            if (this.currentScreen != null) {
                this.func_6273_f();
                this.resize(this.displayWidth, this.displayHeight);
            }
            System.out.println("Size: " + this.displayWidth + ", " + this.displayHeight);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void resize(int i2, int j2) {
        if (i2 <= 0) {
            i2 = 1;
        }
        if (j2 <= 0) {
            j2 = 1;
        }
        this.displayWidth = i2;
        this.displayHeight = j2;
        if (this.currentScreen != null) {
            ScaledResolution scaledresolution = new ScaledResolution(i2, j2);
            int k2 = scaledresolution.getScaledWidth();
            int l2 = scaledresolution.getScaledHeight();
            this.currentScreen.setWorldAndResolution(this, k2, l2);
        }
    }

    private void clickMiddleMouseButton() {
        if (this.objectMouseOver != null) {
            int i2 = this.theWorld.getBlockId(this.objectMouseOver.blockX, this.objectMouseOver.blockY, this.objectMouseOver.blockZ);
            if (i2 == Block.grass.blockID) {
                i2 = Block.dirt.blockID;
            }
            if (i2 == Block.stairDouble.blockID) {
                i2 = Block.stairSingle.blockID;
            }
            if (i2 == Block.bedrock.blockID) {
                i2 = Block.stone.blockID;
            }
            this.thePlayer.inventory.setCurrentItem(i2, this.field_6327_b instanceof PlayerControllerTest);
        }
    }

    public void runTick() {
        this.ingameGUI.func_555_a();
        this.field_9243_r.func_910_a(1.0f);
        if (this.thePlayer != null) {
            this.thePlayer.func_6420_o();
        }
        if (!this.field_6316_m && this.theWorld != null) {
            this.field_6327_b.func_6474_c();
        }
        GL11.glBindTexture(3553, this.renderEngine.getTexture("/terrain.png"));
        if (!this.field_6316_m) {
            this.renderEngine.func_1067_a();
        }
        if (this.currentScreen == null && this.thePlayer != null && this.thePlayer.health <= 0) {
            this.displayGuiScreen(null);
        }
        if (this.currentScreen != null) {
            this.field_6302_aa = this.ticksRan + 10000;
        }
        if (this.currentScreen != null) {
            this.currentScreen.handleInput();
            if (this.currentScreen != null) {
                this.currentScreen.updateScreen();
            }
        }
        if (this.currentScreen == null || this.currentScreen.field_948_f) {
            while (Mouse.next()) {
                long l2 = System.currentTimeMillis() - this.field_6287_N;
                if (l2 > 200L) continue;
                int j2 = Mouse.getEventDWheel();
                if (j2 != 0) {
                    this.thePlayer.inventory.changeCurrentItem(j2);
                }
                if (this.currentScreen == null) {
                    if (!this.field_6289_L && Mouse.getEventButtonState()) {
                        this.func_6259_e();
                        continue;
                    }
                    if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState()) {
                        this.clickMouse(0);
                        this.field_6302_aa = this.ticksRan;
                    }
                    if (Mouse.getEventButton() == 1 && Mouse.getEventButtonState()) {
                        this.clickMouse(1);
                        this.field_6302_aa = this.ticksRan;
                    }
                    if (Mouse.getEventButton() != 2 || !Mouse.getEventButtonState()) continue;
                    this.clickMiddleMouseButton();
                    continue;
                }
                if (this.currentScreen == null) continue;
                this.currentScreen.handleMouseInput();
            }
            if (this.field_6282_S > 0) {
                --this.field_6282_S;
            }
            while (Keyboard.next()) {
                this.thePlayer.func_460_a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
                if (!Keyboard.getEventKeyState()) continue;
                if (Keyboard.getEventKey() == 87) {
                    this.toggleFullscreen();
                    continue;
                }
                if (this.currentScreen != null) {
                    this.currentScreen.handleKeyboardInput();
                } else {
                    if (Keyboard.getEventKey() == 1) {
                        this.func_6252_g();
                    }
                    if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                        this.forceReload();
                    }
                    if (Keyboard.getEventKey() == 63) {
                        boolean bl2 = this.gameSettings.thirdPersonView = !this.gameSettings.thirdPersonView;
                    }
                    if (Keyboard.getEventKey() == this.gameSettings.keyBindInventory.keyCode) {
                        this.displayGuiScreen(new GuiInventory(this.thePlayer.inventory, this.thePlayer.inventory.craftingInventory));
                    }
                    if (Keyboard.getEventKey() == this.gameSettings.keyBindDrop.keyCode) {
                        this.thePlayer.dropPlayerItemWithRandomChoice(this.thePlayer.inventory.decrStackSize(this.thePlayer.inventory.currentItem, 1), false);
                    }
                    if (this.isMultiplayerWorld() && Keyboard.getEventKey() == this.gameSettings.keyBindChat.keyCode) {
                        this.displayGuiScreen(new GuiChat());
                    }
                }
                for (int i2 = 0; i2 < 9; ++i2) {
                    if (Keyboard.getEventKey() != 2 + i2) continue;
                    this.thePlayer.inventory.currentItem = i2;
                }
                if (Keyboard.getEventKey() != this.gameSettings.keyBindToggleFog.keyCode) continue;
                this.gameSettings.setOptionValue(4, !Keyboard.isKeyDown(42) && !Keyboard.isKeyDown(54) ? 1 : -1);
            }
            if (this.currentScreen == null) {
                if (Mouse.isButtonDown(0) && (float)(this.ticksRan - this.field_6302_aa) >= this.timer.ticksPerSecond / 4.0f && this.field_6289_L) {
                    this.clickMouse(0);
                    this.field_6302_aa = this.ticksRan;
                }
                if (Mouse.isButtonDown(1) && (float)(this.ticksRan - this.field_6302_aa) >= this.timer.ticksPerSecond / 4.0f && this.field_6289_L) {
                    this.clickMouse(1);
                    this.field_6302_aa = this.ticksRan;
                }
            }
            this.func_6254_a(0, this.currentScreen == null && Mouse.isButtonDown(0) && this.field_6289_L);
        }
        if (this.theWorld != null) {
            if (this.thePlayer != null) {
                ++this.field_6300_ab;
                if (this.field_6300_ab == 30) {
                    this.field_6300_ab = 0;
                    this.theWorld.func_705_f(this.thePlayer);
                }
            }
            this.theWorld.difficultySetting = this.gameSettings.difficulty;
            if (this.theWorld.multiplayerWorld) {
                this.theWorld.difficultySetting = 3;
            }
            if (!this.field_6316_m) {
                this.field_9243_r.func_911_a();
            }
            if (!this.field_6316_m) {
                this.field_6323_f.func_945_d();
            }
            if (!this.field_6316_m) {
                this.theWorld.func_633_c();
            }
            if (!this.field_6316_m || this.isMultiplayerWorld()) {
                this.theWorld.tick();
            }
            if (!this.field_6316_m && this.theWorld != null) {
                this.theWorld.randomDisplayUpdates(MathHelper.floor_double(this.thePlayer.posX), MathHelper.floor_double(this.thePlayer.posY), MathHelper.floor_double(this.thePlayer.posZ));
            }
            if (!this.field_6316_m) {
                this.field_6321_h.func_1193_a();
            }
        }
        this.field_6287_N = System.currentTimeMillis();
    }

    private void forceReload() {
        System.out.println("FORCING RELOAD!");
        this.sndManager = new SoundManager();
        this.sndManager.func_340_a(this.gameSettings);
        this.downloadResourcesThread.reloadResources();
    }

    public boolean isMultiplayerWorld() {
        return this.theWorld != null && this.theWorld.multiplayerWorld;
    }

    public void func_6247_b(String s2) {
        this.func_6261_a(null);
        System.gc();
        World world = new World(new File(Minecraft.getMinecraftDir(), "saves"), s2);
        if (world.field_1033_r) {
            this.func_6263_a(world, "Generating level");
        } else {
            this.func_6263_a(world, "Loading level");
        }
    }

    public void func_6237_k() {
        this.thePlayer.dimension = this.thePlayer.dimension == -1 ? 0 : -1;
        this.theWorld.setEntityDead(this.thePlayer);
        this.thePlayer.isDead = false;
        double d2 = this.thePlayer.posX;
        double d1 = this.thePlayer.posZ;
        double d22 = 8.0;
        if (this.thePlayer.dimension == -1) {
            this.thePlayer.setLocationAndAngles(d2 /= d22, this.thePlayer.posY, d1 /= d22, this.thePlayer.rotationYaw, this.thePlayer.rotationPitch);
            this.theWorld.func_4084_a(this.thePlayer, false);
            World world = new World(this.theWorld, new WorldProviderHell());
            this.func_6256_a(world, "Entering the Nether", this.thePlayer);
        } else {
            this.thePlayer.setLocationAndAngles(d2 *= d22, this.thePlayer.posY, d1 *= d22, this.thePlayer.rotationYaw, this.thePlayer.rotationPitch);
            this.theWorld.func_4084_a(this.thePlayer, false);
            World world1 = new World(this.theWorld, new WorldProvider());
            this.func_6256_a(world1, "Leaving the Nether", this.thePlayer);
        }
        this.thePlayer.worldObj = this.theWorld;
        this.thePlayer.setLocationAndAngles(d2, this.thePlayer.posY, d1, this.thePlayer.rotationYaw, this.thePlayer.rotationPitch);
        this.theWorld.func_4084_a(this.thePlayer, false);
        new Teleporter().func_4107_a(this.theWorld, this.thePlayer);
    }

    public void func_6261_a(World world) {
        this.func_6263_a(world, "");
    }

    public void func_6263_a(World world, String s2) {
        this.func_6256_a(world, s2, null);
    }

    public void func_6256_a(World world, String s2, EntityPlayer entityplayer) {
        this.loadingScreen.func_596_a(s2);
        this.loadingScreen.displayLoadingString("");
        this.sndManager.func_331_a(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        if (this.theWorld != null) {
            this.theWorld.func_651_a(this.loadingScreen);
        }
        this.theWorld = world;
        System.out.println("Player is " + this.thePlayer);
        if (world != null) {
            this.field_6327_b.func_717_a(world);
            if (!this.isMultiplayerWorld()) {
                if (entityplayer == null) {
                    this.thePlayer = (EntityPlayerSP)world.func_4085_a(EntityPlayerSP.class);
                }
            } else if (this.thePlayer != null) {
                this.thePlayer.preparePlayerToSpawn();
                if (world != null) {
                    world.entityJoinedWorld(this.thePlayer);
                }
            }
            if (!world.multiplayerWorld) {
                this.func_6255_d(s2);
            }
            System.out.println("Player is now " + this.thePlayer);
            if (this.thePlayer == null) {
                this.thePlayer = (EntityPlayerSP)this.field_6327_b.func_4087_b(world);
                this.thePlayer.preparePlayerToSpawn();
                this.field_6327_b.flipPlayer(this.thePlayer);
            }
            this.thePlayer.field_787_a = new MovementInputFromOptions(this.gameSettings);
            if (this.field_6323_f != null) {
                this.field_6323_f.func_946_a(world);
            }
            if (this.field_6321_h != null) {
                this.field_6321_h.func_1188_a(world);
            }
            this.field_6327_b.func_6473_b(this.thePlayer);
            if (entityplayer != null) {
                world.func_6464_c();
            }
            world.func_608_a(this.thePlayer);
            if (world.field_1033_r) {
                world.func_651_a(this.loadingScreen);
            }
        } else {
            this.thePlayer = null;
        }
        System.gc();
        this.field_6287_N = 0L;
    }

    private void func_6255_d(String s2) {
        this.loadingScreen.func_596_a(s2);
        this.loadingScreen.displayLoadingString("Building terrain");
        int c2 = 128;
        int i2 = 0;
        int j2 = c2 * 2 / 16 + 1;
        j2 *= j2;
        for (int k2 = -c2; k2 <= c2; k2 += 16) {
            int l2 = this.theWorld.spawnX;
            int i1 = this.theWorld.spawnZ;
            if (this.thePlayer != null) {
                l2 = (int)this.thePlayer.posX;
                i1 = (int)this.thePlayer.posZ;
            }
            for (int j1 = -c2; j1 <= c2; j1 += 16) {
                this.loadingScreen.setLoadingProgress(i2++ * 100 / j2);
                this.theWorld.getBlockId(l2 + k2, 64, i1 + j1);
                while (this.theWorld.func_6465_g()) {
                }
            }
        }
        this.loadingScreen.displayLoadingString("Simulating world for a bit");
        j2 = 2000;
        this.theWorld.func_656_j();
    }

    public void installResource(String s2, File file) {
        int i2 = s2.indexOf("/");
        String s1 = s2.substring(0, i2);
        s2 = s2.substring(i2 + 1);
        if (s1.equalsIgnoreCase("sound")) {
            this.sndManager.func_6372_a(s2, file);
        } else if (s1.equalsIgnoreCase("newsound")) {
            this.sndManager.func_6372_a(s2, file);
        } else if (s1.equalsIgnoreCase("streaming")) {
            this.sndManager.addStreaming(s2, file);
        } else if (s1.equalsIgnoreCase("music")) {
            this.sndManager.addMusic(s2, file);
        } else if (s1.equalsIgnoreCase("newmusic")) {
            this.sndManager.addMusic(s2, file);
        }
    }

    public OpenGlCapsChecker func_6251_l() {
        return this.glCapabilities;
    }

    public String func_6241_m() {
        return this.field_6323_f.func_953_b();
    }

    public String func_6262_n() {
        return this.field_6323_f.func_957_c();
    }

    public String func_6245_o() {
        return "P: " + this.field_6321_h.func_1190_b() + ". T: " + this.theWorld.func_687_d();
    }

    public void respawn() {
        if (!this.theWorld.worldProvider.func_6477_d()) {
            this.func_6237_k();
        }
        this.theWorld.func_4076_b();
        this.theWorld.func_9424_o();
        int i2 = 0;
        if (this.thePlayer != null) {
            i2 = this.thePlayer.field_620_ab;
            this.theWorld.setEntityDead(this.thePlayer);
        }
        this.thePlayer = (EntityPlayerSP)this.field_6327_b.func_4087_b(this.theWorld);
        this.thePlayer.preparePlayerToSpawn();
        this.field_6327_b.flipPlayer(this.thePlayer);
        this.theWorld.func_608_a(this.thePlayer);
        this.thePlayer.field_787_a = new MovementInputFromOptions(this.gameSettings);
        this.thePlayer.field_620_ab = i2;
        this.field_6327_b.func_6473_b(this.thePlayer);
        this.func_6255_d("Respawning");
        if (this.currentScreen instanceof GuiGameOver) {
            this.displayGuiScreen(null);
        }
    }

    public static void func_6269_a(String s2, String s1) {
        Minecraft.func_6253_a(s2, s1, null);
    }

    public static void func_6253_a(String s2, String s1, String s22) {
        boolean flag = false;
        String s3 = s2;
        Frame frame = new Frame("Minecraft");
        Canvas canvas = new Canvas();
        frame.setLayout(new BorderLayout());
        frame.add((Component)canvas, "Center");
        canvas.setPreferredSize(new Dimension(854, 480));
        frame.pack();
        frame.setLocationRelativeTo(null);
        MinecraftImpl minecraftimpl = new MinecraftImpl(frame, canvas, null, 854, 480, flag, frame);
        Thread thread = new Thread((Runnable)minecraftimpl, "Minecraft main thread");
        thread.setPriority(10);
        minecraftimpl.field_6317_l = false;
        minecraftimpl.field_6319_j = "www.minecraft.net";
        minecraftimpl.field_6320_i = s3 != null && s1 != null ? new Session(s3, s1) : new Session("Player" + System.currentTimeMillis() % 1000L, "");
        if (s22 != null) {
            String[] as2 = s22.split(":");
            minecraftimpl.func_6258_a(as2[0], Integer.parseInt(as2[1]));
        }
        frame.setVisible(true);
        frame.addWindowListener(new GameWindowListener(minecraftimpl, thread));
        thread.start();
    }

    public static void main(String[] args) {
        String s2 = "Player" + System.currentTimeMillis() % 1000L;
        if (args.length > 0) {
            s2 = args[0];
        }
        String s1 = "-";
        if (args.length > 1) {
            s1 = args[1];
        }
        s2 = "Player" + System.currentTimeMillis() % 1000L;
        s2 = "Player524";
        Minecraft.func_6269_a(s2, s1);
    }
}

