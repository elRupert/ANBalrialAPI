package org.balrial.apibalrial.controller.proyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.ProyectoDTO;
import org.balrial.apibalrial.dto.assembler.ProyectoAssembler;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Proyecto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Daniel Ares Cabo
 * Método para seleccionar un proyecto concreto
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class SelPrController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private ProyectoDAO proyectoDAO = factory.getProyectoDAO();


    @ApiOperation(value = "Endpoint para probar a pasar un valor en el path"
            , notes = "En este endpoint enviamos un valor en el path de la petición el cual será procesado por la API y nos lo devolverá en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping(value="/proyectos/{idProyecto}", produces = { MediaType.APPLICATION_JSON_VALUE})
    /**
     * Este endpoint consulta un id de proyecto existente en la base de datos para saber toda la información de dicho proyecto
     */
    public ProyectoDTO consultarProyecto(@PathVariable int idProyecto) {

        Proyecto proyecto = proyectoDAO.consultar(idProyecto);

        if (proyecto != null) {
            ProyectoDTO proyectoDTO = ProyectoAssembler.pasearADTO(proyecto);

            return proyectoDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso solicitado");
        }
    }

}
