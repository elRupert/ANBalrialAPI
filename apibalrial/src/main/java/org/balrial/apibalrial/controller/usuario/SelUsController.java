package org.balrial.apibalrial.controller.usuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.RolDTO;
import org.balrial.apibalrial.dto.UsuarioDTO;
import org.balrial.apibalrial.dto.assembler.RolAssembler;
import org.balrial.apibalrial.dto.assembler.UsuarioAssembler;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Rol;
import org.balrial.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SelUsController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UsuarioDAO usuarioDAO = factory.getUsuarioDAO();

    @ApiOperation(value = "Endpoint para seleccionar un usuario"
            , notes = "En este endpoint enviamos un valor en el path de la petición de seleccionar usuario, el cual será procesado por la API y nos devolverá el resultado en modo texto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/usuarios/{id}")
    /**
     * Este endpoint consulta un id de usuario existente en la base de datos para saber toda la información de dicho usuario
     */
    public UsuarioDTO consultarUsuario(@PathVariable int id) {

        Usuario usuario = usuarioDAO.consultar(id);

        if (usuario != null) {
            UsuarioDTO usuarioDTO = UsuarioAssembler.pasearADTO(usuario);
            return usuarioDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        }
    }

    @ApiOperation(value = "Endpoint para listar los roles de un usuario"
            , notes = "En este endpoint enviamos un valor en el path de la petición de seleccionar usuario, el cual será procesado por la API y nos devolverá el resultado en modo texto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping(value="/usuarios/{id}/roles", produces = { MediaType.APPLICATION_JSON_VALUE})
    /**
     * Este endpoint consulta los roles de un id de usuario existente en la base de datos
     */
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
    }

}
