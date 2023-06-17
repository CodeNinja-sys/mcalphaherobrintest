/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

import java.io.File;
import net.minecraft.src.CanvasIsomPreview;
import net.minecraft.src.ChunkLoader;
import net.minecraft.src.ChunkProviderIso;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;

class WorldIso
extends World {
    final CanvasIsomPreview field_1051_z;

    WorldIso(CanvasIsomPreview canvasisompreview, File file, String s2) {
        super(file, s2);
        this.field_1051_z = canvasisompreview;
    }

    @Override
    protected IChunkProvider func_4081_a(File file) {
        return new ChunkProviderIso(this, new ChunkLoader(file, false));
    }
}

