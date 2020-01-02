package com.example.viewpagermvvm.data.rest;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient
{
    private static final String BASE_URL="https://api.github.com/orgs/";

    private static APIClient myClient;
    private Retrofit retrofit;
    private APIClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized APIClient getInstance(){
        if (myClient==null){
            myClient=new APIClient();
        }
        return myClient;
    }
    public APIInterface getMyApi(){
        return retrofit.create(APIInterface.class);
    }

}
