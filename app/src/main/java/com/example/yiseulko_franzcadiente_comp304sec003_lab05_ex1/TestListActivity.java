package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class TestListActivity extends AppCompatActivity {

    private TestViewModel testViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        TestAdapter adapter = new TestAdapter();
        recyclerView.setAdapter(adapter);

        testViewModel= ViewModelProviders.of(this).get(TestViewModel.class);

        testViewModel.getAllTests().observe(this, new Observer<List<Test>>() {
            @Override
            public void onChanged(List<Test> tests) {
                adapter.setTests(tests);

                //Toast.makeText( PatientListActivity.this, "onchanged", Toast.LENGTH_SHORT).show();
            }
        });


        adapter.setOnItemClickListener(new TestAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Test test) {
                Intent intent = new Intent(TestListActivity.this, ViewTestInfoActivity.class);

                intent.putExtra("patientId", test.getPatientId());
                intent.putExtra("nurseId", test.getNurseId());
                intent.putExtra("testId", test.getTestId());
                intent.putExtra("temperature", test.getTemperature());
                intent.putExtra("BPH", test.getBPH());
                intent.putExtra("BPL", test.getBPL());

                startActivity(intent);
            }
        });


    }

    public void moveToTestActivity(View view){
        Intent intent = new Intent(this, TestActivity.class);

        startActivity(intent);
    }
}