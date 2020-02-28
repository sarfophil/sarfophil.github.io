package edu.mum.cs.cs544.exercises.domain.q2;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "passenger_tbl")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passenger_id",nullable = false)
    private Collection<Flight> flights = new ArrayList<>();



    public Passenger(){

    }

    public Passenger(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }
}
