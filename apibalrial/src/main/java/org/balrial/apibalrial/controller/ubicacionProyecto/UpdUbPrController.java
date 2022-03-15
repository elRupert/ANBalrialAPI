package org.balrial.apibalrial.controller.ubicacionProyecto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.UbicacionProyectoDTO;
import org.balrial.apibalrial.dto.UsuarioDTO;
import org.balrial.apibalrial.dto.assembler.UbicacionProyectoAssembler;
import org.balrial.apibalrial.dto.assembler.UsuarioAssembler;
import org.balrial.dao.ubicacionproyecto.UbicacionProyectoDAO;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.UbicacionProyecto;
import org.balrial.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class UpdUbPrController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UbicacionProyectoDAO ubicacionProyectoDAO = factory.getUbicacionProyectoDAO();

    @ApiOperation(value = "Endpoint para poder actualizar la Ubicacion de Proyecto en la BBDD"
            , notes = "En este endpoint enviamos un objeto Ubicacion Proyecto que modificará los datos actuales de la Ubicacion de Proyecto que se haya modificado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PutMapping("/ubicacionProyectos")
    public UbicacionProyectoDTO actualizarUbicacionProyecto(@RequestBody UbicacionProyectoDTO dto) {

        UbicacionProyecto ubicacionProyectoBD = ubicacionProyectoDAO.consultar(dto.getId());

        if (ubicacionProyectoBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            UbicacionProyecto ubicacionProyecto = UbicacionProyectoAssembler.pasearDesdeDTO(dto);
            ubicacionProyectoDAO.actualizar(ubicacionProyecto);

            return UbicacionProyectoAssembler.pasearADTO(ubicacionProyecto);
        }
    }
}
