package cs544.exercise07_1.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "address_tbl")
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String street;
    private String zip;
    private String city;

    public Address() {
    }

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
