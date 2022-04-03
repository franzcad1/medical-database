package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PatientViewModel extends AndroidViewModel {
    private PatientRepository repository;
    private LiveData<List<Patient>> allPatients;

    private LiveData<Integer> insertSuccessful;

    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }

    private LiveData<Integer> updateSuccessful;

    public LiveData<Integer> getUpdateSuccessful() {
        return updateSuccessful;
    }

    public PatientViewModel(@NonNull Application application) {
        super(application);

        repository = new PatientRepository(application);
        allPatients = repository.getAllPatients();

        insertSuccessful=repository.getInsertSuccessful();
        updateSuccessful= repository.getUpdateSuccessful();
    }

    public void insert(Patient patient) {
        repository.insert(patient);
    }

    public void update(Patient patient) {
        repository.update(patient);
    }

    public LiveData<List<Patient>> getAllPatients() {
        return allPatients;
    }
}
