package week3.project1.models;

import java.util.Objects;
import java.util.UUID;

public abstract class Account {
    private Client client;
    protected Manager manager;
    protected Double balance = 0.0;
    private final UUID uuid;
    protected Statement statement = new Statement();


    public Account(Client client, Double amount) throws Exception {
        setClient(client);
        deposit(amount);
        uuid = UUID.randomUUID();
        manager = new Manager("King", "default");
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

    public void deposit(Double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Valor deve ser maior que zero");
        }
        this.balance += amount;
        //falar pro extrato para guardar transação
        this.statement.addTransaction(amount);
    }

    public void withdraw(Double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Valor deve ser maior que zero");
        }
        if (this.getBalance() < amount) {
            throw new Exception("Seu saldo não é suficiente");
        }
        this.balance -= amount;
        //falar pro extrato para guardar transação
        this.statement.addTransaction(-amount);
    }

    public void showStatement() {
        this.statement.showTransactions();
    }

    public void transfer(Double amount, Account destination) throws Exception {
        if (amount <= 0) {
            throw new Exception("Valor deve ser maior que zero");
        }
        if (this.getBalance() < amount) {
            throw new Exception("Saldo insuficiente");
        }
        // se a conta destino não existe tratar
        this.balance -= amount;
        destination.deposit(amount);
        //falar pro extrato para guardar transação
        this.statement.addTransaction(-amount);
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
        return getClient().equals(account.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClient());
    }
}
