package com.example.sslost.main.search;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sslost.Data.database.search.entry.entity.SearchHistory;
import com.example.sslost.R;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class SearchActivity extends AppCompatActivity implements SearchContract.View, View.OnClickListener {
    private EditText edtSearch;
    private ImageView imgClearSearch, imgBin;
    private TextView txtHuy, txtFeaturedSearch, txtSearchHistory;
    private LinearLayout lnViewAfter, lnViewBefore;
    private RecyclerView mRecyclerViewFeaturedSearch, mRecyclerViewSearchHistory, mRecyclerViewSearchResult;
    private SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        findViewByIds();


        onButtonSearchClicked();
        setAdapterSearch();
        onEditTextChange();

        txtHuy.setOnClickListener(this);
        imgClearSearch.setOnClickListener(this);
        imgBin.setOnClickListener(this);

        mSearchPresenter = new SearchPresenter(this, mRecyclerViewFeaturedSearch, mRecyclerViewSearchHistory, mRecyclerViewSearchResult, this);
    }

    private void findViewByIds() {
        lnViewAfter = findViewById(R.id.viewAfter);
        lnViewBefore = findViewById(R.id.viewBefore);
        mRecyclerViewSearchResult = findViewById(R.id.recvListBook);
        imgBin = findViewById(R.id.imgBin);
        imgClearSearch = findViewById(R.id.clearSearch);
        mRecyclerViewFeaturedSearch = findViewById(R.id.recycleview_featuredSearch);
        mRecyclerViewSearchHistory = findViewById(R.id.recycleview_SearchHistory);
        edtSearch = findViewById(R.id.edtSearch);
        txtHuy = findViewById(R.id.txtHuy);
        txtFeaturedSearch = findViewById(R.id.txtFeaturedSearch);
        txtSearchHistory = findViewById(R.id.txtSearchHistory);
    }

    private void setAdapterSearch() {
        FlexboxLayoutManager layoutManagerSH, layoutManagerSF;
        layoutManagerSH = new FlexboxLayoutManager(this);
        layoutManagerSF = new FlexboxLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(SearchActivity.this, 3);

        layoutManagerSH.setFlexDirection(FlexDirection.ROW);
        layoutManagerSH.setJustifyContent(JustifyContent.FLEX_START);

        layoutManagerSF.setFlexDirection(FlexDirection.ROW);
        layoutManagerSF.setJustifyContent(JustifyContent.FLEX_START);

        mRecyclerViewSearchHistory.setLayoutManager(layoutManagerSH);
        mRecyclerViewFeaturedSearch.setLayoutManager(layoutManagerSF);
        mRecyclerViewSearchResult.setLayoutManager(gridLayoutManager);
    }


    private void onEditTextChange() {
        edtSearch.requestFocus();
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                mSearchPresenter.clearData();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    imgClearSearch.setVisibility(View.VISIBLE);
                    lnViewBefore.setVisibility(View.GONE);
                    lnViewAfter.setVisibility(View.VISIBLE);
                } else {
                    imgClearSearch.setVisibility(View.GONE);
                    lnViewBefore.setVisibility(View.VISIBLE);
                    lnViewAfter.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0)
                    mSearchPresenter.searchResult(s.toString());

            }
        });
    }

    private void onButtonSearchClicked() {
        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    SearchHistory mSearchHistory = new SearchHistory();
                    mSearchHistory.setName(textView.getText().toString().trim());
                    //update
                    mSearchPresenter.update(mSearchHistory);
                    //save to database
                    mSearchPresenter.saveSH(mSearchHistory);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void showToastSearch(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBin:
                mSearchPresenter.deleteAll();
                mSearchPresenter.clear();
                break;
            case R.id.clearSearch:
                edtSearch.setText("");
                break;
            case R.id.txtHuy:
                finish();
                break;
        }
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }
}
