package com.akshayteli.retrofitmvvmjava.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Akshay Teli on 24,October,2021
 */
public class RetrofitInstance {

    private static RetrofitInstance instance = null;
    private RetrofitService myApi;

    private RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(RetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(RetrofitService.class);
    }

    public static synchronized RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

    public RetrofitService getMyApi() {
        return myApi;
    }
}
