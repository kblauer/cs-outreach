/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Programming Language Java
   This class file contains all the method, functions and data for the programming Language Java
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

public class JavaActivity extends AppCompatActivity {

    // Textview to store the tutorial text
    TextView textviewjava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
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

        TextView textviewjava = (TextView)findViewById(R.id.textView4);
        textviewjava.setMovementMethod(new ScrollingMovementMethod());
        textviewjava.setText("Java is a general-purpose computer programming language that is "
                        + "concurrent, "
                        + "class-based, object-oriented, and specifically designed to have as few "
                        + "implementation dependencies as possible. It is intended to let "
                        + "application developers 'write once, run anywhere' (WORA), meaning "
                        + "that compiled Java code can run on all platforms that support "
                        + "Java without the need for recompilation. Java applications are typically "
                        + "compiled to bytecode that can run on any Java "
                        + "Virtual Machine (JVM) regardless of computer architecture. As of 2015, "
                        + "Java is one of the most popular programming languages in use, "
                        + "particularly for client-server web applications, with a reported 9 "
                        + "million developers. Java was originally developed by James Gosling "
                        + "at Sun Microsystems and released in 1995 as a core component of Sun "
                        + "Microsystems' Java platform. The language derives much of its "
                        + "syntax from C and C++, but it has fewer low-level facilities than "
                        + "either of them."
                        + "\n\nThe original and reference implementation Java compilers, virtual "
                        + "machines, and class libraries were originally released by Sun under "
                        + "proprietary licences. As of May 2007, in compliance with the "
                        + "specifications of the Java Community Process, Sun relicensed most "
                        + "of its Java technologies under the GNU General Public License. Others "
                        + "have also developed alternative implementations of these Sun "
                        + "technologies, such as the GNU Compiler for Java (bytecode compiler), "
                        + "GNU Classpath (standard libraries), and IcedTea-Web (browser "
                        + "plugin for applets)."
        );
    }

}
