/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ThreadDownloadResources
extends Thread {
    public File resourcesFolder;
    private Minecraft mc;
    private boolean closing = false;

    public ThreadDownloadResources(File file, Minecraft minecraft) {
        this.mc = minecraft;
        this.setName("Resource download thread");
        this.setDaemon(true);
        this.resourcesFolder = new File(file, "resources/");
        if (!this.resourcesFolder.exists() && !this.resourcesFolder.mkdirs()) {
            throw new RuntimeException("The working directory could not be created: " + this.resourcesFolder);
        }
    }

    @Override
    public void run() {
        try {
            URL url = new URL("http://s3.amazonaws.com/MinecraftResources/");
            DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
            Document document = documentbuilder.parse(url.openStream());
            NodeList nodelist = document.getElementsByTagName("Contents");
            for (int i2 = 0; i2 < 2; ++i2) {
                for (int j2 = 0; j2 < nodelist.getLength(); ++j2) {
                    Node node = nodelist.item(j2);
                    if (node.getNodeType() != 1) continue;
                    Element element = (Element)node;
                    String s2 = ((Element)element.getElementsByTagName("Key").item(0)).getChildNodes().item(0).getNodeValue();
                    long l2 = Long.parseLong(((Element)element.getElementsByTagName("Size").item(0)).getChildNodes().item(0).getNodeValue());
                    if (l2 <= 0L) continue;
                    this.downloadAndInstallResource(url, s2, l2, i2);
                    if (!this.closing) continue;
                    return;
                }
            }
        }
        catch (Exception exception) {
            this.loadResource(this.resourcesFolder, "");
            exception.printStackTrace();
        }
    }

    public void reloadResources() {
        this.loadResource(this.resourcesFolder, "");
    }

    private void loadResource(File file, String s2) {
        File[] afile = file.listFiles();
        for (int i2 = 0; i2 < afile.length; ++i2) {
            if (afile[i2].isDirectory()) {
                this.loadResource(afile[i2], s2 + afile[i2].getName() + "/");
                continue;
            }
            try {
                this.mc.installResource(s2 + afile[i2].getName(), afile[i2]);
                continue;
            }
            catch (Exception exception) {
                System.out.println("Failed to add " + s2 + afile[i2].getName());
            }
        }
    }

    private void downloadAndInstallResource(URL url, String s2, long l2, int i2) {
        try {
            int j2 = s2.indexOf("/");
            String s1 = s2.substring(0, j2);
            if (s1.equals("sound") || s1.equals("newsound") ? i2 != 0 : i2 != 1) {
                return;
            }
            File file = new File(this.resourcesFolder, s2);
            if (!file.exists() || file.length() != l2) {
                file.getParentFile().mkdirs();
                String s22 = s2.replaceAll(" ", "%20");
                this.downloadResource(new URL(url, s22), file, l2);
                if (this.closing) {
                    return;
                }
            }
            this.mc.installResource(s2, file);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void downloadResource(URL url, File file, long l2) throws IOException {
        byte[] abyte0 = new byte[4096];
        DataInputStream datainputstream = new DataInputStream(url.openStream());
        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
        int i2 = 0;
        while ((i2 = datainputstream.read(abyte0)) >= 0) {
            dataoutputstream.write(abyte0, 0, i2);
            if (!this.closing) continue;
            return;
        }
        datainputstream.close();
        dataoutputstream.close();
    }

    public void closeMinecraft() {
        this.closing = true;
    }
}

