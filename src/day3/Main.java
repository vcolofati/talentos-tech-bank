package day3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        exercicio2();
    }

    public static void exercicio1() {
        // 1. Construa um algoritmo que leia 10 valores inteiros e positivos e:
        //Encontre o maior valor
        //Encontre o menor valor
        //Calcule a média dos números lidos Esse exercício foi dado na aula 3 e
        // agora vamos otimizar ele utilizando o while e for.

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

    public static void exercicio2() {
        // 2. Construa um algoritmo usando uma estrutura de repetição que calcule o fatorial de um número.
        Scanner sc = new Scanner(System.in);
        System.out.println("**********Fatorial***********");
        System.out.print("Digite o número para calcular seu fatorial: ");
        if (!sc.hasNextLong()) {
            System.out.println("Digite um número!!");
            sc.close();
            System.exit(1);
        }
        long number = sc.nextLong();
        sc.close();
        System.out.println(recursiveFatorial(number) == -1
                ? "Não existe fatorial de número negativo"
                : String.format("Fatorial: %d",recursiveFatorial(number)));

    }

    public static long recursiveFatorial(long n) {
        if(n < 0L) {
            return -1L;
        }
        if(n == 0L) {
            return 1L;
        }
        if(n == 1L) {
            return n;
        }
        return n * recursiveFatorial(n - 1);
    }
}
