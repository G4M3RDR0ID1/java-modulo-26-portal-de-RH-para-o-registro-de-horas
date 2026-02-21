package entitys;

public class Estagiario extends Funcionario{
    public Estagiario(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void exibirRegistros() {
        System.out.println("Este cargo não possui controle de ponto.");
    }
}
