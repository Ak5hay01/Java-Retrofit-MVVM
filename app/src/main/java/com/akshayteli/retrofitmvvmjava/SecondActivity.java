package com.akshayteli.retrofitmvvmjava;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofitmvvmjava.R;

/**
 * Created by Akshay Teli on 24,October,2021
 */
public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        retrieve the data from 1 activity to another
        String data = getIntent().getExtras().getString("string");

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }
}
