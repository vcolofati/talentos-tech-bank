package week2.day8;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Float altura;

    Pessoa() {
    }

    Pessoa(String nome, LocalDate dataNascimento, Float altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    Integer getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    @Override
    final public String toString() {
        return "Pessoa{" + "nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", altura=" + altura +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(dataNascimento, pessoa.dataNascimento) && Objects.equals(altura, pessoa.altura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento, altura);
    }
}
