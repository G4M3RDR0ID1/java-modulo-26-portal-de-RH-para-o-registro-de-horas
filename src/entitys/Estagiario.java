package entitys;

import java.time.LocalDate;
import java.time.LocalTime;

public class Estagiario extends Funcionario{
    public Estagiario(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void exibirRegistros() {
        System.out.println("Este cargo não possui controle de ponto.");
    }

    @Override
    public void registrarPonto(LocalDate data, LocalTime entrada, LocalTime saida) {
        System.out.println("Este cargo não possui controle de ponto.");
    }
}
