/* Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the My Courses
   Once selected this will redirect the user to a new activity called My Courses
*/

package com.example.ajeyadav.cstutorialapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MyCoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Working on it", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }
}

