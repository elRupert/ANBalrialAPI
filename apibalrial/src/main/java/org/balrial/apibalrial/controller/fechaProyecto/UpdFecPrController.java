package org.balrial.apibalrial.controller.fechaProyecto;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.FechaProyectoDTO;
import org.balrial.apibalrial.dto.UsuarioDTO;
import org.balrial.apibalrial.dto.assembler.FechaProyectoAssembler;
import org.balrial.apibalrial.dto.assembler.UsuarioAssembler;
import org.balrial.dao.fechaProyecto.FechaProyectoDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.FechaProyecto;
import org.balrial.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author LuciaRguez
 * Método para actualizar una fechas proyecto
 */

@RestController
@RequestMapping("/api")
public class UpdFecPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private FechaProyectoDAO fechaProyectoDAO = factory.getFechaProyectoDao();

    @ApiOperation(value = "Endpoint para poder actualizar la echa proyecto en la BBDD"
            , notes = "En este endpoint enviamos un objeto usuario que modificará los datos actuales del usuario que se haya modificado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PutMapping("/proyfechas")
    public FechaProyectoDTO actualizarFechaProyecto(@RequestBody FechaProyectoDTO dto) {

        FechaProyecto fechaProyectoBD = fechaProyectoDAO.consultar(dto.getId());

        if (fechaProyectoBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            FechaProyecto fechaProyecto = FechaProyectoAssembler.pasearDesdeDTO(dto);
            fechaProyecto.setFecha(fechaProyecto.getFecha());
            fechaProyectoDAO.actualizar(fechaProyecto);

            return FechaProyectoAssembler.pasearADTO(fechaProyecto);
        }
    }
}
