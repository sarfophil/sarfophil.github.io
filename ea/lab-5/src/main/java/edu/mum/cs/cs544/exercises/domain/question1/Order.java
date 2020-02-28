package edu.mum.cs.cs544.exercises.domain.question1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Order
 */
@Entity(name = "order_tbl")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private  final LocalDate date = LocalDate.now();
    

    @ManyToOne
    @JoinColumn(name = "customer_id",updatable = false,insertable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "orderlines",
            joinColumns = {@JoinColumn(name= "Order_id")},
            inverseJoinColumns = {@JoinColumn(name="OrderLine_id")}
            )
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();


    public Order(){}

    
    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param orderLines the orderLines to set
     */
    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

   

}