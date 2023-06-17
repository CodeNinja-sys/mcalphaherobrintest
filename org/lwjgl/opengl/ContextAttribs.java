/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.opengl.ContextAttribsImplementation;
import org.lwjgl.opengl.LinuxContextAttribs;
import org.lwjgl.opengl.MacOSXContextAttribs;
import org.lwjgl.opengl.WindowsContextAttribs;

public final class ContextAttribs {
    private int majorVersion;
    private int minorVersion;
    private int layerPlane;
    private boolean debug;
    private boolean forwardCompatible;
    private boolean profileCore;
    private boolean profileCompatibility;

    public ContextAttribs() {
        this(1, 0);
    }

    public ContextAttribs(int majorVersion, int minorVersion) {
        if (majorVersion < 0 || 3 < majorVersion || minorVersion < 0 || majorVersion == 3 && 2 < minorVersion || majorVersion == 2 && 1 < minorVersion || majorVersion == 1 && 5 < minorVersion) {
            throw new IllegalArgumentException("Invalid OpenGL version specified: " + majorVersion + '.' + minorVersion);
        }
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.layerPlane = 0;
        this.debug = false;
        this.forwardCompatible = false;
        this.profileCore = 3 < majorVersion || majorVersion == 3 && 2 <= minorVersion;
        this.profileCompatibility = false;
    }

    private ContextAttribs(ContextAttribs attribs) {
        this.majorVersion = attribs.majorVersion;
        this.minorVersion = attribs.minorVersion;
        this.layerPlane = attribs.layerPlane;
        this.debug = attribs.debug;
        this.forwardCompatible = attribs.forwardCompatible;
        this.profileCore = attribs.profileCore;
        this.profileCompatibility = attribs.profileCompatibility;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getLayerPlane() {
        return this.layerPlane;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isForwardCompatible() {
        return this.forwardCompatible;
    }

    public boolean isProfileCore() {
        return this.profileCore;
    }

    public boolean isProfileCompatibility() {
        return this.profileCompatibility;
    }

    public ContextAttribs withLayer(int layerPlane) {
        if (layerPlane < 0) {
            throw new IllegalArgumentException("Invalid layer plane specified: " + layerPlane);
        }
        if (layerPlane == this.layerPlane) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.layerPlane = layerPlane;
        return attribs;
    }

    public ContextAttribs withDebug(boolean debug) {
        if (debug == this.debug) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.debug = debug;
        return attribs;
    }

    public ContextAttribs withForwardCompatible(boolean forwardCompatible) {
        if (forwardCompatible == this.forwardCompatible) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.forwardCompatible = forwardCompatible;
        return attribs;
    }

    public ContextAttribs withProfileCore(boolean profileCore) {
        if (this.majorVersion < 3 || this.majorVersion == 3 && this.minorVersion < 2) {
            throw new IllegalArgumentException("Profiles are only supported on OpenGL version 3.2 or higher.");
        }
        if (profileCore == this.profileCore) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.profileCore = profileCore;
        if (profileCore) {
            attribs.profileCompatibility = false;
        }
        return attribs;
    }

    public ContextAttribs withProfileCompatibility(boolean profileCompatibility) {
        if (this.majorVersion < 3 || this.majorVersion == 3 && this.minorVersion < 2) {
            throw new IllegalArgumentException("Profiles are only supported on OpenGL version 3.2 or higher.");
        }
        if (profileCompatibility == this.profileCompatibility) {
            return this;
        }
        ContextAttribs attribs = new ContextAttribs(this);
        attribs.profileCompatibility = profileCompatibility;
        if (profileCompatibility) {
            attribs.profileCore = false;
        }
        return attribs;
    }

    private static ContextAttribsImplementation getImplementation() {
        switch (LWJGLUtil.getPlatform()) {
            case 1: {
                return new LinuxContextAttribs();
            }
            case 3: {
                return new WindowsContextAttribs();
            }
            case 2: {
                return new MacOSXContextAttribs();
            }
        }
        throw new IllegalStateException("Unsupported platform");
    }

    IntBuffer getAttribList() {
        ContextAttribsImplementation implementation = ContextAttribs.getImplementation();
        int attribCount = 0;
        if (this.majorVersion != 1 || this.minorVersion != 0) {
            attribCount += 2;
        }
        if (0 < this.layerPlane) {
            ++attribCount;
        }
        int flags = 0;
        if (this.debug) {
            flags |= implementation.getDebugBit();
        }
        if (this.forwardCompatible) {
            flags |= implementation.getForwardCompatibleBit();
        }
        if (0 < flags) {
            ++attribCount;
        }
        int profileMask = 0;
        if (this.profileCore) {
            profileMask |= implementation.getProfileCoreBit();
        } else if (this.profileCompatibility) {
            profileMask |= implementation.getProfileCompatibilityBit();
        }
        if (0 < profileMask) {
            ++attribCount;
        }
        if (attribCount == 0) {
            return null;
        }
        IntBuffer attribs = BufferUtils.createIntBuffer(attribCount * 2 + 1);
        if (this.majorVersion != 1 || this.minorVersion != 0) {
            attribs.put(implementation.getMajorVersionAttrib()).put(this.majorVersion);
            attribs.put(implementation.getMinorVersionAttrib()).put(this.minorVersion);
        }
        if (0 < this.layerPlane) {
            attribs.put(implementation.getLayerPlaneAttrib()).put(this.layerPlane);
        }
        if (0 < flags) {
            attribs.put(implementation.getFlagsAttrib()).put(flags);
        }
        if (0 < profileMask) {
            attribs.put(implementation.getProfileMaskAttrib()).put(profileMask);
        }
        attribs.put(0);
        attribs.rewind();
        return attribs;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(32);
        sb.append("ContextAttribs:");
        sb.append(" Version=").append(this.majorVersion).append('.').append(this.minorVersion);
        sb.append(" - Layer=").append(this.layerPlane);
        sb.append(" - Debug=").append(this.debug);
        sb.append(" - ForwardCompatible=").append(this.forwardCompatible);
        sb.append(" - Profile=");
        if (this.profileCore) {
            sb.append("Core");
        } else if (this.profileCompatibility) {
            sb.append("Compatibility");
        } else {
            sb.append("None");
        }
        return sb.toString();
    }
}

