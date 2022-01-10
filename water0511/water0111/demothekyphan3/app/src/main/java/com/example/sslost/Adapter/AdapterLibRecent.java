package com.example.sslost.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sslost.Data.Book;
import com.example.sslost.R;

import java.util.ArrayList;

public class AdapterLibRecent extends RecyclerView.Adapter<AdapterLibRecent.ViewHolder> {
    private Context mContext;
    private ArrayList<Book> mBookArrayList;

    public AdapterLibRecent(Context mContext, ArrayList<Book> mBookArrayList) {
        this.mContext = mContext;
        this.mBookArrayList = mBookArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book_lib_recent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvBookName.setText(mBookArrayList.get(position).getName());
        holder.tvNameAuthor.setText(mBookArrayList.get(position).getAuthor());
        holder.tvDate.setText("Today");

        Glide.with(mContext).load(mBookArrayList.get(position).getThumbnail())
                .into(holder.ivBook);

    }

    @Override
    public int getItemCount() {
        return mBookArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBook;
        TextView tvBookName, tvNameAuthor, tvChapter, tvDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivBook = itemView.findViewById(R.id.iv_book);
            tvBookName = itemView.findViewById(R.id.tv_name_book);
            tvNameAuthor = itemView.findViewById(R.id.tv_name_author);
            tvChapter = itemView.findViewById(R.id.tv_chapter);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
}
