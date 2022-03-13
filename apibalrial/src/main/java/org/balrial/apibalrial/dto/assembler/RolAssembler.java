package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.RolDTO;
import org.balrial.model.Rol;

public class RolAssembler {

    public static RolDTO pasearADTO(Rol obj) {

        RolDTO dto = new RolDTO();

        dto.setId(obj.getId());
        dto.setNombre(obj.getNombre());

        return dto;
    }

    public static Rol pasearDesdeDTO(RolDTO dto) {

        Rol obj = new Rol();

        obj.setId(dto.getId());
        obj.setNombre(dto.getNombre());

        return obj;
    }
}
