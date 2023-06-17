/*
 * Decompiled with CFR 0.150.
 */
package net.minecraft.src;

public class ChatLine {
    public String message;
    public int updateCounter;

    public ChatLine(String s2) {
        this.message = s2;
        this.updateCounter = 0;
    }
}

