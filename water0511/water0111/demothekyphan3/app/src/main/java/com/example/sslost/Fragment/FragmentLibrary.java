package com.example.sslost.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.sslost.Adapter.PagerLibAdapter;
import com.example.sslost.R;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class FragmentLibrary  extends Fragment {

    private SmartTabLayout tabLayout;
    private ViewPager viewPager;

    public FragmentLibrary() {
        // Required empty public constructor
    }

    public static FragmentLibrary newInstance() {
        return new FragmentLibrary();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        initLayout(view);

        PagerLibAdapter pagerLibAdapter = new PagerLibAdapter(getChildFragmentManager(), getContext());
        viewPager.setAdapter(pagerLibAdapter);
        tabLayout.setViewPager(viewPager);


        return view;
    }

    private void initLayout(View view) {
        tabLayout = view.findViewById(R.id.tabLib);
        viewPager = view.findViewById(R.id.viewPager);

    }
}
