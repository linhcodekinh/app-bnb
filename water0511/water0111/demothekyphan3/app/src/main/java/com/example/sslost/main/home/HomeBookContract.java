package com.example.sslost.main.home;

public interface HomeBookContract {

    interface Presenter {
        void onItemSelected(int id);
    }

    interface View {
        void showToastBook(int id);
    }
}
