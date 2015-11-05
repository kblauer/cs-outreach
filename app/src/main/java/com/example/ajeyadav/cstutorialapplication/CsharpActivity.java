/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Programming Language C#
   This class file contains all the method, functions and data for the programming Language C#
*/

package com.example.ajeyadav.cstutorialapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class CsharpActivity extends AppCompatActivity {

    // Textview to store the tutorial text
    TextView textviewcsharp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csharp);
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

        TextView textviewcsharp = (TextView)findViewById(R.id.textView5);
        textviewcsharp.setMovementMethod(new ScrollingMovementMethod());
        textviewcsharp.setText("C# is a multi-paradigm programming language encompassing "
                + "strong typing, imperative, declarative, functional, generic, object-oriented "
                + "(class-based), and component-oriented programming disciplines. It was "
                + "developed by Microsoft within its .NET initiative and later approved as a "
                + "standard by Ecma (ECMA-334) and ISO (ISO/IEC 23270:2006). C# is one of the "
                + "programming languages designed for the Common Language Infrastructure."
                + "\n\nC# is intended to be a simple, modern, general-purpose, object-oriented "
                + "programming language. Its development team is led by Anders Hejlsberg. The "
                + "most recent version is C# 6.0, which was released on July 20, 2015."
        );
    }

}
