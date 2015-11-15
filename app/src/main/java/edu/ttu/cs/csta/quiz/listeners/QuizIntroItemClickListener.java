package edu.ttu.cs.csta.quiz.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.view.View;

import edu.ttu.cs.csta.quiz.QuizManager;
import edu.ttu.cs.csta.quiz.model.Quiz;
import edu.ttu.cs.csta.quiz.activity.QuizQuestionActivity;

/**
 * Created by Tristan on 11/4/2015.
 */
public class QuizIntroItemClickListener implements OnClickListener {
    /** The quiz that was started */
    private Quiz quiz;
    /** The parent activity for this on click listener */
    private AppCompatActivity appCompatActivity;

    /**
     * Default constructor.
     *
     * @param quiz the quiz that was started
     * @param appCompatActivity the activity this on click listener comes from
     */
    public QuizIntroItemClickListener(Quiz quiz, AppCompatActivity appCompatActivity) {
        this.quiz = quiz;
        this.appCompatActivity = appCompatActivity;
    }

    /**
     * Actions to perform on click.
     *
     * @param v the view
     */
    public void onClick(View v) {
        QuizManager.startQuiz(quiz);

        Intent intent = new Intent(appCompatActivity, QuizQuestionActivity.class);
        appCompatActivity.startActivity(intent);
    }
}
