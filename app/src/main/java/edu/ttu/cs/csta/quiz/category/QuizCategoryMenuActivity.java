package edu.ttu.cs.csta.quiz.category;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ajeyadav.cstutorialapplication.R;

import java.util.ArrayList;

import edu.ttu.cs.csta.quiz.QuizManager;

public class QuizCategoryMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_category_menu);
        this.populateQuizCategoryList();
    }

    /**
     * Populate the list of quiz categories.
     */
    private void populateQuizCategoryList() {
        LinearLayout listView = (LinearLayout) findViewById(R.id.quiz_category_menu_list);

        // Get the quizzes from the server
        ArrayList<QuizCategory> quizCategories = QuizManager.getQuizCategories();

        LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Add the quizzes to the view
        for (QuizCategory quizCategory : quizCategories) {
            View quizCategoryMenuItemView = layoutInflater.inflate(R.layout.fragment_quiz_category_menu_item, null);

            TextView nameTextView = (TextView) quizCategoryMenuItemView.findViewById(R.id.quiz_category_menu_item_name_value);
            nameTextView.setText(quizCategory.getName());

            TextView descriptionTextView = (TextView) quizCategoryMenuItemView.findViewById(R.id.quiz_category_menu_item_description_value);
            descriptionTextView.setText(quizCategory.getDescription());

            quizCategoryMenuItemView.setOnClickListener(new QuizCategoryMenuItemClickListener(quizCategory, this));

            listView.addView(quizCategoryMenuItemView);
        }
    }
}
