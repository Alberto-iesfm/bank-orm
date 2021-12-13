package org.iesfm.bank.pojos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Account {
    @Id
    private String iban;
    @Column (name = "owner_id")
    private int ownerId;
    private double balance;
    @Column (name = "open_date")
    private Date openDate;
    @OneToMany
    @JoinColumn(name = "iban", referencedColumnName = "iban")
    private List<Movement> movements;

    public Account(String iban, int ownerId, double balance, Date openDate, List<Movement> movements) {
        this.iban = iban;
        this.ownerId = ownerId;
        this.balance = balance;
        this.openDate = openDate;
        this.movements = movements;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return ownerId == account.ownerId && Double.compare(account.balance, balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(openDate, account.openDate) && Objects.equals(movements, account.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, ownerId, balance, openDate, movements);
    }
}
