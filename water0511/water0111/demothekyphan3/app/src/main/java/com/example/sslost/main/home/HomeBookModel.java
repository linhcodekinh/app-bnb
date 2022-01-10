package com.example.sslost.main.home;

import android.content.Context;

import com.example.sslost.Data.Book;

import java.util.ArrayList;
import java.util.List;

public class HomeBookModel {
    private List<Book> mRecommendBookArrayList, mPopularBookArrayList;
    private Context mContext;

    public HomeBookModel(Context context) {
        this.mContext = context;
    }

    public List<Book> getListRecommendBook(){
        mRecommendBookArrayList = new ArrayList<>();
        mRecommendBookArrayList.add(new Book(1, " Sam sung Notes1Sam sung Notes1Sam sung Notes1", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mRecommendBookArrayList.add(new Book(2, "Sam sungSam sung Notes1 Notes1", "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mRecommendBookArrayList.add(new Book(3, "Sam sung Sam sung Notes1Notes1", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mRecommendBookArrayList.add(new Book(4, "Attack on Titan", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        return mRecommendBookArrayList;
    }

    public List<Book> getListPopularBook(){
        mPopularBookArrayList = new ArrayList<>();
        mPopularBookArrayList.add(new Book(1, " Sam sung Notes1Sam sung Notes1Sam sung Notes1", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mPopularBookArrayList.add(new Book(2, "Sam sungSam sung Notes1 Notes1", "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mPopularBookArrayList.add(new Book(3, "Sam sung Sam sung Notes1Notes1", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mPopularBookArrayList.add(new Book(4, "Attack on Titan", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        return mPopularBookArrayList;
    }
}
