package service;

import model.Consulta;

import java.util.LinkedHashSet;

public class ConsultaService {
    private static ConsultaService ourInstance = new ConsultaService();

    public static ConsultaService getInstance() {
        return ourInstance;
    }

    private ConsultaService() {
    }
    private LinkedHashSet<Consulta> Consultas = new LinkedHashSet<>();


    public boolean salvarConsulta(Consulta consulta) {
        return this.Consultas.add(consulta);
    }

    public void listarConsulta() {
        this.Consultas.stream().forEach(System.out::println);
    }
}
