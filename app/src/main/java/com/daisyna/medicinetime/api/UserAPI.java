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


    @POST("users/login")
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("users/register")
    Call<TokenResponse> register(@Body UserModel users);
}
