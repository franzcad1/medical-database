package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class PatientRepository {
    private PatientDao patientDao;
    private LiveData<List<Patient>> allPatients;

    private MutableLiveData<Integer> insertSuccessful = new MutableLiveData<>();

    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }

    private MutableLiveData<Integer> updateSuccessful = new MutableLiveData<>();

    public LiveData<Integer> getUpdateSuccessful() {
        return updateSuccessful;
    }

    public PatientRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        patientDao=db.patientDao();
        allPatients= patientDao.getAllPatients();
    }

    public void insert(Patient patient){
        insertAsync(patient);
    }

    public void update(Patient patient){
        updateAsync(patient);
    }

    public LiveData<List<Patient>> getAllPatients(){
        return allPatients;
    }

    private void insertAsync(final Patient patient) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patientDao.insert(patient);
                    insertSuccessful.postValue(1);
                } catch (Exception e) {
                    insertSuccessful.postValue(0);
                }
            }
        }).start();
    }

    private void updateAsync(final Patient patient) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patientDao.update(patient);
                    updateSuccessful.postValue(1);
                } catch (Exception e) {
                    updateSuccessful.postValue(0);
                }
            }
        }).start();
    }
}
