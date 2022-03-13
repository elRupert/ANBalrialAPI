package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsuarioDTO implements Serializable {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String login;
    private String telefono;
    private String email;
    private Integer cp;
    private Integer telegramId;
    private String dias;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer disponibilidad;

}
