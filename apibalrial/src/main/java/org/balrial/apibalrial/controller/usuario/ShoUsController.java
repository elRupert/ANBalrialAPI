package org.balrial.apibalrial.controller.usuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.UsuarioDTO;
import org.balrial.apibalrial.dto.assembler.UsuarioAssembler;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Este endpoint devuelve una lista con todos los usuarios
 */
@RestController
@RequestMapping("/api")
public class ShoUsController {

    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private final UsuarioDAO usuarioDAO = factory.getUsuarioDAO();

    @ApiOperation(value = "Endpoint para listar todos los proyectos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/usuarios")
    public List<UsuarioDTO> listarUsuarios() {

        List<Usuario> lista = usuarioDAO.listar();

        List<UsuarioDTO> listaDTO = new ArrayList<>();
        for (Usuario usuario : lista) {
            UsuarioDTO usuarioDTO = UsuarioAssembler.pasearADTO(usuario);
            listaDTO.add(usuarioDTO);
        }

        return listaDTO;
    }

}
