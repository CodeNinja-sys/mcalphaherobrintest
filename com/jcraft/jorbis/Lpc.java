/*
 * Decompiled with CFR 0.150.
 */
package com.jcraft.jorbis;

import com.jcraft.jorbis.Drft;

class Lpc {
    Drft fft = new Drft();
    int ln;
    int m;

    Lpc() {
    }

    static float lpc_from_data(float[] arrf, float[] arrf2, int n2, int n3) {
        int n4;
        float f2;
        float[] arrf3 = new float[n3 + 1];
        int n5 = n3 + 1;
        while (n5-- != 0) {
            f2 = 0.0f;
            for (n4 = n5; n4 < n2; ++n4) {
                f2 += arrf[n4] * arrf[n4 - n5];
            }
            arrf3[n5] = f2;
        }
        float f3 = arrf3[0];
        for (n4 = 0; n4 < n3; ++n4) {
            f2 = -arrf3[n4 + 1];
            if (f3 == 0.0f) {
                for (int i2 = 0; i2 < n3; ++i2) {
                    arrf2[i2] = 0.0f;
                }
                return 0.0f;
            }
            for (n5 = 0; n5 < n4; ++n5) {
                f2 -= arrf2[n5] * arrf3[n4 - n5];
            }
            arrf2[n4] = f2 /= f3;
            for (n5 = 0; n5 < n4 / 2; ++n5) {
                float f4 = arrf2[n5];
                int n6 = n5;
                arrf2[n6] = arrf2[n6] + f2 * arrf2[n4 - 1 - n5];
                int n7 = n4 - 1 - n5;
                arrf2[n7] = arrf2[n7] + f2 * f4;
            }
            if (n4 % 2 != 0) {
                int n8 = n5;
                arrf2[n8] = arrf2[n8] + arrf2[n5] * f2;
            }
            f3 = (float)((double)f3 * (1.0 - (double)(f2 * f2)));
        }
        return f3;
    }

    float lpc_from_curve(float[] arrf, float[] arrf2) {
        int n2;
        int n3 = this.ln;
        float[] arrf3 = new float[n3 + n3];
        float f2 = (float)(0.5 / (double)n3);
        for (n2 = 0; n2 < n3; ++n2) {
            arrf3[n2 * 2] = arrf[n2] * f2;
            arrf3[n2 * 2 + 1] = 0.0f;
        }
        arrf3[n3 * 2 - 1] = arrf[n3 - 1] * f2;
        this.fft.backward(arrf3);
        n2 = 0;
        int n4 = (n3 *= 2) / 2;
        while (n2 < n3 / 2) {
            float f3 = arrf3[n2];
            arrf3[n2++] = arrf3[n4];
            arrf3[n4++] = f3;
        }
        return Lpc.lpc_from_data(arrf3, arrf2, n3, this.m);
    }

    void init(int n2, int n3) {
        this.ln = n2;
        this.m = n3;
        this.fft.init(n2 * 2);
    }

    void clear() {
        this.fft.clear();
    }

    static float FAST_HYPOT(float f2, float f3) {
        return (float)Math.sqrt(f2 * f2 + f3 * f3);
    }

    void lpc_to_curve(float[] arrf, float[] arrf2, float f2) {
        int n2;
        for (n2 = 0; n2 < this.ln * 2; ++n2) {
            arrf[n2] = 0.0f;
        }
        if (f2 == 0.0f) {
            return;
        }
        for (n2 = 0; n2 < this.m; ++n2) {
            arrf[n2 * 2 + 1] = arrf2[n2] / (4.0f * f2);
            arrf[n2 * 2 + 2] = -arrf2[n2] / (4.0f * f2);
        }
        this.fft.backward(arrf);
        n2 = this.ln * 2;
        float f3 = (float)(1.0 / (double)f2);
        arrf[0] = (float)(1.0 / (double)(arrf[0] * 2.0f + f3));
        for (int i2 = 1; i2 < this.ln; ++i2) {
            float f4 = arrf[i2] + arrf[n2 - i2];
            float f5 = arrf[i2] - arrf[n2 - i2];
            float f6 = f4 + f3;
            arrf[i2] = (float)(1.0 / (double)Lpc.FAST_HYPOT(f6, f5));
        }
    }
}

