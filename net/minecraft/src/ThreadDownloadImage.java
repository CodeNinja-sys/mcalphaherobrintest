/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import net.minecraft.src.ImageBuffer;
import net.minecraft.src.ThreadDownloadImageData;

class ThreadDownloadImage
extends Thread {
    final String location;
    final ImageBuffer buffer;
    final ThreadDownloadImageData imageData;

    ThreadDownloadImage(ThreadDownloadImageData threaddownloadimagedata, String s2, ImageBuffer imagebuffer) {
        this.imageData = threaddownloadimagedata;
        this.location = s2;
        this.buffer = imagebuffer;
    }

    @Override
    public void run() {
        block8: {
            HttpURLConnection httpurlconnection = null;
            try {
                URL url = new URL(this.location);
                httpurlconnection = (HttpURLConnection)url.openConnection();
                httpurlconnection.setDoInput(true);
                httpurlconnection.setDoOutput(false);
                httpurlconnection.connect();
                if (httpurlconnection.getResponseCode() == 404) {
                    return;
                }
                try {
                    if (this.buffer == null) {
                        this.imageData.image = ImageIO.read(httpurlconnection.getInputStream());
                        break block8;
                    }
                    this.imageData.image = this.buffer.func_883_a(ImageIO.read(httpurlconnection.getInputStream()));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            finally {
                httpurlconnection.disconnect();
            }
        }
    }
}

