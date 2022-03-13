package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.ProyectoDTO;
import org.balrial.model.Proyecto;

import java.sql.Timestamp;

public class ProyectoAssembler {

    public static ProyectoDTO pasearADTO(Proyecto obj) {

        ProyectoDTO dto = new ProyectoDTO();

        dto.setId(obj.getId());
        dto.setNombre(obj.getNombre());
        dto.setFechaInicio(obj.getFechaInicio().toLocalDateTime().toLocalDate());
        dto.setFechaFin(obj.getFechaFin().toLocalDateTime().toLocalDate());

        return dto;
    }

    public static Proyecto pasearDesdeDTO(ProyectoDTO dto) {

        Proyecto obj = new Proyecto();

        obj.setId(dto.getId());
        obj.setNombre(dto.getNombre());
        obj.setFechaInicio(Timestamp.valueOf(dto.getFechaInicio().atStartOfDay()));
        obj.setFechaFin(Timestamp.valueOf(dto.getFechaFin().atStartOfDay()));

        return obj;
    }
}
