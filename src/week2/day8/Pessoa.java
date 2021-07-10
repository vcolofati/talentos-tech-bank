package week2.day8;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;
    private Float altura;

    public Pessoa(String nome, LocalDate dataNascimento, Float altura) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setAltura(altura);
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

    public Integer getIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    @Override
    public final String toString() {
        return "Pessoa{" + "nome='" + this.getNome() + '\'' +
                ", dataNascimento=" + this.getDataNascimento() +
                ", altura=" + this.getAltura() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getNome(), pessoa.getNome()) && Objects.equals(getDataNascimento(), pessoa.getDataNascimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDataNascimento());
    }
}
