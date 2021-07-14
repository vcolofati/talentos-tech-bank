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

    public void setOverdraft(Double overdraft, String password) throws Exception {
        if (overdraft <= 0) {
            throw new Exception("Valor deve ser maior que zero");
        }
        if(overdraft < this.overdraft) {
            throw new Exception("Valor deve ser maior que limite atual");
        }
        if (password.equals(this.manager.getPassword())) {
            this.overdraft = overdraft;
            System.out.printf("Limite cheque especial aumentado para R$ %.2f%n", this.overdraft);
        } else {
            System.out.println("Erro senha inválida");
        }
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
    }
}
