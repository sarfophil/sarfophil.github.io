package edu.mum.cs.cs544.exercises.domain.q1;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "employee_tbl")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname,lastname;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "employee_id",nullable = false)
    private Set<Laptop> laptops = new HashSet<>();

    public Employee(){}

    public Employee(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }
}
