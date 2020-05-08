package cs544.exercise07_1.model.mock1;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Treatment {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private Tree tree;
}
