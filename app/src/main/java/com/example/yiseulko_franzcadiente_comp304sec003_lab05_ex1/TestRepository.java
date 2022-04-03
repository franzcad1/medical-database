package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class TestRepository {
    private TestDao testDao;

    private LiveData<List<Test>> allTests;

    private MutableLiveData<Integer> insertSuccessful = new MutableLiveData<>();

    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }

    public TestRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        testDao=db.testDao();
        allTests= testDao.getAllTests();
    }

    public void insert(Test test){
        insertAsync(test);
    }

    public LiveData<List<Test>> getAllTests(){
        return allTests;
    }

    private void insertAsync(final Test test) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testDao.insert(test);
                    insertSuccessful.postValue(1);
                } catch (Exception e) {
                    insertSuccessful.postValue(0);
                }
            }
        }).start();
    }
}
