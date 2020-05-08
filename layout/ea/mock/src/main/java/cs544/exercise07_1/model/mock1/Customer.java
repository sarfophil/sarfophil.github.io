package cs544.exercise07_1.model.mock1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne
    private CreditCard cc;
    @OneToMany
    private List<Tree> trees =
            new ArrayList<>();

}
