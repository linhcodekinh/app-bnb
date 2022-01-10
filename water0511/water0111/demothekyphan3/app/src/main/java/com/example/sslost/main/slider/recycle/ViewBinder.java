package com.example.sslost.main.slider.recycle;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.sslost.main.slider.ImageLoader;
import com.example.sslost.main.slider.OnPageClickListener;
import com.example.sslost.main.slider.Page;

public interface ViewBinder {

    View bindView(Context context,
                  int position,
                  Page page,
                  ImageLoader imageLoader,
                  OnPageClickListener onPageClickListener,
                  View convertView,
                  ViewGroup container);
}
