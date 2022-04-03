package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewTestInfoActivity extends AppCompatActivity {
    private TextView textViewNurseId, textViewTestId, textViewPatientId, textViewBPL, textViewTemperature, textViewBPH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_info);

        textViewNurseId=findViewById(R.id.textViewNurseId);
        textViewTestId=findViewById(R.id.textViewTestId);
        textViewPatientId=findViewById(R.id.textViewPatientId);
        textViewBPL=findViewById(R.id.textViewBPL);
        textViewBPH=findViewById(R.id.textViewBPH);
        textViewTemperature=findViewById(R.id.textViewTemperature);

        Intent intent = getIntent();

        textViewTestId.setText(String.valueOf(intent.getIntExtra("testId", 0)));
        textViewNurseId.setText(String.valueOf(intent.getIntExtra("nurseId", 0)));
        textViewPatientId.setText(String.valueOf(intent.getIntExtra("patientId", 0)));
        textViewBPH.setText(intent.getStringExtra("BPH"));
        textViewBPL.setText(intent.getStringExtra("BPL"));
        textViewTemperature.setText(intent.getStringExtra("temperature"));

    }
}