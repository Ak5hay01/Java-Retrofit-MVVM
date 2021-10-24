package com.akshayteli.retrofitmvvmjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.akshayteli.retrofitmvvmjava.network.RetrofitInstance;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Akshay Teli on 24,October,2021
 */
public class MainActivityViewModel extends ViewModel {

    MutableLiveData<Bitmap> image = new MutableLiveData();
    byte[] bytes = null;

    public MutableLiveData<Bitmap> getImageObserver(){
        return image;
    }

    public void makeApiCall(){
        Call<ResponseBody> call = RetrofitInstance.getInstance().getMyApi().getImage();
        call.enqueue(new Callback<ResponseBody>() {
                         @Override
                         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                             try {
                                 bytes = response.body().bytes();
                                 Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                                 image.postValue(bitmap);
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }

                         }

                         @Override
                         public void onFailure(Call<ResponseBody> call, Throwable t) {

                         }
                     }
        );
    }
}
