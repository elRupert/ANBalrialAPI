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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author LuciaRguez
 * Método para devolver varias fechas proyecto
 */

@RestController
@RequestMapping("/api")
public class ShoFecPrController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private FechaProyectoDAO fechaProyectoDAO = factory.getFechaProyectoDao();

    @ApiOperation(value = "Endpoint para listar todos los proyectos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/proyfechas")
    public List<FechaProyectoDTO> listarFechasProyecto() {

        List<FechaProyecto> lista = fechaProyectoDAO.listar();

        List<FechaProyectoDTO> listaDTO = new ArrayList<>();
        for (FechaProyecto fechaProyecto : lista) {
            FechaProyectoDTO fechaProyectoDTO = FechaProyectoAssembler.pasearADTO(fechaProyecto);
            listaDTO.add(fechaProyectoDTO);
        }

        return listaDTO;
    }

}

