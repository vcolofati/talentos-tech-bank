package day1;

import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args) {
        exercicio4();
    }

    public static void exercicio1() {
        // 1. Escreva um algoritmo que armazene o valor 99 em uma variável Y e o valor 11 em uma variável Z.
        // A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteúdos fazendo com
        // que o valor que está em Y passe para Z e vice-versa. Ao final, escrever os valores que ficaram
        // armazenados nas variáveis.

        short y = 99;
        short z = 11;
        System.out.printf("y: %d, z: %d%n", y, z);
        short temp = y;
        y = z;
        z = temp;
        System.out.printf("y: %d, z: %d", y, z);
    }

    public static void exercicio2() {
        // 2. Escreva um algoritmo para ler um valor (do teclado) e escrever (na tela) o seu antecessor.
        // TODO tratar erros de input.
        System.out.printf("Digite um número: ");
        Scanner sc = new Scanner(System.in);
        System.out.printf("O antecessor é: %d%n", sc.nextInt() - 1);
        sc.close();
    }

    public static void exercicio3() {
        // 3. Escreva um algoritmo para ler as dimensões de um retângulo (base e altura),
        // calcular e escrever a área do retângulo.

        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite a altura do retângulo (m): ");
        double width = sc.nextDouble();
        System.out.printf("Digite a largura do retângulo (m): ");
        double length = sc.nextDouble();
        double area = width * length;
        System.out.println("Area do retângulo: " + area + " m²");
        sc.close();
    }

    public static void exercicio4() {
        // 4. Escreva um algoritmo para ler o número total de eleitores de um município,
        // o número de votos brancos, nulos e válidos. Calcular e escrever o percentual
        // que cada um representa em relação ao total de eleitores.

        Scanner sc = new Scanner(System.in);

        System.out.printf("Número de votos brancos: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você não digitou um valor válido, encerrando o programa...");
            System.exit(1);
        }
        double blankVotes = sc.nextInt();
        System.out.printf("Número de votos nulos: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você não digitou um valor válido, encerrando o programa...");
            System.exit(1);
        }
        double spoiltVotes = sc.nextInt();
        System.out.printf("Número de votos válidos: ");
        if (!sc.hasNextInt()) {
            System.out.println("Você não digitou um valor válido, encerrando o programa...");
            System.exit(1);
        }
        double validVotes = sc.nextInt();

        double totalVoters = blankVotes + spoiltVotes + validVotes;
        System.out.printf("Número total de eleitores no município: %.0f%n", totalVoters);

        System.out.printf("Votos brancos: %.2f%%%n", blankVotes / totalVoters * 100.0);
        System.out.printf("Votos nulos: %.2f%%%n", spoiltVotes / totalVoters * 100.0);
        System.out.printf("Votos brancos: %.2f%%", validVotes / totalVoters * 100.0);


    }
}
