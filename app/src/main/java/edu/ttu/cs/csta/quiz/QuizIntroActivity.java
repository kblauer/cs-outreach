/* Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Quiz
   Once selected this will redirect the user to a new activity called Quiz
*/


package edu.ttu.cs.csta.quiz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ajeyadav.cstutorialapplication.R;

public class QuizIntroActivity extends AppCompatActivity {
    private static final String QUIZ_EXTRAS = "QUIZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_intro);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Quiz quiz = (Quiz) this.getIntent().getExtras().getSerializable(QUIZ_EXTRAS);
        populateQuizIntro(quiz);
    }

    /**
     * Populate the quiz intro screen.
     *
     * @param quiz the quiz
     */
    private void populateQuizIntro(Quiz quiz) {
        TextView quizNameTextView = (TextView) findViewById(R.id.quiz_name);
        quizNameTextView.setText(quiz.getName());

        TextView quizDescriptionTextView = (TextView) findViewById(R.id.quiz_description);
        quizDescriptionTextView.setText(quiz.getDescription());


    }
}
