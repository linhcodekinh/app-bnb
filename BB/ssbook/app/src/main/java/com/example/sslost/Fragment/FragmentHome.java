package com.example.sslost.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Activity.BookDetailActivity;
import com.example.sslost.Adapter.RecommendBookAdapter;
import com.example.sslost.Data.Book;
import com.example.sslost.R;

import java.util.ArrayList;


public class FragmentHome extends Fragment {
    private RecyclerView mRecyclerView;
    private RecommendBookAdapter mRecommendBookAdapter;
    private ArrayList<Book> mBookArrayList = new ArrayList<>();

    public FragmentHome() {
        // Required empty public constructor
    }

    public static FragmentHome newInstance() {
        return new FragmentHome();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initLayout(view);
        initData();
        setUp();
        mRecommendBookAdapter.setOnClickBook(new RecommendBookAdapter.OnClickBook() {
            @Override
            public void onClickBook(int pos) {
                Toast.makeText(getContext(), mBookArrayList.get(pos).getId() + " ", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getContext(), BookDetailActivity.class);
                startActivity(it);
            }
        });

        return view;
    }

    private void initLayout(View view) {
        mRecyclerView = view.findViewById(R.id.rcv_listbook);
    }

    private void initData() {
        mBookArrayList.add(new Book(1, "Sam sung Notes1","https://s3.mangareader.net/cover/naruto/naruto-l0.jpg" ));
        mBookArrayList.add(new Book(2, "Sam sung Notes1","https://sv5.ghienmanga.net/images/2020/08/15/1172733501859fd4948a669a4a11629dce965b8.jpg" ));
        mBookArrayList.add(new Book(3, "Sam sung Notes1","http://bnblima.unaux.com/1.jpg" ));
        mBookArrayList.add(new Book(4, "Sam sung Notes1","http://en.c.pic.mangatoon.mobi/ps/409487/watermark/1000/xe.jpg" ));

        mRecommendBookAdapter = new RecommendBookAdapter(getContext(), mBookArrayList);
        mRecommendBookAdapter.notifyDataSetChanged();
    }

    private void setUp() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(1), true));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mRecommendBookAdapter);
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
