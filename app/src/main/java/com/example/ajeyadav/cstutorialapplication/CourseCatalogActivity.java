/* Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Course Catalog
   Once selected this will redirect the user to a new activity called Course Catalog
*/

package com.example.ajeyadav.cstutorialapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class CourseCatalogActivity extends AppCompatActivity implements View.OnClickListener {


    // Declaring the buttons on the course catalog page
    Button button12, button13, button14, button15, button16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_catalog);
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

	// Setting the references of the buttons of the course catalog page
        button12 = (Button)findViewById(R.id.button_lang_python);
        button12.setOnClickListener(this);
        button13 = (Button)findViewById(R.id.button_lang_c);
        button13.setOnClickListener(this);
        button14 = (Button)findViewById(R.id.button_lang_cplusplus);
        button14.setOnClickListener(this);
        button15 = (Button)findViewById(R.id.button_lang_java);
        button15.setOnClickListener(this);
        button16 = (Button)findViewById(R.id.button_lang_csharp);
        button16.setOnClickListener(this);

    }


    /**
     * Method which handles the button click
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

	/** Selection statement, which redirects to the Python class 
	    if the python button is clicked
	*/ 
        if(v.getId() == R.id.button_lang_python) {
            Intent i = new Intent(this, PythonActivity.class);
            startActivity(i);
        }

	/** Selection statement, which redirects to the C class 
	    if the c button is clicked
	*/ 
        else if (v.getId() == R.id.button_lang_c) {
            Intent i = new Intent(this, CActivity.class);
            startActivity(i);
        }

	/** Selection statement, which redirects to the C++ class 
	    if the c++ button is clicked
	*/ 
        else if (v.getId() == R.id.button_lang_cplusplus) {
            Intent i = new Intent(this, CplusplusActivity.class);
            startActivity(i);
        }

	/** Selection statement, which redirects to the Java class 
	    if the java button is clicked
	*/ 
        else if (v.getId() == R.id.button_lang_java) {
            Intent i = new Intent(this, JavaActivity.class);
            startActivity(i);
        }

	/** Selection statement, which redirects to the C# class 
	    if the c# button is clicked
	*/ 
        else if (v.getId() == R.id.button_lang_csharp) {
            Intent i = new Intent(this, CsharpActivity.class);
            startActivity(i);
        }
        else {

        }

    }
}
