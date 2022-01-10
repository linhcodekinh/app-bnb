package com.example.sslost.main.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Data.database.search.entry.entity.SearchHistory;
import com.example.sslost.R;

import java.util.List;

public class SearchHistoryAdapter extends RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder> {

    private Context mContext;
    private SearchModel mModel;
    private SearchContract.Presenter mSearchContract;
    List<SearchHistory> mSearchHistoryList;

    public SearchHistoryAdapter(Context context, SearchContract.Presenter searchContract, SearchModel searchModel) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.txtItemFeaturedSearch.setText(mSearchHistoryList.get(mSearchHistoryList.size() - position - 1).getName());
        holder.itemFeatureSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thay đổi background khi bấm vào item
                if (mSearchContract != null) {
                    mSearchContract.onItemSelected(SearchConstant.KEY_ADAPTER_SEARCH_HISTORY, holder.txtItemFeaturedSearch.getText().toString());
                }
            }
        });
    }

    public void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
        mSearchHistoryList = searchHistoryList;
        notifyDataSetChanged();
    }

    public void clear() {
        mSearchHistoryList.clear();
        notifyDataSetChanged();
    }

    public void update(SearchHistory mSearchHistory) {
        mSearchHistoryList.add(mSearchHistory);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mSearchHistoryList == null) return 0;
        return mSearchHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtItemFeaturedSearch;
        RelativeLayout itemFeatureSearch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemFeatureSearch = itemView.findViewById(R.id.itemFeaturedSearch);
            txtItemFeaturedSearch = itemView.findViewById(R.id.txtItemFeaturedSearch);
        }
    }
}
