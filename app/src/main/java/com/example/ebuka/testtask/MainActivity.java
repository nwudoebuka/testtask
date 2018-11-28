package com.example.ebuka.testtask;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ebuka.testtask.adapters.AssignmentAdapter;
import com.example.ebuka.testtask.interfaces.OnAssignmentClickListener;
import com.example.ebuka.testtask.model.Assignment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements OnAssignmentClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Unbinder unbinder;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fab) FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        List<Assignment> assignments = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            Assignment assignment = new Assignment("28-12-2018", "Ebuka", "Ikeja", "12hrs");
            assignments.add(assignment);
        }

        AssignmentAdapter adapter = new AssignmentAdapter(assignments, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAssignmentActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void onClick(Assignment assignment) {
        Intent edit = new Intent(this, EditAssignmentActivity.class);
        edit.putExtra("extra", assignment);
        startActivity(edit);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}