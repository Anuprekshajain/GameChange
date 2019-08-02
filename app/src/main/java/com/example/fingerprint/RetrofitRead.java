package com.example.fingerprint;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitRead {

    @GET("all")
    Call<List<ResponsePOJO>> getData();
}
