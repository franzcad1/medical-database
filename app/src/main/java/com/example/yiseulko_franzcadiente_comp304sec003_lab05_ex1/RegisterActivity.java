package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    NurseViewModel nurseViewModel;
    Nurse nurse;
    EditText editTextNurseId, editTextPassword, editTextFirstName, editTextLastName, editTextDepartment;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nurseViewModel= ViewModelProviders.of(this).get(NurseViewModel.class);

        editTextNurseId=findViewById(R.id.editTextNurseId);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextFirstName=findViewById(R.id.editTextFirstName);
        editTextLastName=findViewById(R.id.editTextLastName);
        editTextDepartment=findViewById(R.id.editTextDepartment);
        btnRegister=findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nurse newNurse = new Nurse(
                        Integer.parseInt(editTextNurseId.getText().toString()),
                        editTextPassword.getText().toString(),
                        editTextFirstName.getText().toString(),
                        editTextLastName.getText().toString(),
                        editTextDepartment.getText().toString());

                nurseViewModel.insert(newNurse);
            }
        });
        nurseViewModel.getInsertSuccessful().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                if (result == 1) {
                    Toast.makeText(RegisterActivity.this, "Nurse successfully registered", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(RegisterActivity.this, "Error registering nurse", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}