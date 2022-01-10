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

public class CategoryDetailAdapter extends RecyclerView.Adapter<CategoryDetailAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Book> mListBooks;

    public CategoryDetailAdapter(Context mContext, ArrayList<Book> mListBooks) {
        this.mContext = mContext;
        this.mListBooks = mListBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(mListBooks.get(position).getName());
        holder.tvDes.setText(mListBooks.get(position).getDescription());
        holder.tvTotalLike.setText(mListBooks.get(position).getTotalLike()+"");
        holder.tvTotalView.setText(mListBooks.get(position).getTotalView()+"");

        Glide.with(mContext)
                .load(mListBooks.get(position).getThumbnail())
                .into(holder.ivBook);
    }

    @Override
    public int getItemCount() {
        return mListBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBook;
        TextView tvName, tvDes, tvTotalLike, tvTotalView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDes = itemView.findViewById(R.id.tv_description);
            tvName = itemView.findViewById(R.id.tv_name_book);
            tvTotalLike = itemView.findViewById(R.id.tv_total_like);
            tvTotalView = itemView.findViewById(R.id.tv_total_view);
            ivBook = itemView.findViewById(R.id.iv_book);
        }
    }
}
