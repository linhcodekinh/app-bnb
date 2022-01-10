package com.example.sslost.main.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sslost.Data.Book;
import com.example.sslost.Data.database.search.entry.entity.SearchHistory;
import com.example.sslost.R;

import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    private Context mContext;
    private SearchModel mSearchModel;
    private SearchContract.Presenter mSearchContract;
    List<Book> mBookList = new ArrayList<>();

    public SearchResultAdapter(Context mContext, SearchContract.Presenter mSearchContract, SearchModel mSearchModel) {
        this.mContext = mContext;
        this.mSearchContract = mSearchContract;
        this.mSearchModel = mSearchModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(mBookList.get(position).getName());
        Glide.with(mContext)
                .load(mBookList.get(position).getThumbnail())
                .into(holder.imageView);
        holder.llParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSearchContract != null) {
                    mSearchContract.onItemSelected(SearchConstant.KEY_ADAPTER_SEARCH_RESULT, mBookList.get(position).getId() + " ");
                }
            }
        });
    }

//    public void setSearchHistoryList(List<SearchHistory> searchHistoryList) {
//        mSearchHistoryList = searchHistoryList;
//        notifyDataSetChanged();
//    }

    @Override
    public int getItemCount() {
        if (mBookList == null) return 0;
        return mBookList.size();
    }

    public void setSearchResultList(String s) {
        s = s.toUpperCase();
//        int k = 0;
        List<Book> list = mSearchModel.getListBook();
        for (int i = 0; i < mSearchModel.getListBook().size(); i++) {
            Book book = list.get(i);
            String name = book.getName().toUpperCase();
            if (name.contains(s)) {
//                list.set(i, list.get(k));
//                list.set(k, book);
//                k++;
                mBookList.add(book);
            }
        }
        notifyDataSetChanged();
    }

    public void clear() {
        mBookList.clear();
        notifyDataSetChanged();
    }

//    public void setSearchResultList(String s) {
//        s = s.toUpperCase();
//        List<Book> list = mSearchModel.getListBook();
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llParent;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llParent = itemView.findViewById(R.id.ll_parent);
            imageView = itemView.findViewById(R.id.iv_cover);
            textView = itemView.findViewById(R.id.tv_name_book);
        }
    }
}
