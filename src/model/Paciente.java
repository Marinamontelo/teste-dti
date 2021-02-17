package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.format.DateTimeFormatter;  

public class Paciente {

    String nome;
    String endereco;
    String email;
    List<String> telefones = new ArrayList<>();
    LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefone(List<String> telefones) {
        this.telefones = telefones;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(nome, paciente.nome) &&
                Objects.equals(endereco, paciente.endereco) &&
                Objects.equals(email, paciente.email) &&
                Objects.equals(telefones, paciente.telefones) &&
                Objects.equals(dataNascimento, paciente.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, endereco, email, telefones, dataNascimento);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", email='" + email + '\'' +
                ", telefones=" + telefones +
                ", dataNascimento=" + dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                '}' + '\n' + '\n';
    }
}
