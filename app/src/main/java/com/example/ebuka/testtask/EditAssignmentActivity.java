package com.example.ebuka.testtask;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ebuka.testtask.model.Assignment;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EditAssignmentActivity extends AppCompatActivity {
    private static final String TAG = EditAssignmentActivity.class.getSimpleName();
    private Unbinder unbinder;
    private Assignment assignment;
    @BindView(R.id.name)
    TextView employerName;
    @BindView(R.id.location)
    TextView siteLocation;
    @BindView(R.id.weekending)
    TextView weekEnding;

    @BindView(R.id.monday)
    TextInputEditText monday;
    @BindView(R.id.tuesday)
    TextInputEditText tuesday;
    @BindView(R.id.wednessday)
    TextInputEditText wednessday;
    @BindView(R.id.thursday)
    TextInputEditText thursday;
    @BindView(R.id.friday)
    TextInputEditText friday;
    @BindView(R.id.saturday)
    TextInputEditText saturday;
    @BindView(R.id.sunday)
    TextInputEditText sunday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        unbinder = ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent.getExtras() != null ){
            assignment = (Assignment) intent.getSerializableExtra("extra");
        }

        if(assignment != null){
            employerName.setText(String.format(Locale.getDefault(), "Employer's Name : %s", assignment.getEmployer()));
            siteLocation.setText(String.format(Locale.getDefault(), "Site Location : %s", assignment.getWorkSite()));
            weekEnding.setText(String.format(Locale.getDefault(), "Week Ending Date : %s", assignment.getWeekEndingDate()));
        }

        if(savedInstanceState != null){
            monday.setText(savedInstanceState.getString("monday"));
            tuesday.setText(savedInstanceState.getString("tuesday"));
            wednessday.setText(savedInstanceState.getString("wednesday"));
            thursday.setText(savedInstanceState.getString("thursday"));
            friday.setText(savedInstanceState.getString("friday"));
            saturday.setText(savedInstanceState.getString("saturday"));
            sunday.setText(savedInstanceState.getString("sunday"));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("monday", monday.getText().toString().trim());
        outState.putString("tuesday", tuesday.getText().toString().trim());
        outState.putString("wednesday", wednessday.getText().toString().trim());
        outState.putString("thursday", thursday.getText().toString().trim());
        outState.putString("friday", friday.getText().toString().trim());
        outState.putString("saturday", saturday.getText().toString().trim());
        outState.putString("sunday", sunday.getText().toString().trim());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
