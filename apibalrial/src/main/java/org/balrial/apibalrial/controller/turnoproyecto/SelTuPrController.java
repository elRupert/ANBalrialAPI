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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SelTuPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private TurnoProyectoDAO turnoProyectoDAO = factory.getTurnoProyectoDAO();

    @ApiOperation(value = "Endpoint para seleccionar un usuario"
            , notes = "En este endpoint enviamos un valor en el path de la petición de seleccionar usuario, el cual será procesado por la API y nos devolverá el resultado en modo texto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping(value="/turnoproyectos/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    /**
     * Este endpoint consulta un id de usuario existente en la base de datos para saber toda la información de dicho usuario
     */
    public TurnoProyectoDTO consultarTurnoProyecto(@PathVariable int id) {

        TurnoProyecto turnoProyecto = turnoProyectoDAO.consultar(id);

        if (turnoProyecto != null) {
            TurnoProyectoDTO turnoProyectoDTO = TurnoProyectoAssembler.pasearADTO(turnoProyecto);
            return turnoProyectoDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        }
    }
    /**
     * @deprecated no funiciona ni se como hacerlo funcionar
    @ApiOperation(value = "Endpoint para listar los roles de un usuario"
            , notes = "En este endpoint enviamos un valor en el path de la petición de seleccionar usuario, el cual será procesado por la API y nos devolverá el resultado en modo texto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/usuarios/{id}/roles")

     * Este endpoint consulta los roles de un id de usuario existente en la base de datos

     *

    public List<RolDTO> consultarRolesUsuario(@PathVariable int id) {

        Usuario usuario = usuarioDAO.consultar(id);

        if (usuario != null) {
            UsuarioDTO usuarioDTO = UsuarioAssembler.pasearADTO(usuario);

            List<RolDTO> listaDTO = new ArrayList<>();
            for (Rol rol : usuario.getRoles()) {
                RolDTO rolDTO = RolAssembler.pasearADTO(rol);
                listaDTO.add(rolDTO);
            }

            return listaDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        }
    }*/
}
