package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UbicacionDTO implements Serializable {

    private Integer id;
    private Integer idEntidad;
    private String nombre;
    private String direccion;
    private Integer cp;
    private String poblacion;
    private String zona;
    private Double longitud;
    private Double latitud;
    private Integer volumen;
    
}
