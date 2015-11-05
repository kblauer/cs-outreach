/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Programming Language Python
   This class file contains all the method, functions and data for the programming Language Python
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

public class PythonActivity extends AppCompatActivity {

    // Textview to store the tutorial text
    TextView textviewpython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
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

        TextView textviewpython = (TextView)findViewById(R.id.textView1);
        textviewpython.setMovementMethod(new ScrollingMovementMethod());
        textviewpython.setText("Python is a widely used general-purpose, high-level programming "
                        + "language. Its design philosophy emphasizes code readability, and "
                        + "its syntax allows programmers to express concepts in fewer lines "
                        + "of code than would be possible in languages such as C++ or Java. "
                        + "The language provides constructs intended to enable clear programs "
                        + "on both a small and large scale."
                        + "\n\nPython supports multiple programming paradigms, including "
                        + "object-oriented, imperative and functional programming or procedural "
                        + "styles. It features a dynamic type system and automatic memory "
                        + "management and has a large and comprehensive standard library."
                        + "\n\nPython interpreters are available for installation on many "
                        + "operating systems, allowing Python code execution on a wide variety "
                        + "of systems. Using third-party tools, such as Py2exe or Pyinstaller, "
                        + "Python code can be packaged into stand-alone executable programs "
                        + "for some of the most popular operating systems, allowing the "
                        + "distribution of Python-based software for use on those environments "
                        + "without requiring the installation of a Python interpreter."
                        + "\n\nCPython, the reference implementation of Python, is free and "
                        + "open-source software and has a community-based development model, "
                        + "as do nearly all of its alternative implementations. CPython is "
                        + "managed by the non-profit Python Software Foundation."
        );
    }
}
