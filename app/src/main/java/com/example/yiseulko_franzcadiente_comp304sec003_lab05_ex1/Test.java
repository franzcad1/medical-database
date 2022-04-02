package com.example.yiseulko_franzcadiente_comp304sec003_lab05_ex1;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.lang.annotation.Native;

@Entity(tableName = "test_table",
        foreignKeys = {
                @ForeignKey(entity = Nurse.class,
                        parentColumns = "nurseId",
                        childColumns = "nurseId",
                        onDelete = ForeignKey.NO_ACTION),
                @ForeignKey(entity = Patient.class,
                        parentColumns = "patientId",
                        childColumns = "patientId",
                        onDelete = ForeignKey.NO_ACTION)
            }
        )
public class Test {
    @PrimaryKey
    @ColumnInfo(name = "testId")
    private int testId;

    //FK
    @ColumnInfo(name = "patientId")
    private int patientId;

    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @Nullable
    @ColumnInfo(name = "BPL")
    private String BPL;

    @Nullable
    @ColumnInfo(name = "BPH")
    private String BPH;

    @Nullable
    @ColumnInfo(name = "temperature")
    private String temperature;

    public int getTestId() {
        return testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    @Nullable
    public String getBPL() {
        return BPL;
    }

    @Nullable
    public String getBPH() {
        return BPH;
    }

    @Nullable
    public String getTemperature() {
        return temperature;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public void setBPL(@Nullable String BPL) {
        this.BPL = BPL;
    }

    public void setBPH(@Nullable String BPH) {
        this.BPH = BPH;
    }

    public void setTemperature(@Nullable String temperature) {
        this.temperature = temperature;
    }
}
