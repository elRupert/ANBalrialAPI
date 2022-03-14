package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * @author Diego De Arriba Carrasco
 * Clase DTO de TurnoProyecto
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TurnoProyectoDTO implements Serializable {
    private int id;
    private int idProyecto;
    private LocalTime horaInicio;
    private LocalTime horaFin;

}
