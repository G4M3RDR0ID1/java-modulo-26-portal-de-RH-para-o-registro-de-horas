package domain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class FuncionarioComPonto extends Funcionario implements Registravel{

    private List<RegistroDeHoras> registros;

    public FuncionarioComPonto(int id, String nome) {
        super(id, nome);
        registros = new ArrayList<>();
    }

    @Override
    public void exibirRegistros() {

        if (registros.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
            return;
        }

        System.out.println("Registros de ponto de " + getNome() + ":");

        for (RegistroDeHoras r : registros) {
            System.out.println(r);
        }
    }

    @Override
    public void registrarPonto(LocalDate data, LocalTime entrada, LocalTime saida) {

        if (jaExisteRegistroNaData(data)) {
            System.out.println("Já existe um registro para esta data.");
            return;
        }

        if (entrada.isBefore(LocalTime.of(6, 0))){
            System.out.println("Entrada não pode ser antes das 06:00.");
            return;
        }

        if (saida.isAfter(LocalTime.of(22,0))){
            System.out.println("Saída não pode ser após 22:00.");
            return;
        }

        if (!saida.isAfter(entrada)){
            System.out.println("Saída deve ser após a entrada.");
            return;
        }

        long minutosTrabalhados = java.time.Duration.between(entrada, saida).toMinutes() - 60;

        if (minutosTrabalhados <= 0) {
            System.out.println("Jornada inválida.");
            return;
        }

        long horas = minutosTrabalhados / 60;
        long horasExtras = Math.max(0, horas - 8);

        if (horasExtrasExcedidas(horasExtras)){
            System.out.println("Limite de horas extras excedido.");
            return;
        }

        registros.add(new RegistroDeHoras(data, entrada, saida, horas));
        System.out.println("Registro realizado com sucesso.");
    }

    private boolean jaExisteRegistroNaData(LocalDate data) {
        for (RegistroDeHoras r : registros) {
            if (r.getData().equals(data)) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean horasExtrasExcedidas(long horasTrabalhadas);

}
