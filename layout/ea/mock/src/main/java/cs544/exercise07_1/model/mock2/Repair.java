package cs544.exercise07_1.model.mock2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Repair {
    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "tech",referencedColumnName = "name"),
            @JoinColumn(name = "tech_date",referencedColumnName = "hireDate")
    })
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "automobile_id")
    private Automobile automobile;

    @OneToMany
    @JoinColumn(name = "repair_id")
    private List<Part> parts = new ArrayList<>();
}
