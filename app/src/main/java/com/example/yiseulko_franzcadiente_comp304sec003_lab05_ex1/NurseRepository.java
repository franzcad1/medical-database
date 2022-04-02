package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseRepository {
    private NurseDao nurseDao;

    private LiveData<List<Nurse>> allNurses;

    public NurseRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        nurseDao=db.nurseDao();
        allNurses= nurseDao.getAllNurses();
    }

    public void insert(Nurse nurse){

    }

    public LiveData<List<Nurse>> getAllNurses(){
        return allNurses;
    }

    private void insertAsync(final Nurse nurse) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    nurseDao.insert(nurse);
                    //insertResult.postValue(1);
                } catch (Exception e) {
                    //insertResult.postValue(0);
                }
            }
        }).start();
    }


}
