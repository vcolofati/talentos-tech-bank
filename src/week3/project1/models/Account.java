package week3.project1.models;

import java.util.Objects;
import java.util.UUID;

public abstract class Account {
    private Client client;
    private Double balance = 0.0;
    private UUID uuid;

    public Account(Client client, Double amount) {
        setClient(client);
        deposit(amount);
        uuid = UUID.randomUUID();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {

        this.client = client;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(Double amount) {
        this.balance+= amount;
    }

    public void withdraw(Double amount) throws Exception {
        if (this.getBalance() < amount) {
            throw new Exception("Seu saldo não é suficiente");
        }
        this.balance-= amount;
    }

    public void transfer(Double amount, Account destination) throws Exception {
        if (this.getBalance() < amount) {
            throw new Exception("Saldo insuficiente");
        }
        // se a conta destino não existe tratar
        this.balance -= amount;
        destination.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account{" +
                "clientName='" + client.getName() + '\'' +
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
