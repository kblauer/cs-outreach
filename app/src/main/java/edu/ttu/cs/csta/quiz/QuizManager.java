package edu.ttu.cs.csta.quiz;

import java.text.DecimalFormat;
import java.util.ArrayList;

import edu.ttu.cs.csta.quiz.model.QuizCategory;
import edu.ttu.cs.csta.quiz.model.Quiz;
import edu.ttu.cs.csta.quiz.model.QuizQuestion;

/**
 * Manages the quizzes for the application.
 *
 * Created by Tristan on 10/25/2015.
 */
public class QuizManager {
    /** The quiz that is currently being run */
    private static Quiz quiz;

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
            quizCategory.setName("Test category #" + (i + 1));
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
            quiz.setDescription("This is quiz #" + (i + 1) + " in the category " + quizCategory.getName());
            quiz.setQuizQuestions(QuizManager.getQuizQuestions(quiz));

            quizzes.add(quiz);
        }

        return quizzes;
    }

    /**
     * Gets the QuizQuestions for the specified Quiz.
     *
     * @param quiz the quiz
     * @return the list of quiz questions
     */
    private static ArrayList<QuizQuestion> getQuizQuestions(Quiz quiz) {
        ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            QuizQuestion quizQuestion = new QuizQuestion();
            quizQuestion.setQuestion("What is the correct answer? Question " + i);
            quizQuestion.setAnswers("This is the correct answer", "No wait, this is", "This is definitely it", "All of the above");
            quizQuestion.setCorrectAnswer(0);

            quizQuestions.add(quizQuestion);
        }

        return quizQuestions;
    }

    /**
     * Starts the specified quiz.
     *
     * @param quiz the quiz
     */
    public static void startQuiz(Quiz quiz) {
        QuizManager.quiz = quiz;
        QuizManager.quiz.setCurrentQuestion(-1);
    }

    public static void stopQuiz() {
        QuizManager.quiz = null;
    }

    /**
     * Gets the next quiz question.
     *
     * @return the next quiz question
     */
    public static QuizQuestion getNextQuizQuestion() {
        QuizQuestion quizQuestion = QuizManager.quiz.getNextQuizQuestion();

        if (quizQuestion != null)
            return quizQuestion;

        return null;
    }

    /**
     * Attempts the selected answer.
     *
     * @param answerIndex the answer index
     */
    public static void attemptAnswer(Integer answerIndex) {
        QuizQuestion quizQuestion = QuizManager.quiz.getCurrentQuizQuestion();

        if (quizQuestion != null) {
            Boolean answerCorrect = quizQuestion.isCorrect(answerIndex);

            if (answerCorrect)
                QuizManager.quiz.incrementScore();
        }
    }

    /**
     * Gets the current score.
     *
     * @return the current score
     */
    public static Integer getScore() {
        return QuizManager.quiz.getCurrentScore();
    }

    /**
     * Gets the percentage of questions answered correctly.
     *
     * @return the percentage of questions answered correctly
     */
    public static String getScorePercentage() {
        Integer score = QuizManager.quiz.getCurrentScore();
        Integer possibleScore = QuizManager.quiz.getPossibleScore();

        Double percentComplete = ((double) score / (double) possibleScore) * 100.0;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");


        return decimalFormat.format(percentComplete) + "%";
    }

    /**
     * Checks if the quiz is on the last question.
     *
     * @return true if the quiz is on the last question; false otherwise
     */
    public static Boolean isLastQuestion() {
        return QuizManager.quiz.isLastQuestion();
    }
}