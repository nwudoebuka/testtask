package com.example.ebuka.testtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ebuka.testtask.model.Assignment;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class EditAssignmentActivity extends AppCompatActivity {
    private static final String TAG = EditAssignmentActivity.class.getSimpleName();
    private Unbinder unbinder;
    private Assignment assignment;

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

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
