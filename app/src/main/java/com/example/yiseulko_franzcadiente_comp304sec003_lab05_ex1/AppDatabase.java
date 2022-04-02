package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Nurse.class, Patient.class, Test.class}, version = 1 )
public abstract class AppDatabase extends RoomDatabase {

    private static String DB_NAME = "lab5DB";

    private static AppDatabase INSTANCE;

    public abstract NurseDao nurseDao();
    public abstract PatientDao patientDao();
    public abstract TestDao testDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            //Create DB object
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DB_NAME).build();
        }
        return INSTANCE;
    }



}
