package org.balrial.apibalrial.controller.planificacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.PlanificacionDTO;
import org.balrial.apibalrial.dto.ProyectoDTO;
import org.balrial.apibalrial.dto.assembler.PlanificacionAssembler;
import org.balrial.apibalrial.dto.assembler.ProyectoAssembler;
import org.balrial.dao.planificacion.PlanificacionDAO;
import org.balrial.dao.proyecto.ProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Planificacion;
import org.balrial.model.Proyecto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ShoPlController {
    private final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private final PlanificacionDAO planificacionDAO = factory.getPlanificacionDAO();

    @ApiOperation(value = "Endpoint para listar planificaciones"
            ,notes = "En este endpoint devolvemos todos los tipos de datos que pueden ser retornados para facilitar pruebas con el API.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
    @GetMapping(value = "/planificaciones", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<PlanificacionDTO> listarPlanificaciones () throws ParseException {


        List<Planificacion> listaPlanificaciones = planificacionDAO.listar();
        List<PlanificacionDTO> listaPlanificacionesDTO = new ArrayList<>();


        for (Planificacion planificacion : listaPlanificaciones) {

            PlanificacionDTO planificacionDTO = PlanificacionAssembler.pasearADTO(planificacion);
            listaPlanificacionesDTO.add(planificacionDTO);

        }

        return listaPlanificacionesDTO;

    }
}
