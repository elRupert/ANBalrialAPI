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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class UpdTuPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private final TurnoProyectoDAO turnoProyectoDAO = factory.getTurnoProyectoDAO();

    @ApiOperation(value = "Endpoint para poder actualizar el usuario en la BBDD"
            , notes = "En este endpoint enviamos un objeto usuario que modificará los datos actuales del usuario que se haya modificado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PutMapping(value="/turnoproyectos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public TurnoProyectoDTO actualizarTurnoProyecto(@RequestBody TurnoProyectoDTO dto) {

        TurnoProyecto turnoProyectoBD = turnoProyectoDAO.consultar(dto.getId());

        if (turnoProyectoBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            TurnoProyecto turnoProyecto = TurnoProyectoAssembler.pasearDesdeDTO(dto);
            turnoProyecto.setHoraInicio(turnoProyectoBD.getHoraInicio());
            turnoProyecto.setHoraFin(turnoProyectoBD.getHoraFin());
            turnoProyectoDAO.actualizar(turnoProyecto);

            return TurnoProyectoAssembler.pasearADTO(turnoProyecto);
        }
    }
}
