package com.example.fingerprint;

public class ListModel {
    String title;
    String sub;
    String btn;

    public ListModel(String title, String sub, String btn) {
        this.title = title;
        this.sub = sub;
        this.btn = btn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }
}
