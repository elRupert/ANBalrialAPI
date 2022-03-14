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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class InsUbPrController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UbicacionProyectoDAO ubicacionProyectoDAO = factory.getUbicacionProyectoDAO();

    @ApiOperation(value = "Endpoint para probar un post de un objeto"
            , notes = "En este endpoint enviamos un objeto para que sea procesado por la API la cual nos lo mostrará en modo texto.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 201, message = "La solicitud ha tenido éxito y se ha creado un nuevo recurso como resultado de ello."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petición no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @PostMapping("/ubicacionProyectos")
    public ResponseEntity<UbicacionProyectoDTO> insertarUbicacionProyecto(@RequestBody UbicacionProyectoDTO dto) throws Exception {

        UbicacionProyecto ubicacionProyecto = UbicacionProyectoAssembler.pasearDesdeDTO(dto);

        ubicacionProyectoDAO.insertar(ubicacionProyecto);

        return new ResponseEntity<>(UbicacionProyectoAssembler.pasearADTO(ubicacionProyecto), HttpStatus.CREATED);
    }

}
