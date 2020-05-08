package cs544.exercise07_1.model.mock1;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Plant")
@DiscriminatorColumn(name = "Ttype")
public class Tree {
    @Id
    @GeneratedValue
    private int id;
    private int height;
    private double price;
    @OneToMany(mappedBy = "tree")
    private List<Treatment> treatments =
            new ArrayList<>();
}
