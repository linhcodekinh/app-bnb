package com.example.sslost.Data.repository;


import android.content.Context;

import androidx.annotation.NonNull;

import com.example.sslost.Data.repository.search.SearchHistoryRepository;

public final class RepositoryFactory {

    private final Context mContext;

    public static RepositoryFactory newInstance(@NonNull Context context) {
        return new RepositoryFactory(context);
    }

    private RepositoryFactory(@NonNull Context context) {
        mContext = context.getApplicationContext();
    }

    @NonNull
    public SearchHistoryRepository createSearchHistoryRepository() {
        return new SearchHistoryRepository(mContext);
    }

}
