package com.example.project_reser;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("https://api.odcloud.kr/api/15077586/v1/centers")
    Call<Example> getExample(@Query("page") int page, @Query("perPage") int perPage,@Query("serviceKey") String serviceKey);
}