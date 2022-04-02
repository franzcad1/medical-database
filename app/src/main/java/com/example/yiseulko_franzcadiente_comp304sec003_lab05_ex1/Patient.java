package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "patient_table",
        foreignKeys = @ForeignKey(entity = Nurse.class,
        parentColumns = "nurseId",
        childColumns = "nurseId",
        onDelete = ForeignKey.NO_ACTION))

public class Patient {
    @PrimaryKey
    @ColumnInfo(name = "patientId")
    private int patientId;


    @Nullable
    public String getDepartment() {
        return department;
    }

    @Nullable
    public String getRoom() {
        return room;
    }

    //FK
    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @ColumnInfo(name = "firstName")
    private String firstName;

    @ColumnInfo(name = "lastName")
    private String lastName;

    @Nullable
    @ColumnInfo(name = "department")
    private String department;

    @Nullable
    @ColumnInfo(name = "room")
    private String room;

    public int getPatientId() {
        return patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
