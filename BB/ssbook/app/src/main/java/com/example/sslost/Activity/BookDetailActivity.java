package com.example.sslost.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sslost.Adapter.PagerBookDetailAdapter;
import com.example.sslost.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class BookDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private AppBarLayout appBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView btnBack, btnDownload;
    private TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        initLayout();
    }

    private void initLayout() {
//        Toolbar toolbar = findViewById(R.id.toolbar);
//
//        tvUserName = toolbar.findViewById(R.id.text_user_name_toolbar);
//        btnBack = findViewById(R.id.ic_back);
//        btnDownload = findViewById(R.id.ic_download);
        appBar = findViewById(R.id.app_bar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        //Initializing viewPager
        PagerBookDetailAdapter adapter = new PagerBookDetailAdapter(getSupportFragmentManager(), this);
        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
