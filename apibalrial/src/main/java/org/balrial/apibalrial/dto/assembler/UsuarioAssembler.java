package org.balrial.apibalrial.dto.assembler;

import org.balrial.apibalrial.dto.UsuarioDTO;
import org.balrial.model.Usuario;

import java.sql.Time;

public class UsuarioAssembler {

    public static UsuarioDTO pasearADTO(Usuario obj) {

        UsuarioDTO dto = new UsuarioDTO();

        dto.setId(obj.getId());
        dto.setNombre(obj.getNombre());
        dto.setApellidos(obj.getApellidos());
        dto.setLogin(obj.getLogin());
        dto.setTelefono(obj.getTelefono());
        dto.setEmail(obj.getEmail());
        dto.setCp(obj.getCp());
        dto.setTelegramId(obj.getTelegramId());
        dto.setDias(obj.getDias());
        dto.setHoraInicio(obj.getHoraInicio().toLocalTime());
        dto.setHoraFin(obj.getHoraFin().toLocalTime());
        dto.setDisponibilidad(obj.getDisponibilidad());

        return dto;
    }

    public static Usuario pasearDesdeDTO(UsuarioDTO dto) {

        Usuario obj = new Usuario();

        obj.setId(dto.getId());
        obj.setNombre(dto.getNombre());
        obj.setApellidos(dto.getApellidos());
        obj.setLogin(dto.getLogin());
        obj.setTelefono(dto.getTelefono());
        obj.setEmail(dto.getEmail());
        obj.setCp(dto.getCp());
        obj.setTelegramId(dto.getTelegramId());
        obj.setDias(dto.getDias());
        obj.setHoraInicio(Time.valueOf(dto.getHoraInicio()));
        obj.setHoraFin(Time.valueOf(dto.getHoraFin()));
        obj.setDisponibilidad(dto.getDisponibilidad());

        return obj;
    }
}
