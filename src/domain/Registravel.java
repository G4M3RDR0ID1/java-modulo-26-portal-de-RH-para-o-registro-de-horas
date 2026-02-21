package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Registravel {
    void registrarPonto(LocalDate data, LocalTime entrada, LocalTime saida);
}