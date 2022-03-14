package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.FechaProyectoDTO;
import org.balrial.model.FechaProyecto;

public class FechaProyectoAssembler {

    public static FechaProyectoDTO pasearADTO(FechaProyecto obj){

     FechaProyectoDTO dto = new FechaProyectoDTO();

     dto.setId(obj.getId());
     dto.setIdProyecto(obj.getIdProyecto());
     dto.setFecha(obj.getFecha());

     return dto;
    }


    public static FechaProyecto pasearDesdeDTO(FechaProyectoDTO dto){

        FechaProyecto obj= new FechaProyecto();

        obj.setId(dto.getId());
        obj.setIdProyecto(dto.getIdProyecto());
        obj.setFecha(dto.getFecha());

        return obj;
    }
}
