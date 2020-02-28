package edu.mum.cs.cs544.exercises.domain.q2;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "flight_tbl")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber,destinationFrom,destinationTo;
    private String flightDate = "90-0920-33";

    public Flight(){}

    public Flight(String flightNumber, String destinationFrom, String destinationTo) {
        this.flightNumber = flightNumber;
        this.destinationFrom = destinationFrom;
        this.destinationTo = destinationTo;
    }
}
