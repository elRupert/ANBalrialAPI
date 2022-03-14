package org.balrial.apibalrial.controller.proyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Proyecto;
import org.balrial.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

/**
 * @author LuciaRguez
 * Método para eliminar un proyecto
 */

@RestController
@RequestMapping("/api")
public class DelPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private ProyectoDAO proyectoDAO = factory.getProyectoDAO();

    @ApiOperation(value = "Endpoint para eliminar un proyecto"
            , notes = "En este endpoint enviamos un id que se buscara en la BBDD y se eliminara.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @DeleteMapping("/proyectos/{id}")
    public void elminarProyecto(@PathVariable int id) throws SQLException {

        Proyecto proyecto = proyectoDAO.consultar(id);

        if (proyecto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            proyectoDAO.eliminar(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
