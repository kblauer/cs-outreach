package edu.ttu.cs.csta.quiz.model;

import java.io.Serializable;

/**
 * A category of quizzes.
 *
 * Created by Tristan on 10/25/2015.
 */
public class QuizCategory implements Serializable {
    /** The name of the category */
    private String name;
    /** A description of the quiz category */
    private String description;

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
}