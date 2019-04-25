package com.example.freshfinaltoolbarwhatsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit retrofit = null;
    public static final String BASE_URL = "http://hakayat.a2api.com/api/";
//    public static final String BASE_URL = "http://hakayat.a2api.com/api/";

    public static Retrofit getRetrofit() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}
