package entitys;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioComPonto extends Funcionario{

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

}
