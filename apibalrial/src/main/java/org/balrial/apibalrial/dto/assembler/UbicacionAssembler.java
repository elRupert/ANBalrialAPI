package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.UbicacionDTO;
import org.balrial.model.Ubicacion;

public class UbicacionAssembler {

    public static UbicacionDTO pasearADTO(Ubicacion obj) {

        UbicacionDTO dto = new UbicacionDTO();

        dto.setId(obj.getId());
        dto.setIdEntidad(obj.getIdEntidad());
        dto.setNombre(obj.getNombre());
        dto.setDireccion(obj.getDireccion());
        dto.setCp(obj.getCp());
        dto.setPoblacion(obj.getPoblacion());
        dto.setZona(obj.getZona());
        dto.setLongitud(obj.getLongitud());
        dto.setLatitud(obj.getLatitud());
        dto.setVolumen(obj.getVolumen());

        return dto;
    }

    public static Ubicacion pasearDesdeDTO(UbicacionDTO dto) {

        Ubicacion obj = new Ubicacion();

        obj.setId(dto.getId());
        obj.setIdEntidad(dto.getIdEntidad());
        obj.setNombre(dto.getNombre());
        obj.setDireccion(dto.getDireccion());
        obj.setCp(dto.getCp());
        obj.setPoblacion(dto.getPoblacion());
        obj.setZona(dto.getZona());
        obj.setLongitud(dto.getLongitud());
        obj.setLatitud(dto.getLatitud());
        obj.setVolumen(dto.getVolumen());

        return obj;
    }
}
