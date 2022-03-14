package org.balrial.apibalrial.controller.proyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.ProyectoDTO;
import org.balrial.apibalrial.dto.TestDTO;
import org.balrial.apibalrial.dto.assembler.ProyectoAssembler;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Proyecto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoPrController {

    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private final ProyectoDAO proyectoDAO = factory.getProyectoDAO();

    @ApiOperation(value = "Endpoint para pruebas de tipos de datos"
            ,notes = "En este endpoint devolvemos todos los tipos de datos que pueden ser retornados para facilitar pruebas con el API.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    @GetMapping(value = "/proyectos", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<ProyectoDTO> listarProyectos () throws ParseException {

        List<Proyecto>listaProyectos=proyectoDAO.listar();
        List<ProyectoDTO> listaProyectosDTO=new ArrayList<>();
        for(Proyecto proyecto:listaProyectos){

            ProyectoDTO proyectoDTO= ProyectoAssembler.pasearADTO(proyecto);
            listaProyectosDTO.add(proyectoDTO);

        }

        return listaProyectosDTO;
    }



}
