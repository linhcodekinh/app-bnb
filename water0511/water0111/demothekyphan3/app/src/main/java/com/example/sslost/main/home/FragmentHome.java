package com.example.sslost.main.home;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.sslost.Activity.BookDetailActivity;
import com.example.sslost.R;
import com.example.sslost.main.slider.GlideLoader;
import com.example.sslost.main.slider.IndicatorConfiguration;
import com.example.sslost.main.slider.InfiniteIndicator;
import com.example.sslost.main.slider.OnPageClickListener;
import com.example.sslost.main.slider.Page;

import java.util.ArrayList;


public class FragmentHome extends Fragment implements ViewPager.OnPageChangeListener, OnPageClickListener, HomeBookContract.View {
    private RecyclerView mRcvRecommendBook, mRcvPopularBook;
    private ArrayList<Page> pageViews;
    private HomeBookPresenter mHomeBookPresenter;

    private InfiniteIndicator mAnimIndicator;
    private InfiniteIndicator mAnimLineIndicator;


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
        findViewByIds(view);
        initData();
        setAdapterRecommendBook();

        testAnimCircleIndicator();

        mHomeBookPresenter = new HomeBookPresenter(getContext(),mRcvRecommendBook, mRcvPopularBook,this);


//        mRecommendBookAdapter.setOnClickBook(new RecommendBookAdapter.OnClickBook() {
//            @Override
//            public void onClickBook(int pos) {
//                Toast.makeText(getContext(), mBookArrayList.get(pos).getId() + " ", Toast.LENGTH_SHORT).show();
//                Intent it = new Intent(getContext(), BookDetailActivity.class);
//                startActivity(it);
//            }
//        });

        return view;
    }

    private void findViewByIds(View view) {
        mAnimIndicator = view.findViewById(R.id.infinite_slider);
        mRcvRecommendBook = view.findViewById(R.id.rcv_list_recommend_book);
        mRcvPopularBook = view.findViewById(R.id.rcv_list_popular_book);

    }

    private void initData() {
        pageViews = new ArrayList<>();
//        pageViews.add(new Page("A ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/a.jpg", this));
//        pageViews.add(new Page("B ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/b.jpg", this));
//        pageViews.add(new Page("C ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/c.jpg", this));
//        pageViews.add(new Page("D ", "https://raw.githubusercontent.com/lightSky/InfiniteIndicator/master/res/d.jpg", this));

        pageViews.add(new Page("A", R.drawable.a, this));
        pageViews.add(new Page("B", R.drawable.b, this));
        pageViews.add(new Page("C", R.drawable.c, this));
        pageViews.add(new Page("D", R.drawable.d, this));
        pageViews.add(new Page("E", R.drawable.c, this));
        pageViews.add(new Page("F", R.drawable.d, this));
        pageViews.add(new Page("G", R.drawable.c, this));
        pageViews.add(new Page("H", R.drawable.d, this));



    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageClick(int position, Page page) {
        Toast.makeText(getContext(), " click page --- " + position, Toast.LENGTH_SHORT).show();
    }


    //To avoid memory leak ,you should release the res
    @Override
    public void onPause() {
        super.onPause();
        mAnimIndicator.stop();

    }

    @Override
    public void onResume() {
        super.onResume();
        mAnimIndicator.start();

    }

    private void testAnimCircleIndicator() {

        IndicatorConfiguration configuration = new IndicatorConfiguration.Builder()
                .imageLoader(new GlideLoader())
                .isStopWhileTouch(true)
                .onPageChangeListener(this)
                .onPageClickListener(this)
                .position(IndicatorConfiguration.IndicatorPosition.Center_Bottom)
                .build();
        mAnimIndicator.init(configuration);
        mAnimIndicator.notifyDataChange(pageViews);
        mAnimIndicator.setCurrentItem(2);
    }

    @Override
    public void showToastBook(int id) {
        Toast.makeText(getContext(),"id: " + id, Toast.LENGTH_SHORT).show();
        Intent it = new Intent(getContext(), BookDetailActivity.class);
        startActivity(it);
    }


    private void setAdapterRecommendBook() {
        mRcvRecommendBook.setLayoutManager(new GridLayoutManager(getContext(), 3));
        mRcvRecommendBook.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(1), true));
        mRcvRecommendBook.setItemAnimator(new DefaultItemAnimator());
        mRcvRecommendBook.setNestedScrollingEnabled(false);

        mRcvPopularBook.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mRcvPopularBook.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(1), true));
        mRcvPopularBook.setItemAnimator(new DefaultItemAnimator());
        mRcvPopularBook.setNestedScrollingEnabled(false);
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
