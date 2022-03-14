package org.balrial.apibalrial.controller.ubicacion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.balrial.apibalrial.dto.UbicacionDTO;
import org.balrial.apibalrial.dto.assembler.EntidadAssembler;
import org.balrial.apibalrial.dto.assembler.UbicacionAssembler;
import org.balrial.dao.ubicacion.UbicacionDAO;
import org.balrial.factory.DAOFactory;
import org.balrial.model.Ubicacion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Lucia Rguez
 * metodo para listar todas las ubicaciones.
 */

@RestController
@RequestMapping("/api")
public class ShoUbController {
    private DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.ORM);
    private UbicacionDAO ubicacionDAO = factory.getUbicacionDAO();

    @ApiOperation(value = "Endpoint para listar ubicaciones"
            , notes = "En este endpoint listamos todas las ubicaciones que hay en la api.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La solicitud ha tenido éxito."),
            @ApiResponse(code = 400, message = "No se pudo interpretar la solicitud debido a una sintaxis inválida."),
            @ApiResponse(code = 401, message = "Petició no autorizada, es necesario autenticar para obtener la respuesta solicitada."),
            @ApiResponse(code = 403, message = "No se poseen los permisos necesarios para la solicitud, por lo que se rechaza la misma."),
            @ApiResponse(code = 404, message = "El servidor no puede encontrar el contenido solicitado."),
            @ApiResponse(code = 500, message = "Error inesperado del sistema")})
    @GetMapping("/ubicaciones")
    public List<UbicacionDTO> listarUbicaciones() {

        List<Ubicacion> lista = ubicacionDAO.listar();

        List<UbicacionDTO> listaDTO = new ArrayList<>();
        for (Ubicacion ubicacion : lista) {
            UbicacionDTO ubicacionDTO = UbicacionAssembler.pasearADTO(ubicacion);
            listaDTO.add(ubicacionDTO);
        }
        return listaDTO;
    }
}
