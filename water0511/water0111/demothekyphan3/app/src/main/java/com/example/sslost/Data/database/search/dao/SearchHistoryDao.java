package com.example.sslost.Data.database.search.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sslost.Data.database.search.entry.entity.SearchHistory;

import java.util.List;

@Dao
public abstract class SearchHistoryDao {
    @Query("SELECT * FROM searchHistory_table")
    public abstract LiveData<List<SearchHistory>> getAll();

    @Query("SELECT * FROM searchHistory_table")
    public abstract List<SearchHistory> getAllData();

    @Insert
    public abstract void insert(SearchHistory searchHistory);

    @Delete
    public abstract void delete(SearchHistory searchHistory);

    @Query("DELETE FROM searchHistory_table")
    public abstract void deleteAll();
}
