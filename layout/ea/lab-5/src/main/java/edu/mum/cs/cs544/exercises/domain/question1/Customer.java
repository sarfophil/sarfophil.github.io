package edu.mum.cs.cs544.exercises.domain.question1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Customer
 */
@Entity(name = "customer_tble")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstname,lastname;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private List<Order> oList = new ArrayList<Order>();


    public Customer(){}

    public Customer(String firstname,String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * @param oList the oList to set
     */
    public void setoList(List<Order> oList) {
        this.oList = oList;
    }


    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    
}