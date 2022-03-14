package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.balrial.model.Planificacion;
import org.balrial.model.Usuario;

import java.io.Serializable;

/**
 * @author Martin Blanco
 * DTO PlanificacionUsuario
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PlanificacionUsuarioDTO implements Serializable {
    private int id;
    private int idPlanificacion;
    private int idUsuario;
    private Usuario usuario;
    private Planificacion planificacion;
}
