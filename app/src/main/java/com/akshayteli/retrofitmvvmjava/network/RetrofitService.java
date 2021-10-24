package com.akshayteli.retrofitmvvmjava.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Akshay Teli on 24,October,2021
 */
public interface RetrofitService {

    String BASE_URL = "https://taxguru.in/wp-content/uploads/2020/01/";

    @GET("New-indian-50-100-500-and-2000-rupees-banknotes-and-10-rupees-coin.jpg")
    Call<ResponseBody> getImage();
}
