package day4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        exercicio2();
    }

    public static void exercicio1() {
        // // 1 . Dois números são inseridos pelo teclado. Escreva um programa para encontrar o valor de um número elevado à
        //    // potência de outro. (Não use o método Math.pow integrado Java)

        char finish;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("*********Potência***********");
            System.out.print("Digite a base: ");
            if (!sc.hasNextInt()) {
                System.out.println("Digite um número inteiro!");
                sc.close();
                System.exit(1);
            }
            int base = sc.nextInt();
            System.out.print("Digite o expoente: ");
            if (!sc.hasNextInt()) {
                System.out.println("Digite um número inteiro!");
                sc.close();
                System.exit(1);
            }
            int exponent = sc.nextInt();

            long result = 1;

            for (int i = exponent; i != 0; i--) {
                result *= base;
            }

            System.out.printf("O resultado da potência é: %d%n", result);
            System.out.print("Deseja sair [S/n]: ");
            finish = sc.next().charAt(0);
            sc.close();
        } while (finish != 'S');
    }

    public static void exercicio2() {
        System.out.println("i)");
        int length = 5;
        for(int i = 0; i< length; i++) {
            for(int j = 0; j < length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("ii)");
        length = 5;
        for(int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("iii)");
        length = 5;
        for(int i = 1; i <= length; i++) {
            for (int k = 4 - i; k >= 0; k--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("iv)");
        length = 5;
        for(int i = 1; i <= length; i++) {
            for (int k = 4 - i; k >= 0; k--) {
                System.out.print("  ");
            }
            for (int j = 0; j != 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("v)");
        length = 5;
        for(int i = 1; i <= length; i++) {
            for (int k = 4 - i; k >= 0; k--) {
                System.out.print("  ");
            }
            for (int j = 0; j != 2 * i - 1; j++) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }

        System.out.println("vi)");
        length = 5;
        for(int i = 1; i <= length; i++) {
            for (int j = 1; j <=(length - i) * 2; j++) {
                System.out.print(" ");
            }
            for (int k = i; k >= 1; k--) {
                System.out.printf(" %d", k);
            }
            for (int k = 2; k <= i; k++) {
                System.out.printf(" %d", k);
            }
            System.out.println();
        }
    }

}
