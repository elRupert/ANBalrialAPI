package org.balrial.apibalrial.controller.turnoproyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import org.balrial.apibalrial.dto.TurnoProyectoDTO;
import org.balrial.apibalrial.dto.assembler.TurnoProyectoAssembler;
import org.balrial.dao.turnoproyecto.TurnoProyectoDAO;
import org.balrial.factory.DAOFactory;

import org.balrial.model.TurnoProyecto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InsTuPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private TurnoProyectoDAO turnoProyectoDAO = factory.getTurnoProyectoDAO();

    @ApiOperation(value = "Endpoint para probar un post de un objeto"
            , notes = "En este endpoint enviamos un objeto para que sea procesado por la API la cual nos lo mostrará en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping(value="/turnoproyectos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TurnoProyectoDTO> insertarTurnoProyecto(@RequestBody TurnoProyectoDTO dto) throws Exception {

        TurnoProyecto turnoProyecto = TurnoProyectoAssembler.pasearDesdeDTO(dto);

        turnoProyectoDAO.insertar(turnoProyecto);

        return new ResponseEntity<>(TurnoProyectoAssembler.pasearADTO(turnoProyecto), HttpStatus.CREATED);
    }
}
