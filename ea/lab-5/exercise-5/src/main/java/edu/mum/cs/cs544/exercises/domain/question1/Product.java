package edu.mum.cs.cs544.exercises.domain.question1;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Product
 */
@Entity(name = "product_tbl")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "product_type", 
    discriminatorType=DiscriminatorType.STRING)
public abstract class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name,description;

     public Product(String name,String description){
         this.name = name;
         this.description = description;
     }
    
}