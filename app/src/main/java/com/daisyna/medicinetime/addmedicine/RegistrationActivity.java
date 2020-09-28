package com.daisyna.medicinetime.addmedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daisyna.medicinetime.R;
import com.daisyna.medicinetime.RetrofitUrl;
import com.daisyna.medicinetime.TokenResponse;
import com.daisyna.medicinetime.api.UserAPI;
import com.daisyna.medicinetime.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {



    EditText regFirstName, regLastName, regPassword, regEmail, regAge;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regFirstName = findViewById(R.id.regFirstName);
        regLastName = findViewById(R.id.regLastName);
        regAge = findViewById(R.id.regAge);
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    register();
            }
        });


    }

    public void register(){
        UserModel user = new UserModel(regFirstName.getText().toString(), regLastName.getText().toString(), regAge.getText().toString(), regEmail.getText().toString(), regPassword.getText().toString());

        UserAPI usersAPI = RetrofitUrl.getInstance().create(UserAPI.class);
        Call<TokenResponse> registerCall = usersAPI.register(user);

        registerCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(RegistrationActivity.this, "Code:"+ response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, "Error: "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
