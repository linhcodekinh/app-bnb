package com.example.sslost.main.slider.recycle;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sslost.R;
import com.example.sslost.main.slider.ImageLoader;
import com.example.sslost.main.slider.OnPageClickListener;
import com.example.sslost.main.slider.Page;

public class BaseViewBinder implements ViewBinder {

    @Override
    public View bindView(Context context,
                         final int position,
                         final Page page,
                         ImageLoader imageLoader,
                         final OnPageClickListener mOnPageClickListener,
                         View convertView,
                         ViewGroup container) {

        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.simple_slider_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        if (holder.target != null) {
            if (mOnPageClickListener != null) {
                holder.target.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnPageClickListener.onPageClick(position, page);
                    }
                });
            }

            if (imageLoader != null) {
                imageLoader.load(context, holder.target, page.res);
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        final ImageView target;

        public ViewHolder(View view) {
            target = (ImageView) view.findViewById(R.id.slider_image);
        }
    }
}
