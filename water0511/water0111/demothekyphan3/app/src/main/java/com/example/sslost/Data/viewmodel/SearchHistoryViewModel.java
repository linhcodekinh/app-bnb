package com.example.sslost.Data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sslost.Data.database.search.entry.entity.SearchHistory;
import com.example.sslost.Data.repository.search.SearchHistoryRepository;

import java.util.List;

public class SearchHistoryViewModel extends AndroidViewModel {

    private SearchHistoryRepository mSearchHistoryRepository;
    private LiveData<List<SearchHistory>> mAllSearchHistory;

    public SearchHistoryViewModel(@NonNull Application application) {
        super(application);
        mSearchHistoryRepository = new SearchHistoryRepository(application);
        mAllSearchHistory = mSearchHistoryRepository.getAllSearchHistory();
    }

    public LiveData<List<SearchHistory>> getAllSearchHistory() {
        return mAllSearchHistory;
    }

    public void insert(SearchHistory mSearchHistory) {
        mSearchHistoryRepository.insert(mSearchHistory);
    }

    public void deleteAll() {
        mSearchHistoryRepository.deleteAll();
    }
}
