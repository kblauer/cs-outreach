/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the login function
   This java file will control the backend for homepage for the application.
*/

package com.example.ajeyadav.cstutorialapplication;

import android.content.Intent;
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

	// Setting the references of the buttons of the homepage
        button1 = (Button)findViewById(R.id.button_login);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button_signup);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.button_mycourses);
        button3.setOnClickListener(this);
        button4 = (Button)findViewById(R.id.button_course_catalog);
        button4.setOnClickListener(this);
        button5 = (Button)findViewById(R.id.button_videos);
        button5.setOnClickListener(this);
        button6 = (Button)findViewById(R.id.button_quiz);
        button6.setOnClickListener(this);
        button7 = (Button)findViewById(R.id.button_games);
        button7.setOnClickListener(this);


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


    /**
     * Method which handles the button click
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
	
	/** Selection statement, which redirects to the Login class 
	    if the login button is clicked
	*/ 
        if(v.getId() == R.id.button_login) {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i);
        }
	
	/** Selection statement, which redirects to the Signup class 
	    if the signup button is clicked
	*/ 
        else if (v.getId() == R.id.button_signup) {
            Intent i = new Intent(this, SignupActivity.class);
            startActivity(i);
        }
        
	/** Selection statement, which redirects to the My courses class 
	    if the my courses button is clicked
	*/ 
	else if (v.getId() == R.id.button_mycourses) {
            Intent i = new Intent(this, MyCoursesActivity.class);
            startActivity(i);
        }
        
	/** Selection statement, which redirects to the Course Catalog class 
	    if the Course Catalog button is clicked
	*/ 
	else if (v.getId() == R.id.button_course_catalog) {
            Intent i = new Intent(this, CourseCatalogActivity.class);
            startActivity(i);
        }

	/** Selection statement, which redirects to the Videos class 
	    if the video button is clicked
	*/ 
        else if (v.getId() == R.id.button_videos) {
            Intent i = new Intent(this, VideosActivity.class);
            startActivity(i);
        }
	
	/** Selection statement, which redirects to the Quiz class 
	    if the quiz button is clicked
	*/ 
        else if (v.getId() == R.id.button_quiz) {
            Intent i = new Intent(this, QuizActivity.class);
            startActivity(i);
        }
	
	/** Selection statement, which redirects to the Games class 
	    if the games button is clicked
	*/ 
        else if (v.getId() == R.id.button_games) {
            Intent i = new Intent(this, GamesActivity.class);
            startActivity(i);
        }
    }

}
