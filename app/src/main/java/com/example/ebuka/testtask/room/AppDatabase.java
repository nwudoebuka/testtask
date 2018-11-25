package com.example.ebuka.testtask.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.ebuka.testtask.room.dao.EmployeeDAO;
import com.example.ebuka.testtask.room.dao.EmployerDAO;
import com.example.ebuka.testtask.room.tables.Employee;
import com.example.ebuka.testtask.room.tables.Employer;
import com.example.ebuka.testtask.room.typeconverters.Converters;

@Database(entities = {Employee.class, Employer.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    private static String DB_NAME = "testDb.db";

    public abstract EmployeeDAO getEmployeeDAO();
    public abstract EmployerDAO getEmployerDAO();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Allows room to do operation on main thread Note: Not advisable
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public void cleanUp() {
        INSTANCE = null;
    }

}