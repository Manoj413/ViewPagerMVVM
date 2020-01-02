package com.example.viewpagermvvm.data.model;

import android.net.sip.SipErrorCode;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable
{
    String page,total;
    ArrayList<Data> data;

    public User(String page, String total, ArrayList<Data> data) {
        this.page = page;
        this.total = total;
        this.data = data;
    }



    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "page='" + page + '\'' +
                ", total='" + total + '\'' +
                ", data=" + data +
                '}';
    }
}
