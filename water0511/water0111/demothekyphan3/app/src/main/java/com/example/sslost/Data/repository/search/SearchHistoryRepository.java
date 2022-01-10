package com.example.sslost.Data.repository.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.sslost.Data.database.access.SearchHistoryDatabaseManager;
import com.example.sslost.Data.database.search.dao.SearchHistoryDao;
import com.example.sslost.Data.database.search.entry.entity.SearchHistory;

import java.util.ArrayList;
import java.util.List;

public class SearchHistoryRepository {

    private SearchHistoryDao mSearchHistoryDao;
    private LiveData<List<SearchHistory>> mAllSearchHistory;
    private List<String> data;

    private  List<SearchHistory> mSearchHistoryList;


    public SearchHistoryRepository(Context context) {
        mSearchHistoryDao = SearchHistoryDatabaseManager.getInstance(context).searchHistoryDao();
//        mSearchHistoryList = mSearchHistoryDao.getAllData();
    }

    public List<SearchHistory> getSearchHistoryList(){
        return mSearchHistoryList;
    }


    public List<String> getSearchFeaturedList(){
        data = new ArrayList<>();
        data.add("Đích trưởng nữ");
        data.add("nỗi lòng hoa tầm gửi");
        data.add("Đích trưởng nữ");
        data.add("nỗi lòng hoa tầm gửi");
        data.add("Đích trưởng nữ");
        data.add("nỗi lòng hoa tầm gửi");
        return data;
    }

    public LiveData<List<SearchHistory>> getAllSearchHistory() {
        return mSearchHistoryDao.getAll();
    }

    public void insert(SearchHistory mSearchHistory) {
        insertSH insertSH = new insertSH(mSearchHistory);
        insertSH.execute();
    }

    public void deleteAll() {
        DeleteSearchHisList deleteSearchHisList = new DeleteSearchHisList();
        deleteSearchHisList.execute();
    }


    @SuppressLint("StaticFieldLeak")
    class insertSH extends AsyncTask<Void, Void, Void> {
        SearchHistory mSearchHistory;

        private insertSH(SearchHistory mSearchHistory) {
            this.mSearchHistory = mSearchHistory;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mSearchHistoryDao.insert(mSearchHistory);
            return null;
        }

    }

    class DeleteSearchHisList extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            mSearchHistoryDao.deleteAll();
            return null;
        }
    }

//    void insert(Word word) {
//        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
//            mWordDao.insert(word);
//        });
//    }
}

