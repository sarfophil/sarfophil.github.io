package cs544.exercise07_1.model.mock2;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "Technician")
public class Mechanic {
    @EmbeddedId
    private MechanicId id;
    private double salary;
    private String phonenr;

    @OneToMany(mappedBy = "mechanic")
    private List<Repair> repairs
            = new ArrayList<>();
}
