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

        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i1.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813085.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i1.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813087.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i8.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813089.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813091.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i2.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813093.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i6.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813095.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813097.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i9.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813099.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i6.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813101.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813103.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i2.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813105.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i2.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813107.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i5.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813109.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i9.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813111.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i5.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813113.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i9.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813115.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i9.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813117.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i6.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813119.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i3.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813121.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813123.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i9.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813125.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i3.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813127.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813129.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i2.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813131.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813133.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i6.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813135.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813137.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i1.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813139.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i2.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813141.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i2.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813143.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i8.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813145.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813147.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813149.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i1.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813151.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813153.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813155.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i9.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813157.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i6.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813159.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813161.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i3.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813163.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813165.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i3.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813167.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813169.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i6.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813171.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i4.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813173.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i8.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813175.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i8.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813177.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i3.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813179.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i1.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813181.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i1.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813183.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813185.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813187.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i4.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813189.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i10.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813191.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i4.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813193.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i8.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813195.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i4.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813197.jpg"));
        mChapterDetailArrayList.add(new ChapterDetail(1, 1, "http://i7.imggur.net/shingeki-no-kyojin/1/shingeki-no-kyojin-1813199.jpg"));


        mChapterDetailAdapter = new ChapterDetailAdapter(this, mChapterDetailArrayList);
        mChapterDetailAdapter.notifyDataSetChanged();

    }

    private void initLayout() {
        mRecyclerView = findViewById(R.id.rcv_listImage);
    }
}
