package com.example.sslost.main.search;

public interface SearchContract {

    interface Presenter {
        void onItemSelected(String key, String text);
    }

    interface View {
        void showToastSearch(String name);
    }
}

