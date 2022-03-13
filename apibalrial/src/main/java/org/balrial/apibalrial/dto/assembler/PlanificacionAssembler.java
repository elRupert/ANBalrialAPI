package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.PlanificacionDTO;
import org.balrial.model.Planificacion;

import java.sql.Time;
import java.sql.Timestamp;

public class PlanificacionAssembler {
    
    public static PlanificacionDTO pasearADTO(Planificacion obj) {

        PlanificacionDTO dto = new PlanificacionDTO();

        dto.setId(obj.getId());
        dto.setIdProyUbicacion(obj.getIdProyUbicacion());
        dto.setFecha(obj.getFecha().toLocalDateTime().toLocalDate());
        dto.setHoraInicio(obj.getHoraInicio().toLocalTime());
        dto.setHoraFin(obj.getHoraFin().toLocalTime());
        dto.setRecursos(obj.getRecursos());
        dto.setAsignados(obj.getAsignados());

        return dto;
    }

    public static Planificacion pasearDesdeDTO(PlanificacionDTO dto) {

        Planificacion obj = new Planificacion();

        obj.setId(dto.getId());
        obj.setIdProyUbicacion(dto.getIdProyUbicacion());
        obj.setFecha(Timestamp.valueOf(dto.getFecha().atStartOfDay()));
        obj.setHoraInicio(Time.valueOf(dto.getHoraInicio()));
        obj.setHoraFin(Time.valueOf(dto.getHoraFin()));
        obj.setRecursos(dto.getRecursos());
        obj.setAsignados(dto.getAsignados());

        return obj;
    }
}
