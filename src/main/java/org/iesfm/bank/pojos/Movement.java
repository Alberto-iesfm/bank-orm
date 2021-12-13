package org.iesfm.bank.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Movement {
    @Id
    @GeneratedValue
    private int id;
    private String iban;
    @Column(name = "movement_date")
    private Date movementDate;
    private double amount;
    private String description;

    public Movement(int id, String iban, Date movementDate, double amount, String description) {
        this.id = id;
        this.iban = iban;
        this.movementDate = movementDate;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Date movementDate) {
        this.movementDate = movementDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return id == movement.id && Double.compare(movement.amount, amount) == 0 && Objects.equals(iban, movement.iban) && Objects.equals(movementDate, movement.movementDate) && Objects.equals(description, movement.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, movementDate, amount, description);
    }
}
