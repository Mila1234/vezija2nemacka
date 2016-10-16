package com.example.marija.myapplication;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by marija on 15.10.16.
 */
public interface MInterface {
    @GET("/json/github.com")
    void getUser(Callback<Mirko> uscb);


    @GET("/json/")
    void getIP(@Query("q") String sort,Callback<Mirko> m);

}
