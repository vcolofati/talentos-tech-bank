package week3.project1.program;

import week3.project1.models.*;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Bank bank = new Bank();
        mainMenu(bank);
    }

    public static int getUserInput(Scanner sc) {
        if (!sc.hasNextInt()) {
            sc.next();
            return -1;
        }
        return sc.nextInt();
    }

    public static void mainMenu(Bank bank) {

        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;

        do {
            System.out.println("================== Coders Bank ==================");
            System.out.println("[1] Cadastrar uma nova conta");
            System.out.println("[2] Acessar uma conta");
            System.out.println("[3] Sair");
            System.out.println("=================================================");
            System.out.print("Opção: ");
            switch (getUserInput(sc)) {
                case 1:
                    // Cadastrar Conta
                    System.out.print("Digite o nome do cliente: ");
                    sc.nextLine();
                    String clientName = sc.nextLine().trim();
                    System.out.print("Digite o cpf do cliente: ");
                    String cpf = sc.nextLine().trim();
                    System.out.print("Digite a profissão do cliente: ");
                    String occupation = sc.nextLine().trim();
                    Client client = new Client(clientName, cpf, occupation);
                    System.out.println("[1] Conta Corrente");
                    System.out.println("[2] Conta Poupança");
                    int accountType = getUserInput(sc);
                    Account account;
                    String password;
                    double initialDeposit;
                    try {
                        switch (accountType) {
                            case 1:
                                System.out.print("Digite uma senha para sua conta: ");
                                password = sc.next();
                                System.out.print("Digite o depósito inicial: ");
                                initialDeposit = sc.nextDouble();
                                account = new CheckingAccount(client, initialDeposit, password,
                                        300.0);
                                System.out.printf("Sua conta corrente é a %d%n", account.getAccountId());
                                bank.addAccount(account);

                                break;
                            case 2:
                                System.out.print("Digite uma senha para sua conta: ");
                                password = sc.next();
                                System.out.print("Digite o depósito inicial: ");
                                initialDeposit = sc.nextDouble();
                                account = new SavingsAccount(client, initialDeposit, password);
                                System.out.printf("Sua conta poupança é a %d%n", account.getAccountId());
                                bank.addAccount(account);
                                break;
                            default:
                                System.out.println("Comando inválido");
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    // Acessar conta
                    clientMenu(bank, sc);
                    break;
                case 3:
                    // Encerra programa
                    isRunning = false;
                    break;
                default:
                    System.out.println("Comando inválido");
                    break;
            }
        } while (isRunning);
        sc.close();
    }

    public static void clientMenu(Bank bank, Scanner sc) {
        boolean isRunning = true;
        System.out.print("Digite o número da conta: ");
        int accountId = getUserInput(sc);
        if (bank.getAccount(accountId) == null) {
            System.out.println("Conta não existente");
            return;
        }
        Account account = bank.getAccount(accountId);
        System.out.printf("Bem vindo(a) %s%n", account.getClient().getName());
        System.out.println();
        do {
            System.out.println("[1] Consultar saldo");
            System.out.println("[2] Listar extrato");
            System.out.println("[3] Realizar saque");
            System.out.println("[4] Realizar depósito");
            System.out.println("[5] Efetuar uma transferência");
            System.out.println("[6] Adicionar limite de cheque especial");
            System.out.println("[7] Encerrar conta");
            System.out.println("[8] Voltar");
            switch (getUserInput(sc)) {
                case 1:
                    // saldo
                    System.out.printf("Seu saldo é R$ %.2f%n", account.getBalance());
                    break;
                case 2:
                    account.showStatement();
                    break;
                case 3:
                    //realizar saque
                    System.out.println("Quanto deseja sacar?");
                    System.out.print("Valor: ");
                    try {
                        account.withdraw(sc.nextDouble());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.printf("Seu saldo atualizado é %.2f%n", account.getBalance());
                    break;
                case 4:
                    //depositar
                    System.out.println("Quanto deseja depositar?");
                    System.out.print("Valor: ");
                    try {
                        account.deposit(sc.nextDouble());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.printf("Seu saldo atualizado é %.2f%n", account.getBalance());
                    break;
                case 5:
                    //transferir
                    //TODO LATER validar cpf do usuário, não está validando
                    //System.out.print("Digite o cpf do destinatário: ");
                    //String cpf = sc.next();
                    System.out.print("Digite o número da conta que deseja transferir: ");
                    int userAccountId = sc.nextInt();
                    Account destination = bank.getAccount(userAccountId);
                    System.out.print("Digite o valor para transferir: ");

                    //TODO checar se existe destinatário
                    // se existir faz a transferencia senão informa que não existe pessoa
                    try {
                        account.transfer(sc.nextDouble(), destination);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    if (account instanceof CheckingAccount) {
                        System.out.println("Solicite um valor maior de cheque especial");
                        System.out.printf("Seu valor atual é %.2f%n",
                                ((CheckingAccount) account).getOverdraft());
                        System.out.print("Novo valor: ");
                        double newOverdraft = sc.nextDouble();
                        System.out.println("Simulação gerente aprovando e digitando a senha ...");
                        System.out.print("Digite a senha gerente: ");
                        String password = sc.next();
                        try {
                            ((CheckingAccount) account).setOverdraft(newOverdraft, password);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Função indisponível para conta poupança");
                    }
                    break;
                case 7:
                    System.out.println("Tem certeza que deseja encerrar a conta [s/n]?");
                    char response = sc.next().toLowerCase().charAt(0);
                    if (response == 's') {
                        int res = bank.deleteAccount(accountId);
                        if (res == 1) {
                            System.out.println("Você deve sacar todo dinheiro antes de encerrar a conta");
                        } else if (res == -1) {
                            System.out.println("Verifique débitos pendentes com a instituição.");
                        } else {
                            System.out.println("Conta encerrada com sucesso.");
                            isRunning = false;
                        }
                    } else if (response == 'n') {
                        System.out.println("Obrigado por manter sua conta!");
                    } else {
                        System.out.println("Resposta inválida");
                    }
                    break;
                default:
                    isRunning = false;
                    break;
            }
        } while (isRunning);
    }
}
