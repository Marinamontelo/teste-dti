import model.Alimento;
import model.Consulta;
import model.Paciente;
import service.AlimentoService;
import service.ConsultaService;
import service.PacienteService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continuar = true;
        Scanner sc = new Scanner(System.in);
        while (continuar) {

			System.out.println("1 - Cadastrar Paciente \n ");
			System.out.println("2 - Listar Pacientes \n ");
			System.out.println("3 - Cadastrar Alimento\n ");
			System.out.println("4 - Listar Alimentos \n ");
			System.out.println("5 - Realizar Consulta \n ");
			System.out.println("6 - Listar Consultas\n ");

            try {

                int operacao = sc.nextInt();
                switch (operacao) {
                    case 1:
                        cadastrarPaciente();
                        break;
                    case 2:
                       PacienteService.getInstance().listarPaciente();
                       break;
                    case 3:
                        cadastrarAlimento();
                        break;
                    case 4:                    
						AlimentoService.getInstance().listarAlimentos();
                        break;						
                    case 5:
						realizarConsulta();
                        break;                        
                    case 6:
                        ConsultaService.getInstance().listarConsulta();
                        break;
                    case 0:
                        System.out.println("Encerrando ...");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Operação inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Operação inválida");
                sc.next();
            }
        }
    }

    public static void realizarConsulta() {
        try {
            Consulta consulta = new Consulta();
            consulta.setData(LocalDateTime.now());
            PacienteService.getInstance().listarPaciente();
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o email do paciente que irá consultar");
            String email = sc.next();
            Paciente paciente = PacienteService.getInstance().selecionarPorEmail(email);
            consulta.setPaciente(paciente);
            System.out.println("Digite o peso do paciente (0,0)");
            consulta.setPeso(sc.nextDouble());

            System.out.println("Digite a porcentagem de gordura (0,0)");
            consulta.setPorcentagemGordura(sc.nextDouble());

            System.out.println("Digite a queixa");
            consulta.setSensacaoFisica(sc.next());
            System.out.println("Digite as restrições alimentares");
            consulta.setRestricoesAlimentares(sc.next());
            System.out.println("Digite uma meta para o consumo colórico ou 0  para não informar");
            consulta.setMetaConsumo(sc.nextInt());

            ConsultaService.getInstance().salvarConsulta(consulta);

            System.out.println("Consulta Realizada");
            if (consulta.getMetaConsumo() > 0) {
                AlimentoService.getInstance().listarCombinacoesPorMeta(consulta.getMetaConsumo());
            }
        } catch (Exception e) {
            System.out.println("Erro ao Realizar Consulta");
        }

    }

    public static void cadastrarAlimento() {
        try {

            Scanner sc = new Scanner(System.in);
            Alimento alimento = new Alimento();
            System.out.println("Digite o nome do Alimento");
            alimento.setNome(sc.next());
            System.out.println("Digite a quantidade de calorias (0-9)");
            alimento.setCalorias(sc.nextInt());
            System.out.println("Digite o número do Grupo do Alimento (0-9)");
            alimento.setGrupo(sc.nextInt());

            AlimentoService.getInstance().salvarAlimento(alimento);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Alimento");
        }

    }


    public static void cadastrarPaciente() {
        try {

            Scanner sc = new Scanner(System.in);
            Paciente paciente = new Paciente();
            System.out.println("Digite o nome do Paciente");
            paciente.setNome(sc.next());
            System.out.println("Digite o email do Paciente");
            paciente.setEmail(sc.next());
            System.out.println("Digite o endereço do Paciente");
            paciente.setEndereco(sc.next());
            System.out.println("Digite a data de nascimento do Paciente no formato 31/12/9999");
            String dataString = sc.next();
            paciente.setDataNascimento(LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            int operacao = 1;
            while (operacao == 1) {
                System.out.println("Digite o telefone do Paciente");
                paciente.getTelefones().add(sc.next());
                System.out.println("Adicionar outro telefone? \n 1 - SIM \n 2 - NÃO");
                operacao = sc.nextInt();

            }
            PacienteService.getInstance().salvarPaciente(paciente);

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar Paciente");
        }

    }


}
