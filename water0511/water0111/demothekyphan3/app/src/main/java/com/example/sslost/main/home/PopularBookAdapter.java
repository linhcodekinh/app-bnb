package com.example.sslost.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sslost.R;

public class PopularBookAdapter extends RecyclerView.Adapter<PopularBookAdapter.ViewHolder>{

    private Context mContext;
    private HomeBookContract.Presenter mHomeBookContract;
    private HomeBookModel mHomeBookModel;

    public PopularBookAdapter(Context context, HomeBookModel homeBookModel, HomeBookContract.Presenter mHomeBookContract) {
        this.mContext = context;
        this.mHomeBookModel = homeBookModel;
        this.mHomeBookContract = mHomeBookContract;
    }

    @NonNull
    @Override
    public PopularBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book2,parent,false);
        return new PopularBookAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularBookAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(mHomeBookModel.getListPopularBook().get(position).getName());
        Glide.with(mContext)
                .load(mHomeBookModel.getListPopularBook().get(position).getThumbnail())
                .into(holder.imageView);
        holder.llParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mHomeBookContract != null){
                    mHomeBookContract.onItemSelected(mHomeBookModel.getListPopularBook().get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHomeBookModel.getListPopularBook().size();
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

}


