/* Ajeet Kumar Yadav
   Project Team - 5
   CS Tutorial Application
   CS 5363 - Software Project Management
   Java file for the Quiz
   Once selected this will redirect the user to a new activity called Quiz
*/


package edu.ttu.cs.csta.quiz.intro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.ajeyadav.cstutorialapplication.R;

import edu.ttu.cs.csta.quiz.Quiz;

public class QuizIntroActivity extends AppCompatActivity {
    private static final String QUIZ_EXTRA = "QUIZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_intro);

        Quiz quiz = (Quiz) this.getIntent().getExtras().getSerializable(QUIZ_EXTRA);
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

        Button quizStartQuizButton = (Button) findViewById(R.id.quiz_start_quiz_button);
        quizStartQuizButton.setOnClickListener(new QuizIntroItemClickListener(quiz, this));
    }
}
