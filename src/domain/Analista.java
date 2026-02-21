package domain;

public class Analista extends FuncionarioComPonto implements Registravel {

    public Analista(int id, String nome) {
        super(id, nome);
    }

    @Override
    protected boolean horasExtrasExcedidas(long horasExtras) {
        return horasExtras > 3;
    }
}