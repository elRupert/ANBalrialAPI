package org.balrial.apibalrial.controller.proyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.dao.proyecto.ProyectoORMDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Proyecto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelPrController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private ProyectoDAO proyectoDAO = factory.getProyectoDAO();


    @ApiOperation(value = "Endpoint para probar a pasar un valor en el path"
            ,notes = "En este endpoint enviamos un valor en el path de la petición el cual será procesado por la API y nos lo devolverá en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    @GetMapping("/proyectos/{idProyecto}")
    public Proyecto one(@PathVariable int idProyecto) {

        ProyectoDAO proyectoDAO= new ProyectoORMDAO();
        Proyecto proyecto = proyectoDAO.consultar(idProyecto);

        return proyecto;
    }






}
