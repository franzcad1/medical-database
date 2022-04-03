package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {
    private List<Test> tests = new ArrayList<>();

    private TestAdapter.onItemClickListener listener;

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test_item, parent, false);
        return new TestHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        Test currentTest=tests.get(position);

        holder.text_view_testId.setText("Test Id: " + currentTest.getTestId());
        holder.text_view_patientId_nurseId.setText("Patient Id: " + String.valueOf(currentTest.getPatientId())
                + " / Nurse Id: " + String.valueOf(currentTest.getNurseId()));
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public void setTests(List<Test> tests){
        this.tests = tests;
        notifyDataSetChanged();
    }

    class TestHolder extends RecyclerView.ViewHolder{
        private TextView text_view_patientId_nurseId;
        private TextView text_view_testId;

        public TestHolder(@NonNull View itemView) {
            super(itemView);

            text_view_patientId_nurseId = itemView.findViewById(R.id.text_view_patientId_nurseId);
            text_view_testId = itemView.findViewById(R.id.text_view_testId);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position = getAdapterPosition();
                    if(listener!=null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(tests.get(position));
                    }
                }
            });
        }
    }

    public interface onItemClickListener {

        void onItemClick(Test test);

    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }
}
