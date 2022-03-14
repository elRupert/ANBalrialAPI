package org.balrial.apibalrial.controller.planificacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.PlanificacionDTO;
import org.balrial.apibalrial.dto.assembler.PlanificacionAssembler;
import org.balrial.apibalrial.dto.assembler.ProyectoAssembler;
import org.balrial.dao.planificacion.PlanificacionDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Planificacion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")

public class SelPlController {

        private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
        private PlanificacionDAO planificacionDAO = factory.getPlanificacionDAO();

        @ApiOperation(value = "Endpoint que consulta una planificación concreta de un proyecto en base a como se especifica en la documentación")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
                @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
                @ApiResponse(code = 401, message = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
                @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
                @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
                @ApiResponse(code = 500, message = "Error inesperado del sistema")})
        @GetMapping("/planificaciones/{idPlanificacion}")

        public PlanificacionDTO consultarPlanificacion(@PathVariable int idPlanificacion) {


            Planificacion planificacion = planificacionDAO.consultar(idPlanificacion);

            if (planificacion != null) {

                PlanificacionDTO planificacionDTO = PlanificacionAssembler.pasearADTO(planificacion);

                return planificacionDTO;

            } else {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");

            }
        }
}
