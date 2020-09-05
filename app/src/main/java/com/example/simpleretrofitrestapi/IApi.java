package com.example.simpleretrofitrestapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApi {
    @GET("posts/1")
    public Call<PostData> getPostData();
}
