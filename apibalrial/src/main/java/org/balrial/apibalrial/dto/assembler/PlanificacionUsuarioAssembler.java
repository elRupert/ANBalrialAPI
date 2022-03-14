package org.balrial.apibalrial.dto.assembler;


import org.balrial.apibalrial.dto.PlanificacionUsuarioDTO;
import org.balrial.model.PlanificacionUsuario;

/**
 * @author Martin Blanco
 * Assembler para el dto PlanificacionUsuario
 */
public class PlanificacionUsuarioAssembler {
    public static PlanificacionUsuarioDTO pasearADTO(PlanificacionUsuario obj){
       PlanificacionUsuarioDTO dto = new PlanificacionUsuarioDTO();

       dto.setId(obj.getId());
       dto.setIdPlanificacion(obj.getIdPlanificacion());
       dto.setIdUsuario(obj.getIdUsuario());
       dto.setUsuario(obj.getUsuario());
       dto.setPlanificacion(obj.getPlanificacion());

       return dto;
    }

    public static PlanificacionUsuario pasearDesdeDTO(PlanificacionUsuarioDTO dto){
        PlanificacionUsuario obj = new PlanificacionUsuario();

        obj.setId(dto.getId());
        obj.setIdPlanificacion(dto.getIdPlanificacion());
        obj.setIdUsuario(dto.getIdUsuario());
        obj.setUsuario(dto.getUsuario());
        obj.setPlanificacion(dto.getPlanificacion());

        return obj;
    }
}
