package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TestViewModel extends AndroidViewModel {
    private TestRepository repository;
    private LiveData<List<Test>> allTests;

    private LiveData<Integer> insertSuccessful;
    public LiveData<Integer> getInsertSuccessful() {
        return insertSuccessful;
    }


    public TestViewModel(@NonNull Application application) {
        super(application);

        repository=new TestRepository(application);
        allTests= repository.getAllTests();

        insertSuccessful = repository.getInsertSuccessful();
    }

    public void insert(Test test){
        repository.insert(test);
    }

    public LiveData<List<Test>> getAllTests() {
        return allTests;
    }
}
