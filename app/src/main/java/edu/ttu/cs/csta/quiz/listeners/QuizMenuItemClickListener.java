package edu.ttu.cs.csta.quiz.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import edu.ttu.cs.csta.quiz.model.Quiz;
import edu.ttu.cs.csta.quiz.activity.QuizIntroActivity;

/**
 * Created by Tristan on 10/25/2015.
 */
public class QuizMenuItemClickListener implements OnClickListener {
    private static final String QUIZ_EXTRA = "QUIZ";

    /** The quiz that was clicked */
    private Quiz quiz;
    /** The parent activity for this on click listener */
    private AppCompatActivity appCompatActivity;

    /**
     * Default constructor.
     *
     * @param quiz the quiz that was clicked
     * @param appCompatActivity the activity this on click listener comes from
     */
    public QuizMenuItemClickListener(Quiz quiz, AppCompatActivity appCompatActivity) {
        this.quiz = quiz;
        this.appCompatActivity = appCompatActivity;
    }

    /**
     * Actions to perform on click.
     *
     * @param v the view
     */
    public void onClick(View v) {
        Intent intent = new Intent(appCompatActivity, QuizIntroActivity.class);
        intent.putExtra(QUIZ_EXTRA, quiz);
        appCompatActivity.startActivity(intent);
    }
}