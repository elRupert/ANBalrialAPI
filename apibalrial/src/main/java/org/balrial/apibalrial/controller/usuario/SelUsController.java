package org.balrial.apibalrial.controller.usuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.dao.usuario.UsuarioORMDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelUsController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UsuarioDAO usuarioDAO = factory.getUsuarioDAO();

    @ApiOperation(value = "Endpoint para seleccionar un usuario"
            ,notes = "En este endpoint enviamos un valor en el path de la petición de seleccionar usuario, el cual será procesado por la API y nos devolverá el resultado en modo texto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    @GetMapping("/usuarios/{id}")
    public Usuario one(@PathVariable int id) {
        UsuarioDAO usuarioDAO = new UsuarioORMDAO();
        Usuario usuario = usuarioDAO.consultar(id);


        return usuario;
    }

}
