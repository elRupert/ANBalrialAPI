package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.EntidadDTO;
import org.balrial.model.Entidad;

public class EntidadAssembler {

    public static EntidadDTO pasearADTO(Entidad obj) {

        EntidadDTO dto = new EntidadDTO();

        dto.setId(obj.getId());
        dto.setNombre(obj.getNombre());

        return dto;
    }

    public static Entidad pasearDesdeDTO(EntidadDTO dto) {

        Entidad obj = new Entidad();

        obj.setId(dto.getId());
        obj.setNombre(dto.getNombre());

        return obj;
    }
}
