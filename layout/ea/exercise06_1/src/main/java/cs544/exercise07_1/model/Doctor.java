package cs544.exercise07_1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "doctor_tbl")
public class Doctor {
    @Id
    @GeneratedValue
    private int id;
    private String doctortype;
    private String firstname;
    private String lastname;

    public Doctor() {
    }

    public Doctor(String doctortype, String firstname, String lastname) {
        this.doctortype = doctortype;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
