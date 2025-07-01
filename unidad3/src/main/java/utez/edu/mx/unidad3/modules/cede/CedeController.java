package utez.edu.mx.unidad3.modules.cede;

import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.unidad3.utils.APIResponse;

@RestController
@RequestMapping("/api/cede")
public class CedeController {
    @Autowired
    private CedeService cedeService;

    @GetMapping("")
    public ResponseEntity<APIResponse> findAll(){
        APIResponse response=cedeService.findAll();
        return new ResponseEntity<>(response,response.getStatus());
    }
    @PostMapping("")
    public ResponseEntity<APIResponse> save(@RequestBody Cede payload){
        APIResponse response=cedeService.save(payload);
        return new ResponseEntity<>(response,response.getStatus());
    }
}
