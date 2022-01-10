package com.example.sslost.main.home;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public class HomeBookPresenter implements HomeBookContract.Presenter{

    private Context mContext;
    private HomeBookModel mHomeBookModel;
    private HomeBookContract.View mViewContract;
    private RecyclerView mRcvRecommendBook, mRcvPopularBook;
    private RecommendBookAdapter mRecommendBookAdapter;
    private PopularBookAdapter mPopularBookAdapter;

    public HomeBookPresenter(Context context, RecyclerView rcvRecommendBook, RecyclerView rcvPopularBook, HomeBookContract.View viewContract) {
        mContext = context;
        mHomeBookModel = new HomeBookModel(mContext);
        mViewContract = viewContract;
        mRecommendBookAdapter = new RecommendBookAdapter(mContext, mHomeBookModel,this);
        mPopularBookAdapter = new PopularBookAdapter(mContext, mHomeBookModel,this);
        mRcvRecommendBook = rcvRecommendBook;
        mRcvPopularBook = rcvPopularBook;
        mRcvRecommendBook.setAdapter(mRecommendBookAdapter);
        mRcvPopularBook.setAdapter(mPopularBookAdapter);
    }

    @Override
    public void onItemSelected(int id) {
        mViewContract.showToastBook(id);
    }
}
