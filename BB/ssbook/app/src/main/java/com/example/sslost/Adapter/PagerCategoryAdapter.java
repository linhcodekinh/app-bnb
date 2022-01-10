package com.example.sslost.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.sslost.Fragment.FragmentCategoryDetail;


import java.util.ArrayList;
import java.util.List;

public class PagerCategoryAdapter extends FragmentPagerAdapter {
    List<String> titleFragment = new ArrayList<>();

    public PagerCategoryAdapter(FragmentManager fm) {
        super(fm);

        for (int i = 1; i <= 100; ++i) {
            titleFragment.add("Cate " + i);
        }

    }

    @Override
    public Fragment getItem(int position) {
        return FragmentCategoryDetail.newInstance();
    }

    @Override
    public int getCount() {
        return titleFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }


}
