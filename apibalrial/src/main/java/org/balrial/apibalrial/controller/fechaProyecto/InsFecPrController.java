package org.balrial.apibalrial.controller.fechaProyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.FechaProyectoDTO;
import org.balrial.apibalrial.dto.assembler.FechaProyectoAssembler;
import org.balrial.dao.fechaProyecto.FechaProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.FechaProyecto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author LuciaRguez
 * Método para insertar una fecha proyecto
 */

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class InsFecPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private FechaProyectoDAO fechaProyectoDAO = factory.getFechaProyectoDao();

    @ApiOperation(value = "Endpoint para insertar una fecha de un proyecto"
            , notes = "En este endpoint enviamos un json para insertar un nuevo proyecto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping("/proyfechas")
    public ResponseEntity<FechaProyectoDTO> insertarFechaProyecto(@RequestBody FechaProyectoDTO dto) throws Exception {

        FechaProyecto fechaProyecto = FechaProyectoAssembler.pasearDesdeDTO(dto);

        fechaProyectoDAO.insertar(fechaProyecto);

        return new ResponseEntity<>(FechaProyectoAssembler.pasearADTO(fechaProyecto), HttpStatus.CREATED);
    }
}
