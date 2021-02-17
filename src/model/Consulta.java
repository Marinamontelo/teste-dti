package model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.time.format.DateTimeFormatter; 

public class Consulta {

    private LocalDateTime data;
    Paciente paciente;
    Double peso;
    Double porcentagemGordura;
    String sensacaoFisica;
    String restricoesAlimentares;
    Integer metaConsumo;

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPorcentagemGordura() {
        return porcentagemGordura;
    }

    public void setPorcentagemGordura(Double porcentagemGordura) {
        this.porcentagemGordura = porcentagemGordura;
    }

    public String getSensacaoFisica() {
        return sensacaoFisica;
    }

    public void setSensacaoFisica(String sensacaoFisica) {
        this.sensacaoFisica = sensacaoFisica;
    }

    public String getRestricoesAlimentares() {
        return restricoesAlimentares;
    }

    public void setRestricoesAlimentares(String restricoesAlimentares) {
        this.restricoesAlimentares = restricoesAlimentares;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data=" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))  +
                ", paciente=" + paciente +
                ", peso=" + peso +
                ", porcentagemGordura=" + porcentagemGordura +
                ", sensacaoFisica='" + sensacaoFisica + '\'' +
                ", restricoesAlimentares='" + restricoesAlimentares + '\'' +
                '}'+ '\n' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(data, consulta.data) &&
                Objects.equals(paciente, consulta.paciente) &&
                Objects.equals(peso, consulta.peso) &&
                Objects.equals(porcentagemGordura, consulta.porcentagemGordura) &&
                Objects.equals(sensacaoFisica, consulta.sensacaoFisica) &&
                Objects.equals(restricoesAlimentares, consulta.restricoesAlimentares);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, paciente, peso, porcentagemGordura, sensacaoFisica, restricoesAlimentares);
    }


    public Integer getMetaConsumo() {
        return metaConsumo;
    }

    public void setMetaConsumo(Integer metaConsumo) {
        this.metaConsumo = metaConsumo;
    }
}
