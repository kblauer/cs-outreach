package edu.ttu.cs.csta.quiz.model;

import java.io.Serializable;

/**
 * Created by Tristan on 11/4/2015.
 */
public class QuizQuestion implements Serializable {
    /** The question */
    private String question;
    /** The possible answers */
    private String[] answers;
    /** The correct answer */
    private Integer correctAnswer;

    public Boolean isCorrect(Integer answerIndex) {
        return answerIndex.equals(correctAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String... answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}