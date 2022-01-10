package com.example.sslost.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Adapter.CategoryDetailAdapter;
import com.example.sslost.Data.Book;
import com.example.sslost.R;

import java.util.ArrayList;

public class FragmentCategoryDetail extends Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<Book> mBookArrayList = new ArrayList<>();
    private CategoryDetailAdapter mCategoryDetailAdapter;

    public FragmentCategoryDetail() {
    }

    public static FragmentCategoryDetail newInstance() {
        return new FragmentCategoryDetail();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_detail, container, false);
        initLayout(view);
        initData();
        setUp();


        return view;
    }

    private void setUp() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mCategoryDetailAdapter);
    }

    private void initData() {
        mBookArrayList.add(new Book(1, "SSLost2", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.", 3030, 1321));
        mBookArrayList.add(new Book(2, "SSLost1", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.", 3030, 1321));
        mBookArrayList.add(new Book(3, "SSLost6", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.", 3030, 1321));
        mBookArrayList.add(new Book(4, "SSLost3", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.", 3030, 1321));
        mBookArrayList.add(new Book(5, "SSLost4", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.", 3030, 1321));
        mBookArrayList.add(new Book(6, "SSLost5", "https://i.stack.imgur.com/QblyW.jpg?s=128&g=1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.", 3030, 1321));

        mCategoryDetailAdapter = new CategoryDetailAdapter(getContext(), mBookArrayList);
        mCategoryDetailAdapter.notifyDataSetChanged();
    }

    private void initLayout(View view) {
        mRecyclerView = view.findViewById(R.id.rcv_listBook);
    }
}
