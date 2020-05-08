package edu.mum.cs.cs544.exercises.domain.question1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * CD
 */
@Entity
@DiscriminatorValue("cd")
public class CD extends Product{

    private String title;

    public CD(String name, String description,String title) {
        super(name, description);
        this.title = title;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    
}