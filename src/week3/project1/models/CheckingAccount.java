package week3.project1.models;

public class CheckingAccount extends Account {

    Double overdraft;

    public CheckingAccount(Client client, Double amount, Double overdraft) throws Exception {
        super(client, amount);
        this.overdraft = overdraft;
    }

    public Double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(Double amount) throws Exception {
        //TODO pensar na lógica
        if (amount <= 0) {
            throw new Exception("Valor deve ser maior que zero");
        }
        if (this.getBalance() + this.getOverdraft() < amount) {
            throw new Exception("Seu saldo não é suficiente");
        } else {
            this.balance -= amount;
            this.overdraft -= Math.abs(this.balance);
            this.statement.addTransaction(-amount);
        }
    }

    @Override
    public void transfer(Double amount, Account destination) throws Exception {
        if (amount <= 0) {
            throw new Exception("Valor deve ser maior que zero");
        }
        if (this.getBalance() < amount) {
            throw new Exception("Saldo insuficiente");
        }
        // se a conta destino não existe tratar
        this.balance -= amount;
        //falar pro extrato para guardar transação
        this.statement.addTransaction(-amount);

        destination.deposit(amount);
        //falar pro extrato para guardar transação
    }
}
