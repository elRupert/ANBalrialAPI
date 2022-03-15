package org.balrial.apibalrial.controller.turnoproyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.balrial.apibalrial.dto.TurnoProyectoDTO;
import org.balrial.apibalrial.dto.assembler.TurnoProyectoAssembler;
import org.balrial.dao.turnoproyecto.TurnoProyectoDAO;
import org.balrial.factory.DAOFactory;

import org.balrial.model.TurnoProyecto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShoTuPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private TurnoProyectoDAO turnoProyectoDAO = factory.getTurnoProyectoDAO();

    @ApiOperation(value = "Endpoint para listar ubicaciones"
            , notes = "En este endpoint listamos todas las ubicaciones que hay en la api.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping(value="/turnoproyectos", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TurnoProyectoDTO> listarUbicaciones() {

        List<TurnoProyecto> lista = turnoProyectoDAO.listar();

        List<TurnoProyectoDTO> listaDTO = new ArrayList<>();
        for (TurnoProyecto turnoProyecto : lista) {
            TurnoProyectoDTO turnoProyectoDTO = TurnoProyectoAssembler.pasearADTO(turnoProyecto);
            listaDTO.add(turnoProyectoDTO);
        }
        return listaDTO;
    }
}
