package week3.project1.models;

import java.util.Objects;

public class Client {

    private String name;
    private String cpf;
    private String occupation;

    public Client(String name, String cpf, String occupation) {
        this.name = name;
        this.cpf = cpf;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getCpf().equals(client.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }
}

