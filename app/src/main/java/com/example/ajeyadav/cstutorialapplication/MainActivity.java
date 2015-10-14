// Ajeet Kumar Yadav
// Project Team - 5
// CS Tutorial Application
// CS 5363 - Software Project Management
// Java file for the login function
// This java file will control the backend for homepage for the application.


package com.example.ajeyadav.cstutorialapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.VideoView;

// Main class for the homepage
public class MainActivity extends AppCompatActivity implements OnClickListener {

    // Declaring the buttons on the homepage
    Button button1, button2, button3, button4, button5, button6, button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Working on it.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button1 = (Button)findViewById(R.id.buttonlogin);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.buttonsignup);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.buttonmycourses);
        button3.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.buttoncoursecatalog);
        button4.setOnClickListener(this);
        button5 = (Button)findViewById(R.id.buttonvideos);
        button5.setOnClickListener(this);
        button6 = (Button)findViewById(R.id.buttonquiz);
        button6.setOnClickListener(this);
        button7 = (Button)findViewById(R.id.buttongames);
        button7.setOnClickListener(this);


        final VideoView videoView =(VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" +
                R.raw.welcome));
        videoView.setMediaController(new android.widget.MediaController(this));
        videoView.requestFocus();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonlogin) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttonsignup) {
            Intent i = new Intent(this, SignupActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttonmycourses) {
            Intent i = new Intent(this, MyCoursesActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttoncoursecatalog) {
            Intent i = new Intent(this, CourseCatalogActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttonvideos) {
            Intent i = new Intent(this, VideosActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttonquiz) {
            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.buttongames) {
            Intent i = new Intent(this, GamesActivity.class);
            startActivity(i);
        }
    }


}
