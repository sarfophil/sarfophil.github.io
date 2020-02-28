package edu.mum.cs.cs544.exercises.domain.question1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * DVD
 */
@Entity
@DiscriminatorValue("dvd")
public class DVD extends Product{

    private String genre;

    public DVD(String name, String description,String genre) {
        super(name, description);
        this.genre = genre;
    }


    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }
    
}