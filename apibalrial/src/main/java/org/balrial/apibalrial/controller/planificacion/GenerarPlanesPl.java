package org.balrial.apibalrial.controller.planificacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api")
/**
 *
 */
public class GenerarPlanesPl {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private ProyectoDAO proyectoDAO = factory.getProyectoDAO();

    @ApiOperation(value = "Endpoint que genera las planificaciones de un proyecto en base a como se especifica en la documentación")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping("/planificaciones/{idProyecto}")
    public void generarPlanificacion(@PathVariable int idProyecto) {
        
        System.out.println(proyectoDAO.consultar(idProyecto).toString());

        // Consulta para comprobar is el idEspecificado se corresponde con datos reales
        if (proyectoDAO.consultar(idProyecto) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        } else {
            proyectoDAO.generarPlanificaciones(idProyecto);
        }
    }
}

