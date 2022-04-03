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

    public Patient(int patientId, int nurseId, String firstName, String lastName, @Nullable String department, @Nullable String room) {
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.room = room;
    }

    @Nullable
    public String getDepartment() {
        return department;
    }

    @Nullable
    public String getRoom() {
        return room;
    }

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

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(@Nullable String department) {
        this.department = department;
    }

    public void setRoom(@Nullable String room) {
        this.room = room;
    }
}
