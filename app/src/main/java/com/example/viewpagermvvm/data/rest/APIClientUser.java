package com.example.viewpagermvvm.data.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClientUser {


    private static final String BASE_URL="https://reqres.in";

    private static APIClientUser myClient;
    private Retrofit retrofit;
    private APIClientUser(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL).
                        addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized APIClientUser getInstance(){
        if (myClient==null){
            myClient=new APIClientUser();
        }
        return myClient;
    }
    public APIInterface getMyApi(){
        return retrofit.create(APIInterface.class);
    }

}
