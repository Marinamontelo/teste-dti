package service;

import model.Paciente;

import java.util.LinkedHashSet;

public class PacienteService {
    private static PacienteService ourInstance = new PacienteService();

    public static PacienteService getInstance() {
        return ourInstance;
    }

    private PacienteService() {
    }

    private LinkedHashSet<Paciente> pacientes = new LinkedHashSet<>();


    public boolean salvarPaciente(Paciente paciente) {
        return this.pacientes.add(paciente);
    }

    public void listarPaciente() {
        this.pacientes.stream().forEach(System.out::println);
    }

    public Paciente selecionarPorEmail(String email) throws Exception{
        return this.pacientes.stream().filter(paciente -> paciente.getEmail().equals(email)).findFirst().orElseThrow(Exception::new);
    }

}
