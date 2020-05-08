package cs544.exercise07_1.model.mock2;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Accounting",pkJoinColumns = {@PrimaryKeyJoinColumn})
public class Part {

    @Id
    @GeneratedValue
    private int id;
    private String description;

    @Column(table = "Accounting")
    @JoinColumn()
    private double purchasePrice;

}
