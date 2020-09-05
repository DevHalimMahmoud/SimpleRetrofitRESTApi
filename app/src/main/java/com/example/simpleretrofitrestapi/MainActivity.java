package com.example.simpleretrofitrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static retrofit2.converter.gson.GsonConverterFactory.create;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView;
        textView=findViewById(R.id.text);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(create())
                .build();

        IApi iapi= retrofit.create(IApi.class);
        Call<PostData> call = iapi.getPostData();
        call.enqueue(new Callback<PostData>() {


            @Override
            public void onResponse(Call<PostData> call, Response<PostData> response) {


                assert response.body() != null;
                textView.setText(String.valueOf(response.body().getId()));
            }

            @Override
            public void onFailure(Call<PostData> call, Throwable t) {
            textView.setText(t.getMessage());
            }
        });
    }
    
}