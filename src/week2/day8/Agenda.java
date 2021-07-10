package week2.day8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Pessoa> contatos = new ArrayList<>();

    void armazenaPessoa(String nome, LocalDate dataNascimento, float altura) {
        contatos.add(new Pessoa(nome, dataNascimento, altura));
    }

    void removePessoa(String nome) {
        contatos.remove(buscaPessoa(nome));
    }

    int buscaPessoa(String nome) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equals(nome)) {
                return i;
            }
        }
        return -1;
    }

    void imprimeAgenda() {
        contatos.forEach(System.out::println);
    }

    void imprimePessoa(int index) {
        System.out.println(contatos.get(index));
    }
}
