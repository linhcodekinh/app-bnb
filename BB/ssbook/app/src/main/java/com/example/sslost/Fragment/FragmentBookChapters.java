package com.example.sslost.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Activity.ChapterDetailActivity;
import com.example.sslost.Adapter.ChapterAdapter;
import com.example.sslost.Data.Chapter;
import com.example.sslost.R;

import java.util.ArrayList;

public class FragmentBookChapters extends Fragment implements View.OnClickListener{

    private RecyclerView mRecyclerView;
    private ChapterAdapter chapterAdapter;
    private ArrayList<Chapter> mChapterArrayList = new ArrayList<>();

    public FragmentBookChapters() {
        // Required empty public constructor
    }

    public static FragmentBookChapters newInstance() {
        return new FragmentBookChapters();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_episodes, container, false);

        initLayout(view);
        initData();
        setUp();
        chapterAdapter.setOnClickChapter(new ChapterAdapter.OnClickChapter() {
            @Override
            public void onClickChapter(int pos) {
                Toast.makeText(getContext(), mChapterArrayList.get(pos).getId() + " ", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getContext(), ChapterDetailActivity.class);
                startActivity(it);
            }
        });

        return view;
    }

    private void setUp() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
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

        chapterAdapter = new ChapterAdapter(getContext(), mChapterArrayList);
        chapterAdapter.notifyDataSetChanged();
    }

    private void initLayout(View view) {
        mRecyclerView = view.findViewById(R.id.rcv_listChapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_chapter:
               break;
        }
    }
}
