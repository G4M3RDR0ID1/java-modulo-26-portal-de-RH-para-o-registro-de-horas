package entitys;

public class Assistente extends FuncionarioComPonto{
    public Assistente(int id, String nome) {
        super(id, nome);
    }

    @Override
    protected boolean horasExtrasExcedidas(long horas) {
        return horas > 3;
    }
}
