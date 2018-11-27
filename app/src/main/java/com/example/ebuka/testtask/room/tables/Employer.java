package com.example.ebuka.testtask.room.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "employer")
public class Employer {
   // private String name;
   // @PrimaryKey @NonNull
   // private String phoneNumber;
    //private Date date;

    @PrimaryKey(autoGenerate = true)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
