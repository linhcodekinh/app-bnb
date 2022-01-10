package com.example.sslost.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sslost.Fragment.FragmentLibDownload;
import com.example.sslost.Fragment.FragmentLibRecent;
import com.example.sslost.Fragment.FragmentLibSubscribed;
import com.example.sslost.R;

import java.util.ArrayList;
import java.util.List;

public class PagerLibAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragment = new ArrayList<Fragment>();
    List<String>  titleFragment = new ArrayList<String>();

    public PagerLibAdapter(FragmentManager fm, Context context) {
        super(fm);
        listFragment.add(FragmentLibRecent.newInstance());
        listFragment.add(FragmentLibSubscribed.newInstance());
        listFragment.add(FragmentLibDownload.newInstance());


        titleFragment.add(context.getResources().getString(R.string.description));
        titleFragment.add(context.getResources().getString(R.string.episodes));
        titleFragment.add(context.getResources().getString(R.string.app_name));

    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
