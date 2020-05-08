package cs544.exercise07_1.model;

import javax.persistence.*;

@Entity(name = "patient_tbl")
public class Patient {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private Address address;

    public Patient() {
    }

    public Patient(String name,Address address) {
        this.name = name;
        this.address = address;
    }
}
