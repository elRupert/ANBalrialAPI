package org.balrial.apibalrial.controller.fechaProyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.fechaProyecto.FechaProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.FechaProyecto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

/**
 * @author LuciaRguez
 * Método para eliminar una fecha proyecto
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DelFecPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private FechaProyectoDAO fechaProyectoDAO = factory.getFechaProyectoDao();

    @ApiOperation(value = "Endpoint para eliminar una fecha proyecto"
            , notes = "En este endpoint enviamos un id que se buscara en la BBDD y se eliminara.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @DeleteMapping("/proyfechas/{id}")
    public void elminarFechaProyecto(@PathVariable int id) throws SQLException {

        FechaProyecto fechaProyecto = fechaProyectoDAO.consultar(id);

        if (fechaProyecto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            fechaProyectoDAO.eliminar(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}

