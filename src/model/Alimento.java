package model;

import java.util.Objects;

public class Alimento {

    private String nome;
    private Integer calorias;
    private Integer grupo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "nome='" + nome + '\'' +
                ", calorias=" + calorias +
                ", grupo=" + grupo +
                '}'+ '\n' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alimento alimento = (Alimento) o;
        return Objects.equals(nome, alimento.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, calorias, grupo);
    }
}
