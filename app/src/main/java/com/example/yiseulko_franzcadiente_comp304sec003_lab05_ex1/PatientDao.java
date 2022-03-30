package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert
    void insert(Patient patient);

    @Query("SELECT * FROM patient_table")
    LiveData<List<Nurse>> getAllPatients();
}
