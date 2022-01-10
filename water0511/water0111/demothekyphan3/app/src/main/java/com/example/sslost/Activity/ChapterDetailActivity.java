package com.example.sslost.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sslost.Adapter.ChapterDetailAdapter;
import com.example.sslost.Data.ChapterDetail;
import com.example.sslost.R;

import java.util.ArrayList;

public class ChapterDetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ChapterDetailAdapter mChapterDetailAdapter;
    private ArrayList<ChapterDetail> mChapterDetailArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_detail);

        initLayout();
        initData();
        setUp();

    }

    private void setUp() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mChapterDetailAdapter);
    }

    private void initData() {


        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "https://s8.mkklcdnv8.com/mangakakalot/o1/ol923635/chapter_10/7.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(2, 1, "https://s8.mkklcdnv8.com/mangakakalot/o1/ol923635/chapter_10/7.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(3, 1, "https://s8.mkklcdnv8.com/mangakakalot/o1/ol923635/chapter_10/7.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(4, 1, "https://s8.mkklcdnv8.com/mangakakalot/o1/ol923635/chapter_10/7.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(5, 1, "https://s8.mkklcdnv8.com/mangakakalot/o1/ol923635/chapter_10/7.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(6, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(7, 2, "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mChapterDetailArrayList.add(new ChapterDetail(8, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(9, 2, "https://webtoon-phinf.pstatic.net/20200727_180/1595811934553pliNh_JPEG/15958119311711468857.jpg?type=q90"));
        mChapterDetailArrayList.add(new ChapterDetail(10, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(11, 2, "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mChapterDetailArrayList.add(new ChapterDetail(12, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(13, 2, "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mChapterDetailArrayList.add(new ChapterDetail(14, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(15, 2, "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mChapterDetailArrayList.add(new ChapterDetail(16, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(17, 2, "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));
        mChapterDetailArrayList.add(new ChapterDetail(18, 2, "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1"));
        mChapterDetailArrayList.add(new ChapterDetail(19, 2, "https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1"));


        mChapterDetailAdapter = new ChapterDetailAdapter(this, mChapterDetailArrayList);
        mChapterDetailAdapter.notifyDataSetChanged();

    }

    private void initLayout() {
        mRecyclerView = findViewById(R.id.rcv_listImage);
    }
}
