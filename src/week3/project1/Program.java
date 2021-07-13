package week3.project1;

import week3.project1.models.Account;
import week3.project1.models.Bank;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Criar conta - perguntar nome cliente, saldo inicial, tipo de conta e id aleatório de 4 digitos
        Bank bank = new Bank();
        mainMenu(bank);

        //Ao terminar de preencher os dados de abertura da conta, o programa deverá mostrar um menu com as seguintes
        //opções;
        // * Listar
        // * Realizar Saque
        // * Depositar;
        // * Adicionar limite de cheque especial ( Deve pedir a senha do gerente)

        //Encerrar conta (Ao encerrar a conta, o usuário deve realizar o saque de
        // todo o valor restante na conta e não pode estar devendo nada no cheque especial).
    }

    public static void mainMenu(Bank bank) {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        do {
            System.out.println("================== Coders Bank ==================");
            System.out.println("Para cadastrar uma nova conta digite 1");
            System.out.println("Para acessar uma conta digite 2");
            System.out.println("Para sair, digite 3");
            System.out.print("Opção: ");
            int resp = sc.nextInt();
            switch (resp) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    sc.nextLine();
                    String clientName = sc.nextLine().trim();
                    System.out.print("Digite o depósito inicial: ");
                    double initialDeposit = sc.nextDouble();
                    bank.addAccount(new Account(clientName, initialDeposit));
                    break;
                case 2:
                    // Acessar conta
                    clientMenu(bank);
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
            }
        } while (isRunning);
        sc.close();
    }

    public static void clientMenu(Bank bank) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu nome completo: ");
        String clientName = sc.nextLine().trim();
        Account account = bank.getAccount(clientName);
        System.out.printf("Bem vindo(a) %s", account.getClientName());
        System.out.println();
        int resp;
        do {
            System.out.println("Para consultar seu saldo, digite 1");
            System.out.println("Para listar seu extrato, digite 2");
            System.out.println("Para realizar saque, digite 3");
            System.out.println("Para realizar depósito, digite 4");
            System.out.println("Para adicionar limite de cheque especial, digite 5");
            System.out.println("Para encerrar sua conta, digite 6");
            System.out.println("Para voltar, digite 0");
            resp = sc.nextInt();
            switch (resp) {
                case 1:
                    // saldo
                    System.out.printf("Seu saldo é %.2f%n", account.getBalance());
                    break;
                case 2:
                    //listar extrato
                case 3:
                    //realizar saque
                    System.out.println("Quanto deseja sacar?");
                    System.out.print("Valor: ");
                    account.withdraw(sc.nextDouble());
                    System.out.printf("Seu saldo atualizado é %.2f%n", account.getBalance());
                    break;
                case 4:
                    //depositar
                    System.out.println("Quanto deseja depositar?");
                    System.out.print("Valor: ");
                    account.deposit(sc.nextDouble());
                    System.out.printf("Seu saldo atualizado é %.2f%n", account.getBalance());
                    break;
                case 5:
                    //adicionar limite cheque especial
                case 6:
                    System.out.println("Tem certeza que deseja encerrar a conta [s/N]?");
                    if (sc.next().charAt(0) == 's') {
                        bank.deleteAccount(clientName);
                    }
                    resp = 0;
                default:
                    System.out.println("Saindo");
                    break;
            }
        } while (resp != 0);
    }
}
