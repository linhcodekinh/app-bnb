package com.example.sslost.Activity.View;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.graphics.drawable.DrawableCompat;

import com.example.sslost.R;

public class StarView extends View {
    private boolean integerMark = true;
    private Drawable mDrawable;
    private OnStarChangeListener onStarChangeListener;
    private Paint paint;
    private int starCount = 5;
    private int starDistance = 0;
    private float starMark = 0.0f;
    private int starSize;
    private boolean touchable = true;

    public interface OnStarChangeListener {
        void onStarChange(float f);
    }

    public StarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public StarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @SuppressLint("ResourceType")
    private void init(Context context, AttributeSet attributeSet) {
        setClickable(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StarView);
        this.starDistance = (int) obtainStyledAttributes.getDimension(3, 0.0f);
        this.starSize = (int) obtainStyledAttributes.getDimension(4, 20.0f);
        this.starCount = obtainStyledAttributes.getInteger(2, 5);
        this.mDrawable = obtainStyledAttributes.getDrawable(5);
        int color = obtainStyledAttributes.getColor(0, -7829368);
        int color2 = obtainStyledAttributes.getColor(1, -16776961);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            this.mDrawable.setTint(color2);
        } else {
            this.mDrawable = DrawableCompat.wrap(this.mDrawable);
            DrawableCompat.setTint(this.mDrawable, color2);
        }
        Bitmap bitmapFromVectorDrawable = getBitmapFromVectorDrawable(this.mDrawable, this.starSize);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setShader(new BitmapShader(bitmapFromVectorDrawable, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        if (Build.VERSION.SDK_INT >= 21) {
            this.mDrawable.setTint(color);
            return;
        }
        this.mDrawable = DrawableCompat.wrap(this.mDrawable);
        DrawableCompat.setTint(this.mDrawable, color);
    }

    public void setIntegerMark(boolean z) {
        this.integerMark = z;
    }

    public void initStarMark(float f) {
        if (!this.integerMark) {
            this.starMark = (((float) Math.round(f * 10.0f)) * 1.0f) / 10.0f;
        } else if (f < 1.0f) {
            this.starMark = 1.0f;
        } else {
            this.starMark = (float) ((int) Math.ceil((double) f));
        }
        invalidate();
    }

    public void setStarMark(float f) {
        if (!this.integerMark) {
            this.starMark = (((float) Math.round(f * 10.0f)) * 1.0f) / 10.0f;
        } else if (f < 1.0f) {
            this.starMark = 1.0f;
        } else {
            this.starMark = (float) ((int) Math.ceil((double) f));
        }
        if (this.onStarChangeListener != null) {
            this.onStarChangeListener.onStarChange(this.starMark);
        }
        invalidate();
    }

    public void setStarCount(int i) {
        this.starCount = i;
    }

    public float getStarMark() {
        return this.starMark;
    }

    public boolean isTouchable() {
        return this.touchable;
    }

    public void setTouchable(boolean z) {
        this.touchable = z;
    }

    public void setOnStarChangeListener(OnStarChangeListener onStarChangeListener2) {
        this.onStarChangeListener = onStarChangeListener2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension((this.starSize * this.starCount) + (this.starDistance * (this.starCount - 1)), this.starSize);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawable != null) {
            for (int i = 0; i < this.starCount; i++) {
                this.mDrawable.setBounds((this.starDistance + this.starSize) * i, 0, ((this.starDistance + this.starSize) * i) + this.starSize, this.starSize);
                this.mDrawable.draw(canvas);
            }
            if (this.starMark > 1.0f) {
                canvas.drawRect(0.0f, 0.0f, (float) this.starSize, (float) this.starSize, this.paint);
                if (this.starMark - ((float) ((int) this.starMark)) == 0.0f) {
                    for (int i2 = 1; ((float) i2) < this.starMark; i2++) {
                        canvas.translate((float) (this.starDistance + this.starSize), 0.0f);
                        canvas.drawRect(0.0f, 0.0f, (float) this.starSize, (float) this.starSize, this.paint);
                    }
                } else {
                    for (int i3 = 1; ((float) i3) < this.starMark - 1.0f; i3++) {
                        canvas.translate((float) (this.starDistance + this.starSize), 0.0f);
                        canvas.drawRect(0.0f, 0.0f, (float) this.starSize, (float) this.starSize, this.paint);
                    }
                    canvas.translate((float) (this.starDistance + this.starSize), 0.0f);
                    Canvas canvas2 = canvas;
                    canvas2.drawRect(0.0f, 0.0f, ((((float) Math.round((this.starMark - ((float) ((int) this.starMark))) * 10.0f)) * 1.0f) / 10.0f) * ((float) this.starSize), (float) this.starSize, this.paint);
                }
            } else {
                Canvas canvas3 = canvas;
                canvas3.drawRect(0.0f, 0.0f, this.starMark * ((float) this.starSize), (float) this.starSize, this.paint);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.touchable) {
            return super.onTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        if (x < 0) {
            x = 0;
        }
        if (x > getMeasuredWidth()) {
            x = getMeasuredWidth();
        }
        if (motionEvent.getAction() == 0) {
            setStarMark((((float) x) * 1.0f) / ((((float) getMeasuredWidth()) * 1.0f) / ((float) this.starCount)));
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public Bitmap getBitmapFromVectorDrawable(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            drawable = DrawableCompat.wrap(drawable).mutate();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i, i);
        drawable.draw(canvas);
        return createBitmap;
    }
}
