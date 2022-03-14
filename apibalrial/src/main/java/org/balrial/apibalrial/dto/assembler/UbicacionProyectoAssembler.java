package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.UbicacionProyectoDTO;
import org.balrial.model.UbicacionProyecto;

public class UbicacionProyectoAssembler {

    public static UbicacionProyectoDTO pasearADTO(UbicacionProyecto obj) {

        UbicacionProyectoDTO dto = new UbicacionProyectoDTO();

        dto.setId(obj.getId());
        dto.setIdProyecto(obj.getIdProyecto());
        dto.setIdUbicacion(obj.getIdUbicacion());
        dto.setIdCordinador(obj.getIdCordinador());

        return dto;
    }

    public static UbicacionProyecto pasearDesdeDTO(UbicacionProyectoDTO dto){

        UbicacionProyecto obj = new UbicacionProyecto();

        obj.setId(dto.getId());
        obj.setIdProyecto(dto.getIdProyecto());
        obj.setIdUbicacion(dto.getIdUbicacion());
        obj.setIdCordinador(dto.getIdCordinador());

        return obj;
    }
}
