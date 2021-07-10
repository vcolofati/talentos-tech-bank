package week2.day12.composicao;

import java.util.Scanner;

public class Exercicios {
    public static void exercicio1() {
        /* 1.) Crie uma classe Televisão e uma classe ControleRemoto que pode controlar o volume e
        trocar os canais da televisão. O controle de volume permite:
         * aumentar ou diminuir a potência do volume de som em uma unidade de cada vez;
         * aumentar e diminuir o número do canal em uma unidade
         * trocar para um canal indicado;
         * consultar o valor do volume de som e o canal selecionado.
         * Uma Televisão tem um ControleRemoto */

        TV tv = new TV();
        RemoteControl remoteControl = new RemoteControl(tv);

        boolean tvIsOn = true;
        Scanner sc = new Scanner(System.in);
        while (tvIsOn) {
            System.out.println("========= Minha TV =========");
            System.out.println("Para desligar a tv, pressione 0");
            System.out.println("Para aumentar o volume, pressione 1");
            System.out.println("Para diminuir o volume, pressione 2");
            System.out.println("Para incrementar o canal, pressione 3");
            System.out.println("Para decrementar o canal, pressione 4");
            System.out.println("Para escolher o canal, pressione 5");
            System.out.println("Para exibir informação de canal e volume atual, pressione 6");
            System.out.print("Opção: ");
            int option = sc.nextInt();
            switch (option) {
                case 0:
                    tvIsOn = false;
                    break;
                case 1:
                    remoteControl.incrementVolume();
                    break;
                case 2:
                    remoteControl.decrementVolume();
                    break;
                case 3:
                    remoteControl.incrementChannel();
                    break;
                case 4:
                    remoteControl.decrementChannel();
                    break;
                case 5:
                    System.out.print("Digite o canal desejado: ");
                    int canal = sc.nextInt();
                    remoteControl.setChannel(canal);
                    break;
                case 6:
                    remoteControl.showVolumeAndChannel();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        exercicio1();
    }
}
