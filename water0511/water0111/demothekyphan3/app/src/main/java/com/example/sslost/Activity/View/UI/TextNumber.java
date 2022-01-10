package com.example.sslost.Activity.View.UI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.widget.AppCompatTextView;

public class TextNumber extends AppCompatTextView {
    private boolean isAutoSpeed;
    private boolean isFormat;
    private int mDuration = 1000;
    /* access modifiers changed from: private */
    public int mOldValue = 0;
    private OnFormatListener mOnFormatListener;
    private ValueAnimator mValueAnimator;


    public interface OnFormatListener {
        String getFormat(int i);
    }

    private int getAutoDuration(int i, int i2) {
        if (i < 10) {
            return 200;
        }
        if (i < 20) {
            return 500;
        }
        return i2;
    }

    public TextNumber(Context context) {
        super(context);
        initView();
    }

    public TextNumber(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public TextNumber(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void initView() {
        this.mValueAnimator = ValueAnimator.ofInt(new int[]{0, 0}).setDuration((long) this.mDuration);
        this.mValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mValueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TextNumber.this.setFormatText(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                TextNumber.this.setFormatText(TextNumber.this.mOldValue);
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                TextNumber.this.setFormatText(TextNumber.this.mOldValue);
            }
        });
    }

    public void setAnimText(int i, int dura) {
        setAnimText(i, dura, false);
    }

    public void setAnimText(int value, int dura, boolean isFormat) {
        this.isFormat = isFormat;
        this.mDuration = dura;
        if (value != this.mOldValue) {
            this.mValueAnimator.cancel();
            this.mValueAnimator.setDuration((long) getAutoDuration(Math.abs(value - this.mOldValue), this.mDuration));
            this.mValueAnimator.setIntValues(new int[]{this.mOldValue, value});
            this.mValueAnimator.start();
        } else {
            setFormatText(value);
        }
        this.mOldValue = value;
    }

    private String getUnit(int i) {
        if (!this.isFormat) {
            return String.valueOf(i);
        }
        if (Math.abs(i) <= 10000) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i / 1000);
        sb.append("K");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mValueAnimator.cancel();
    }

    public void setOnFormatListener(OnFormatListener onFormatListener) {
        this.mOnFormatListener = onFormatListener;
    }

    public void setFormatText(int i) {
        if (this.mOnFormatListener != null) {
            setText(this.mOnFormatListener.getFormat(i));
        } else {
            setText(getUnit(i));
        }
    }
}
