package com.example.sslost.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sslost.Fragment.FragmentBookDescription;
import com.example.sslost.Fragment.FragmentBookChapters;
import com.example.sslost.R;

import java.util.ArrayList;
import java.util.List;

public class PagerBookDetailAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragments = new ArrayList<Fragment>();
    List<String> titleFragment = new ArrayList<String>();

    public PagerBookDetailAdapter(FragmentManager fm, Context context) {
        super(fm);
        listFragments.add(FragmentBookDescription.newInstance());
        listFragments.add(FragmentBookChapters.newInstance());

        titleFragment.add(context.getResources().getString(R.string.description));
        titleFragment.add(context.getResources().getString(R.string.episodes));
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
