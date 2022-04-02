package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    private NurseViewModel nurseViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nurseViewModel = ViewModelProviders.of(this).get(NurseViewModel.class);

    }

    public void moveToRegisterActivity(View view){
        Intent intent = new Intent(this, RegisterActivity.class);

        startActivity(intent);
    }


}