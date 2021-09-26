package com.example.project_reser;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private static RetrofitInterface retrofitInterface;
    private static String baseUrl = "https://api.odcloud.kr/";

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = (RetrofitInterface) retrofit.create(com.example.project_reser.RetrofitInterface.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public static RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }
}
