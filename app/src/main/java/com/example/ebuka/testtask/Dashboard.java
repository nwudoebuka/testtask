package com.example.ebuka.testtask;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {

    private FloatingActionButton addtask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setTitle("Dashboard");

        //setting onclicklistener for my add task button

        addtask = (FloatingActionButton) findViewById(R.id.addtask);
        addtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Addtask.class));
            }
        });

    }
}
