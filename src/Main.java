import entitys.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Funcionario> funcionarios = new HashMap<>();

        System.out.println("Bem vindo ao Portal de RH\n");

        int opcaoMenu = 0;

        while (opcaoMenu != 6) {

            System.out.println("Opçoes do menu:\n" +
                    "1: Registrar funcionario.\n" +
                    "2: Registrar horarios.\n" +
                    "3: Exibir registro de horas do funcionario.\n" +
                    "4: Deletar funcionario do sistema\n" +
                    "5: Exibir IDs dos funcionarios cadastrados.\n" +
                    "6: Sair."
            );
            opcaoMenu = sc.nextInt();

            switch (opcaoMenu) {
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o nome do Funcionario:");
                    String nome = sc.nextLine();
                    System.out.println("Selecione qual o cargo dele!\nOpçoes do menu:\n" +
                            "1: Analista.\n" +
                            "2: Assistente.\n" +
                            "3: Cordenador.\n" +
                            "4: Estagiario\n" +
                            "5: Gerente."
                    );
                    int opcaoCargo = sc.nextInt();

                    while (opcaoCargo > 5 || opcaoCargo < 1) {
                        System.out.println("Numero digitado não corresponde as opçoes do menu, digite novamente!");
                        opcaoCargo = sc.nextInt();
                    }

                    registarFuncionario(funcionarios, nome, opcaoCargo);
                    break;

                case 2:
                    sc.nextLine();

                    System.out.println("Digite o ID do funcionario:");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Funcionario funcionario = buscarFuncionario(funcionarios, id);
                    if (funcionario == null) break;

                    System.out.println("Digite o data do registro  (dd/MM/yyyy):");
                    String dataStr = sc.nextLine();

                    System.out.println("Digite o Hoario de Entrada (formato HH:mm):");
                    String entradaStr = sc.nextLine();

                    System.out.println("Digite o Hoario de Saida (formato HH:mm):");
                    String saidaStr = sc.nextLine();

                    registrarHorario(funcionario, dataStr, entradaStr, saidaStr);
                    break;

                case 3:
                    System.out.println("Digite o numero do ID do funcionario que deseja exibir os horarios de ponto");
                    id = sc.nextInt();

                    exibirRegistroHoras(id, funcionarios);
                    break;

                case 4:
                    System.out.println("Digite o numero do ID do funcionario que deseja deletar do banco de dados: ");
                    int idParaDeletar = sc.nextInt();

                    deletarFuncionario(idParaDeletar, funcionarios);
                    break;

                case 5:
                    exibirFuncionarios(funcionarios);
                    break;

                case 6:
                    System.out.println("Encerrando o Sistema!");
                    break;

                default:
                    System.out.println("Opção invalida.");
            }
        }
    }

    public static void registarFuncionario(Map<Integer, Funcionario> funcionarios, String nome, int opcaoCargo) {

        int id = GeradorId.gerarId();
        Funcionario funcionario = null;

        switch (opcaoCargo) {
            case 1:
                funcionario = new Analista(id, nome);
                break;
            case 2:
                funcionario = new Assistente(id, nome);
                break;
            case 3:
                funcionario = new Coordenador(id, nome);
                break;
            case 4:
                funcionario = new Estagiario(id, nome);
                break;
            case 5:
                funcionario = new Gerente(id, nome);
                break;
        }

        funcionarios.put(id, funcionario);
        System.out.println(funcionario);

    }

    public static void registrarHorario(Funcionario funcionario, String dataStr, String entradaStr, String saidaStr) {
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalDate data = LocalDate.parse(dataStr, formatterData);
            LocalTime entrada = LocalTime.parse(entradaStr, formatterHora);
            LocalTime saida = LocalTime.parse(saidaStr, formatterHora);

            funcionario.registrarPonto(data, entrada, saida);

        } catch (Exception e){
            System.out.println("Formato de data ou hora invalido.");
        }

    }

    public static void exibirRegistroHoras(int id, Map<Integer, Funcionario> funcionarios) {

        Funcionario funcionario = buscarFuncionario(funcionarios, id);

        if (funcionario == null) return;

        funcionario.exibirRegistros();
    }

    public static void deletarFuncionario(int idParaDeletar, Map<Integer, Funcionario> funcionarios) {

        Funcionario funcionario = buscarFuncionario(funcionarios, idParaDeletar);

        if (funcionario == null) return;

        funcionarios.remove(idParaDeletar);

        System.out.println("Funcionário removido com sucesso.");
    }

    public static Funcionario buscarFuncionario(Map<Integer, Funcionario> funcionarios, int id) {

        Funcionario funcionario = funcionarios.get(id);

        if (funcionario == null) {
            System.out.println("Funcionario não encontrado.");
            return null;
        }

        return funcionario;
    }

    public static void exibirFuncionarios(Map<Integer, Funcionario> funcionarios){

        if (funcionarios.isEmpty()){
            System.out.println("Nenhum funcionario cadastrado!");
            return;
        }

        System.out.println("Funcionarios cadastrados:");

        for (Funcionario f : funcionarios.values()){
            System.out.println(f);
        }
    }
}