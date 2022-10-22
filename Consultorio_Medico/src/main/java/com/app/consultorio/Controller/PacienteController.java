
package com.app.consultorio.Controller;

import com.app.consultorio.Models.Paciente;
import com.app.consultorio.ServiceInterface.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private IPacienteService service;
    
    @GetMapping("/list")
    public List<Paciente> listar(){
        return service.findAll();
    }
    
}
