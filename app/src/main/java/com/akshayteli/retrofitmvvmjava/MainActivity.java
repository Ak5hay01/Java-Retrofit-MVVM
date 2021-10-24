package com.akshayteli.retrofitmvvmjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import retrofitmvvmjava.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgview;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgview = findViewById(R.id.imgView);
        button = findViewById(R.id.navigate_btn);
        button.setOnClickListener(this);

        setImage();

    }

    private void setImage() {
//        Calling the viewmodel for making the Api call
      MainActivityViewModel  mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mViewModel.getImageObserver().observe(this, bitmap -> {
            imgview.setImageBitmap(bitmap);
        });

        mViewModel.makeApiCall();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.navigate_btn:
//                send some data from one activity to other
                Intent intent = new Intent(this,SecondActivity.class);
                intent.putExtra("string","I am Happy");
                startActivity(intent);
                break;
        }
    }
}