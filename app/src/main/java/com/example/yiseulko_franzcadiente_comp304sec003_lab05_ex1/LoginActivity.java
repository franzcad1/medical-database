package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private NurseViewModel nurseViewModel;

    EditText editTextNurseId, editTextPassword;

    boolean loginSuccssful = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

        editTextNurseId = findViewById(R.id.editTextNurseId);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void moveToRegisterActivity(View view){
        Intent intent = new Intent(this, RegisterActivity.class);

        startActivity(intent);
    }

    public void login(View view){
        nurseViewModel.getAllNurses().observe(this, new Observer<List<Nurse>>() {
            @Override
            public void onChanged(List<Nurse> nurses) {
                Integer nurseId = Integer.parseInt(editTextNurseId.getText().toString());
                String password = editTextPassword.getText().toString();

                for(Nurse n : nurses){
                    if(n.getNurseId() == nurseId
                            && n.getPassword().equals(password)){

                        SharedPreferences myPreference =
                                getSharedPreferences("Lab5Preferences", 0);
                        SharedPreferences.Editor prefEditor = myPreference.edit();
                        prefEditor.putString("LoggedInID", nurseId.toString());

                        prefEditor.commit();

                        loginSuccssful = true;

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                        break;

                    }
                }
                if(!loginSuccssful){
                    Toast.makeText(LoginActivity.this,
                            "Please check if you put correct nurse ID and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}