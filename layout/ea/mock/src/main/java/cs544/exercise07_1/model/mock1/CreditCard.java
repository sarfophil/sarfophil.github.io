package cs544.exercise07_1.model.mock1;

import javax.persistence.*;
import java.util.Date;


@Entity
public class CreditCard {
    @Id
    private long number;
    @Column(name="nameOnCard")
    private String name;
    @Temporal(TemporalType.DATE)
    private Date expiration;

    @OneToOne(mappedBy = "cc")
    private Customer customer;

}
