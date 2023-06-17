/*
 * Decompiled with CFR 0.150.
 */
package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.util.plugins.Plugins;

class DefaultControllerEnvironment
extends ControllerEnvironment {
    static String libPath;
    private ArrayList controllers;
    private Collection loadedPlugins = new ArrayList();

    static void loadLibrary(final String lib_name) {
        AccessController.doPrivileged(new PrivilegedAction(){

            public final Object run() {
                String lib_path = System.getProperty("net.java.games.input.librarypath");
                if (lib_path != null) {
                    System.load(lib_path + File.separator + System.mapLibraryName(lib_name));
                } else {
                    System.loadLibrary(lib_name);
                }
                return null;
            }
        });
    }

    static String getPrivilegedProperty(final String property) {
        return (String)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return System.getProperty(property);
            }
        });
    }

    static String getPrivilegedProperty(final String property, final String default_value) {
        return (String)AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                return System.getProperty(property, default_value);
            }
        });
    }

    public Controller[] getControllers() {
        if (this.controllers == null) {
            this.controllers = new ArrayList();
            AccessController.doPrivileged(new PrivilegedAction(){

                public Object run() {
                    DefaultControllerEnvironment.this.scanControllers();
                    return null;
                }
            });
            String pluginClasses = DefaultControllerEnvironment.getPrivilegedProperty("jinput.plugins", "") + " " + DefaultControllerEnvironment.getPrivilegedProperty("net.java.games.input.plugins", "");
            if (!DefaultControllerEnvironment.getPrivilegedProperty("jinput.useDefaultPlugin", "true").toLowerCase().trim().equals("false") && !DefaultControllerEnvironment.getPrivilegedProperty("net.java.games.input.useDefaultPlugin", "true").toLowerCase().trim().equals("false")) {
                String osName = DefaultControllerEnvironment.getPrivilegedProperty("os.name", "").trim();
                if (osName.equals("Linux")) {
                    pluginClasses = pluginClasses + " net.java.games.input.LinuxEnvironmentPlugin";
                } else if (osName.equals("Mac OS X")) {
                    pluginClasses = pluginClasses + " net.java.games.input.OSXEnvironmentPlugin";
                } else if (osName.equals("Windows XP") || osName.equals("Windows Vista")) {
                    pluginClasses = pluginClasses + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
                } else if (osName.equals("Windows 98") || osName.equals("Windows 2000")) {
                    pluginClasses = pluginClasses + " net.java.games.input.DirectInputEnvironmentPlugin";
                } else if (osName.startsWith("Windows")) {
                    System.out.println("WARNING: Found unknown Windows version: " + osName);
                    System.out.println("Attempting to use default windows plug-in.");
                    System.out.flush();
                    pluginClasses = pluginClasses + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
                } else {
                    System.out.println("Trying to use default plugin, OS name " + osName + " not recognised");
                }
            }
            StringTokenizer pluginClassTok = new StringTokenizer(pluginClasses, " \t\n\r\f,;:");
            while (pluginClassTok.hasMoreTokens()) {
                String className = pluginClassTok.nextToken();
                try {
                    if (this.loadedPlugins.contains(className)) continue;
                    System.out.println("Loading: " + className);
                    Class<?> ceClass = Class.forName(className);
                    ControllerEnvironment ce2 = (ControllerEnvironment)ceClass.newInstance();
                    if (ce2.isSupported()) {
                        this.addControllers(ce2.getControllers());
                        this.loadedPlugins.add(ce2.getClass().getName());
                        continue;
                    }
                    DefaultControllerEnvironment.logln(ceClass.getName() + " is not supported");
                }
                catch (Throwable e2) {
                    e2.printStackTrace();
                }
            }
        }
        Controller[] ret = new Controller[this.controllers.size()];
        Iterator it2 = this.controllers.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            ret[i2] = (Controller)it2.next();
            ++i2;
        }
        return ret;
    }

    private void scanControllers() {
        String pluginPathName = DefaultControllerEnvironment.getPrivilegedProperty("jinput.controllerPluginPath");
        if (pluginPathName == null) {
            pluginPathName = "controller";
        }
        this.scanControllersAt(DefaultControllerEnvironment.getPrivilegedProperty("java.home") + File.separator + "lib" + File.separator + pluginPathName);
        this.scanControllersAt(DefaultControllerEnvironment.getPrivilegedProperty("user.dir") + File.separator + pluginPathName);
    }

    private void scanControllersAt(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        try {
            Plugins plugins = new Plugins(file);
            Class[] envClasses = plugins.getExtends(ControllerEnvironment.class);
            for (int i2 = 0; i2 < envClasses.length; ++i2) {
                try {
                    ControllerEnvironment.logln("ControllerEnvironment " + envClasses[i2].getName() + " loaded by " + envClasses[i2].getClassLoader());
                    ControllerEnvironment ce2 = (ControllerEnvironment)envClasses[i2].newInstance();
                    if (ce2.isSupported()) {
                        this.addControllers(ce2.getControllers());
                        this.loadedPlugins.add(ce2.getClass().getName());
                        continue;
                    }
                    DefaultControllerEnvironment.logln(envClasses[i2].getName() + " is not supported");
                    continue;
                }
                catch (Throwable e2) {
                    e2.printStackTrace();
                }
            }
        }
        catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void addControllers(Controller[] c2) {
        for (int i2 = 0; i2 < c2.length; ++i2) {
            this.controllers.add(c2[i2]);
        }
    }

    public boolean isSupported() {
        return true;
    }
}

