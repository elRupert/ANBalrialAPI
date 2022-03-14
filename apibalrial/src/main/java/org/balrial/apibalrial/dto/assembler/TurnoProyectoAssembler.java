package org.balrial.apibalrial.dto.assembler;


import org.balrial.apibalrial.dto.TurnoProyectoDTO;

import org.balrial.model.TurnoProyecto;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @author Diego De Arriba Carrasco
 * Assembler para el objeto DTO de TurnoProyecto
 */
public class TurnoProyectoAssembler {
    public static TurnoProyectoDTO pasearADTO(TurnoProyecto obj) {

        TurnoProyectoDTO dto = new TurnoProyectoDTO();

        dto.setId(obj.getId());
        dto.setIdProyecto(obj.getIdProyecto());
        dto.setHoraInicio(obj.getHoraInicio().toLocalTime());
        dto.setHoraFin(obj.getHoraFin().toLocalTime());

        return dto;
    }

    public static TurnoProyecto pasearDesdeDTO(TurnoProyectoDTO dto) {

        TurnoProyecto obj = new TurnoProyecto();

        obj.setId(dto.getId());
        obj.setIdProyecto(dto.getIdProyecto());
        obj.setHoraInicio(Time.valueOf(dto.getHoraInicio()));
        obj.setHoraFin(Time.valueOf(dto.getHoraFin()));

        return obj;
    }
}
