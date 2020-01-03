package com.example.viewpagermvvm.data.rest;

import com.example.viewpagermvvm.data.model.Repo;
import com.example.viewpagermvvm.data.model.User;

import java.util.ArrayList;
import java.util.Observable;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface
{
    @GET("Google/repos")
    Single<ArrayList<Repo>> getRepoData();

    @GET("https://reqres.in/api/users")
    Single<User> getUserData();
}
