package com.example.ebuka.testtask.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.ebuka.testtask.room.tables.Employee;

import java.util.List;

@Dao
public interface EmployeeDAO {

    //@Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employee... employees);

    @Update
    void update(Employee... employees);

    @Delete
    void delete(Employee employee);

    @Query("DELETE FROM employee")
    void deleteAll();

//    @Query("SELECT * from employee ORDER BY name ASC")
//    List<Employee> getContactInOrder();

//    @Query("SELECT * FROM employee")
//    List<Employee> getEmployees();

//    @Query("SELECT * FROM employee WHERE phoneNumber = :number")
//    Employee getEmployeeBy(String number);

//    @Query("SELECT * FROM employee WHERE phoneNumber IN (:userPhoneNumbers)")
//    List<Employee> getEmployeeByPhoneNumbers(String[] userPhoneNumbers);

//    @Query("SELECT * FROM employee WHERE name LIKE :name LIMIT 1")
//    Employee getEmployeeByName(String name);
}
