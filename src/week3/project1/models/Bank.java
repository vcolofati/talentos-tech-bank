package week3.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(String name) {
        // tratar null pointer Exception
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getClientName().equals(name)) {
                return this.accounts.get(i);
            }
        }
        return null;
    }

    public void deleteAccount(String name) {
        if (getAccount(name).getBalance() > 0) {
            System.out.println("Você deve sacar todo dinheiro antes de encerrar a conta");
            return;
        }
        Account account = getAccount(name);
        accounts.remove(account);
    }
}
