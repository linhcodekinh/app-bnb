package com.example.sslost.Data.database.access;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.sslost.Data.database.search.dao.SearchHistoryDao;
import com.example.sslost.Data.database.search.entry.entity.SearchHistory;

public class SearchHistoryDatabaseManager {

    private static final String TAG = "SearchHistoryDatabaseManager";

    private static volatile SearchHistoryDatabase mInstance;

    public SearchHistoryDatabaseManager() {
        //no instance
    }

    private static SearchHistoryDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(), SearchHistoryDatabase.class, "searchHistory_database")
                .fallbackToDestructiveMigration()
                .addCallback(sRoomDatabaseCallback)
                .build();
    }

    @NonNull
    public static SearchHistoryDatabase getInstance(@NonNull Context context) {
        SearchHistoryDatabase result = mInstance;
        if (result == null) {
            synchronized (SearchHistoryDatabase.class) {
                result = mInstance;
                if (result == null) {
                    mInstance = (result = getDatabase(context));
                }
            }
        }
        return result;
    }
//   OR
//    public static synchronized SearchHistoryDatabaseManager getInstance (Context mContext){
//        if (mInstance == null) {
//            mInstance = new SearchHistoryDatabaseManager(mContext);
//        }
//        return mInstance;
//    }

    //
//    public SearchHistoryDatabase getSearchHistoryDatabase() {
//        return searchHistoryDatabase;
//    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =

            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);

                    new PopulateDbAsync(mInstance).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private SearchHistoryDao mSearchHistoryDao;

        String[] mSearchHistory = {"haha", "dbrr", "bigcity boi"};

        public PopulateDbAsync(SearchHistoryDatabase db) {
            mSearchHistoryDao = db.searchHistoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mSearchHistoryDao.getAll();

            for (int i = 0; i < mSearchHistory.length; ++i) {
                SearchHistory searchHistory = new SearchHistory();
                searchHistory.setName(mSearchHistory[i].trim());
                mSearchHistoryDao.insert(searchHistory);
            }
            return null;
        }
    }
}
