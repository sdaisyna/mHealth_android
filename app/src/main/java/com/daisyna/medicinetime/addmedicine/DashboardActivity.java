package com.daisyna.medicinetime.addmedicine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daisyna.medicinetime.R;

public class DashboardActivity extends AppCompatActivity {
    TextView medicine, diet, exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        medicine=findViewById(R.id.tvMedicine);


        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
//                intent = new Intent(AddMedicineActivity.this, DashboardActivity.class);
//                startActivity(intent);
                finish();
            }

        });
    }
}
