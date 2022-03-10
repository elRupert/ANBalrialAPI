package org.balrial.apibalrial.controller.entidad;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.dao.entidad.EntidadDAO;
import org.balrial.dao.entidad.EntidadORMDAO;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.dao.proyecto.ProyectoORMDAO;
import org.balrial.model.Entidad;
import org.balrial.model.Proyecto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Diego de Arriba Carrasco
 * metodo para listar todas las entidades.
 */
@RestController
@RequestMapping("/api")
public class ShoEnController {
    @ApiOperation(value = "Endpoint para probar a pasar un valor en el path"
            ,notes = "En este endpoint enviamos un valor en el path de la petición el cual será procesado por la API y nos lo devolverá en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    @GetMapping("/entidades")
    public List<Entidad> one() {

        EntidadDAO entidadDAO= new EntidadORMDAO();
        List<Entidad> entidad = entidadDAO.listar();

        return entidad;
    }

}