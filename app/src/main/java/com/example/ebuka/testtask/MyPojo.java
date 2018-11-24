package com.example.ebuka.testtask;

public class MyPojo {

    String title;
    String desc;
    String hours;
    int image;

    public MyPojo(String title, String desc,String hours, int image) {
        this.title = title;
        this.desc = desc;
        this.hours = hours;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String gethours() {
        return hours;
    }

    public int getImage() {
        return image;
    }
}