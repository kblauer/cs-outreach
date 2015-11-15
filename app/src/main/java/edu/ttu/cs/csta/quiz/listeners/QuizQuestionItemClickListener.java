package edu.ttu.cs.csta.quiz.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import edu.ttu.cs.csta.quiz.QuizManager;
import edu.ttu.cs.csta.quiz.activity.QuizQuestionActivity;
import edu.ttu.cs.csta.quiz.activity.QuizScoreActivity;

/**
 * Created by Tristan on 11/4/2015.
 */
public class QuizQuestionItemClickListener implements OnClickListener{

    private AppCompatActivity appCompatActivity;
    private Integer selectedAnswer;

    public QuizQuestionItemClickListener(AppCompatActivity appCompatActivity, Integer selectedAnswer) {
        this.appCompatActivity = appCompatActivity;
        this.selectedAnswer = selectedAnswer;
    }

    public void onClick(View v) {
        QuizManager.attemptAnswer(selectedAnswer);

        Intent intent;
        if (QuizManager.isLastQuestion()) {
            intent = new Intent(appCompatActivity, QuizScoreActivity.class);
        } else {
            intent = new Intent(appCompatActivity, QuizQuestionActivity.class);
        }

        appCompatActivity.startActivity(intent);
        appCompatActivity.finish();
    }
}