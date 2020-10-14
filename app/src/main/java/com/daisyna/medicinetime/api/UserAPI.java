package com.daisyna.medicinetime.api;

import com.daisyna.medicinetime.TokenResponse;
import com.daisyna.medicinetime.model.*;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface UserAPI {


    @POST("user/sigin")
    Call<TokenResponse> login(@Body UserModel users);

    @POST("user/signup")
    Call<TokenResponse> register(@Body UserModel users);
}
