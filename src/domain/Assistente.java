package domain;

public class Assistente extends FuncionarioComPonto implements Registravel{
    public Assistente(int id, String nome) {
        super(id, nome);
    }

    @Override
    protected boolean horasExtrasExcedidas(long horas) {
        return horas > 3;
    }
}
