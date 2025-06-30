package utez.edu.mx.unidad3.modules.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utez.edu.mx.unidad3.utils.APIResponse;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<APIResponse>findAll(){
        APIResponse response = clientService.findAll();
        return new ResponseEntity<>(response,response.getStatus());
    }

}
