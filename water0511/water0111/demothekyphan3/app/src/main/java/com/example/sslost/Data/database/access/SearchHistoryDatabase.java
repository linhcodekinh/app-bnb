package com.example.sslost.Data.database.access;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sslost.Data.database.search.dao.SearchHistoryDao;
import com.example.sslost.Data.database.search.entry.entity.SearchHistory;

@Database(entities = {SearchHistory.class}, version = 1, exportSchema = false)
public abstract class SearchHistoryDatabase extends RoomDatabase {
    public abstract SearchHistoryDao searchHistoryDao();
}
