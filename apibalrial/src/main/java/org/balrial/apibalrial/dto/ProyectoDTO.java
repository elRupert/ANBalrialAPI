package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProyectoDTO implements Serializable {

    private int id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
}
