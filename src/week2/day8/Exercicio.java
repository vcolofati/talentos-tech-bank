package week2.day8;

import java.time.LocalDate;

public class Exercicio {

    private static void exercicio1() {
        /* 1.) Crie uma classe para representar uma pessoa, com os atributos de nome, ano de nascimento e altura.
        Crie e também um método para imprimir todos dados de uma pessoa. Crie um método para mostrar quantos anos
        a pessoa fará/terá neste ano. */

        Pessoa pessoa = new Pessoa("João", LocalDate.parse("1993-09-28"), 1.75f);
        System.out.println(pessoa);
        System.out.println("Idade: " + pessoa.getIdade());
    }

    public static void exercicio2() {
        /* 2.) Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz de realizar as seguintes operações:
        void armazenaPessoa(String nome, int idade, float altura);
        void removePessoa(String nome);
        int buscaPessoa(String nome); // informa em que posição da agenda está a pessoa
        void imprimeAgenda(); // imprime os dados de todas as pessoas da agenda
        void imprimePessoa(int index); // imprime os dados da pessoa que está na posição “i” da agenda.*/

        Agenda myAgenda = new Agenda();
        // Add pessoas
        myAgenda.armazenaPessoa("Mario Ramos", LocalDate.parse("1990-08-07"), 1.8f);
        myAgenda.armazenaPessoa("Paulo Roberto", LocalDate.parse("1984-06-08"), 1.79f);
        myAgenda.armazenaPessoa("Maria de Fátima", LocalDate.parse("1981-03-25"), 1.58f);
        myAgenda.armazenaPessoa("Roberto Justo", LocalDate.parse("1979-05-17"), 1.71f);
        // imprime agenda com pessoas acima
        myAgenda.imprimeAgenda();
        System.out.println();
        // imprime pessoa com índice 0
        myAgenda.imprimePessoa(0);
        System.out.println();
        //imprime pessoa om índice 2
        myAgenda.imprimePessoa(2);
        System.out.println();
        //remove pessoa 'Roberto Justo'
        myAgenda.removePessoa("Roberto Justo");
        // imprime agenda novamente para verificar se pessoa foi excluída
        myAgenda.imprimeAgenda();
        System.out.println();
        // retorna índice do Paulo Roberto
        System.out.println(myAgenda.buscaPessoa("Paulo Roberto"));

    }

    public static void main(String[] args) {
        exercicio2();


    }
}
