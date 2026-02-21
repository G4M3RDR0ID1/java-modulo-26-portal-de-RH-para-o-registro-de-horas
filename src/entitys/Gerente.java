package entitys;

public class Gerente extends Funcionario{
    public Gerente(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void exibirRegistros() {
        System.out.println("Este cargo não possui controle de ponto.");
    }
}
