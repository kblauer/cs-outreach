package edu.ttu.cs.csta.quiz;

import java.io.Serializable;

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
    /** The type of quiz */
    private String type;
    /** The timestamp the quiz was created on */
    private Long createdOn;
    /** The timestamp the quiz was last updated */
    private Long lastModified;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }
}