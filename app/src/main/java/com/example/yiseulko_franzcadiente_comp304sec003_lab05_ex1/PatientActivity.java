package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.annotation.Nullable;
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

public class PatientActivity extends AppCompatActivity {
    private PatientViewModel patientViewModel;

    private EditText editTextNurseId;
    private EditText editTextPatientId;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextDepartment;
    private EditText editTextRoom;
    private Button btnRegisterPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);

        editTextNurseId=findViewById(R.id.editTextNurseId);
        editTextPatientId=findViewById(R.id.editTextPatientId);
        editTextFirstName=findViewById(R.id.editTextFirstName);
        editTextLastName=findViewById(R.id.editTextLastName);
        editTextDepartment=findViewById(R.id.editTextDepartment);
        editTextRoom=findViewById(R.id.editTextRoom);
        btnRegisterPatient=findViewById(R.id.btnRegisterPatient);

        SharedPreferences myPreference =
                getSharedPreferences("Lab5Preferences", 0);

        editTextNurseId.setText(myPreference.getString("LoggedInID", ""));

        btnRegisterPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Patient newPatient = new Patient
                                (Integer.parseInt(editTextPatientId.getText().toString()),
                                Integer.parseInt(editTextNurseId.getText().toString()),
                                editTextFirstName.getText().toString(),
                                editTextLastName.getText().toString(),
                                editTextDepartment.getText().toString(),
                                editTextRoom.getText().toString());

                patientViewModel.insert(newPatient);
            }
        });

        patientViewModel.getInsertSuccessful().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                if (result == 1) {
                    Toast.makeText(PatientActivity.this, "Patient successfully registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), PatientListActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(PatientActivity.this, "Error registering patient", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}