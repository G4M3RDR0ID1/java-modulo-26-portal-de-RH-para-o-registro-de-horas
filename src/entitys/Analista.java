package entitys;

public class Analista extends FuncionarioComPonto{
    public Analista(int id, String nome) {
        super(id, nome);
    }

    @Override
    protected boolean horasExtrasExcedidas(long horas) {
        return horas > 3;
    }
}
