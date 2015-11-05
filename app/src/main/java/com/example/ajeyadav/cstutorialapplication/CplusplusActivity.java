/**
   Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Programming Language C++
   This class file contains all the method, functions and data for the programming Language C++
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

public class CplusplusActivity extends AppCompatActivity {

    // Textview to store the tutorial text
    TextView textviewcplusplus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cplusplus);
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

        TextView textviewcplusplus = (TextView)findViewById(R.id.textView3);
        textviewcplusplus.setMovementMethod(new ScrollingMovementMethod());
        textviewcplusplus.setText("C++ is a general-purpose programming language. It has "
                + "imperative, object-oriented and generic programming features, while also "
                + "providing facilities for low-level memory manipulation."
                + "\n\nIt was designed with a bias toward system programming and embedded, "
                + "resource-constrained and large systems, with performance, efficiency and "
                + "flexibility of use as its design highlights. C++ has also been found "
                + "useful in many other contexts, with key strengths being software "
                + "infrastructure and resource-constrained applications, including desktop "
                + "applications, servers (e.g. e-commerce, web search or SQL servers), "
                + "and performance-critical applications (e.g. telephone switches or space "
                + "probes).C++ is a compiled language, with implementations of it available "
                + "on many platforms and provided by various organizations, including the FSF, "
                + "LLVM, Microsoft, Intel and IBM."
                + "\n\nC++ is standardized by the International Organization for Standardization "
                + "(ISO), with the latest standard version ratified and published by ISO in "
                + "December 2014 as ISO/IEC 14882:2014 (informally known as C++14). The C++  "
                + "programming language was initially standardized in 1998 as ISO/IEC 14882:1998, "
                + "which was then amended by the C++03, ISO/IEC 14882:2003, standard. The "
                + "current C++14 standard supersedes these and C++11, with new features and "
                + "an enlarged standard library. Before the initial standardization in 1998, "
                + "C++ was developed by Bjarne Stroustrup at Bell Labs since 1979, as an  "
                + "extension of the C language as he wanted an efficient and flexible language "
                + "similar to C, which also provided high-level features for program organization."
        );
    }

}
