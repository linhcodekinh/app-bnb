package com.example.sslost.Activity.View.UI;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.sslost.R;

public class GradientView extends AppCompatImageView {
    public static final int Cardio = 1;
    public static final int Dance = 2;
    public static final int Hiit = 3;
    public static final int PostNatal = 5;
    public static final int PreNatal = 4;
    public static final int Strength = 6;
    public static final int Tone = 7;
    public static final int Transparent = -1;
    private int coverHeight;
    private Paint coverPaint;
    public int currentColor;
    private float endX;
    private float endY;
    private int[] gradientCardio;
    private int[] gradientCurrent;
    private int[] gradientDance;
    private int[] gradientHiit;
    private int[] gradientNatal;
    private int[] gradientStrength;
    private int[] gradientTone;
    private int[] gradientTransparent;
    private boolean isDefault;
    private Paint paint;
    private float[] positionCurrent;
    private float[] positionDefault;
    private boolean showCover;
    private float startX;
    private float startY;

    public GradientView(Context context) {
        this(context, null);
    }

    public GradientView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GradientView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentColor = 0;
        this.gradientTransparent = new int[]{0, 0};
        this.gradientCardio = new int[]{-6599952, 16736676};
        this.gradientStrength = new int[]{-10580759, 8406969};
        this.gradientHiit = new int[]{-8662852, 6991319};
        this.gradientDance = new int[]{-7840587, 11365833};
        this.gradientTone = new int[]{-31103, 16749943};
        this.gradientNatal = new int[]{-2795073, 16737434};
        this.positionDefault = new float[]{0.11f, 0.81f};
        this.paint = new Paint();
        this.coverPaint = new Paint();
        this.isDefault = false;
        init(attributeSet);
    }

    @SuppressLint("ResourceType")
    private void init(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GradientView);
            this.isDefault = obtainStyledAttributes.getBoolean(3, false);
            String string = obtainStyledAttributes.getString(6);
            String string2 = obtainStyledAttributes.getString(2);
            String string3 = obtainStyledAttributes.getString(0);
            String string4 = obtainStyledAttributes.getString(4);
            this.showCover = obtainStyledAttributes.getBoolean(5, false);
            this.coverHeight = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            this.gradientCurrent = getColorData(string3);
            this.positionCurrent = getPosData(string4);
            this.startX = getXScale(string);
            this.startY = getYScale(string);
            this.endX = getXScale(string2);
            this.endY = getYScale(string2);
            obtainStyledAttributes.recycle();
        }
        if (this.isDefault) {
            setGradient(1);
        }
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.coverHeight, new int[]{838860800, 0}, new float[]{0.0f, 1.0f}, Shader.TileMode.MIRROR);
        this.coverPaint.setShader(linearGradient);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gradientCurrent != null && this.gradientCurrent.length >= 2) {
            int width = getWidth();
            int height = getHeight();
            this.paint.setShader(produceGradient(width, height));
            if (this.showCover) {
                canvas.drawRect(0.0f, 0.0f, (float) width, (float) this.coverHeight, this.coverPaint);
            }
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.paint);
        }
    }

    public GradientView setGradient(int i) {
        if (i != -1) {
            switch (i) {
                case 1:
                    this.currentColor = 1;
                    this.gradientCurrent = this.gradientCardio;
                    this.positionCurrent = this.positionDefault;
                    break;
                case 2:
                    this.currentColor = 2;
                    this.gradientCurrent = this.gradientDance;
                    this.positionCurrent = this.positionDefault;
                    break;
                case 3:
                    this.currentColor = 3;
                    this.gradientCurrent = this.gradientHiit;
                    this.positionCurrent = this.positionDefault;
                    break;
                case 4:
                    this.currentColor = 4;
                    this.gradientCurrent = this.gradientNatal;
                    this.positionCurrent = this.positionDefault;
                    break;
                case 5:
                    this.currentColor = 5;
                    this.gradientCurrent = this.gradientNatal;
                    this.positionCurrent = this.positionDefault;
                    break;
                case 6:
                    this.currentColor = 6;
                    this.gradientCurrent = this.gradientStrength;
                    this.positionCurrent = this.positionDefault;
                    break;
                case 7:
                    this.currentColor = 7;
                    this.gradientCurrent = this.gradientTone;
                    this.positionCurrent = this.positionDefault;
                    break;
                default:
                    this.currentColor = 1;
                    this.gradientCurrent = this.gradientCardio;
                    this.positionCurrent = this.positionDefault;
                    break;
            }
        } else {
            this.currentColor = -1;
            this.gradientCurrent = this.gradientTransparent;
            this.positionCurrent = this.positionDefault;
        }
        return this;
    }

    private float getXScale(String str) {
        if (str != null && str.length() > 0 && str.contains(",")) {
            try {
                return Float.parseFloat(str.substring(0, str.indexOf(",")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1.0f;
    }

    private float getYScale(String str) {
        if (str != null && str.length() > 0 && str.contains(",")) {
            try {
                return Float.parseFloat(str.substring(str.indexOf(",") + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1.0f;
    }

    private int[] getColorData(String str) {
        int i;
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                i = Color.parseColor(split[i2]);
            } catch (Exception e) {
                e.printStackTrace();
                i = -1;
            }
            if (i != -1) {
                iArr[i2] = i;
            }
        }
        return iArr;
    }

    private float[] getPosData(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] split = str.split(",");
        float[] fArr = new float[split.length];
        for (int i = 0; i < split.length; i++) {
            fArr[i] = Float.parseFloat(split[i]);
        }
        return fArr;
    }

    private LinearGradient produceGradient(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        if (this.startX == -1.0f || this.startY == -1.0f || this.endX == -1.0f || this.endY == -1.0f) {
            float f = (float) i3;
            float f2 = (float) i4;
            int[] iArr = this.gradientCurrent;
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f, f2, iArr, this.positionCurrent, Shader.TileMode.CLAMP);
            return linearGradient;
        }
        float f3 = (float) i3;
        float f4 = (float) i4;
        LinearGradient linearGradient2 = new LinearGradient(f3 * this.startX, f4 * this.startY, f3 * this.endX, f4 * this.endY, this.gradientCurrent, this.positionCurrent, Shader.TileMode.CLAMP);
        return linearGradient2;
    }

    public int getGradient() {
        return this.currentColor;
    }
}
