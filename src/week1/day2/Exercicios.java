package week1.day2;

import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args) {
        exercicio6();
    }

    public static void exercicio1() {
        // 1. Escreva um algoritmo que leia um número inteiro e diga se ele é par ou ímpar.

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você precisa digitar um número do tipo inteiro");
            sc.close();
            System.exit(1);
        }
        int value = sc.nextInt();
        if (value % 2 == 1) {
            System.out.println("O número digitado é ímpar");
        } else {
            System.out.println("O número digitado é par");
        }
        sc.close();
    }

    public static void exercicio2() {
        // 2. Elabore um algoritmo que dada a idade de um nadador classifique-o em uma das seguintes categorias:
        //Infantil A = 5 a 7 anos
        //Infantil B = 8 a 11 anos
        //Juvenil A = 12 a 13 anos
        //Juvenil B = 14 a 17 anos
        //Adultos = Maiores de 18 anos

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a idade do nadador: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você precisa digitar um número inteiro");
            sc.close();
            System.exit(1);
        }
        int age = sc.nextInt();

        if (age < 5) {
            System.out.println("Só é possível cadastrar nadadores com mais de 5 anos!");
        } else if (age < 8) {
            System.out.println("Infantil A");
        } else if (age < 12) {
            System.out.println("Infantil B");
        } else if (age < 14) {
            System.out.println("Juvenil A");
        } else if (age < 18) {
            System.out.println("Juvenil B");
        } else {
            System.out.println("Adulto");
        }
        sc.close();
    }

    public static void exercicio3() {
        // 3. Escreva um algoritmo em Java que leia dois números inteiros e determine qual
        // é o menor. Escreva um algoritmo que determina o maior também.

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você precisa digitar um número inteiro");
            sc.close();
            System.exit(1);
        }
        int value1 = sc.nextInt();
        System.out.print("Digite o segundo número: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você precisa digitar um número inteiro");
            sc.close();
            System.exit(1);
        }
        int value2 = sc.nextInt();
        if (value2 < value1) {
            System.out.println("O menor número é o " + value2);
            System.out.println("O maior número é o " + value1);
        } else if (value2 > value1) {
            System.out.println("O menor número é o  " + value1);
            System.out.println("O maior número é o " + value2);
        } else {
            System.out.println("Os números são iguais");
        }
        sc.close();
    }

    public static void exercicio4() {
        // 4. Construa um algoritmo que leia 10 valores inteiros e positivos e:
        //Encontre o maior valor
        //Encontre o menor valor
        //Calcule a média dos números lidos

        Scanner sc = new Scanner(System.in);
        int current, greatest = 0, smallest = 0, length = 10;
        double acum = 0.0;

        for (int i = 0; i < length; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            if (!sc.hasNextInt()) {
                System.out.println("Erro, só é possível digitar números inteiros!");
                sc.close();
                System.exit(1);
            }
            current = sc.nextInt();
            if (i == 0) {
                greatest = current;
                smallest = current;
                acum += current;
                continue;
            }
            if (current > greatest) {
                greatest = current;
                acum += current;
            }
            if (current < smallest) {
                smallest = current;
                acum += current;
            }
        }

        System.out.println("O maior número é " + greatest);
        System.out.println("O menor número é " + smallest);
        System.out.println("A média é " + acum / length);
        sc.close();
    }

    public static void exercicio5() {
        // 5. Escreva um algoritmo em Java que seja capaz de fazer as seguintes operações
        // matemáticas (adição, subtração, multiplicação e divisão). Todas as operações serão
        // entre dois valores. No começo do algoritmo pergunte ao usuário qual operação ele deseja
        // fazer e quais são os valores.

        Scanner sc = new Scanner(System.in);
        System.out.println("*********** Calculadora ***********");
        System.out.println("+ para soma");
        System.out.println("- para subtração");
        System.out.println("* para multiplicação");
        System.out.println("/ para divisão");
        System.out.print("Digite a operação desejada: ");
        if (!sc.hasNext("^(?:/|\\*|-|\\+)$")) {
            System.out.println("Operação inválida");
            sc.close();
            System.exit(1);
        }
        char operation = sc.next().charAt(0);
        System.out.print("Digite o primeiro número: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Operação inválida");
            sc.close();
            System.exit(1);
        }
        double value1 = sc.nextDouble();
        System.out.print("Digite o segundo número: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Operação inválida");
            sc.close();
            System.exit(1);
        }
        double value2 = sc.nextDouble();

        switch (operation) {
            case '+':
                System.out.printf("A soma dos números é: %.2f", value1 + value2);
                break;
            case '-':
                System.out.printf("A subtração dos números é: %.2f", value1 - value2);
                break;
            case '*':
                System.out.printf("A multiplicação dos números é: %.2f", value1 * value2);
                break;
            case '/':
                if (value2 == 0) {
                    System.out.println("Não é possível dividir por zero");
                    break;
                }
                System.out.printf("A divisão dos números é: %.2f", value1 / value2);
                break;
            default:
                System.out.println("Operação inválida");
        }
        sc.close();
    }

    public static void exercicio6() {
        // 6. Faça a implementação do Jogo Pedra, Papel e Tesoura (Jokempô). O algoritmo deverá perguntar
        // qual é a escolha do jogador 1 (Pedra [pe], Papel [pa], Tesoura [t]) e deverá fazer o mesmo para
        // o jogador 2. No final da execução o algoritmo deverá dizer qual é o jogador vencedor ou se houve
        // empate.

        System.out.println("******Jokempô**********");

        Scanner sc = new Scanner(System.in);

        // Turno jogador 1
        System.out.println("Turno do jogador 1");
        System.out.print("Pedra [pe], Papel [pa] ou tesoura [t]? ");
        if (!sc.hasNext("pa|pe|t")) {
            System.out.println("Jogada inexistente");
            sc.close();
            System.exit(1);
        }
        String movePlayer1 = sc.next();

        // Turno jogador 2
        System.out.println("Turno do jogador 2");
        System.out.print("Pedra [pe], Papel [pa] ou tesoura [t]? ");
        if (!sc.hasNext("pa|pe|t")) {
            System.out.println("Jogada inexistente");
            sc.close();
            System.exit(1);
        }
        String movePlayer2 = sc.next();

        if (movePlayer1.equals("pa") && movePlayer2.equals("pe")
                || movePlayer1.equals("pe") && movePlayer2.equals("t")
                || movePlayer1.equals("t") && movePlayer2.equals("pa")) {
            System.out.println("Vitória do jogador 1");
        } else if (movePlayer1.equals("pa") && movePlayer2.equals("t")
                || movePlayer1.equals("pe") && movePlayer2.equals("pa")
                || movePlayer1.equals("t") && movePlayer2.equals("pe")) {
            System.out.println("Vitória do jogador 2");
        } else {
            System.out.println("Empate");
        }
        sc.close();
    }
}
