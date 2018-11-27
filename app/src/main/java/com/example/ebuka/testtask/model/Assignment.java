package com.example.ebuka.testtask.model;

import java.io.Serializable;

public class Assignment implements Serializable {
    private String weekEndingDate;
    private String employer;
    private String workSite;
    private String totalHoursWorkedPerWeek;

    public Assignment(String weekEndingDate, String employer, String workSite, String totalHoursWorkedPerWeek) {
        this.weekEndingDate = weekEndingDate;
        this.employer = employer;
        this.workSite = workSite;
        this.totalHoursWorkedPerWeek = totalHoursWorkedPerWeek;
    }

    public String getWeekEndingDate() {
        return weekEndingDate;
    }

    public void setWeekEndingDate(String weekEndingDate) {
        this.weekEndingDate = weekEndingDate;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getWorkSite() {
        return workSite;
    }

    public void setWorkSite(String workSite) {
        this.workSite = workSite;
    }

    public String getTotalHoursWorkedPerWeek() {
        return totalHoursWorkedPerWeek;
    }

    public void setTotalHoursWorkedPerWeek(String totalHoursWorkedPerWeek) {
        this.totalHoursWorkedPerWeek = totalHoursWorkedPerWeek;
    }
}