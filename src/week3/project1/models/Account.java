package week3.project1.models;

import java.util.Objects;
import java.util.UUID;

public class Account {
    private String clientName;
    private Double balance = 0.0;
    private UUID uuid;

    public Account(String clientName, Double amount) {
        setClientName(clientName);
        deposit(amount);
        uuid = UUID.randomUUID();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {

        this.clientName = clientName;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double amount) {
        this.balance+= amount;
    }

    public void withdraw(Double amount) {
        this.balance-= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientName='" + clientName + '\'' +
                ", balance=" + balance +
                ", uuid=" + uuid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return uuid.equals(account.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
