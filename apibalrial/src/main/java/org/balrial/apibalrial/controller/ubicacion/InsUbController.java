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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InsUbController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UbicacionDAO ubicacionDAO = factory.getUbicacionDAO();

    @ApiOperation(value = "Endpoint para insertar una nueva ubicación"
            , notes = "En este endpoint enviamos un json para crear una nueva ubicación en la BBDD")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping("/ubicaciones")
    public ResponseEntity<UbicacionDTO> insertarUbicacion(@RequestBody UbicacionDTO dto) throws Exception {

        Ubicacion ubicacion = UbicacionAssembler.pasearDesdeDTO(dto);
        ubicacion.setNombre("");

        ubicacionDAO.insertar(ubicacion);

        return new ResponseEntity<>(UbicacionAssembler.pasearADTO(ubicacion), HttpStatus.CREATED);
    }
}
