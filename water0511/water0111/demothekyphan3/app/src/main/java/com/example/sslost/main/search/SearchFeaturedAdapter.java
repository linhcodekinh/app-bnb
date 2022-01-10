package com.example.sslost.main.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.R;

public class SearchFeaturedAdapter extends RecyclerView.Adapter<SearchFeaturedAdapter.ViewHolder> {

    private Context mContext;
    private SearchContract.Presenter mSearchContract;
    private SearchModel mModel;

    public SearchFeaturedAdapter(Context context, SearchContract.Presenter searchContract, SearchModel searchModel) {
        mContext = context;
        mSearchContract = searchContract;
        mModel = searchModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_featured, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        //set text cho từng item
        holder.txtItemFeaturedSearch.setText(mModel.getSearchHistoryRepository().getSearchFeaturedList().get(position));
//        Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/Nunito-SemiBold.ttf");
//        holder.txtItemFeaturedSearch.setTypeface(typeface);
        //Băt sự kiện LinearLayout
        holder.itemFeaturedSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thay đổi background khi bấm vào item
                if (mSearchContract != null) {
                    mSearchContract.onItemSelected(SearchConstant.KEY_ADAPTER_SEARCH_FEATURED, holder.txtItemFeaturedSearch.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModel.getSearchHistoryRepository().getSearchFeaturedList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemFeaturedSearch;
        RelativeLayout itemFeaturedSearch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemFeaturedSearch = (RelativeLayout) itemView.findViewById(R.id.itemFeaturedSearch);
            txtItemFeaturedSearch = (TextView) itemView.findViewById(R.id.txtItemFeaturedSearch);
        }
    }
}
