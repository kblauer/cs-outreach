package edu.ttu.cs.csta.quiz.menu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ajeyadav.cstutorialapplication.R;

import java.util.ArrayList;

import edu.ttu.cs.csta.quiz.Quiz;
import edu.ttu.cs.csta.quiz.category.QuizCategory;
import edu.ttu.cs.csta.quiz.QuizManager;

public class QuizMenuActivity extends AppCompatActivity {
    private static final String QUIZ_CATEGORIES_EXTRA = "QUIZ_CATEGORY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        QuizCategory quizCategory = (QuizCategory) getIntent().getExtras().getSerializable(QUIZ_CATEGORIES_EXTRA);
        populateView(quizCategory);
    }

    /**
     * Populate the view.
     *
     * @param quizCategory the quiz category
     */
    private void populateView(QuizCategory quizCategory) {
        TextView quizCategoryName = (TextView) findViewById(R.id.quiz_menu_category_name);
        quizCategoryName.setText(quizCategory.getName());

        TextView quizCategoryDescription = (TextView) findViewById(R.id.quiz_menu_category_description);
        quizCategoryDescription.setText(quizCategory.getDescription());

        populateQuizList(quizCategory);
    }

    /**
     * Populate the list of quizzes in the view.
     *
     * @param quizCategory the list of quizzes
     */
    private void populateQuizList(QuizCategory quizCategory) {
        LinearLayout listView = (LinearLayout) findViewById(R.id.quiz_menu_list);

        // Get the quizzes from the server
        ArrayList<Quiz> quizzes = QuizManager.getQuizzes(quizCategory);

        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Add the quizzes to the view
        for (Quiz quiz : quizzes) {
            View quizCategoryMenuItemView = layoutInflater.inflate(R.layout.fragment_quiz_menu_item, null);

            TextView nameTextView = (TextView) quizCategoryMenuItemView.findViewById(R.id.quiz_menu_item_name_value);
            nameTextView.setText(quiz.getName());

            TextView descriptionTextView = (TextView) quizCategoryMenuItemView.findViewById(R.id.quiz_menu_item_description_value);
            descriptionTextView.setText(quiz.getDescription());

            quizCategoryMenuItemView.setOnClickListener(new QuizMenuItemClickListener(quiz, this));

            listView.addView(quizCategoryMenuItemView);
        }
    }
}
