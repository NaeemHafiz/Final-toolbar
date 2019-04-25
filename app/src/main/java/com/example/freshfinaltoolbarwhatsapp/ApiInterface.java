package com.example.freshfinaltoolbarwhatsapp;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("categories")
    Call<ParentHakayatCategory> performShowCategoriesData();

}
