package com.example.ebuka.testtask.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ebuka.testtask.room.tables.Employer;

@Dao
public interface EmployerDAO {
    //@Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employer... employers);

    @Update
    void update(Employer... employers);

    @Delete
    void delete(Employer employer);

    @Query("DELETE FROM employer")
    void deleteAll();

}
