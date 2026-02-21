package entitys;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroDeHoras {
    private LocalDate dia;
    private LocalTime horarioEntrada;
    private LocalTime horarioSaida;

    @Override
    public String toString() {
        return "Entrada: " + horarioEntrada +
                " | Saída: " + horarioSaida +
                " | Dia: " + dia;
    }
}
