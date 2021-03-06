package cs544.exercise07_1.model;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
    private String paydate;
    private double amount;

    public Payment() {
    }

    public Payment(String paydate, double amount) {
        this.paydate = paydate;
        this.amount = amount;
    }
}
