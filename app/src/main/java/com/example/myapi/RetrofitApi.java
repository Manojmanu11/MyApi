package com.example.myapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    String BASE_URL="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<DataModal>> getHeroes() ;



}
