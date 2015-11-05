/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Programming Language C
   This class file contains all the method, functions and data for the programming Language C
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

public class CActivity extends AppCompatActivity {

    // Textview to store the tutorial text
    TextView textviewc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
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

        TextView textviewc = (TextView)findViewById(R.id.textView2);
        textviewc.setMovementMethod(new ScrollingMovementMethod());
        textviewc.setText("C is a general-purpose, imperative computer programming language, "
                + "supporting structured programming, lexical variable scope and recursion, "
                + "while a static type system prevents many unintended operations. By design, "
                + "C provides constructs that map efficiently to typical machine instructions, "
                + "and therefore it has found lasting use in applications that had formerly been "
                + "coded in assembly language, including operating systems, as well as various "
                + "application software for computers ranging from supercomputers to embedded "
                + "systems."
                + "\n\nC was originally developed by Dennis Ritchie between 1969 and 1973 at "
                + "AT&T Bell Labs, and used to re-implement the Unix operating system. "
                + "It has since become one of the most widely used programming languages of "
                + "all time, with C compilers from various vendors available for the majority "
                + "of existing computer architectures and operating systems. C has been "
                + "standardized by the American National Standards Institute (ANSI) since 1989 "
                + "and subsequently by the International Organization for Standardization (ISO)."
        );
    }

}
