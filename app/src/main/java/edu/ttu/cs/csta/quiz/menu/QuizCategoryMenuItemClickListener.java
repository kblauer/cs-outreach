package edu.ttu.cs.csta.quiz.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import edu.ttu.cs.csta.quiz.QuizCategory;

/**
 * Created by Tristan on 10/25/2015.
 */
public class QuizCategoryMenuItemClickListener implements OnClickListener {
    private static final String QUIZ_CATEGORIES_EXTRAS = "QUIZ_CATEGORY";

    /** The quiz category that was clicked */
    private QuizCategory quizCategory;
    /** The parent activity for this on click listener */
    private AppCompatActivity appCompatActivity;

    /**
     * Default constructor.
     *
     * @param quizCategory the quiz category that was clicked
     * @param appCompatActivity the activity this on click listener comes from
     */
    public QuizCategoryMenuItemClickListener(QuizCategory quizCategory, AppCompatActivity appCompatActivity) {
        this.quizCategory = quizCategory;
        this.appCompatActivity = appCompatActivity;
    }

    /**
     * Actions to perform on click.
     *
     * @param v the view
     */
    public void onClick(View v) {
        Intent intent = new Intent(appCompatActivity, QuizMenuActivity.class);
        intent.putExtra(QUIZ_CATEGORIES_EXTRAS, quizCategory);
        appCompatActivity.startActivity(intent);
    }
}