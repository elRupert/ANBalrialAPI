package org.balrial.apibalrial.controller.planificacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.fechaProyecto.FechaProyectoDAO;
import org.balrial.dao.fechaProyecto.FechaProyectoORMDAO;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.dao.proyecto.ProyectoORMDAO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PlanificacionController {


    @ApiOperation(value = "Endpoint para insertar una planificación en un proyecto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping("/planificaciones/{idProyecto}")
    public void one(@PathVariable int idProyecto) {

        ProyectoDAO proyectoDAO = new ProyectoORMDAO();
        FechaProyectoDAO fechaProyectoDAO = new FechaProyectoORMDAO();


        // Consulta para comprobar is el idEspecificado se corresponde con datos reales
        if(proyectoDAO.consultar(idProyecto) == null) {
            System.out.println("Null");
        } else {

            // todo llamar al procedimiento almacenado(en dao proyecto) que genere los planes
        }

    }
}
