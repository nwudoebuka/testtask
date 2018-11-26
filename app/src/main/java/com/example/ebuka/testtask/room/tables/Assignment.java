package com.example.ebuka.testtask.room.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "assignment")
public class Assignment {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String employerName;
    private String employeeName;
    private String location;
    private List<String> daysOfWeek;
    private List<String> hoursPerDay;

}
