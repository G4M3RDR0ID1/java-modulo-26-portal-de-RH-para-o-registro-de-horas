package infrastructure;

public class GeradorId {
    private static int proximoId = 1;

    public static int gerarId(){
        return proximoId++;
    }
}
