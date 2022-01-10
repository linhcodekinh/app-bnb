package com.example.sslost.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sslost.Adapter.ChapterAdapter;
import com.example.sslost.Data.Chapter;
import com.example.sslost.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private AppBarLayout appBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView btnBack, btnDownload;
    private TextView tvUserName;

    private RecyclerView mRecyclerView;
    private ChapterAdapter chapterAdapter;
    private ArrayList<Chapter> mChapterArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        initLayout();
        initData();
        setUp();
        chapterAdapter.setOnClickChapter(new ChapterAdapter.OnClickChapter() {
            @Override
            public void onClickChapter(int pos) {
                Toast.makeText(BookDetailActivity.this, mChapterArrayList.get(pos).getId() + " ", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(BookDetailActivity.this, ChapterDetailActivity.class);
                startActivity(it);
            }
        });
    }

    private void initLayout() {
//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        tvUserName = toolbar.findViewById(R.id.text_user_name_toolbar);
//        btnBack = findViewById(R.id.ic_back);
//        btnDownload = findViewById(R.id.ic_download);
        appBar = findViewById(R.id.app_bar);
        mRecyclerView = findViewById(R.id.rcv_chapter);



    }
    private void setUp() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(chapterAdapter);
    }

    private void initData() {
        mChapterArrayList.add(new Chapter(1,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(2,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(3,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(4,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(5,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(6,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(7,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(8,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(9,"Nguyen Van Linh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(11,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(12,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(13,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(14,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(15,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(16,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(17,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(18,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(19,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(20,"Nguyen Van Minh", "29/6/1996"));
        mChapterArrayList.add(new Chapter(21,"Nguyen Van Minh", "29/6/1996"));

        chapterAdapter = new ChapterAdapter(this, mChapterArrayList);
        chapterAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.ll_chapter:
//                break;
        }
    }
}
