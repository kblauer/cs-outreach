package edu.ttu.cs.csta.quiz.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.ajeyadav.cstutorialapplication.R;

import edu.ttu.cs.csta.quiz.QuizManager;

public class QuizScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        populateScorePage();
    }

    private void populateScorePage() {
        TextView scoreValueTextView = (TextView) findViewById(R.id.quiz_score_score_value);
        scoreValueTextView.setText(QuizManager.getScore() + "");

        TextView scorePossibleTextView = (TextView) findViewById(R.id.quiz_score_possible_value);
        scorePossibleTextView.setText(QuizManager.getPossibleScore() + "");

        QuizManager.stopQuiz();
    }
}
