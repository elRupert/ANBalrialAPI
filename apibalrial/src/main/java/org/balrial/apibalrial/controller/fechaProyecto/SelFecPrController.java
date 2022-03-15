package org.balrial.apibalrial.controller.fechaProyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.FechaProyectoDTO;
import org.balrial.apibalrial.dto.assembler.FechaProyectoAssembler;
import org.balrial.dao.fechaProyecto.FechaProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.FechaProyecto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author LuciaRguez
 * Método para seleccionar una fecha proyecto
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SelFecPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private FechaProyectoDAO fechaProyectoDAO = factory.getFechaProyectoDao();

    @ApiOperation(value = "Endpoint para probar a pasar un valor en el path"
            , notes = "En este endpoint enviamos un valor en el path de la petición el cual será procesado por la API y nos lo devolverá en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/proyfechas/{id}")
    public FechaProyectoDTO consultarFechaProyecto(@PathVariable int id) {

        FechaProyecto fechaProyecto = fechaProyectoDAO.consultar(id);

        if (fechaProyecto != null) {
            FechaProyectoDTO fechaProyectoDTO = FechaProyectoAssembler.pasearADTO(fechaProyecto);

            return fechaProyectoDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        }
    }
}
