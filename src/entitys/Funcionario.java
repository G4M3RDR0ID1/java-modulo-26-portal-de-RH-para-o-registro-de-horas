package entitys;

public abstract class Funcionario {
    private int id;
    private String nome;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public abstract void exibirRegistros();

    @Override
    public String toString() {
        return "ID: " + id + " Funcionario: " + nome;
    }
}
