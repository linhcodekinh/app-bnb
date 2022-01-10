package com.example.sslost.main.slider;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideLoader implements ImageLoader {

    public void initLoader(Context context) {

    }

    @Override
    public void load(Context context, ImageView targetView, Object res) {

            Glide.with(context)
                    .load(res)
                    .centerCrop()
//                .placeholder(R.drawable.a)
                    .into(targetView);

    }
}
