package utez.edu.mx.unidad3.modules.cede;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.unidad3.utils.APIResponse;

@RestController
@RequestMapping("/api/cede")
public class CedeController {
    @Autowired
    private CedeService cedeService;

    //http://localhpst:8080/api/cede=OK
    //http://localhpst:8080/api/cede/=NOT_FOUND
    @GetMapping(value = {"","/"})
    @Operation(summary = "Traer cedes",description = "Trae a todos las cedes registrados en el sistema.")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    description = "Traer todos las cedes",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                            @Content(mediaType = "application/xml", schema = @Schema(implementation = APIResponse.class)),
                            @Content(mediaType = "application/html", schema = @Schema(implementation = APIResponse.class))
                    }
            )
    })
    public ResponseEntity<APIResponse> findAll(){
        APIResponse response=cedeService.findAll();
        return new ResponseEntity<>(response,response.getStatus());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Traer una cede",description = "Trae una cede en especifico")
    @ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Traer a la cede solicitada",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "No se encontro la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No se pudo consultar la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            )
    })
    public ResponseEntity<APIResponse> findById(@PathVariable("id")Long id){
        APIResponse response=cedeService.findById(id);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @PostMapping("")
    @Operation(summary = "Guardar una cede",description = "Registra la información de una cede")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "201",
                    description = "Registro exitoso de cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No se pudo consultar la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            )
    })
    public ResponseEntity<APIResponse> save(@RequestBody Cede payload){
        APIResponse response=cedeService.save(payload);
        return new ResponseEntity<>(response,response.getStatus());
    }

    @PutMapping("")
    @Operation(summary = "Actualiza una cede",description = "Actualiza una cede en especifico")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    description = "Actualiza una cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "No se encontro la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No se pudo consultar la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            )
    })
    public ResponseEntity<APIResponse>update(@RequestBody Cede payload){
        APIResponse response=cedeService.update(payload);
        return new ResponseEntity<>(response,response.getStatus());
    }
    @DeleteMapping("")
    @Operation(summary = "Borra una cede",description = "Borra una cede en especifico")
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    description = "Borra una cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "No se encontro la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "No se pudo consultar la cede",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = APIResponse.class)),
                    }
            )
    })
    public ResponseEntity<APIResponse>remove(@RequestBody Cede payload){
        APIResponse response=cedeService.remove(payload);
        return new ResponseEntity<>(response,response.getStatus());
    }
}
