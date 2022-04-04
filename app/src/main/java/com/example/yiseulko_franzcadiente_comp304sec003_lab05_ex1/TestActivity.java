package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {
    private TestViewModel testViewModel;

    private EditText editTextNurseId, editTextTestId, editTextPatientId, editTextBPH, editTextBPL, editTextTemperature;
    private Button btnCreateTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);

        editTextNurseId=findViewById(R.id.editTextNurseId);
        editTextTestId=findViewById(R.id.editTextTestId);
        editTextPatientId=findViewById(R.id.editTextPatientId);
        editTextBPH=findViewById(R.id.editTextBPH);
        editTextBPL=findViewById(R.id.editTextBPL);
        editTextTemperature=findViewById(R.id.editTextTemperature);
        btnCreateTest=findViewById(R.id.btnCreateTest);

        SharedPreferences myPreference =
                getSharedPreferences("Lab5Preferences", 0);

        editTextNurseId.setText(myPreference.getString("LoggedInID", ""));

        btnCreateTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Test newTest = new Test (
                        Integer.parseInt(editTextTestId.getText().toString()),
                        Integer.parseInt(editTextPatientId.getText().toString()),
                        Integer.parseInt(editTextNurseId.getText().toString()),
                        editTextBPL.getText().toString(),
                        editTextBPH.getText().toString(),
                        editTextTemperature.getText().toString()
                        );

                testViewModel.insert(newTest);
            }
        });

        testViewModel.getInsertSuccessful().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                if (result == 1) {
                    Toast.makeText(TestActivity.this, "Test successfully created.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), TestListActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(TestActivity.this, "Error creating test: : Test Id should be unique.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}