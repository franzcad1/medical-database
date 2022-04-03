package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    private PatientViewModel patientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        PatientAdapter adapter = new PatientAdapter();
        recyclerView.setAdapter(adapter);

        patientViewModel = ViewModelProviders.of(this).get(PatientViewModel.class);
        patientViewModel.getAllPatients().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                adapter.setPatients(patients);

                //Toast.makeText( PatientListActivity.this, "onchanged", Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnItemClickListener(new PatientAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Patient patient) {
                Intent intent = new Intent(PatientListActivity.this, UpdateInfoActivity.class);

                intent.putExtra("patientId", patient.getPatientId());
                intent.putExtra("firstName", patient.getFirstName());
                intent.putExtra("lastName", patient.getLastName());
                intent.putExtra("department", patient.getDepartment());
                intent.putExtra("room", patient.getRoom());
                intent.putExtra("nurseId", patient.getNurseId());

                startActivity(intent);
            }
        });

    }

    public void moveToPatientActivity(View view){
        Intent intent = new Intent(this, PatientActivity.class);

        startActivity(intent);
    }


}