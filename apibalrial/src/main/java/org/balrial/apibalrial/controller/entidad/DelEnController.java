package org.balrial.apibalrial.controller.entidad;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.entidad.EntidadDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Entidad;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Diego de Arriba
 * metodo para eliminar entidades
 */
@RestController
@RequestMapping("/api")
public class DelEnController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private EntidadDAO entidadDAO = factory.getEntidadDAO();

    @ApiOperation(value = "Endpoint para probar a pasar un valor en el path"
            , notes = "En este endpoint enviamos un valor en el path de la petición el cual será procesado por la API y nos lo devolverá en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @DeleteMapping(value="/entidades/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public void eliminarEntidades(@PathVariable int id) {

        Entidad entidad = entidadDAO.consultar(id);

        if (entidad == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            entidadDAO.eliminar(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}
