package com.example.freshfinaltoolbarwhatsapp;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("categories")
    Call<ParentHakayatCategory> performShowCategoriesData();

}
