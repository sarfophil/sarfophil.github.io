package edu.mum.cs.cs544.exercises.domain.q1;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "laptop_tbl")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand,type;

    @ManyToOne
    @JoinColumn(name = "employee_id",updatable = false,insertable = false)
    private Employee employee;

    public Laptop(){}

    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != getClass()) return false;
        Laptop laptop = (Laptop) obj;
        return brand.equals(laptop.brand) && type.equals(laptop.type);
    }


    @Override
    public int hashCode() {
        return Objects.hash(brand,type);
    }
}
