package org.balrial.apibalrial.controller.planificacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.PlanificacionDTO;
import org.balrial.dao.planificacion.PlanificacionDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Planificacion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class UpdPlController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private PlanificacionDAO planificacionDAO = factory.getPlanificacionDAO();

    @ApiOperation(value = "Endpoint para probar un post de un objeto"
            , notes = "En este endpoint enviamos un objeto para que sea procesado por la API la cual nos lo mostrará en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PutMapping("/planificaciones")
    public void actualizarPlanificacion(@RequestBody PlanificacionDTO planificacionDTO) {

        Planificacion planificacion = planificacionDAO.consultar(planificacionDTO.getId());

        if (planificacion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            planificacionDAO.actualizar(planificacion);
        }
    }
}
