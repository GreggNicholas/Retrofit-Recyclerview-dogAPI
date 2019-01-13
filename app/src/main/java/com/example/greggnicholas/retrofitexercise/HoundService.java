package com.example.greggnicholas.retrofitexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HoundService {

    @GET("api/breed/hound/images")
    Call<RandomHound> getDogs();
}
