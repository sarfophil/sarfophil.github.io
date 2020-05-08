package edu.mum.cs.cs544.exercises.domain.question1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Book
 */
@Entity
@DiscriminatorValue("book")
public class Book extends Product{

    private String artist;

    public Book(String name, String description,String artist) {
        super(name, description);
        this.artist = artist;
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    
}