package cs544.exercise07_1.model.mock2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Automobile {
    @Id
    @GeneratedValue
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;

    @OneToMany(mappedBy = "automobile")
    private List<Repair> repairs
            = new ArrayList<>();
}
