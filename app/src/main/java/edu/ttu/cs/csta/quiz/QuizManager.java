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

//        // Generate a test category
//        // TODO Remove this
//        for (int i = 0; i < 50; i++) {
//            QuizCategory quizCategory = new QuizCategory();
//            quizCategory.setName("Test category #" + (i + 1));
//            quizCategory.setDescription("This is a test description.");
//
//            quizCategories.add(quizCategory);
//        }

        QuizCategory quizCategory = new QuizCategory();
        quizCategory.setName("Programming Languages");
        quizCategory.setDescription("These quizzes pertain to information related to programming languages and their fundamental concepts.");
        quizCategories.add(quizCategory);

        quizCategory = new QuizCategory();
        quizCategory.setName("Software Project Management");
        quizCategory.setDescription("Man, we could put all of Dr. Mengel's quizzes in here! :D");
        quizCategories.add(quizCategory);

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

        if (quizCategory.getName().equals("Programming Languages")) {
            Quiz quiz;

            quiz = new Quiz();
            quiz.setName("C");
            quiz.setDescription("This contains questions about the C programming language");
            quiz.setQuizQuestions(QuizManager.getQuizQuestions(quiz));
            quizzes.add(quiz);

            quiz = new Quiz();
            quiz.setName("C#");
            quiz.setDescription("This contains questions about the C# programming language");
            quiz.setQuizQuestions(QuizManager.getQuizQuestions(quiz));
            quizzes.add(quiz);

            quiz = new Quiz();
            quiz.setName("C++");
            quiz.setDescription("This contains questions about the C++ programming language");
            quiz.setQuizQuestions(QuizManager.getQuizQuestions(quiz));
            quizzes.add(quiz);

            quiz = new Quiz();
            quiz.setName("Java");
            quiz.setDescription("This contains questions about the Java programming language");
            quiz.setQuizQuestions(QuizManager.getQuizQuestions(quiz));
            quizzes.add(quiz);

            quiz = new Quiz();
            quiz.setName("Python");
            quiz.setDescription("This contains questions about the Python programming language");
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

        if (quiz.getName().equals("Java")) {
            QuizQuestion quizQuestion;

            quizQuestion = new QuizQuestion();
            quizQuestion.setQuestion("What is the default scope of methods in Java?");
            quizQuestion.setAnswers("Public", "Private", "Package-Private", "Protected");
            quizQuestion.setCorrectAnswer(2);
            quizQuestions.add(quizQuestion);

            quizQuestion = new QuizQuestion();
            quizQuestion.setQuestion("Who was the founder of Java?");
            quizQuestion.setAnswers("James Gosling", "Grace Hopper", "Alan Turing", "None of the above");
            quizQuestion.setCorrectAnswer(0);
            quizQuestions.add(quizQuestion);

            quizQuestion = new QuizQuestion();
            quizQuestion.setQuestion("What does Java aim to be?");
            quizQuestion.setAnswers(
                    "Simple, object-oriented, and familiar",
                    "Robust and secure",
                    "Architecture-neutral and portable",
                    "High performance",
                    "Interpreted, threaded and dynamic",
                    "All of the above");
            quizQuestion.setCorrectAnswer(5);
            quizQuestions.add(quizQuestion);

            quizQuestion = new QuizQuestion();
            quizQuestion.setQuestion("What does 2+2*3 evaluate to in java?");
            quizQuestion.setAnswers(
                    "223",
                    "8",
                    "12",
                    "None of the above");
            quizQuestion.setCorrectAnswer(1);
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
        QuizManager.quiz.resetScore();
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