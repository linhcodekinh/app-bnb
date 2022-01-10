package com.example.sslost.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.sslost.Adapter.PagerCategoryAdapter;
import com.example.sslost.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentCategory extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ImageView ivSearch;

    public FragmentCategory() {
        // Required empty public constructor
    }

    public static FragmentCategory newInstance() {
        return new FragmentCategory();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        initLayout(view);

        PagerCategoryAdapter pagerCategoryAdapter = new PagerCategoryAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerCategoryAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void initLayout(View view) {
        tabLayout = view.findViewById(R.id.tabCate);
        viewPager = view.findViewById(R.id.viewPager);


    }
}
