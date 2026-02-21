package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Gerente extends Funcionario{
    public Gerente(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void exibirRegistros() {
        System.out.println("Este cargo não possui controle de ponto.");
    }

}
