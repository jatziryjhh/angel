package utez.edu.mx.unidad3.modules.cede;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.unidad3.utils.APIResponse;
import utez.edu.mx.unidad3.utils.ClaveGenerator;

import java.sql.SQLException;
import java.util.List;

@Service
public class CedeService {
    @Autowired
    private CedeRepository cedeRepository;

    @Transactional(readOnly = true)
    public APIResponse findAll(){
        List<Cede>list=cedeRepository.findAll();
        return new APIResponse("Operación exitosa",list,false, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public APIResponse findById(Long id){
        try{
            Cede found = cedeRepository.findById(id).orElse(null);
            if()
        }catch (Exception ex){

        }
    }

    @Transactional(rollbackFor = {SQLException.class, Exception.class})
    public APIResponse save(Cede payload){
        try{
            payload.setClave("pending...");
            Cede saved=cedeRepository.save(payload);

            saved.setClave(ClaveGenerator.generateCedeClave(saved.getId()));
            cedeRepository.save(saved);

            return new APIResponse("Operación exitosas",false,HttpStatus.CREATED);
        }catch (Exception ex){
            return new APIResponse("No se pudo registrar la cede",true,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
