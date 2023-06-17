/*
 * Decompiled with CFR 0.150.
 */
package org.lwjgl.input;

import java.util.ArrayList;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.ControllerEvent;
import org.lwjgl.input.JInputController;

public class Controllers {
    private static ArrayList controllers = new ArrayList();
    private static int controllerCount;
    private static ArrayList events;
    private static ControllerEvent event;
    private static boolean created;

    public static void create() throws LWJGLException {
        if (created) {
            return;
        }
        try {
            ControllerEnvironment env = ControllerEnvironment.getDefaultEnvironment();
            net.java.games.input.Controller[] found = env.getControllers();
            ArrayList<net.java.games.input.Controller> lollers = new ArrayList<net.java.games.input.Controller>();
            for (int i2 = 0; i2 < found.length; ++i2) {
                net.java.games.input.Controller c2 = found[i2];
                if (c2.getType().equals(Controller.Type.KEYBOARD) || c2.getType().equals(Controller.Type.MOUSE)) continue;
                lollers.add(c2);
            }
            int length = lollers.size();
            for (int i3 = 0; i3 < length; ++i3) {
                net.java.games.input.Controller c3 = (net.java.games.input.Controller)lollers.get(i3);
                Controllers.createController(c3);
            }
            created = true;
        }
        catch (Throwable e2) {
            throw new LWJGLException("Failed to initialise controllers", e2);
        }
    }

    private static void createController(net.java.games.input.Controller c2) {
        net.java.games.input.Controller[] sub = c2.getControllers();
        if (sub.length == 0) {
            JInputController controller = new JInputController(controllerCount, c2);
            controllers.add(controller);
            ++controllerCount;
        } else {
            for (int i2 = 0; i2 < sub.length; ++i2) {
                Controllers.createController(sub[i2]);
            }
        }
    }

    public static Controller getController(int index) {
        return (Controller)controllers.get(index);
    }

    public static int getControllerCount() {
        return controllers.size();
    }

    public static void poll() {
        for (int i2 = 0; i2 < controllers.size(); ++i2) {
            Controllers.getController(i2).poll();
        }
    }

    public static void clearEvents() {
        events.clear();
    }

    public static boolean next() {
        if (events.size() == 0) {
            event = null;
            return false;
        }
        event = (ControllerEvent)events.remove(0);
        return event != null;
    }

    public static boolean isCreated() {
        return created;
    }

    public static void destroy() {
    }

    public static Controller getEventSource() {
        return event.getSource();
    }

    public static int getEventControlIndex() {
        return event.getControlIndex();
    }

    public static boolean isEventButton() {
        return event.isButton();
    }

    public static boolean isEventAxis() {
        return event.isAxis();
    }

    public static boolean isEventXAxis() {
        return event.isXAxis();
    }

    public static boolean isEventYAxis() {
        return event.isYAxis();
    }

    public static boolean isEventPovX() {
        return event.isPovX();
    }

    public static boolean isEventPovY() {
        return event.isPovY();
    }

    public static long getEventNanoseconds() {
        return event.getTimeStamp();
    }

    static void addEvent(ControllerEvent event) {
        if (event != null) {
            events.add(event);
        }
    }

    static {
        events = new ArrayList();
    }
}
