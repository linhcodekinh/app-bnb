package com.example.sslost.main.search;


import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Data.database.search.entry.entity.SearchHistory;

import java.util.List;

public class SearchPresenter implements SearchContract.Presenter {

    private Context mContext;
    private SearchModel mModel;
    private SearchContract.View mViewContract;
    private RecyclerView mRcvSearchFeatured, mRcvSearchHistory, mRcvSearchResult;
    private SearchFeaturedAdapter mSearchFeaturedAdapter;
    private SearchHistoryAdapter mSearchHistoryAdapter;
    private SearchResultAdapter mSearchResultAdapter;


    public SearchPresenter(Context context, RecyclerView rcvSearchFeatured, RecyclerView rcvSearchHistory, RecyclerView rcvSearchResult,SearchContract.View searchViewContract) {
        mContext = context;
        mRcvSearchFeatured = rcvSearchFeatured;
        mRcvSearchHistory = rcvSearchHistory;
        mRcvSearchResult = rcvSearchResult;
        mViewContract = searchViewContract;
        mModel = new SearchModel(mContext);
        mSearchFeaturedAdapter = new SearchFeaturedAdapter(mContext, this, mModel);
        mSearchHistoryAdapter = new SearchHistoryAdapter(mContext, this, mModel);
        mSearchResultAdapter = new SearchResultAdapter(mContext, this, mModel);
        mRcvSearchFeatured.setAdapter(mSearchFeaturedAdapter);
        mRcvSearchHistory.setAdapter(mSearchHistoryAdapter);
        mRcvSearchResult.setAdapter(mSearchResultAdapter);
        observeData();
    }

    private void observeData() {
        mModel.getSearchHistoryRepository().getAllSearchHistory().observe((LifecycleOwner) mContext, new Observer<List<SearchHistory>>() {
                    @Override
                    public void onChanged(List<SearchHistory> searchHistories) {
                        mSearchHistoryAdapter.setSearchHistoryList(searchHistories);
                    }
                }
        );

    }

    @Override
    public void onItemSelected(String key, String text) {
        if (key.equals(SearchConstant.KEY_ADAPTER_SEARCH_FEATURED)) {
            mViewContract.showToastSearch(text);
        }
    }

    public void update(SearchHistory mSearchHistory) {
        mSearchHistoryAdapter.update(mSearchHistory);
    }

    public void saveSH(SearchHistory mSearchHistory) {
        mModel.insertSearchHistory(mSearchHistory);
    }

    public void deleteAll() {
        mModel.deleteAllSearchHistory();
    }

    public void clear() {
        mSearchHistoryAdapter.clear();
    }

    public void searchResult(String s){
        mSearchResultAdapter.setSearchResultList(s);
    }
    public void clearData(){
        mSearchResultAdapter.clear();
    }
}
