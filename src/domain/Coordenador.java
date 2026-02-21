package domain;

public class Coordenador extends FuncionarioComPonto implements Registravel{
    public Coordenador(int id, String nome) {
        super(id, nome);
    }

    @Override
    protected boolean horasExtrasExcedidas(long horasExtras) {
        return horasExtras > 5;
    }
}
