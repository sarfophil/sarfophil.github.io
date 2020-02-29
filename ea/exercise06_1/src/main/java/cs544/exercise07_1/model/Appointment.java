package cs544.exercise07_1.model;

import javax.persistence.*;

@Entity(name = "appointment_tbl")
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private String appdate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient")
    private Patient patient;

    @Embedded
    private Payment payment;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    public Appointment() {
    }

    public Appointment(String appdate, Patient patient, Payment payment, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }
}
