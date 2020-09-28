package com.daisyna.medicinetime;
import com.daisyna.medicinetime.api.UserAPI;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
public class Login {
    boolean isSuccess = false;

    public boolean checkUser(String email, String password) {

        UserAPI usersAPI = RetrofitUrl.getInstance().create(UserAPI.class);
        Call<TokenResponse> usersCall = usersAPI.login(email, password);

        try {
            Response<TokenResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() && loginResponse.body().getStatus().equals("Login successful")) {

                RetrofitUrl.token += loginResponse.body().getToken();
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
