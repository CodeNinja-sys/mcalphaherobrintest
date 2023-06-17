/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.IOException;
import java.io.InputStream;
import net.minecraft.src.MusInputStream;
import paulscode.sound.codecs.CodecJOrbis;

public class CodecMus
extends CodecJOrbis {
    @Override
    protected InputStream openInputStream() {
        try {
            return new MusInputStream(this, this.url, this.urlConnection.getInputStream());
        }
        catch (IOException e2) {
            return null;
        }
    }
}

