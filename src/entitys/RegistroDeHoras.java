package entitys;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RegistroDeHoras {
    private final LocalDate data;
    private final LocalTime horarioEntrada;
    private final LocalTime horarioSaida;
    private final long horas;

    public LocalDate getData() {
        return data;
    }

    public RegistroDeHoras(LocalDate data, LocalTime horarioEntrada, LocalTime horarioSaida, long horas) {
        this.data = data;
        this.horarioEntrada = horarioEntrada;
        this.horarioSaida = horarioSaida;
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Data: " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " | Entrada: " + horarioEntrada +
                " | Saída: " + horarioSaida +
                " | Horas trabalhadas: " + horas + "h";
    }
}
