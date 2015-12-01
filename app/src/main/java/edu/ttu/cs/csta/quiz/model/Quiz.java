package edu.ttu.cs.csta.quiz.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A single quiz object.
 *
 * Created by Tristan on 10/25/2015.
 */
public class Quiz implements Serializable {
    /** The name of the quiz */
    private String name;
    /** A description of the quiz */
    private String description;
    /** The quiz questions */
    private QuizQuestion[] quizQuestions;
    /** The current score */
    private Integer currentScore = 0;
    /** The current question */
    private Integer currentQuestion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QuizQuestion[] getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(ArrayList<QuizQuestion> quizQuestions) {
        QuizQuestion[] quizQuestionArray = new QuizQuestion[quizQuestions.size()];

        for (int i = 0; i < quizQuestions.size(); i++)
            quizQuestionArray[i] = quizQuestions.get(i);

        this.quizQuestions = quizQuestionArray;
    }

    public void setCurrentQuestion(Integer currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public QuizQuestion getNextQuizQuestion() {
        try {
            this.currentQuestion++;
            return quizQuestions[currentQuestion];
        } catch (ArrayIndexOutOfBoundsException aioobe) {

        }
        return null;
    }

    public QuizQuestion getCurrentQuizQuestion() {
        try {
            return quizQuestions[currentQuestion];
        } catch (ArrayIndexOutOfBoundsException aioobe) {

        }
        return null;
    }

    public int getPossibleScore() {
        return this.getQuizQuestions().length;
    }

    public Boolean isLastQuestion() {
        return this.currentQuestion == (quizQuestions.length -1);
    }

    public Integer getCurrentScore() {
        return this.currentScore;
    }

    public void incrementScore() {
        this.currentScore++;
    }

    public void resetScore() {
        this.currentScore = 0;
    }
}