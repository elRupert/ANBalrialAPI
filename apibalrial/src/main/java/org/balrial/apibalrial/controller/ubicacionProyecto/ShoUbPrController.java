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
import org.balrial.model.Ubicacion;
import org.balrial.model.UbicacionProyecto;
import org.balrial.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Este endpoint devuelve una lista con todas las Ubicaciones de Proyectos
 */
@RestController
@RequestMapping("/api")
public class ShoUbPrController {

    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UbicacionProyectoDAO ubicacionProyectoDAO = factory.getUbicacionProyectoDAO();

    @ApiOperation(value = "Endpoint para seleccionar todas las Ubicaciones de Proyectos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/ubicacionProyectos")
    public List<UbicacionProyectoDTO> listarUbicacionProyecto() {

        List<UbicacionProyecto> lista = ubicacionProyectoDAO.listar();

        List<UbicacionProyectoDTO> listaDTO = new ArrayList<>();
        for (UbicacionProyecto ubicacionProyecto : lista) {
            UbicacionProyectoDTO ubicacionProyectoDTO = UbicacionProyectoAssembler.pasearADTO(ubicacionProyecto);
            listaDTO.add(ubicacionProyectoDTO);
        }

        return listaDTO;
    }

}
