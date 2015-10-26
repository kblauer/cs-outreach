package edu.ttu.cs.csta.quiz;

import java.util.ArrayList;

/**
 * Manages the quizzes for the application.
 *
 * Created by Tristan on 10/25/2015.
 */
public class QuizManager {
    /**
     * Gets the quizzes from the server and returns a list of quiz groups.
     */
    // TODO Implement server functionality
    public static ArrayList<QuizCategory> getQuizCategories() {
        ArrayList<QuizCategory> quizCategories = new ArrayList<>();

        // Generate a test category
        // TODO Remove this
        for (int i = 0; i < 50; i++) {
            QuizCategory quizCategory = new QuizCategory();
            quizCategory.setName("Test category #" + (i+1));
            quizCategory.setDescription("This is a test description.");

            quizCategories.add(quizCategory);
        }

        return quizCategories;
    }

    /**
     * Gets the quizzes for the specified category and returns a list of quizzes.
     *
     * @param quizCategory the quiz category
     * @return the list of quizzes
     */
    public static ArrayList<Quiz> getQuizzes(QuizCategory quizCategory) {
        ArrayList<Quiz> quizzes = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Quiz quiz = new Quiz();
            quiz.setName(quizCategory.getName() + " - Quiz " + (i + 1));
            quiz.setDescription("This quiz #" + (i + 1) + " in the category " + quizCategory.getName());

            quizzes.add(quiz);
        }

        return quizzes;
    }
}