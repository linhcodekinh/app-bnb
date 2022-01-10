package com.example.sslost.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Data.Chapter;
import com.example.sslost.R;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Chapter> mListChapters;
    public OnClickChapter mOnClickChapter;

    public ChapterAdapter(Context mContext, ArrayList<Chapter> mListChapters){
        this.mContext = mContext;
        this.mListChapters = mListChapters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_chapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvName.setText(mListChapters.get(position).getName());
        holder.tvDate.setText(mListChapters.get(position).getDate());

        holder.llParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mOnClickChapter != null){
                    mOnClickChapter.onClickChapter(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListChapters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDate, tvLike;
        LinearLayout llParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_chapter_name);
            tvLike = itemView.findViewById(R.id.tv_total_like);
            tvDate = itemView.findViewById(R.id.tv_date);
            llParent = itemView.findViewById(R.id.ll_parent);
        }
    }
     public interface OnClickChapter {
        void onClickChapter(int pos);
    }

    public void setOnClickChapter(OnClickChapter onClickChapter){
        mOnClickChapter = onClickChapter;
    }
}
