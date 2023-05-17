package com.example.myapi;


import com.example.myapi.model.sample.response.food.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

//    String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("v1/1/categories.php")
    Call<DataResponse> getHeroes() ;



}
