/*
 * Decompiled with CFR 0.150.
 */
package paulscode.sound;

import javax.sound.sampled.AudioFormat;

public class SoundBuffer {
    public byte[] audioData;
    public AudioFormat audioFormat;

    public SoundBuffer(byte[] arrby, AudioFormat audioFormat) {
        this.audioData = arrby;
        this.audioFormat = audioFormat;
    }

    public void cleanup() {
        this.audioData = null;
        this.audioFormat = null;
    }

    public void trimData(int n2) {
        if (this.audioData == null || n2 == 0) {
            this.audioData = null;
        } else if (this.audioData.length > n2) {
            byte[] arrby = new byte[n2];
            System.arraycopy(this.audioData, 0, arrby, 0, n2);
            this.audioData = arrby;
        }
    }
}

