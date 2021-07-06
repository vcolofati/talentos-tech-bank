package week2.day6;

import java.util.*;

public class Exercicios {
    public static void exercicio1() {
        // 1.) Escreva um algoritmo que leia números insira em um array e após mostre os
        // números informados na tela.
        //Ler somente 5 números.

        // Com array
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            array[i] = sc.nextInt();
        }
        System.out.printf("%nArray: %s \uD83D\uDE80", Arrays.toString(array));

        // Com ArrayList
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.printf("%n%nDigite o %dº número: ", i + 1);
            list.add(sc.nextInt());
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", list);
        sc.close();
    }

    public static void exercicio2() {
        // 2. ) Escreva um algoritmo que leia números, insira em um array e
        // após mostre a quantidade de números negativos.

        // Com array
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            array[i] = sc.nextInt();
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", Arrays.toString(array));

        int counter = 0;
        for (int value : array) {
            if (value < 0) {
                counter++;
            }
        }
        System.out.printf("%nQuantidade de números negativos: %d%n", counter);

        // Com ArrayList
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            list.add(sc.nextInt());
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", list);
        System.out.printf("%nQuantidade de números negativos: %d%n", list.stream().filter(el -> el < 0).count());
        sc.close();
    }

    public static void exercicio3() {
        // 3.) Escreva um algoritmo que leia números, insira em um array e após mostre
        // a quantidade de números pares.

        // Com array
        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            array[i] = sc.nextInt();
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", Arrays.toString(array));

        int counterEven = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                counterEven++;
            }
        }
        System.out.printf("%nQuantidade de números pares: %d%n", counterEven);

        // Com ArrayList
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            list.add(sc.nextInt());
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", list);
        System.out.printf("%nQuantidade de números pares: %d%n", list.stream().filter(el -> el % 2 == 0).count());
        sc.close();
    }

    public static void exercicio4() {
        // 4.) Escreva um algoritmo que leia números, insira em um array e após mostre o maior valor.

        Scanner sc = new Scanner(System.in);
        int[] array = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            array[i] = sc.nextInt();
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", Arrays.toString(array));

        int greatestValue = 0;
        for (int value : array) {
            if (value > greatestValue) {
                greatestValue = value;
            }
        }
        System.out.printf("%nO maior número é: %d%n", greatestValue);

        // Com ArrayList
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            list.add(sc.nextInt());
        }
        System.out.printf("%nLista: %s \uD83D\uDE80", list);
        System.out.printf("%nO maior número é: %d%n", list.stream().reduce(0, Integer::max));
        sc.close();
    }

    public static void exercicio5() {
        // 5.) Escreva um algoritmo que simula um jogo da forca simples. o usuario precisara
        // adivinhar uma palavra chutando cada letra em no máximo 10 chutes, caso o usuario
        // acerte a letra o jogo dirá que ele acertou, caso tenha errado, o numero de tentativas
        // vai diminuindo. Caso o numero de tentativas chegue a 0 o usuário perde.

        Scanner sc = new Scanner(System.in);
        int attempts = 10;


        System.out.println("============ Meu jogo da forca ============");

        System.out.print("Digite uma palavra para começar: ");
        String secretWord = sc.next();
        int length = secretWord.length(); //Para testar se a palavra foi descoberta.
        char[] temp = new char[length];
        List<String> alreadyUsedLetters = new ArrayList<>();
        Arrays.fill(temp, '_');
        System.out.print(temp);
        while (attempts > 0) {
            System.out.printf("%nTentativas restantes: %d%n", attempts);
            System.out.print("Digite uma letra: ");
            String guess = sc.next();

            if (guess.length() != 1) {
                System.out.println("Digite apenas um caractere");
                continue; // vai para a proxima iteração, forçando a pessoa digitar novamente
            }
            if(alreadyUsedLetters.contains(guess)) {
                System.out.println("Letra já foi usada ! Digite outra letra!");
                continue;
            }

            char guessChar = guess.charAt(0);

            int foundPos = -2; // indexOf volta -1 quando não encontra então para forçar sair do loop usei esse -2
            int foundLetterCount = 0;
            while ((foundPos = secretWord.indexOf(guessChar, foundPos + 1)) != -1) {
                temp[foundPos] = guessChar; //Troca o "_" pela letra correspondente
                foundLetterCount++;
                length--;
            }
            alreadyUsedLetters.add(guess);

            if (foundLetterCount == 0) {
                System.out.printf("Nenhuma letra %s nessa palavra%n", guess);
                attempts--;
            } else {
                System.out.printf("Acertou essa palavra possui %d letras \"%s\"%n", foundLetterCount, guess);
            }

            System.out.printf("Letras já usadas: %s%n", alreadyUsedLetters);


            for (char c : temp) {
                System.out.print(c);
            }
            System.out.println();

            if (length == 0) {
                break; //Sai quando a pessoa acerta a palavra!
            }
        }


        System.out.println();
        System.out.println(length == 0
                ? "Parabéns, você ganhou!"
                : "Sinto muito, você perdeu !!");

        System.out.printf("A palavra era \"%s\"%n", secretWord);

        sc.close();
    }

    public static void main(String[] args) {
        exercicio5();
    }


}
