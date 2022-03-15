package org.balrial.apibalrial.controller.ubicacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.UbicacionDTO;
import org.balrial.apibalrial.dto.UsuarioDTO;
import org.balrial.apibalrial.dto.assembler.UbicacionAssembler;
import org.balrial.apibalrial.dto.assembler.UsuarioAssembler;
import org.balrial.dao.ubicacion.UbicacionDAO;
import org.balrial.dao.usuario.UsuarioDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Ubicacion;
import org.balrial.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UpdUbController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private final UbicacionDAO ubicacionDAO = factory.getUbicacionDAO();

    @ApiOperation(value = "Endpoint para poder actualizar la ubicación en la BBDD"
            , notes = "En este endpoint enviamos un objeto ubicacion que modificará los datos actuales de la ubicación que se haya modificado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PutMapping("/ubicaciones/{id}")
    public UbicacionDTO actualizarUbicacion(@PathVariable int id, @RequestBody UbicacionDTO dto) {

        // Verificamos si el id de la url coincide con el del objeto a modificar
        if (dto.getId()!=id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El identificador no coincide");
        }

        Ubicacion ubicacionBD = ubicacionDAO.consultar(dto.getId());

        if (ubicacionBD == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha encontrado el recuso solicitado");
        } else {
            Ubicacion ubicacion = UbicacionAssembler.pasearDesdeDTO(dto);

            ubicacionDAO.actualizar(ubicacion);

            return UbicacionAssembler.pasearADTO(ubicacion);
        }
    }
}
