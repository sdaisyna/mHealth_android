package com.daisyna.medicinetime.addmedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daisyna.medicinetime.Login;
import com.daisyna.medicinetime.R;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button login;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activityy);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }


    public void login() {

        String mail = email.getText().toString();
        String pass = password.getText().toString();

        Login login = new Login();

        if (login.checkUser(mail, pass)) {
            Intent loginIntent = new Intent(this, AddMedicineActivity.class);
            startActivity(loginIntent);
            finish();
        } else {
            Toast.makeText(this, "Either email or password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
