package cs544.exercise07_1.model.mock2;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class MechanicId  implements Serializable {
    private String name;
    private Date hireDate;

}
