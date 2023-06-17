/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferChecks;
import org.lwjgl.opengl.APIUtils;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.GLContext;

public final class AMDPerformanceMonitor {
    public static final int GL_COUNTER_TYPE_AMD = 35776;
    public static final int GL_COUNTER_RANGE_AMD = 35777;
    public static final int GL_UNSIGNED_INT = 5125;
    public static final int GL_FLOAT = 5126;
    public static final int GL_UNSIGNED_INT64_AMD = 35778;
    public static final int GL_PERCENTAGE_AMD = 35779;
    public static final int GL_PERFMON_RESULT_AVAILABLE_AMD = 35780;
    public static final int GL_PERFMON_RESULT_SIZE_AMD = 35781;
    public static final int GL_PERFMON_RESULT_AMD = 35782;

    private AMDPerformanceMonitor() {
    }

    public static void glGetPerfMonitorGroupsAMD(IntBuffer numGroups, IntBuffer groups) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorGroupsAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (numGroups != null) {
            BufferChecks.checkBuffer(numGroups, 1);
        }
        BufferChecks.checkDirect(groups);
        AMDPerformanceMonitor.nglGetPerfMonitorGroupsAMD(numGroups, numGroups != null ? numGroups.position() : 0, groups.remaining(), groups, groups.position(), function_pointer);
    }

    private static native void nglGetPerfMonitorGroupsAMD(IntBuffer var0, int var1, int var2, IntBuffer var3, int var4, long var5);

    public static void glGetPerfMonitorCountersAMD(int group, IntBuffer numCounters, IntBuffer maxActiveCounters, IntBuffer counters) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorCountersAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(numCounters, 1);
        BufferChecks.checkBuffer(maxActiveCounters, 1);
        BufferChecks.checkDirect(counters);
        AMDPerformanceMonitor.nglGetPerfMonitorCountersAMD(group, numCounters, numCounters.position(), maxActiveCounters, maxActiveCounters.position(), counters.remaining(), counters, counters.position(), function_pointer);
    }

    private static native void nglGetPerfMonitorCountersAMD(int var0, IntBuffer var1, int var2, IntBuffer var3, int var4, int var5, IntBuffer var6, int var7, long var8);

    public static void glGetPerfMonitorGroupStringAMD(int group, IntBuffer length, ByteBuffer groupString) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorGroupStringAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(groupString);
        AMDPerformanceMonitor.nglGetPerfMonitorGroupStringAMD(group, groupString.remaining(), length, length != null ? length.position() : 0, groupString, groupString.position(), function_pointer);
    }

    private static native void nglGetPerfMonitorGroupStringAMD(int var0, int var1, IntBuffer var2, int var3, ByteBuffer var4, int var5, long var6);

    public static String glGetPerfMonitorGroupStringAMD(int group, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorGroupStringAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer groupString_length = APIUtils.getLengths();
        ByteBuffer groupString = APIUtils.getBufferByte(bufSize);
        AMDPerformanceMonitor.nglGetPerfMonitorGroupStringAMD(group, bufSize, groupString_length, 0, groupString, groupString.position(), function_pointer);
        groupString.limit(groupString_length.get(0));
        return APIUtils.getString(groupString);
    }

    public static void glGetPerfMonitorCounterStringAMD(int group, int counter, IntBuffer length, ByteBuffer counterString) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorCounterStringAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        if (length != null) {
            BufferChecks.checkBuffer(length, 1);
        }
        BufferChecks.checkDirect(counterString);
        AMDPerformanceMonitor.nglGetPerfMonitorCounterStringAMD(group, counter, counterString.remaining(), length, length != null ? length.position() : 0, counterString, counterString.position(), function_pointer);
    }

    private static native void nglGetPerfMonitorCounterStringAMD(int var0, int var1, int var2, IntBuffer var3, int var4, ByteBuffer var5, int var6, long var7);

    public static String glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorCounterStringAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer counterString_length = APIUtils.getLengths();
        ByteBuffer counterString = APIUtils.getBufferByte(bufSize);
        AMDPerformanceMonitor.nglGetPerfMonitorCounterStringAMD(group, counter, bufSize, counterString_length, 0, counterString, counterString.position(), function_pointer);
        counterString.limit(counterString_length.get(0));
        return APIUtils.getString(counterString);
    }

    public static void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, ByteBuffer data) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorCounterInfoAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkBuffer(data, 16);
        AMDPerformanceMonitor.nglGetPerfMonitorCounterInfoAMD(group, counter, pname, data, data.position(), function_pointer);
    }

    private static native void nglGetPerfMonitorCounterInfoAMD(int var0, int var1, int var2, ByteBuffer var3, int var4, long var5);

    public static void glGenPerfMonitorsAMD(IntBuffer monitors) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGenPerfMonitorsAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(monitors);
        AMDPerformanceMonitor.nglGenPerfMonitorsAMD(monitors.remaining(), monitors, monitors.position(), function_pointer);
    }

    private static native void nglGenPerfMonitorsAMD(int var0, IntBuffer var1, int var2, long var3);

    public static int glGenPerfMonitorsAMD() {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGenPerfMonitorsAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer monitors = APIUtils.getBufferInt();
        AMDPerformanceMonitor.nglGenPerfMonitorsAMD(1, monitors, monitors.position(), function_pointer);
        return monitors.get(0);
    }

    public static void glDeletePerfMonitorsAMD(IntBuffer monitors) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glDeletePerfMonitorsAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(monitors);
        AMDPerformanceMonitor.nglDeletePerfMonitorsAMD(monitors.remaining(), monitors, monitors.position(), function_pointer);
    }

    private static native void nglDeletePerfMonitorsAMD(int var0, IntBuffer var1, int var2, long var3);

    public static void glDeletePerfMonitorsAMD(int monitor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glDeletePerfMonitorsAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDPerformanceMonitor.nglDeletePerfMonitorsAMD(1, APIUtils.getBufferInt().put(0, monitor), 0, function_pointer);
    }

    public static void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, IntBuffer counterList) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glSelectPerfMonitorCountersAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(counterList);
        AMDPerformanceMonitor.nglSelectPerfMonitorCountersAMD(monitor, enable, group, counterList.remaining(), counterList, counterList.position(), function_pointer);
    }

    private static native void nglSelectPerfMonitorCountersAMD(int var0, boolean var1, int var2, int var3, IntBuffer var4, int var5, long var6);

    public static void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int counter) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glSelectPerfMonitorCountersAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDPerformanceMonitor.nglSelectPerfMonitorCountersAMD(monitor, enable, group, 1, APIUtils.getBufferInt().put(0, counter), 0, function_pointer);
    }

    public static void glBeginPerfMonitorAMD(int monitor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glBeginPerfMonitorAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDPerformanceMonitor.nglBeginPerfMonitorAMD(monitor, function_pointer);
    }

    private static native void nglBeginPerfMonitorAMD(int var0, long var1);

    public static void glEndPerfMonitorAMD(int monitor) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glEndPerfMonitorAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        AMDPerformanceMonitor.nglEndPerfMonitorAMD(monitor, function_pointer);
    }

    private static native void nglEndPerfMonitorAMD(int var0, long var1);

    public static void glGetPerfMonitorCounterDataAMD(int monitor, int pname, IntBuffer data, IntBuffer bytesWritten) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorCounterDataAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        BufferChecks.checkDirect(data);
        if (bytesWritten != null) {
            BufferChecks.checkBuffer(bytesWritten, 1);
        }
        AMDPerformanceMonitor.nglGetPerfMonitorCounterDataAMD(monitor, pname, data.remaining(), data, data.position(), bytesWritten, bytesWritten != null ? bytesWritten.position() : 0, function_pointer);
    }

    private static native void nglGetPerfMonitorCounterDataAMD(int var0, int var1, int var2, IntBuffer var3, int var4, IntBuffer var5, int var6, long var7);

    public static int glGetPerfMonitorCounterDataAMD(int monitor, int pname) {
        ContextCapabilities caps = GLContext.getCapabilities();
        long function_pointer = caps.AMD_performance_monitor_glGetPerfMonitorCounterDataAMD_pointer;
        BufferChecks.checkFunctionAddress(function_pointer);
        IntBuffer data = APIUtils.getBufferInt();
        AMDPerformanceMonitor.nglGetPerfMonitorCounterDataAMD(monitor, pname, 4, data, data.position(), null, 0, function_pointer);
        return data.get(0);
    }
}

