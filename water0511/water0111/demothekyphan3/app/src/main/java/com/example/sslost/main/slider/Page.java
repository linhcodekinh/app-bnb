package com.example.sslost.main.slider;

public class Page {
    public String data = "";
    public Object res;

    public Page(Object res) {
        this.res = res;
    }

    public Page(String data, Object res) {
        this.data = data;
        this.res = res;
    }

    public Page(String data, Object res, OnPageClickListener listener) {
        this.data = data;
        this.res = res;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }
}
