package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseViewModel extends AndroidViewModel
{
    private NurseRepository nurseRepository;
    private LiveData<List<Nurse>> allNurses;
    private LiveData<Integer> insertSuccessful;

    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }

    public NurseViewModel(@NonNull Application application) {
        super(application);

        nurseRepository=new NurseRepository(application);
        allNurses = nurseRepository.getAllNurses();

        insertSuccessful = nurseRepository.getInsertSuccessful();
    }

    public void insert(Nurse nurse){
        nurseRepository.insert(nurse);
    }

    public LiveData<List<Nurse>> getAllNurses() {
        return allNurses;
    }


}
