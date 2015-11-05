package edu.ttu.cs.csta.quiz.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ajeyadav.cstutorialapplication.R;

import edu.ttu.cs.csta.quiz.QuizManager;
import edu.ttu.cs.csta.quiz.score.QuizScoreActivity;

public class QuizQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        displayNextQuestion();
    }

    private void displayNextQuestion() {
        QuizQuestion quizQuestion = QuizManager.getNextQuizQuestion();
        if (quizQuestion != null) {
            TextView quizQuestionTextView = (TextView) findViewById(R.id.quiz_question_text);
            quizQuestionTextView.setText(quizQuestion.getQuestion());

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.quiz_question_content);

            for (int i = 0; i < quizQuestion.getAnswers().length; i++) {
                Button button = new Button(this);
                button.setText(quizQuestion.getAnswers()[i]);
                button.setOnClickListener(new QuizQuestionItemClickListener(this, i));

                linearLayout.addView(button);
            }
        } else {
            Intent intent = new Intent(this, QuizScoreActivity.class);
            this.startActivity(intent);
        }
    }
}