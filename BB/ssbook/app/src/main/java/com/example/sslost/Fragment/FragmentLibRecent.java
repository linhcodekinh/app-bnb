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

import com.example.sslost.Adapter.AdapterLibRecent;
import com.example.sslost.Data.Book;
import com.example.sslost.R;

import java.util.ArrayList;

public class FragmentLibRecent extends Fragment{
    private RecyclerView mRecyclerView;
    private ArrayList<Book> mBookArrayList = new ArrayList<>();
    private AdapterLibRecent mAdapterLibRecent;


    public FragmentLibRecent() {
    }

    public static FragmentLibRecent newInstance() {
        return new FragmentLibRecent();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lib_recent, container, false);

        initLayout(view);
        initData();
        setUp();
        return view;
    }

    private void setUp() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapterLibRecent);
    }

    private void initData() {
        mBookArrayList.add(new Book(2, "Nam nhan nay khong them dua hahahahhahahhhhhhhhhh","kakakakak","https://i.stack.imgur.com/QblyW.jpg?s=128&g=1","Today"));
        mBookArrayList.add(new Book(3, "Nam nhan nay khong them dua","kakakakak","https://i.stack.imgur.com/QblyW.jpg?s=128&g=1","Today"));
        mBookArrayList.add(new Book(4, "Nam nhan nay khong them dua","kakakakak","https://www.gravatar.com/avatar/b7cb362c12cdf0f613860694a320f296?s=128&d=identicon&r=PG&f=1","Today"));
        mBookArrayList.add(new Book(5, "Nam nhan nay khong","kakakakak","https://i.stack.imgur.com/QblyW.jpg?s=128&g=1","Today"));
        mBookArrayList.add(new Book(6, "Nam nhan nay khong them dua","kakakakak","https://i.stack.imgur.com/QblyW.jpg?s=128&g=1","Today"));
        mBookArrayList.add(new Book(7, "Nam nhan nay khong them dua","kakakakak","https://i.stack.imgur.com/QblyW.jpg?s=128&g=1","Today"));
        mBookArrayList.add(new Book(8, "Nam nhan nay khong them dua","kakakakak","https://i.stack.imgur.com/QblyW.jpg?s=128&g=1","Today"));

        mAdapterLibRecent = new AdapterLibRecent(getContext(),mBookArrayList);
        mAdapterLibRecent.notifyDataSetChanged();
    }

    private void initLayout(View view) {
        mRecyclerView = view.findViewById(R.id.rcv_list_book_recent);
    }
}
