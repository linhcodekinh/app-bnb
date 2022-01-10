package com.example.sslost.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sslost.Data.ChapterDetail;
import com.example.sslost.R;

import java.util.ArrayList;

public class ChapterDetailAdapter extends RecyclerView.Adapter<ChapterDetailAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ChapterDetail> mChapterDetails;


    public ChapterDetailAdapter(Context mContext, ArrayList<ChapterDetail> mChapterDetails){
        this.mContext = mContext;
        this.mChapterDetails = mChapterDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_chapter_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if(mChapterDetails.get(1).getChapterId() == 1){
            Glide.with(mContext)
                    .load(mChapterDetails.get(position).getImagePath())
                    .into(holder.image);

//            Log.d("ChapterDetailAdapter", "onBindViewHolder: " + mChapterDetails.get(position).getChapterId());
//        }
        Log.d("ChapterDetailAdapter", "onBindViewHolder positiosn: " + position);
    }

    @Override
    public int getItemCount() {
        return mChapterDetails.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_page);
        }
    }
}
