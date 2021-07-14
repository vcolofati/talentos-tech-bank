package week3.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        if (!accounts.contains(account)) {
            accounts.add(account);
            System.out.println("Conta criada com sucesso.");
        } else {
            System.out.println("Já existe conta cadastrada com esses dados");
        }
    }

    public Account getAccount(String name) {
        // tratar null pointer Exception
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getClient().getName().equals(name)) {
                return this.accounts.get(i);
            }
        }
        return null;
    }

    public Integer deleteAccount(String name) {
        if (getAccount(name).getBalance() > 0) {
            return 1;
        } else if (getAccount(name).getBalance() < 0) {
            return -1;
        } else if (getAccount(name).getBalance() == 0) {
            Account account = getAccount(name);
            accounts.remove(account);
        }
        return 0;
    }
}
