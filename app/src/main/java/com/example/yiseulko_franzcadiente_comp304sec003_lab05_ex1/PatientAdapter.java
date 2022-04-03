package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.PatientHolder> {
    private List<Patient> patients = new ArrayList<>();

    private onItemClickListener listener;


    @NonNull
    @Override
    public PatientHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_item, parent, false);
        return new PatientHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientHolder holder, int position) {
        Patient currentPatient = patients.get(position);

        holder.text_view_room.setText("Room: " + currentPatient.getRoom());
        holder.text_view_patientId.setText(String.valueOf(currentPatient.getPatientId()));
        holder.text_view_name.setText(currentPatient.getFirstName() + " " + currentPatient.getLastName());
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    public void setPatients(List<Patient> patients){
        this.patients = patients;
        notifyDataSetChanged();
    }

    class PatientHolder extends RecyclerView.ViewHolder{
        private TextView text_view_patientId;
        private TextView text_view_name;
        private TextView text_view_room;

        public PatientHolder(@NonNull View itemView) {
            super(itemView);

            text_view_patientId = itemView.findViewById(R.id.text_view_patientId);
            text_view_name = itemView.findViewById(R.id.text_view_name);
            text_view_room = itemView.findViewById(R.id.text_view_room);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int position = getAdapterPosition();
                    if(listener!=null && position != RecyclerView.NO_POSITION){
                        listener.onItemClick(patients.get(position));
                    }

                }
            });
        }
    }

    public interface onItemClickListener {

        void onItemClick(Patient patient);

    }

    public void setOnItemClickListener(onItemClickListener listener){
        this.listener=listener;
    }
}
