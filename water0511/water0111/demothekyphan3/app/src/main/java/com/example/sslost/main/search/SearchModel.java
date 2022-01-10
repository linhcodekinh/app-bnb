package com.example.sslost.main.search;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.sslost.Base.support.BaseUtils;
import com.example.sslost.Data.Book;
import com.example.sslost.Data.database.search.entry.entity.SearchHistory;
import com.example.sslost.Data.repository.RepositoryFactory;
import com.example.sslost.Data.repository.search.SearchHistoryRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchModel {

    private Context mContext;
    private SearchHistoryRepository mSearchHistoryRepository;

//    private LiveData<List<SearchHistory>> mAllSearchHistory;


    public SearchModel(Context context) {
        this.mContext = context;
//        mAllSearchHistory = mSearchHistoryRepository.getAllSearchHistory();
    }

    public SearchHistoryRepository getSearchHistoryRepository() {
        if (mSearchHistoryRepository == null) {
            mSearchHistoryRepository = RepositoryFactory.newInstance(mContext).createSearchHistoryRepository();
        }
        return mSearchHistoryRepository;
    }

    public LiveData<List<SearchHistory>> getAllSearchHistory() {
        return mSearchHistoryRepository.getAllSearchHistory();
    }

    public void insertSearchHistory(SearchHistory mSearchHistory) {
        mSearchHistoryRepository.insert(mSearchHistory);
    }

    public void deleteAllSearchHistory() {
        mSearchHistoryRepository.deleteAll();
    }

    public List<SearchHistory> getSearchHistoryList(){
        return mSearchHistoryRepository.getSearchHistoryList();
    }

    public List<Book> getListBook() {
        List<Book> mListBook ;
        mListBook = new ArrayList<>();
        mListBook.add(new Book(1, "ab", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mListBook.add(new Book(2, "bv", "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mListBook.add(new Book(3, "ca", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mListBook.add(new Book(4, "de", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        return mListBook;
    }
}
