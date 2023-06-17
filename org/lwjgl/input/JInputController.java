/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.input;

import java.util.ArrayList;
import net.java.games.input.Component;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import org.lwjgl.input.Controller;
import org.lwjgl.input.ControllerEvent;
import org.lwjgl.input.Controllers;

class JInputController
implements Controller {
    private net.java.games.input.Controller target;
    private int index;
    private ArrayList buttons = new ArrayList();
    private ArrayList axes = new ArrayList();
    private ArrayList pov = new ArrayList();
    private boolean[] buttonState;
    private float[] povValues;
    private float[] axesValue;
    private float[] axesMax;
    private float[] deadZones;
    private int xaxis = -1;
    private int yaxis = -1;
    private int zaxis = -1;
    private int rxaxis = -1;
    private int ryaxis = -1;
    private int rzaxis = -1;

    public JInputController(int index, net.java.games.input.Controller target) {
        int i2;
        this.target = target;
        this.index = index;
        Component[] sourceAxes = target.getComponents();
        for (int i3 = 0; i3 < sourceAxes.length; ++i3) {
            if (sourceAxes[i3].getIdentifier() instanceof Component.Identifier.Button) {
                this.buttons.add(sourceAxes[i3]);
                continue;
            }
            if (sourceAxes[i3].getIdentifier().equals(Component.Identifier.Axis.POV)) {
                this.pov.add(sourceAxes[i3]);
                continue;
            }
            this.axes.add(sourceAxes[i3]);
        }
        this.buttonState = new boolean[this.buttons.size()];
        this.povValues = new float[this.pov.size()];
        this.axesValue = new float[this.axes.size()];
        int buttonsCount = 0;
        int axesCount = 0;
        for (i2 = 0; i2 < sourceAxes.length; ++i2) {
            if (sourceAxes[i2].getIdentifier() instanceof Component.Identifier.Button) {
                this.buttonState[buttonsCount] = sourceAxes[i2].getPollData() != 0.0f;
                ++buttonsCount;
                continue;
            }
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.POV)) continue;
            this.axesValue[axesCount] = sourceAxes[i2].getPollData();
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.X)) {
                this.xaxis = axesCount;
            }
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.Y)) {
                this.yaxis = axesCount;
            }
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.Z)) {
                this.zaxis = axesCount;
            }
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.RX)) {
                this.rxaxis = axesCount;
            }
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.RY)) {
                this.ryaxis = axesCount;
            }
            if (sourceAxes[i2].getIdentifier().equals(Component.Identifier.Axis.RZ)) {
                this.rzaxis = axesCount;
            }
            ++axesCount;
        }
        this.axesMax = new float[this.axes.size()];
        this.deadZones = new float[this.axes.size()];
        for (i2 = 0; i2 < this.axesMax.length; ++i2) {
            this.axesMax[i2] = 1.0f;
            this.deadZones[i2] = 0.05f;
        }
    }

    public String getName() {
        String name = this.target.getName();
        return name;
    }

    public int getIndex() {
        return this.index;
    }

    public int getButtonCount() {
        return this.buttons.size();
    }

    public String getButtonName(int index) {
        Component button = (Component)this.buttons.get(index);
        return button.getName();
    }

    public boolean isButtonPressed(int index) {
        return this.buttonState[index];
    }

    public void poll() {
        this.target.poll();
        Event event = new Event();
        EventQueue queue = this.target.getEventQueue();
        while (queue.getNextEvent(event)) {
            if (this.buttons.contains(event.getComponent())) {
                Component button = event.getComponent();
                int buttonIndex = this.buttons.indexOf(button);
                this.buttonState[buttonIndex] = event.getValue() != 0.0f;
                Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 1, buttonIndex, false, false));
            }
            if (this.pov.contains(event.getComponent())) {
                Component povComponent = event.getComponent();
                int povIndex = this.pov.indexOf(povComponent);
                float prevX = this.getPovX();
                float prevY = this.getPovY();
                this.povValues[povIndex] = event.getValue();
                if (prevX != this.getPovX()) {
                    Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 3, 0, false, false));
                }
                if (prevY != this.getPovY()) {
                    Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 4, 0, false, false));
                }
            }
            if (!this.axes.contains(event.getComponent())) continue;
            Component axis = event.getComponent();
            int axisIndex = this.axes.indexOf(axis);
            float value = axis.getPollData();
            if (Math.abs(value) < this.deadZones[axisIndex]) {
                value = 0.0f;
            }
            if (Math.abs(value) < axis.getDeadZone()) {
                value = 0.0f;
            }
            if (Math.abs(value) > this.axesMax[axisIndex]) {
                this.axesMax[axisIndex] = Math.abs(value);
            }
            Controllers.addEvent(new ControllerEvent(this, event.getNanos(), 2, axisIndex, axisIndex == this.xaxis, axisIndex == this.yaxis));
            this.axesValue[axisIndex] = value /= this.axesMax[axisIndex];
        }
    }

    public int getAxisCount() {
        return this.axes.size();
    }

    public String getAxisName(int index) {
        Component axis = (Component)this.axes.get(index);
        return axis.getName();
    }

    public float getAxisValue(int index) {
        return this.axesValue[index];
    }

    public float getXAxisValue() {
        if (this.xaxis == -1) {
            return 0.0f;
        }
        return this.getAxisValue(this.xaxis);
    }

    public float getYAxisValue() {
        if (this.yaxis == -1) {
            return 0.0f;
        }
        return this.getAxisValue(this.yaxis);
    }

    public float getXAxisDeadZone() {
        if (this.xaxis == -1) {
            return 0.0f;
        }
        return this.getDeadZone(this.xaxis);
    }

    public float getYAxisDeadZone() {
        if (this.yaxis == -1) {
            return 0.0f;
        }
        return this.getDeadZone(this.yaxis);
    }

    public void setXAxisDeadZone(float zone) {
        this.setDeadZone(this.xaxis, zone);
    }

    public void setYAxisDeadZone(float zone) {
        this.setDeadZone(this.yaxis, zone);
    }

    public float getDeadZone(int index) {
        return this.deadZones[index];
    }

    public void setDeadZone(int index, float zone) {
        this.deadZones[index] = zone;
    }

    public float getZAxisValue() {
        if (this.zaxis == -1) {
            return 0.0f;
        }
        return this.getAxisValue(this.zaxis);
    }

    public float getZAxisDeadZone() {
        if (this.zaxis == -1) {
            return 0.0f;
        }
        return this.getDeadZone(this.zaxis);
    }

    public void setZAxisDeadZone(float zone) {
        this.setDeadZone(this.zaxis, zone);
    }

    public float getRXAxisValue() {
        if (this.rxaxis == -1) {
            return 0.0f;
        }
        return this.getAxisValue(this.rxaxis);
    }

    public float getRXAxisDeadZone() {
        if (this.rxaxis == -1) {
            return 0.0f;
        }
        return this.getDeadZone(this.rxaxis);
    }

    public void setRXAxisDeadZone(float zone) {
        this.setDeadZone(this.rxaxis, zone);
    }

    public float getRYAxisValue() {
        if (this.ryaxis == -1) {
            return 0.0f;
        }
        return this.getAxisValue(this.ryaxis);
    }

    public float getRYAxisDeadZone() {
        if (this.ryaxis == -1) {
            return 0.0f;
        }
        return this.getDeadZone(this.ryaxis);
    }

    public void setRYAxisDeadZone(float zone) {
        this.setDeadZone(this.ryaxis, zone);
    }

    public float getRZAxisValue() {
        if (this.rzaxis == -1) {
            return 0.0f;
        }
        return this.getAxisValue(this.rzaxis);
    }

    public float getRZAxisDeadZone() {
        if (this.rzaxis == -1) {
            return 0.0f;
        }
        return this.getDeadZone(this.rzaxis);
    }

    public void setRZAxisDeadZone(float zone) {
        this.setDeadZone(this.rzaxis, zone);
    }

    public float getPovX() {
        if (this.pov.size() == 0) {
            return 0.0f;
        }
        float value = this.povValues[0];
        if (value == 0.875f || value == 0.125f || value == 1.0f) {
            return -1.0f;
        }
        if (value == 0.625f || value == 0.375f || value == 0.5f) {
            return 1.0f;
        }
        return 0.0f;
    }

    public float getPovY() {
        if (this.pov.size() == 0) {
            return 0.0f;
        }
        float value = this.povValues[0];
        if (value == 0.875f || value == 0.625f || value == 0.75f) {
            return 1.0f;
        }
        if (value == 0.125f || value == 0.375f || value == 0.25f) {
            return -1.0f;
        }
        return 0.0f;
    }
}

