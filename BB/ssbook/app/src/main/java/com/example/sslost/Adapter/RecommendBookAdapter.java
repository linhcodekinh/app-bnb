package com.example.sslost.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sslost.Data.Book;
import com.example.sslost.R;

import java.util.ArrayList;

public class RecommendBookAdapter extends RecyclerView.Adapter<RecommendBookAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Book> mListBook;
    public OnClickBook mOnClickBook;

    public RecommendBookAdapter(Context mContext, ArrayList<Book> mListBook) {
        this.mContext = mContext;
        this.mListBook = mListBook;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(mListBook.get(position).getName());
        try {
            Glide.with(mContext)
                    .load(mListBook.get(position).getThumbnail())
                    .into(holder.imageView);
        } catch (Exception e) {
            Log.d("RecommendBookAdapter", "onBindViewHolder: " + e.getMessage());
        }
        holder.llParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickBook != null) {
                    mOnClickBook.onClickBook(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListBook.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llParent;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llParent = itemView.findViewById(R.id.ll_parent);
            imageView = itemView.findViewById(R.id.iv_cover);
            textView = itemView.findViewById(R.id.tv_name_book);
        }
    }

    public interface OnClickBook {
        void onClickBook(int pos);
    }

    public void setOnClickBook(OnClickBook onClickBook) {
        mOnClickBook = onClickBook;
    }
}
