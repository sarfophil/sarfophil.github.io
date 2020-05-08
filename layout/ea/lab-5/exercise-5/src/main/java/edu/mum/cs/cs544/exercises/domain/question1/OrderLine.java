package edu.mum.cs.cs544.exercises.domain.question1;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * OrderLine
 */
@Entity(name = "orderLine_tbl")
public class OrderLine {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product")
    private Product product;


    public OrderLine(String quantity){
        this.quantity = quantity;
    }


    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
}